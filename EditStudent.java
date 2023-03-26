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

//getstudentdyid

@WebServlet("/editstudent")
public class EditStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("id"));
		StudentService personService=new StudentService();
	Student student	 =personService.getByIdStudentService(id);
	if(student != null)
	{
		req.setAttribute("shiva", student);
		RequestDispatcher dispatcher=req.getRequestDispatcher("updatestudent.jsp");
		dispatcher.forward(req, resp);
	}
	else
	{
		RequestDispatcher dispatcher=req.getRequestDispatcher("editstudent.jsp");
		dispatcher.include(req, resp);
	}
	}

}