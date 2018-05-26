package cn.mldn.eop.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.Reimbursement;
import cn.mldn.util.service.IBaseService;

public interface IReimbursementService extends IBaseService<Reimbursement>{

	/**
	 * 增加之前报销类型的查询
	 * @return  返回数据字典中的所有类型
	 * @throws Exception
	 */
	public List<Dictionary> addPre()throws Exception;
	
	/**
	 * 报销单的创建
	 * @return
	 * @throws Exception
	 */
	public boolean add(Reimbursement vo)throws Exception;
	
	/**
	 * 报销申请提交
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean editStatusById(Long id,String eid) throws Exception ;
	/**
	 * 数据删除
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public boolean deleteR(Set<Long> ids) throws Exception ;
	/**
	 * 进行已经提交报销单分页操作
	 * @param currentPage
	 * @param lineSize
	 * @param column
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> findAllSplitByStatus(long currentPage, int lineSize, String column, String keyWord) throws Exception ;
}
