/*
Paolo S.
CS 2-1 | Final Hands-On Exam
*/

package Final;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JTextField txtContact;
	private JPasswordField Fpassword;
	private JPasswordField Fpassword1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	public signup() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Eclipse\\Images\\SEAdfL_.png"));
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("SIGN UP");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBackground(UIManager.getColor("Label.background"));
		lblTitle.setBounds(141, 29, 298, 27);
		contentPane.add(lblTitle);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Eclipse\\Images\\peninsula2.png"));
		lblBackground.setBounds(-171, -14, 834, 95);
		contentPane.add(lblBackground);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(245, 245, 245));
		panel.setBounds(0, 59, 581, 532);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(115, 41, 35, 17);
		panel.add(lblName);
		
		JLabel lblUserN = new JLabel("Username");
		lblUserN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserN.setBounds(115, 108, 61, 17);
		panel.add(lblUserN);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(115, 175, 31, 17);
		panel.add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact Number");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContact.setBounds(115, 242, 102, 17);
		panel.add(lblContact);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(115, 309, 58, 17);
		panel.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setBounds(115, 69, 355, 28);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsername.setColumns(10);
		txtUsername.setBounds(115, 136, 355, 28);
		panel.add(txtUsername);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(115, 203, 355, 28);
		panel.add(txtEmail);
		
		txtContact = new JTextField();
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContact.setColumns(10);
		txtContact.setBounds(115, 270, 355, 28);
		panel.add(txtContact);
		
		
		//REGISRATION
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = txtName.getText();
				String userN = txtUsername.getText();
				String email = txtEmail.getText();
				String contactNo = txtContact.getText();
				String password = Fpassword.getText();
				String cpassword = Fpassword1.getText(); //CONFIRM PASSWORD
				
				if(password.equals(cpassword)) {
					
					try {
						Statement st = database.mycon().createStatement();
						st.executeUpdate("INSERT INTO user (name, username, email, contact, password) VALUES ('"+Name+"','"+userN+"','"+email+"','"+contactNo+"','"+password+"') ");
						
						JOptionPane.showMessageDialog(null, "Congratulations, your account has been successfully created. Please Log in.", "Registration Successful", 2);
						
						dispose();
						new signin().setVisible(true);
						
					}catch(Exception ex) {
						System.out.println(ex);
					}
					
					txtName.setText("");
					txtUsername.setText("");
					txtEmail.setText("");
					txtContact.setText("");
					Fpassword.setText("");
					Fpassword1.setText("");
				
				} else { //PASSWORD DIDN'T MATCH
					JOptionPane.showMessageDialog(null, "The password confirmation does not match.", "Password Mismatch", 2);
				}
			}
		});
		btnRegister.setBackground(new Color(65, 105, 225));
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBounds(115, 455, 355, 28);
		panel.add(btnRegister);
		
		JLabel lblLog = new JLabel("Log in");
		lblLog.setForeground(new Color(0, 0, 205));
		lblLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Log in from registration
				
				new signin().setVisible(true); //WILL SHOW THE SIGNIN PAGE
				dispose(); //WILL CLOSE THE SIGNUP PAGE
			}
		});
		lblLog.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLog.setBounds(355, 494, 33, 15);
		panel.add(lblLog);
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");
		lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAlreadyHaveAn.setBounds(211, 494, 141, 15);
		panel.add(lblAlreadyHaveAn);
		
		JLabel lblCPassword = new JLabel("Confirm Password");
		lblCPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPassword.setBounds(115, 376, 110, 17);
		panel.add(lblCPassword);
		
		Fpassword = new JPasswordField();
		Fpassword.setBounds(115, 337, 355, 28);
		panel.add(Fpassword);
		
		Fpassword1 = new JPasswordField();
		Fpassword1.setBounds(115, 404, 355, 28);
		panel.add(Fpassword1);
	}
}
