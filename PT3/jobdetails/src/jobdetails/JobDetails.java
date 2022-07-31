/*
Paolo S.
CS 2-1 | PT3
 */
package jobdetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class JobDetails {

	public static void main(String[] args) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:orcluser/jdbcuser@//localhost:1521/xepdb1"); 
		Connection conn = ods.getConnection();

		Statement stmt=conn.createStatement();
		Statement stmt1=conn.createStatement();
		Statement stmt2=conn.createStatement();

		// Execute a statement - DO THIS WITH AT LEAST 3 TABLES - provide screenshot
		ResultSet rset= stmt.executeQuery("Select job_id, job_title, min_salary, max_salary from jobs");
		ResultSet rset1= stmt1.executeQuery("Select location_id, street_address, postal_code, city from locations");
		ResultSet rset2= stmt2.executeQuery("Select country_ID, country_name, region_id from countries");
		
		
		System.out.println("\n\n        WELCOME! Here you can check the job details of the ABC Company.");
		System.out.println("\n\n---------------------------------------------------------------------------------------------\n\n");
		
		//  Iterate  through  the  result  and  print  the  employee's ID, title, min salary, and max salary from JOBS 
		System.out.println("\t" + "Job ID" + "\t" +"Job Title"+ "\t" + "Min Salary" + "\t" + "Max Salary" ); 
		System.out.println();
		while (rset.next()) {
			System.out.println("\t" + rset.getString(1) + "\t" +rset.getString(2) + "\t"+rset.getString(3) + "\t"+rset.getString(4));
		}//endwhile

		System.out.print("\n\n---------------------------------------------------------------------------------------------\n\n\n");


		//  Iterate  through  the  result  and  print  the  employee's location ID, street address, postal code, and city from LOCATIONS 
		System.out.println("\t" + "Location ID" + "\t" +"Street Address"+"\t"+"Postal Code"+"\t" + "City"); 
		System.out.println();
		while (rset1.next()) {
			System.out.println("\t" + rset1.getString(1) +  "\t"  +rset1.getString(2) +  "\t"+rset1.getString(3)+ "\t"+rset1.getString(4));
		}//endwhile

		System.out.print("\n\n---------------------------------------------------------------------------------------------\n\n\n");
		
		
		//  Iterate  through  the  result  and  print  the  employee's country ID, country name, and region ID from COUNTRIES 
		System.out.println("\t" + "Country ID" + "\t" +"Country Name"+"\t"+"Region ID"+"\t"); 
		System.out.println();
		while (rset2.next()) {
			System.out.println("\t" + rset2.getString(1) +  "\t"  +rset2.getString(2) +  "\t"+rset2.getString(3));
		}//endwhile

		System.out.println("\n\n\n        Thank you!\n\n");
		
		
		//close the resources 
		rset.close(); 
		stmt.close();
		rset1.close(); 
		stmt1.close();
		rset2.close(); 
		stmt2.close();
	}//end method main

}//end class JobDetails
