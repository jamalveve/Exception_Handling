package com.custom.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) throws NumberException {

		Scanner scann = new Scanner(System.in);
		String username = null;
		String password = null;
		while (true) {
			System.out.println("Enter the username: ");
			username = scann.nextLine();
			if (isValidUsername(username)) {
				break;
			} else {
				System.out.println("Enter a valid username");
			}
		}
		System.out.println("Enter your password");
		try {
			password = scann.nextLine();
		} catch (Exception e) {
			System.out.println(e);
		}

		UserLogin login = new UserLogin(username, password);
		System.out.println("welcome to the page");
		PersonDetails person = new PersonDetails();
		person.check();
	}

	public static boolean isValidUsername(String username) {
		// Example validation criteria
		// Username must be between 3 and 15 characters long
		return username.length() > 3 || username.length() < 15 && username.matches("[a-zA-Z]+");
	}

}

class PersonDetails {
	String name;
	int age;
	String makeupproducts;
	int skincare;

	public void check() throws NumberException {
		Scanner scann = new Scanner(System.in);
		System.out.println("Enter your gender: ");
		String gender = scann.next();
		if (gender.matches(".*\\d.*")) {
			throw new NumberException();
		} else if (gender.equals("female")) {
			System.out.println("Enter click to go");
			womenSection(makeupproducts, skincare);
		} else {

		}
	}
	// bipan

	public void womenSection(String makeupproducts, int skincare) {
		System.out.println("here are some products for you! choose 1 for SKincare 2 for makeup");
		Scanner scann = new Scanner(System.in);
		
//		try {
		
			int choose = scann.nextInt();
			if(choose<1) {
				throw new InputMismatchException();
			}
//		}catch(Exception e) {
//			System.out.println(e);
//		}
//			finally {
//			System.out.println("retry the page");
//		}
	}

}

class UserLogin {
	String username;
	String password;
	int mobilenumber;
	String gmailid;

	public UserLogin(String Username, String password) {

		this.username = username;
		this.password = password;

	}

	public UserLogin(String Username, int mobilnumber, String password) {
		this.username = username;
		this.password = password;

	}

//	public void Login(int mobilenumber,String password){
//		this.mobilenumber=mobilenumber;
//		this.password=password;
//	
//	}
	public UserLogin(int mobilenumber, String gmailid) {
		this.mobilenumber = mobilenumber;
		this.gmailid = gmailid;

	}
}

class NumberException extends Throwable {
	void empty() {
		System.out.println("gender cant be number");
	}
}