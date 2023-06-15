package Tester;
import static utils.HiberUtils.getFactory;
import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
     try(SessionFactory sf=getFactory())
     {
    	System.out.println("hib up and running "); 
     }
      catch(Exception e) {
    	  e.printStackTrace();
      }
	}

}
