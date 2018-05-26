package cn.mldn.eop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import cn.mldn.eop.dao.IEmpresourceDAO;
import cn.mldn.eop.dao.IResourceDetailsDAO;
import cn.mldn.eop.dao.IShopcarDAO;
import cn.mldn.eop.dao.ResourceDAO;
import cn.mldn.eop.dao.SupplyPurchaseDAO;
import cn.mldn.eop.service.ResourceMgrService;
import cn.mldn.eop.vo.Empresource;
import cn.mldn.eop.vo.Resource;
import cn.mldn.eop.vo.SupplyPurchase;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;

@Service
public class ResourceMgrServiceImpl extends AbstractService implements ResourceMgrService {
	@Autowired
	private SupplyPurchaseDAO supplyDao;
	@Autowired
	private ResourceDAO resourceDao;
	@Autowired
	private IEmpresourceDAO empresourceDAO;
	@Autowired
	private IResourceDetailsDAO resourcedetailsDAO;

	@Override
	public SupplyPurchase getById(String id) throws Exception {
		return supplyDao.findById(id);
	}

	@Override
	public boolean add(SupplyPurchase vo) throws Exception {
		// 设置申请日期
		vo.setPubdate(new Date()); 
		return supplyDao.doCreate(vo);
	}

	@Override
	public long add(SupplyPurchase vo, boolean returnNewKeyId) throws Exception {
		// 设置申请单的初始状态为0，表示草稿状态
		vo.setStatus(0);
		vo.setPubdate(new Date());
		// 设置商品总价及数量为零

		return supplyDao.doCreate(vo, returnNewKeyId);
	}
	@Override
	public int submitSupply(String spid) throws Exception{
		SupplyPurchase sp = supplyDao.findById(spid);
		int status = sp.getStatus();
		//状态为草稿或者审核未通过才能提交
		if (status==0||status==2) {
			sp.setStatus(1);
			supplyDao.doEdit(sp);
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public boolean delete(Set<String> ids) throws Exception {
		return supplyDao.doRemove(ids);
	}

	@Override
	public boolean edit(SupplyPurchase vo) throws Exception {
		return supplyDao.doEdit(vo);
	}

	@Override
	public long getAllCount() throws Exception {
		return supplyDao.getAllCount();
	}

	/* (non-Javadoc)
	 * @see cn.mldn.util.service.IBaseService#findBySplit(long, int)
	 */
	@Override
	public Map<String, Object> findBySplit(long currentPage, int lineSize) throws Exception {

		return super.findBySplit(currentPage, lineSize, this.supplyDao);
	}

	/* (non-Javadoc)
	 * @see cn.mldn.util.service.IBaseService#findBySplit(long, int, java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> findBySplit(long currentPage, int lineSize, String column, String keyWord)
			throws Exception {
		return super.findBySplit(currentPage, lineSize, column, keyWord, this.supplyDao);
	}

	/* (non-Javadoc)
	 * @see cn.mldn.eop.service.ResourceMgrService#findSupplyDetails(java.lang.Long)
	 */
	@Override
	public List<Resource> findSupplyDetails(Long supplyId) throws Exception {
		return resourceDao.findAll("spid=" + supplyId);
	}

	/* (non-Javadoc)
	 * @see cn.mldn.eop.service.ResourceMgrService#getResourceById(java.lang.Long)
	 */
	public Resource getResourceById(Long rsId) throws Exception {
		return resourceDao.findById(rsId.toString());
	}

	/* (non-Javadoc)
	 * @see cn.mldn.eop.service.ResourceMgrService#addResource(cn.mldn.eop.vo.Resource)
	 */
	public int addResource(Resource vo) throws Exception {
		// 首先取得申请单对象，以便检查状态
		SupplyPurchase sp = supplyDao.findById(vo.getSpid().toString());
		int status = sp.getStatus();
		if (canUpdateDetails(status)) {
			resourceDao.doCreate(vo);
			this.calculateSupply(vo.getSpid().toString());
			return 1;
		} else {
			return -1;
		}
	}

	/* (non-Javadoc)
	 * @see cn.mldn.eop.service.ResourceMgrService#editResource(cn.mldn.eop.vo.Resource)
	 */
	public int editResource(Resource vo) throws Exception {
		// 首先取得申请单对象，以便检查状态
		SupplyPurchase sp = supplyDao.findById(vo.getSpid().toString());
		int status = sp.getStatus();
		if (canUpdateDetails(status)) {
			resourceDao.doEdit(vo);
			this.calculateSupply(vo.getSpid().toString());
			return 1;
		} else {
			return -1;
		}
	}

	/* (non-Javadoc)
	 * @see cn.mldn.eop.service.ResourceMgrService#deleteResource(java.lang.String, java.util.Set)
	 */
	@Override
	public int deleteResource(String spid, Set<String> ids) throws Exception {
		// 首先取得申请单对象，以便检查状态
		SupplyPurchase sp = supplyDao.findById(spid);
		int status = sp.getStatus();
		if (canUpdateDetails(status)) {
			resourceDao.doRemove(ids);
			this.calculateSupply(spid);
			return 1;
		} else {
			return -1;
		}
	}
	
	/* (non-Javadoc)
	 * @see cn.mldn.eop.service.ResourceMgrService#findGoodsBySplit(long, int, java.lang.String, java.lang.String)
	 */
	public Map<String, Object> findGoodsBySplit(long currentPage, int lineSize, String column, String keyWord)
			throws Exception {
		return super.findBySplit(currentPage, lineSize, column, keyWord, this.resourceDao);
	}
	/* (non-Javadoc)
	 * @see cn.mldn.eop.service.ResourceMgrService#findGoodsBySplit(long, int)
	 */
	public Map<String, Object> findGoodsBySplit(long currentPage, int lineSize)
			throws Exception {
			
		return super.findBySplit(currentPage, lineSize,  this.resourceDao); 
	}
	/* (non-Javadoc)
	 * @see cn.mldn.eop.service.ResourceMgrService#appendResourceQty(java.lang.Long, java.lang.Integer)
	 */
	public boolean appendResourceQty(Long resid, Integer qty) throws Exception {
		// 首先取得resource 对象
		Resource vo = resourceDao.findById(resid.toString());
		if (vo != null) {
			vo.setAmount(vo.getAmount() + qty);
			vo.setAppdate(new Date());
			resourceDao.doEdit(vo);
			this.calculateSupply(vo.getSpid().toString());
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 检查是否可以删除申请单明细 可以删除明细的状态有：0-草稿 不可以删除明细的状态有:1-提交,2-审核未通过,3-审核通过
	 * 
	 * @param status
	 *            申请单状态
	 * @return true:可以删除明细 false:不能删除明细
	 */
	private boolean canUpdateDetails(int status) {
		if (status == 0 || status == 2) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 在增加，修改删除清单明细记录时，重新计算购买申请单的数量与金额
	 * 
	 * @param spid
	 * @param qty
	 * @param price
	 * @throws Exception
	 */
	private synchronized void calculateSupply(String spid) throws Exception {
		// 取得申请单对象
		SupplyPurchase vo = supplyDao.findById(spid);
		int oldQty = vo.getAmount();
		// 获得申请单下的所有明细
		List<Resource> resourceList = resourceDao.findAll("spid=" + spid);
		int totalQty = 0;
		double totalMoney = 0.0;
		// 重新计算金额与数量
		for (Resource rs : resourceList) {
			totalQty = totalQty + rs.getAmount();
			totalMoney += rs.getAmount() * rs.getPrice();
		}

		vo.setAmount(totalQty);
		vo.setMoney(totalMoney);
		supplyDao.doEdit(vo);
	}
	/* (non-Javadoc)
	 * @see cn.mldn.eop.service.ResourceMgrService#canUpdateResource(java.lang.String)
	 */
	public boolean canUpdateResource(String spid) throws Exception{
		SupplyPurchase vo = supplyDao.findById(spid);
		int status = vo.getStatus();
		return canUpdateDetails(status);
	}
	
	/* (non-Javadoc)
	 * @see cn.mldn.eop.service.ResourceMgrService#findAvibGoodsSplit(java.lang.Long, java.lang.Integer)
	 */
	public Map<String,Object> findAvibGoodsSplit(Long currentPage, Integer lineSize) throws Exception {
		List<Resource> objectList = new ArrayList<Resource>();
		objectList = resourceDao.findAvibSplit(currentPage, lineSize);
		long totalCount = resourceDao.getAllCountHandle("status=1");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("objectList", objectList);
		map.put("totalCount", totalCount);
		return map;
	}
	/* (non-Javadoc)
	 * @see cn.mldn.eop.service.ResourceMgrService#findAvibGoodsSplit(java.lang.Long, java.lang.Integer, java.lang.String, java.lang.String)
	 */
	public Map<String,Object> findAvibGoodsSplit(Long currentPage, Integer lineSize ,String column, String keyWord) throws Exception {
		List<Resource> objectList = new ArrayList<Resource>();
		objectList = resourceDao.findAvibSplit(currentPage, lineSize,column,keyWord);
		long totalCount = resourceDao.getAllCountHandle(column+ " like '%"+keyWord+"%'"+" and status=1");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("objectList", objectList);
		map.put("totalCount", totalCount);
		return map;
	}
	
    public Map<String,Object> findSupplyForAudit(Long currentPage,Integer lineSize, String column, String keyWord) throws Exception {
		List<SupplyPurchase> objectList = new ArrayList<SupplyPurchase>();
		objectList = supplyDao.findSupplyForAudit(currentPage, lineSize,column,keyWord);
		long totalCount = supplyDao.getAllCountHandle(column+ " like '%"+keyWord+"%'"+" and status=1");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("objectList", objectList);
		map.put("totalCount", totalCount);
		return map;
	
	}
	public Map<String,Object> findSupplyForAudit(Long currentPage,Integer lineSize) throws Exception {
		List<SupplyPurchase> objectList = new ArrayList<SupplyPurchase>();
		objectList = supplyDao.findSupplyForAudit(currentPage, lineSize);
		long totalCount = supplyDao.getAllCountHandle("status=1");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("objectList", objectList);
		map.put("totalCount", totalCount);
		return map;
	}
	 
	public boolean auditResource(String eid,String eresid,String audit,String note) throws Exception{
		// 取出VO对象
				// ResourceMgrService rsService = new ResourceMgrServiceImpl();
				Empresource resource = empresourceDAO.findById(eresid.toString());
				
				resource.setRenote(note);;
				resource.setAeid(eid);
				resource.setStatus(Integer.parseInt(audit));// 状态：1-提交/审核中，2-审核通过，3-审核不通过
				resource.setAuditdate(new Date());

			
				return empresourceDAO.doEdit(resource);
	}


	
}
