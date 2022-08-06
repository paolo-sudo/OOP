/*
Paolo S.
CS 2-1 | PT4
*/

package copl_ex1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Dashboard extends JFrame {
	
	public JFrame frmDashboard;
	//JLabel lblUser;
	
	private JPanel contentPane;
	JTextField txtUser;
	private JTable tableView;
	private JTextField txtStudentNo;
	private JTextField txtStudentName;
	private JComboBox txtGender;
	private JTextField txtContact;
	private JTextField txtAddress;
	private JTextField txtSearch;
	@SuppressWarnings("rawtypes")
	
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblHeaderImage;
	private JLabel lblClock;
	
	private JButton btnView;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClear;
	private JButton btnExit;
	
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	DefaultTableModel model;
	

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

	public Dashboard() {
		setTitle("Student Record System");
		initialize();
		clock();
		viewRecords();
	}
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Eclipse\\Images\\SEAdfL_.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1342, 710);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Eclipse\\Images\\lpu2.png"));
		lblLogo.setBounds(23, 11, 80, 86);
		contentPane.add(lblLogo);
		
		txtUser = new JTextField();
		txtUser.setForeground(new Color(105, 105, 105));
		txtUser.setEditable(false);
		txtUser.setBackground(new Color(245, 245, 245));
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUser.setBounds(1112, 33, 186, 40);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtUser.setText(login.USERNAME);
		
		JLabel lblNewLabel = new JLabel("STUDENT RECORD SYSTEM");
		lblNewLabel.setBackground(new Color(245, 245, 245));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(113, 39, 245, 25);
		contentPane.add(lblNewLabel);
		
		lblHeaderImage = new JLabel("");
		lblHeaderImage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeaderImage.setVerticalAlignment(SwingConstants.TOP);
		lblHeaderImage.setIcon(new ImageIcon("C:\\Eclipse\\Images\\homepage.png"));
		lblHeaderImage.setBounds(0, -361, 1339, 469);
		contentPane.add(lblHeaderImage);
		
		lblClock = new JLabel(""); //CLOCK
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClock.setBounds(23, 632, 424, 19);
		contentPane.add(lblClock);
		
		JPanel panelWhite = new JPanel();
		panelWhite.setBackground(new Color(255, 255, 255));
		panelWhite.setBounds(23, 128, 1280, 485);
		contentPane.add(panelWhite);
		panelWhite.setLayout(null);
		
		btnExit = new JButton("Log Out"); //EXIT METHOD
		btnExit.setBounds(984, 436, 116, 34);
		panelWhite.add(btnExit);
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(220, 20, 60));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnView = new JButton("Refresh");
		btnView.setBounds(536, 436, 116, 34);
		panelWhite.add(btnView);
		btnView.setBackground(new Color(245, 245, 245));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewRecords();
				txtStudentNo.setEnabled(true);
			}
		});
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnDelete = new JButton("Delete"); //DELETE BUTTON
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(tableView.getSelectedRow() >= 0) {
						deleteRecord(txtStudentNo.getText());
					}
				
			}
		});
		btnDelete.setBounds(830, 436, 116, 34);
		panelWhite.add(btnDelete);
		btnDelete.setBackground(new Color(245, 245, 245));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnUpdate = new JButton("Update"); //UPDATE BUTTON
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableView.getSelectedRow() >= 0) {
					updateRecord(txtStudentNo.getText());
				}
			}
		});
		btnUpdate.setBounds(684, 436, 116, 34);
		panelWhite.add(btnUpdate);
		btnUpdate.setBackground(new Color(245, 245, 245));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(536, 64, 734, 354);
		panelWhite.add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		//TABLE EVENT PROCEDURE ONCLICK
		tableView = new JTable(); //TABLE
		tableView.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(tableView);
		tableView.setColumnSelectionAllowed(true);
		tableView.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				txtStudentNo.setEnabled(false);
				//btnAdd.setEnabled(false);
				String id = tableView.getValueAt(tableView.getSelectedRow(), 0).toString();
				textField(id);
				
				
			}
		});
		
		//You can add if statement here to check if it will be connected to the database
		
		JButton btnSave = new JButton("Save"); //ADD BUTTON
		btnSave.setBounds(379, 311, 116, 33);
		panelWhite.add(btnSave);
		btnSave.setBackground(new Color(245, 245, 245));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRecord();//call to the add method
			}
		});
		
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(253, 311, 116, 33);
		panelWhite.add(btnClear);
		btnClear.setBackground(new Color(245, 245, 245));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextfield();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtAddress = new JTextField();
		txtAddress.setBounds(142, 240, 353, 33);
		panelWhite.add(txtAddress);
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		
		txtStudentName = new JTextField();
		txtStudentName.setBounds(142, 108, 353, 33);
		panelWhite.add(txtStudentName);
		txtStudentName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtStudentName.setColumns(10);
		
		txtStudentNo = new JTextField();
		txtStudentNo.setBounds(142, 64, 353, 33);
		panelWhite.add(txtStudentNo);
		txtStudentNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtStudentNo.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(75, 246, 57, 20);
		panelWhite.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Student Name");
		lblNewLabel_2.setBounds(32, 114, 100, 20);
		panelWhite.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Student Number");
		lblNewLabel_1.setBounds(16, 70, 116, 20);
		panelWhite.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblNewLabel_4 = new JLabel("Search");
		lblNewLabel_4.setBounds(536, 26, 47, 20);
		panelWhite.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) { //SEARCH
				Connection con = connect();
				
				try {
					String sql = "SELECT * FROM student_tbl WHERE student_name LIKE '%" + txtSearch.getText() + "%'"; //Search for Name
					//String sql = "SELECT * FROM student_tbl WHERE student_no '%" + txtSearch.getText() + "%'"; //Search for student number
					//String sql = "SELECT student_no, student_name, gender, contact_no, address FROM student_tbl WHERE id = ?";
					PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
					//ps.setString(1, txtSearch.getText());

					ResultSet rs = ps.executeQuery();
					
					tableView.setModel(DbUtils.resultSetToTableModel(rs));
					ps.close();
					
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,"Got an exception!");
			        System.err.println(ex.getMessage()); 
				}
				
			}
		});

		txtSearch.setBounds(593, 20, 381, 33);
		panelWhite.add(txtSearch);
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSearch.setColumns(10);
		
		txtContact = new JTextField();
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContact.setColumns(10);
		txtContact.setBounds(142, 196, 353, 33);
		panelWhite.add(txtContact);
		
		txtGender = new JComboBox();
		txtGender.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
		txtGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGender.setBackground(new Color(255, 255, 255));
		txtGender.setBounds(142, 152, 353, 33);
		panelWhite.add(txtGender);
		
		JLabel lblNewLabel_3_1 = new JLabel("Phone Number");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(26, 202, 106, 20);
		panelWhite.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Gender");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(81, 158, 51, 20);
		panelWhite.add(lblNewLabel_3_2);
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
			String sql = "INSERT INTO student_tbl (student_no, student_name, gender, contact_no, address, date_created) VALUES (?,?,?,?,?,NOW())";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, txtStudentNo.getText());
			ps.setString(2, txtStudentName.getText());
			ps.setString(3, (String) txtGender.getSelectedItem());
			ps.setString(4, txtContact.getText());
			ps.setString(5, txtAddress.getText());
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
		
		model.addColumn("No.");
		model.addColumn("Student No");
		model.addColumn("Student Name");
		model.addColumn("Gender");
		model.addColumn("Contact");
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
					rs.getString("gender"),
					rs.getString("contact_no"),
					rs.getString("address"),
					rs.getString("date_created")
				});
			}
			rs.close();
			st.close();
			con.close();
			
			tableView.setModel(model);
			tableView.setAutoResizeMode(WIDTH);
			tableView.getColumnModel().getColumn(0).setPreferredWidth(10); //ID
			tableView.getColumnModel().getColumn(1).setPreferredWidth(35); //Student Number
			tableView.getColumnModel().getColumn(2); //Student Name
			tableView.getColumnModel().getColumn(3).setPreferredWidth(20); //Gender
			tableView.getColumnModel().getColumn(4).setPreferredWidth(40); //Contact Number
			tableView.getColumnModel().getColumn(5); //Address
			tableView.getColumnModel().getColumn(6).setPreferredWidth(100); //Date Created

			
		}catch(Exception ex) {
			System.out.print("Error : " + ex);
		}
		
	}
	
	//DELETE record method
	private void deleteRecord(String id) {
		Connection con = connect();
		try { //try catch will run even there is an error
			String sql = "DELETE from student_tbl WHERE student_no = ?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, id);
			
			int ex = JOptionPane.showConfirmDialog(null, "Are you sure you want to permanently delete this data??", "Exit Program",JOptionPane.YES_NO_OPTION);
			if (ex==JOptionPane.YES_OPTION) {
				ps.execute();
				JOptionPane.showMessageDialog(null, "Record deleted from database");
				
			}
			else if (ex==JOptionPane.NO_OPTION) {
			}
			
			ps.close();
			con.close();
			
			clearTextfield();
			
		}catch(Exception ex) {
			System.out.print("Error : " + ex);
		}
	}
	
	//UPDATE record method
	private void updateRecord(String id) {
		Connection con = connect();
		try {
			String sql = "UPDATE student_tbl SET student_no = ?, student_name = ?, gender = ?, contact_no = ?, address = ? WHERE student_no = ?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, txtStudentNo.getText());
			ps.setString(2, txtStudentName.getText());
			ps.setString(3, (String) txtGender.getSelectedItem());
			ps.setString(4, txtContact.getText());
			ps.setString(5, txtAddress.getText());
			ps.setString(6, id);
			ps.execute();
			
			ps.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Record successfully updated");
			clearTextfield();
			
		}catch(Exception ex){
			System.out.print("Error : " + ex);
		}
	}
	
	//CLICK EVENT FROM THE TABLE TO INPUT FIELDS
	private void textField(String id) {
		Connection con = connect();
		
		try {
			String sql = "SELECT * FROM student_tbl WHERE id = ?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, id);
			String gender = tableView.getValueAt(tableView.getSelectedRow(), 3).toString();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				txtStudentNo.setText(rs.getString("student_no"));
				txtStudentName.setText(rs.getString("student_name"));
				//GENDER click from table working
				switch(gender) { //Working now
				case "Male":
					txtGender.setSelectedIndex(1);
					break;
				case "Female":
					txtGender.setSelectedIndex(2);
					break;
				}
	
				txtContact.setText(rs.getString("contact_no"));
				txtAddress.setText(rs.getString("address"));
			}
			
		}catch(Exception ex) {
			System.out.print("Error : " + ex);
		}
	}
	
	//Clear method
	private void clearTextfield() {
		txtStudentNo.setText("");
		txtStudentName.setText("");
		//txtGender.setToolTipText("");
		txtContact.setText("");
		txtAddress.setText("");
	}
	
	private void exit() {
		int ex = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Log Out",JOptionPane.YES_NO_OPTION);
		if (ex==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		else if (ex==JOptionPane.NO_OPTION) {
		}
	}
	
	
	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while(true) {
						Calendar cl = new GregorianCalendar();
						int day = cl.get(Calendar.DAY_OF_MONTH);
						int month = cl.get(Calendar.MONTH);
						int year = cl.get(Calendar.YEAR);
						
						//int sec = cl.get(Calendar.SECOND);
						//int min = cl.get(Calendar.MINUTE);
						//int hr = cl.get(Calendar.HOUR);
						
						SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
						monthFormat = new SimpleDateFormat("MMMM");
					    String strMonth= monthFormat.format(new Date());
						
						DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss aa");
				    	String dateString = timeFormat.format(new Date()).toString();
				    	//lblClock.setText("Time : " + hr + ":" + min + ":" + sec + " | Date : " + month + "/" + day + "/" + year);
						lblClock.setText("Time : " + dateString + " | Date : " + strMonth + " " + day + ", " + year);
						
						sleep(1000);
						
					}
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		};
		clock.start();
	}
}

