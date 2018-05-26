package cn.mldn.eop.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.SupplyPurchaseDAO;
import cn.mldn.eop.vo.SupplyPurchase;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class SupplyPurchaseDAOImpl extends AbstractDAO<SupplyPurchase> implements SupplyPurchaseDAO {

	
	@Override
	public boolean doCreate(SupplyPurchase vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.doCreate(vo,SupplyPurchase.class);
	}

	@Override
	public long doCreate(SupplyPurchase vo,boolean returnNewKeyId) throws SQLException {
		return super.doCreate(vo, SupplyPurchase.class,returnNewKeyId);
	}

	@Override
	public boolean doEdit(SupplyPurchase vo) throws SQLException {
		return super.doEdit(vo, SupplyPurchase.class);
	}

	@Override
	public boolean doRemove(Set<String> ids) throws SQLException {
		return super.doRemove(ids, "supply_purchase", "spid", "status");
	}

	@Override
	public SupplyPurchase findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return super.findById("spid", id, SupplyPurchase.class);
	}

	@Override
	public List<SupplyPurchase> findAll() throws SQLException {
		return super.findAll(SupplyPurchase.class);
	}

	@Override
	public List<SupplyPurchase> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		return super.findSplit(currentPage, lineSize,"" ,SupplyPurchase.class);
	}

	@Override
	public List<SupplyPurchase> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		return super.findSplit(currentPage, lineSize, column+" like '%"+keyWord+"%'", SupplyPurchase.class);
	}

	@Override
	public Long getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return super.getAllCountHandle("supply_purchase");
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return super.getAllCountSplitHandle("supply_purchase", column, keyWord);
	}
	@Override
	public long getAllCountHandle(String whereStr) throws SQLException {
		return super.getAllCountHandle("supply_purchase", whereStr);
	}
	
	public List<SupplyPurchase> findSupplyForAudit(Long currentPage, Integer lineSize) throws SQLException {
		return super.findSplit(currentPage.longValue(), lineSize.intValue(),"status=1", SupplyPurchase.class);

	}
	public List<SupplyPurchase> findSupplyForAudit(Long currentPage, Integer lineSize,String column, String keyWord ) throws SQLException {
		return super.findSplit(currentPage, lineSize,column+ " like '%"+keyWord+"%'"+" and status=1", SupplyPurchase.class);

	}

}
