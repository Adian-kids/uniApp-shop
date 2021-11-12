package shop.servlet.user;


import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import shop.dao.userDao;
import shop.entity.User;


@WebServlet("/register")
public class registerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String passwd = request.getParameter("passwd");

        try {
            // 封装为user对象
            User user = new User();
            user.setEmail(email);
            user.setPasswd(passwd);
            userDao userdao = new userDao();
            Map registerResult = userdao.register(user);
            // 处理为json
            response.setContentType("text/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            JSONArray jsonarray = new JSONArray();
            JSONObject jsonobj = new JSONObject();
            // 两种状态
            if (registerResult.get("code").equals("0")) {
                jsonobj.put("code", registerResult.get("code"));
            }else {
                jsonobj.put("code", registerResult.get("code"));
                jsonobj.put("userId", registerResult.get("userId"));
            }
            out = response.getWriter();
            out.println(jsonobj);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }
}
