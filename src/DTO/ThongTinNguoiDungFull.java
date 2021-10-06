package DTO;

public class ThongTinNguoiDungFull {
	private int IDNguoiDung;
	private String TaiKhoan;
	private String MatKhau;
	private int IDGroup;
	private String Ten;
	private String SDT;
	private String DiaChi;
	private int Vitien;
	public int getIDNguoiDung() {
		return IDNguoiDung;
	}
	public void setIDNguoiDung(int iDNguoiDung) {
		IDNguoiDung = iDNguoiDung;
	}
	public String getTaiKhoan() {
		return TaiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public int getIDGroup() {
		return IDGroup;
	}
	public void setIDGroup(int iDGroup) {
		IDGroup = iDGroup;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public int getVitien() {
		return Vitien;
	}
	public void setVitien(int vitien) {
		Vitien = vitien;
	}
	public ThongTinNguoiDungFull() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThongTinNguoiDungFull(int iDNguoiDung, String taiKhoan, String matKhau, int iDGroup, String ten, String sDT,
			String diaChi, int vitien) {
		
		setIDNguoiDung(iDNguoiDung);
		setTaiKhoan(taiKhoan);
		setMatKhau(matKhau);
		setIDGroup(iDGroup);
		setTen(ten);
		setSDT(sDT);
		setDiaChi(diaChi);
		setVitien(vitien);
		
	
	}
	
	
	

}
