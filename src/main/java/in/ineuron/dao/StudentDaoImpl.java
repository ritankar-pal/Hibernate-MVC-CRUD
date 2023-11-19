package in.ineuron.dao;
import in.ineuron.model.Student;
import in.ineuron.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class StudentDaoImpl implements IStudentDao {

	Session session = HibernateUtil.getSession();
	
	
	@Override
	public String addStudent(Student student) {
		
		Transaction transaction = null;
		boolean flag = false;
		String status = "";
		
		try {
			
			if(session != null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction != null) {
				session.save(student);
				flag = true; 
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				status = "success";
			}
			else {
				transaction.rollback();
				status = "failure";
			}
		}
		
		return status;
	}


	@Override
	public Student searchStudent(Integer sid) {
		
		Student student = session.get(Student.class, sid);
		return student;
	}
	
	
	@Override
	public String updateStudent(Student student){
		
		Transaction transaction = null; 
		boolean flag = false; 
		String status = "";
		
		try {
			if(session != null)
				if(student != null) {
					transaction = session.beginTransaction();
				}
			
			if(transaction != null) {
				session.merge(student);
				flag = true;
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				status = "success";
			}
			else {
				transaction.rollback();
				status = "failure";
			}
		}
		
		return status;
	}
	
	

	@Override
	public String deleteStudent(Integer sid) {
		
		Transaction transaction = null; 
		boolean flag = false; 
		String status = "";
		
		//load the matching student first::
		Student student = searchStudent(sid);
		
		if(student != null) {
			try {
				transaction = session.beginTransaction();
				
				if(transaction != null) {
					session.delete(student);
					flag = true;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				if(flag) {
					transaction.commit();
					status = "success";
				}
				else {
					transaction.rollback();
					status = "failure";
				}
			}
		}
		else {
			return "not found ";
		}
		
		return status;
	}

}
