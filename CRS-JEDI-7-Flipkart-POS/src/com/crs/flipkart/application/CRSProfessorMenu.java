package com.crs.flipkart.application;

import java.util.Scanner;

public class CRSProfessorMenu {
	public void professorMenu()
	{
		Scanner sc=new Scanner(System.in);
		
		int in=1;
		while(in!=4)
		{
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("----------------------------------------PROFESSOR MENU---------------------------------------");
			System.out.println("---------------------------------------------------------------------------------------------\n");

			System.out.println("1. View Courses");
			System.out.println("2. View Enrolled Students");
			System.out.println("3. Add grade");
			System.out.println("4. Logout");

			System.out.println("------------------------------------------");
			System.out.print("ENTER YOUR CHOICE--->:\t");
			System.out.println();

			in=sc.nextInt();
			//input user
			
			switch(in)
			{
				case 1:
					//view all the courses taught by the professor
					getCourses();
					break;
				case 2:
					//view all the enrolled students for the course
					viewStudents();
					break;
					
				case 3:
					//add grade for a student
					addGrade();
					break;
				case 4:
					//logout from the system
					return;
				default:
					System.out.println("Select right option.");
			}
			
		}
		sc.close();
		
		
	}
	
	private void getCourses()
	{
		
	}
	
	private void viewStudents()
	{
		
	}
	
	private void addGrade()
	{
		
	}
	

}
