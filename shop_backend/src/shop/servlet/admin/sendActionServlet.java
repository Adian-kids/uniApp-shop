package shop.servlet.admin;


import shop.dao.goodsDao;
import shop.dao.orderDao;
import shop.entity.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/sendAction")
public class sendActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        String express = request.getParameter("express");

        try {
            orderDao orderdao = new orderDao();
            int updateResult = orderdao.sendOut(Integer.parseInt(orderId),express);
            request.setAttribute("updateResult",updateResult);
            request.getRequestDispatcher("/admin/sendOut.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}