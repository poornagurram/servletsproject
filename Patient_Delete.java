import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Patient_Delete extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
		res.setContentType("text/html");
		String btn=req.getParameter("submit");
		
		String Patientid="";
		
			try
				{
				PrintWriter out=res.getWriter();
				Class.forName("com.mysql.jdbc.Driver");
				
				String url="jdbc://localhost:3306/project";
	Connection con=DriverManager.getConnection(url,"admin","prudhvi");
	Statement stm=con.createStatement();
	if(btn.equals("DELETE"))
		{
			Patientid=req.getParameter("Patientid");
			String deleteq="delete from PATIENT where Patientid=" +Patientid;
			PreparedStatement ps=con.prepareStatement(deleteq);
			ps.executeQuery(deleteq);
			String address="./Registered.html";
			RequestDispatcher dis=req.getRequestDispatcher(address);
			dis.forward(req,res);
		}
		}
	catch(Exception e)
	{
		System.out.println("Exception:" +e);
	}
	}
}
			
