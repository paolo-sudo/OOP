/*
Paolo S.
CS 2-1 | OE9
*/

package copl_ex1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Dashboard extends JFrame {
	
	public JFrame frmDashboard;
	//JLabel lblUser;
	
	private JPanel contentPane;
	JTextField txtUser;
	private JTable tableView;
	private JTextField txtStudentNo;
	private JTextField txtStudentName;
	private JTextField txtAddress;
	private JLabel lblNewLabel_3;
	private JButton btnView;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClear;
	private JButton btnExit;
	private JTextField txtSearch;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane;
	DefaultTableModel model;
	private JLabel lblHeaderImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1170, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setForeground(new Color(105, 105, 105));
		txtUser.setEditable(false);
		txtUser.setBackground(new Color(245, 245, 245));
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUser.setBounds(938, 33, 186, 40);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtUser.setText(login.USERNAME);
		
		JLabel lblNewLabel = new JLabel("STUDENT RECORD SYSTEM");
		lblNewLabel.setBackground(new Color(245, 245, 245));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(23, 39, 245, 25);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(560, 205, 564, 396);
		contentPane.add(scrollPane);
		
		tableView = new JTable(); //TABLE
		tableView.setBackground(new Color(192, 192, 192));
		//model = new DefaultTableModel();
		//Object[] column = {"Number", "Student No", "Student Name", "Address", "Date of Registration"};
		//Object[] row = new Object[0];
		//model.setColumnIdentifiers(column);
		//tableView.setModel(model);
		scrollPane.setViewportView(tableView);
		
		txtStudentNo = new JTextField();
		txtStudentNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtStudentNo.setBounds(163, 205, 353, 33);
		contentPane.add(txtStudentNo);
		txtStudentNo.setColumns(10);
		
		txtStudentName = new JTextField();
		txtStudentName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtStudentName.setColumns(10);
		txtStudentName.setBounds(163, 249, 353, 33);
		contentPane.add(txtStudentName);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		txtAddress.setBounds(163, 293, 353, 33);
		contentPane.add(txtAddress);
		
		JLabel lblNewLabel_1 = new JLabel("Student Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(37, 209, 116, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(53, 253, 100, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(96, 297, 57, 20);
		contentPane.add(lblNewLabel_3);
		
		//You can add if statement here to check if it will be connected to the database
		
		JButton btnAdd = new JButton("Add"); //ADD BUTTON
		btnAdd.setBackground(new Color(245, 245, 245));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRecord();//call to the add method
			}
		});
				
		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(400, 356, 116, 33);
		contentPane.add(btnAdd);
		
		btnView = new JButton("View");
		btnView.setBackground(new Color(245, 245, 245));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewRecords();
			}
		});
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnView.setBounds(400, 411, 116, 25);
		contentPane.add(btnView);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(245, 245, 245));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(400, 447, 116, 25);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(245, 245, 245));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(400, 483, 116, 25);
		contentPane.add(btnDelete);
		
		btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(245, 245, 245));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextfield();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear.setBounds(274, 356, 116, 33);
		contentPane.add(btnClear);
		
		btnExit = new JButton("Exit"); //EXIT METHOD
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(220, 20, 60));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(400, 519, 116, 25);
		contentPane.add(btnExit);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSearch.setColumns(10);
		txtSearch.setBounds(617, 151, 507, 33);
		contentPane.add(txtSearch);
		
		lblNewLabel_4 = new JLabel("Search");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(560, 158, 47, 20);
		contentPane.add(lblNewLabel_4);
		
		lblHeaderImage = new JLabel("");
		lblHeaderImage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeaderImage.setVerticalAlignment(SwingConstants.TOP);
		lblHeaderImage.setIcon(new ImageIcon("C:\\Eclipse\\Images\\homepage.png"));
		lblHeaderImage.setBounds(0, -361, 1339, 469);
		contentPane.add(lblHeaderImage);
		//lblUser.setText(login.USERNAME);
	}
	
	//Database Connection
	static Connection connect(){
		try {
			//set the mysql driver
			String myDriver = "com.mysql.cj.jdbc.Driver";
			//Connection String
			String url = "jdbc:mysql://localhost:3306/copl_db";
			Class.forName(myDriver);
			return(Connection) DriverManager.getConnection(url,"root","");
		}catch(Exception e) {
			System.out.print("Cannot connect to the database...");
		}
		return null;
	}
	
	
	//ADD record method
	private void addRecord() {
		Connection con = connect();
		//Calendar date = Calendar.getInstance();
		//java.sql.Date datecreated = new java.sql.Date(date.getTime().getTime());
		
		try {
			String sql = "INSERT INTO student_tbl (student_no, student_name, address, date_created) VALUES (?,?,?,NOW())";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, txtStudentNo.getText());
			ps.setString(2, txtStudentName.getText());
			ps.setString(3, txtAddress.getText());
			//ps.setDate(4, datecreated);
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Record successfully added");
			clearTextfield();
		}catch(Exception e) {
			System.out.print("Error : " + e);
		}
	}
	
	//VIEW record method
	private void viewRecords() {
		Connection con = connect();
		DefaultTableModel model = new DefaultTableModel();
		//model = new DefaultTableModel();
		
		model.addColumn("Number");
		model.addColumn("Student No");
		model.addColumn("Student Name");
		model.addColumn("Address");
		model.addColumn("Date of Registration");
		
		try {
			String sql = "SELECT * from student_tbl"; //* means select all
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				model.addRow(new Object[] {
					rs.getInt("id"),
					rs.getString("student_no"),
					rs.getString("student_name"),
					rs.getString("address"),
					rs.getString("date_created")
				});
			}
			rs.close();
			st.close();
			con.close();
			
			tableView.setModel(model);
			tableView.setAutoResizeMode(WIDTH);
			tableView.getColumnModel().getColumn(0).setPreferredWidth(15);
			tableView.getColumnModel().getColumn(1);
			tableView.getColumnModel().getColumn(2);
			tableView.getColumnModel().getColumn(3);
			tableView.getColumnModel().getColumn(4).setPreferredWidth(100);

			
		}catch(Exception ex) {
			System.out.print("Error : " + ex);
		}
		
	}
	
	//Clear method
	private void clearTextfield() {
		txtStudentNo.setText("");
		txtStudentName.setText("");
		txtAddress.setText("");
	}
	
	private void exit() {
		int ex = JOptionPane.showConfirmDialog(null, "Do you want to close this program?", "Exit Program",JOptionPane.YES_NO_OPTION);
		if (ex==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		else if (ex==JOptionPane.NO_OPTION) {
		}
	}
	
}















