package com.erp.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.EmployeeService;
import com.erp.test.service.GradeService;
import com.erp.test.service.impl.EmployeeServiceImpl;
import com.erp.test.service.impl.GradeServiceImpl;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService es = new EmployeeServiceImpl();	
	private GradeService gs = new GradeServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if("/employee/employee-list".equals(uri)) {
			request.setAttribute("empList", es.selectEmployeeList(null));
			request.setAttribute("grdList", gs.selectGradeList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/employee/employee-list");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
