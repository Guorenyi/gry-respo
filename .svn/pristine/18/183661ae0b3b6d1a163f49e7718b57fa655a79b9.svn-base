package cn.mldn.util.dao.abs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dbc.DatabaseConnection;
import cn.mldn.util.sql.SqlUtil;
import cn.mldn.util.web.annotation.FieldAnnotation;
import cn.mldn.util.web.annotation.TableAnnotation;

public abstract class AbstractDAO<T> {
	protected PreparedStatement pstmt;
	protected Connection conn;

	public AbstractDAO() {
		try {
			this.conn = DatabaseConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 实现数据批量删除的处理方法
	 * 
	 * @param tableName
	 *            要删除的数据表
	 * @param keyColumn
	 *            删除数据主键列的名称
	 * @param ids
	 *            删除的ID
	 * @return 删除成功返回true
	 * @throws SQLException
	 *             数据库异常
	 */
	public boolean doRemoveHandleByLong(String tableName, String keyColumn, Set<Long> ids) throws SQLException {
		StringBuffer buf = new StringBuffer("DELETE FROM ");
		buf.append(tableName).append(" WHERE ").append(keyColumn).append(" IN (");
		for (Long id : ids) {
			buf.append(id).append(",");
		}
		buf.delete(buf.length() - 1, buf.length()).append(")");
		this.prepareStatement(buf.toString());
		return this.pstmt.executeUpdate() > 0;
	}

	/**
	 * 对查询全部数据量进行处理
	 * 
	 * @param tableName
	 *            要查询的表名称
	 * @return 记录的统计个数
	 * @throws SQLException
	 *             SQL异常
	 */
	public long getAllCountHandle(String tableName) throws SQLException {
		String sql = "SELECT COUNT(*) FROM " + tableName;
		this.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

	/**
	 * 对查询全部数据量进行处理
	 * 
	 * @param tableName
	 *            要查询的表名称
	 * @return 记录的统计个数
	 * @throws SQLException
	 *             SQL异常
	 */
	public long getAllCountHandle(String tableName,String whereStr) throws SQLException {
		String sql="";
		if(whereStr!=null&&!"".equals(whereStr)) {
		    sql = "SELECT COUNT(*) FROM " + tableName + " where "+ whereStr;
		}else {
			sql = "SELECT COUNT(*) FROM " + tableName;
		}
		this.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}
	/**
	 * 对数据量进行模糊查询操作
	 * 
	 * @param tableName
	 *            表名称
	 * @param column
	 *            列名称
	 * @param keyWord
	 *            查询关键字
	 * @return 模糊查询统计结果
	 * @throws SQLException
	 *             SQL异常
	 */
	public long getAllCountSplitHandle(String tableName, String column, String keyWord) throws SQLException {
		String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE " + column + " LIKE ?";
		this.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

	/**
	 * 根据表的主键删除逻辑删除记录，将逻辑删除字段修改为1
	 * @param ids 主键ID list
	 * @param tableName 表名
	 * @param keyColName 主键字段名称
	 * @param deleteColName 逻辑删除字段名称
	 * @return 删除结果
	 * @throws SQLException
	 */
	protected boolean doRemove(Set<String> ids, String tableName, String keyColName, String deleteColName)
			throws SQLException {
		if (ids == null || ids.size() <= 0) {
			return false;
		}
		String sql = "update " + tableName + " set " + deleteColName + "=1 where " + keyColName + "=?";
		this.prepareStatement(sql);
		for (String id : ids) {
			this.pstmt.setString(1, id);
			this.pstmt.addBatch();
		}
		return this.pstmt.executeBatch().length == ids.size() ? true : false;

	}
	/**
	 * 物理删除表记录
	 * @param ids 主键 Set<String>集合
	 * @param tableName 表名
	 * @param keyColName 主键字段
	 * @return true: 删除成功
	 * 		   false:删除失败
	 * @throws SQLException
	 */
	protected boolean doRemove(Set<String> ids, String tableName, String keyColName)
			throws SQLException {
		if (ids == null || ids.size() <= 0) {
			return false;
		} 
		String sql = "delete from " + tableName + " where " + keyColName + "=?";
		this.prepareStatement(sql);
		for (String id : ids) {
			this.pstmt.setString(1, id);
			this.pstmt.addBatch();
		}
		return this.pstmt.executeBatch().length == ids.size() ? true : false;

	}

	/**
	 *根据VO对象创建记录
	 * @param vo VO对象
	 * @param clazz VO对象class名称
	 * @return 创建结果
	 * @throws SQLException
	 */
	protected boolean doCreate(T vo, Class<T> clazz) throws SQLException {

		String sql = SqlUtil.generateInsertSql(clazz);
		this.prepareStatement(sql);
		SqlUtil.assembleInsertParams(this.pstmt, vo);
		return this.pstmt.executeUpdate() > 0;
	}
	
	/**
	 * 返回当前创建对象的主键值
	 * @param vo
	 * @param clazz
	 * @param keyColumn
	 * @return
	 * @throws SQLException
	 */
	protected long doCreate(T vo, Class<T> clazz,boolean returnKeyId) throws SQLException {
		
		String sql = SqlUtil.generateInsertSql(clazz);
		this.prepareStatement(sql);
		SqlUtil.assembleInsertParams(this.pstmt, vo);
		if(returnKeyId) {
			Long maxKeyId = 0L;
			if(this.pstmt.executeUpdate()>0) {
				TableAnnotation TableAnnotation = (TableAnnotation) clazz.getAnnotation(TableAnnotation.class);
				String tableName = TableAnnotation.tableName();
				String keyCol = TableAnnotation.keyCol();
				
				String keySql = "select max("+keyCol+") maxKeyId from "+tableName;
				this.prepareStatement(keySql);
				ResultSet rs = this.pstmt.executeQuery();
				while (rs.next()) {
					maxKeyId = rs.getLong("maxKeyId");
				}
			}
			return maxKeyId;
		}else {
			return this.pstmt.executeUpdate();
		}
	}

	/**
	 * 根据VO对象更新记录
	 * @param vo VO对象
	 * @param clazz VO对象class名称
	 * @return 更新结果
	 * @throws SQLException
	 */
	protected boolean doEdit(T vo, Class<T> clazz) throws SQLException {
		String sql = SqlUtil.generateUpdateSql(clazz);
		this.prepareStatement(sql);
		SqlUtil.assembleUpdateParams(this.pstmt, vo);
		return this.pstmt.executeUpdate() > 0;
	}

	/**
	 * 根据表的主键返回VO对象
	 * @param keyColName 主键字段名称
	 * @param id 主键值
	 * @param clazz 返回对象class类名称
	 * @return VO对象
	 * @throws SQLException
	 */
	protected <T> T findById(String keyColName,String id, Class<T> clazz) throws SQLException {
	
		String sql = SqlUtil.generateFindSql(clazz, keyColName+"= ?");
		this.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		T obj = SqlUtil.assembleVO(rs, clazz);
		if(obj!=null) {
			//设置关联对象
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
				//如果某个字段对象是依赖于其他表对象，则构建其他表对象。
				if(fieldAnnotation!=null&&!"".equals(fieldAnnotation.dependencyField())) {
					String dependencyField = fieldAnnotation.dependencyField();
					String sourceFieldId = dependencyField.split(":")[0];
					try {
					Field sourceField = obj.getClass().getDeclaredField(sourceFieldId);
					Method sourceFieldGetMethod = clazz.getDeclaredMethod(SqlUtil.getMethodName(sourceField, "get"));
					
					String targeFieldId = dependencyField.split(":")[1];
					
					Object sourceId = sourceFieldGetMethod.invoke(obj, null);
					if(sourceId!=null) {
						Method setMethod = clazz.getDeclaredMethod(SqlUtil.getMethodName(field, "set"), field.getType());
						setMethod.invoke(obj, this.findById(targeFieldId, sourceId.toString(), field.getType()));
					}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return obj;

	}

	/**
	 * 返回所有非逻辑删除的数据，以VO List返回
	 * @param clazz VO对象class名称
	 * @return VO对象List
	 * @throws SQLException
	 */
	public List<T> findAll(Class<T> clazz) throws SQLException {
		String sql = SqlUtil.generateFindSql(clazz, "");
		this.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		List<T> voList = SqlUtil.assembleVOList(rs, clazz);
		if(voList.size()>0) {
			for (T obj : voList) {
				//设置关联对象
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
					//如果某个字段对象是依赖于其他表对象，则构建其他表对象。
					if(fieldAnnotation!=null&&!"".equals(fieldAnnotation.dependencyField())) {
						String dependencyField = fieldAnnotation.dependencyField();
						String sourceFieldId = dependencyField.split(":")[0];
						try {
						Field sourceField = obj.getClass().getDeclaredField(sourceFieldId);
						Method sourceFieldGetMethod = clazz.getDeclaredMethod(SqlUtil.getMethodName(sourceField, "get"));
						
						String targeFieldId = dependencyField.split(":")[1];
						
						Object sourceId = sourceFieldGetMethod.invoke(obj, null);
						if(sourceId!=null) {
							Method setMethod = clazz.getDeclaredMethod(SqlUtil.getMethodName(field, "set"), field.getType());
							setMethod.invoke(obj, this.findById(targeFieldId, sourceId.toString(), field.getType()));
						}
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return voList;
		
	}
	
	/**
	 * 返回所有符合条件的数据，以VO List返回
	 * @param clazz VO对象class名称
	 * @param whereStr 查询条件
	 * @return 所有符合条件的数据，以VO List返回
	 * @throws SQLException
	 */
	public List<T> findAll(Class<T> clazz,String whereStr) throws SQLException { String sql = SqlUtil.generateFindSql(clazz, whereStr);
		this.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		List<T> voList = SqlUtil.assembleVOList(rs, clazz);
		if(voList.size()>0) {
			for (T obj : voList) {
				//设置关联对象
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
					//如果某个字段对象是依赖于其他表对象，则构建其他表对象。
					if(fieldAnnotation!=null&&!"".equals(fieldAnnotation.dependencyField())) {
						String dependencyField = fieldAnnotation.dependencyField();
						String sourceFieldId = dependencyField.split(":")[0];
						try {
						Field sourceField = obj.getClass().getDeclaredField(sourceFieldId);
						Method sourceFieldGetMethod = clazz.getDeclaredMethod(SqlUtil.getMethodName(sourceField, "get"));
						
						String targeFieldId = dependencyField.split(":")[1];
						
						Object sourceId = sourceFieldGetMethod.invoke(obj, null);
						if(sourceId!=null) {
							Method setMethod = clazz.getDeclaredMethod(SqlUtil.getMethodName(field, "set"), field.getType());
							setMethod.invoke(obj, this.findById(targeFieldId, sourceId.toString(), field.getType()));
						}
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return voList;
		
	}
	/**
	 * 获得每页的VO List
	 * @param currentPage 当前页
	 * @param lineSize	每页行数
	 * @param clazz VO对象class名称
	 * @return 分页后的VO List
	 * @throws SQLException
	 */
//	public List<T> findSplit(long currentPage, int lineSize, Class<T> clazz) throws SQLException {
//		String sql = SqlUtil.generateFindSql(clazz, "dflag is null LIMIT ?,?");
//		this.prepareStatement(sql);
//		this.pstmt.setLong(1, (currentPage - 1) * lineSize);
//		this.pstmt.setInt(2, lineSize); 
//		ResultSet rs = this.pstmt.executeQuery();
//		List<T> voList = SqlUtil.assembleVOList(rs, clazz);
//		if(voList.size()>0) {
//			for (T obj : voList) {
//				//设置关联对象
//				Field[] fields = clazz.getDeclaredFields();
//				for (Field field : fields) {
//					FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
//					//如果某个字段对象是依赖于其他表对象，则构建其他表对象。
//					if(fieldAnnotation!=null&&!"".equals(fieldAnnotation.dependencyField())) {
//						String dependencyField = fieldAnnotation.dependencyField();
//						String sourceFieldId = dependencyField.split(":")[0];
//						try {
//						Field sourceField = obj.getClass().getDeclaredField(sourceFieldId);
//						Method sourceFieldGetMethod = clazz.getDeclaredMethod(SqlUtil.getMethodName(sourceField, "get"));
//						
//						String targeFieldId = dependencyField.split(":")[1];
//						
//						Object sourceId = sourceFieldGetMethod.invoke(obj, null);
//						if(sourceId!=null) {
//							Method setMethod = clazz.getDeclaredMethod(SqlUtil.getMethodName(field, "set"), field.getType());
//							setMethod.invoke(obj, this.findById(targeFieldId, sourceId.toString(), field.getType()));
//						}
//						}catch(Exception e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//		}
//		return voList;
//		
//	}

	/**
	 * 根据模糊条件查询并返回当前页面的VO list
	 * @param currentPage 当前页
	 * @param lineSize 每页行数
	 * @param column 查找列名
	 * @param keyWord 模糊查找值
	 * @param clazz VO对象class名称
	 * @return 模糊查找分页VO List
	 * @throws SQLException
	 */
	public List<T> findSplit(long currentPage, int lineSize, String column, String keyWord, Class<T> clazz)
			throws SQLException {
		String sql = SqlUtil.generateFindSql(clazz, "dflag is null and " + column + " like ? limit ?,? ");
		this.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setLong(2, (currentPage - 1) * lineSize);
		this.pstmt.setInt(3, lineSize); 
		ResultSet rs = this.pstmt.executeQuery();
		List<T> voList = SqlUtil.assembleVOList(rs, clazz);
		if(voList.size()>0) {
			for (T obj : voList) {
				//设置关联对象
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
					//如果某个字段对象是依赖于其他表对象，则构建其他表对象。
					if(fieldAnnotation!=null&&!"".equals(fieldAnnotation.dependencyField())) {
						String dependencyField = fieldAnnotation.dependencyField();
						String sourceFieldId = dependencyField.split(":")[0];
						try {
						Field sourceField = obj.getClass().getDeclaredField(sourceFieldId);
						Method sourceFieldGetMethod = clazz.getDeclaredMethod(SqlUtil.getMethodName(sourceField, "get"));
						
						String targeFieldId = dependencyField.split(":")[1];
						
						Object sourceId = sourceFieldGetMethod.invoke(obj, null);
						if(sourceId!=null) {
							Method setMethod = clazz.getDeclaredMethod(SqlUtil.getMethodName(field, "set"), field.getType());
							setMethod.invoke(obj, this.findById(targeFieldId, sourceId.toString(), field.getType()));
						}
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return voList;
	}
	public List<T> findSplit(long currentPage, int lineSize, Class<T> clazz)
			throws SQLException {
		return this.findSplit(currentPage, lineSize, "", clazz);
	}
	
	public List<T> findSplit(long currentPage, int lineSize, String where, Class<T> clazz)
			throws SQLException {
		String sql="";
	    sql = SqlUtil.generateFindSql(clazz,where);
		sql = sql +" limit ?,? ";
		this.prepareStatement(sql);
		this.pstmt.setLong(1, (currentPage - 1) * lineSize);
		this.pstmt.setInt(2, lineSize); 
		ResultSet rs = this.pstmt.executeQuery();
		List<T> voList = SqlUtil.assembleVOList(rs, clazz);
		if(voList.size()>0) {
			for (T obj : voList) { 
				//设置关联对象 
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
					//如果某个字段对象是依赖于其他表对象，则构建其他表对象。
					if(fieldAnnotation!=null&&!"".equals(fieldAnnotation.dependencyField())) {
						String dependencyField = fieldAnnotation.dependencyField();
						String sourceFieldId = dependencyField.split(":")[0];
						try {
						Field sourceField = obj.getClass().getDeclaredField(sourceFieldId);
						Method sourceFieldGetMethod = clazz.getDeclaredMethod(SqlUtil.getMethodName(sourceField, "get"));
						
						String targeFieldId = dependencyField.split(":")[1];
						
						Object sourceId = sourceFieldGetMethod.invoke(obj, null);
						if(sourceId!=null) {
							Method setMethod = clazz.getDeclaredMethod(SqlUtil.getMethodName(field, "set"), field.getType());
							setMethod.invoke(obj, this.findById(targeFieldId, sourceId.toString(), field.getType()));
						}
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return voList;
	}
	protected void prepareStatement(String sql ) throws SQLException {
		// 检查conn 是否关闭或者为空,避免一个Action只能调用一次Service而导致前面service关闭连接而后面service 不能使用连接的错误
		if (this.conn == null || this.conn.isClosed()) {
			try {
				this.conn = DatabaseConnection.getConnection();
				// System.out.println("AbstractDAO==="+this.conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.pstmt = this.conn.prepareStatement(sql);
	}

}
