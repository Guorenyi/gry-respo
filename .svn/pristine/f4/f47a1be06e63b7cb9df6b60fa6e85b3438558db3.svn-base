package cn.mldn.util.service;

import java.util.Map;
import java.util.Set;


public interface IBaseService<T> {
	public <T> T getById(String id) throws Exception;
	public boolean add(T vo) throws Exception;
	public boolean delete(Set<String> ids) throws Exception;
	public boolean edit(T vo) throws Exception;
	public long getAllCount() throws Exception;
	public Map<String,Object> findBySplit(long currentPage,int lineSize) throws Exception;
	public Map<String,Object> findBySplit(long currentPage,int lineSize,String column,String keyWord) throws Exception;

}
