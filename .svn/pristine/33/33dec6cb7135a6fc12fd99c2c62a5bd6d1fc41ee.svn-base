package cn.mldn.eop.action;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import cn.mldn.eop.action.abs.IBaseAction;
import cn.mldn.eop.service.ResourceMgrService;
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
@RequestMapping("/pages/back/admin/supply/*")
public class ResourceMgrAction extends AbstractAction implements IBaseAction {
	@Autowired
	ResourceMgrService rsService;

	@Override
	public ModelAndView addPre() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	 * 增加采购申请单
	 */
	@Override
	@RequestMapping("supply_add")
	public ModelAndView add() throws Exception {
		SupplyPurchase vo = WebUtil.assembleVO(SupplyPurchase.class);
		String eid = ServletObjectUtil.getRequest().getSession().getAttribute("eid").toString();
		vo.setEid(eid);
		Long newKeyId = rsService.add(vo, true);
		if (newKeyId > 0) {
			ModelAndView mav = new ModelAndView(super.getPage("goodsAdd.page"));
			// 传入申请单Id去创建申请单明细
			mav.add("spid", newKeyId);
			mav.add("itemList", DictionaryUtil.getDictionary("resource"));
			return mav;
		} else {
			ServletObjectUtil.getRequest().setAttribute("msg", "申请增加失败！");
			return new ModelAndView("/pages/back/admin/supply/supply_apply_add.jsp");
		}
 
	}
	/**
	 * 提交采购申请单
	 * @return 提交成功进入申请单列表页面，否则进入原页面
	 * @throws Exception
	 */
	@RequestMapping("supply_submit")
	public ModelAndView supplySubmit() throws Exception {
		String spid = WebUtil.getParameterValue("spid")[0];
		int resultFlag = rsService.submitSupply(spid);
		super.print(resultFlag);
		if (resultFlag == 1) { 
			// 提交成功进入明细列表页面
			return this.list();
	//		String url= "/pages/back/admin/supply/supply_details_list.jsp?random="+Math.random();
		//	System.out.println("url==="+url);  
//			ModelAndView mav = new ModelAndView(url);//使用random使页面刷新 
//			List<Resource> supplyDetailList = rsService.findSupplyDetails(new Long(spid));
//			SupplyPurchase sp = rsService.getById((spid));
//			mav.add("supply",sp);
//			mav.add("supplyStatus", DictionaryUtil.getDictionary("supplystatus"));
//			mav.add("spid", spid);
//			mav.add("supplyDetailList", supplyDetailList);
//			return mav;
		} else {
			// 提交 失败，则返回原页面
			String url= "/pages/back/admin/supply/supply_details_list.jsp?random="+Math.random();
			ModelAndView mav = new ModelAndView(url);
			List<Resource> supplyDetailList = rsService.findSupplyDetails(new Long(spid));
			mav.add("spid", spid);
			mav.add("supplyDetailList", supplyDetailList);
			mav.add("saveMsg", "该申请单不是草稿状态,不能提交！");
			return mav;
	}
 
	}
	/**
	 * 采购申请提交时检查是否可以提交申请单
	 * @return 2:表示非草稿状态，不能提交
	 * 			0:表示无明细，不能提交
	 * 			1:表示可以正常提交
	 * @throws Exception
	 */
	@RequestMapping("supply_submit_check")
	public void supplySubmitCheck() throws Exception {
		String spid = WebUtil.getParameterValue("spid")[0];
		int resultFlag =1;
		
		//检查状态是否可以提交申请
		if(!rsService.canUpdateResource(spid.toString())) {
			resultFlag=2;
		}
		if(rsService.findSupplyDetails(Long.parseLong(spid)).size()==0){
			resultFlag=0;
		}
		super.print(resultFlag);
	}
	

	/**
	 * 删除指定申请单页面下的明细数据
	 * @throws Exception
	 */
	@RequestMapping("supply_goods_delete")
	public void goods_delete() throws Exception {
		String spid = WebUtil.getParameterValue("spid")[0];
		String resids = WebUtil.getParameterValue("resid")[0];
		String[] residArr = resids.split(";");
		Set<String> residSet = new HashSet<String>();
		for (String resid : residArr) {
			residSet.add(resid);
		}
		int resultFlg = 0;
		if (residSet != null && residSet.size() > 0 && !"".equals(spid)) {
			resultFlg = rsService.deleteResource(spid, residSet);
		}
		super.print(resultFlg);
	}

	/**
	 * 为申请单明细增加数量
	 * @throws Exception
	 */
	@RequestMapping("supply_goods_appendQty")
	public void goodsAppendQty() throws Exception {
		String resids = WebUtil.getParameterValue("resid")[0];
		String appendQty = WebUtil.getParameterValue("appendQty")[0];

		super.print(rsService.appendResourceQty(Long.parseLong(resids), Integer.parseInt(appendQty)));
	}

	@RequestMapping("supply_goods_add_pre")
	public ModelAndView goods_add_pre() throws Exception {
		if (WebUtil.getParameterValue("spid") != null && WebUtil.getParameterValue("spid").length > 0) {
			
		ModelAndView mav = new ModelAndView(super.getPage("goodsAdd.page"));
		mav.add("spid", WebUtil.getParameterValue("spid")[0]);
		mav.add("itemList", DictionaryUtil.getDictionary("resource"));
		return mav;
		}else {
			return super.parameterErrorPage("无指定的购物申请单ID");
		}

	}

	/**
	 * 增加申请单明细
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("supply_goods_add")
	public ModelAndView goods_add() throws Exception {
		Resource vo = WebUtil.assembleVO(Resource.class);
		String photoPath = WebUtil.getParameterValue("photo")[0];
		int resultFlag = rsService.addResource(vo);
		if (resultFlag == 1) {
			// 增加成功进入明细列表页面
			ModelAndView mav = new ModelAndView(super.getPage("detaillist.page")); 
			List<Resource> supplyDetailList = rsService.findSupplyDetails(vo.getSpid());
			SupplyPurchase sp = rsService.getById((vo.getSpid().toString()));
			mav.add("supply",sp);
			mav.add("spid", vo.getSpid());
			mav.add("supplyStatus", DictionaryUtil.getDictionary("supplystatus"));
			mav.add("supplyDetailList", supplyDetailList); 
			return mav;
		} else {
			// 增加失败，则返回原页面
			ModelAndView mav = new ModelAndView(super.getPage("goodsAdd.page"));
			mav.add("resource", vo);
			mav.add("itemList", DictionaryUtil.getDictionary("resource"));
			mav.add("saveMsg", "该申请单不是草稿状态,不能增加！");
			return mav;
		}

	}

	/**
	 * 编辑申请单明细数据前获得明细数据，及取得所需的基础数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("supply_goods_edit_pre")
	public ModelAndView goods_edit_pre() throws Exception {
		Long goodsId = 0L;
		if (WebUtil.getParameterValue("resid") != null && WebUtil.getParameterValue("resid").length > 0) {
			
		if (WebUtil.getParameterValue("resid")[0] != null) {
			goodsId = Long.parseLong(WebUtil.getParameterValue("resid")[0]);
		}
		ModelAndView mav = new ModelAndView(super.getPage("goodsEdit.page"));
		Resource resource = rsService.getResourceById(goodsId);
		mav.add("resource", resource);
		SupplyPurchase sp = rsService.getById(resource.getSpid().toString());
		mav.add("itemList", DictionaryUtil.getDictionary("resource"));
		mav.add("supplyStatus",sp.getStatus());
		return mav;
		} else {
			return super.parameterErrorPage("无指定的明细ID");
		} 
		
	}

	/**
	 * 编辑申请单明细数据
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("supply_goods_edit")
	public ModelAndView goods_edit() throws Exception {
		Resource vo = WebUtil.assembleVO(Resource.class);
		int resultFlag = rsService.editResource(vo);
		if (resultFlag == 1) {
			// 编辑成功进入明细列表页面
			ModelAndView mav = new ModelAndView(super.getPage("detaillist.page"));
			List<Resource> supplyDetailList = rsService.findSupplyDetails(vo.getSpid());
			SupplyPurchase sp = rsService.getById((vo.getSpid().toString()));
			mav.add("supply",sp);
			mav.add("supplyStatus", DictionaryUtil.getDictionary("supplystatus"));
			mav.add("spid", vo.getSpid());
			mav.add("supplyDetailList", supplyDetailList);
			return mav;
		} else {
			// 编辑失败，则返回原页面
			ModelAndView mav = new ModelAndView(super.getPage("goodsEdit.page"));
			mav.add("resource", vo);
			mav.add("itemList", DictionaryUtil.getDictionary("resource"));
			mav.add("saveMsg", "该申请单已提交或审核通过,不能修改！");
			return mav;
		}

	}
	
	/**
	 * 采购申请单明细列表页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("supply_detail_list")
	public ModelAndView listSupplyDetail() throws Exception {

		if (WebUtil.getParameterValue("spid") != null && WebUtil.getParameterValue("spid").length > 0) {
			Long spid = Long.parseLong(WebUtil.getParameterValue("spid")[0]);
			List<Resource> supplyDetailList = rsService.findSupplyDetails(spid);
			
			ModelAndView mav = new ModelAndView(super.getPage("detaillist.page"));
			mav.add("supplyStatus", DictionaryUtil.getDictionary("supplystatus"));
			SupplyPurchase sp = rsService.getById(spid.toString());
			mav.add("supply",sp);
			mav.add("spid", spid);
			mav.add("supplyDetailList", supplyDetailList);
			return mav;
		} else {
			return super.parameterErrorPage("须指定申请单ID");
		}
	}
   /**
	 * 资源库存页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("supply_goods_list")
	public ModelAndView listSupplyGoods() throws Exception {
		// /pages/back/admin/supply/supply_details_list.jsp
		ModelAndView mav = new ModelAndView(super.getPage("goodslist.page"));
		String url = "cn.mldn.eop.action.ResourceMgrAction.goodslist.action";
		String columnData = "办公用品名称:title|用品类型:itemtype"; 
		SplitPageUtil spu = new SplitPageUtil(columnData, url);
		String searchCol = parameterUtil.getSearchCol();
		// WebUtil.getParameterValue("col")
		String searchKeyWord = parameterUtil.getSearchKeyWord();
		Map<String, Object> map;
		if (!"".equals(searchCol) && !"".equals(searchKeyWord)) {
			if("itemtype".equalsIgnoreCase(searchCol)) {
				switch (searchKeyWord) {
				case "文具":
					searchKeyWord="1";
					break;
				case "耗材":
					searchKeyWord="2";
					break;
				case "硬件":
					searchKeyWord="3";
					break;
				}
			}
			// 根据模糊查询条件获取数据
			map = rsService.findAvibGoodsSplit(spu.getCurrentPage(), spu.getLineSize(), searchCol, searchKeyWord);
		} else {
			map = rsService.findAvibGoodsSplit(spu.getCurrentPage(), spu.getLineSize());
		}
		List<Resource> supplyList = (List<Resource>) map.get("objectList");
		Long totalCount = (Long) map.get("totalCount");
		mav.add("itemList", DictionaryUtil.getDictionary("resource"));
		mav.add("supplyDetailList", supplyList);
		mav.add("allRecorders", totalCount);
		return mav;
	
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

	/**
	 * 检查申请单状态
	 * @throws Exception
	 */
	@RequestMapping("supply_status_check")
	public void checkSupplyStatus() throws Exception {
		String spid = WebUtil.getParameterValue("spid")[0];
		super.print(rsService.canUpdateResource(spid.toString()));

	}
	
	/* *
	 * 申请单列表页面
	 */
	@RequestMapping("supply_list")
	public ModelAndView list() throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView(super.getPage("list.page"));
		String url = "cn.mldn.eop.action.ResourceMgrAction.list.action";
		String columnData = "申请名称:title";
		SplitPageUtil spu = new SplitPageUtil(columnData, url);
		String searchCol = parameterUtil.getSearchCol();
		// WebUtil.getParameterValue("col")
		String searchKeyWord = parameterUtil.getSearchKeyWord();

		Map<String, Object> map;
		if (!"".equals(searchCol) && !"".equals(searchKeyWord)) {
			// 根据模糊查询条件获取数据
			map = rsService.findBySplit(spu.getCurrentPage(), spu.getLineSize(), searchCol, searchKeyWord);
		} else {
			map = rsService.findBySplit(spu.getCurrentPage(), spu.getLineSize());
		}
		List<SupplyPurchase> supplyList = (List<SupplyPurchase>) map.get("objectList");
		Long totalCount = (Long) map.get("totalCount");
		mav.add("supplyStatus", DictionaryUtil.getDictionary("supplystatus"));
		mav.add("supplyList", supplyList);
		mav.add("allRecorders", totalCount);
		return mav;
	}

}
