package dao;
import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import org.hibernate.*;
import org.hibernate.Session;

import pojos.Author;
import pojos.Book;

public class BookDaoImpl implements BookDao {

	@Override
	public String newBook(Book book, int author_id) {
		String msg="BOOK ADDED FAILED...";
		Session session=getFactory().getCurrentSession();
		Transaction tx=  (Transaction) session.beginTransaction();
		try {
			Author auth=session.get(Author.class, author_id);
			if(auth!=null) {
				auth.addBook(book);
				session.persist(book);
				
				msg="BOOK ADDED WITH GENERATED ID="+book.getId();
				
				}
		         try {
					tx.commit();
				} catch (RollbackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (HeuristicMixedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (HeuristicRollbackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		}catch(RuntimeException e) {
			if(tx!=null)
				try {
					tx.rollback();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SystemException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
		return msg;
	}

	@Override
	public String removeBook(int bid) {
		// TODO Auto-generated method stub
		String msg="Book remove failed..";
		Session session=getFactory().getCurrentSession();
	Transaction tx=(Transaction) session.beginTransaction();
	try {
		Book book=session.get(Book.class, bid);
		
		if(book!=null) {
			 session.remove(book);
			 msg="book removed..";
		}
		try {
			tx.commit();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}catch (RuntimeException e) {
	     if(tx!=null)
			try {
				tx.rollback();
			} catch (IllegalStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
		return msg;
	}

	@Override
	public String updatBook(String title, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBook() {
		String msg="Book show failed...";
		String jpql="select b from Book b";
		List<BookDaoImpl> blist=null;
		
		Session session =getFactory().getCurrentSession();
		org.hibernate.Transaction tx=session.beginTransaction();
		
		try {
			blist=session.createQuery(jpql).getResultList();
			
			tx.commit();
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
				 
		}
		
		return null;
	}

}
