package org.btm.mvcApp.controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.btm.mvcApp.dto.Employee;
import org.btm.mvcApp.service.EmployeeService;

public class EmployeeController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("Inside controller class");
		Employee emp=null;
		Employee retemp=null;
		if (!req.getParameter("fn").isEmpty() && !req.getParameter("ln").isEmpty() && !req.getParameter("em").isEmpty() && !req.getParameter("pw").isEmpty() )
		{			
			emp=new Employee();
			emp.setFirst_name(req.getParameter("fn"));
			emp.setLast_name(req.getParameter("ln"));
			emp.setEmail_id(req.getParameter("em"));
			emp.setPassword(req.getParameter("pw"));
			
			System.out.println("Pass Employee Object from EmployeeController to ");
			EmployeeService empsrv=new EmployeeService();
			retemp=empsrv.registerEmployee(emp);
			System.out.println("returned employee object from employeeService");
			
		}
		else
		{
			emp=null;
			System.out.println("Invalid Data");
		}
		//Redirect to UI or view part
		
		RequestDispatcher dispatcher=null;
		if(retemp!=null)
		{
			//Add employee object into scope
			req.setAttribute("Username", retemp.getFirst_name()+retemp.getLast_name());
			dispatcher=req.getRequestDispatcher("Success.jsp");
			
		}
		else
		{
			dispatcher =req.getRequestDispatcher("Error.jsp");
		}
		dispatcher.forward(req, resp);
		
	}
	
}
