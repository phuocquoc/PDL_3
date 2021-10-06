package DAL;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DTO.ClassHoaDon;
import DTO.ClassSanPham;
import DTO.HinhAnh;


import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JSpinner;

public class GiaoDienNguoiDung extends DoAn {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	
	String tempp = "";
	DefaultTableModel dtm = null;
	public Connection conn;
	private JPanel contentPane;
	private JTextField texts;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane_1;
	public static JTable table_1;
	
	private JLabel lblTng;
	private JLabel tttt;
	ClassSanPham SP;
	public static ArrayList<ClassSanPham> classlist = new ArrayList<>();
	public static ArrayList<ClassSanPham> classlistFull = new ArrayList<>();
	public static ArrayList<HinhAnh> HinhAnh = new ArrayList<>();
	public static ArrayList<ClassHoaDon> listHoaDon = new ArrayList<>();
	ArrayList<Integer> soluong = new ArrayList<>();
	ArrayList<Integer> iDD = new ArrayList<>();
	int[] tien = new int[100];
	 static int Tong=0;
	 private JMenuItem mntmNewMenuItem;
		private JMenuItem mntmNewMenuItem_1;
		private JMenuItem mntmNewMenuItem_2;
		private JMenuItem mntmNewMenuItem_3;
		private JMenuItem mntmNewMenuItem_4;
		private JMenuItem mntmNewMenuItem_5;
		private JMenuItem mntmNewMenuItem_6;
		static GiaoDienNguoiDung okkk;
	int lq=0;
	int sl=0;
	int kk=0;
	private JLabel testt;
	String anh;
	JPanel panel;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	



	/**
	 * Create the frame.
	 */
	public GiaoDienNguoiDung() {
		
		classlistFull = new ArrayList<ClassSanPham>();
		classlist.clear();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1029, 727);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(15, 68, 988, 268);
		contentPane.add(scrollPane);
		
		texts = new JTextField();
		texts.setEnabled(false);
		texts.setEditable(false);
		texts.setHorizontalAlignment(SwingConstants.CENTER);
		texts.setBounds(294, 347, 0, 24);
		contentPane.add(texts);
		texts.setColumns(10);
		
		final JLabel txtsl = new JLabel("S\u1ED1 L\u01B0\u1EE3ng");
		txtsl.setHorizontalAlignment(SwingConstants.CENTER);
		txtsl.setIcon(new ImageIcon(GiaoDienNguoiDung.class.getResource("/anh/soluong.png")));
		txtsl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtsl.setBounds(38, 575, 117, 43);
		contentPane.add(txtsl);
		
		final JLabel vlais = new JLabel("");
		vlais.setFont(new Font("Tahoma", Font.BOLD, 14));
		vlais.setForeground(Color.RED);
		vlais.setBounds(30, 487, 238, 21);
		contentPane.add(vlais);
		
		final JLabel text111 = new JLabel("New label");
		text111.setBounds(32, 431, -10, 14);
		contentPane.add(text111);
		
		SpinnerNumberModel model1 = new SpinnerNumberModel(1.0, 0.0, 100.0, 1.0);
		JSpinner texts1 = new JSpinner(model1);
		texts1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texts1.setBounds(182, 581, 50, 30);
		contentPane.add(texts1);
		
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(38, 418, 0, 14);
		contentPane.add(lblNewLabel);
		
		JLabel okchua = new JLabel("");
		okchua.setBounds(217, 311, 64, 21);
		contentPane.add(okchua);
		
		btnNewButton = new JButton("Thêm Vào Giỏ Hàng");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setIcon(new ImageIcon(GiaoDienNguoiDung.class.getResource("/anh/rsz_add_shopping_cart_40px.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vlais.setText("");
				lq=0;
				sl=0;
				if(texts.getText().equals("")) 
					{
						JOptionPane.showMessageDialog(null,"Vui lòng chọn sách.");
						lq=1;
					}				
				else {
				int iDll=(int)Float.parseFloat(texts.getText());
				int slb=(int)Float.parseFloat(texts1.getValue().toString());				
				DefaultTableModel model=(DefaultTableModel) table_1.getModel();
				for(int i=0;i<classlist.size();i++)
				{	
					if(iDll==classlist.get(i).getIDSanPham()&&slb<=classlist.get(i).getSoluong())
					{		
													
							int mm=0;
								sl=slb;
							for(int TH:iDD)
							{									
								if(iDll==TH) 
								{									
									sl+=soluong.get(mm);									
								}
								mm++;
							}
							if(sl<=classlist.get(i).getSoluong())
							{	ClassHoaDon a;							
								soluong.add(slb);
								iDD.add(iDll);																															
								tien[i]=slb*classlist.get(i).getDongia();
								model.addRow(new Object[] {iDll,classlist.get(i).getTensach(),slb,classlist.get(i).getDongia(),tien[i]});
								a=new ClassHoaDon(iDll,classlist.get(i).getTensach(),slb,classlist.get(i).getDongia(),tien[i]);
								if(listHoaDon.size()==0)
									{
										listHoaDon.add(a);
									}
								else
									{
									for(int o=0;o<listHoaDon.size();o++)
										{
											
											if(iDll==listHoaDon.get(o).getMaS())
												{	
													kk=listHoaDon.get(o).getsLuog()+slb;
													listHoaDon.get(o).setsLuog(kk);
													listHoaDon.get(o).setThanhT(listHoaDon.get(o).getDonGia()*listHoaDon.get(o).getsLuog());
										
												}
											else if(o==listHoaDon.size()-1)
											{
												listHoaDon.add(a);
												break;
											}	
										}
									}
								Tong+=tien[i];								
								tttt.setText(""+Tong);
								lq=1;								
							}
							break;
					}		}			
				}
				if(lq==0)
				{
					vlais.setText("Vui lòng nhập số lượng phù hợp");
				}
				}
		});
		btnNewButton.setBounds(45, 622, 187, 43);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("X\u00F3a");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon(GiaoDienNguoiDung.class.getResource("/anh/rsz_delete_document_50px.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				model.setRowCount(0);
				tttt.setText("");
				iDD.clear();
				soluong.clear();
				Tong=0;
				listHoaDon.clear();
			}
		});
		btnNewButton_1.setBounds(286, 622, 187, 43);
		contentPane.add(btnNewButton_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(294, 394, 524, 179);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch", "S\u1ED1 L\u01B0\u1EE3ng", "\u0110\u01A1n Gi\u00E1", "Th\u00E0nh Ti\u1EC1n"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(82);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(250);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		table_1.getColumnModel().getColumn(4).setResizable(false);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(117);
		scrollPane_1.setViewportView(table_1);
		table_1.getTableHeader().setReorderingAllowed(false);
		
		lblTng = new JLabel("T\u1ED5ng ti\u1EC1n:");
		lblTng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTng.setBounds(541, 644, 108, 21);
		contentPane.add(lblTng);
		
		tttt = new JLabel("");
		tttt.setFont(new Font("Tahoma", Font.BOLD, 14));
		tttt.setForeground(Color.RED);
		tttt.setBounds(664, 644, 146, 21);
		contentPane.add(tttt);
		
		
		
		
		
		try {

			String queryl="SELECT Distinct * FROM SanPham inner join  NguoiDung  on IDnguoiban != '"+ DoAn.ID + "' where  NguoiDung.IDNguoiDung = '"+ DoAn.ID + "'";
			ResultSet rs=DoAn.statement.executeQuery(queryl);
			
			while (rs.next())
			{
				SP = new ClassSanPham(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getBytes(7));
				classlist.add(SP);

			}
					
		} catch (SQLException ex) 
		{
		}
		
		
		try {

			String queryl="SELECT  * FROM SanPham ";
			ResultSet rs=DoAn.statement.executeQuery(queryl);
			
			while (rs.next())
			{
				SP = new ClassSanPham(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getBytes(7));
				classlistFull.add(SP);

			}
					
		} catch (SQLException ex) 
		{
			JOptionPane.showMessageDialog(null, "1");
		}
		text111.setText(tempp);
		
		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setBackground(Color.WHITE);
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThanhToan.setIcon(new ImageIcon(GiaoDienNguoiDung.class.getResource("/anh/rsz_checkout_80px.png")));
		btnThanhToan.setBounds(825, 634, 178, 43);
		contentPane.add(btnThanhToan);
		
		btnThanhToan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(Tong==0)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần mua");				
				else {
				dispose();
				HoaDon HD = new HoaDon();
				HD.setVisible(true);
				}
			}
		});
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1010, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Thao tác");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_3 = new JMenuItem("Thông tin khách hàng");
		
		
		
		for(int i = 0; i < DoAn.inforUser.size();i++) {
			
			if(DoAn.ID == DoAn.inforUser.get(i).getID()) {
				
				
				if(DoAn.inforUser.get(i).getHinh() == null) {
			
					mntmNewMenuItem_3.setIcon(new ImageIcon(DoAn.class.getResource("/anh/user.PNG")));
					
				}
				else {
				ImageIcon image = new ImageIcon(new ImageIcon(DoAn.inforUser.get(i).getHinh()).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
				mntmNewMenuItem_3.setIcon(image);
				
				}
			}
		}

		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				InformationUserFix IF = new InformationUserFix();
				IF.setVisible(true);
			}
		});
		
		
		mnNewMenu.add(mntmNewMenuItem_3);
		
		
		
		mntmNewMenuItem = new JMenuItem("Giao diện bán");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GiaoDienNguoiBan ND = new GiaoDienNguoiBan();
				ND.setVisible(true);

			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_4 = new JMenuItem("Quản lí người dùng");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GiaoDienQuanLyNguoiDUng QLND = new GiaoDienQuanLyNguoiDUng();
				QLND.setVisible(true);

			}
		});
		mntmNewMenuItem_5 = new JMenuItem("Quản lí tất cả đơn hàng");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GiaoDienQuanLyDonHang QLDH = new GiaoDienQuanLyDonHang();
				QLDH.setVisible(true);

			}
		});
		mntmNewMenuItem_6 = new JMenuItem("Quản lí Sản phẩm");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GiaoDienQuanLySanPham QLDH = new GiaoDienQuanLySanPham();
				QLDH.setVisible(true);

			}
		});
		
		
		
		
		
		mntmNewMenuItem_1 = new JMenuItem("Tình trạng đơn hàng của bạn");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GiaoDienDonhang a = new GiaoDienDonhang();
				a.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DoAn doAn11 = new DoAn();
				doAn11.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		
		testt = new JLabel("");
		testt.setHorizontalAlignment(SwingConstants.CENTER);
		testt.setBounds(30, 394, 226, 170);
		contentPane.add(testt);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBorder(new TitledBorder(null, "Sách:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setbuton(classlist,panel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Giỏ hàng");
		lblNewLabel_1.setIcon(new ImageIcon(GiaoDienNguoiDung.class.getResource("/anh/rsz_shopping_cart_80px.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(299, 332, 163, 50);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(680, 37, 205, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Tìm kiếm");
		btnNewButton_2.setIcon(new ImageIcon(GiaoDienNguoiDung.class.getResource("/anh/search_20px.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList <ClassSanPham> timkiem = new ArrayList <ClassSanPham>();
				panel.removeAll();
				for(int i=0;i<classlist.size();i++)
					{
						if(classlist.get(i).getTensach().toLowerCase().contains(textField.getText().toLowerCase()))
						{	
							timkiem.add(classlist.get(i));
						}
					}
				
				JPanel aa = new JPanel();
				scrollPane.setViewportView(aa);
				aa.setBorder(new TitledBorder(null, "Sách:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				setbuton(timkiem,aa);
			}
		});
		btnNewButton_2.setBounds(902, 34, 101, 23);
		contentPane.add(btnNewButton_2);
		
		
		
		
		
		// Phan Quyen chuc nang
		
		
		if(DoAn.IDGroup == 2) {
			mnNewMenu.add(mntmNewMenuItem_4);
			mnNewMenu.add(mntmNewMenuItem_5);
			mnNewMenu.add(mntmNewMenuItem_6);
			
		}
		
		
		
		
	}
	
	void setbuton(ArrayList<ClassSanPham> classlist,JPanel panel)
	{
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<classlist.size() ;i++)
		{
			if(classlist.get(i).getSoluong()!=0)
			{ImageIcon image = new ImageIcon(new ImageIcon(classlist.get(i).getHinh()).getImage()
		             .getScaledInstance(150, 100, Image.SCALE_SMOOTH) );
			ImageIcon image1 = new ImageIcon(new ImageIcon(classlist.get(i).getHinh()).getImage()
		             .getScaledInstance(130, 170, Image.SCALE_SMOOTH) );
			JButton a= new JButton("",image);
			a.setText("<html> Mã Sách:"+classlist.get(i).getIDSanPham()+"<br /> Tên Sách:"+classlist.get(i).getTensach()+"<br /> Thể Loại:"+classlist.get(i).getTheloai()+"<br />Giá:"+classlist.get(i).getDongia()+"VND<br />Số Lượng:"+classlist.get(i).getSoluong()+"<br />ID Người Bán:"+classlist.get(i).getIDNguoiBan()+"</html>");
			int ll=classlist.get(i).getIDSanPham();
			//
			a.setSize(150,120);
			a.setFont(new Font("Verdana", Font.ITALIC, 12));
			a.setVerticalTextPosition(a.BOTTOM);
			a.setHorizontalTextPosition(a.CENTER);
			a.setHorizontalAlignment(SwingConstants.CENTER);
			a.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					testt.setIcon(image1);
					texts.setText(""+ll);
				}
			});
			panel.add(a);
		}
			
		}
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e2) {
			e2.printStackTrace();
		}
	}
}
