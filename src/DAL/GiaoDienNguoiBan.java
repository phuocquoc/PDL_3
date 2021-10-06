package DAL;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import DTO.FileTypeFiler;
import DTO.testt;

import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class GiaoDienNguoiBan extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TenSP;
	private JSpinner SoLuong;
	private JTextField TheLoai;
	private JTextField Gia;
	private File file;
	static GiaoDienNguoiBan okkk;
	private ArrayList<testt> test;
	private ArrayList<testt> test1;
	String anh;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public GiaoDienNguoiBan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 549);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên sách: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(GiaoDienNguoiBan.class.getResource("/anh/rsz_product_40px.png")));
		lblNewLabel.setBounds(20, 57, 182, 51);
		panel.add(lblNewLabel); 
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		
		JLabel lblnGi = new JLabel("\u0110\u01A1n gi\u00E1:");
		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblnGi.setIcon(new ImageIcon(GiaoDienNguoiBan.class.getResource("/anh/rsz_transaction_64px.png")));
		lblnGi.setBounds(20, 119, 187, 44);
		panel.add(lblnGi);
		
		JLabel lblThLoi = new JLabel("Th\u1EC3 lo\u1EA1i:");
		lblThLoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThLoi.setIcon(new ImageIcon(GiaoDienNguoiBan.class.getResource("/anh/sorting_30px.png")));
		lblThLoi.setHorizontalAlignment(SwingConstants.LEFT);
		lblThLoi.setBounds(20, 174, 182, 38);
		panel.add(lblThLoi);
		
		JLabel lblNewLabel_1 = new JLabel("Số lượng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setIcon(new ImageIcon(GiaoDienNguoiBan.class.getResource("/anh/soluong.png")));
		lblNewLabel_1.setBounds(20, 226, 182, 51);
		panel.add(lblNewLabel_1);
		
		TenSP = new JTextField();
		TenSP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TenSP.setOpaque(false);
		TenSP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 0, 0)));
		TenSP.setBackground(Color.CYAN);
		TenSP.setBounds(200, 75, 165, 19);
		panel.add(TenSP);
		TenSP.setColumns(10);
		
		SoLuong = new JSpinner();
		SoLuong.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		SoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SoLuong.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 0, 0)));
		SoLuong.setBackground(Color.LIGHT_GRAY);
		SoLuong.setBounds(200, 235, 165, 34);
		panel.add(SoLuong);
		
		TheLoai = new JTextField();
		TheLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TheLoai.setOpaque(false);
		TheLoai.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 0, 0)));
		TheLoai.setBackground(new Color(0, 255, 255));
		TheLoai.setBounds(200, 186, 165, 19);
		panel.add(TheLoai);
		TheLoai.setColumns(10);
		
		Gia = new JTextField();
		Gia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Gia.setOpaque(false);
		Gia.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 0, 0)));
		Gia.setBackground(new Color(0, 255, 255));
		Gia.setBounds(200, 131, 165, 19);
		panel.add(Gia);
		Gia.setColumns(10);
		
		JLabel lblHnhnh = new JLabel("Hình ảnh:");
		lblHnhnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHnhnh.setHorizontalAlignment(SwingConstants.LEFT);
		lblHnhnh.setIcon(new ImageIcon(GiaoDienNguoiBan.class.getResource("/anh/rsz_image_80px.png")));
		lblHnhnh.setBounds(20, 296, 192, 51);
		panel.add(lblHnhnh);
		
		JLabel HinhAnh = new JLabel("");
		HinhAnh.setHorizontalAlignment(SwingConstants.LEFT);
		HinhAnh.setIcon(new ImageIcon(GiaoDienNguoiBan.class.getResource("/anh/image.png")));
		HinhAnh.setSize(new Dimension(100, 100));
		HinhAnh.setBorder(new LineBorder(new Color(255, 0, 0)));
		HinhAnh.setBounds(197, 288, 168, 167);
		panel.add(HinhAnh);
		
		JButton btnBn = new JButton("Bán");
		btnBn.setIcon(new ImageIcon(GiaoDienNguoiBan.class.getResource("/anh/rsz_sell_64px.png")));
		btnBn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBn.setBounds(421, 404, 155, 51);
		panel.add(btnBn);
		
		JButton btnHinh = new JButton("Lấy hình");
		btnHinh.setIcon(new ImageIcon(GiaoDienNguoiBan.class.getResource("/anh/rsz_upload_64px.png")));
		btnHinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHinh.setBounds(10, 404, 155, 51);
		panel.add(btnHinh);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 623, 22);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Thao tác");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Giao diện mua");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GiaoDienNguoiDung ND = new GiaoDienNguoiDung();
				ND.setVisible(true);
				okkk.setVisible(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Trình trạng đơn hàng");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DoAn doAn11 = new DoAn();
				doAn11.setVisible(true);
				okkk.setVisible(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(GiaoDienNguoiBan.class.getResource("/anh/online_store_120px.png")));
		lblNewLabel_2.setBounds(421, 57, 182, 239);
		panel.add(lblNewLabel_2);
		
		
		
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
					HinhAnh.setIcon(new ImageIcon(file.getAbsolutePath()));
					anh=file.getAbsolutePath().replace("/", "//");
					}
					
					
					
					
			}
		});
		
		btnBn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					DoAn.statement.executeUpdate("INSERT INTO SanPham SELECT '"+ DoAn.ID + "' ,N'"+TenSP.getText() + "','" + Integer.parseInt(SoLuong.getValue().toString())+ "','" + Integer.parseInt(Gia.getText())+ "',N'" + TheLoai.getText()+ "',BulkColumn FROM OPENROWSET(BULK N'"+anh+"', SINGLE_BLOB) image; ");
					DoAn.statement.executeUpdate("INSERT INTO HoaDon values('"+ DoAn.ID + "','"+ Integer.parseInt(SoLuong.getValue().toString())*Integer.parseInt(Gia.getText())+"',N'Đang bán',null,N'Bán','"+dtf.format(now)+"')");
					
					String s="SELECT ID FROM HoaDon left join  ChiTietHoaDon  on ID != IDHOADON where HoaDon.TrangThai=N'Đang bán'";
					ResultSet rs = DoAn.statement.executeQuery(s);
					testt t = new testt();
					test = new ArrayList<testt>();
					while (rs.next()) {
						t.setID(rs.getInt(1));
						
						test.add(t);

					}
					rs.close();
					
					String s1="SELECT ID FROM SanPham left join  ChiTietHoaDon  on ID != IDSanPham ";
					ResultSet rs1 = DoAn.statement.executeQuery(s1);	
					testt t1 = new testt();					
					test1 = new ArrayList<testt>();
					while (rs1.next()) {
						t1.setID(rs1.getInt(1));
						
						test1.add(t1);

					}
					rs1.close();
					DoAn.statement.executeUpdate("Insert into ChiTietHoaDon values('"+test.get(0).getID()+"','"+test1.get(0).getID()+"',N'"+TenSP.getText() + "','" + Integer.parseInt(SoLuong.getValue().toString())+ "','" + Integer.parseInt(Gia.getText())+ "','"+ Integer.parseInt(SoLuong.getValue().toString())*Integer.parseInt(Gia.getText())+"')");
					dispose();
					GiaoDienDonhang SP = new GiaoDienDonhang();
					SP.setVisible(true);
					okkk.setVisible(false);
				} catch (Exception e2) {
					
					
				}
			}

			
		});
		
		
	}
}

