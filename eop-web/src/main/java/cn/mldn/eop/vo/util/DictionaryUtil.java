package cn.mldn.eop.vo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.mldn.util.dbc.DatabaseConnection;
import cn.mldn.util.sql.SqlUtil;

public class DictionaryUtil {
	/**
	 * 该类加载时将取得全部的 dictionary数据，以便在内存中根据type取得相应的dictionary List
	 */
	private static HashMap<String, List<Dictionary>> dicMap = new HashMap<String, List<Dictionary>>();
	static {
		if (dicMap == null || dicMap.size() == 0) {
			String sql = SqlUtil.generateFindSql(Dictionary.class, "");
			Connection conn =null;
			try {
				conn = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery();
				List<Dictionary> dicList = SqlUtil.assembleVOList(rs, Dictionary.class);
				String type = "";
				List<Dictionary> dicTempList = null;
				for (Dictionary dic : dicList) {
					String tempType = dic.getType();
					// 第一次取数据
					if ("".equals(type)) {
						type = tempType;
						dicTempList = new ArrayList<Dictionary>();
						dicMap.put(type, dicTempList);
					}

					// 如果type发生变化，则重新创建List
					if (!type.equalsIgnoreCase(tempType)) {
						dicTempList = new ArrayList<Dictionary>();
						dicMap.put(tempType, dicTempList);
						type = tempType;
					}
					dicTempList.add(dic);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 根据type取得dictionary数据列表
	 * 
	 * @param type
	 *            数据类型
	 * @return dictionary数据列表
	 */
	public static List<Dictionary> getDictionary(String type) {

		if (dicMap != null) {
			return dicMap.get(type);
		}
		return null;

	}

}
