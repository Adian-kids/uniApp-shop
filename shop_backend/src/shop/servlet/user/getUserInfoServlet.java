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


@WebServlet("/getInfo")
public class getUserInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");

        try {
            // 封装为user对象
            userDao userdao = new userDao();
            User user = userdao.getInfo(Integer.parseInt(userId));
            // 处理为json
            response.setContentType("text/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            JSONArray jsonarray = new JSONArray();
            JSONObject jsonobj = new JSONObject();

            jsonobj.put("email",user.getEmail());
            jsonobj.put("nickName",user.getNickname());
            jsonobj.put("phone",user.getPhone());
            out = response.getWriter();
            out.println(jsonobj);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

