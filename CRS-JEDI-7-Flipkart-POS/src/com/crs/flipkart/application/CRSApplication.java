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
		
		while(Input!=4)
		{
			switch(Input)
			{	
				case 1:
					registerStudent();
					break;
				case 2:
					loginUser();
					break;
				case 3:
					updatePassword();
					break;
				case 4:
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
		System.out.println("2. Login ");
		System.out.println("3. UpdatePassword");
		System.out.println("4. Exit");
		System.out.println("------------------------------------------");
		System.out.print("ENTER YOUR CHOICE----->:\t");

	}
	
	
	private static void registerStudent() {
	
	}
	
	private static void loginUser(){
		Scanner sc = new Scanner(System.in);
		String userId, password;
		System.out.println("Email:");
		userId = sc.next();
		System.out.println("Password:");
		password = sc.next();
		
		Boolean loggedIn = true;  //Authentication
		
		if (loggedIn) {
			int role = 2;  //Authorization
			switch (role) {
			case 1:  //Admin
				System.out.println(" Login Successful!");
				CRSAdminMenu adminMenu = new CRSAdminMenu();
				break;
			case 2:  //Professor
				System.out.println(" Login Successful!");
				CRSProfessorMenu professorMenu = new CRSProfessorMenu();
				professorMenu.professorMenu();
				break;
			case 3:   //Student
				int isApproved = 1; //check approval
				if (isApproved == 1) {
					System.out.println( " Login Successful!");
					CRSStudentMenu studentMenu = new CRSStudentMenu();

				} else {
					System.out.println("You have not been approved by the admin!");
					loggedIn = false;
				}
				break;
			}

		}
		
	}
	

	private static void updatePassword(){
		
		
	}
	
	
	
	
	
}

