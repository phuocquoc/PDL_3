package DTO;


public class HinhAnh {
	 private String Name;
	   private Byte icon;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Byte getIcon() {
		return icon;
	}
	public void setIcon(Byte icon) {
		this.icon = icon;
	}
	public HinhAnh(String name, Byte icon) {
		super();
		Name = name;
		this.icon = icon;
	}
}