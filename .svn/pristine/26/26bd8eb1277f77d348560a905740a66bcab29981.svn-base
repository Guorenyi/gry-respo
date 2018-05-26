 package cn.mldn.eop.action;
import java.util.Map;

import cn.mldn.eop.service.IDeptService;
import cn.mldn.eop.vo.Dept;
import cn.mldn.util.bean.WebUtil;
import cn.mldn.util.web.SplitPageUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
@Controller 
@RequestMapping("/pages/back/admin/dept/*")
public class DeptAction extends AbstractAction{
	@Autowired
	private IDeptService deptService ;
	/**
	 * 通过Action跳转到增加页面
	 * @return
	 */
	@RequestMapping("dept_add_pre")
	public ModelAndView addPre() throws Exception{ 
		ModelAndView mav = new ModelAndView(super.getPage("addPre.page"));
		mav.add("allEmps", this.deptService.listAllLid());
		return mav;
	}
	/**
	 * 进行部门信息的添加操作
	 * @param vo 需要添加的部门信息内容
	 * @return 增加成功返回true，否则返回false
	 * @throws Exception
	 */
	@RequestMapping("dept_add")
	public ModelAndView add() throws Exception{
		ModelAndView mav = new ModelAndView(super.getForwardPage()) ;
		Dept dept = WebUtil.assembleVO(Dept.class) ;
		if(dept != null) {
			if(this.deptService.add(dept)) {
				super.setUrlAndMsg(mav,super.getPageKey("add.page"), "vo.add.success","部门");
			}else {
				super.setUrlAndMsg(mav,super.getPageKey("add.page"), "vo.add.failure","部门");
			}
		}
		return mav ;
	}
	/**
	 * 异步检查添加的部门名称是否存在，存在返回true，否则返回false
	 * @param dname 部门名称
	 * @return 
	 * @throws Exception 		
	 */
	@RequestMapping("check_dname")
	public void checkDname(String dname) throws Exception{
		super.print(this.deptService.findByDname(dname) == null); 
	}
	/**
	 * 分页显示所有部门信息
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("dept_list")
	public ModelAndView list() throws Exception{
		ModelAndView mav = new ModelAndView(super.getPage("list.page")) ;
		String columnData = "部门名称:dname|部门详情:note" ;
		SplitPageUtil spu = new SplitPageUtil(columnData,super.getPageKey("list.action"));
		Map<String,Object> map = this.deptService.findBySplit(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyword()) ;
		mav.add("allRecorders", map.get("allRecorders"));
		mav.add("allDepts", map.get("allDepts"));
		mav.add("allEmps", map.get("allEmps"));
		return mav ;
	}
	@RequestMapping("dept_edit")
	public void edit() throws Exception{
		Dept dept = WebUtil.assembleVO(Dept.class) ;
		super.print(this.deptService.edit(dept));
	}
}
