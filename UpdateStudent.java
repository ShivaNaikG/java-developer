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


@WebServlet("/updatestudent")
public class UpdateStudent  extends  HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student person=new Student() ;
		 person.setId(Integer.parseInt(req.getParameter("id"))); 
		person.setName(req.getParameter("name"));
		person.setAge(Integer.parseInt(req.getParameter("age")));
		person.setEmail(req.getParameter("email"));
		person.setPassword(req.getParameter("password"));
		StudentService studentService=new StudentService();
Student student	=studentService.updateStudentService(person);
	if(student !=null )
	{
	
		RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
		dispatcher.forward(req, resp);
	}
	else
	{
		RequestDispatcher dispatcher=req.getRequestDispatcher("editstudent.jsp"); 
		dispatcher.include(req, resp);
	}
	}
}
