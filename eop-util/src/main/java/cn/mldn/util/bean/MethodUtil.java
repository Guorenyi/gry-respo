package cn.mldn.util.bean;

import java.lang.reflect.Method;

/**
 * 该类的主要作用是获取指定方法对应的Method对象，此时并不知道参数类型
 * @author mldn
 */
public class MethodUtil {
	/**
	 * 获取指定方法名称的Method对象
	 * @param cls 要操作的类
	 * @param methodName 方法名称
	 * @return 如果该方法存在则返回对象，如果不存在返回null
	 */
	public static Method getMethod(Class<?> cls,String methodName) {
		Method methods [] = cls.getDeclaredMethods() ; 	// 获取全部方法
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {	// 找到了指定名称的方法
				return method ;
			}
		}
		return null ; 
	}
}
