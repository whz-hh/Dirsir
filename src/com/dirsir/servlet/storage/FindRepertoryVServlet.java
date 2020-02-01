package com.dirsir.servlet.storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dirsir.dao.entities.RepertoryV;
import com.dirsir.service.storage.StorageService;



@WebServlet("/storage/FindRepertoryVServlet")
public class FindRepertoryVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		int merchantId = Integer.parseInt(request.getParameter("merchantId"));
		String checkDate = request.getParameter("checkDate");
		StorageService service = new StorageService();
		List<RepertoryV> repertoryV = service.getRepertoryV(checkDate, merchantId);
		PrintWriter out = response.getWriter();
		if(repertoryV != null) {
			out.print(true);
		}else {
			out.print(false);
		}
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
