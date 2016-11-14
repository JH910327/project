package pojo;

import java.util.Date;

public class Review {
	public Integer num;
	public String writer;
	public String memo;
	public Integer good;
	public Date writedate;
	
	
	public void setNum(Integer num) {
		this.num = num;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public void setGood(Integer good) {
		this.good = good;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	
	public Integer getNum() {
		return num;
	}
	public String getWriter() {
		return writer;
	}
	public String getMemo() {
		return memo;
	}
	public Integer getGood() {
		return good;
	}
	public Date getWritedate() {
		return writedate;
	}
	

	
	
	
}
