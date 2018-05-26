package cn.mldn.util.bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.Repository;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.annotation.Service;

/**
 * 负责分析所有的程序类与注解
 */
public class ConfigAnnotationUtil {
	private Map<String, ControllerRequestMapping> controllerMapping = new HashMap<String, ControllerRequestMapping>();
	// 获取业务接口与子类的对象，key = 接口名字、value = 子类的类型
	private Map<Class<?>, Class<?>> serviceMapping = new HashMap<Class<?>, Class<?>>();
	// 获取数据接口与子类对象、key = 接口名称、value = 子类类型
	private Map<Class<?>, Class<?>> daoMapping = new HashMap<Class<?>, Class<?>>(); 
	private Class<?> clazz; // 要进行分析的类

	public ConfigAnnotationUtil(Class<?> clazz) {
		this.clazz = clazz;
		this.classHandle();
	}
	public Map<String, ControllerRequestMapping> getControllerMapping() {
		return controllerMapping;
	}
	public Map<Class<?>, Class<?>> getServiceMapping() {
		return serviceMapping;
	}
	public Map<Class<?>, Class<?>> getDaoMapping() {
		return daoMapping;
	}
	/**
	 * 进行每一个方法的映射处理操作
	 */
	private void methodHandle(String parentUrl) {
		Method methods[] = this.clazz.getDeclaredMethods(); // 获取方法
		for (Method method : methods) {
			if (method.isAnnotationPresent(RequestMapping.class)) { // 是否具有指定的注解
				RequestMapping mapping = method.getAnnotation(RequestMapping.class);
				String path = (parentUrl == null ? "" : parentUrl.substring(0, parentUrl.lastIndexOf("*")))
						+ mapping.value();
				this.controllerMapping.put(path, new ControllerRequestMapping(this.clazz, method));
			}
		}
	}

	private void classHandle() {
		Annotation[] annotations = this.clazz.getAnnotations(); // 获取全部注解
		// System.out.println(Arrays.toString(annotations));
		for (Annotation anto : annotations) { // 取出每一个注解
			if (anto.annotationType().equals(Controller.class)) { // 现在配置的是控制层注解
				String parentUrl = null;
				try {// 当找到了控制器之后就需要找到控制器之中的对应的映射访问路径
					RequestMapping requestMapping = this.clazz.getAnnotation(RequestMapping.class); // 获得指定的Annotation
					parentUrl = requestMapping.value(); // 获取父路径
				} catch (Exception e) {
				}
				this.methodHandle(parentUrl); // 进行方法的获取与映射信息的获取
			} else if (anto.annotationType().equals(Repository.class)) {
				Class<?>[] interfaces = this.clazz.getInterfaces(); // 获得所有的接口
				for (int x = 0; x < interfaces.length; x++) {
					this.daoMapping.put(interfaces[x], this.clazz);
				}
			} else if (anto.annotationType().equals(Service.class)) {
				Class<?>[] interfaces = this.clazz.getInterfaces(); // 获得所有的接口
				for (int x = 0; x < interfaces.length; x++) {
					this.serviceMapping.put(interfaces[x], this.clazz);
				}
			}
		}
	}
}
