package com.erp.test.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.GradeService;
import com.erp.test.service.impl.GradeServiceImpl;

public class GradeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private GradeService gs = new GradeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String uri = request.getRequestURI();
		if ("/grade/grade-list".equals(uri))
		{

			request.setAttribute("gradeList", gs.selectGradeList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/grade/grade-list");
			rd.forward(request, response);
		} else if ("/grade/grade-view".equals(uri))
		{
			Map<String, Object> grade = new HashMap<>();
			grade.put("grd_no", Integer.parseInt(request.getParameter("grd_no")));
			request.setAttribute("grade", gs.selectGrade(grade));
			RequestDispatcher rd = request.getRequestDispatcher("/views/grade/grade-view");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if("/grade/grade-update".equals(uri)) {
			Map<String,Object> grade = new HashMap<>();
			grade.put("grd_no", request.getParameter("grd_no"));
			grade.put("grd_name", request.getParameter("grd_name"));
			grade.put("grd_desc", request.getParameter("grd_desc"));
			Map<String,Object> rMap = gs.updateGrade(grade);
			rMap.put("url", "/grade/grade-list");
			request.setAttribute("rMap",rMap);
		}
		
		else if("/grade/grade-delete".equals(uri)) {
			Map<String,Object> grade = new HashMap<>();
			grade.put("grd_no", request.getParameter("grd_no"));
			Map<String,Object> rMap = gs.deleteGrade(grade);
			rMap.put("url", "/grade/grade-list");
			request.setAttribute("rMap",rMap);
		}else if("/grade/grade-insert".equals(uri)) {
			Map<String,Object> grade = new HashMap<>();
			grade.put("grd_no", request.getParameter("grd_no"));
			grade.put("grd_name", request.getParameter("grd_name"));
			grade.put("grd_desc", request.getParameter("grd_desc"));
			Map<String,Object> rMap = gs.insertGrade(grade);
			rMap.put("url", "/grade/grade-list");
			request.setAttribute("rMap",rMap);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg");
		rd.forward(request,response);
	}
}
