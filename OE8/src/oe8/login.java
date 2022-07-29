/*
Paolo S.
CS 2-1 | OE8
*/

package oe8;

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

public class login extends JFrame {

	public JFrame frmLogin;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnExit;
	public static String USERNAME;

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
		initialize();
	}
	
	private void initialize() {
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsername.setBounds(169, 71, 342, 32);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setColumns(10);
		txtPassword.setBounds(169, 144, 342, 32);
		contentPane.add(txtPassword);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Eclipse\\Images\\User.png"));
		lblNewLabel.setBounds(69, 60, 60, 60);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Eclipse\\Images\\password.png"));
		lblNewLabel_1.setBounds(69, 129, 60, 60);
		contentPane.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("LOG IN"); //LOG IN BUTTON
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//set the mysql jdbc driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//set the Mysql connection string
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/copl_db","root","");
					Statement stmt = (Statement) con.createStatement();
					
					//sql query for the login
					String sql = "Select * from users_tbl where username='"+ txtUsername.getText().toString() +"' and password='"+ txtPassword.getText().toString() +"' ";
					
					//Execute the query
					ResultSet rs = ((java.sql.Statement)stmt).executeQuery(sql);
					
					//condition for the username and password
					if(rs.next()) {
						//JOptionPane.showMessageDialog(null, "Log in successful...", "Log in Alert", 2);
						
						dispose();// call dispose first before opening a new frame
						Dashboard dash = new Dashboard();
						dash.setVisible(true); //calling the main window
						USERNAME = txtUsername.getText();
						dash.lblUser.setText(USERNAME);
						//frmLogin.setVisible(false);
						
						
						
						JOptionPane.showMessageDialog(null, "Log in successful...", "Log in Alert", 2);
						
					}else if(txtUsername.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null, "Username is required...", "Log in Warning", 2);
					}else if(txtPassword.getText().trim().equals("")){
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
		btnLogin.setBounds(360, 198, 151, 32);
		contentPane.add(btnLogin);
		
		btnExit = new JButton("EXIT");
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
		btnExit.setBounds(169, 198, 151, 32);
		contentPane.add(btnExit);
	}
}
