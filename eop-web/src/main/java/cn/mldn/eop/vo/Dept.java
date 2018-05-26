package cn.mldn.eop.vo;

import java.io.Serializable;

import cn.mldn.util.web.annotation.FieldAnnotation;
import cn.mldn.util.web.annotation.TableAnnotation;

@SuppressWarnings("serial")
//@TableAnnotation(tableName="dept",keyCol= "did")
public class Dept implements Serializable {
//	@FieldAnnotation(isAutoIncrease="true",isKeyCol="true")
	private Long did ;
	private String dname ;
	private String eid ;
	private Integer maxnum ;
	private Integer currnum ;
	private String note ;
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public Integer getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}
	public Integer getCurrnum() {
		return currnum;
	}
	public void setCurrnum(Integer currnum) {
		this.currnum = currnum;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
