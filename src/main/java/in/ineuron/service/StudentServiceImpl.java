package in.ineuron.service;
import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.dao.IStudentDao;
//import in.ineuron.servicefactory.StudentServiceFactory;




public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao = null;
	
	
	
	@Override
	public String addStudent(Student student) {
		
		studentDao = StudentDaoFactory.getStudentDao();
		
		if(studentDao != null)
			return studentDao.addStudent(student);
		else
			return "failure";
	}

	
	
	//DAO Object in the service level
	@Override
	public Student searchStudent(Integer sid) {
		
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.searchStudent(sid);
	}

	
	
	@Override
	public String updateStudent(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateStudent(student);
	}
	
	
	

	@Override
	public String deleteStudent(Integer sid) {
		
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteStudent(sid);
	}

}
