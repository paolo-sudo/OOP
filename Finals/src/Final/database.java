/*
Paolo S.
CS 2-1 | Final Hands-On Exam
*/

package Final;

import java.sql.Connection;
import java.sql.DriverManager;

//Database connection
public class database {

	public static Connection mycon() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return con;

	}

}
