package shop.servlet.admin;

import shop.dao.goodsDao;
import shop.entity.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/goodDelete")
public class goodsDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String goodId = request.getParameter("goodId");

        try {
            goodsDao goodsDao = new goodsDao();
            int deleteResult = goodsDao.deleteGood(Integer.parseInt(goodId));
            request.setAttribute("deleteResult",deleteResult);
            request.getRequestDispatcher("/admin/goodManage.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}