package cn.mldn.eop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.vo.Shopcar;
import cn.mldn.util.dao.IDAO;

public interface IShopcarDAO extends IDAO<Long,Shopcar> {
	/**
	 * 根据用户编号和商品编号获取一个购物车的数据信息
	 * @param eid 用户ID
	 * @param resid 商品ID
	 * @return 如果该信息存在则返回vo对象,否则返回null;
	 * @throws SQLException 程序异常错误
	 */
	public Shopcar findByMemberAndGoods(String eid,Long resid) throws SQLException;
	/**
	 * 根据购物车中的保存信息编号进行商品数量的变更处理;
	 * @param resid 商品ID
	 * @param amount 更新的数量
	 * @return 更新成功返回true
	 * @throws SQLException SQL
	 */
	public boolean doEditAmount(String eid,Long resid) throws SQLException;
	/**
	 * 根据用户编号和商品编号查询购物车中商品是否存在
	 * @param eid 用户ID
	 * @param resid 商品ID
	 * @return 存在返回true
	 * @throws SQLException 异常输出
	 */
	public boolean isExist(String eid,Long resid) throws SQLException;
	
	/**
	 * 根据用户ID查询购物车信息
	 * @param eid 用户ID
	 * @return 返回用户购物车信息
	 * @throws SQLException 异常输出
	 */
	public List<Shopcar> findAllByEid(String eid) throws SQLException;
	/**
	 * 根据用户ID和商品ID移除购物车中的商品
	 * @param eid 用户ID
	 * @param resid 商品ID
	 * @return 删除成功返回true
	 * @throws Exception 异常输出
	 */
	public boolean doRemoveByMember(String eid,Set<Long> resid) throws Exception;
	/**
	 * 根据用户ID,商品ID修改商品数量;
	 * @param eid 用户ID
	 * @param resid 商品ID
	 * @param amount 商品数量
	 * @return 返回修改结果
	 * @throws SQLException 异常输出
	 */
	public boolean doEditAmount(String eid,Long resid,Integer amount) throws SQLException;
	/**
	 * 根据用户ID清空用户购物车表数据
	 * @return 成功返回true
	 * @throws SQLException 异常输出
	 */
	public boolean doRemoveByEid(String eid) throws SQLException;
}
