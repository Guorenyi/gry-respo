package cn.mldn.eop.service.impl;



import cn.mldn.eop.dao.IEmpDAO;
import cn.mldn.eop.dao.IPlanDAO;
import cn.mldn.eop.dao.IPlanDetailsDAO;
import cn.mldn.eop.service.IPlanDetailsService;
import cn.mldn.eop.vo.PlanDetails;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
import cn.mldn.util.web.servlet.ServletObjectUtil;

@Service
public class PlanDetailsServiceImpl extends AbstractService implements IPlanDetailsService {
	@Autowired
	private IPlanDetailsDAO planDetailsDAO;
	
	@Autowired
	private IPlanDAO planDAO;
	
	@Autowired
	private IEmpDAO empDAO;
	
	public Boolean delete(PlanDetails vo)throws Exception{
		if (vo==null||"".equals(vo)) {
			return false;
		}
		if (this.planDetailsDAO.doDelete(vo.getPid(),vo.getEid())) {
			return this.planDAO.doEditCount(-1, vo.getPid());
		}
		return false;
	}
	
	@Override
	public Boolean add(PlanDetails vo) throws Exception {
		if (vo==null||"".equals(vo)) {
			return false;
		}
		//注意事项：如果当前用户等级大于要增加的用户等级，才可以添加
		//从session中获取eid，然后从eid中获取lid,lid越小等级越高
		String eid=(String)ServletObjectUtil.getRequest().getSession().getAttribute("eid");
//		System.out.println("*************************************");
//		//增加雇员的等级
//		System.out.println(vo.getEid());
//		System.out.println(this.empDAO.findById(vo.getEid()));
//		System.out.println(this.empDAO.findById(vo.getEid()).getLid());
//		//当前雇员等级
//		System.out.println(this.empDAO.findById(eid).getLid());
		if (this.empDAO.findById(eid).getLid() > this.empDAO.findById(vo.getEid()).getLid()) {
			return false;
		}
		//一个人不允许被同一任务分配两次
		if (this.planDetailsDAO.findByEidAndPid(vo.getPid(), vo.getEid())==null) {
			if (this.planDetailsDAO.doCreate(vo)) {
				return this.planDAO.doEditCount(1,vo.getPid());
			}
		}
		return false;
	}

}
