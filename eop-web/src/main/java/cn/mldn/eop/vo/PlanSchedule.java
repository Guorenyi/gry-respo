package cn.mldn.eop.vo;

import java.io.Serializable;
import java.util.Date;

public class PlanSchedule implements Serializable {
	private String eid;
	private Long pid;
	private String title;
	private String item;
	private Date starttime;
	private Date endtime;
	private Integer amount;
	
	@Override
	public String toString() {
		return "PlanSchedule [eid=" + eid + ", pid=" + pid + ", title=" + title + ", item=" + item + ", starttime="
				+ starttime + ", endtime=" + endtime + ", amount=" + amount + "]";
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
