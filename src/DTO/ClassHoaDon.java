package DTO;

public class ClassHoaDon {

	private int maS;
	private String tenS;
	private int sLuog;
	private int donGia;
	private int thanhT;
	
	public ClassHoaDon() {
	}
	
	public ClassHoaDon(int maS ,String tenS,int sLuog,int donGia,int thanhT) {
		this.maS=maS;
		this.tenS=tenS;
		this.sLuog=sLuog;
		this.donGia=donGia;
		this.thanhT=thanhT;
	}
	
	public int getMaS() {
		return maS;
	}
	public void setMaS(int maS) {
		this.maS = maS;
	}
	public String getTenS() {
		return tenS;
	}
	public void setTenS(String tenS) {
		this.tenS = tenS;
	}
	public int getsLuog() {
		return sLuog;
	}
	public void setsLuog(int sLuog) {
		this.sLuog = sLuog;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public int getThanhT() {
		return thanhT;
	}
	public void setThanhT(int thanhT) {
		this.thanhT = thanhT;
	}
	
	

}
