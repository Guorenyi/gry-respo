package cn.mldn.eop.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.mldn.eop.vo.UserPermission;

public class PermissionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest)req;
		HttpSession session  = httpRequest.getSession();
		String userId = "";
		//首先从session 中取用户信息
		if(session.getAttribute("userId")!=null) {
			userId = session.getAttribute("userId").toString();
		}else {
			//如果session 中没有则在request中取，并且把userId加入session
			userId = req.getParameter("userId");
			session.setAttribute("userId", userId);
		}
		//根据用户信息，取得权限
		List<UserPermission> userPermList = PermissionUtil.getUserPermission(userId);
		
		session.setAttribute("userPermList", userPermList);
		
	//	req.getRequestDispatcher().forward(request, response); // 跳转
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	
}
