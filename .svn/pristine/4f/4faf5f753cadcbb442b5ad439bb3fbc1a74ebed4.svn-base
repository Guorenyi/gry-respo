package cn.mldn.eop.dao;

import java.sql.SQLException;

import cn.mldn.eop.vo.PlanDetails;
import cn.mldn.util.dao.IDAO;

public interface IPlanDetailsDAO extends IDAO<Long, PlanDetails> {
	/**
	 * 
	 *通过eid和pid查找相应的vo对象 
	 */
	public PlanDetails findByEidAndPid(Long pid,String eid)throws SQLException;
	
	/**
	 * 通过eid和pid删除相应的vo 对象
	 * @param pid
	 * @param eid
	 * @return
	 * @throws SQLException
	 */
	public Boolean doDelete(Long pid,String eid)throws SQLException;
	
}
