/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

/**
 * @author Tushar
 *
 */
public class CRSApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("================================================================================");
		System.out.println("********************WELCOME to Course Registration System!!!********************");
		System.out.println("================================================================================");

		printMenu();
		int Input=sc.nextInt();
		
		while(Input!=5)
		{
			switch(Input)
			{	
				case 1:
					registerStudent();
					break;
				case 2:
					loginStudent();
					break;
				case 3:
					loginProf();
					break;
				case 4:
					updatePassword();
					break;
				case 5:
					break;
				default:
					System.out.println("Enter a valid input");
			}
			printMenu();
			Input = sc.nextInt();
		}
		System.out.println("*******************************Thank you for using our Application.*********************************");
		sc.close();
	}
	
	public static void printMenu() {
		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------MAIN MENU-----------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------\n");

		System.out.println("1. Student Signup");
		System.out.println("2. Student Login ");
		System.out.println("3. Professor Login ");
		System.out.println("4. UpdatePassword");
		System.out.println("5. Exit");
		System.out.println("------------------------------------------");
		System.out.print("ENTER YOUR CHOICE----->:\t");

	}
	
	
	private static void registerStudent() {
	
	}
	
	private static void loginProf(){
		Scanner sc = new Scanner(System.in);
		String userId, password;
		System.out.println("Email:");
		userId = sc.next();
		System.out.println("Password:");
		password = sc.next();
		
		Boolean loggedIn = true;  //Authentication
		
		if (loggedIn) {
			System.out.println(" Login Successful!");
			CRSProfessorMenu professorMenu = new CRSProfessorMenu();
			professorMenu.professorMenu(1);
		}
		
	}

	private static void loginStudent(){
		Scanner sc = new Scanner(System.in);
		String userId, password;
		System.out.println("Email:");
		userId = sc.next();
		System.out.println("Password:");
		password = sc.next();

		Boolean loggedIn = true;  //Authentication

		if (loggedIn) {
			int isApproved = 1; //check approval
			if (isApproved == 1) {
				System.out.println( " Login Successful!");
				CRSStudentMenu studentMenu = new CRSStudentMenu();

			} else {
				System.out.println("You have not been approved by the admin!");
				loggedIn = false;
			}
		}

	}
	

	private static void updatePassword(){
		
		
	}
	
	
	
	
	
}

