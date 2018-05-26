package cn.mldn.util.bean;

import java.lang.reflect.Field;

import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.annotation.Autowired;

/**
 * 实现资源的注入处理，本次的注入只针对于控制层和业务层的注入操作
 * @author mldn 
 */
public class InjectResourceUtil {
	private InjectResourceUtil() {}
	/** 
	 * 获取指定对象中的资源内容 
	 * @param target 要反射处理的对象
	 */
	public static void resouceHandle(Object target) {
		Field fileds[] = target.getClass().getDeclaredFields() ;  // 获取全部的属性
		for (Field field : fileds) {
			if (field.isAnnotationPresent(Autowired.class)) {	// 需要做注入处理
				try {
					field.setAccessible(true);
					Object serviceObject = ScannerPackageUtil.getServiceMap().get(field.getType())
							.getDeclaredConstructor().newInstance() ; // 一个Service对象
					// 在Service对象之中需要注入DAO接口对象，获取全部的属性，基本上业务层中的属性只有DAO
					Field daoFields [] = ScannerPackageUtil.getServiceMap().get(field.getType()).getDeclaredFields() ;
					for (Field daoField : daoFields) {	// 业务层中的属性
						if (daoField.isAnnotationPresent(Autowired.class)) {	// 有注入需求
							// 通过工厂类获取一个DAO的实例化对象
							Object daoObject = Factory.getDAOInstance(ScannerPackageUtil.getDaoMap().get(daoField.getType())) ;
							daoField.setAccessible(true);
							daoField.set(serviceObject, daoObject); // 把DAO对象注入到业务子类之中
						}
					} 
					field.set(target, Factory.getServiceInstance(serviceObject));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
