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

import DTO.InforUser;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class InformationUserFix extends JFrame {

	private JPanel contentPane;
	private JTextField Ten;
	private JTextField SDT;
	private JTextField DiaChi;
	private File file;
	String anh;
	public static ArrayList<InforUser> inforUserFix;
	static InformationUserFix IFF;

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
	public InformationUserFix() {
		//inforUserFix.clear();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(241, 44, 95, 13);
		contentPane.add(lblNewLabel);

		Ten = new JTextField();
		Ten.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.ORANGE));
		Ten.setForeground(Color.WHITE);
		Ten.setBackground(SystemColor.controlShadow);
		Ten.setBounds(240, 62, 186, 19);
		contentPane.add(Ten);
		Ten.setColumns(10);
		Ten.setEditable(false);

		JLabel lblNewLabel_1 = new JLabel("Sá»‘ Ä‘iá»‡n thoáº¡i");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(241, 91, 95, 13);
		contentPane.add(lblNewLabel_1);

		SDT = new JTextField();
		SDT.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.ORANGE));
		SDT.setForeground(Color.WHITE);
		SDT.setBackground(SystemColor.controlShadow);
		SDT.setBounds(241, 109, 185, 19);
		contentPane.add(SDT);
		SDT.setColumns(10);
		SDT.setEditable(false);

		JLabel lblNewLabel_2 = new JLabel("Ä�á»‹a chá»‰");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setBounds(241, 138, 95, 13);
		contentPane.add(lblNewLabel_2);

		DiaChi = new JTextField();
		DiaChi.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.ORANGE));
		DiaChi.setForeground(Color.WHITE);
		DiaChi.setBackground(SystemColor.controlShadow);
		DiaChi.setEditable(false);

		DiaChi.setBounds(241, 151, 185, 19);
		contentPane.add(DiaChi);
		DiaChi.setColumns(10);

		JButton btnSa = new JButton("Sá»­a");
		btnSa.setBounds(327, 208, 85, 21);
		contentPane.add(btnSa);

		JButton btnQuayLi = new JButton("Quay láº¡i");
		btnQuayLi.setBounds(0, 242, 85, 21);
		contentPane.add(btnQuayLi);
		btnQuayLi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				disable();
				GiaoDienNguoiDung GD = new GiaoDienNguoiDung();
				GD.setVisible(true);
				IFF.setVisible(false);
			}
		});

		inforUserFix = new ArrayList<InforUser>();

		try {

			String queryl = "SELECT * FROM ThongTinNguoiDung";
			ResultSet rs = DoAn.statement.executeQuery(queryl);
			InforUser IF;
			while (rs.next()) {
				IF = new InforUser(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5), rs.getBytes(6));
				inforUserFix.add(IF);

			}

		} catch (SQLException ex) {
			// tempp += "not Connected";
		}

		for (int i = 0; i < DoAn.inforUser.size(); i++) {

			if (DoAn.inforUser.get(i).getID() == DoAn.ID) {
					
					Ten.setText(inforUserFix.get(i).getTen());
					SDT.setText(""+inforUserFix.get(i).getSDT());
					DiaChi.setText(inforUserFix.get(i).getDiaChi());
					JOptionPane.showMessageDialog(null, inforUserFix.get(i).getTen() + " " + inforUserFix.get(i).getSDT() +" " +  inforUserFix.get(i).getDiaChi() );
					
				

				if (inforUserFix.get(i).getHinh() == null) {
					label.setIcon(new ImageIcon(InformationUser.class.getResource("/anh/user.png")));
				} else {
					ImageIcon image = new ImageIcon(new ImageIcon(inforUserFix.get(i).getHinh()).getImage()
							.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
					label.setIcon(image);
				}
			}

		}
		btnSa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				InformationUser IF = new InformationUser();
				IF.setVisible(true);
				IFF.setVisible(false);
			}
		});
	}
}
