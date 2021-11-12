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


@WebServlet("/changeInfo")
public class editUserInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String nickName = request.getParameter("nickName");
        String userId = request.getParameter("userId");

        try {
            // 封装为user对象
            User user = new User();
            user.setPhone(phone);
            user.setNickname(nickName);
            user.setUserId(Integer.parseInt(userId));
            userDao userdao = new userDao();
            int changeResult = userdao.changeInfo(user);
            // 处理为json
            response.setContentType("text/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            JSONArray jsonarray = new JSONArray();
            JSONObject jsonobj = new JSONObject();

            jsonobj.put("code", changeResult);

            out = response.getWriter();
            out.println(jsonobj);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

