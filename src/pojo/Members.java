package pojo;

import java.sql.Date;

public class Members {
	String id;
	String pass;
	String name;
	int point;
	Date joindate;
	
	public Members(String id, String pass, String name, int point, Date joindate) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.point = point;
		this.joindate = joindate;
	}
	public Members() {
		this.id = null;
		this.pass = null;
		this.name = null;
		this.point = 0;
		this.joindate = null;
	}
	
	public Members(String id, String pass, String name) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.point = 0;
		this.joindate = null;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
	public Date getJoindate() {
		return joindate;
	}
	
	

}
