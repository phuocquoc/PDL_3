package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAL.DoAn;
import DAL.GiaoDienNguoiDung;
import DTO.NguoiMua;

public class SQL {
	public void Login(ArrayList<NguoiMua>customers2,JTextField textField,JPasswordField passwordField,int p,int ID,int IDGroup,DoAn frame )
	{
		
		String queryl2 = "SELECT * FROM NguoiDung where TaiKhoanND = '"+ textField.getText() +"' and MatKhauND = '" + passwordField.getText()+"' ";
		try {
			customers2 = new ArrayList<NguoiMua>();
			ResultSet rs =  DoAn.statement.executeQuery(queryl2 );
			if(rs.next()) {
				NguoiMua NM = new NguoiMua();
				NM.setID(rs.getInt(1));
				NM.setTaiKhoan(rs.getString(2));
				NM.setMatKhau(rs.getString(3));	
				NM.setIDGroup(rs.getInt(4));
				customers2.add(NM);	
				p = 1;
				
				ID = customers2.get(0).getID();
				IDGroup = customers2.get(0).getIDGroup();
				JOptionPane.showMessageDialog(null, "Đăng nhập thành công." );
				frame.setVisible(false);
				GiaoDienNguoiDung SP = new GiaoDienNguoiDung();
				SP.setVisible(true);
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Tài khoản không hợp lệ");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}

	}
	public void dangki(JTextField textTK,JPasswordField textMK,ArrayList<NguoiMua> test)
	{
		try {
			DoAn.statement.executeUpdate("insert  into NguoiDung values  ( '"
					+ textTK.getText() + "', '" + textMK.getText() + "', '" + 1 +"')");
			String s2 = "SELECT * FROM NguoiDung WHERE TaiKhoanND = '" + textTK.getText()
					+ "'";
			ResultSet rss = DoAn.statement.executeQuery(s2);
			NguoiMua nguoiMua = new NguoiMua();
			test = new ArrayList<NguoiMua>();
			while (rss.next()) {
				NguoiMua NM = new NguoiMua();
				NM.setID(rss.getInt(1));
				NM.setTaiKhoan(rss.getString(2));
				NM.setMatKhau(rss.getString(3));
				test.add(NM);
			}
			rss.close();
			JOptionPane.showMessageDialog(null, "TK  " + test.get(0).getID() );
			DoAn.statement.executeUpdate("INSERT INTO ThongTinNguoiDung VALUES ('"
					+ test.get(0).getID() + "' ,null,null,null ,null,null)");
			
		} catch (SQLException e1) { 
			e1.printStackTrace(); 
			
		}
	}

		
	
}
