package DTO;

public class InforUser {
	private int ID;
	private String Ten;
	private int SDT;
	private String DiaChi;
	private byte[] hinh;
	int Vitien;
	
	public int getVitien() {
		return Vitien;
	}
	public void setVitien(int vitien) {
		Vitien = vitien;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public int getSDT() {
		return SDT;
	}
	public void setSDT(int sDT) {
		SDT = sDT;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
	public byte[] getHinh() {
		return hinh;
	}
	public void setHinh(byte[] hinh) {
		this.hinh = hinh;
	}
	public InforUser(int iD, String ten, int sDT, String diaChi, int v,byte[] hinh) {
		setID(iD);
		setTen(ten);
		setSDT(sDT);
		setDiaChi(diaChi);
		setVitien(v);
		setHinh(hinh);
		
		
	}
	
	
	
}
