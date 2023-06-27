package dao;
import static utils.HibernateUtils.getFactory;

import javax.persistence.EntityTransaction;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import pojos.Author;

public class AuthorDaoImpi implements AuthorDao {

	@Override
	public String newAuthor(Author author) {
		String msg="---AUTHOR ADDED FAILED---";
		Session session=getFactory().openSession();
		//
		EntityTransaction tx=session.beginTransaction();
		try {
			session.persist(author);
			tx.commit();
			msg="ADDED A NEW AUTHOR WITH AUTO GENERATED ID"+author.getId();
				
		}
		catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
		}
		return null;
	}

}
