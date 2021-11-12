package shop.servlet.admin;

import shop.dao.baseDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/admin")
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String username = request.getParameter("username");
            String passwd = request.getParameter("passwd");
            baseDao basedao = new baseDao();
            String sqlString = "SELECT passwd FROM manager WHERE username=?";
            String[] params = {username};
            Map selectResult = basedao.sqlQuery(sqlString,params);
            ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
            String passwd_database = null;
            while (selectResultSet.next()){
                passwd_database = selectResultSet.getString("passwd");
            }
            if (passwd.equals(passwd_database)) {
                response.addCookie(new Cookie("isAdmin","1"));
                request.setAttribute("loginResult",1);
            }else {
                request.setAttribute("loginResult",0);
            }
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}