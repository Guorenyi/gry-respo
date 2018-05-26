package cn.mldn.eop.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;

import cn.mldn.eop.service.IEmpresourceService;
import cn.mldn.eop.service.IShopcarService;
import cn.mldn.eop.service.ResourceMgrService;
import cn.mldn.eop.vo.Empresource;
import cn.mldn.eop.vo.Resource;
import cn.mldn.eop.vo.Shopcar;
import cn.mldn.util.bean.WebUtil;
import cn.mldn.util.web.SplitPageUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;
@Controller 
@RequestMapping("/pages/back/admin/resource/*")
public class ShopcarAction extends AbstractAction {
	@Autowired
	private IShopcarService shopcarService;
	@Autowired
	private ResourceMgrService resourceMgrService;
	@Autowired
	private IEmpresourceService empresourceService;
	
	@RequestMapping("shopcar_add")
	public void add() throws Exception {
		String userid=ServletObjectUtil.getRequest().getSession().getAttribute("eid").toString();
		Shopcar car = WebUtil.assembleVO(Shopcar.class);
		Map<String,Object> result = new HashMap<String,Object>();
		car.setEid(userid);
		Resource resource = resourceMgrService.getResourceById(car.getResid());
		car.setTitle(resource.getTitle());
		car.setPrice(resource.getPrice());
		car.setPhoto(resource.getPhoto());
		car.setAmount(1);
		result.put("flag", this.shopcarService.add(car));
		super.print(JSON.toJSONString(result));
	}	
	
	@RequestMapping("Resource_list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("list.page"));
		String columnData="名称:title";
		String url="cn.mldn.eop.action.ShopcarAction.list.action";
		SplitPageUtil spu = new SplitPageUtil(columnData,url);
		String searchCol = parameterUtil.getSearchCol();
		String searchKeyWord = parameterUtil.getSearchKeyWord();
		Map<String,Object> map;
		if (!"".equals(searchCol) && !"".equals(searchKeyWord)) {
			map = resourceMgrService.findAvibGoodsSplit(spu.getCurrentPage(), spu.getLineSize(), searchCol,searchKeyWord);
		} else {
			map = resourceMgrService.findAvibGoodsSplit(spu.getCurrentPage(), spu.getLineSize());
		}
		List<Resource> resourceList = (List<Resource>) map.get("objectList");
		Long totalCount = (Long) map.get("totalCount");
		mav.add("resourcelist",resourceList );
		mav.add("allRecorders",totalCount);
		return mav;
	}
	
	@RequestMapping("shopcar_list")
	
	public ModelAndView shopcarlist() throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("shoplist.page"));
		String userid=ServletObjectUtil.getRequest().getSession().getAttribute("eid").toString();
		mav.addMap(this.shopcarService.list(userid));
		return mav;
	}
	
	public Set<Long> handleIdToLong(String id) {
		if (id == null || "".equals(id)) {
			return null;
		}
		Set<Long> result = new HashSet<Long>();
		String splitStr [] = id.split(";");
		for (int x=0;x<splitStr.length;x++) {
			result.add(Long.parseLong(splitStr[x]));
		}
		return result;
	}
	@RequestMapping("shopcar_remove")
	public void remove(String ids) throws Exception{
		String userid=ServletObjectUtil.getRequest().getSession().getAttribute("eid").toString();
		Set<Long> resid = super.handleIdToLong(ids);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("flag", this.shopcarService.delete(userid,resid));
		super.print(JSON.toJSONString(result));
	}
	
	@RequestMapping("shopcar_edit")
	public void edit() throws Exception {
		Shopcar car = WebUtil.assembleVO(Shopcar.class);
		String userid=ServletObjectUtil.getRequest().getSession().getAttribute("eid").toString();
		car.setEid(userid);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("flag", this.shopcarService.editAmount(car));
		super.print(JSON.toJSONString(result));
	}
	
	@RequestMapping("empresource_add")
	public void empresadd() throws Exception {
		Empresource empres = WebUtil.assembleVO(Empresource.class);
		String userid=ServletObjectUtil.getRequest().getSession().getAttribute("eid").toString();
		Map<String,Object> result = new HashMap<String,Object>();
		empres.setEid(userid);
		result.put("flag", this.empresourceService.add(empres));
		super.print(JSON.toJSONString(result));
	}	
}
