/*
Paolo S.
CS 2-1 | PT4
*/

package copl_ex1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import com.sun.jdi.connect.spi.Connection;
import com.mysql.jdbc.Driver;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.SystemColor;

public class login extends JFrame {

	public JFrame frmLogin;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JLabel lblLoginImage;
	private JButton btnExit;
	public static String USERNAME;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Eclipse\\Images\\SEAdfL_.png"));
		initialize();
	}
	
	private void initialize() {
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPass.setBounds(405, 214, 342, 32);
		contentPane.add(txtPass);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsername.setBounds(405, 128, 342, 32);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		lblLoginImage = new JLabel("");
		lblLoginImage.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoginImage.setIcon(new ImageIcon("C:\\Eclipse\\Images\\login2.png"));
		lblLoginImage.setBounds(-253, -65, 606, 486);
		contentPane.add(lblLoginImage);
		
		JButton btnLogin = new JButton("LOG IN"); //LOG IN BUTTON
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 102, 204));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//set the mysql jdbc driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//set the Mysql connection string
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/copl_db","root","");
					Statement stmt = (Statement) con.createStatement();
					
					//sql query for the login
					String sql = "Select * from users_tbl where username='"+ txtUsername.getText().toString() +"' and password='"+ txtPass.getText().toString() +"' ";
					
					//Execute the query
					ResultSet rs = stmt.executeQuery(sql);
					
					//condition for the username and password
					if(rs.next()) {		
						JOptionPane.showMessageDialog(null, "Log in successful...", "Log in Alert", 2);
						
						dispose();// call dispose first before opening a new frame
						Dashboard window = new Dashboard();
						
						window.show();
						//dash.setVisible(true); //calling the main window
						USERNAME = txtUsername.getText().toString();
						window.txtUser.setText("User : " + USERNAME.toUpperCase());
						
						//dash.lblUser.setText(USERNAME)
						//frmLogin.setVisible(false);
						
					}else if(txtUsername.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null, "Username is required...", "Log in Warning", 2);
					}else if(txtPass.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null, "Password is required...", "Log in Warning", 2);
					}else {
						JOptionPane.showMessageDialog(null, "Username or Password incorrect...", "Log in Warning", 2);
					}
					
				}catch(Exception ex){
					System.out.print(ex);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(405, 295, 342, 32);
		contentPane.add(btnLogin);
		
		btnExit = new JButton("EXIT");
		btnExit.setEnabled(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ex = JOptionPane.showConfirmDialog(null, "Do you want to close this program?", "Exit Program",JOptionPane.YES_NO_OPTION);
				if (ex==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				else if (ex==JOptionPane.NO_OPTION) {
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBounds(202, 338, 151, 32);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(405, 97, 76, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(405, 182, 67, 20);
		contentPane.add(lblPassword);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogIn.setBounds(405, 49, 58, 22);
		contentPane.add(lblLogIn);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setBackground(new Color(245, 245, 245));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					txtPass.setEchoChar((char)0);
				}else {
					txtPass.setEchoChar('�');
				}
			}
		});
		chckbxNewCheckBox.setBounds(401, 254, 101, 23);
		contentPane.add(chckbxNewCheckBox);
	}
}
