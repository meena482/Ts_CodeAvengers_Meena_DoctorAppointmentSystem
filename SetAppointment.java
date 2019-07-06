import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class SetAppointment extends JFrame {

	protected static final String APPOINTMENT = null;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetAppointment frame = new SetAppointment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public SetAppointment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSetAppointment = new JLabel("SET APPOINTMENT");
		lblSetAppointment.setBounds(339, 11, 276, 14);
		lblSetAppointment.setFont(new Font("Trebuchet MS", Font.ITALIC, 19));
		contentPane.add(lblSetAppointment);
		
		JLabel lblDoctorDetails = new JLabel("Doctor Details");
		lblDoctorDetails.setBounds(60, 124, 112, 14);
		lblDoctorDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblDoctorDetails);
		
		JLabel lblSpecalist = new JLabel("Specalist");
		lblSpecalist.setBounds(60, 170, 112, 14);
		lblSpecalist.setForeground(new Color(0, 153, 153));
		lblSpecalist.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblSpecalist);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(195, 168, 151, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" ", "cardiologist", "surgeon", "kids", "neurologist", "psychiatrist", "urologist", "gynecologist", "pediatrician", "nephrologist"}));
		contentPane.add(comboBox);
		
		JButton btnView = new JButton("VIEW");
		btnView.setBounds(515, 167, 89, 23);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
	    
			}
		});
		contentPane.add(btnView);
		
		table = new JTable();
		table.setBounds(206, 300, 71, -21);
		contentPane.add(table);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 229, 711, 77);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"doc_id", "doc_name", "specalist", "city", "visiting time"
			}
		));
		scrollPane.setViewportView(table_1);
		
		JLabel lblDATE = new JLabel("Date");
		lblDATE.setBounds(40, 334, 46, 14);
		contentPane.add(lblDATE);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(93, 334, 112, 20);
		contentPane.add(dateChooser);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(40, 367, 46, 14);
		contentPane.add(lblTime);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(93, 365, 112, 20);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "1:00am", "2:00am", "3:00am", "4:00am", "5:00am", "6:00am", "7:00am", "8:00am", "9:00am", "10:00am", "11:00am", "12:00am", "1:00pm", "2:00pm", "3:00pm", "4:00pm", "5:00pm", "6:00pm", "7:00pm", "8:00pm"}));
		contentPane.add(comboBox_1);
		
		JButton btnSetAppointment_1 = new JButton("SET APPOINTMENT");
		btnSetAppointment_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "APPOINTMENT NOT Succefully");
			}
		});
		btnSetAppointment_1.setBackground(UIManager.getColor("Button.background"));
		btnSetAppointment_1.setBounds(406, 352, 177, 23);
		contentPane.add(btnSetAppointment_1);
		
		JLabel lblPatid = new JLabel("PAT_ID");
		lblPatid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPatid.setBounds(93, 66, 46, 14);
		contentPane.add(lblPatid);
		
		textField = new JTextField();
		textField.setBounds(195, 64, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDisease = new JLabel("DISEASE");
		lblDisease.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDisease.setBounds(420, 67, 86, 14);
		contentPane.add(lblDisease);
		
		textField_1 = new JTextField();
		textField_1.setBounds(515, 64, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientDetails a=new PatientDetails();
				a.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(694, 352, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Meena\\Pictures\\Camera Roll\\doctor-hearthands-copy-1024x417.jpg"));
		lblNewLabel.setBounds(10, 0, 865, 403);
		contentPane.add(lblNewLabel);
	}
}