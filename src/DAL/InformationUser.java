package DAL;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import DTO.FileTypeFiler;
import DTO.Test;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class InformationUser extends JFrame {

	private JPanel contentPane;
	private JTextField Ten;
	private JTextField SDT;
	private JTextField DiaChi;
	private File file;
	String anh;
	InformationUser IF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformationUser frame = new InformationUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InformationUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 309);
		contentPane = new JPanel();
		getContentPane().setBackground(SystemColor.controlShadow);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(InformationUser.class.getResource("/anh/user.png")));
	
	
		label.setBackground(UIManager.getColor("CheckBox.background"));
		label.setBounds(42, 43, 157, 160);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Há»� vÃ  tÃªn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(241, 44, 95, 13);
		contentPane.add(lblNewLabel);
		
		Ten = new JTextField();
		Ten.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.ORANGE));
		Ten.setForeground(Color.DARK_GRAY);
		Ten.setBackground(Color.WHITE);
		Ten.setBounds(240, 62, 186, 19);
		contentPane.add(Ten);
		Ten.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sá»‘ Ä‘iá»‡n thoáº¡i");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(241, 91, 95, 13);
		contentPane.add(lblNewLabel_1);
		
		SDT = new JTextField();
		SDT.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.ORANGE));
		SDT.setForeground(Color.DARK_GRAY);
		SDT.setBackground(Color.WHITE);
		SDT.setBounds(241, 109, 185, 19);
		contentPane.add(SDT);
		SDT.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ä�á»‹a chá»‰");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(241, 138, 95, 13);
		contentPane.add(lblNewLabel_2);
		
		DiaChi = new JTextField();
		DiaChi.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.ORANGE));
		DiaChi.setForeground(Color.DARK_GRAY);
		DiaChi.setBackground(Color.WHITE);

		DiaChi.setBounds(241, 151, 185, 19);
		contentPane.add(DiaChi);
		DiaChi.setColumns(10);
		JButton btnHinh = new JButton("L\u1EA5y h\u00ECnh");
		btnHinh.setBounds(52, 213, 85, 21);
		contentPane.add(btnHinh);
		
		JButton btnLu = new JButton("LÆ°u");
		btnLu.setBounds(341, 213, 85, 21);
		contentPane.add(btnLu);
		
		JButton btnQuayLaij = new JButton("Quay láº¡i");
		btnQuayLaij.setBounds(0, 244, 85, 21);
		contentPane.add(btnQuayLaij);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(InformationUser.class.getResource("/anh/1.png")));
		lblNewLabel_3.setBounds(0, 0, 465, 270);
		contentPane.add(lblNewLabel_3);
		
		btnQuayLaij.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				disable();
				InformationUserFix IFF  = new  InformationUserFix();
				IFF.setVisible(true);
				IF.setVisible(false);
			}
		});
		
		btnHinh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					JFileChooser jFileChooser = new JFileChooser();
					jFileChooser.setDialogTitle("please add Image");
					jFileChooser.setMultiSelectionEnabled(false);
					jFileChooser.setFileFilter(new FileTypeFiler(".jpg", "JPG"));
					jFileChooser.setFileFilter(new FileTypeFiler(".gif", "GIF"));
					jFileChooser.setFileFilter(new FileTypeFiler(".png", "PNG"));
					int result = jFileChooser.showOpenDialog(null);
					
					if(result == JFileChooser.APPROVE_OPTION) {
					file = jFileChooser.getSelectedFile();
					ImageIcon image = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
					label.setIcon(image);
					anh= file.getAbsolutePath().replace("/", "//");
					}
					
					
					
					
			}
		});
btnLu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Test SP = new Test();
					SP.setHinh(file.getAbsolutePath().getBytes());
					//DoAn.statement.executeUpdate("INSERT INTO SanPham values ( 1, '"+ TenSP.getText() + "','" + Integer.parseInt(SoLuong.getText())+ "','" + Integer.parseInt(Gia.getText())+ "','" + TheLoai.getText()+ "','"+ SP.getHinh()+"')");
				//	DoAn.statement.executeUpdate("INSERT INTO  ThongTinNguoiMua SELECT '"+DoAn.ID + "' ,'"+ Ten.getText() + "','" + SDT.getText()+ "','" + DiaChi.getText()+ "',BulkColumn FROM OPENROWSET(BULK N'"+anh+"', SINGLE_BLOB) image; ");
                DoAn.statement.executeUpdate("UPDATE ThongTinNguoiDung SET Ten = '"+ Ten.getText() + "',SDT = '" + SDT.getText()+ "', DiaChi = '" + 0+ "', ViTien = '" + DiaChi.getText()+ "',Image = (SELECT MyImage.* from Openrowset(BULK '"+anh+"', Single_Blob) MyImage) where IDNguoiDung = '" + DoAn.ID + "' ");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Done" + e2.getMessage());
				}
				JOptionPane.showMessageDialog(null, "Done");
			}
		});
	}
}
