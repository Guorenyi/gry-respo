package cn.mldn.eop.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.eop.vo.ReimbursementDetails;
import cn.mldn.util.dao.IDAO;

public interface IReimbursementDetailsDAO extends IDAO<Long, ReimbursementDetails>{
	/**
	 * 根据rbsid查询当前报销项信息
	 * @param id rbsid 报销单id
	 * @return
	 * @throws SQLException
	 */
	public List<ReimbursementDetails> findAllByRbsid(Long id) throws SQLException ;
	/**
	 * 增加报销项成功追加报销单总钱数
	 * @param rbsid
	 * @return
	 * @throws SQLException
	 */
	public boolean editMoney(Long rbsid,double money) throws SQLException ;
	/**
	 * 删除单个报销信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean doRemoveSingle(Long id) throws SQLException ;
}
