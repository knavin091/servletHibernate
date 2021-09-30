package org.btm.mvcApp.dao;
import org.btm.mvcApp.dto.Employee;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class EmployeeDao {
	
	public Employee saveEmployee(Employee emp)
	{
		System.out.println("Inside EmployeeDao Class");
		int primarykey=0;
		Transaction tran=null;
		try {
			if (emp!=null) {

				Configuration conf=new Configuration();
				conf.configure();
				SessionFactory sef=conf.buildSessionFactory();
				Session ses=sef.openSession();
				tran=ses.beginTransaction();
				primarykey=(int)ses.save(emp);
					
				System.out.println("Employee object saved into Database");
				tran.commit();
				ses.close();
			}
		}
		catch(HibernateException e)
		{
			tran.rollback();
			System.out.println("Operation rolled back");
			return null;
		}
		if(primarykey!=0) {
			System.out.println("Return Employee Object from Database");
			return emp;
		}
		else
		{
			return null;
		}
	}

}
