package cn.mldn.util.bean;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现指定包之中的类的扫描处理
 * @author mldn
 */
public class ScannerPackageUtil {
	private ScannerPackageUtil() {}
	private static final Map<String,ControllerRequestMapping> ACTION_MAP = new HashMap<String,ControllerRequestMapping>() ;
	// key = Service接口类型、value = 子类类型
	private static final Map<Class<?>,Class<?>> SERVICE_MAP = new HashMap<Class<?>,Class<?>>() ;
	// key = DAO接口类型、value = 子类类型
	private static final Map<Class<?>,Class<?>> DAO_MAP = new HashMap<Class<?>,Class<?>>() ;
	/**
	 * 直接扫描所有给定包中的类，如果没有设置包，则直接扫描当前包下的内容
	 * @param clazz 确认类路径的Class
	 * @param packages 所有的包的信息，中间使用“;”进行分割
	 * @return 所有该包下的类
	 */
	public static void scannerHandle(Class<?> clazz, String packages) {
		String resultPackages [] = null ;
		if (packages == null || "".equals(packages)) {	// 没有设置扫描包
			return  ; // 直接结束
		} 
		resultPackages = packages.split(";") ; // 按照分号拆分
		String baseDir = clazz.getResource("/").getPath() ; // 获得基础目录
		//windows系统 
		if(File.separator.equals("\\")) {
			baseDir = baseDir.substring(1).replace("/", "\\") ; // 对baseDir进行处理
		}
		//baseDir = baseDir.substring(1);
		for (int x = 0 ; x < resultPackages.length ; x ++) {
			File file = new File(baseDir,resultPackages[x].replace(".", File.separator)) ;
			classList(file,baseDir) ; // 进行目录操作列表
		}
	}
	public static Map<String,ControllerRequestMapping> getActionMapping() {
		return ACTION_MAP ;
	} 
	public static Map<Class<?>, Class<?>> getServiceMap() {
		return SERVICE_MAP;
	}
	public static Map<Class<?>, Class<?>> getDaoMap() {
		return DAO_MAP;
	}
	/**
	 * 进行指定目录的列出操作
	 * @param file 列出的目录名称
	 * @param baseDir 基础目录
	 */
	private static void classList(File file, String baseDir) {
		if (file.isDirectory()) {// 给定的是一个目录
			File results [] = file.listFiles() ;
			if (results != null) {
				for (File item : results) {
					classList(item,baseDir) ;
				}
			}
		} else {
			if (file.getName().endsWith(".class")) {	// 后缀为*.class
				String className = "" ;
				if (File.separator.equals("\\")) {
					className = file.getAbsolutePath().replace(baseDir, "").replace("\\", ".").replace(".class", "") ;
				} else {
					className = file.getAbsolutePath().replace(baseDir, "").replace("/", ".").replace(".class", "") ;
				}
				try {		// 从给定的类之中扫描出对应的控制层处理方法
					ConfigAnnotationUtil cau = new ConfigAnnotationUtil(Class.forName(className)) ;
					ACTION_MAP.putAll(cau.getControllerMapping());
					SERVICE_MAP.putAll(cau.getServiceMapping());
					DAO_MAP.putAll(cau.getDaoMapping()) ;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
