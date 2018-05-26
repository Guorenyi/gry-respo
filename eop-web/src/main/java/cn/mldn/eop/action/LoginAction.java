package cn.mldn.eop.action;

import java.util.Date;

import cn.mldn.eop.service.IEmpService;
import cn.mldn.eop.service.LoginService;
import cn.mldn.eop.vo.Emp;
import cn.mldn.util.bean.WebUtil;
import cn.mldn.util.encrypt.EncryptUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;
@Controller
@RequestMapping("/*")
public class LoginAction extends AbstractAction{
	@Autowired
	IEmpService empService;
	@Autowired
	LoginService loginService;
	/**
	 * 系统登录逻辑
	 * 1.检查用户是否存在
	 * 2.检查密码是否正确
	 * 3.登陆成功后记录登陆时间，并把用户信息保存进session
	 * @return 如果通过验证，则跳转进首页，否则跳回登陆页面
	 * @throws Exception
	 */
	@RequestMapping("login")
	public ModelAndView login() throws Exception{
		
		String eid = WebUtil.getParameterValue("eid")[0];
		
		Emp emp = empService.getById(eid);
		if(emp==null) {
			ModelAndView mav = new ModelAndView("/");
			mav.add("msg","登陆失败，用户不存在或账号不可用！");
			return mav;
		}
		String password = WebUtil.getParameterValue("password")[0];
		//登陆成功
		if(EncryptUtil.encrypt(password).equals(emp.getPassword())) {
			ModelAndView mav = new ModelAndView("pages/back/");
			// 更新用户最新登陆时间
			//mav.add("lastLoginDate", emp.getLastlogdate());
			loginService.updateUserLoginDate(eid);
			//mav.add("lastLoginDate", new Date()); 
			ServletObjectUtil.getRequest().getSession().setAttribute("lastLoginDate", new Date());
			ServletObjectUtil.getRequest().getSession().setAttribute("currentEmp", emp);
			return mav;
		}else {
			ModelAndView mav = new ModelAndView("/");
			mav.add("msg","登陆失败，密码错误！");
			return mav;
		}
	}
	/**
	 * 注销登录，清空session 权限内容
	 * @return 返回登录页面
	 * @throws Exception
	 */
	@RequestMapping("logout")
	public ModelAndView logout() throws Exception{
		//清除session属性
		ServletObjectUtil.getRequest().getSession().removeAttribute("eid");
		ServletObjectUtil.getRequest().getSession().removeAttribute("userPermStr");
		ModelAndView mav = new ModelAndView("/");
		mav.add("msg","系统登出成功");
		return mav;
	}
	/**
	 * 验证码检查
	 * @throws Exception
	 */
	@RequestMapping("loginCodeCheck")
	public void loginCodeCheck() throws Exception{
		String code = WebUtil.getParameterValue("code")[0];
		if(code.equalsIgnoreCase(ServletObjectUtil.getRequest().getSession().getAttribute("rand").toString())) {
			super.print(true);
		}else {
			super.print(false);
		}
	}
	@RequestMapping("change_password")
	public ModelAndView changePassword() throws Exception{
		String curUserId = ServletObjectUtil.getRequest().getSession().getAttribute("eid").toString();
		Emp emp = empService.getById(curUserId);
		String newPwd = WebUtil.getParameterValue("newpwd")[0];
		String oldPwd = WebUtil.getParameterValue("pwd")[0];
		
		ModelAndView mav=null;
		//检查输入的原密码是否正确
		if(!EncryptUtil.encrypt(oldPwd).equals(emp.getPassword())) {
			mav = new ModelAndView("pages/plugins/back/password_update.jsp");
			mav.add("msg", "修改失败，原密码错误！");
			return mav;
		}
		boolean result = loginService.updateUserPwd(curUserId,newPwd);
		
		if(!result) {
			//如果更新失败，返回原页面
			 mav = new ModelAndView("pages/plugins/back/password_update.jsp");
		}else {
			
			//如果更改密码成功，清除session属性，重新登陆
			ServletObjectUtil.getRequest().getSession().removeAttribute("eid");
			ServletObjectUtil.getRequest().getSession().removeAttribute("userPermStr");
			 mav = new ModelAndView("/");
		}
		return mav;
	}
}
