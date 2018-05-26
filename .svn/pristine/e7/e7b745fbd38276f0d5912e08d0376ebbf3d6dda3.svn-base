package cn.mldn.eop.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.eop.vo.Empresource;
import cn.mldn.util.dao.IDAO;

public interface IEmpresourceDAO extends IDAO<String,Empresource> {
	/**
	 * 根据用户ID查找资源申请单并进行分页显示
	 * @param currentPage  cp
	 * @param lineSize ls
	 * @param eid 用户ID
	 * @return 返回资源申请单详情
	 * @throws SQLException  异常输出
	 */
	public List<Empresource> findSplit(Long currentPage, Integer lineSize,String eid) throws SQLException;
	public long getAllCountHandle(String whereStr) throws SQLException;
	public long doCreate(Empresource vo,boolean isReturnKeyId) throws SQLException;
	/**
	 * 根据雇员资源申请ID查找资源申请单详情
	 * @param eresid 雇员资源申请ID
	 * @return 返回资源申请单详情
	 * @throws SQLException 异常处理
	 */
	public List<Empresource> findByEresid(Long eresid) throws SQLException;
	/**
	 * 根据雇员资源申请单ID修改商品总数量和商品总价格
	 * @param eresid 雇员资源申请单ID
	 * @param amount 商品总数量
	 * @param money	商品总价格
	 * @return 执行成功返回true
	 * @throws SQLException 异常输出
	 */
	public boolean doEdit(Long eresid,Integer amount,Double money) throws SQLException;
	/**
	 * 查找符合条件的资源申请单
	 * @return 资源申请单列表
	 * @throws SQLException
	 */
	public List<Empresource> findResourceApplyList(String whereStr) throws SQLException;

}
