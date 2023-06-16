package Dao1;

import static utils.HibernateUtils.getFactory;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Student;

public class StudentDaoImpl implements studentdao {

	@Override
	public String addStudent(Student stud) {
		Session session=getFactory().openSession();
		EntityTransaction tx=session.beginTransaction();
		String mesg="";
		try{
			session.save(stud);
			
			tx.commit();
		}
		catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String Studentlogin(String email, String password1) {
		Session ss= getFactory().getCurrentSession();
		Transaction tx =ss.beginTransaction();
		String JPQL ="select s from Student s where s.email=:EMAIL and s.password=:PASSWORD";
		String msg="";
		try {
			ss.createQuery(JPQL,Student.class).setParameter("EMAIL", email)
			.setParameter("PASSWORD",password1).getSingleResult();
			
			tx.commit();
			msg="___login succesfully...___";
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return msg;
	}

}
