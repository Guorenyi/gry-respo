package cn.mldn.util.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConverterUtil {
	private DataConverterUtil() {
	}
	/**
	 * 此时可以将字符串数组变为指定类型的数组
	 * @param type 类型
	 * @param value 字符串数据
	 * @return 指定类型的数组
	 */
	public static Object convert(String type, String value[]) {
		if (value == null) {
			return value;
		}
		if ("int[]".equals(type)) {
			int data[] = new int[value.length];
			for (int x = 0; x < data.length; x++) {
				data[x] = Integer.parseInt(value[x]);
			}
			return data;
		} else if ("Integer[]".equals(type)) {
			Integer data[] = new Integer[value.length];
			for (int x = 0; x < data.length; x++) {
				data[x] = Integer.parseInt(value[x]);
			}
			return data;
		} else if ("long[]".equals(type)) {
			long data[] = new long[value.length];
			for (int x = 0; x < data.length; x++) {
				data[x] = Long.parseLong(value[x]);
			}
			return data;
		} else if ("Long[]".equals(type)) {
			Long data[] = new Long[value.length];
			for (int x = 0; x < data.length; x++) {
				data[x] = Long.parseLong(value[x]);
			}
			return data;
		} else {
			return value; // 直接返回
		}
	} 

	/**
	 * 实现指定类型的数据转型
	 * 
	 * @param type
	 *            数据类型
	 * @param value
	 *            接收到的数据内容
	 * @return 转换后的结果
	 */
	public static Object convert(String type, String value) {
		if ("int".equals(type) || "Integer".equals(type)) {
			try {
				return Integer.parseInt(value) ;
			} catch (Exception e) {
				return 0 ;
			}
		} else if ("long".equalsIgnoreCase(type)) {
			try {
				return Long.parseLong(value) ;
			} catch (Exception e) {
				return 0 ;
			}
		} else if ("double".equalsIgnoreCase(type)) {
			try {
				return Double.parseDouble(value) ;
			} catch (Exception e) {
				return 0.0 ;
			}
		} else if ("date".equalsIgnoreCase(type)) {
			try {
				if (value.matches("\\d{4}-\\d{2}-\\d{2}")) {
					return new SimpleDateFormat("yyyy-MM-dd").parse(value);
				} else if (value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
					return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(value);
				} else if (value.matches("\\d+")) {
					return new Date(Long.parseLong(value));
				}
			} catch (Exception e) {
				return null;
			}
		} else if ("boolean".equalsIgnoreCase(type)) {
			return Boolean.parseBoolean(value);
		} else {
			return value;
		}
		return value;
	}
}
