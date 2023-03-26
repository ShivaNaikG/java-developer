package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Student;
import com.jsp.service.StudentService;
@WebServlet("/save")
public class SaveStudent  extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student=new Student();
		student.setName(req.getParameter("name"));
		student.setAge(Integer.parseInt(req.getParameter("age")));
		student.setEmail(req.getParameter("email"));
		student.setPassword(req.getParameter("password"));
StudentService studentService=new   StudentService();
Student student2=studentService.saveDataStudentService(student);
if(student2 !=null)
{
	RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
	dispatcher.forward(req, resp);
}
else
{
	RequestDispatcher dispatcher=req.getRequestDispatcher("savestudent.jsp");
	dispatcher.include(req, resp);
}
		
	}
	

}
