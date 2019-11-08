package com.exercise31session.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html charset='utf-8'");
		PrintWriter output = response.getWriter();
		
		String userName = request.getParameter("txtUserName");
		String password = request.getParameter("txtPassword");
		
		// Access the data base to validate that userName and the password exist
		if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			output.println("Username:" + userName);
			output.println("Password: "+ password);
			HttpSession mySesion = request.getSession();
			// Assign 'userName' and 'password' to the object
			mySesion.setAttribute("user", userName);
			mySesion.setAttribute("password", password);
			// Send the data to welcome to check if the user is log
			response.sendRedirect("welcome.jsp");
		}
		else {
			output.println("The user or password doesn't exist");
		}
		output.close();
	}

}
