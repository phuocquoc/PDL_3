package DAL;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import DTO.testt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class HoaDon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ten;
	private JTextField sdt;
	private JTextField DiaChi;
	private JScrollPane scrollPane_1;
	private ArrayList<testt> test; 
	static HoaDon HD1;
	String t1t;
	int qq;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public HoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 626);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		JLabel lblThngTinNgi = new JLabel("Th\u00F4ng tin ng\u01B0\u1EDDi mua h\u00E0ng");
		lblThngTinNgi.setIcon(new ImageIcon(HoaDon.class.getResource("/anh/information_50px.png")));
		lblThngTinNgi.setFont(lblThngTinNgi.getFont().deriveFont(Font.PLAIN, 20f));
		lblThngTinNgi.setBounds(53, 10, 323, 50);
		contentPane.add(lblThngTinNgi);
		
		JLabel lblTnNgiNhn = new JLabel("T\u00EAn ng\u01B0\u1EDDi nh\u1EADn:");
		lblTnNgiNhn.setIcon(new ImageIcon(HoaDon.class.getResource("/anh/name_tag_40px.png")));
		lblTnNgiNhn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnNgiNhn.setBounds(53, 81, 146, 33);
		contentPane.add(lblTnNgiNhn);
		
		ten = new JTextField();
		ten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ten.setOpaque(false);
		ten.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		ten.setBounds(230, 91, 222, 19);
		contentPane.add(ten);
		ten.setColumns(10);
		t1t=ten.getText();
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSinThoi.setIcon(new ImageIcon(HoaDon.class.getResource("/anh/phone_30px.png")));
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(53, 125, 125, 29);
		contentPane.add(lblSinThoi);
		
		sdt = new JTextField();
		sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sdt.setOpaque(false);
		sdt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		sdt.setBounds(230, 133, 222, 19);
		contentPane.add(sdt);
		sdt.setColumns(10);
		sdt.setText("");
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblaCh.setIcon(new ImageIcon(HoaDon.class.getResource("/anh/address_40px.png")));
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(53, 165, 125, 36);
		contentPane.add(lblaCh);
		
		DiaChi = new JTextField();
		DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DiaChi.setOpaque(false);
		DiaChi.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		DiaChi.setBounds(230, 177, 222, 18);
		contentPane.add(DiaChi);
		DiaChi.setColumns(10);
		DiaChi.setText("");
		
		JLabel lblTngTin = new JLabel("T\u1ED5ng ti\u1EC1n:");
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTngTin.setBounds(582, 474, 101, 33);
		contentPane.add(lblTngTin);
		
		JLabel tien = new JLabel("");
		tien.setFont(new Font("Tahoma", Font.BOLD, 16));
		tien.setForeground(Color.RED);
		tien.setBounds(746, 480, 157, 20);
		contentPane.add(tien);
		
		JButton btntHng = new JButton("\u0110\u1EB7t H\u00E0ng");
		btntHng.setIcon(new ImageIcon(HoaDon.class.getResource("/anh/purchase_order_50px.png")));
		btntHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btntHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(ten.getText().equals("")||sdt.getText().equals("")||DiaChi.getText().equals("")) JOptionPane.showMessageDialog(null, "Nhập Đầy Đủ Tên, SDT Và Địa Chỉ");
					else {
						DoAn.statement.executeUpdate("insert into HoaDon values ('"+DoAn.ID+"','"+GiaoDienNguoiDung.Tong+"',N'Đang xử lý',N'Tên:"+ten.getText()+"   SDT:"+sdt.getText()+"     DiaChi:"+DiaChi.getText()+"','Mua','"+dtf.format(now)+"')"); ///
						String s="SELECT ID FROM HoaDon left join  ChiTietHoaDon  on ID != IDHOADON where HoaDon.TrangThai= N'Đang xử lý'";
						ResultSet rs = DoAn.statement.executeQuery(s);					
						testt t = new testt();
						test = new ArrayList<testt>();
						while (rs.next()) {
							t.setID(rs.getInt(1));
							
							test.add(t);

						}
						rs.close();

						for(int i=0;i<GiaoDienNguoiDung.listHoaDon.size();i++)
						{	int k1 = 0;
							int k2 = 0;
							int k3 = 0;
							String s1="select ID from HoaDon left join ChiTietHoaDon on ID = IDHoaDon where TrangThai = N'Đang bán'   and IDSanPham='"+GiaoDienNguoiDung.listHoaDon.get(i).getMaS()+"'";
							ResultSet rs1 = DoAn.statement.executeQuery(s1);					
							testt t1 = new testt();
							ArrayList<testt> test1 = new ArrayList<testt>();
							while (rs1.next()) {
								t1.setID(rs1.getInt(1));								
								test1.add(t1);

							}
							
							for(int l=0;l<GiaoDienNguoiDung.classlist.size();l++)
							{
								if(GiaoDienNguoiDung.classlist.get(l).getIDSanPham()==GiaoDienNguoiDung.listHoaDon.get(i).getMaS())
								{
									k1=GiaoDienNguoiDung.classlist.get(l).getSoluong()*GiaoDienNguoiDung.classlist.get(l).getDongia()-GiaoDienNguoiDung.listHoaDon.get(i).getThanhT();
									k2=GiaoDienNguoiDung.classlist.get(l).getSoluong()-GiaoDienNguoiDung.listHoaDon.get(i).getsLuog();
									k3=GiaoDienNguoiDung.classlist.get(l).getIDNguoiBan();
								}
							}

							DoAn.statement.executeUpdate("insert into ChiTietHoaDon values ('"+test.get(0).getID()+"','"+GiaoDienNguoiDung.listHoaDon.get(i).getMaS()+"',N'"+GiaoDienNguoiDung.listHoaDon.get(i).getTenS()+"','"+GiaoDienNguoiDung.listHoaDon.get(i).getsLuog()+"','"+GiaoDienNguoiDung.listHoaDon.get(i).getDonGia()+"','"+GiaoDienNguoiDung.listHoaDon.get(i).getThanhT()+"')");
							JOptionPane.showMessageDialog(null, "test"+test1.get(0).getID()+k1);
							DoAn.statement.executeUpdate("update HoaDon set TongTien = '"+k1+"' where ID='"+test1.get(0).getID()+"'");
							JOptionPane.showMessageDialog(null, "test1");
							DoAn.statement.executeUpdate("update ChiTietHoaDon set ThanhTien = "+k1+",Soluong='"+k2+"' where IDHoaDon='"+test1.get(0).getID()+"'");
							JOptionPane.showMessageDialog(null, "test2");
							DoAn.statement.executeUpdate("insert into HoaDon values ('"+k3+"','"+GiaoDienNguoiDung.Tong+"',N'Xác nhận đơn hàng',N'Tên:"+ten.getText()+"   SDT:"+sdt.getText()+"     DiaChi:"+DiaChi.getText()+"',N'Bán','"+dtf.format(now)+"')"); 
							JOptionPane.showMessageDialog(null, "test3");
							String s2="select Top 1 ID from HoaDon order by ID desc";
							ResultSet rs2 = DoAn.statement.executeQuery(s2);					
							testt t2 = new testt();
							ArrayList<testt> test2 = new ArrayList<testt>();
							while (rs2.next()) {
								t2.setID(rs2.getInt(1));								
								test2.add(t2);

							}
							rs2.close();
							JOptionPane.showMessageDialog(null, ""+test2.get(0).getID());
							DoAn.statement.executeUpdate("insert into ChiTietHoaDon values ('"+test2.get(0).getID()+"','"+GiaoDienNguoiDung.listHoaDon.get(i).getMaS()+"',N'"+GiaoDienNguoiDung.listHoaDon.get(i).getTenS()+"','"+GiaoDienNguoiDung.listHoaDon.get(i).getsLuog()+"','"+GiaoDienNguoiDung.listHoaDon.get(i).getDonGia()+"','"+GiaoDienNguoiDung.listHoaDon.get(i).getThanhT()+"')");
							for(int j=0;j<GiaoDienNguoiDung.classlist.size();j++)
							{
								
								if(GiaoDienNguoiDung.listHoaDon.get(i).getMaS()==GiaoDienNguoiDung.classlist.get(j).getIDSanPham())
								{
																	
										 qq=GiaoDienNguoiDung.classlist.get(j).getSoluong()-GiaoDienNguoiDung.listHoaDon.get(i).getsLuog();
										 DoAn.statement.executeUpdate(" UPDATE SanPham SET SoLuong = '"+qq+"' WHERE ID = '"+GiaoDienNguoiDung.classlist.get(j).getIDSanPham()+"'");															
								}		
							
							}
						
					   } 
						dispose();
						GiaoDienDonhang HD = new GiaoDienDonhang();
						HD.setVisible(true);
//						HD1.setVisible(false);
					}			
				}
				catch (Exception e2) {

				 JOptionPane.showMessageDialog(null, ""+e2);
				}
		}
		});
		btntHng.setBackground(Color.WHITE);
		btntHng.setForeground(Color.BLACK);
		btntHng.setBounds(712, 526, 191, 50);
		contentPane.add(btntHng);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setRequestFocusEnabled(false);
		scrollPane_1.setBounds(40, 212, 863, 230);
		contentPane.add(scrollPane_1);
		scrollPane_1.setViewportView(GiaoDienNguoiDung.table_1);
		
		
			
		tien.setText("" + GiaoDienNguoiDung.Tong);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(HoaDon.class.getResource("/anh/delivery_120px.png")));
		lblNewLabel.setBounds(619, 60, 196, 120);
		contentPane.add(lblNewLabel);
		
	}
}
