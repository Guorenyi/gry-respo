package cn.mldn.util.factory;

import cn.mldn.util.service.proxy.ServiceProxy;

/**
 * 实现一个工厂类定义，该工厂类可以返回DAO或业务接口实例
 * @author mldn 
 */
public class Factory {
	/**
	 * 获取Service接口实例化对象
	 * @param key 要获取资源对象key
	 * @param clazz 对象的接口类型
	 * @return 业务层接口对象，如果不存在返回null
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getServiceInstance(Object target) {
		try {
			return (T) new ServiceProxy(target).bind();
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		} 
	}
	
	/**
	 * 获取DAO接口实例化对象
	 * @param key 要获取对象的资源文件key
	 * @param clazz 对象的接口类型，用于检测与转型使用
	 * @return 如果配置对象存在则返回数据，如果不存在返回null
	 */
	public static <T> T getDAOInstance(Class<T> clazz) {
		try {
			return (T) clazz.getDeclaredConstructor().newInstance() ;
		} catch (Exception e) {
			return null ;
		}
	}
}
