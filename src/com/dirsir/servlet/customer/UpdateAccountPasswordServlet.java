package com.dirsir.servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dirsir.dao.entities.Account;
import com.dirsir.service.customer.AccountService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class UpdateAccountPasswordServlet
 */
@WebServlet("/customer/UpdateAccountPasswordServlet")
public class UpdateAccountPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charest=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		AccountService service=new AccountService();
		String password1= request.getParameter("password1");
		Account account= (Account) session.getAttribute("account");
		int accountid=account.getAccountId();
		boolean flag= service.uptateAccountPassword(accountid,password1);
		JSONArray list= new JSONArray();
		list.add(flag);
		out.print(list);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
