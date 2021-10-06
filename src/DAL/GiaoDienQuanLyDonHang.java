package DAL;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DTO.ClassDonHang;

public class GiaoDienQuanLyDonHang extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table2;
	
	static Object [] row;	
	public static ArrayList<ClassDonHang> ListDonHang;
	static GiaoDienQuanLyDonHang frame;
	static int temp = 0;
	static int a  = 0;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GiaoDienQuanLyDonHang() {
		//GiaoDienDonhang a = new GiaoDienDonhang();
		ListDonHang = new ArrayList<ClassDonHang>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 894, 252);
		contentPane.add(scrollPane);
		
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(10, 32, 788, 268);
//		scrollPane.setSize(700, 400);
//		contentPane.add(scrollPane);
		
		
		table = new JTable();
		
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setUpdateSelectionOnSort(false);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					" ID đơn hàng", "Tổng tiền", "Địa chỉ", "Tình trạng"
				}
			) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getColumnModel().getColumn(2).setPreferredWidth(91);
			table.getColumnModel().getColumn(3).setResizable(false);
			
			
			scrollPane.setViewportView(table);
			table.getTableHeader().setReorderingAllowed(false);
			
			
			
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			
			
			 
			 
			 
			
			
			
			try {

				String queryl="SELECT ID,TongTien,DiaChiGH,TrangThai,NgayGD from HoaDon";
				ResultSet rs = DoAn.statement.executeQuery(queryl);
				
				while (rs.next())
				{
					ClassDonHang SP = new ClassDonHang(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5));
					ListDonHang.add(SP);
				}
						
			} catch (SQLException ex) 
			{
				JOptionPane.showMessageDialog(null, "Thất Bại 1" + ex.getMessage());
			}
			
			Object [] row =new Object[5];
			for(int i=0;i<ListDonHang.size();i++)
			{
				row[0]=ListDonHang.get(i).getId();
				row[1]=ListDonHang.get(i).getTongT();
				row[2]=ListDonHang.get(i).getDiachi();
				row[3]=ListDonHang.get(i).getTinhtrang();	
				row[4]=ListDonHang.get(i).getDate();
				model.addRow(row);		   
			}
//			for(int i=0;i<a.Donhang.size();i++)
//			{
//				row[0]=a.Donhang.get(i).getId();
//				row[1]=a.Donhang.get(i).getTongT();
//				row[2]=a.Donhang.get(i).getDiachi();
//				row[3]=a.Donhang.get(i).getTinhtrang();			
//				model.addRow(row);		   
//			}
			
	//		JOptionPane.showMessageDialog(null,"" + GiaoDienDonhang.Donhang.get(0).getId());	
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					temp = table.getSelectedRow();
//					 a= ListDonHang.get(temp).getId();
//					dispose();
//					GiaoDienQuanLyChiTietDonHang QL = new GiaoDienQuanLyChiTietDonHang();
//					QL.setVisible(true);
//					frame.setVisible(false);
					int ii = table.getSelectedRow();
					int a= ListDonHang.get(ii).getId();
					JScrollPane scrollPane_2 = new JScrollPane();
					scrollPane_2.setBounds(50, 320, 800, 150);
					contentPane.add(scrollPane_2);
					
					table2 = new JTable();
					table2.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"T\u00EAn S\u00E1ch", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
						}
					));
					table2.getColumnModel().getColumn(0).setPreferredWidth(124);
					table2.getColumnModel().getColumn(1).setPreferredWidth(56);
					table2.getColumnModel().getColumn(3).setPreferredWidth(84);
					scrollPane_2.setViewportView(table2);
					try {

						String queryl="select TenSP,SoLuong,DonGia,ThanhTien from ChiTietHoaDon where IDHoaDon = '"+a+"'";
						ResultSet rs=DoAn.statement.executeQuery(queryl);
						
						while (rs.next())
						{
//							ClassDonHang SP = new ClassDonHang(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
							DefaultTableModel model1=(DefaultTableModel)table2.getModel();
							Object [] row1 =new Object[4];
								row1[0]=rs.getString(1);
								row1[1]=rs.getInt(2);
								row1[2]=rs.getInt(3);
								row1[3]=rs.getInt(4);		
								model1.addRow(row1);
								
						}
					
					
					}	
				 catch (SQLException ex) 
				{
					JOptionPane.showMessageDialog(null, "Tháº¥t Báº¡i 4");
				}
				
				}	 
			});
			
			
			JButton btnNewButton_2 = new JButton("Back");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					dispose();
					GiaoDienNguoiDung GDQL = new GiaoDienNguoiDung();
					GDQL.setVisible(true);
					frame.setVisible(false);
					
				}
			});
			btnNewButton_2.setBounds(33, 487, 68, 23);
			contentPane.add(btnNewButton_2);
	}

}
