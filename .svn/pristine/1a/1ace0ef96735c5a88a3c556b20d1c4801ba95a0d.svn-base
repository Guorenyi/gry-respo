package cn.mldn.eop.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;

import cn.mldn.eop.service.IPlanDetailsService;
import cn.mldn.eop.service.IPlanService;
import cn.mldn.eop.vo.Dept;
import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.Emp;
import cn.mldn.eop.vo.EmpLevel;
import cn.mldn.eop.vo.Plan;
import cn.mldn.eop.vo.PlanDetails;
import cn.mldn.util.bean.WebUtil;
import cn.mldn.util.web.SplitPageUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;
@Controller
@RequestMapping("/pages/back/admin/plan/*")
public class PlanAction extends AbstractAction  {
	//getpage是获取value
	//getpagekey是获取value
	
	public static final String ACTION_TITLE = "任务" ;
	@Autowired
	private IPlanService planService;
	
	@Autowired 
	private IPlanDetailsService planDetailsService;
	
	/**
	 * 添加之前任务类型数据的列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("plan_add_pre")
	public ModelAndView addPre() throws Exception {
		//super.print(JSON.toJSONString(this.cityService.listByProvince(pid)));
		ModelAndView mav = new ModelAndView(super.getPage("add.page")) ;
//		Map<String, Object> map = new HashMap<>();
//		map.put("allPlanDictoryes",this.planService.addPre());
//		mav.addMap(map);
		//super.print(JSON.toJSONString(this.planService.addPre()));
		
		List<Dictionary> all = this.planService.addPre();
		//super.print(all);
		//System.out.println(all);
		mav.add("all", all);
		return mav;
	}

	/**
	 * 添加任务
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("plan_add")
	public ModelAndView add() throws Exception {
		//Plan vo =WebUtil.assembleVO(Plan.class);
		
		Plan vo = new Plan();
		vo.setTitle(ServletObjectUtil.getRequest().getParameter("title"));
		vo.setItem(ServletObjectUtil.getRequest().getParameter("item"));
		String starttime = ServletObjectUtil.getRequest().getParameter("starttime");
		SimpleDateFormat starttimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date startdate = starttimeFormat.parse(starttime);
		vo.setStarttime(new Date(startdate.getTime()));
		
		String endtime = ServletObjectUtil.getRequest().getParameter("endtime");
		SimpleDateFormat endtimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date enddate = endtimeFormat.parse(endtime);
		vo.setEndtime(new Date(enddate.getTime()));

		//System.out.println(vo);
		ModelAndView mav = new ModelAndView(super.getForwardPage());
		if (this.planService.add(vo)) {
			super.setUrlAndMsg(mav, super.getPageKey("add.action"), "vo.add.success", ACTION_TITLE);

		}else {
			super.setUrlAndMsg(mav, super.getPageKey("add.action"), "vo.add.failure", ACTION_TITLE);
		}
		return mav ;
	}

	public ModelAndView editPre() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public ModelAndView edit() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 任务删除
	 * @param ids
	 * @throws Exception
	 */
	@RequestMapping("plan_delete")
	public void delete(String ids) throws Exception {
		System.out.println(ids);
		Set<Long> pids = super.handleIdToLong(ids) ; // 进行ids的数据处理
		Map<String,Object> result = new HashMap<String,Object>() ;
		result.put("flag", this.planService.delete(pids)) ;
		super.print(JSON.toJSONString(result));
	} 

	/**
	 * 任务列表
	 * @return
	 * @throws Exception
	 */
	//注意所有的getPageKey获取的要改变方式`
	@RequestMapping("plan_list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("list.page"));
		SplitPageUtil spu = new SplitPageUtil("任务名称:title|任务类型:item", super.getPageKey("list.action"));
		try {
			mav.addMap(
					this.planService.list(spu.getColumn(), spu.getKeyword(), spu.getCurrentPage(), spu.getLineSize()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	/**
	 * 任务发布
	 * @param pid
	 * @throws Exception
	 */
	@RequestMapping("plan_publish")
	public void publish(Long pid) throws Exception{
		boolean flag = true ;
		if (this.planService.editPublish(pid)) {
			super.print(JSON.toJSONString(flag));
		}	
	}
	
	/**
	 * 任务详情
	 * @param pid
	 * @param did
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("plan_details")
	public ModelAndView details(String pid,String did)throws Exception{
		ModelAndView mav = new ModelAndView(super.getPage("details.page"));
		Map<String, Object> map = new HashMap<>();
		map = this.planService.getDetails(Long.parseLong(pid));
		Plan plan = (Plan) map.get("plan");
		List<Dept>  allDepts = (List<Dept>)map.get("allDepts");
		List<EmpLevel>  allEmpLevels = (List<EmpLevel>)map.get("allEmpLevels");
		List<Emp> allEmps = (List<Emp>)map.get("allEmps");
		List<EmpLevel> allEmpLevelDept =(List<EmpLevel>)map.get("allEmpLevelDept");		
		mav.add("plan", plan);
		mav.add("allDepts", allDepts);
		mav.add("allEmpLevels", allEmpLevels);
		mav.add("allEmps", allEmps);
		mav.add("allEmpLevelDept", allEmpLevelDept);
		mav.add("pid", pid);
		//mav.addMap(this.planService.getAllEmpDept();
		return mav;
	}
	
	/**
	 * 分页action
	 * @param did
	 * @param currentPage
	 * @param lineSize
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("plan_details_modal")
	public ModelAndView detailsModal(String did, String currentPage, String lineSize)throws Exception{
		ModelAndView mav = new ModelAndView(super.getPage("modal.page"));
		SplitPageUtil spu = new SplitPageUtil("", super.getPageKey("modal.page.action"));
		if(did==null) {
			try {
				mav.addMap(
						this.planService.getAllEmpDept(null, spu.getCurrentPage(), spu.getLineSize()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			Long didd = Long.parseLong(did);
			try {
				mav.addMap(
						this.planService.getAllEmpDept(didd, spu.getCurrentPage(), spu.getLineSize()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return mav;
//		Map<String, Object> map = this.planService.getAllEmpDept(did,currentPage, lineSize);
//		List<Dept> allDepts = (List<Dept>)map.get("allDepts");
//		List<EmpLevel> allEmpLevels = (List<EmpLevel>)map.get("allEmpLevels");
//		System.out.println(allEmpLevels);
//		//System.out.println(allDepts);
//		//mav.add("allDepts", allDepts);
//		mav.add("allEmpLevels", allEmpLevels);
//	
//		return mav;
	}
	
	/**
	 * 列出所有的部门信息
	 * @param did
	 * @throws Exception
	 */
	@RequestMapping("plan_list_dept")
	public void listByDept(String did)throws Exception{
		if (did==null||"".equals(did)||did=="0") {
			super.print(JSON.toJSONString(this.planService.getDetailsDept(null)));
		}else {
			super.print(JSON.toJSONString(this.planService.getDetailsDept(Long.parseLong(did))));
		}
		
	}
	
	/**
	 * 添加任务人员
	 * @param eid
	 * @param pid
	 * @throws Exception
	 */
	
	@RequestMapping("plan_add_emp")
	public void  addEmpPlan(String eid,String pid)throws Exception{
		System.out.println(eid+"\t"+pid);
		PlanDetails vo = new PlanDetails();
		vo.setEid(eid);
		vo.setPid(Long.parseLong(pid));
		super.print(JSON.toJSONString(this.planDetailsService.add(vo)));
		//System.out.println(vo);
		//return this.planDetailsService.add(vo);
	}
	
	/**
	 * 删除任务人员
	 * @param eid
	 * @param pid
	 * @throws Exception
	 */
	
	@RequestMapping("plan_delete_emp")
	public void  deleteEmpPlan(String eid,String pid)throws Exception{
		//System.out.println(eid+"\t"+pid);
		PlanDetails vo = new PlanDetails();
		vo.setEid(eid);
		vo.setPid(Long.parseLong(pid));
		super.print(JSON.toJSONString(this.planDetailsService.delete(vo)));
		//传递更改后数据库中 的人数
		//super.print(JSON.toJSONString(this.planService.getPlan(Long.parseLong(pid))));
		//return this.planDetailsService.delete(vo);
	}
	
	/**
	 * 人员信息
	 * @param eid
	 * @throws Exception
	 */
	@RequestMapping("plan_emp")
	//ttp://localhost/eop/pages/back/admin/plan/plan_emp_list.action?pid=1
	public void  empInfo(String eid)throws Exception{
		//System.out.println(eid);
		super.print(JSON.toJSONString(this.planService.findEmpLevel(eid)));
		//return null;
		//return JSON.toJSONString(this.planService.findEmpLevel(eid));
	}
}
