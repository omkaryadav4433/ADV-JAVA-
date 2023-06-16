package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao1.StudentDaoImpl;
import pojos.Course;
import pojos.Student;



public class StudentTester {

	public static void main(String[] args) {
		StudentDaoImpl Studentdao =new StudentDaoImpl();
		try(SessionFactory SF =getFactory(); Scanner sc=new Scanner(System.in)){
			System.out.println("fname, lname, email, password, course, dob");
			Student newStudent=new Student(sc.next(),sc.next(),sc.next(),sc.next(),Course.valueOf(sc.next().toUpperCase()),LocalDate.parse(sc.next()));
		
			System.out.println(Studentdao.addStudent(newStudent));
		
		
		
		}
		
		
	}

}
