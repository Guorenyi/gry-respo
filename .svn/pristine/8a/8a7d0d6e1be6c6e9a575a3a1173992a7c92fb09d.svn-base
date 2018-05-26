package cn.mldn.eop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.IReimbursementDetailsDAO;
import cn.mldn.eop.vo.ReimbursementDetails;
import cn.mldn.eop.vo.SupplyPurchase;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class ReimbursementDetailsDAOImpl extends AbstractDAO implements IReimbursementDetailsDAO{
	@Override
	public List<ReimbursementDetails> findAllByRbsid(Long id) throws SQLException {
		List<ReimbursementDetails> all = new ArrayList<ReimbursementDetails>() ;
		String sql = "select rbdid,rbsid,money,note,title from reimbursement_details where rbsid=?" ;
		prepareStatement(sql); 
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			ReimbursementDetails vo = new ReimbursementDetails() ;
			vo.setRbdid(rs.getLong(1));
			vo.setRbsid(rs.getLong(2));
			vo.setMoney(rs.getDouble(3));
			vo.setNote(rs.getString(4));
			vo.setTitle(rs.getString(5));
			all.add(vo) ;
		}
		return all;
	}
	@Override
	public boolean doCreate(ReimbursementDetails vo) throws SQLException {
		return super.doCreate(vo,ReimbursementDetails.class);
	}

	@Override
	public boolean doEdit(ReimbursementDetails vo) throws SQLException {
		return super.doEdit(vo, ReimbursementDetails.class);
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		return super.doRemoveHandleByLong("reimbursement_details", "rbdid", ids);
	}

	@Override
	public ReimbursementDetails findById(Long id) throws SQLException {
		return (ReimbursementDetails) super.findById("rbdid", String.valueOf(id), ReimbursementDetails.class);
	}

	@Override
	public List<ReimbursementDetails> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementDetails> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementDetails> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean editMoney(Long rbsid,double money) throws SQLException {
		String sql = "update reimbursement set money=? where rbsid=?"  ;
		prepareStatement(sql);
		System.out.println("*******sql***" + sql);
		pstmt.setDouble(1,money);
		pstmt.setLong(2, rbsid);
		return pstmt.executeUpdate() > 0;
	}
	@Override
	public boolean doRemoveSingle(Long id) throws SQLException {
		String sql = "delete from reimbursement_details where rbdid=?" ;
		prepareStatement(sql);
		pstmt.setLong(1, id);
		return pstmt.executeUpdate() > 0;
	}

}
