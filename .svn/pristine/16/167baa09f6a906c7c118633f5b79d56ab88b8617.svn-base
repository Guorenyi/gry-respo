package cn.mldn.eop.action;

import java.util.List;
import java.util.Map;

import cn.mldn.eop.service.IEmpresourceService;
import cn.mldn.eop.vo.Empresource;
import cn.mldn.eop.vo.util.DictionaryUtil;
import cn.mldn.util.web.SplitPageUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;
@Controller 
@RequestMapping("/pages/back/admin/resource/*")
public class EmpresourceAction extends AbstractAction {
	@Autowired
	private IEmpresourceService empresourceService;
	
	
	@RequestMapping("empresource_list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("empresource.page"));
		String userid=ServletObjectUtil.getRequest().getSession().getAttribute("eid").toString();
		String columnData = "雇员编号:eid";
		String url="cn.mldn.eop.action.EmpresourceAction.empresource.action";
		SplitPageUtil spu = new SplitPageUtil(columnData,url);
		String searchCol = parameterUtil.getSearchCol();
		String searchKeyWord = parameterUtil.getSearchKeyWord();
		Map<String,Object> map = empresourceService.findSplit(spu.getCurrentPage(), spu.getLineSize(),userid);
		List<Empresource> resourceList = (List<Empresource>) map.get("objectList");
		Long totalCount = (Long) map.get("totalCount");
		mav.add("empresourcelist", resourceList);
		mav.add("allRecorders", totalCount);
		mav.add("resourceStatus", DictionaryUtil.getDictionary("resourcestatus"));
		return mav;
	}
}
