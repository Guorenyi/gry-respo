package cn.mldn.eop.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import cn.mldn.eop.service.IPlanService;
import cn.mldn.eop.service.ISheduleService;
import cn.mldn.eop.vo.EmpLevel;
import cn.mldn.eop.vo.Plan;
import cn.mldn.util.web.SplitPageUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;

@Controller
@RequestMapping("/pages/back/admin/schedule/*")
public class SheduleAction  extends AbstractAction{
	@Autowired
	private ISheduleService scheduleService;
	@Autowired
	private IPlanService planService;
	/**
	 * 个人任务列表
	 * @return
	 */
//	@RequestMapping("schedule_list")
//	public ModelAndView list()throws Exception{
//		ModelAndView mav = new ModelAndView(super.getPage("schedule.list"));
//		String eid = "mldn-lisen";
//		mav.add("allSchdules", this.scheduleService.get(eid));
//		System.out.println(this.scheduleService.get(eid));
//		return mav;
//		
//	}
	
	
	/**
	 * 个人任务列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("schedule_list")
	public ModelAndView split() throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("schedule.list"));
		SplitPageUtil spu = new SplitPageUtil("任务名称:title|任务类型:item", super.getPageKey("list.action"));
		try {
			//String mid = "mldn-lisen";
			String eid = (String)ServletObjectUtil.getRequest().getSession().getAttribute("eid");
			mav.addMap(
					this.scheduleService.list(spu.getColumn(), spu.getKeyword(), spu.getCurrentPage(), spu.getLineSize(),eid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
//	@RequestMapping("schedule_details")
//	///pages/back/admin/schedule/schedule_details
//	public ModelAndView details(String pid)throws Exception{
//		System.out.println("**************"+pid);
//		ModelAndView mav = new ModelAndView(super.getPage("schedule.details"));
//		String eid = "mldn-lisen";
//		//mav.add("allSchdules", this.scheduleService.get(eid));
//		Map<String, Object> map = new HashMap<>();
//		map = this.planService.getDetails(Long.parseLong(pid));
//		Plan plan = (Plan) map.get("plan");
//		System.out.println(plan);
//		List<EmpLevel> allEmpLevelDept =(List<EmpLevel>)map.get("allEmpLevelDept");
//		
//		mav.add("plan", plan);
//		mav.add("allEmpLevelDept", allEmpLevelDept);
//		return mav;
//	}
	
	@RequestMapping("schedule_details")
	public void details(String pid)throws Exception{
		System.out.println("**************"+pid);
		String eid = "mldn-lisen";
		Map<String, Object> map = new HashMap<>();
		map = this.planService.getDetails(Long.parseLong(pid));
		super.print(JSON.toJSONString(map));
//		Plan plan = (Plan) map.get("plan");
//		System.out.println(plan);
//		List<EmpLevel> allEmpLevelDept =(List<EmpLevel>)map.get("allEmpLevelDept");
//		
//		mav.add("plan", plan);
//		mav.add("allEmpLevelDept", allEmpLevelDept);
//		return mav;
	}
	
}
