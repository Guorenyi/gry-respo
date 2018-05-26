package cn.mldn.util.web.servlet;

import java.util.Map;

public class ModelAndView {
	private String path ; // 保存跳转路径
	public ModelAndView(String path) {
		this.path = path ;
	}
	public void setPath(String path) {
		this.path = path ;
	}
	/**
	 * 保存request属性
	 * @param name 属性名称
	 * @param value 属性内容
	 */
	public void add(String name,Object value) {
		ServletObjectUtil.getRequest().setAttribute(name, value);
	}
	public void addMap(Map<String,Object> map) {
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			ServletObjectUtil.getRequest().setAttribute(entry.getKey(), entry.getValue());
		}
	}
	public String getPath() {
		return this.path ; 
	}
}
