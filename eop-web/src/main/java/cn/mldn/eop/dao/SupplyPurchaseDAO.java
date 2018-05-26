package cn.mldn.eop.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.eop.vo.SupplyPurchase;
import cn.mldn.util.dao.IDAO;

public interface SupplyPurchaseDAO extends IDAO<String, SupplyPurchase> {
	public long doCreate(SupplyPurchase vo,boolean returnNewKeyId) throws Exception;
	public List<SupplyPurchase> findSupplyForAudit(Long currentPage, Integer lineSize) throws SQLException ;
	public List<SupplyPurchase> findSupplyForAudit(Long currentPage, Integer lineSize,String column, String keyWord ) throws SQLException ;
	public long getAllCountHandle(String whereStr) throws SQLException;
}
