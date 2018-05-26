package cn.mldn.util.sql;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.util.web.annotation.FieldAnnotation;
import cn.mldn.util.web.annotation.TableAnnotation;


public class SqlUtil {
	/**根据VO class生成插入SQL
	 * @param clazz VO class
	 * @return 插入SQL
	 */
	public static String generateInsertSql(Class clazz) {
		// 得到类的annotation
		TableAnnotation TableAnnotation = (TableAnnotation) clazz.getAnnotation(TableAnnotation.class);
		String tableName = TableAnnotation.tableName();
		String keyCol = TableAnnotation.keyCol();
		Field[] fields = clazz.getDeclaredFields();
		StringBuffer sql = new StringBuffer();
		sql.append("insert into ").append(tableName).append("(");
		for (Field field : fields) {
			if(field.getAnnotations().length>0){
				FieldAnnotation annotation = (FieldAnnotation)field.getAnnotation(FieldAnnotation.class);
				if(annotation!=null&&annotation.isAutoIncrease().equalsIgnoreCase("true")){
					continue;
				}
				if(field.getAnnotation(FieldAnnotation.class)!=null&&!"".equals(field.getAnnotation(FieldAnnotation.class).dependencyField())) {
					continue;
				}
			}
			sql.append(field.getName()).append(",");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(") values(");
		for (Field field : fields) {
			if(field.getAnnotations().length>0){
				FieldAnnotation annotation = (FieldAnnotation)field.getAnnotation(FieldAnnotation.class);
				if(annotation!=null&&annotation.isAutoIncrease().equalsIgnoreCase("true")){
					continue;
				}
				if(field.getAnnotation(FieldAnnotation.class)!=null&&!"".equals(field.getAnnotation(FieldAnnotation.class).dependencyField())) {
					continue;
				}
			}
			sql.append("?").append(",");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		return sql.toString();
	}

	/**自动生成更新SQL语句
	 * @param clazz VO对象class
	 * @return 更新SQL语句
	 */
	public static String generateUpdateSql(Class clazz) {
		// 得到类的annotation
		TableAnnotation TableAnnotation = (TableAnnotation) clazz.getAnnotation(TableAnnotation.class);
		String tableName = TableAnnotation.tableName();
		String keyCol = TableAnnotation.keyCol();
		Field[] fields = clazz.getDeclaredFields();
		StringBuffer sql = new StringBuffer();
		sql.append("update ").append(tableName).append(" set ");
		for (Field field : fields) {
			if (field.getName().equalsIgnoreCase(keyCol)) {
				continue;
			}
			if(field.getAnnotation(FieldAnnotation.class)!=null&&!"".equals(field.getAnnotation(FieldAnnotation.class).dependencyField())) {
				continue;
			}
			sql.append(field.getName()).append("=?,");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(" where ").append(keyCol).append("=? ");

		return sql.toString();
	}
	/**自动生成删除SQL语句
	 * @param clazz VO对象class
	 * @return 删除SQL语句
	 */
	public static String generateDeleteSql(Class clazz) {
		// 得到类的annotation
		TableAnnotation TableAnnotation = (TableAnnotation) clazz.getAnnotation(TableAnnotation.class);
		String tableName = TableAnnotation.tableName();
		String keyCol = TableAnnotation.keyCol();
		Field[] fields = clazz.getDeclaredFields();
		StringBuffer sql = new StringBuffer();
		sql.append("delete from ").append(tableName).append(" where ").append(keyCol).append("=?");
		return sql.toString();
	}

	/**
	 * 自动生成查询SQL，可以加入一个where 条件，
	 * @param clazz VO Class Name
	 * @param whereStr where 条件 ，如" dept=2",   不需要保护where关键字
	 * @return
	 */
	public static String generateFindSql(Class clazz, String whereStr) {
		TableAnnotation TableAnnotation = (TableAnnotation) clazz.getAnnotation(TableAnnotation.class);
		String tableName = TableAnnotation.tableName();
		String keyCol = TableAnnotation.keyCol();
		Field[] fields = clazz.getDeclaredFields();
		StringBuffer sql = new StringBuffer();

		sql.append("select ");
		for (Field field : fields) {
			if(field.getAnnotation(FieldAnnotation.class)!=null&&!"".equals(field.getAnnotation(FieldAnnotation.class).dependencyField())) {
				continue;
			}
			sql.append(field.getName()).append(",");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(" from ").append(tableName);
		if (whereStr != null && !"".equals(whereStr)) {
			sql.append(" where ").append(whereStr);
		}
		return sql.toString();

	}

	/**
	 * 自动生成分页的 查询SQL
	 * @param clazz VO class name
	 * @param whereStr where 条件 ，如" dept=2",   不需要保护where关键字
	 * @param currentPage 当前页
	 * @param pageSize 每页显示行数
	 * @return 分页的 查询SQL
	 */
	public static String generateFindSql(Class clazz, String whereStr, Long currentPage, Integer pageSize) {
		TableAnnotation TableAnnotation = (TableAnnotation) clazz.getAnnotation(TableAnnotation.class);
		String tableName = TableAnnotation.tableName();
		Field[] fields = clazz.getDeclaredFields();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from (");
		sql.append("select ");
		for (Field field : fields) {
			if(field.getAnnotation(FieldAnnotation.class)!=null&&!"".equals(field.getAnnotation(FieldAnnotation.class).dependencyField())) {
				continue;
			}
			sql.append(field.getName()).append(",");
		}
		sql.append(" rownum frownum");
		sql.append(" from ").append(tableName);
		if (whereStr != null && !"".equals(whereStr)) {
			sql.append(" where ").append(whereStr);
			sql.append(" lim").append(currentPage * pageSize).append(") temp");
		}else{
			sql.append(" where rownum<=").append(currentPage * pageSize).append(") temp");
		}
		
		sql.append(" where frownum>").append((currentPage - 1) * pageSize);

		return sql.toString();
	}



	/**
	 * 根据VO实例对象自动设置新建对象的参数
	 * @param preparedStatement
	 * @param obj VO实例对象
	 */
	public static void assembleInsertParams(PreparedStatement preparedStatement, Object obj) {

		TableAnnotation TableAnnotation = (TableAnnotation) obj.getClass().getAnnotation(TableAnnotation.class);
		String tableName = TableAnnotation.tableName();
		String keyCol = TableAnnotation.keyCol();

		Field[] fields = obj.getClass().getDeclaredFields();
		int i = 1;
		for (Field field : fields) {
			if(field.getAnnotations().length>0){
				FieldAnnotation annotation = (FieldAnnotation)field.getAnnotations()[0];
				if(annotation.isAutoIncrease().equalsIgnoreCase("true")){
					continue;
				}
				if(field.getAnnotation(FieldAnnotation.class)!=null&&!"".equals(field.getAnnotation(FieldAnnotation.class).dependencyField())) {
					continue;
				}
			}
			String getMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			try {
				Method method = obj.getClass().getMethod(getMethodName);
				Object value = method.invoke(obj);
				if ("java.lang.Integer".equals(field.getType().getName())) {
					if(value!=null){
						preparedStatement.setInt(i++, (Integer) value);
					}else{
						preparedStatement.setNull(i++, Types.INTEGER);
					}
				} else if ("java.lang.Long".equals(field.getType().getName())) {
					if(value!=null){
						preparedStatement.setLong(i++, (Long) value);
					}else{
						preparedStatement.setNull(i++, Types.INTEGER);
					}
				} else if ("java.lang.String".equals(field.getType().getName())) {
					
					preparedStatement.setObject(i++,value);
					
				} else if ("java.lang.Double".equals(field.getType().getName())) {
					if(value!=null){
					preparedStatement.setDouble(i++, (Double) value);
					}else{
						preparedStatement.setNull(i++, Types.DOUBLE);
					}
				} else if ("java.util.Date".equals(field.getType().getName())) {
					if (value != null) {
						preparedStatement.setDate(i++, (new java.sql.Date(((java.util.Date) value).getTime())));
					} else {
						preparedStatement.setNull(i++, Types.DATE);
					}
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		try {
			preparedStatement.addBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 根据VO实例对象自动设置更新对象的参数
	 * @param preparedStatement
	 * @param obj VO实例对象
	 */
	public static void assembleUpdateParams(PreparedStatement preparedStatement, Object obj) {

		TableAnnotation TableAnnotation = (TableAnnotation) obj.getClass().getAnnotation(TableAnnotation.class);
		String tableName = TableAnnotation.tableName();
		String keyCol = TableAnnotation.keyCol();
		Field[] fields = obj.getClass().getDeclaredFields();
		int i = 1;
		String keyValue = "";
		try {
			for (Field field : fields) {
				String getMethodName = getMethodName(field, "get");
				Method method = obj.getClass().getDeclaredMethod(getMethodName);
				Object value = method.invoke(obj);
				if (field.getName().equalsIgnoreCase(keyCol)) {
					keyValue = value.toString();
					continue;
				}
				if(field.getAnnotation(FieldAnnotation.class)!=null&&!"".equals(field.getAnnotation(FieldAnnotation.class).dependencyField())) {
					continue;
				}
				if ("java.lang.Integer".equals(field.getType().getName())) {
					if(value!=null){
						preparedStatement.setInt(i++, (Integer) value);
					}else{
						preparedStatement.setNull(i++, Types.INTEGER);
					}
				} else if ("java.lang.Long".equals(field.getType().getName())) {
					if(value!=null){
						preparedStatement.setLong(i++, (Long) value);
					}else{
						preparedStatement.setNull(i++, Types.INTEGER);
					}
				} else if ("java.lang.String".equals(field.getType().getName())) {
					
					preparedStatement.setObject(i++,value);
					
				} else if ("java.lang.Double".equals(field.getType().getName())) {
					if(value!=null){
					preparedStatement.setDouble(i++, (Double) value);
					}else{
						preparedStatement.setNull(i++, Types.DOUBLE);
					}
				} else if ("java.util.Date".equals(field.getType().getName())) {
					if (value != null) {
						preparedStatement.setDate(i++, (new java.sql.Date(((java.util.Date) value).getTime())));
					} else {
						preparedStatement.setNull(i++, Types.DATE);
					}
				}

			}
			// 最后设置Key 条件
			preparedStatement.setString(i, keyValue);
			preparedStatement.addBatch();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * 根据结果集自动组装VO对象
	 * @param rs
	 * @param clazz
	 * @return VO对象
	 * @throws SQLException
	 */
	public static <T> T assembleVO(ResultSet rs, Class<T> clazz) throws SQLException {
		TableAnnotation TableAnnotation = (TableAnnotation) clazz.getClass().getAnnotation(TableAnnotation.class);
		Field[] fields = clazz.getDeclaredFields();
		String methodName = "";
		T vo = null;
		if (rs.next()) {
			try {
				vo = (T) clazz.getDeclaredConstructor().newInstance();
				for (Field field : fields) {
					
					Method method = clazz.getDeclaredMethod(getMethodName(field, "set"), field.getType());
					
					if ("java.lang.Integer".equals(field.getType().getName())) {
						method.invoke(vo, rs.getInt(field.getName()));
					} else if ("java.lang.Long".equals(field.getType().getName())) {
						method.invoke(vo, rs.getLong(field.getName()));
					} else if ("java.lang.String".equals(field.getType().getName())) {
						method.invoke(vo, rs.getString(field.getName()));
					} else if ("java.lang.Double".equals(field.getType().getName())) {
						method.invoke(vo, rs.getDouble(field.getName()));
					} else if ("java.util.Date".equals(field.getType().getName())) {
						method.invoke(vo, rs.getDate(field.getName()));
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return vo;

	}
	/**
	 * 根据结果集自动组装VO对象列表
	 * @param rs
	 * @param clazz
	 * @return VO对象
	 * @throws SQLException
	 */
	public static <T> List<T> assembleVOList(ResultSet rs, Class<T> clazz) throws SQLException {
		TableAnnotation TableAnnotation = (TableAnnotation) clazz.getClass().getAnnotation(TableAnnotation.class);
		Field[] fields = clazz.getDeclaredFields();
		String methodName = "";
		
		List<T> voList = new ArrayList<T>();
		while (rs.next()) {
			T vo=null;
			try {
				 vo = (T) clazz.getDeclaredConstructor().newInstance();
				for (Field field : fields) {
					Method method = clazz.getDeclaredMethod(getMethodName(field, "set"), field.getType());
					if ("java.lang.Integer".equals(field.getType().getName())) {
						method.invoke(vo, rs.getInt(field.getName()));
					} else if ("java.lang.Long".equals(field.getType().getName())) {
						method.invoke(vo, rs.getLong(field.getName()));
					} else if ("java.lang.String".equals(field.getType().getName())) {
						method.invoke(vo, rs.getString(field.getName()));
					} else if ("java.lang.Double".equals(field.getType().getName())) {
						method.invoke(vo, rs.getDouble(field.getName()));
					} else if ("java.util.Date".equals(field.getType().getName())) {
						method.invoke(vo, rs.getDate(field.getName()));
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			voList.add(vo);
		}
		return voList;

	}

	/**
	 * 生成获得总记录数的SQL
	 * @param clazz VO 对象
	 * @param whereStr 条件
	 * @return sql语句
	 */
	public static String getAllCountSql(Class clazz, String whereStr) {
		TableAnnotation TableAnnotation = (TableAnnotation) clazz.getAnnotation(TableAnnotation.class);

		String tableName = TableAnnotation.tableName();
		StringBuffer sql = new StringBuffer();
		if (whereStr != null && !"".equals(whereStr)) {
		sql.append("select count(*) totalRows from ").append(tableName).append(" where ").append(whereStr);
		}else {
			sql.append("select count(*) totalRows from ").append(tableName);
		}
		return sql.toString();

	}

	public static String getMethodName(Field field, String type) {
		String fieldName = field.getName();
		StringBuffer methodName = new StringBuffer();
		methodName.append(type).append(fieldName.substring(0, 1).toUpperCase())
				.append(fieldName.substring(1, fieldName.length()));
		return methodName.toString();

	}

}
