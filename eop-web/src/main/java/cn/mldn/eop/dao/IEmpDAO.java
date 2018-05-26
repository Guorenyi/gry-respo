package cn.mldn.eop.dao;

import cn.mldn.eop.vo.Emp;
import cn.mldn.eop.vo.EmpLevel;
import cn.mldn.util.dao.IDAO;

public interface IEmpDAO extends IDAO<String, Emp>{
	/**
	 * 根据eid获取部门以及职位信息
	 * @param eid
	 * @return
	 * @throws Exception
	 */
	public EmpLevel findDeptAndLevelByEid(String eid) throws Exception ;
}
