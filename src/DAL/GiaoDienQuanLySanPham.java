package DAL;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GiaoDienQuanLySanPham extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static int temp = 0;
	static int temp2 = 0;
	static int ii = 0;
	
	static GiaoDienQuanLySanPham frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GiaoDienQuanLySanPham() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(10, 30, 808, 427);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setUpdateSelectionOnSort(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				" ID S\u00E1ch", "T\u00EAn S\u00E1ch", "ID Ng\u01B0\u1EDDi  B\u00E1n", "\u0110\u01A1n Gi\u00E1", "Th\u1EC3 Lo\u1EA1i", "S\u1ED1 L\u01B0\u1EE3ng", "Image"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, javax.swing.ImageIcon.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(137);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(91);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);
		
		

		DefaultTableModel model=(DefaultTableModel)table.getModel();
		Object [] row =new Object[7];
		for(int i=0;i<GiaoDienNguoiDung.classlistFull.size() ;i++)
		{
			if(GiaoDienNguoiDung.classlistFull.get(i).getSoluong()>0) 
			{
				
			row[0]=GiaoDienNguoiDung.classlistFull.get(i).getIDSanPham();
			row[1]=GiaoDienNguoiDung.classlistFull.get(i).getTensach();
			row[2]=GiaoDienNguoiDung.classlistFull.get(i).getIDNguoiBan();
			row[3]=GiaoDienNguoiDung.classlistFull.get(i).getDongia();
			row[4]=GiaoDienNguoiDung.classlistFull.get(i).getTheloai();
			row[5]=GiaoDienNguoiDung.classlistFull.get(i).getSoluong();
			if(GiaoDienNguoiDung.classlistFull.get(i).getHinh() != null) {
				
				 ImageIcon image = new ImageIcon(new ImageIcon(GiaoDienNguoiDung.classlistFull.get(i).getHinh()).getImage()
				             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );  
				row[6] =image;
				
			}
			else {
				row[6]=null;
			}
//			s
			model.addRow(row);
		   }
		}
		table.setRowHeight(120);
		
		JButton btnNewButton = new JButton("X\u00F3a s\u1EA3n ph\u1EA9m");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(140, 478, 116, 23);
		contentPane.add(btnNewButton);
		
		JButton btnThmSnPhm = new JButton("Th\u00EAm s\u1EA3n ph\u1EA9m");
		btnThmSnPhm.setBounds(565, 478, 116, 23);
		contentPane.add(btnThmSnPhm);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBounds(10, 497, 68, 23);
		contentPane.add(btnNewButton_2);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 ii = table.getSelectedRow();
				int a= GiaoDienNguoiDung.classlistFull.get(ii).getIDSanPham();
				temp = a;
				
			
				
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				dispose();
				GiaoDienNguoiDung GDQL = new GiaoDienNguoiDung();
				GDQL.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(temp == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần xóa");
					
					
				}
				else {
					try {
						
						DoAn.statement.executeUpdate("DELETE FROM SanPham WHERE ID = '"+  GiaoDienNguoiDung.classlistFull.get(ii).getIDSanPham() + " '");
						
						
						GiaoDienNguoiDung.classlistFull.remove(ii);
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Sản phẩm này đang có đơn đặt hàng! không thể xóa" + e1.getMessage());
					}
				
					JOptionPane.showMessageDialog(null, "thành công" + GiaoDienNguoiDung.classlistFull.get(ii).getIDSanPham());
				}
				
			}
		});
		
	}
}
