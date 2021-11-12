package shop.servlet.admin;


import shop.dao.goodsDao;
import shop.dao.orderDao;
import shop.entity.Good;
import shop.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/orderManage")
public class orderManageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        try {
            orderDao orderdao = new orderDao();
            goodsDao gooddao = new goodsDao();
            List<Good> goodList = gooddao.getGoodsList("all");
            List<Order> orderList = orderdao.getAllOrder();
            request.setAttribute("orderList",orderList);
            request.setAttribute("goodList",goodList);
            request.getRequestDispatcher("/admin/orderManage.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}