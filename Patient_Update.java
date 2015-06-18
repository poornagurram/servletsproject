import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Patient_Update extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
		res.setContentType("text/html");
		String Patientid="1";
		String btn=req.getParameter("submit");
		
		try
			{
				PrintWriter out=res.getWriter();
				Class.forName("com.mysql.jdbc.Driver");
				
				String url="jdbc://localhost:3306/project";
				Connection con=DriverManager.getConnection(url,"admin","prudhvi");
				Statement stm=con.createStatement();
				if(btn.equals("UPDATE"))
					{
						Patientid=req.getParameter("Patientid");
						String field=req.getParameter("field");
						String upd=req.getParameter("upd");
						if(field.equals("name"))
							{
								String updateq="update PATIENT set name='"+upd+"'where Patientid=" +Patientid;
								PreparedStatement ps=con.prepareStatement(updateq);
								ps.executeUpdate(updateq);
								String address="./Registered.html";
								RequestDispatcher dis=req.getRequestDispatcher(address);
								dis.forward(req,res);
							}
						else if(field.equals("age"))
							{
								String updateq="update PATIENT set age='"+upd+"'where Patientid=" +Patientid;
								PreparedStatement ps=con.prepareStatement(updateq);
								ps.executeUpdate(updateq);
								String address="./Registered.html";
								RequestDispatcher dis=req.getRequestDispatcher(address);
								dis.forward(req,res);
							}
					}
			}//try
					catch(Exception e)
						{					
							System.out.println("Exception:" +e);
						}
	}	
}
