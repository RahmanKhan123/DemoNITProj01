package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminBean ab = new LoginDAO().login(request);
		if(ab!=null)
		{
			request.setAttribute("msg", "Login Success");
			request.setAttribute("bean", ab);
			request.getRequestDispatcher("loginsuccess.jsp").forward(request, response);
		}
		else {
			request.setAttribute("msg", "Login Failed");
			request.getRequestDispatcher("loginsuccess.jsp").forward(request, response);
		}
	}

}
