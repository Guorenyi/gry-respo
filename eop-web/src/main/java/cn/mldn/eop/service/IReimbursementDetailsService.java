package cn.mldn.eop.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.vo.ReimbursementDetails;
import cn.mldn.util.service.IBaseService;

public interface IReimbursementDetailsService extends IBaseService<ReimbursementDetails>{

	/**
	 * 数据删除
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public boolean deleteR(Set<Long> ids,long rbsid) throws Exception ;
	/**
	 * 根据rbsid查询当前报销项信息
	 * @param id rbsid 报销单id
	 * @return
	 * @throws SQLException
	 */
	public List<ReimbursementDetails> listByRbsid(Long id) throws Exception ;
	
}
