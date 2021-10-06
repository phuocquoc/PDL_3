package DAL;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.border.MatteBorder;

import DAO.SQL;
import DTO.InforUser;
import DTO.NguoiMua;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class DoAn extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String temp = "";
	private JTextField txtQuoc;
	private JPasswordField passwordField;
	public Connection conn;
	public static ArrayList<NguoiMua> customers;
	public static ArrayList<NguoiMua> customers2;
	public static ArrayList<InforUser> inforUser;
	public static Statement statement;
	public static int ID;
	public static int IDGroup;
	static DoAn frame;
	int pp = 0;
	int p = 0;
	
	
	

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					 frame = new DoAn();
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

	public DoAn() {
				
		
		getContentPane().setForeground(Color.BLACK);
		
		
		// Connect
		try {

			String dbURL = "jdbc:sqlserver://localhost;databaseName=SACHH;user=sa;password=sa";
			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
			temp = "Connected";

			}
		} catch (SQLException ex) {
			temp = "Not Connected";
			JOptionPane.showMessageDialog(null, ""+ex);
		}
		// ---------------------------------------

		getContentPane().setBackground(new Color(169, 169, 169));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 343);
		getContentPane().setLayout(null);

		txtQuoc = new JTextField("quoc13");
		txtQuoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuoc.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.ORANGE));
		txtQuoc.setForeground(Color.WHITE);
		txtQuoc.setBackground(new Color(169, 169, 169));
		txtQuoc.setToolTipText("Tài khoản");
		txtQuoc.setBounds(400, 107, 234, 19);
		getContentPane().add(txtQuoc);
		txtQuoc.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.addKeyListener(new KeyAdapter() {

		@SuppressWarnings("deprecation")
		public void keyPressed(KeyEvent e) 
				
			{
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				// TODO Auto-generated method stub
				String queryl2 = "SELECT * FROM NguoiDung where TaiKhoanND = '"+ txtQuoc.getText() +"' and MatKhauND = '" + passwordField.getText()+"' ";
				try {
					customers2 = new ArrayList<NguoiMua>();
					ResultSet rs =  statement.executeQuery(queryl2 );
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
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công.");
						dispose();
						GiaoDienNguoiDung SP = new GiaoDienNguoiDung();
						SP.setVisible(true);
						frame.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Tài khoản không hợp lệ");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			
				
				// TODO Auto-generated method stub

			}}
		});
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.ORANGE));
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(new Color(169, 169, 169));
		passwordField.setToolTipText("Mật khẩu");
		passwordField.setBounds(400, 174, 234, 19);
		getContentPane().add(passwordField);
		//setUndecorated(true);
		
	
		// --------------------------------------------
		 customers = new ArrayList<NguoiMua>();
		

		try {

			 statement = conn.createStatement();
			
				inforUser = new ArrayList<InforUser>();	
				try {

					String queryl= "SELECT * FROM ThongTinNguoiDung";
					ResultSet rs =  statement.executeQuery(queryl);
					InforUser IF ;
					while (rs.next())
					{
						IF = new InforUser(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getBytes(6));
						inforUser.add(IF);
					}
					rs.close();
							
				} catch (SQLException ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
			String s = "SELECT * FROM NguoiDung";
			ResultSet rs = statement.executeQuery(s);

			while (rs.next()) {
			
				NguoiMua NM = new NguoiMua();
				NM.setID(rs.getInt(1));
				NM.setTaiKhoan(rs.getString(2));
				NM.setMatKhau(rs.getString(3));	
				NM.setIDGroup(rs.getInt(4));
				customers.add(NM);	
	//			temp += "" + customers.size();
			
			}

			rs.close();
			
			
			
		} catch (Exception e) {
			
		}

		// ---------------------------------------
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("Thoát");
		btnNewButton_2.setBounds(new Rectangle(1, 1, 1, 1));
		btnNewButton_2.setFocusCycleRoot(true);
		btnNewButton_2.setFocusTraversalPolicyProvider(true);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setRequestFocusEnabled(false);
		btnNewButton_2.setRolloverEnabled(false);
		btnNewButton_2.setForeground(new Color(169, 169, 169));
		btnNewButton_2.setIcon(new ImageIcon(DoAn.class.getResource("/anh/tắt.png")));
		btnNewButton_2.setBackground(new Color(169, 169, 169));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setBounds(644, 0, 54, 51);
		getContentPane().add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				disable();
				System.exit(0);
			}
		});
		
		JLabel lblBook = new JLabel("Books");
		lblBook.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBook.setBounds(122, 283, 45, 13);
		getContentPane().add(lblBook);
		
		JLabel lblA = new JLabel("");
		lblA.setIcon(new ImageIcon(DoAn.class.getResource("/anh/92461402_152803256113716_6881816030977458176_n.png")));
		lblA.setBounds(21, 31, 268, 263);
		getContentPane().add(lblA);
		
		JLabel text = new JLabel("");
		text.setBackground(new Color(153, 180, 209));
		text.setOpaque(true);
		text.setBounds(0, 0, 289, 320);
		getContentPane().add(text);
		
		JLabel lblTiKhon = new JLabel("Tài Khoản: ");
		lblTiKhon.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTiKhon.setForeground(Color.RED);
		lblTiKhon.setBounds(400, 84, 98, 13);
		getContentPane().add(lblTiKhon);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMtKhu.setForeground(Color.RED);
		lblMtKhu.setBounds(400, 151, 98, 13);
		getContentPane().add(lblMtKhu);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(new Color(105, 105, 105));
		label.setBounds(272, -3, 426, 57);
		getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Trạng Thái: ");
		lblNewLabel.setBounds(322, 284, 245, 13);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setText("Trạng Thái: " + temp);
		
		JButton btnDN = new JButton("Đăng Nhập");
		btnDN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDN.setBackground(Color.WHITE);
		btnDN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SQL a =new SQL();
				a.Login(customers2, txtQuoc, passwordField, PROPERTIES, WIDTH, IDGroup, frame);
			}
		});
		btnDN.setBounds(400, 221, 98, 32);
		getContentPane().add(btnDN);
		
		JButton btnDK = new JButton("Đăng kí");
		btnDK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDK.setBackground(Color.WHITE);
		btnDK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DangKy DK = new DangKy();						
				DK.setVisible(true);
			}
		});
		btnDK.setBounds(536, 221, 98, 32);
		getContentPane().add(btnDK);
	
		
	}
	
}
