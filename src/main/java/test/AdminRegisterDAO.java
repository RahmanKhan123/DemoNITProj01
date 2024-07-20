package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminRegisterDAO {

	public int register(AdminBean ab)
	{
		int executeUpdate=0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement
					("insert into admin_info values(?,?,?,?)");
			ps.setString(1, ab.getName());
			ps.setString(2, ab.getpWord());
			ps.setString(3, ab.getfName());
			ps.setString(4, ab.getlName());
		    executeUpdate = ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return executeUpdate;
	}
}
