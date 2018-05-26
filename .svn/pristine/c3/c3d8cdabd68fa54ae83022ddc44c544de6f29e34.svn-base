package cn.mldn.eop.action;

import java.util.List;
import java.util.Map;

import cn.mldn.eop.service.IFinanceAuditService;
import cn.mldn.eop.service.IReimbursementDetailsService;
import cn.mldn.eop.service.IReimbursementService;
import cn.mldn.eop.service.ResourceMgrService;
import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.Empresource;
import cn.mldn.eop.vo.Reimbursement;
import cn.mldn.eop.vo.ReimbursementDetails;
import cn.mldn.eop.vo.Resource;
import cn.mldn.eop.vo.SupplyPurchase;
import cn.mldn.eop.vo.util.DictionaryUtil;
import cn.mldn.util.bean.WebUtil;
import cn.mldn.util.web.SplitPageUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;

@Controller
@RequestMapping("/pages/back/admin/finance/*")
public class FinanceAuditAction extends AbstractAction {
	@Autowired
	ResourceMgrService rsService;
	@Autowired
	IFinanceAuditService finService;
	@Autowired
	private IReimbursementService reimbursementService;
	@Autowired
	IReimbursementDetailsService reimbursementDetailsService;
	@RequestMapping("finance_supply_apply_list")
	public ModelAndView supplyAuditList() throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("list.page"));
		String url = "cn.mldn.eop.action.FinanceAuditAction.list.action";
		String columnData = "申请名称:title";
		SplitPageUtil spu = new SplitPageUtil(columnData, url);
		String searchKeyWord = parameterUtil.getSearchKeyWord();
		String searchCol = parameterUtil.getSearchCol();
		Map<String, Object> map;
		if (!"".equals(searchCol) && !"".equals(searchKeyWord)) {
			// 根据模糊查询条件获取数据
			map = rsService.findSupplyForAudit(spu.getCurrentPage(), spu.getLineSize(), searchCol, searchKeyWord);
		} else {
			map = rsService.findSupplyForAudit(spu.getCurrentPage(), spu.getLineSize());
		}
		List<SupplyPurchase> supplyList = (List<SupplyPurchase>) map.get("objectList");
		Long totalCount = (Long) map.get("totalCount");
		mav.add("supplyStatus", DictionaryUtil.getDictionary("supplystatus"));
		mav.add("supplyList", supplyList);
		mav.add("allRecorders", totalCount);
		return mav;
	}

	@RequestMapping("finance_supply_apply_handle")
	public ModelAndView detail() throws Exception {
		if (WebUtil.getParameterValue("spid") != null && WebUtil.getParameterValue("spid").length > 0) {
			Long spid = Long.parseLong(WebUtil.getParameterValue("spid")[0]);
			List<Resource> supplyDetailList = rsService.findSupplyDetails(spid);

			ModelAndView mav = new ModelAndView(super.getPage("handle.page"));
			mav.add("supplyStatus", DictionaryUtil.getDictionary("supplystatus"));
			SupplyPurchase sp = rsService.getById(spid.toString());
			mav.add("supply", sp);
			mav.add("spid", spid);
			mav.add("supplyDetailList", supplyDetailList);
			return mav;
		} else {
			return super.parameterErrorPage("须指定申请单ID");
		}
	}

	// 处理
	@RequestMapping("finance_supply_audit")
	public ModelAndView audit() throws Exception {
		// 获得前端数据
		String audit = WebUtil.getParameterValue("audit")[0];
		String spid = WebUtil.getParameterValue("spid")[0];
		String anote = WebUtil.getParameterValue("anote")[0];
		String aeid = ServletObjectUtil.getRequest().getSession().getAttribute("eid").toString();

		// 取出VO对象
		if (finService.auditSupply(aeid, spid, audit, anote)) {

			return supplyAuditList();

		} else {
			ModelAndView mav = new ModelAndView(super.getPage("handle.page"));
			SupplyPurchase sp = rsService.getById(spid.toString());
			List<Resource> supplyDetailList = rsService.findSupplyDetails(new Long(spid));

			mav.add("supply", sp);
			mav.add("spid", spid);
			mav.add("errorMsg", "审核失败！");
			mav.add("supplyDetailList", supplyDetailList);
			return mav;
		}
	}

	/**
	 * 进行报销单的列表
	 */
	
	@RequestMapping("finance_reimbursement_apply_list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("reimbursement.list.page"));
		String columnData = "名称:title|类型:item";
		SplitPageUtil spu = new SplitPageUtil(columnData, super.getPageKey("reimbursement.list.action"));
		Map<String, Object> map = this.reimbursementService.findAllSplitByStatus(spu.getCurrentPage(),
				spu.getLineSize(), spu.getColumn(), spu.getKeyword());
		List<Dictionary> allType = this.reimbursementService.addPre();
		mav.add("allRecorders", map.get("allRecorders"));
		mav.add("allReims", map.get("allReims"));
		mav.add("allType", allType);
		return mav;

	}
	
	@RequestMapping("finance_reimbursement_apply_handle")
	public ModelAndView Rdetail() throws Exception {
		if (WebUtil.getParameterValue("rbsid") != null && WebUtil.getParameterValue("rbsid").length > 0) {
			Long rbsid = Long.parseLong(WebUtil.getParameterValue("rbsid")[0]);
			ModelAndView mav = new ModelAndView(super.getPage("reimbursement.handle.page"));
			mav.add("status", DictionaryUtil.getDictionary("status"));
			Reimbursement rs=reimbursementService.getById(rbsid.toString());
			mav.add("reimbursement", rs);
			mav.add("rbsid", rbsid);
			System.out.println("reimbursementDetailsService.listByRbsid(rbsid)=="+reimbursementDetailsService.listByRbsid(rbsid));
			mav.add("reimbursementDetailList", reimbursementDetailsService.listByRbsid(rbsid));
			return mav;
		} else {
			return super.parameterErrorPage("须指定申请单ID");
		}
	}
	 //报销单审核提交：
	 @RequestMapping("finance_reimbursement_check")
	 public ModelAndView check() throws Exception {
	 //获得前端数据
	 String audit = WebUtil.getParameterValue("audit")[0];
	 String rbsid = WebUtil.getParameterValue("rbsid")[0];
	 String anote = WebUtil.getParameterValue("anote")[0];
	 String aeid=ServletObjectUtil.getRequest().getSession().getAttribute("eid").toString();
	
	
	 //取出VO对象
	 if(finService.auditReimbursement(rbsid,audit, rbsid, anote)) {
	 return list();
	
	 }else {
	 ModelAndView mav = new ModelAndView(super.getPage("reimbursement.handle.page"));
	 Reimbursement rs=reimbursementService.getById(rbsid.toString());
	 List<ReimbursementDetails> reimbursement = this.reimbursementDetailsService.listByRbsid(new Long(rbsid));
	
	 mav.add("reimbursement", rs);
	 mav.add("rbsid", rbsid);
	 mav.add("errorMsg", "审核失败！");
	 mav.add("reimbursement", reimbursement);
	 return mav;
	 }
	 }
	 
	 @RequestMapping("finance_reimbursement_audit")
		public ModelAndView finAudit() throws Exception {
			// 获得前端数据
			String audit = WebUtil.getParameterValue("audit")[0];
			String rbsid = WebUtil.getParameterValue("rbsid")[0];
			String note = WebUtil.getParameterValue("note")[0];
			String aeid = ServletObjectUtil.getRequest().getSession().getAttribute("eid").toString();

			// 取出VO对象
			if (finService.auditReimbursement(aeid, rbsid, audit, note)) {
				return list();
			} else {
				ModelAndView mav = new ModelAndView(super.getPage("resourceAudit.page"));
				Reimbursement rs=reimbursementService.getById(rbsid.toString());
				mav.add("reimbursement", rs);
				mav.add("rbsid", rbsid);
				mav.add("errorMsg","审核失败！");
				return mav;
			}

		}
}
