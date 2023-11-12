package in.ineuron.dao;
import in.ineuron.dto.Student;
import in.ineuron.util.*;
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
		
		if(student != null) 
			return student;
		else
			return null;
		
	}
	
	
	@Override
	public String updateStudent(Student student){
		
		
		return "failure";
	}
	
	

	@Override
	public String deleteStudent(Integer sid) {
		
		Transaction transaction = session.beginTransaction(); 
		boolean flag = false; 
		String status = "";
		
		//load the matching student first::
		Student student = searchStudent(sid);
		
		try {
			if(transaction != null) {
				if(student != null) {
					session.delete(student);
					flag = true;
				}
				else {
					return "not found ";
				}
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

}
