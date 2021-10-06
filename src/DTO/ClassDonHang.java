package DTO;

import java.sql.Date;
import java.sql.Time;
import java.time.format.DateTimeFormatter;

public class ClassDonHang {

	int id;
	int tongT;
	String diachi;
	String tinhtrang;
	Date date;
	Time time;
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTongT() {
		return tongT;
	}
	public void setTongT(int tongT) {
		this.tongT = tongT;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getTinhtrang() {
		return tinhtrang;
	} 
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public ClassDonHang() {
		// TODO Auto-generated constructor stub
	}
	
	public ClassDonHang(int id,int tongT,String diachi, String tinhtrang,Date date) {
		this.id=id;
		this.tongT=tongT;
		this.diachi=diachi;
		this.tinhtrang=tinhtrang;
		this.date =date;
	}

	public ClassDonHang(int id,int tongT,String diachi, String tinhtrang,Date date,Time time) {
		this.id=id;
		this.tongT=tongT;
		this.diachi=diachi;
		this.tinhtrang=tinhtrang;
		this.date =date;
		this.time=time;
	}
}
