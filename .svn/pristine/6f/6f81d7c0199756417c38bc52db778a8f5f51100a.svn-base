package cn.mldn.util.web.validate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import cn.mldn.util.bean.ResourceUtil;
import cn.mldn.util.web.annotation.ValidateRuleAnnotation;
import cn.mldn.util.web.servlet.ServletObjectUtil;

public class ValidateUtil {
	private ValidateUtil() {
	}

	public static Map<String, String> validateCommonMIME(String mimeRule) {
		Set<String> ruleSet = new HashSet<String>();
		Map<String, String> errors = new HashMap<String, String>();
		ruleSet.addAll(Arrays.asList(mimeRule.split(";"))); // 进行数据保存，所有可以使用规则
		Set<String> uploadMime = ServletObjectUtil.getParameter().getMimes();// 获取所有的类型
		for (String um : uploadMime) {
			if (!ruleSet.contains(um)) { // 不在给定的类型范围内
				errors.put("file", ResourceUtil.getMessage("mime.validate.error.msg"));
			}
		}
		if (errors.size() > 0) { // 有错误了
			ServletObjectUtil.getRequest().setAttribute("errors", errors);
		}
		return errors;
	}

	public static Map<String, String> validateMIME(String mimeRule) {
		Map<String, String> errors = new HashMap<String, String>();
		String rules[] = mimeRule.split("\\|"); // 拆分
		for (int x = 0; x < rules.length; x++) {
			String rule[] = rules[x].split(":");
			Set<String> ruleSet = new HashSet<String>();
			ruleSet.addAll(Arrays.asList(rule[1].split(";"))); // 进行数据保存，所有可以使用规则
			Set<String> uploadMime = ServletObjectUtil.getParameter().getMimes(rule[0]);// 获取所有的类型
			for (String um : uploadMime) {
				if (!ruleSet.contains(um)) { // 不在给定的类型范围内
					errors.put(rule[0], ResourceUtil.getMessage("mime.validate.error.msg"));
				}
			}
		}
		if (errors.size() > 0) { // 有错误了
			ServletObjectUtil.getRequest().setAttribute("errors", errors);
		}
		return errors;
	}

	/**
	 * 进行规则验证处理操作
	 * 
	 * @param validateRule
	 *            验证规则
	 * @return 如果有错误则Map集合保存错误信息，如果没有错误Map集合长度为0
	 */
	public static Map<String, String> validate(String validateRule) {
		// key = 验证的参数名称、value = 错误信息（Messages.properties）
		// 验证表达式格式：name:type=string$mandantory=true|price:tyep=double&between=(1,5)|tag:type=string|iid:type=long
		Map<String, String> errors = new HashMap<String, String>();
		String rules[] = validateRule.split("\\|"); // 拆分
		String fieldName = "";
		for (int x = 0; x < rules.length; x++) {
			String rule[] = rules[x].split(":");
			fieldName = rule[0];
			String checkRules[] = rule[1].split("&");
			for (String checkRule : checkRules) {
				String ruleId = checkRule.split("=")[0];
				String ruleDetail = checkRule.split("=")[1];
				switch (ruleId) {
				case "mandatory": {//检查是否必填
					if ("true".equalsIgnoreCase(ruleDetail)) {
						if (!existVaule(fieldName)) {
							errors.put(fieldName, ResourceUtil.getMessage("mandatory.validate.error.msg"));
							
						}
					}
					break;
				}
				case "between": {//检查值的范围
					long minValue = Long.parseLong(ruleDetail.split(",")[0].substring(1));
					long maxValue = Long.parseLong(ruleDetail.split(",")[1].replace(")", ""));
					if (!betweenVaule(fieldName, minValue, maxValue)) {
						errors.put(fieldName, ResourceUtil.getMessage("between.validate.error.msg"));
						
					}
					break;
				}
				case "contain": {//检查值是否在枚举值中
					String[] values = ruleDetail.split(",");
					if(!containVaule(fieldName,values)) {
						errors.put(fieldName, ResourceUtil.getMessage("contain.validate.error.msg"));
						
					}
					break;
				}
				case "type": {
					switch (ruleDetail) {
					case "int": {
						if (!isInt(rule[0])) { // 没有通过验证
							errors.put(rule[0], ResourceUtil.getMessage("int.validate.error.msg"));
						}
						break;
					}
					case "boolean": {
						if (!isBoolean(rule[0])) { // 没有通过验证
							errors.put(rule[0], ResourceUtil.getMessage("int.validate.error.msg"));
						}
						break;
					}
					case "long": {
						if (!isLong(rule[0])) { // 没有通过验证
							errors.put(rule[0], ResourceUtil.getMessage("long.validate.error.msg"));
						}
						break;
					}

					case "double": {
						if (!isDouble(rule[0])) { // 没有通过验证
							errors.put(rule[0], ResourceUtil.getMessage("double.validate.error.msg"));
						}
						break;
					}
					case "date": {
						if (!isDate(rule[0])) { // 没有通过验证
							errors.put(rule[0], ResourceUtil.getMessage("date.validate.error.msg"));
						}
						break;
					}
					case "datetime": {
						if (!isDatetime(rule[0])) { // 没有通过验证
							errors.put(rule[0], ResourceUtil.getMessage("datetime.validate.error.msg"));
						}
						break;
					}
					case "rand": {
						if (!isRand(rule[0])) { // 没有通过验证
							errors.put(rule[0], ResourceUtil.getMessage("rand.validate.error.msg"));
						}
						break;
					}
					case "int[]": {
						if (!isIntArray(rule[0])) { // 没有通过验证
							errors.put(rule[0], ResourceUtil.getMessage("int[].validate.error.msg"));
						}
						break;
					}
					case "long[]": {
						if (!isLongArray(rule[0])) { // 没有通过验证
							errors.put(rule[0], ResourceUtil.getMessage("long[].validate.error.msg"));
						}
						break;
					}
					case "string[]": {
						if (!isStringArray(rule[0])) { // 没有通过验证
							errors.put(rule[0], ResourceUtil.getMessage("string[].validate.error.msg"));
						}
						break;
					}

					}
				}

				}
			}
		}
		if (errors.size() > 0) { // 有错误了
			ServletObjectUtil.getRequest().setAttribute("errors", errors);
		}
		return errors;
	}

	/**
	 * 验证码数据
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 整数返回true
	 */
	public static boolean isRand(String paramName) {
		if (isString(paramName)) { // 通过了字符串不为空的验证
			String paramValue = ServletObjectUtil.getParameter().getParameter(paramName);
			String rand = (String) ServletObjectUtil.getRequest().getSession().getAttribute("rand");
			if (rand == null || "".equals(rand)) {
				return false;
			}
			return rand.equalsIgnoreCase(paramValue);
		}
		return false;
	}

	/**
	 * 验证是否为空以及是否为整数
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 整数返回true
	 */
	public static boolean isDatetime(String paramName) {

		String paramValue = ServletObjectUtil.getParameter().getParameter(paramName);
		if (paramValue != null) {
			return paramValue.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
		}
		return true;

	}

	/**
	 * 验证是否为空以及是否为整数
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 整数返回true
	 */
	public static boolean isBoolean(String paramName) {

		String paramValue = ServletObjectUtil.getParameter().getParameter(paramName);
		return "true".equals(paramValue) || "false".equals(paramValue);

	}

	public static boolean existVaule(String paramName) {
		String paramValue = ServletObjectUtil.getParameter().getParameter(paramName);
		return paramValue != null && !"".equals(paramValue);
	}

	public static boolean betweenVaule(String paramName, long minValue, long maxValue) {
		String paramValue = ServletObjectUtil.getParameter().getParameter(paramName);
		if (paramValue != null && !"".equals(paramValue)) {
			if (isDouble(paramName)) {
				return Double.parseDouble(paramValue) >= minValue && Double.parseDouble(paramValue) <= maxValue;
			}
		}
		return true;
	}
	public static boolean containVaule(String paramName, String[] values) {
		String paramValue = ServletObjectUtil.getParameter().getParameter(paramName);
		boolean flag = false;
		if (paramValue != null && !"".equals(paramValue)) {
			for (String value : values) {
				if(paramValue.equals(value)) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * 验证是否为空以及是否为整数
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 整数返回true
	 */
	public static boolean isDate(String paramName) {

		String paramValue = ServletObjectUtil.getParameter().getParameter(paramName);
		if (paramValue != null) {
			return paramValue.matches("\\d{4}-\\d{2}-\\d{2}");
		}
		return true;

	}

	/**
	 * 验证是否为空以及是否为整数
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 整数返回true
	 */
	public static boolean isDouble(String paramName) {

		String paramValue = ServletObjectUtil.getParameter().getParameter(paramName);
		if (paramValue != null && !"".equals(paramValue)) {
			return paramValue.matches("\\d+(\\.\\d+)?");
		}
		return true;

	}

	/**
	 * 验证是否为空以及是否为整数
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 整数返回true
	 */
	public static boolean isLongArray(String paramName) {
		String paramValue[] = ServletObjectUtil.getParameter().getParameterValues(paramName);
		if (paramValue == null) {
			return false;
		}
		for (int x = 0; x < paramValue.length; x++) {
			if (!paramValue[x].matches("\\d+")) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 验证是否为空以及是否为整数
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 整数返回true
	 */
	public static boolean isLong(String paramName) {

		String paramValue = ServletObjectUtil.getParameter().getParameter(paramName);
		if (paramValue != null) {
			return paramValue.matches("\\d+");
		}
		return true;
	}

	/**
	 * 验证是否为空以及是否为整数
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 整数返回true
	 */
	public static boolean isIntArray(String paramName) {
		String paramValue[] = ServletObjectUtil.getParameter().getParameterValues(paramName);
		if (paramValue == null) {
			return false;
		}
		for (int x = 0; x < paramValue.length; x++) {
			if (!paramValue[x].matches("\\d+")) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 验证是否为空以及是否为整数
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 整数返回true
	 */
	public static boolean isInt(String paramName) {

		String paramValue = ServletObjectUtil.getParameter().getParameter(paramName);
		if (paramValue != null) {
			return paramValue.matches("\\d+");
		}
		return true;

	}

	/**
	 * 进行字符串的数据验证
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 不为空返回true
	 */
	public static boolean isStringArray(String paramName) {
		String paramValue[] = ServletObjectUtil.getParameter().getParameterValues(paramName);
		if (paramValue == null) {
			return false;
		}
		for (int x = 0; x < paramValue.length; x++) {
			if (paramValue[x] == null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 进行字符串的数据验证
	 * 
	 * @param paramName
	 *            参数名称
	 * @return 不为空返回true
	 */
	public static boolean isString(String paramName) {
		String paramValue = ServletObjectUtil.getParameter().getParameter(paramName);
		if (paramValue == null || "".equals(paramValue)) {
			return false;
		}
		return true;
	}
	@Deprecated
	public static Map<String, String> validateVO(Object vo) {
		// 定义错误Map，第一个参数表示字段名，第二个表示错误类型
		Map<String, String> errorMap = new HashMap<String, String>();
		Field[] fields = vo.getClass().getDeclaredFields();
		for (Field field : fields) {
			ValidateRuleAnnotation vAnnotation = field.getAnnotation(ValidateRuleAnnotation.class);
			if (vAnnotation == null) {
				continue;
			}

			String filedName = field.getName();
			try {
				Method getMethod = vo.getClass().getDeclaredMethod(getMethodName(field, "get"), null);
				Object value = getMethod.invoke(vo, null);
				// 检查是否不为空
				if (vAnnotation.mandatory() && value == null) {
					errorMap.put(field.getName(), "该字段值不能为空");
					continue;// 每个字段只检查一次
				}
				if (value != null || "".equals(value)) {
					if (vAnnotation.between() != null && !"".equals(vAnnotation.between())) {

						long minValue = Long.parseLong(vAnnotation.between().split(":")[0]);
						long maxValue = Long.parseLong(vAnnotation.between().split(":")[1]);
						long curValue = Long.parseLong(value.toString());
						if (curValue < minValue || curValue > maxValue) {
							errorMap.put(field.getName(), "该字段值的范围是" + minValue + " - " + maxValue);
						}
					}
					if (vAnnotation.formatRegex() != null && !"".equals(vAnnotation.formatRegex())) {
						if (!value.toString().matches(vAnnotation.formatRegex())) {
							errorMap.put(field.getName(), "数据格式错误");

						}

					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return errorMap;
	}

	private static String getMethodName(Field field, String type) {
		String fieldName = field.getName();
		StringBuffer methodName = new StringBuffer();
		methodName.append(type).append(fieldName.substring(0, 1).toUpperCase())
				.append(fieldName.substring(1, fieldName.length()));
		return methodName.toString();

	}
}
