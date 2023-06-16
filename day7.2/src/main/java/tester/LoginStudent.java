package tester;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao1.StudentDaoImpl;
public class LoginStudent {

	public static void main(String[] args) {
	  try(SessionFactory sf=getFactory(); Scanner sc=new Scanner(System.in);){
		 StudentDaoImpl studetdaoInstance=new StudentDaoImpl() ;
		 System.out.println("email, password");
		 System.out.println(studetdaoInstance.Studentlogin(sc.next(), sc.next()));
		  
	  }

	}

}
