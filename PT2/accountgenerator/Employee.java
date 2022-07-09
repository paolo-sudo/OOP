/*
Paolo S.
CS 2-1 | PT2
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
	private String name, username, email, password;

	private static Scanner sc = new Scanner(System.in);

	Employee(){
		name = setName();
		username = setUserName(name);
		email = setEmail(username);
		password = setPassword(username);
	}

	private int countChars(String str, char ch){
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == ch){
				count++;
			}
		}
		return count;
	}

	private String setName(){
		int count;
		Pattern p = Pattern.compile("[a-zA-Z]+\\s[a-zA-Z]+.+");

		System.out.print("\nPlease enter your full name: ");
		name = sc.nextLine();
		Matcher m = p.matcher(name);
		boolean b = m.matches();

		if(b != true) {
			System.out.println("\nIncorrect format for name");
		}
		else {
			count = countChars(name, ' ');
		}
		return name;
		/* 
		do{
			System.out.print("\nPlease enter your full name: ");
			name = sc.nextLine();
			count = countChars(name, ' ');
		} while(count != 1);
		return name;
		*/
	}

	private String setUserName(String name){
		return name.replace(' ', '.').toLowerCase();
	}

	private String setEmail(String username){
		return username.charAt(0) + username.substring(username.indexOf('.') + 1) + "@oracleacademy.Test";
	}

	private String setPassword(String username){
		String inipass = "";
		for(int i = 0; i < username.length() && i < 8; i++){
			if(username.charAt(i) == 'a' || username.charAt(i) == 'e' || username.charAt(i) == 'i'
			|| username.charAt(i) == 'o' || username.charAt(i) == 'u'){
				inipass += "*";
			}else{
				inipass += username.charAt(i);
			}
		}while(inipass.length() < 8)
			inipass += "*";

		for(int i = 0; i < inipass.length(); i++){
			if(inipass.charAt(i) != '*'){
				inipass = inipass.substring(0, 1) + 
				(inipass.charAt(i) + "").toUpperCase() + inipass.substring(i + 1);
				break;
			}
		}
		return inipass;
	}
    public String toString() {
		return "\nEmployee Details" + "\nName\t\t: " + this.name + 
				"\nUsername\t: " + this.username + "\nEmail\t\t: "
				+ this.email + "\nInitial Password: " + password + "\n\n";
    }
}
