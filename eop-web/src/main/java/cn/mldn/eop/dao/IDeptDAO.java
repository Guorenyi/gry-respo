package cn.mldn.eop.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.eop.vo.Dept;
import cn.mldn.eop.vo.Emp;
import cn.mldn.util.dao.IDAO;

public interface IDeptDAO extends IDAO<Long, Dept>{
	/**
	 * 根据指定部门名称查询当前部门是否存在，如果存在则不允许进行添加
	 * @param dname 需要添加的部门名称
	 * @return 查询成功返回当前部门信息，否则返回null
	 * @throws SQLException SQL执行异常
	 */
	public Dept findByDname(String dname) throws SQLException ;
	/**
	 * 进行部门当前人数更改操作
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public boolean updateCurrnum(Integer num,String dname) throws SQLException ;
	/**
	 * 查询所有部门经理
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> findByLid() throws SQLException ;
}
