package com.jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Student;
import com.jsp.service.StudentService;


@WebServlet("/displayAll")
public class GetAllStudentData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	StudentService studentService=new StudentService();
List<Student>list=studentService.getByAllStudentService();
if(list.size()>0)
{
	req.setAttribute("shiva", list);
	RequestDispatcher dispatcher=req.getRequestDispatcher("dispalystudent.jsp");
	dispatcher.forward(req, resp);
}
else
{
	RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
	dispatcher.include(req, resp);
}
	}

}
