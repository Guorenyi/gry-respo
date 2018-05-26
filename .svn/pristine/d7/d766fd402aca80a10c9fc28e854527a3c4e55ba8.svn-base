package cn.mldn.util.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.util.web.ParameterUtil;

public class ServletObjectUtil {
	public static final ThreadLocal<HttpServletRequest> REQUEST_THREADLOCAL = new ThreadLocal<HttpServletRequest>() ; 
	public static final ThreadLocal<HttpServletResponse> RESPONSE_THREADLOCAL = new ThreadLocal<HttpServletResponse>() ;
	public static final ThreadLocal<ParameterUtil> PARAMETER_THREADLOCAL = new ThreadLocal<ParameterUtil>() ;
	public static void setRequest(HttpServletRequest request) {
		REQUEST_THREADLOCAL.set(request);
	}
	public static void setResponse(HttpServletResponse response) {
		RESPONSE_THREADLOCAL.set(response);
	}
	
	public static ParameterUtil getParameter() {
		ParameterUtil pu = PARAMETER_THREADLOCAL.get() ;
		if (pu == null) {	// 没有获得
			pu = new ParameterUtil(REQUEST_THREADLOCAL.get(),"/","/upload/") ;
			PARAMETER_THREADLOCAL.set(pu) ;
		}
		return pu ; 
	}
	
	public static HttpServletRequest getRequest() {
		return REQUEST_THREADLOCAL.get() ;
	}
	public static HttpServletResponse getResponse() {
		return RESPONSE_THREADLOCAL.get() ;
	}
	public static void clear() {
		REQUEST_THREADLOCAL.remove(); 
		RESPONSE_THREADLOCAL.remove(); 
		PARAMETER_THREADLOCAL.remove(); 
	}
}
