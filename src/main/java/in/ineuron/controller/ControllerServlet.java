package in.ineuron.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.model.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;
import in.ineuron.util.HibernateUtil;



@WebServlet(urlPatterns = {"/controller/*"}, loadOnStartup = 1)
public class ControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	static {
		HibernateUtil.startUp();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}




	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		
		System.out.println("Requested URI:: " + request.getRequestURI());
		System.out.println("Requested PathInfo:: " + request.getPathInfo());
		
	
		//Registering an User::
		if(request.getRequestURI().endsWith("addform")) {
			
			String age = request.getParameter("sage");
			String name = request.getParameter("sname");
			String address = request.getParameter("saddr");
			
			
			Student student = new Student();
			student.setSname(name);
			student.setSage(Integer.parseInt(age));
			student.setSaddress(address);
			
			String status = studentService.addStudent(student);
		
			RequestDispatcher reqDisp = null;
				
			request.setAttribute("status", status);
			reqDisp = request.getRequestDispatcher("../insertResult.jsp");
			reqDisp.forward(request, response);
				
		}
		
		
		//Searching an user:: 	
		if(request.getRequestURI().endsWith("searchform")) {
			String sid = request.getParameter("sid");
			
			Student student = studentService.searchStudent(Integer.parseInt(sid));
			request.setAttribute("student", student);
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../display.jsp");
			rd.forward(request, response);
		}
		
		
		//Delete Operation:: 
		if(request.getRequestURI().endsWith("deleteform")) {
			
			String sid = request.getParameter("sid");
			String status = studentService.deleteStudent(Integer.parseInt(sid));

			RequestDispatcher reqDisp = null;
			
			request.setAttribute("status", status);
			
			reqDisp = request.getRequestDispatcher("../deleteResult.jsp");
			reqDisp.forward(request, response);
		}
		
		
		
		//Update Logic:: 
		if(request.getRequestURI().endsWith("editform")) {
			
			String sid = request.getParameter("sid");
			
			Student student = studentService.searchStudent(Integer.parseInt(sid));
			
			RequestDispatcher rd = null;
			
			if(student != null) {
				request.setAttribute("student", student);
				rd = request.getRequestDispatcher("../updateForm.jsp");
				rd.forward(request, response);
			}
	
		}
		
		if(request.getRequestURI().endsWith("updateRecord")) {
			
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddr");
			
			System.out.println(sid);
			System.out.println(sname);
			System.out.println(sage);
			System.out.println(saddress);
			
			
			Student student = new Student();
			student.setSid(Integer.parseInt(sid));
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSaddress(saddress);
			
			String status = studentService.updateStudent(student);
			
			RequestDispatcher reqDisp = null;
			
			request.setAttribute("status", status);
	
			reqDisp = request.getRequestDispatcher("../../updateResult.jsp");
			reqDisp.forward(request, response);
		
		}
		
	}

}





