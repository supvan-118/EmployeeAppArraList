package com.capg.empapp.main;
import java.util.ArrayList;
import java.util.Scanner;

import com.capg.empapp.db.EmployeeDB;
import com.capg.empapp.dto.Employee;
import com.capg.empapp.service.EmployeeServiceImpl;
import com.capg.empapp.service.IEmployeeService;

public class EmpMainClass {
	
	IEmployeeService empService = new EmployeeServiceImpl();
	
	public static void main(String[] args) {
		
		EmpMainClass app = new EmpMainClass();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println(" === MENU ==== ");
			System.out.println("Press 1 to  Add employee ");
			System.out.println("Press 2 to Display All Employees ");
			System.out.println("Press 3 to Display Employees based on salary ");
			System.out.println("Press 4 to Display Employees based on salary Range ");
			System.out.println("Press 5 to Display Employees based on Experience ");
			System.out.println("Press 6 to Edit Salary by Employee ID ");
			System.out.println("Press 7 to Edit Experience by Employee ID ");
			System.out.println("Press 0 to EXIT");
			System.out.println("Enter Option");
			int option = Integer.parseInt(sc.nextLine());
			switch(option)
			{
			
			case 0:
				System.exit(0);
			break;
			
			case 1:
				
				System.out.println("Enter Employee Id ");
				int empId = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Salary ");
				int empSalary = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Exp ");
				int empExp = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Name ");
				String name = sc.nextLine();
				
				Employee e = new Employee(empId, name, empExp, empSalary);
				
				try
				{
					boolean isInserted = app.empService.addEmployee(e);
					if(isInserted)
					{
						System.out.println(" Employee Added !!!");
					}
					else
					{
						 throw new Exception("Cannot added Employee ...");
					}
				}
				catch(Exception ex)
				{
					System.out.println(" Contact to Customer Care ... "+ex); // raise the exception
				}
				
				break;
			case 2:
				System.out.println("Displaying all employees\n");
				/*ArrayList<Employee> arr = app.empService.getAllEmployees();
				int count = EmployeeDB.count;  // not the code
				System.out.println("  --->>  count in main "+count);
				for (Employee employee : arr) {
					System.out.println(employee);
					System.out.println(" ====================***********======================");
				}
				break;*/
              // ArrayList<Employee> arr = app.empService.getAllEmployees();
               ArrayList<Employee> arr=app.empService.getAllEmployees();
				for (Employee employee : arr) {
					System.out.println(employee);
					System.out.println(" ====================***********======================");
				}
				break;
			case 3:
				System.out.println("Enter Employee's Salary ");
				int empsal = Integer.parseInt(sc.nextLine());
				ArrayList<Employee> sal=app.empService.getEmployeeBySalary(empsal);
				//int count0 = EmployeeDB.count;
			//	System.out.println("count value:"+count0);
				System.out.println("The Employees with salary of "+empsal);
				for (Employee employee :sal) {
					System.out.println(employee);
					System.out.println(" ===================*************=======================");
				}
				
				break;
			case 4:
				System.out.println("Enter Employee Salary min and max salary");
				int empminsal = Integer.parseInt(sc.nextLine());
				int empmaxsal = Integer.parseInt(sc.nextLine());
				ArrayList<Employee> sal01=app.empService.getEmployessBySalaryRange(empminsal, empmaxsal);
			//	int count1 = EmployeeDB.count;
				System.out.println("Employees within the salary range  of"+empminsal+" to "+empmaxsal);
				for (Employee salrange:sal01 ) {
					System.out.println(sal01);
					System.out.println(" ===================*************=======================");
				}
				
				break;
			case 5:
				System.out.println("Enter Employee's experience");
				int empexp = Integer.parseInt(sc.nextLine());		
				ArrayList<Employee> exp=app.empService.getEmployessByExperience(empexp);
				//int count2 = EmployeeDB.count;
				//System.out.println("count value :"+count2);
				System.out.println("The Employees with experience of "+empexp);
				for (Employee expi:exp ) {
					System.out.println(exp);
					System.out.println(" ===================*************=======================");
				}
				
			case 6:
				System.out.println("Enter Employee Id to change salary of the employee");
				int empidsal = Integer.parseInt(sc.nextLine());
				System.out.println("enter new salary");
				int empnewsal = Integer.parseInt(sc.nextLine());
				try
				{
					boolean isChanged = app.empService.editSalaryByEmployeeId(empidsal,empnewsal);
					if(isChanged)
					{
						System.out.println(" Employee Details Updated !!!");
					}
					else
					{
						 throw new Exception("Cannot Find Employee ID...");
					}
				}
				catch(Exception ex)
				{
					System.out.println(" Contact to Customer Care ... "+ex); // raise the exception
				}
				break;
				
			case 7:
				
				System.out.println("Enter Employee Id to change experience of the employee");
				int empidexp = Integer.parseInt(sc.nextLine());
				System.out.println("enter new experience");
				int empnewexp = Integer.parseInt(sc.nextLine());
				try
				{
					boolean isAltered = app.empService.editSalaryByEmployeeId(empidexp,empnewexp);
					if(isAltered)
					{
						System.out.println(" Employee Details Updated !!!");
					}
					else
					{
						 throw new Exception("Cannot Find Employee ID...");
					}
				}
				catch(Exception ex)
				{
					System.out.println(" Contact to Customer Care ... "+ex); // raise the exception
				}
				
			}//end switch
			
		}// end while
		
	}//end main

}