package DAL;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class GiaoDienQuanLyChiTietNguoiDung extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static GiaoDienQuanLyChiTietNguoiDung frame;
	static int temp1 = 0;
	static int temp2 = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new GiaoDienQuanLyChiTietNguoiDung();
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
	public GiaoDienQuanLyChiTietNguoiDung() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn ng\u01B0\u1EDDi d\u00F9ng:");
		lblNewLabel.setBounds(51, 27, 110, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(208, 27, 221, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00E0i kho\u1EA3n \u0111\u0103ng nh\u1EADp:");
		lblNewLabel_2.setBounds(51, 65, 147, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("M\u1EADt kh\u1EA9u \u0111\u0103ng nh\u1EADp:");
		lblNewLabel_2_1.setBounds(51, 104, 147, 14);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(208, 65, 221, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setBounds(208, 104, 221, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblaCh.setBounds(51, 140, 147, 14);
		panel.add(lblaCh);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSinThoi.setBounds(51, 182, 110, 14);
		panel.add(lblSinThoi);
		
		JLabel lblVTin = new JLabel("V\u00ED Ti\u1EC1n");
		lblVTin.setBounds(51, 220, 110, 14);
		panel.add(lblVTin);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setBounds(208, 140, 221, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("");
		lblNewLabel_1_1_2.setBounds(208, 182, 221, 14);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("");
		lblNewLabel_1_1_3.setBounds(208, 220, 110, 14);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(475, 27, 208, 207);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		
		btnNewButton.setBounds(284, 336, 145, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("X\u00F3a ng\u01B0\u1EDDi d\u00F9ng");
		btnNewButton_1.setBounds(463, 336, 145, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi:");
		lblNewLabel_4.setBounds(96, 308, 121, 14);
		panel.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(88, 337, 166, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1.setText(DoAn.inforUser.get(GiaoDienQuanLyNguoiDUng.temp).getTen());
		lblNewLabel_1_1.setText(DoAn.customers.get(GiaoDienQuanLyNguoiDUng.temp).getTaiKhoan());
		lblNewLabel_1_2.setText(DoAn.customers.get(GiaoDienQuanLyNguoiDUng.temp).getMatKhau());
		lblNewLabel_1_1_1.setText(DoAn.inforUser.get(GiaoDienQuanLyNguoiDUng.temp).getDiaChi());
		lblNewLabel_1_1_2.setText("" +DoAn.inforUser.get(GiaoDienQuanLyNguoiDUng.temp).getSDT());
		lblNewLabel_1_1_3.setText("" + DoAn.inforUser.get(GiaoDienQuanLyNguoiDUng.temp).getVitien());
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(temp1 == 1)
				DoAn.customers.get(GiaoDienQuanLyNguoiDUng.temp).setMatKhau(textField.getText()); 
				
				if(temp2 == 1) {
					DoAn.customers.remove(GiaoDienQuanLyNguoiDUng.temp);
				}
				dispose();
				GiaoDienQuanLyNguoiDUng GDQL = new GiaoDienQuanLyNguoiDUng();
				GDQL.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_2.setBounds(10, 347, 68, 23);
		panel.add(btnNewButton_2);
		
		
		if(DoAn.inforUser.get(GiaoDienQuanLyNguoiDUng.temp).getHinh() == null) {
			
			lblNewLabel_3.setIcon(new ImageIcon(DoAn.class.getResource("/anh/user.PNG")));
			
		}
		else {
		ImageIcon image = new ImageIcon(new ImageIcon(DoAn.inforUser.get(GiaoDienQuanLyNguoiDUng.temp).getHinh()).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
		lblNewLabel_3.setIcon(image);
		
		}
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		//		update NguoiDung set MatKhauND = '12' where IDNguoiDung = 17
				temp1 = 1;
			try {
				DoAn.statement.executeUpdate("update NguoiDung set MatKhauND = '"+ textField.getText() + "' where IDNguoiDung = '" + DoAn.inforUser.get(GiaoDienQuanLyNguoiDUng.temp).getID() + "' ");
				JOptionPane.showMessageDialog(null, "thành công");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			
				
			//	GiaoDienQuanLyNguoiDUng.row[2]= textField.getText();
			}
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					temp2 = 1;
				try {
					DoAn.statement.executeUpdate("DELETE FROM ThongTinNguoiDung WHERE IDNguoiDung = '"+   DoAn.inforUser.get(GiaoDienQuanLyNguoiDUng.temp).getID() + " '");
					DoAn.statement.executeUpdate("DELETE FROM NguoiDung         WHERE IDNguoiDung = '"+   DoAn.inforUser.get(GiaoDienQuanLyNguoiDUng.temp).getID()  + " '");
					JOptionPane.showMessageDialog(null, "thành công");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		
		
	}
}
