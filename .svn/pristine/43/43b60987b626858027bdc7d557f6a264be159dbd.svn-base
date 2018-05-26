package cn.mldn.util.service.abs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.util.dao.IDAO;

public abstract class AbstractService {
	/**
	 * 是否需要进行模糊查询处理
	 * @param column 判断的查询列
	 * @param keyWord 判断的关键字
	 * @return 如果需要模糊查询处理返回true，否则返回false
	 */
	public boolean isSearch(String column, String keyWord) {
		if (column == null || "".equals(column) || keyWord == null || "".equals(keyWord)) {
			return false ; // 不需要模糊查询
		}
		return true ;  
	}
	/**
	 * 获取分页数据
	 * @param currentPage 当前页
	 * @param lineSize 每页行数
	 * @param clazz 对象类
	 * @param dao DAO对象
	 * @return  包含分页VOList及总数据量
	 * @throws Exception
	 */
	protected Map<String, Object> findBySplit(long currentPage, int lineSize,IDAO dao) throws Exception {
		List<Class<?>> objectList = new ArrayList<Class<?>>();
		objectList = dao.findSplit(currentPage, lineSize);
		long totalCount = dao.getAllCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("objectList", objectList);
		map.put("totalCount", totalCount);
		return map;

	}
	/**
	 * 获取模糊查询的分页数据
	 * @param currentPage 当前页
	 * @param lineSize 每页行数
	 * @param clazz 对象类
	 * @param column 模糊查询列
	 * @param keyWord 模糊查询值
	 * @param dao DAO对象
	 * @return  包含分页VOList及总数据量
	 * @throws Exception
	 */
	protected Map<String, Object> findBySplit(long currentPage, int lineSize,String column, String keyWord,IDAO dao) throws Exception {
		List<Class<?>> objectList = new ArrayList<Class<?>>();
		objectList = dao.findSplit(currentPage, lineSize,column,keyWord);
		long totalCount = dao.getAllCount(column,keyWord);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("objectList", objectList);
		map.put("totalCount", totalCount);
		return map;

	} 
	protected long getAllCount(IDAO dao) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllCount();
	}

}
