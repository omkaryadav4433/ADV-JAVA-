package dao;

import static  utils.HiberUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import POJO.employee;
@SuppressWarnings("unused")
public class Employeedaoimpl implements EmployeeDao{
 
                    
	@Override
	public String insertemployeeDetails(employee empo) {
		String mesg="adding emp deatils failed!!!!";
		Session Session=getFactory().openSession();
		Transaction tx=Session.beginTransaction();
		try {
			Session.save(empo);
			tx.commit();
			mesg="added emp details with id="+empo.getEmpid();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
			
		}finally {
			if(Session!=null)
				Session.close();
				
		}
		
		
		
		return mesg;
	}

}
