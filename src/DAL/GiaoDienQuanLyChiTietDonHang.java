package DAL;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GiaoDienQuanLyChiTietDonHang extends JFrame {

	private JPanel contentPane;
	private GiaoDienQuanLyChiTietDonHang frame;
	
	public GiaoDienQuanLyChiTietDonHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID h\u00F3a \u0111\u01A1n:");
		lblNewLabel.setBounds(51, 27, 110, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(208, 27, 221, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID S\u1EA3n ph\u1EA9m:");
		lblNewLabel_2.setBounds(51, 65, 147, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("T\u00EAn s\u1EA3n ph\u1EA9m:");
		lblNewLabel_2_1.setBounds(51, 104, 147, 14);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(208, 65, 221, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setBounds(208, 104, 221, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblaCh = new JLabel("S\u1ED1 l\u01B0\u1EE3ng:");
		lblaCh.setBounds(51, 140, 147, 14);
		panel.add(lblaCh);
		
		JLabel lblVTin = new JLabel("\u0110\u01A1n gi\u00E1");
		lblVTin.setBounds(51, 182, 110, 14);
		panel.add(lblVTin);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setBounds(208, 140, 221, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("");
		lblNewLabel_1_1_2.setBounds(208, 182, 221, 14);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("");
		lblNewLabel_1_1_3.setBounds(208, 220, 110, 14);
		panel.add(lblNewLabel_1_1_3);
		
		JButton btnNewButton_1 = new JButton("X\u00F3a \u0111\u01A1n h\u00E0ng");
		btnNewButton_1.setBounds(538, 347, 145, 23);
		panel.add(btnNewButton_1);
		
		
		
		
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				GiaoDienQuanLyNguoiDUng GDQL = new GiaoDienQuanLyNguoiDUng();
				GDQL.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_2.setBounds(10, 347, 68, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblThnhTin = new JLabel("Th\u00E0nh ti\u1EC1n:");
		lblThnhTin.setBounds(51, 220, 110, 14);
		panel.add(lblThnhTin);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("");
		lblNewLabel_1_1_3_1.setBounds(208, 262, 110, 14);
		panel.add(lblNewLabel_1_1_3_1);
		
		
		String queryl="select IDhoaDon,IDSanPham,TenSP,SoLuong,DonGia,ThanhTien from ChiTietHoaDon where IDHoaDon = '"+ GiaoDienQuanLyDonHang.a +"'";
		try {
			ResultSet rs=DoAn.statement.executeQuery(queryl);
			
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
			}
		});
	}
}
