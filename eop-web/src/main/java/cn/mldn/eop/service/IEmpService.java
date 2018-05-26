package cn.mldn.eop.service;

import java.util.Map;

import cn.mldn.eop.vo.Emp;
import cn.mldn.eop.vo.EmpLevel;
import cn.mldn.util.service.IBaseService;

public interface IEmpService extends IBaseService<Emp>{
	/**
	 * 雇员数据增加前的查询操作<br>
	 * <li>key="allDepts",value=所有部门信息,调用deptDAO.findAll()</li>
	 * <li>key="allLevels",value=所有职位信息,调用levelDAO.findAll()</li>
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> addPre() throws Exception ;
	/**
	 * 雇员数据增加前的查询操作<br>
	 * <li>key="allDepts",value=所有部门信息,调用deptDAO.findAll()</li>
	 * <li>key="allLevels",value=所有职位信息,调用levelDAO.findAll()</li>
	 * <li>key="emp",value=当前雇员信息,调用empDAO.findById()</li>
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> editPre(String eid) throws Exception ;
	/**
	 * 异步查询当前工资是否符合当前工资等级
	 * @param lid 工资等级编号
	 * @param salary 工资
	 * @return 工资输入正确返回true,否则返回false
	 * @throws Exception
	 */
	public boolean findSalary(int lid,double salary) throws Exception ;
	/**
	 * 根据eid查询出所需的部门、雇员以及职位信息
	 * @param eid
	 * @return
	 * @throws Exception
	 */
	public EmpLevel getEmpLevelDept(String eid) throws Exception ;
}
