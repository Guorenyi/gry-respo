package cn.mldn.eop.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;

import cn.mldn.eop.service.IEmpresourceService;
import cn.mldn.eop.service.IResourceDetailsService;
import cn.mldn.eop.service.IShopcarService;
import cn.mldn.eop.service.ResourceMgrService;
import cn.mldn.eop.vo.util.DictionaryUtil;
import cn.mldn.util.bean.WebUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;

@Controller 
@RequestMapping("/pages/back/admin/resource/*")
public class ResourcedetailsAction extends AbstractAction {
	@Autowired
	private IShopcarService shopcarService;
	@Autowired
	private ResourceMgrService resourceMgrService;
	@Autowired
	private IEmpresourceService empresourceService;
	@Autowired
	private IResourceDetailsService resourcedetailsService;
	
	@RequestMapping("resource_Details_list")
	public ModelAndView listDetails() throws Exception {
		if (WebUtil.getParameterValue("eresid") != null) {
			Long resid = Long.parseLong(WebUtil.getParameterValue("eresid")[0]);
			ModelAndView mav = new ModelAndView(super.getPage("resourcedetails.page"));
			mav.add("resourceStatus", DictionaryUtil.getDictionary("resourcestatus"));
			Map<String,Object> map = this.resourcedetailsService.findbyeresid(resid);
			mav.add("empresource",map.get("empresource"));
			mav.add("resourcedetails", map.get("resourcedetails"));
			return mav;
		} else {
			return super.parameterErrorPage("须指定申请单ID");
		}
	}
	
	@RequestMapping("Details_editamount")
	public void editamount() throws Exception {
		String eresids = WebUtil.getParameterValue("eresid")[0];
		String resids = WebUtil.getParameterValue("resid")[0];
		String amounts = WebUtil.getParameterValue("amount")[0];
		String moneys = WebUtil.getParameterValue("money")[0];
		long eresid = Long.parseLong(eresids);
		long resid = Long.parseLong(resids);
		int amount = Integer.parseInt(amounts);
		double money = Double.parseDouble(moneys);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("flag", this.resourcedetailsService.editbyid(eresid, resid, amount,money));
		super.print(JSON.toJSONString(result));
	}
	
	@RequestMapping("Details_delete")
	public void delete() throws Exception {
		String eresids = WebUtil.getParameterValue("eresid")[0];
		String resids = WebUtil.getParameterValue("resid")[0];
		Set<Long> sets = new HashSet<Long>();
		String splitreds [] = resids.split(";");
		for (int x=0;x<splitreds.length;x++) {
			sets.add(Long.parseLong(splitreds[x]));
			System.out.println(Long.parseLong(splitreds[x]));
		}
		long eresid = Long.parseLong(eresids);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("flag", this.resourcedetailsService.removebyid(eresid,sets));
		super.print(JSON.toJSONString(result));
	}
	
	@RequestMapping("Details_editempres")
	public void editempres() throws Exception {
		String eresids = WebUtil.getParameterValue("eresid")[0];
		String moneys = WebUtil.getParameterValue("money")[0];
		String amounts = WebUtil.getParameterValue("amount")[0];
		double money = Double.parseDouble(moneys);
		long eresid = Long.parseLong(eresids);
		int amount = Integer.parseInt(amounts);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("flag", this.resourcedetailsService.editnumber(eresid, amount, money));
		super.print(JSON.toJSONString(result));
	}
}
