import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class TimerServlet extends HttpServlet{
   public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException{
     res.setContentType("text/html");
     PrintWriter out = res.getWriter();
     String  roleplayer = req.getParameter("rolepalyer");
     String toastmaster = req.getParameter("toastmaster");
     String time = req.getParameter("time");
     try{
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSl=false","root","1234");
       String q = "insert into user(roleplayer,toastmaster,time) values (?,?,?)";
       PreparedStatement stm = con.prepareStatement(q);
       stm.setString(1,roleplayer);
       stm.setString(2,toastmaster);
       stm.setString(3,time);
       int x = stm.executeUpdate();
       System.out.println("Date Updated successfully..."+x);
      if (x > 0) {
         out.println("<html><body><script>alert('Data Updated Successfully!');window.location='information.html';document.forms['f1'].reset();</script></body></html>");
      } else {
    out.println("<html><body><script>alert('Failed to Update Data!');window.location='timer.html';</script></body></html>");
     }
       con.close();
        }
       catch(Exception e){
                    out.println(e.getMessage());
        }
       }
       }

       
    
