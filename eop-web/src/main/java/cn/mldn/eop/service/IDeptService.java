package cn.mldn.eop.service;

import java.util.List;

import cn.mldn.eop.vo.Dept;
import cn.mldn.eop.vo.Emp;
import cn.mldn.util.service.IBaseService;

public interface IDeptService extends IBaseService<Dept>{
	/**
	 * 根据指定部门名称查询当前部门是否存在，如果存在则不允许进行添加
	 * @param dname 需要添加的部门名称
	 * @return 查询成功返回当前部门信息，否则返回null
	 * @throws 
	 */
	public Dept findByDname(String dname) throws Exception ;
	/**
	 * 进行分页模糊查询操作的数据统计
	 * @param column 模糊查询列
	 * @param keyWord 模糊查询关键字
	 * @return 查询成功返回记录数，否则返回0
	 * @throws Exception
	 */
	public Long getAllCount(String column, String keyWord) throws Exception ;
	/**
	 * 查询所有的部门经理
	 * @return
	 * @throws Exception
	 */
	public List<Emp> listAllLid() throws Exception ;
}
