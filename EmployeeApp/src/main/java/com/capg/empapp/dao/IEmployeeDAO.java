package com.capg.empapp.dao;

import java.util.ArrayList;

import com.capg.empapp.dto.Employee;
import com.capg.empapp.execptions.InvalidEmployeeIdExcption;
import com.capg.empapp.execptions.WrongSalaryException;

public interface IEmployeeDAO {
	
	 public boolean addEmployee(Employee e)throws WrongSalaryException;
	 
	 public boolean editSalaryByEmployeeId(int id,int empNewSalary)throws InvalidEmployeeIdExcption;
	 
	 public boolean editExpByEmployeeId(int id,int empNewExp)throws InvalidEmployeeIdExcption;
	 
     public ArrayList<Employee> getAllEmployees();
	 
	 public ArrayList<Employee> getEmployeeBySalary(int salary);
	 
	 public ArrayList<Employee> getEmployeeByExperience(int expe);
	 
	 public ArrayList<Employee> getEmployessBySalaryRange(int salaryRangeMin,int salaryRangeMax);

}