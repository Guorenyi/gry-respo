package cn.mldn.eop.service;

import java.util.List;
import java.util.Map;

import cn.mldn.eop.vo.PlanSchedule;

public interface ISheduleService {
	/**
	 * 个人任务列表
	 * @return
	 * @throws Exception
	 */
	public 	List<PlanSchedule> get(String eid)throws Exception;
	
	
	/**
	 * 模糊分页查询工作计划
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> list(String column, String keyWord, long currentPage, int lineSize,String eid)throws Exception;

	/**
	 * 全部分页查询
	 * 
	 */
//	public Map<String, Object> list(long currentPage, int lineSize,String eid)throws Exception;

}
