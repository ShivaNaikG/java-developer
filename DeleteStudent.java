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

@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		StudentService personService=new StudentService();
	Student person	=personService.DeleteStudentService(id);
	if(person != null )
	{
		RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
		dispatcher.forward(req, resp);
	}
	else
	{
		RequestDispatcher dispatcher=req.getRequestDispatcher("deletestudent.jsp");
		dispatcher.include(req, resp);
	}
	}
}
