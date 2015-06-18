import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Patient_Retrieve extends HttpServlet
{	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
		res.setContentType("text/html");
		String btn=req.getParameter("submit");
		String Patientid="";
		try{
			PrintWriter out=res.getWriter();
			Empid=req.getParameter("Patientid");
			Class.forName("com.mysql.jdbc.Driver");
		        String url="jdbc://localhost:3306/project";
			Connection con=DriverManager.getConnection(url,"admin","prudhvi");
			Statement st=con.createStatement();
					
				String query="select * from PATIENT where Patientid="+Patientid;
				ResultSet rs=st.executeQuery(query);
				out.println("<html><head><title>DETAILS</title></head><center><body bgcolor=launder><table border=5><tr>"+
				"<td>Patientid</td><td>name</td><td>age</td><td>gender</td><td>compalint</td></tr>");
				while(rs.next())
				{
					out.print("<tr><td>"+rs.getInt("Patientid")+"</td>");
					out.print("<td>"+rs.getString("name")+"</td>");
					out.print("<td>"+rs.getString("age")+"</td>");
					out.print("<td>"+rs.getString("gender")+"</td>");
					out.print("<td>"+rs.getString("complaint")+"</td></tr>");
				}	
				out.println("</table></body></center></html>");
				con.close();
				
		}//try
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}//catch
	}//doGet
}//class
