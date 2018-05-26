package cn.mldn.util.bean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

import cn.mldn.util.bean.DataConverterUtil;
import cn.mldn.util.web.ParameterUtil;
import cn.mldn.util.web.annotation.FieldAnnotation;
import cn.mldn.util.web.servlet.ServletObjectUtil;

public class WebUtil {

	/**
	 * 根据form表单参数创建VO对象，不支持图片
	 * 
	 * @param request
	 *            request
	 * @param clazz
	 *            需要创建的VO对象类型
	 * @param prefix
	 *            form字段前缀，一般来说是表名，如"member"
	 * @return VO对象
	 * @throws Exception
	 */
	public static <T> T assembleVO(Class clazz) throws Exception {
		Field[] fields = clazz.getDeclaredFields();
		ParameterUtil parameterUtil = ServletObjectUtil.getParameter();
		// 获得所有页面参数
		Set<String> allParamSet = parameterUtil.getParameterNames();
		T vo = null;
		vo = (T) clazz.getDeclaredConstructor().newInstance();
		for (String paramName : allParamSet) {
			try {

				// String[] formFieldValue = entry.getValue();
				// if (!(paramName.startsWith(prefix))) {
				// continue;
				// }
				String obj = parameterUtil.getParameter(paramName);
				// String fieldName = paramName.substring(prefix.length() + 1);

				for (Field field : fields) {
					if (!field.getName().equalsIgnoreCase(paramName)) {
						continue;
					}
					FieldAnnotation colAnno = field.getAnnotation(FieldAnnotation.class);
					String value = null;
					if (!parameterUtil.isUpload(paramName)) {
						// 表明该字段可能是保护多个值
						if (colAnno != null) {
							if ("true".equalsIgnoreCase(colAnno.existMultiValue())) {
								value = Arrays.toString(parameterUtil.getParameterValues(paramName));
							} else {
								value = parameterUtil.getParameter(paramName);
							}
						} else {
							value = parameterUtil.getParameter(paramName);
						}
						if (value == null) {
							continue;
						}
					} else {
						Set<String> fileNameSet = parameterUtil.upload(paramName);
						for (String fileName : fileNameSet) {
							value=fileName+",";
						}
						value=value.substring(0,value.length()-1);
						
					}
					Method method = clazz.getDeclaredMethod(getMethodName(field, "set"), field.getType());
					String filedType = field.getType().getName();
					// 设置字段值
					if(value!=null&&!"".equals(value)) {
						method.invoke(vo,
								DataConverterUtil.convert(filedType.substring(filedType.lastIndexOf(".") + 1), value));
					}
					break;

				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return vo;
	}

	private static String getMethodName(Field field, String type) {
		String fieldName = field.getName();
		StringBuffer methodName = new StringBuffer();
		methodName.append(type).append(fieldName.substring(0, 1).toUpperCase())
				.append(fieldName.substring(1, fieldName.length()));
		return methodName.toString();

	}

	public static String[] getParameterValue(String paramName) {
		ParameterUtil parameterUtil = ServletObjectUtil.getParameter();

		return parameterUtil.getParameterValues(paramName);
	}
}
