package shop.servlet.order;


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
import shop.dao.orderDao;
import shop.dao.userDao;
import shop.entity.Order;
import shop.entity.User;


@WebServlet("/addOrder")
public class addOrderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String name  = request.getParameter("name");
        String phone = request.getParameter("phone");
        String recvAddress = request.getParameter("address");
        String userId = request.getParameter("userId");
        String goodId = request.getParameter("goodId");
        try {
            // 封装为user对象
            Order order = new Order();
            order.setName(name);
            order.setPhone(phone);
            order.setRecvAddress(recvAddress);
            order.setUserId(Integer.parseInt(userId));
            order.setGoodId(Integer.parseInt(goodId));
            orderDao orderDao = new orderDao();
            int addResult = orderDao.addOrder(order);
            // 处理为json
            response.setContentType("text/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("code",addResult);
            out = response.getWriter();
            out.println(jsonobj);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
