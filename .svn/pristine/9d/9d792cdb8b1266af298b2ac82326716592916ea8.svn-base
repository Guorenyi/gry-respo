package cn.mldn.eop.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.mldn.eop.vo.UserPermission;

public class PermissionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)req;
		HttpSession session  = httpRequest.getSession(); 
			//如果是登陆页面进入,则设置用户权限
		if(httpRequest.getRequestURI().endsWith("login.action")){
			String userId = req.getParameter("eid");
			session.setAttribute("eid", userId); 
			//根据用户信息，取得权限字符串
			String permStr = PermissionUtil.getUserPermissionStr(userId);
			
			session.setAttribute("userPermStr", permStr);
		}
		
		chain.doFilter(req, resp);
	} 

}
