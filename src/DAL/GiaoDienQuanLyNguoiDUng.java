package DAL;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DTO.ThongTinNguoiDungFull;

import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GiaoDienQuanLyNguoiDUng extends JFrame {
	private JTable table;
	private JPanel contentPane;
	public ArrayList<ThongTinNguoiDungFull> ThongTinFull;
	static GiaoDienQuanLyNguoiDUng frame ;
	static int  temp;
	
	static Object [] row;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GiaoDienQuanLyNguoiDUng() {
		GiaoDienQuanLyChiTietNguoiDung.temp2 = 0;
		GiaoDienQuanLyChiTietNguoiDung.temp1 = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 894, 270);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setUpdateSelectionOnSort(false);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					" ID người dùng", "Tên đăng nhập ", "Mật khẩu", "Họ và tên", "Phân Quyền", "Số điện thoại", "Ví Tiền"
				}
			) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,  Object.class
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
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getColumnModel().getColumn(2).setPreferredWidth(91);
			table.getColumnModel().getColumn(3).setResizable(false);
			table.getColumnModel().getColumn(4).setResizable(false);
			table.getColumnModel().getColumn(5).setResizable(false);
			table.getColumnModel().getColumn(6).setResizable(false);
			table.getColumnModel().getColumn(6).setPreferredWidth(100);
			scrollPane.setViewportView(table);
			table.getTableHeader().setReorderingAllowed(false);
			
			
			
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			
			
			 row =new Object[7];
			for(int i=0;i<DoAn.customers.size() ;i++)
			{
				
					
				row[0]= DoAn.customers.get(i).getID();
				row[1]= DoAn.customers.get(i).getTaiKhoan();
				row[2]= DoAn.customers.get(i).getMatKhau();
				row[3] = DoAn.inforUser.get(i).getTen();
				row[4] = DoAn.customers.get(i).getIDGroup();
				row[5] = DoAn.inforUser.get(i).getSDT();
				row[6] = DoAn.inforUser.get(i).getVitien();
				
				
				model.addRow(row);
			   }
			
			
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					temp = table.getSelectedRow();
					dispose();
					GiaoDienQuanLyChiTietNguoiDung GDQL = new GiaoDienQuanLyChiTietNguoiDung();
					GDQL.setVisible(true);
					frame.setVisible(false);
					
					
					
					
					
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
			btnNewButton_2.setBounds(10, 498, 68, 23);
			contentPane.add(btnNewButton_2);
			
			
			
			
			}
	
		 

		
		
		
		
		
	}

