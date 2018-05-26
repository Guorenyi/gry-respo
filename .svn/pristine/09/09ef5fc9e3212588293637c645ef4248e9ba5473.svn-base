package cn.mldn.util.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.util.bean.ResourceUtil;
import cn.mldn.util.bean.ScannerPackageUtil;
import cn.mldn.util.web.ActionInvokeUtil;
import cn.mldn.util.web.validate.ValidateUtil;



@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		String scanPackages = config.getInitParameter("scanPackages"); // 定义扫描包
		// 1、根据设置的初始化的包信息进行包中所有类的数据扫描
		ScannerPackageUtil.scannerHandle(super.getClass(), scanPackages);
		System.out.println(ScannerPackageUtil.getActionMapping());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletObjectUtil.setRequest(request);
		ServletObjectUtil.setResponse(response);
		String path = ResourceUtil.getPage("error.page"); // 这是一个公共的错误页面
		// 得到访问路径
		String controllerPath = request.getServletPath().substring(0, request.getServletPath().lastIndexOf(".action"));
		try {// 实例化Action类的对象
			ActionInvokeUtil actionInvoke = new ActionInvokeUtil(controllerPath) ;
			System.out.println("controllerPath=="+controllerPath);
			String validateKey = actionInvoke.getCrMapping().getActionClass().getName() + "." + actionInvoke.getCrMapping().getActionMethod().getName() ;
			String validateRule = ResourceUtil.getValidate(validateKey) ;// 获取规则
			if (validateRule == null) { // 没有规则，没有规则则直接执行
				path = actionInvoke.invoke() ; // 反射调用 
			} else {	// 现在有规则，则必须进行规则的验证处理
				if ((ValidateUtil.validate(validateRule).size() == 0)) {	// 没有错误
					if (ServletObjectUtil.getParameter().isUpload()) {	// 有文件上传
						String mimeRule = ResourceUtil.getValidate(validateKey + ".mime") ; // 获取上传规则
						if (mimeRule != null) {	// 规则存在
							if (ValidateUtil.validateMIME(mimeRule).size() == 0) {	// 成功
								path = actionInvoke.invoke() ; // 反射调用
							} else {
								String pageKey = actionInvoke.getCrMapping().getActionClass().getName() + "." + actionInvoke.getCrMapping().getActionMethod().getName() + ".error" ;
								if (ResourceUtil.getPage(pageKey) != null) {	// 有独立的错误页
									path = ResourceUtil.getPage(pageKey) ;
								}
							}
						} else {	// 获取公共规则
							mimeRule = ResourceUtil.getValidate("mime.types") ; // 获取公共规则
							if (mimeRule != null) {	// 公共规则验证
								if (ValidateUtil.validateCommonMIME(mimeRule).size() == 0) {	// 成功
									path = actionInvoke.invoke() ; // 反射调用
								} else {
									String pageKey = actionInvoke.getCrMapping().getActionClass().getName() + "." + actionInvoke.getCrMapping().getActionMethod().getName() + ".error" ;
									if (ResourceUtil.getPage(pageKey) != null) {	// 有独立的错误页
										path = ResourceUtil.getPage(pageKey) ;
									}
								}
							} else {
								path = actionInvoke.invoke() ; // 反射调用
							}
						}
					} else {
						//if ("void".equals(actionInvoke.getCrMapping().getActionMethod().getReturnType().getName())) {
							path = actionInvoke.invoke() ; // 反射调用
						//}
					}
				} else {	// 验证错误
					String pageKey = actionInvoke.getCrMapping().getActionClass().getName() + "." + actionInvoke.getCrMapping().getActionMethod().getName() + ".error" ;
					if (ResourceUtil.getPage(pageKey) != null) {	// 有独立的错误页
						path = ResourceUtil.getPage(pageKey) ;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletObjectUtil.clear(); // 清除线程中保存的内容
		if (path != null) {
			request.getRequestDispatcher(path).forward(request, response); // 跳转
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}

