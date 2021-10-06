package DAL;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import DAO.SQL;
import DTO.NguoiMua;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class DangKy extends JFrame {

	
		private JPanel contentPane;
		private JTextField textTK;
		static DangKy DK;
		private JPasswordField textMK;
		private JPasswordField textMK2;
		public static ArrayList<NguoiMua> customersDK;
		public static ArrayList<NguoiMua> test;
		/**
		 * Launch the application.
		 */
		/**
		 * Create the frame.
		 */
		public DangKy() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(DangKy.class.getResource("/anh/sell.png")));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 565, 374);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			contentPane.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			textTK = new JTextField();
			textTK.setOpaque(false);
			textTK.setForeground(Color.DARK_GRAY);
			textTK.setBackground(Color.WHITE);
			textTK.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
			textTK.setToolTipText("Tài khoản");
			textTK.setBounds(268, 106, 224, 26);
			panel.add(textTK);
			textTK.setColumns(10);
			textMK = new JPasswordField();
			textMK.setOpaque(false);
			textMK.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
			textMK.setToolTipText("Mật khẩu");
			textMK.setBounds(268, 158, 224, 26);
			panel.add(textMK);
			textMK2 = new JPasswordField();
			textMK2.setOpaque(false);
			textMK2.setBackground(SystemColor.window);
			textMK2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
			textMK2.setToolTipText("Nhập lại mật khẩu");
			textMK2.setBounds(268, 215, 224, 26);
			panel.add(textMK2);
			JLabel lblUser = new JLabel("Tài khoản: ");
			lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblUser.setIcon(new ImageIcon(DangKy.class.getResource("/anh/user_male_26px.png")));
			lblUser.setForeground(Color.BLACK);
			lblUser.setBounds(46, 98, 147, 36);
			panel.add(lblUser);
			JLabel lblMtKhu = new JLabel("Mật khẩu:");
			lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblMtKhu.setIcon(new ImageIcon(DangKy.class.getResource("/anh/password_30px.png")));
			lblMtKhu.setForeground(Color.BLACK);
			lblMtKhu.setBounds(46, 151, 147, 35);
			panel.add(lblMtKhu);
			JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu :");
			lblNhpLiMt.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNhpLiMt.setIcon(new ImageIcon(DangKy.class.getResource("/anh/password_30px.png")));
			lblNhpLiMt.setForeground(Color.BLACK);
			lblNhpLiMt.setBounds(46, 207, 212, 36);
			panel.add(lblNhpLiMt);
			
			JLabel lblNewLabel = new JLabel("Đăng Kí");
			lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
			lblNewLabel.setIcon(new ImageIcon(DangKy.class.getResource("/anh/add_user_male_40px.png")));
			lblNewLabel.setBounds(265, 11, 199, 84);
			panel.add(lblNewLabel);
			
			JButton btnNewButton = new JButton("Đăng kí");
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// TODO Auto-generated method stub
					
					int temp = 0;
					if (textMK2.getText().equals(textMK.getText())) {
						if (textTK.getText().equals("") || textMK.getText().equals("") || textMK2.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
						} else {
							for (int j = 0; j < DoAn.customers.size(); j++) {
								if (DoAn.customers.get(j).getTaiKhoan().equals(textTK.getText())) {
									JOptionPane.showMessageDialog(null,
											"Tài khoản đã tồn tại !");
								} else {
									temp++;
									if (temp == DoAn.customers.size()) {
										SQL sql = new SQL();
										sql.dangki(textTK, textMK, test);
										dispose();
										DoAn doAn1 = new DoAn();
										doAn1.setVisible(true);
										break;
									}
								}
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Tài khoản không hợp lệ");
					}
				
				}
			});
			btnNewButton.setBounds(276, 264, 103, 32);
			panel.add(btnNewButton);
			
			JButton btnHy_1 = new JButton("Hủy");
			btnHy_1.setBackground(Color.WHITE);
			btnHy_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// TODO Auto-generated method stub
					dispose();
					DoAn doAn1 = new DoAn();
					doAn1.setVisible(true);
				
				}
			});
			btnHy_1.setBounds(389, 264, 103, 32);
			panel.add(btnHy_1);
		}
	}