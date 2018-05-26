package cn.mldn.eop.service;

import cn.mldn.eop.vo.PlanDetails;

public interface IPlanDetailsService {
	/**
	 * 给雇员增加任务
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public Boolean add(PlanDetails vo)throws Exception;
	
	/**
	 * 删除雇员的任务
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public Boolean delete(PlanDetails vo)throws Exception;
}
