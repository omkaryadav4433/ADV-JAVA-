package Tester1addEmp;
import static utils.HiberUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import POJO.Employment;
import POJO.employee;
import dao.Employeedaoimpl;


public class addemps {

	public static void main(String[] args) {
		try(SessionFactory sf =getFactory();Scanner sc=new Scanner (System.in))
		{
			Employeedaoimpl dao= new Employeedaoimpl();
			System.out.println("enter emp deatils: first name, lastname, email, password, confirmpassword, joindate, type, salary");
			//(String firstname, String lastname, String email, String password,
		//	String confirmpassword, LocalDate joinDate, Employment type
			
			employee newEmp=new employee(sc.next(), sc.next(), 
					sc.next(), sc.next(), sc.next(),
					LocalDate.parse(sc.next()), 
					Employment.valueOf(sc.next().toUpperCase()), 
					sc.nextDouble());
					//(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),LocalDate.parse(sc.next()),Employment.valueOf(sc.next().toUpperCase()),sc.nextDouble());
					System.out.println(dao.insertemployeeDetails(newEmp));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
