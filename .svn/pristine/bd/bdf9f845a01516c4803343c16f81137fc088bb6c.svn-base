package cn.mldn.util.web;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import cn.mldn.util.bean.ControllerRequestMapping;
import cn.mldn.util.bean.DataConverterUtil;
import cn.mldn.util.bean.InjectResourceUtil;
import cn.mldn.util.bean.ScannerPackageUtil;
import cn.mldn.util.bean.StringUtils;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;
import javassist.ClassClassPath;
import javassist.ClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

/**
 * 定义一个专门执行Action程序类的反射调用处理，该操作可以实现参数的配置
 * @author mldn
 */
public class ActionInvokeUtil {
	private ControllerRequestMapping crMapping ; // 进行控制层类信息保存
	/**
	 * 传递控制层的路径
	 * @param controllerPath 控制层路径
	 */
	public ActionInvokeUtil(String controllerPath) {
		this.crMapping = ScannerPackageUtil.getActionMapping().get(controllerPath); // 根据路径获取Action类
	}
	public ControllerRequestMapping getCrMapping() {
		return crMapping;
	}
	/**
	 * 根据指定的参数名称接收参数内容
	 * @param paramName 参数名称
	 * @return 参数内容
	 */
	private Object handleParameterValue(String type,String paramName) throws Exception {
		return DataConverterUtil.convert(type, ServletObjectUtil.getParameter().getParameter(paramName)) ;
	}
	/**
	 * 进行指定VO类型的操作处理
	 * @param voClazz 要操作的类型，需要反射实例化
	 * @return VO类对象
	 */
	private Object handleParameterVO(Class<?> voClazz) throws Exception {	
		Object target = voClazz.getDeclaredConstructor().newInstance() ; // 反射实例化对象
		Field targetFields [] = voClazz.getDeclaredFields() ; // 获取全部成员
		for (int x = 0 ; x < targetFields.length ; x ++) {
			Method setterMethod = voClazz.getDeclaredMethod("set" + StringUtils.initcap(targetFields[x].getName()), targetFields[x].getType()) ;
			setterMethod.invoke(target, DataConverterUtil.convert(targetFields[x].getType().getSimpleName(), ServletObjectUtil.getParameter().getParameter(targetFields[x].getName()))) ;
		}
		return target ; 
	}
	/**
	 * 获取方法中参数的名称，只有存在了参数名称后才可以使用参数接收进行处理
	 * @return 所有的参数的数据
	 */
	private String [] getActionParameterNames() throws Exception {
		Class<?> params [] = this.crMapping.getActionMethod().getParameterTypes() ; // 获取参数的类型
		String [] names = new String [params.length] ; // 根据参数的 个数创建数组
		// 使用javassist工具的核心意义是在于要获取参数的名字
		ClassPool classPool = ClassPool.getDefault() ;
		ClassPath classPath = new ClassClassPath(this.crMapping.getActionClass()) ;	// 将传递进来的Action的类型设置到ClassPath之中
		classPool.insertClassPath(classPath) ;	// 修改了javassist的CLASSPATH
		// 此时相当于将要读取的类的二进制字节码文件的操作交给了一个CtClass对象
		CtClass ctClass = classPool.get(this.crMapping.getActionClass().getName()) ; // 通过指定的类名称来获取对应的类信息
		// 得到一个指定方法对应的二进制数据（通过这个对象可以分析出方法的组成）
		CtMethod ctMethod = ctClass.getDeclaredMethod(this.crMapping.getActionMethod().getName()) ; // 通过字节码的分析工具获取指定的方法部分的字节数据
		MethodInfo methodInfo = ctMethod.getMethodInfo() ; // 正式读取二进制数据信息
		// 按照自己定义的形式获取指定方法对应的所有的核心属性的信息
		CodeAttribute codeAttribute = methodInfo.getCodeAttribute() ; // 得到源代码之中相应的属性
		// 此时要获取本地局部变量的属性信息
		LocalVariableAttribute attributeInfo = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag) ; // 获得本地操作变量的名字
		// 对于这种参数名称的获取一定要判断其是static方法还是非static方法
		int pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1 ;
		for (int x = 0; x < params.length; x++) {
			names [x] = attributeInfo.variableName(x + pos) ;
		}
		return names ;
	}
	/**
	 * 将参数转换为数组
	 * @param type 参数类型
	 * @param paramName 参数名称
	 * @return 数组内容
	 */
	private Object handleParameterArray(String type,String paramName) {
		return DataConverterUtil.convert(type, ServletObjectUtil.getParameter().getParameterValues(paramName)) ;
	}
	/**
	 * 判断要操作的参数类型是否为基本数据类型
	 * @param type 参数类型
	 * @return 基础数据类型返回true
	 */
	private boolean isBasic(String type) {
		return "int".equals(type) || "Integer".equalsIgnoreCase(type) || "long".equalsIgnoreCase(type)
				|| "double".equalsIgnoreCase(type) || "boolean".equalsIgnoreCase(type) || "String".equals(type)
				|| "Date".equalsIgnoreCase(type);
	}
	/**
	 * 判断类型是否为数组
	 * @param type 类型
	 * @return 如果是数组返回true
	 */
	private boolean isArray(String type) {
		return "int[]".equals(type) || "Integer[]".equalsIgnoreCase(type) || "long[]".equalsIgnoreCase(type)
				|| "String[]".equals(type);
	}
	/**
	 * 实现反射调用与参数的自动设置
	 * @return 跳转的执行路径
	 * @throws Exception 异常抛出
	 */
	public String invoke() throws Exception {	// 该操作直接决定了最终的跳转路径
		String names [] = this.getActionParameterNames() ; // 获取参数的名字，就可以根据名称获取参数内容
		Class<?> types [] = this.crMapping.getActionMethod().getParameterTypes() ;
		Object values [] = new Object [names.length] ; // 设置参数的数组
		for (int x = 0; x < names.length; x++) { // 传递参数名称
			try {
				if (this.isBasic(types[x].getSimpleName())) { // 如果是基本类型
					values[x] = this.handleParameterValue(types[x].getSimpleName(), names[x]); // 进行参数的保存

				} else if (this.isArray(types[x].getSimpleName())) { // 按照数组处理
					values[x] = this.handleParameterArray(types[x].getSimpleName(), names[x]);
				} else {
					values[x] = this.handleParameterVO(types[x]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Object actionObject = this.crMapping.getActionClass().getDeclaredConstructor().newInstance(); // 获取Action类的对象
		// 实例化控制层类对象，同时这个对象里面有可能有需要进行注入的业务对象
		InjectResourceUtil.resouceHandle(actionObject);// 需要进行注入的操作处理
		// 此时的调用需要进行参数的获取
		Object backObject = this.crMapping.getActionMethod().invoke(actionObject, values); 
		if (backObject != null) {
			if (backObject instanceof String) { // 返回的是字符串
				return backObject.toString();
			} else if (backObject instanceof ModelAndView) {
				return ((ModelAndView) backObject).getPath();
			}
		}
		return null;
	}
	
}
