package cn.mldn.util.web; 

import javax.servlet.http.HttpServletRequest;

import cn.mldn.util.bean.ResourceUtil;
import cn.mldn.util.web.servlet.ServletObjectUtil;

public class SplitPageUtil {
	private HttpServletRequest request ; // 接收Request对象引用
	public SplitPageUtil(String columnData,String urlKey) {
		this.request = ServletObjectUtil.getRequest() ;
		this.request.setAttribute("columnData", columnData);
		this.request.setAttribute("url", ResourceUtil.getPage(urlKey).substring(1));//去掉第一个斜杠以便在分页中使用相对路径
	}
	public long getCurrentPage() { 
		long currentPage = 1 ; 		// 当前所在页
		try {
			currentPage = Long.parseLong(this.request.getParameter("cp")) ;
		} catch (Exception e) {}	// 该异常没有必要输出
		return currentPage ; 
	} 
	public int getLineSize() {
		int lineSize = 10 ;  // 每页显示的数据行
		try {
			lineSize = Integer.parseInt(request.getParameter("ls")) ;
		} catch (Exception e) {}	// 该异常没有必要输出
		return lineSize ;
	}
	public String getColumn() {
		String column = request.getParameter("col") ; // 接收传递的col参数
		if (column == null) {
			column = "" ;
		}
		return column ;
	}
	public String getKeyword() {
		String keyWord = request.getParameter("kw") ; // 接收查询关键字
		if (keyWord == null) {
			keyWord = "" ; // 为空字符串
		}
		return keyWord ;
	}
}
