import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class httpPostServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String recived_data="";


        String s1=request.getParameter("name");
        String s2=request.getParameter("pass");
        System.out.println(s1);
        System.out.println(s2);

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
            PreparedStatement ps=con.prepareStatement(
                    "insert into javatpoint_user(name,password) values(?,?)");
            ps.setString(1, s1);
            ps.setString(2,s2);
            ps.executeUpdate();
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
