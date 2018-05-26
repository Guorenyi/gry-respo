package cn.mldn.eop.service;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.vo.ResourceDetails;
import cn.mldn.util.service.IBaseService;

public interface IResourceDetailsService extends IBaseService<ResourceDetails> {
	/**
	 * 根据资源申请单ID查找资源详情信息
	 * @param eresid 资源申请单ID
	 * @return 返回资源详情信息
	 * @throws Exception  异常输出
	 */
	public Map<String,Object> findbyeresid(Long eresid) throws Exception;
	
	/**
	 * 根据雇员资源申请ID和雇员资源申请详情单ID删除雇员资源详情单中的商品
	 * @param eresid 雇员资源申请ID
	 * @param resid 雇员资源申请详情单
	 * @return 执行成功返回true
	 * @throws Exception 异常输出
	 */
	public boolean removebyid(Long eresid,Set<Long> resid) throws Exception;
	/**
	 * 根据雇员资源申请ID和雇员资源申请详情单ID和数量修改雇员资源详情单中的商品数量
	 * @param eresid eresid 雇员资源申请ID
	 * @param resid resid 雇员资源申请详情单
	 * @param amount 商品数量
	 * @return 执行成功返回true
	 * @throws SQLException 异常输出
	 */
	public boolean editbyid(Long eresid,Long resid,Integer amount,Double money) throws Exception;
	
	/**
	 * 根据雇员申请ID修改emp_resource中商品总数量和总价格
	 * @param eresid 雇员申请ID
	 * @param amount 商品总数量
	 * @param money 商品总价格
	 * @return 执行成功返回true
	 * @throws Exception 异常输出
	 */
	public boolean editnumber(Long eresid,Integer amount,Double money) throws Exception;
}
