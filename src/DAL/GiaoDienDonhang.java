package DAL;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DTO.ClassDonHang;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



public class GiaoDienDonhang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane_1;
	private JTable table_mua;
	private JScrollPane scrollPane;
	private JTable table_ban;
	public static ArrayList<ClassDonHang> Donhang;
	public static ArrayList<ClassDonHang> Donmua;
	public static ArrayList<ClassDonHang> ChiTietHoaDon;
	private JTable table;
	private JButton btncapnhat = new JButton("Cập nhật");
	private JButton btnXa = new JButton("Xóa");
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JComboBox comboBox = new JComboBox();
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	/**
	 * Create the frame.
	 */
	public GiaoDienDonhang() {
		Donhang = new ArrayList<ClassDonHang>();
		Donmua = new ArrayList<ClassDonHang>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		this.setVisible(true);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 325, 556, 178);
		panel.add(scrollPane_1);
		
		table_mua = new JTable();
		table_mua.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "T\u1ED5ng Ti\u1EC1n", "\u0110\u1ECBa Ch\u1EC9 Nh\u1EADn H\u00E0ng", "T\u00ECnh Tr\u1EA1ng", "Ng\u00E0y Giao D\u1ECBch"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_mua.getColumnModel().getColumn(0).setResizable(false);
		table_mua.getColumnModel().getColumn(0).setPreferredWidth(23);
		table_mua.getColumnModel().getColumn(0).setMinWidth(8);
		table_mua.getColumnModel().getColumn(1).setResizable(false);
		table_mua.getColumnModel().getColumn(1).setPreferredWidth(85);
		table_mua.getColumnModel().getColumn(2).setResizable(false);
		table_mua.getColumnModel().getColumn(2).setPreferredWidth(162);
		table_mua.getColumnModel().getColumn(3).setResizable(false);
		table_mua.getColumnModel().getColumn(4).setResizable(false);
		table_mua.getColumnModel().getColumn(4).setPreferredWidth(86);
		scrollPane_1.setViewportView(table_mua);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 556, 194); 
		panel.add(scrollPane);
		
		table_ban = new JTable();
		
		
		JLabel lblNewLabel = new JLabel("Đơn hàng bán:");
		lblNewLabel.setIcon(new ImageIcon(GiaoDienDonhang.class.getResource("/anh/sell_40px.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 165, 41);
		panel.add(lblNewLabel);
		
		JLabel lblnHngMua = new JLabel("Đơn hàng mua :");
		lblnHngMua.setIcon(new ImageIcon(GiaoDienDonhang.class.getResource("/anh/buy_40px.png")));
		lblnHngMua.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblnHngMua.setBounds(10, 281, 220, 33);
		panel.add(lblnHngMua);
		btnXa.setIcon(new ImageIcon(GiaoDienDonhang.class.getResource("/anh/delete_file_40px.png")));
		
		btnXa.setBounds(818, 555, 130, 41);
		btnXa.setEnabled(false);
		panel.add(btnXa);
		btncapnhat.setIcon(new ImageIcon(GiaoDienDonhang.class.getResource("/anh/update_40px.png")));
		
		btncapnhat.setBounds(633, 555, 136, 41);
		btncapnhat.setEnabled(false);
		panel.add(btncapnhat);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Đang giao hàng", "Đã giao hàng"}));
		comboBox.setEnabled(false);
		comboBox.setBounds(633, 511, 136, 33);
		panel.add(comboBox);
		
		
		
		
		
		
		
		try {

			String queryl="SELECT ID,TongTien,DiaChiGH,TrangThai,NgayGD from HoaDon where IDNguoiDung = '"+ DoAn.ID + "' and LoaiGD = N'Bán'";
			ResultSet rs=DoAn.statement.executeQuery(queryl);
			while (rs.next())
			{
				ClassDonHang SP = new ClassDonHang(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getTime(5));
				Donhang.add(SP);
			}
					
		} catch (SQLException ex) 
		{
			JOptionPane.showMessageDialog(null, "Thất bại 1");
		}

		
		try {

		String queryl="SELECT ID,TongTien,DiaChiGH,TrangThai,NgayGD from HoaDon where IDNguoiDung = '"+ DoAn.ID + "' and LoaiGD = N'Mua'";
		ResultSet rs=DoAn.statement.executeQuery(queryl);
		
		while (rs.next())
		{
			ClassDonHang SP = new ClassDonHang(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5));
			Donmua.add(SP);
		}
				
	} catch (SQLException ex) 
	{
		JOptionPane.showMessageDialog(null, "Thất bại 2");
	}

		DefaultTableModel model1=(DefaultTableModel)table_mua.getModel();
		Object [] row1 =new Object[5];
					
	for(int i=0;i<Donmua.size();i++)
	{
		row1[0]=Donmua.get(i).getId();
		row1[1]=Donmua.get(i).getTongT();
		row1[2]=Donmua.get(i).getDiachi();
		row1[3]=Donmua.get(i).getTinhtrang();
		row1[4]=Donmua.get(i).getDate();
		model1.addRow(row1);		   
	}
	
	settable();
	HienThi();	
	
	
	
	
	table_ban.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			buttonx(true);
			int ii = table_ban.getSelectedRow();
			int a= Donhang.get(ii).getId();
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(595, 63, 370, 440);
			panel.add(scrollPane_2);
			
	
			btnXa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int kk = table_ban.getSelectedRow();
					if(Donhang.get(kk).getTinhtrang().equals("Đang bán")) {
					
					int a=JOptionPane.showConfirmDialog(null, "Bạn Chắc Chắn Muốn Xóa Hóa Đơn \nID:"+Donhang.get(kk).getId()+" ?", null, JOptionPane.YES_NO_OPTION);
					if(a==JOptionPane.YES_OPTION)
					{
						try {
							DoAn.statement.executeUpdate("DELETE FROM ChiTietHoaDon WHERE IDHoaDon="+Donhang.get(kk).getId()+"");
							DoAn.statement.executeUpdate("DELETE FROM HoaDon WHERE ID="+Donhang.get(kk).getId()+"");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}						
						Donhang.remove(kk);
						settable();
						HienThi();
						buttonx(false);
					}
				}else 
					{
						JOptionPane.showMessageDialog(null, "Chỉ Được Xóa Đơn Hàng Khi Trạng Thái \"Đang Bán\"");
					}
				}
			});
			
			btncapnhat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int kk = table_ban.getSelectedRow();
					if(Donhang.get(kk).getTinhtrang().equals("Đang bán")==false) {
					try {
						if(comboBox.getSelectedIndex()==0)
						{
							String ak= ""+Donhang.get(kk).getDate()+" "+Donhang.get(kk).getTime();
							DoAn.statement.executeUpdate("UPDATE HoaDon SET TrangThai = N'Đang giao hàng' WHERE ID="+Donhang.get(kk).getId()+"");
							DoAn.statement.executeUpdate("UPDATE HoaDon SET TrangThai = N'Đang giao hàng' WHERE ID!="+Donhang.get(kk).getId()+"and NgayGD= '"+ak+"' ");
							Donhang.get(kk).setTinhtrang("Đang giao hàng");
						}
						else
						{
							String ak= ""+Donhang.get(kk).getDate()+" "+Donhang.get(kk).getTime();
							DoAn.statement.executeUpdate("UPDATE HoaDon SET TrangThai = N'Đã giao hàng' WHERE ID="+Donhang.get(kk).getId()+"");
							DoAn.statement.executeUpdate("UPDATE HoaDon SET TrangThai = N'Đã giao hàng' WHERE ID!="+Donhang.get(kk).getId()+"and NgayGD= '"+ak+"' ");
							Donhang.get(kk).setTinhtrang("Đã giao hàng");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}					
					settable();
					HienThi();
					buttonx(false);
					}
					else JOptionPane.showMessageDialog(null, "Không thể cập nhật khi tình trạng là \"Đang Bán\"");
				}
			});
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"T\u00EAn S\u00E1ch", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(124);
			table.getColumnModel().getColumn(1).setPreferredWidth(56);
			table.getColumnModel().getColumn(3).setPreferredWidth(84);
			scrollPane_2.setViewportView(table);
			
			
			
			
			
			try {

				String queryl="select TenSP,SoLuong,DonGia,ThanhTien from ChiTietHoaDon where IDHoaDon = '"+a+"'";
				ResultSet rs=DoAn.statement.executeQuery(queryl);
				
				while (rs.next())
				{
					DefaultTableModel model1=(DefaultTableModel)table.getModel();
					Object [] row1 =new Object[4];
						row1[0]=rs.getString(1);
						row1[1]=rs.getInt(2);
						row1[2]=rs.getInt(3);
						row1[3]=rs.getInt(4);		
						model1.addRow(row1);
						
				}
			
				
				
			} catch (SQLException ex) 
			{
				JOptionPane.showMessageDialog(null, "Thất bại 4");
			}
			
		}
	});	
	
	table_mua.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int ii = table_mua.getSelectedRow();  //location 
			int a= Donmua.get(ii).getId();
			buttonx(false);
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(595, 63, 370, 440);
			panel.add(scrollPane_2);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"T\u00EAn S\u00E1ch", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(124);
			table.getColumnModel().getColumn(1).setPreferredWidth(56);
			table.getColumnModel().getColumn(3).setPreferredWidth(84);
			scrollPane_2.setViewportView(table);
			try {

				String queryl="select TenSP,SoLuong,DonGia,ThanhTien from ChiTietHoaDon where IDHoaDon = '"+a+"'";
				ResultSet rs=DoAn.statement.executeQuery(queryl);
				
				while (rs.next())
				{
//					ClassDonHang SP = new ClassDonHang(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
					DefaultTableModel model1=(DefaultTableModel)table.getModel();
					Object [] row1 =new Object[4];
						row1[0]=rs.getString(1);
						row1[1]=rs.getInt(2);
						row1[2]=rs.getInt(3);
						row1[3]=rs.getInt(4);		
						model1.addRow(row1);		   
				}
						
			} catch (SQLException ex) 
			{
				JOptionPane.showMessageDialog(null, "Thất bại 3");
			}
			
		}
	});	
}
	void buttonx(Boolean a)
	{
		btnXa.setEnabled(a);
		btncapnhat.setEnabled(a);
		comboBox.setEnabled(a);
	}
	void HienThi()
	{
		DefaultTableModel model=(DefaultTableModel)table_ban.getModel();
		Object [] row =new Object[5];
						
		for(int i=0;i<Donhang.size();i++)
		{
			row[0]=Donhang.get(i).getId();
			row[1]=Donhang.get(i).getTongT();
			row[2]=Donhang.get(i).getDiachi();
			row[3]=Donhang.get(i).getTinhtrang();
			row[4]=Donhang.get(i).getDate();
			model.addRow(row);		   
		}
	
	}
	void settable()
	{
		table_ban.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "T\u1ED5ng Ti\u1EC1n", "\u0110\u1ECBa Ch\u1EC9 Giao H\u00E0ng", "Tr\u1EA1ng Th\u00E1i", "Ng\u00E0y Giao D\u1ECBch"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table_ban.getColumnModel().getColumn(0).setResizable(false);
			table_ban.getColumnModel().getColumn(0).setPreferredWidth(26);
			table_ban.getColumnModel().getColumn(1).setResizable(false);
			table_ban.getColumnModel().getColumn(1).setPreferredWidth(85);
			table_ban.getColumnModel().getColumn(2).setResizable(false);
			table_ban.getColumnModel().getColumn(2).setPreferredWidth(189);
			table_ban.getColumnModel().getColumn(3).setResizable(false);
			table_ban.getColumnModel().getColumn(3).setPreferredWidth(110);
			table_ban.getColumnModel().getColumn(4).setResizable(false);
			table_ban.getColumnModel().getColumn(4).setPreferredWidth(85);
			scrollPane.setViewportView(table_ban);
	}
}
