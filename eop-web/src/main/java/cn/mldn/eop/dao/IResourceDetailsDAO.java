package cn.mldn.eop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.vo.ResourceDetails;
import cn.mldn.util.dao.IDAO;

public interface IResourceDetailsDAO  extends IDAO<Long,ResourceDetails>{
	/**
	 * 增加数据
	 */
	public  boolean doCreate(ResourceDetails vo) throws SQLException;
	/**
	 * 根据雇员资源申请单ID进行资源查找
	 * @param eresid 雇员资源申请单ID
	 * @return 返回资源详情
	 * @throws SQLException 异常输出
	 */
	public List<ResourceDetails> findByEresid(Long eresid) throws SQLException;
	
	/**
	 * 根据雇员资源申请ID和雇员资源申请详情单ID删除雇员资源详情单中的商品
	 * @param eresid 雇员资源申请ID
	 * @param resid 雇员资源申请详情单
	 * @return 执行成功返回true
	 * @throws Exception 异常输出
	 */
	public boolean doRemoveById(Long eresid,Set<Long> resid) throws SQLException;
	/**
	 * 根据雇员资源申请ID和雇员资源申请详情单ID和数量修改雇员资源详情单中的商品数量
	 * @param eresid eresid 雇员资源申请ID
	 * @param resid resid 雇员资源申请详情单
	 * @param amount 商品数量
	 * @return 执行成功返回true
	 * @throws SQLException 异常输出
	 */
	public boolean doEditById(Long eresid,Long resid,Integer amount,Double money) throws SQLException;
}
