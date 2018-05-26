package cn.mldn.util.bean;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class ResourceUtil {
	private static final String VALIDATIONS_BASENAME = "cn.mldn.eop.resource.Validations" ;
	private static final String MESSAGES_BASENAME = "cn.mldn.eop.resource.Messages" ;
	private static final String PAGES_BASENAME = "cn.mldn.eop.resource.Pages" ;
	private static ResourceBundle validationsResourceBundle ;
	private static ResourceBundle messagesResourceBundle ;
	private static ResourceBundle pagesResourceBundle ;
	static {
		try {
			validationsResourceBundle = ResourceBundle.getBundle(VALIDATIONS_BASENAME) ;
		} catch (Exception e) {}
		try {
			messagesResourceBundle = ResourceBundle.getBundle(MESSAGES_BASENAME) ;
		} catch (Exception e) {}
		try {
			pagesResourceBundle = ResourceBundle.getBundle(PAGES_BASENAME) ;
		} catch (Exception e) {}
	}
	public static String getPage(String key) {
		try {
			return pagesResourceBundle.getString(key) ;
		} catch (Exception e) {
			return null ;
		}
	}
	/**
	 * 读取文字提示信息的资源
	 * @param key KEY
	 * @return 内容
	 */
	public static String getMessage(String key,String ... args) {
		try {
			return MessageFormat.format(messagesResourceBundle.getString(key), args);
		} catch (Exception e) { 
			return null ;
		}
	}
	/**
	 * 得到一个指定的验证规则
	 * @param key 资源中的key
	 * @return 如果存在验证规则则使用，如果不存在返回null
	 */
	public static String getValidate(String key) {
		try {
			return validationsResourceBundle.getString(key) ;
		} catch (Exception e) {
			return null ;
		}
	}
}
