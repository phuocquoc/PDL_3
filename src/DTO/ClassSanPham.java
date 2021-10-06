package DTO;

public class ClassSanPham {
	private int IDSanPham;
	private int IDNguoiBan;
	private String tensach;
	private int soluong;
	private int dongia;
	private String theloai;
	private byte[] hinh;
	
	public ClassSanPham()
	{
		
	}
	public int getIDSanPham() {
		return IDSanPham;
	}
	public void setIDSanPham(int iDSanPham) {
		IDSanPham = iDSanPham;
	}
	public int getIDNguoiBan() {
		return IDNguoiBan;
	}
	public void setIDNguoiBan(int iDNguoiBan) {
		IDNguoiBan = iDNguoiBan;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
	}
	public String getTheloai() {
		return theloai;
	}
	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}
	public byte[] getHinh() {
		return hinh;
	}
	public void setHinh(byte[] hinh) {
		this.hinh = hinh;
	}
	public ClassSanPham(int iDSanPham, int iDNguoiBan, String tensach, int soluong, int dongia, String theloai,
			byte[] hinh) {
		super();
		IDSanPham = iDSanPham;
		IDNguoiBan = iDNguoiBan;
		this.tensach = tensach;
		this.soluong = soluong;
		this.dongia = dongia;
		this.theloai = theloai;
		this.hinh = hinh;
	}
	
	
}
