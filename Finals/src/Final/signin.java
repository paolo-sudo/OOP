/*
Paolo S.
CS 2-1 | Final Hands-On Exam
*/

package Final;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class signin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signin frame = new signin();
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
	public signin() {
		initialize();
		
		con = database.mycon();
	}
	
	
	private void initialize() {
		setTitle("Log In");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Eclipse\\Images\\SEAdfL_.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Eclipse\\Images\\peninsula2.png"));
		lblNewLabel.setBounds(-256, -37, 658, 488);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Log in to Your Account");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(510, 48, 182, 22);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(436, 104, 66, 17);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsername.setBounds(436, 132, 341, 31);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(436, 187, 66, 17);
		contentPane.add(lblPassword);
		
		
		//LOGIN
		JButton btnLogin = new JButton("LOGIN"); 
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtUsername.getText();
				String pass = txtPassword.getText();
				
				try {
					String sql = "SELECT * FROM user WHERE username=? AND password=?";
					ps = con.prepareCall(sql);
					
					ps.setString(1, name); //USERNAME
					ps.setString(2, pass); //PASSWORD
					
					rs = ps.executeQuery();
					
					if(rs.next()) { //IF TRUE, PROCEED IF
						JOptionPane.showMessageDialog(null, "Log in Successful", "Log in Success", 2);
						
						new mwindow(name).setVisible(true);
						dispose();
						
					}else if(txtUsername.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null, "Username is required", "Log in Warning", 2);
					}else if(txtPassword.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null, "Password is required", "Log in Warning", 2);
					}else {
						JOptionPane.showMessageDialog(null, "Username or Password incorrect", "Log in Warning", 2);
						//JOptionPane.showMessageDialog(rootPane, "Login Failed");
					}

				}catch(Exception ex) {
					System.out.print(ex);
				}
				

			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(65, 105, 225));
		btnLogin.setBounds(436, 291, 341, 31);
		contentPane.add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBounds(436, 215, 341, 31);
		contentPane.add(txtPassword);
		
		JLabel lblClickHere = new JLabel("Click here");
		lblClickHere.setForeground(new Color(0, 0, 205));
		lblClickHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new signup().setVisible(true); //WILL SHOW THE SIGNUP PAGE
				dispose(); //WILL CLOSE THE SIGNIN PAGE
			}
		});
		lblClickHere.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClickHere.setBounds(540, 354, 52, 15);
		contentPane.add(lblClickHere);
		
		JCheckBox chckbxPass = new JCheckBox("Show Password");
		chckbxPass.setBackground(UIManager.getColor("Button.background"));
		chckbxPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxPass.isSelected()) {
					txtPassword.setEchoChar((char)0);
				}else {
					txtPassword.setEchoChar('�');
				}
			}
		});
		chckbxPass.setBounds(432, 253, 130, 23);
		contentPane.add(chckbxPass);
		
		JLabel lblNeedAnAccount_1 = new JLabel("Need an account?");
		lblNeedAnAccount_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNeedAnAccount_1.setBounds(436, 354, 100, 15);
		contentPane.add(lblNeedAnAccount_1);
	}
}
