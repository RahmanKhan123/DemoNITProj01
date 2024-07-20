package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		AdminBean ab=new AdminBean();
		ab.setName(request.getParameter("name"));
		ab.setpWord(request.getParameter("pword"));
		ab.setfName(request.getParameter("fname"));
		ab.setlName(request.getParameter("lname"));
		int register = new AdminRegisterDAO().register(ab);
		if(register>0)
		{
		pw.println("Admin Registered Successfully.....");
		request.getRequestDispatcher("home.html").include(request, response);
		}
		else {
			pw.println("Invalid Process.....");
			request.getRequestDispatcher("home.html").include(request, response);
		}
	}

}
