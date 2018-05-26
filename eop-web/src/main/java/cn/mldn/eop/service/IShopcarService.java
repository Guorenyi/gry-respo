package cn.mldn.eop.service;

import java.util.Map;
import java.util.Set;

import cn.mldn.eop.vo.Shopcar;
import cn.mldn.util.service.IBaseService;

public interface IShopcarService extends IBaseService<Shopcar> {
	/**
	 * 实现购物车中的数据增加处理
	 */
	public boolean add(Shopcar car) throws Exception;
	/**
	 * 根据用户ID列出购物车商品信息
	 * @param eid 用户ID
	 * @return 返回商品信息
	 * @throws Exception 异常输出
	 */
	public Map<String,Object> list(String eid) throws Exception;
	/**
	 * 根据用户ID和商品ID删除购物车商品
	 * @param eid 用户ID
	 * @param resid 商品ID
	 * @return 删除成功返回true
	 * @throws Exception 异常输出
	 */
	public boolean delete(String eid,Set<Long> resid) throws Exception;
	/**
	 * 进行指定商品信息的修改
	 * @param car 描述要修改的内容
	 * @return 修改成功返回true
	 * @throws Exception 异常输出
	 */
	public boolean editAmount(Shopcar car) throws Exception;
}
