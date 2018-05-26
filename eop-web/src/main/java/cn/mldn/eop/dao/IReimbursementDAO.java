package cn.mldn.eop.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.Reimbursement;
import cn.mldn.util.dao.IDAO;

public interface IReimbursementDAO extends IDAO<Long, Reimbursement> {
	/**
	 * 根据type信息查询所有的报销类型数据
	 * @param type 
	 * @return 报销对应的类型数据
	 * @throws SQLException 
	 */
	public List<Dictionary> findAllByReimbursement(String type) throws SQLException ;
	
	
	/**
	 * 创建报销单
	 * @param vo
	 * @return
	 * @throws SQLException
	 */
	public Boolean doCreateByRe(Reimbursement vo) throws SQLException;
	/**
	 * 报销申请提交
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean editStatusById(Long id) throws SQLException ;
	/**
	 * 分页查询已经提交的报销单
	 */
	public List<Reimbursement> findSplitByStatus(Long currentPage, Integer lineSize) throws SQLException ;
	/**
	 * 分页查询已经提交的报销单
	 */
	public List<Reimbursement> findSplitByStatus(Long currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException ;
	/**
	 * 分页统计已经提交的报销单
	 */
	public Long getAllCountByStatus() throws SQLException ;
	/**
	 * 分页统计已经提交的报销单
	 */
	public Long getAllCountByStatus(String column, String keyWord) throws SQLException ;
	/**
	 * 修改申请日期
	 * @return
	 * @throws SQLException
	 */
	public boolean editSubDate(Reimbursement vo) throws SQLException ;
	
}
