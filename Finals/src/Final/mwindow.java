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
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mwindow extends JFrame {

	private JPanel contentPane;
	public static String name;
	//private JTextField txtHello;
	JTextField txtHello;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mwindow frame = new mwindow();
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
	public mwindow() {
		setFont(new Font("Arial", Font.PLAIN, 10));
		setTitle("Main");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Eclipse\\Images\\SEAdfL_.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 901, 455);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("Log Out");
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(new Color(204, 0, 51));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ex = JOptionPane.showConfirmDialog(null, "Are you sure you want to Log out?", "Return to Sign in Page",JOptionPane.YES_NO_OPTION);
				if (ex==JOptionPane.YES_OPTION) {
					//System.exit(0);
					new signin().setVisible(true);
					dispose();
				}
				else if (ex==JOptionPane.NO_OPTION) {
				}
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.setBounds(784, 102, 107, 29);
		panel.add(btnLogout);
		
		JLabel lblBG = new JLabel("");
		lblBG.setBounds(0, 0, 900, 91);
		panel.add(lblBG);
		lblBG.setIcon(new ImageIcon("C:\\Eclipse\\Images\\peninsula2.png"));
		
		txtHello = new JTextField();
		txtHello.setHorizontalAlignment(SwingConstants.CENTER);
		txtHello.setEditable(false);
		txtHello.setFont(new Font("Tahoma", Font.PLAIN, 48));
		txtHello.setBackground(new Color(245, 245, 245));
		txtHello.setBounds(0, 89, 901, 366);
		panel.add(txtHello);
		txtHello.setColumns(10);
	}

	public mwindow(String name) {
		//txtHello.setText("Hello, " + signin.name);
		this();
		txtHello.setText("Hello, " + name + "!");
	}
}
