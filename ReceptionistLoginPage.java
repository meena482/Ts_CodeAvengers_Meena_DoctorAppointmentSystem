import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ReceptionistLoginPage extends JFrame {

	protected static final ReceptionistLoginPage Patientdetails = null;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	protected Window frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionistPortal frame = new ReceptionistPortal ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ReceptionistLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 319);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReceptionistLogin = new JLabel("RECEPTIONIST LOGIN");
		lblReceptionistLogin.setForeground(new Color(0, 0, 139));
		lblReceptionistLogin.setFont(new Font("Verdana", Font.ITALIC, 14));
		lblReceptionistLogin.setBounds(182, 11, 195, 14);
		contentPane.add(lblReceptionistLogin);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setForeground(new Color(128, 0, 0));
		lblUsername.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblUsername.setBounds(198, 56, 86, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setForeground(new Color(128, 0, 0));
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPassword.setBounds(198, 112, 86, 17);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(309, 56, 98, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(309, 109, 98, 23);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Meena\\Pictures\\Camera Roll\\receptionist-icon (1).png"));
		lblNewLabel.setBounds(30, 42, 135, 107);
		contentPane.add(lblNewLabel);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReceptionistPortal a=new ReceptionistPortal();
				a.setVisible(true);
				dispose();
			}
		});
		btnLogin.setForeground(new Color(0, 0, 205));
		btnLogin.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnLogin.setBounds(237, 188, 89, 23);
		contentPane.add(btnLogin);
	}
}