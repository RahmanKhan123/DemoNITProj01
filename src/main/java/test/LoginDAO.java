package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class LoginDAO {

	public AdminBean login(HttpServletRequest req)
	{
		AdminBean ab=null;
		try {
			Connection con=DBConnection.getConnection();
		    PreparedStatement ps=con.prepareStatement
		    		("select * from admin_info where name=? and pword=?");
		    ps.setString(1, req.getParameter("name"));
		    ps.setString(2, req.getParameter("pword"));
		    ResultSet rs = ps.executeQuery();
		    if(rs.next())
		    {
		    ab=new AdminBean();
		    ab.setName(rs.getString(1));
		    ab.setpWord(rs.getString(2));
		    ab.setfName(rs.getString(3));
		    ab.setlName(rs.getString(4));
		    }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
