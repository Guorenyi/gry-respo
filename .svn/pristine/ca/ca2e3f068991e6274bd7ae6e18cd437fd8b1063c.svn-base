package cn.mldn.eop.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;

import cn.mldn.eop.service.IEmpCareerService;
import cn.mldn.eop.service.IEmpEducationService;
import cn.mldn.eop.service.IEmpService;
import cn.mldn.eop.vo.Emp;
import cn.mldn.eop.vo.EmpCareer;
import cn.mldn.eop.vo.EmpEducation;
import cn.mldn.eop.vo.EmpLevel;
import cn.mldn.util.bean.WebUtil;
import cn.mldn.util.encrypt.EncryptUtil;
import cn.mldn.util.web.SplitPageUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;

@Controller
@RequestMapping("/pages/back/admin/emp/*")
public class EmpAction extends AbstractAction {
	@Autowired
	private IEmpService empService;
	@Autowired
	private IEmpEducationService empEducationService ;
	@Autowired
	private IEmpCareerService empCareerService ;
	/**
	 * 雇员增加前需要查询所有的部门以及职位信息<br>
	 * <li>key=allDepts,value=所有部门信息</li>
	 * <li>key=addLevels,value=所有职位信息</li>
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("emp_add_pre")
	public ModelAndView addPre() throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("add.page"));
		Map<String, Object> map = this.empService.addPre();
		mav.add("allDepts", map.get("allDepts"));
		mav.add("allLevels", map.get("allLevels"));
		return mav;
	}

	/**
	 * 异步判断输入的eid是否已经存在，存在返回true，否则返回false
	 * @throws Exception
	 */
	@RequestMapping("check_eid")
	public void check_eid() throws Exception {
		Emp vo = WebUtil.assembleVO(Emp.class);
		super.print(this.empService.getById(vo.getEid()) == null);
	}

	/**
	 * 异步查询当前工资是否符合当前工资等级
	 * @throws Exception
	 */
	@RequestMapping("check_salary")
	public void check_salary() throws Exception {
		Emp vo = WebUtil.assembleVO(Emp.class) ;
		super.print(this.empService.findSalary(vo.getLid(), vo.getSalary()));
	}

	/**
	 * 雇员信息的增加操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("emp_add")
	public ModelAndView add() throws Exception {
		ModelAndView mav = new ModelAndView(getForwardPage());
		Emp vo = WebUtil.assembleVO(Emp.class) ;
		vo.setPassword(EncryptUtil.encrypt(vo.getPassword()));
		vo.setHiredate(new Date());
		vo.setStatus(0);
		String ss = (String) ServletObjectUtil.getRequest().getSession().getAttribute("eid") ;
		vo.setIneid(ss);
		if (this.empService.add(vo)) {
//			System.out.println(vo);
			super.setUrlAndMsg(mav, super.getPageKey("add.page"), "vo.add.success", "雇员");
		} else {
			super.setUrlAndMsg(mav, super.getPageKey("add.page"), "vo.add.failure", "雇员");
		}
		return mav;
	}

	/**
	 * 分页显示所有雇员信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("emp_list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("list.page"));
		String columnData = "姓名:ename";
		SplitPageUtil spu = new SplitPageUtil(columnData, super.getPageKey("list.action"));
		Map<String, Object> map = this.empService.findBySplit(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(),
				spu.getKeyword());
		mav.add("allRecorders", map.get("allRecorders"));
		mav.add("allEmps", map.get("allEmps"));
		mav.add("allDepts", map.get("allDepts"));
		mav.add("allLevels", map.get("allLevels"));
		return mav;
	}
	
	/**
	 * 雇员增加前需要查询所有的部门以及职位信息<br>
	 * <li>key=allDepts,value=所有部门信息</li>
	 * <li>key=addLevels,value=所有职位信息</li>
	 * <li>key=emp,value=当前雇员信息</li>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("emp_edit_pre")
	public ModelAndView editPre(String eid) throws Exception {
		ModelAndView mav = new ModelAndView(super.getPage("edit.page"));
		Map<String, Object> map = this.empService.editPre(eid) ;
		mav.add("allDepts", map.get("allDepts"));
		mav.add("allLevels", map.get("allLevels"));
		mav.add("emp", map.get("emp"));
		return mav;
	}
	
	/**
	 * 雇员信息的修改操作
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("emp_edit")
	public ModelAndView edit() throws Exception {
		System.out.println("***********ss****");
		ModelAndView mav = new ModelAndView(getForwardPage());
		Emp vo = WebUtil.assembleVO(Emp.class) ;
		System.out.println("***********sss****");
		Emp oldEmp = this.empService.getById(vo.getEid()) ;
		vo.setPassword(EncryptUtil.encrypt(vo.getPassword()));
		String ss = (String) ServletObjectUtil.getRequest().getSession().getAttribute("eid") ;
		vo.setIneid(ss);
//		System.out.println("*******vovovo******" + vo);
		if(vo.getPhoto() == null) {
			vo.setPhoto(oldEmp.getPhoto());
		}else {
			vo.setPhoto(vo.getPhoto());
		}
		System.out.println("*************vo**" + vo);
		System.out.println("*************oldEmp**" + oldEmp);
		if (this.empService.edit(vo)) {
			super.setUrlAndMsg(mav, super.getPageKey("list.action"), "vo.edit.success", "雇员");
		} else {
			super.setUrlAndMsg(mav, super.getPageKey("list.action"), "vo.edit.failure", "雇员");
		}
		return mav;
	}
	/**
	 * 列出所有教育背景信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("emp_edu_list")
	public ModelAndView list_edu() throws Exception{
		Map<String,Object> map = this.empEducationService.findAllByDicType() ;
		ModelAndView mav = new ModelAndView(super.getPage("list.edu.page")) ;
		String eid = ServletObjectUtil.getRequest().getParameter("eid") ;
		mav.add("empEducation", this.empEducationService.findAllByEid(eid));
		mav.add("allDegrees", map.get("allDegrees"));
		mav.add("eid", eid);
		return mav ;
	}
	/**
	 * 列出所有职业经历信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("emp_career_list")
	public ModelAndView list_career() throws Exception{
		Map<String,Object> map = this.empCareerService.findAllByType() ;
		ModelAndView mav = new ModelAndView(super.getPage("list.career.page")) ;
		String eid = ServletObjectUtil.getRequest().getParameter("eid") ;
		mav.add("allCareers",this.empCareerService.findAllByCareerByEid(eid));
		mav.add("allPositions",map.get("allPositions"));
		mav.add("eid", eid);
		return mav ;
	}
	/**
	 * 异步判断职业经历是否增加成功
	 * @throws Exception
	 */
	@RequestMapping("emp_add_career")
	public ModelAndView addCareer() throws Exception{
		ModelAndView mav = new ModelAndView(super.getForwardPage()) ;
		EmpCareer vo = WebUtil.assembleVO(EmpCareer.class) ;
		if(this.empCareerService.add(vo)) {
			super.setUrlAndMsg(mav, super.getPage("list.career.action"), "vo.add.success","职业经历");
		}else {
			super.setUrlAndMsg(mav, super.getPage("list.career.action"), "vo.add.failure","职业经历");
		}
		return mav ;
	}
	
	/**
	 * 异步判断教育背景是否增加成功
	 * @throws Exception
	 */
	@RequestMapping("emp_add_edu")
	public ModelAndView addEdu() throws Exception{
		ModelAndView mav = new ModelAndView(super.getForwardPage()) ;
		EmpEducation vo = WebUtil.assembleVO(EmpEducation.class) ;
		if(this.empEducationService.add(vo)) {
			super.setUrlAndMsg(mav, super.getPage("list.career.action"), "vo.add.success","教育背景");
		}else {
			super.setUrlAndMsg(mav, super.getPage("list.career.action"), "vo.add.failure","教育背景");
		}
		return mav ;
	}
	/**
	 * 异步判断教育背景是否修改成功
	 * @throws Exception
	 */
	@RequestMapping("emp_edit_edu")
	public ModelAndView editEdu() throws Exception{
		ModelAndView mav = new ModelAndView(super.getForwardPage()) ;
		EmpEducation vo = WebUtil.assembleVO(EmpEducation.class) ;
		if(this.empEducationService.edit(vo)) {
			super.setUrlAndMsg(mav, super.getPage("list.career.action"), "vo.edit.success","教育背景");
		}else {
			super.setUrlAndMsg(mav, super.getPage("list.career.action"), "vo.edit.failure","教育背景");
		}
		return mav ;
	}
	/**
	 * 异步判断职业经历是否修改成功
	 * @throws Exception
	 */
	@RequestMapping("emp_edit_career")
	public ModelAndView editCareer() throws Exception{
		ModelAndView mav = new ModelAndView(super.getForwardPage()) ;
		EmpCareer vo = WebUtil.assembleVO(EmpCareer.class) ;
		if(this.empCareerService.edit(vo)) {
			super.setUrlAndMsg(mav, super.getPage("list.career.action"), "vo.edit.success","职业经历");
		}else {
			super.setUrlAndMsg(mav, super.getPage("list.career.action"), "vo.edit.failure","职业经历");
		}
		return mav ;
	}
	/**
	 * 根据指定eeduid查询详细教育背景信息
	 * @throws Exception
	 */
	@RequestMapping("list_edu_id")
	public void listEduByid() throws Exception{
		EmpEducation edu = WebUtil.assembleVO(EmpEducation.class) ;
		EmpEducation vo = this.empEducationService.findByEeduid(edu.getEeduid()) ;
		Map<String,Object> map = new HashMap<>() ;
		map.put("school", vo.getSchool()) ;
		map.put("major", vo.getMajor()) ;
		map.put("degree", vo.getDegree()) ;
		map.put("entrance", vo.getEntrance()) ;
		map.put("graduation", vo.getGraduation()) ;
		map.put("note", vo.getNote()) ;
		super.print(JSON.toJSONString(map));
	}
	/**
	 * 根据指定ecarid查询详细职业经历信息
	 * @throws Exception
	 */
	@RequestMapping("list_career_id")
	public void listCareerByid() throws Exception{
		EmpCareer ecar = WebUtil.assembleVO(EmpCareer.class) ;
		EmpCareer vo = this.empCareerService.findByEcarid(ecar.getEcarid()) ;
		Map<String,Object> map = new HashMap<>() ;
		map.put("company", vo.getCompany()) ;
		map.put("salary", vo.getSalary()) ;
		map.put("position", vo.getPosition()) ;
		map.put("entry", vo.getEntry()) ;
		map.put("quit", vo.getQuit()) ;
		map.put("reason", vo.getReason()) ;
		map.put("note", vo.getNote()) ;
		super.print(JSON.toJSONString(map));
	}
	/**
	 * 删除教育背景信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("delete_emp_edu")
	public void delete_emp_edu() throws Exception{
		String ids = ServletObjectUtil.getRequest().getParameter("ids") ;
		Set<Long> eeduids = super.handleIdToLong(ids) ;
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("flag", this.empEducationService.deleteEdu(eeduids)) ;
		super.print(JSON.toJSONString(map));
	}
	/**
	 * 删除职业经历信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("delete_emp_career")
	public void delete_emp_career() throws Exception{
		String ids = ServletObjectUtil.getRequest().getParameter("ids") ;
		Set<Long> ecarids = super.handleIdToLong(ids) ;
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("flag",this.empCareerService.deleteCareer(ecarids)) ;
		super.print(JSON.toJSONString(map));
	}
	/**
	 * 删除雇员信息
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping("delete_emp")
//	public void delete_emp() throws Exception{
////		ModelAndView mav = new ModelAndView(getForwardPage());
//		String ids = WebUtil.getParameterValue("ids")[0] ;
//		System.out.println("********ids**" + ids);
//		Set<String> eids = super.handleIdToString(ids) ;
//		if(this.empService.delete(eids)) {
//			ServletObjectUtil.getRequest().getRequestDispatcher("/pages/back/admin/emp/emp_list.action").forward(ServletObjectUtil.getRequest(), ServletObjectUtil.getResponse());
////			super.setUrlAndMsg(mav, super.getPageKey("list.action"), "vo.delete.success", "雇员");
//		}else {
////			super.setUrlAndMsg(mav, super.getPageKey("list.action"), "vo.delete.failure", "雇员");
//		}
////		return mav ;
//	}
	@RequestMapping("delete_emp")
	public void delete_emp() throws Exception{
		String ids = ServletObjectUtil.getRequest().getParameter("ids") ;
		Set<String> eids = super.handleIdToString(ids) ;
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("flag",this.empService.delete(eids)) ;
		super.print(JSON.toJSONString(map));
	}
	/**
	 * 根据eid查询用户信息、教育背景、职业经历
	 * @throws Exception
	 */
	@RequestMapping("list_info")
	public void list_info() throws Exception{
		Map<String,Object> map = new HashMap<String,Object>() ;
		String eid = ServletObjectUtil.getRequest().getParameter("eid") ;
		EmpLevel emp = this.empService.getEmpLevelDept(eid) ;
		List<EmpEducation> allEmpEdus = this.empEducationService.findAllByEid(eid) ;
		List<EmpCareer> allEmpCars = this.empCareerService.findAllByCareerByEid(eid) ;
		map.put("emp", emp) ;
		map.put("allEmpEdus", allEmpEdus) ;
		map.put("allEmpsCars", allEmpCars) ;
		super.print(JSON.toJSONString(map));
	}
	
}
