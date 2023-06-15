package utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class HiberUtils {
	private static SessionFactory factory; //singlton,immutable,
	//inherantly third safe
	
	static {
		System.out.println("in static init block");
		factory=new Configuration()
				.configure()
				.buildSessionFactory();
		}

	public static SessionFactory getFactory() {
		return factory;
	}

}
