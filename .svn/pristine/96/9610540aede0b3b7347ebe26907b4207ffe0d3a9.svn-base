package cn.mldn.eop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.IReimbursementDAO;
import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.Reimbursement;
import cn.mldn.eop.vo.Resource;
import cn.mldn.eop.vo.SupplyPurchase;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class ReimbursementDAOImpl extends AbstractDAO<Reimbursement> implements IReimbursementDAO {

	@Override
	public List<Dictionary> findAllByReimbursement(String type) throws SQLException {
		String sql = "select dctid,type,title,value from dictionary where type=?";
		prepareStatement(sql);
		super.pstmt.setString(1, type);
		ResultSet rs = super.pstmt.executeQuery();
		List<Dictionary> all = new ArrayList<>();
		while (rs.next()) {
			Dictionary vo = new Dictionary();
			vo.setDctid(rs.getLong(1));
			vo.setType(rs.getString(2));
			vo.setTitle(rs.getString(3));
			vo.setValue(rs.getString(4));
			all.add(vo);
		}
		return all;
	}
	
	
	
	@Override
	public Boolean doCreateByRe(Reimbursement vo) throws SQLException {
		String sql = "insert into reimbursement(eid,aeid,title,item,note,credate,money) values(?,?,?,?,?,?,?)";
		prepareStatement(sql);
		super.pstmt.setString(1, vo.getEid());
		super.pstmt.setString(2, vo.getAeid());
		super.pstmt.setString(3, vo.getTitle());
		super.pstmt.setString(4, vo.getItem());
		super.pstmt.setString(5, vo.getNote());
		pstmt.setDouble(5, vo.getMoney());
		super.pstmt.setDate(6, new java.sql.Date(vo.getCredate().getTime()));
		int i = super.pstmt.executeUpdate();
		return i>0;
	}
	@Override
	public boolean doCreate(Reimbursement vo) throws SQLException {
//		String sql = "insert into reimbursement(eid,aeid,title,item,note,money,credate,subdate,status,auditdate,anote) values(?,?,?,?,?,?,?,?,?,?,?)";
//		prepareStatement(sql);
//		super.pstmt.setString(1, vo.getEid());
//		super.pstmt.setString(2, vo.getAeid());
//		super.pstmt.setString(3, vo.getTitle());
//		super.pstmt.setString(4, vo.getItem());
//		super.pstmt.setString(5, vo.getNote());
//		super.pstmt.setDouble(6, vo.getMoney());
//		super.pstmt.setDate(7, new java.sql.Date(vo.getCredate().getTime()));
//		super.pstmt.setDate(8, new java.sql.Date(vo.getSubdate().getTime()));
//		super.pstmt.setInt(9, vo.getStatus());
//		super.pstmt.setDate(10, new java.sql.Date(vo.getAuditdate().getTime()));
//		super.pstmt.setString(11, vo.getAnote());
//		int i = super.pstmt.executeUpdate();
//		return i>0;
		return super.doCreate(vo,Reimbursement.class);
	}

	@Override
	public boolean doEdit(Reimbursement vo) throws SQLException {
		return super.doEdit(vo, Reimbursement.class);
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		StringBuffer sql = new StringBuffer() ;
		sql.append("delete from reimbursement where rbsid in( ") ;
		for(Long id : ids) {
			sql.append(id).append(",") ;
		}
		sql.delete(sql.length()-1, sql.length()).append(")") ;
		sql.append(" and (status=0 or status=3)") ;
		prepareStatement(sql.toString());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public Reimbursement findById(Long id) throws SQLException {
		return super.findById("rbsid", String.valueOf(id), Reimbursement.class);
	}

	@Override
	public List<Reimbursement> findAll() throws SQLException {
		return super.findAll(Reimbursement.class);
	}

	@Override
	public List<Reimbursement> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		return super.findSplit(currentPage, lineSize,"" ,Reimbursement.class);
	}

	@Override
	public List<Reimbursement> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		return super.findSplit(currentPage, lineSize, column+" like '%"+keyWord+"%'", Reimbursement.class);
	}

	@Override
	public Long getAllCount() throws SQLException {
		return super.getAllCountHandle("reimbursement");
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		return super.getAllCountSplitHandle("reimbursement", column, keyWord);
	}



	@Override
	public boolean editStatusById(Long id) throws SQLException {
		String sql = "update reimbursement set status=1 where rbsid=?" ;
		prepareStatement(sql);
		pstmt.setLong(1, id);
		return pstmt.executeUpdate() > 0;
	}



	@Override
	public List<Reimbursement> findSplitByStatus(Long currentPage, Integer lineSize) throws SQLException {
		return super.findSplit(currentPage, lineSize,"status=1" ,Reimbursement.class);
	}



	@Override
	public List<Reimbursement> findSplitByStatus(Long currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		return super.findSplit(currentPage, lineSize, column+" like '%"+keyWord+"%' and status=1", Reimbursement.class);
	}



	@Override
	public Long getAllCountByStatus() throws SQLException {
		return super.getAllCountHandle("reimbursement", "status=1");
	}



	@Override
	public Long getAllCountByStatus(String column, String keyWord) throws SQLException {
		String sql = "SELECT COUNT(*) FROM reimbursement where " + column + " like ? and status=1 " ;
		prepareStatement(sql);
		pstmt.setString(1, "%"+keyWord+"%");
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}



	@Override
	public boolean editSubDate(Reimbursement vo) throws SQLException {
		String sql = "update reimbursement set subdate=?,eid=? where rbsid=?" ;
		prepareStatement(sql);
		pstmt.setDate(1,new java.sql.Date(vo.getSubdate().getTime()));
		pstmt.setString(2, vo.getEid());
		pstmt.setLong(3, vo.getRbsid());
		return pstmt.executeUpdate() > 0;
	}

}
