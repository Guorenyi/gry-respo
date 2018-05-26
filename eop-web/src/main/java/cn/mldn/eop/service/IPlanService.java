package cn.mldn.eop.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.EmpLevel;
import cn.mldn.eop.vo.Plan;


public interface IPlanService {
	
	
	/**
	 * 获取plan的数据
	 * @param pid
	 * @return
	 */
	public Plan getPlan(Long pid)throws SQLException;
	/**
	 * 通过eid查询相关的数据
	 * @param mid
	 * @return
	 * @throws Exception
	 */
	public EmpLevel findEmpLevel(String eid)throws Exception;
	/**
	 * 增加之前任务类型的查询
	 * @return  返回数据字典中的所有类型
	 * @throws Exception
	 */
	public List<Dictionary> addPre()throws Exception;
	
	/**
	 * 进行任务的增加
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public Boolean add(Plan vo)throws Exception;
	
	/**
	 * 进行商品信息的分页数据查询，如果没有查询列或查询关键字则进行整体查询
	 * @param column 查询列
	 * @param keyWord 查询关键字
	 * @param currentPage 当前页
	 * @param lineSize 每页行
	 * @return 返回的内容包含有如下信息：
	 * 1、key = allPlans、value = 全部任务信息；
	 * 2、key = allCount、value = 统计结果。
	 *
	 * @throws Exception SQL
	 */
	public Map<String, Object> list(String column, String keyWord, long currentPage, int lineSize) throws Exception;

	/**
	 * 进行任务的发布
	 * @param pid 传入的主键的数值，在业务层进行状态的更改
	 * @return
	 * @throws Exception
	 */
	public boolean editPublish(Long pid)throws Exception;
	
	/**
	 * 删除未发布的任务
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Set<Long> ids)throws Exception;
	
	/**
	 * 获取任务详情信息
	 * @param pid
	 * @return
	 * key:plan value:任务的信息
	 * key: 
	 * @throws Exception
	 */
	public Map<String, Object> getDetails(Long pid)throws Exception;
	
	
	/**
	 * 获取所有的部门和员工信息
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getAllEmpDept(Long did, long currentPage, int lineSize)throws Exception;
	
	/**
	 * 通过部门id取得相应的员工数据
	 * @param did
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> getDetailsDept(Long did)throws SQLException;
 }
