package shop.servlet.order;


import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import shop.dao.orderDao;
import shop.dao.goodsDao;
import shop.entity.Good;
import shop.entity.Order;


@WebServlet("/getOrderList")
public class getOrderListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        try {
            orderDao orderdao = new orderDao();
            List<Order> orderList = orderdao.getOrderList(Integer.parseInt(userId));
            // 处理为json
            response.setContentType("text/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            JSONArray jsonarray = new JSONArray();
            JSONObject allobj = new JSONObject();
            JSONObject jsonobj = new JSONObject();
            for (Order order : orderList){
                jsonobj.put("orderId",order.getOrderId());
                jsonobj.put("goodId",order.getGoodId());
                // 获取商品详细信息
                goodsDao goodsdao = new goodsDao();
                Good good = goodsdao.getGoodInfo(order.getGoodId());
                jsonobj.put("goodTitle",good.getTitle());
                jsonobj.put("goodPrice",good.getPrice());
                jsonobj.put("goodImg",good.getImg());

                jsonobj.put("name",order.getName());
                jsonobj.put("phone",order.getPhone());
                jsonobj.put("address",order.getRecvAddress());
                if (order.getState() == 0){
                    jsonobj.put("state","未发货");
                }else {
                    jsonobj.put("state","已发货");
                }
                jsonobj.put("express",order.getExpress());
                jsonarray.add(jsonobj);
            }
            allobj.put("orderList",jsonarray);
            out = response.getWriter();
            out.println(allobj);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
