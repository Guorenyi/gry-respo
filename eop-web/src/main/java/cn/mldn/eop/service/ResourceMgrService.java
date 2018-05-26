package cn.mldn.eop.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.vo.Resource;
import cn.mldn.eop.vo.SupplyPurchase;
import cn.mldn.util.service.IBaseService;

public interface ResourceMgrService extends IBaseService<SupplyPurchase>{

	/**
	 * 根据申请单ID取得其所有办公资源
	 * @param supplyId 采购申请单ID
	 * @return 办公资源列表列表
	 * @throws Exception
	 */
	public List<Resource> findSupplyDetails(Long supplyId) throws Exception;
	
	/**
	 * 根据办公资源ID获得办公资源对象
	 * @param rsId 办公资源ID
	 * @return  办公资源对象
	 * @throws Exception
	 */
	public Resource getResourceById(Long rsId) throws Exception;
	/**
	 * 增加申请单明细，办公资源只有在申请单处于草稿状态时才可以增加
	 * @param vo 办公资源对象
	 * @return -1:删除失败，不允许删除明细;
	 *         1:成功删除
	 * @throws Exception
	 */
	public int addResource(Resource vo) throws Exception;
	/**
	 * 修改申请单明细，办公资源只有在申请单处于草稿状态时才可以修改
	 * @param vo 办公资源对象
	 * @return -1:删除失败，不允许删除明细;
	 *         1:成功删除
	 * @throws Exception
	 */
	public int editResource(Resource vo) throws Exception;
	
	/**
	 * 创建采购申请单,并把最新创建的采购申请单ID返回
	 * @param vo  申请单对象
	 * @param returnNewKeyId true:返回主键ID
	 * 					     false:不返回主键ID
	 * @return  主键ID
	 * @throws Exception
	 */
	public long add(SupplyPurchase vo,boolean returnNewKeyId) throws Exception ;
	
	/**
	 * 提交采购申请单
	 * @param spid 采购物申请单ID
	 * @return -1:提交失败，采购申请单状态不是草稿状态的不允许提交;
	 *         1:成功提交
	 * @throws Exception
	 */
	public int submitSupply(String spid) throws Exception;
	
	
	/**
	 * 根据采购申请单ID删除其明细记录
	 * @param spid 申请单ID
	 * @param ids 申请单明细ID列表
	 * @return -1:删除失败，申请单状态不允许删除明细;
	 *         1:成功删除
	 * @throws Exception
	 */
	public int deleteResource(String spid,Set<String> ids) throws Exception;
	/**
	 * 为办公资源增加数量
	 * @param resid 办公资源ID
	 * @param qty 数量
	 * @return true:增加成功
	 * 		   false:增加失败
	 * @throws Exception
	 */
	public boolean appendResourceQty(Long resid,Integer qty) throws Exception;
	/**
	 * 判断申请单的状态是否可以修改，增加，删除申请单明细
	 * @param spid 申请单ID
	 * @return true:可以修改，增加，删除申请单明细
	 * 		   false:不可以修改，增加，删除申请单明细
	 * @throws Exception
	 */
	/**
	 * 检查是否可以为一个采购申请单修改/增加/删除办公资源
	 * @param spid 采购申请单ID
	 * @return true:可以修改/增加/删除办公资源
	 *         false:不能修改/增加/删除办公资源
	 * @throws Exception
	 */
	public boolean canUpdateResource(String spid) throws Exception;
	
	/**
	 * 取得所有状态的商品
	 * @param currentPage 当前页	
	 * @param lineSize 每页行数
	 * @param column 模糊查询列
	 * @param keyWord 模糊查询值
	 * @return  返回查询页的数据列表
	 * @throws Exception 
	 */
	public Map<String, Object> findGoodsBySplit(long currentPage, int lineSize, String column, String keyWord) throws Exception;
	/**
	 * 取得所有状态的商品
	 * @param currentPage 当前页	
	 * @param lineSize 每页行数
	 * @return  返回查询页的数据列表
	 * @throws Exception 
	 */
	public Map<String, Object> findGoodsBySplit(long currentPage, int lineSize) throws Exception;
	/**
	 * 取得所有审核通过状态的商品
	 * @param currentPage 当前页	
	 * @param lineSize 每页行数
	 * @param column 模糊查询列
	 * @param keyWord 模糊查询值
	 * @return  返回查询页的数据列表
	 * @throws Exception 
	 */
	public Map<String,Object> findAvibGoodsSplit(Long currentPage, Integer lineSize) throws Exception ;
	/**
	 * 取得所有审核通过状态的商品
	 * @param currentPage 当前页	
	 * @param lineSize 每页行数
	 * @return  返回查询页的数据列表
	 * @throws Exception 
	 */
	public Map<String,Object> findAvibGoodsSplit(Long currentPage,Integer lineSize, String column, String keyWord) throws Exception ;
	
	/**
	 * 查找所有的待审核的购物申请单
	 * @param currentPage 当前页面
	 * @param lineSize 每页行数
	 * @param column 模糊查询列
	 * @param keyWord 模糊查询值
	 * @return 返回查询页的数据列表
	 * @throws Exception
	 */
	public Map<String,Object> findSupplyForAudit(Long currentPage,Integer lineSize, String column, String keyWord) throws Exception ;
	/**
	 * 查找所有的待审核的购物申请单
	 * @param currentPage 当前页面
	 * @param lineSize 每页行数
	 * @return 返回查询页的数据列表
	 * @throws Exception
	 */
	public Map<String,Object> findSupplyForAudit(Long currentPage,Integer lineSize) throws Exception ;
 
	/**
	 * 审核资源申请单
	 * @param eid 用户ID
	 * @param eresid 资源申请单ID
	 * @param audit 审核结果
	 * @param note 审核备注
	 * @return true:成功
	 * 			false:失败
	 * @throws Exception
	 */
	public boolean auditResource(String eid,String eresid,String audit,String note) throws Exception;
}
