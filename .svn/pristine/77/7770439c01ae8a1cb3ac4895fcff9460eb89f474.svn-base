package cn.mldn.eop.action;

import java.util.List;

import cn.mldn.eop.action.abs.IBaseAction;
import cn.mldn.eop.service.IEmpresourceService;
import cn.mldn.eop.service.IResourceDetailsService;
import cn.mldn.eop.service.ResourceMgrService;
import cn.mldn.eop.vo.Empresource;
import cn.mldn.eop.vo.Resource;
import cn.mldn.eop.vo.SupplyPurchase;
import cn.mldn.eop.vo.util.DictionaryUtil;
import cn.mldn.util.bean.WebUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;

@Controller
@RequestMapping("/pages/back/admin/resource_audit/*")
public class ResourceAuditAction extends AbstractAction implements IBaseAction {
	@Autowired
	private IResourceDetailsService rdService;
	@Autowired
	private IEmpresourceService erService;
	@Autowired
	ResourceMgrService rsService;

	@Override
	public ModelAndView addPre() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView add() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView editPre() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView edit() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping("list")
	public ModelAndView list() throws Exception {
		// 取得所有提交状态的资源申请单
		List<Empresource> empResourceList = erService.findSubmitResourceApplyList();
		ModelAndView mav = new ModelAndView(super.getPage("list.page"));
		mav.add("itemList", DictionaryUtil.getDictionary("resourcestatus"));
		// 传入申请单Id去创建申请单明细
		mav.add("empResourceList", empResourceList);
		return mav;
	}

	@RequestMapping("audit_pre")
	public ModelAndView auditPre() throws Exception {

		Long eresid = 0L;
		if (WebUtil.getParameterValue("eresid") != null && WebUtil.getParameterValue("eresid").length > 0) {

			if (WebUtil.getParameterValue("eresid")[0] != null) {
				eresid = Long.parseLong(WebUtil.getParameterValue("eresid")[0]);
			}
			ModelAndView mav = new ModelAndView(super.getPage("resourceAudit.page"));
			Empresource empresource = erService.getById(eresid.toString());
			mav.add("Empresource", empresource);
			// 取得申请单明细
			mav.add("resourcedetails", rdService.findbyeresid(eresid).get("resourcedetails"));
			mav.add("itemList", DictionaryUtil.getDictionary("resourcestatus"));
			return mav;
		} else {
			return super.parameterErrorPage("无指定的明细ID");
		}

	}

	@RequestMapping("audit")
	public ModelAndView audit() throws Exception {
		// 获得前端数据
		String audit = WebUtil.getParameterValue("audit")[0];
		String eresid = WebUtil.getParameterValue("eresid")[0];
		String note = WebUtil.getParameterValue("note")[0];
		String aeid = ServletObjectUtil.getRequest().getSession().getAttribute("eid").toString();

		// 取出VO对象
		if (rsService.auditResource(aeid, eresid, audit, note)) {
			return list();
		} else {
			ModelAndView mav = new ModelAndView(super.getPage("resourceAudit.page"));
			Empresource empresource = erService.getById(eresid.toString());
			mav.add("Empresource", empresource);
			// 取得申请单明细
			mav.add("resourcedetails", rdService.findbyeresid(new Long(eresid)).get("resourcedetails"));
			mav.add("itemList", DictionaryUtil.getDictionary("resourcestatus"));
			mav.add("errorMsg","审核失败！");
			return mav;
		}

	}

}
