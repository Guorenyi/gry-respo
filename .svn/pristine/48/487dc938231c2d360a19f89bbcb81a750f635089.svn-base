package cn.mldn.eop.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;

import cn.mldn.eop.service.IReimbursementDetailsService;
import cn.mldn.eop.service.IReimbursementService;
import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.Reimbursement;
import cn.mldn.eop.vo.ReimbursementDetails;
import cn.mldn.util.bean.WebUtil;
import cn.mldn.util.web.SplitPageUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;

@Controller
@RequestMapping("/pages/back/admin/reimbursement/*")
public class ReimbursementAction extends AbstractAction{
	public static final String ACTION_TITLE = "报销单" ;
	@Autowired
	private IReimbursementService reimbursementService;
	@Autowired
	private IReimbursementDetailsService reimbursementDetailsService;
	
	/**
	 * 报销单申请之前报销类型数据的显示
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("reimbursement_add_pre")
	public ModelAndView addPre()throws Exception{
		ModelAndView mav = new ModelAndView(super.getPage("add.page"));
		List<Dictionary> allType = this.reimbursementService.addPre();
		//System.out.println(allType);
		mav.add("allType", allType);
		return mav;
	}
	/**
	 * 报销单申请之前报销类型数据的显示
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("reimbursement_editPre")
	public ModelAndView editPre()throws Exception{
		ModelAndView mav = new ModelAndView(super.getPage("edit.page"));
		List<Dictionary> allType = this.reimbursementService.addPre();
		Reimbursement vo = this.reimbursementService.getById(WebUtil.getParameterValue("rbsid")[0]) ;
		mav.add("allType", allType);
		mav.add("vo", vo);
		return mav;
	}
	/**
	 * 进行报销单创建的增加
	 */
	@RequestMapping("reimbursement_add")
	public ModelAndView add()throws Exception{
		Reimbursement vo =WebUtil.assembleVO(Reimbursement.class);
		vo.setAeid((String)ServletObjectUtil.getRequest().getSession().getAttribute("eid"));
		vo.setCredate(new java.util.Date());
		vo.setStatus(0);
		ModelAndView mav = new ModelAndView(super.getForwardPage());
		if (this.reimbursementService.add(vo)) {
			super.setUrlAndMsg(mav, super.getPageKey("add.action"), "vo.add.success", ACTION_TITLE);

		}else {
			super.setUrlAndMsg(mav, super.getPageKey("add.action"), "vo.add.failure", ACTION_TITLE);
		}
		return mav ;
	}
	/**
	 * 进行报销单创建的增加
	 */
	@RequestMapping("add_details")
	public void list_add_re()throws Exception{
		ReimbursementDetails vo =WebUtil.assembleVO(ReimbursementDetails.class);
		super.print(this.reimbursementDetailsService.add(vo));
	}
	/**
	 * 报销项删除操作
	 */
	@RequestMapping("delete_details")
	public void delete_details() throws Exception{
		String ids = ServletObjectUtil.getRequest().getParameter("ids") ;
		Set<Long> reids = super.handleIdToLong(ids) ;
		long rbsid = Long.parseLong(WebUtil.getParameterValue("rbsid")[0]) ;
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("flag", this.reimbursementDetailsService.deleteR(reids,rbsid)) ;
		super.print(JSON.toJSONString(map));
	}
	/**
	 * 进行报销单创建的修改
	 */
	@RequestMapping("edit_details")
	public void edit_details()throws Exception{
		ReimbursementDetails vo =WebUtil.assembleVO(ReimbursementDetails.class);
		super.print(this.reimbursementDetailsService.edit(vo));
	}
	/**
	 * 进行报销单创建的增加
	 */
	@RequestMapping("edit_details_pre")
	public void edit_details_pre()throws Exception{
		String rbdid = WebUtil.getParameterValue("rbdid")[0] ;
		ReimbursementDetails vo = this.reimbursementDetailsService.getById(rbdid) ;
		Map<String,Object> map = new HashMap<>() ;
		map.put("vo", vo) ;
		super.print(JSON.toJSONString(map));
	}
	/**
	 * 进行报销单创建的修改
	 */
	@RequestMapping("reimbursement_edit")
	public ModelAndView edit()throws Exception{
		Reimbursement vo =WebUtil.assembleVO(Reimbursement.class);
		vo.setCredate(new java.util.Date());
		ModelAndView mav = new ModelAndView(super.getForwardPage());
		if (this.reimbursementService.edit(vo)) {
			super.setUrlAndMsg(mav, super.getPageKey("list.action"), "vo.edit.success", ACTION_TITLE);
			
		}else {
			super.setUrlAndMsg(mav, super.getPageKey("list.action"), "vo.edit.failure", ACTION_TITLE);
		}
		return mav ;
	}
	/**
	 * 进行报销单创建的修改
	 */
	@RequestMapping("reimbursement_editApply")
	public ModelAndView editApply()throws Exception{
		long id = Long.parseLong(WebUtil.getParameterValue("rbsid")[0]) ;
		ModelAndView mav = new ModelAndView(super.getForwardPage());
		String eid = (String) ServletObjectUtil.getRequest().getSession().getAttribute("eid") ;
		if (this.reimbursementService.editStatusById(id,eid)) {
			super.setUrlAndMsg(mav, super.getPageKey("list.action"), "vo.post.success", ACTION_TITLE);
			
		}else {
			super.setUrlAndMsg(mav, super.getPageKey("list.action"), "vo.post.failure", ACTION_TITLE);
		}
		return mav ;
	}
	
	/**
	 * 进行报销单的列表
	 */
	@RequestMapping("reimbursement_list")
	public ModelAndView list() throws Exception{
		ModelAndView mav = new ModelAndView(super.getPage("list.page"));
		String columnData = "名称:title|类型:item";
		SplitPageUtil spu = new SplitPageUtil(columnData, super.getPageKey("list.action"));
		Map<String, Object> map = this.reimbursementService.findBySplit(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(),
				spu.getKeyword());
		List<Dictionary> allType = this.reimbursementService.addPre();
		mav.add("allRecorders", map.get("allRecorders"));
		mav.add("allReims", map.get("allReims"));
		mav.add("allType", allType);
		return mav ;
	}
	/**
	 * 进行报销单的列表
	 */
	@RequestMapping("reimbursement_details_list")
	public ModelAndView details_list() throws Exception{
		ModelAndView mav = new ModelAndView(super.getPage("details.page"));
		Reimbursement vo = this.reimbursementService.getById(WebUtil.getParameterValue("rbsid")[0]) ;
		long id = Long.parseLong(WebUtil.getParameterValue("rbsid")[0]) ;
		List<ReimbursementDetails> allDetails = this.reimbursementDetailsService.listByRbsid(id) ;
		mav.add("vo", vo);
		mav.add("allDetails", allDetails);
		return mav ;
	}
	/**
	 * 进行报销单的删除
	 */
	@RequestMapping("reimbursement_delete")
	public ModelAndView delete() throws Exception{
		ModelAndView mav = new ModelAndView(getForwardPage());
		String ids = ServletObjectUtil.getRequest().getParameter("ids") ;
		String result[] = ids.split(",") ;
    	Set<Long> all = new HashSet<Long>() ;
    	for(int i = 0 ; i < result.length ;i++){
    		all.add(Long.parseLong(result[i])) ;
    	}
    	if(this.reimbursementService.deleteR(all)) {
    		super.setUrlAndMsg(mav, super.getPageKey("list.action"), "vo.delete.success", ACTION_TITLE);
    	}else {
    		super.setUrlAndMsg(mav, super.getPageKey("list.action"), "vo.delete.failure", ACTION_TITLE);
    	}
		return mav ;
	}
	
	
	
}
