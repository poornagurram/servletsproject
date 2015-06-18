
package Patient_insert;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Patient_Insert extends HttpServlet
	{
		public void doGet(HttpServletRequest req,HttpServletResponse res)
		{
			res.setContentType("text/html");
			String btn=req.getParameter("submit");
			
			String Patientid=" ";
			String name=" ";
			String age=" ";
			String gender=" ";
			String complaint=" ";
			
			try
				{
					PrintWriter out=res.getWriter();
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc://localhost:3306/project";
					Connection con=(Connection) DriverManager.getConnection(url,"admin","prudhvi");
					
					if(btn.equals("INSERT"))
						{
							Patientid=req.getParameter("Patientid");
							name=req.getParameter("name");
							age=req.getParameter("age");
							gender=req.getParameter("gender");
							complaint=req.getParameter("complaint");
							
					String insertq="insert into PATIENT values(?,?,?,?,?)";
						PreparedStatement ps=(PreparedStatement) con.prepareStatement(insertq);
							ps.setInt(1,Integer.parseInt(Patientid));
							ps.setString(2,name);
							ps.setString(3,age);
							ps.setString(4,gender);
							ps.setString(5,complaint);
							
							ps.executeUpdate();
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
