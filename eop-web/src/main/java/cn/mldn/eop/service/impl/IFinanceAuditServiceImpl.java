package cn.mldn.eop.service.impl;

import java.util.Date;
import java.util.List;

import cn.mldn.eop.dao.IReimbursementDAO;
import cn.mldn.eop.dao.ResourceDAO;
import cn.mldn.eop.dao.SupplyPurchaseDAO;
import cn.mldn.eop.service.IFinanceAuditService;
import cn.mldn.eop.vo.Reimbursement;
import cn.mldn.eop.vo.Resource;
import cn.mldn.eop.vo.SupplyPurchase;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;

@Service
public class IFinanceAuditServiceImpl implements IFinanceAuditService {
	@Autowired
	SupplyPurchaseDAO spDao;
	@Autowired
	ResourceDAO rsDao;
	@Autowired
	IReimbursementDAO reimDao;

	public boolean auditSupply(String aeid,String spid, String auditResult, String anote) throws Exception {
		// 取出VO对象
		// ResourceMgrService rsService = new ResourceMgrServiceImpl();
		SupplyPurchase sp = spDao.findById(spid.toString());
		// 取的明细列表
		List<Resource> supplyDetailList = rsDao.findAll("spid=" + spid);
		sp.setAuditdate(new Date());
		int supplyDetailStatus = 0;
		sp.setAnote(anote);
		sp.setAeid(aeid);
		// 判断审核结果，设置采购单状态
		if ("1".equals(auditResult)) {
			// 更新采购单主表状态
			sp.setStatus(3);// 采购单状态：0-草稿，1-提交，2-拒绝，3-审核通过
			// 更新采购单明细状态
			supplyDetailStatus = 1;
		} else if ("2".equals(auditResult)) {
			// 更新采购单主表状态
			sp.setStatus(2);// 采购单状态：0-草稿，1-提交，2-拒绝，3-审核通过
			// 更新采购单明细状态
			supplyDetailStatus = 0;
			// 更新采购单明细状态
		}
		for (Resource resource : supplyDetailList) {
			resource.setStatus(supplyDetailStatus);
			// 更新明细
			rsDao.doEdit(resource);
		}

		// 更新采购单主表及明细
		return spDao.doEdit(sp);

	}

	@Override
	public boolean auditReimbursement(String eid,String rbsid, String auditResult, String anote) throws Exception {
		Reimbursement reimbursement = reimDao.findById(new Long(rbsid));
		reimbursement.setAnote(anote);
		reimbursement.setStatus(Integer.parseInt(auditResult));
		reimbursement.setAeid(eid);
		return reimDao.doEdit(reimbursement);
	}
	
}
