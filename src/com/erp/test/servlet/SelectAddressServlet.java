package com.erp.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.impl.SelectAddressServiceImpl;



public class SelectAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectAddressServiceImpl saService = new SelectAddressServiceImpl();
    
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sido = request.getParameter("sido");
		List<String> sidoList = saService.selectSidoList(null);
		request.setAttribute("sidoList",sidoList);
		if(sido!=null)
		{
			List<String> gugunList = saService.selectGugunList(sido);
			request.setAttribute("gugunList",gugunList);
			String gugun = request.getParameter("gugun");
			if(gugun!=null)
			{
				List<String> dongList = saService.selectDongList(sido, gugun);
				request.setAttribute("dongList", dongList);
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/div");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
