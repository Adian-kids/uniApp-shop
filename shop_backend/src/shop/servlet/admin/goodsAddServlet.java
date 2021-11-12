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


@WebServlet("/goodAdd")
public class goodsAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String price = request.getParameter("price");
        String img = request.getParameter("img");
        System.out.println(title);
        System.out.println(content);
        System.out.println(price);

        try {
            goodsDao goodsDao = new goodsDao();
            Good good = new Good();
            good.setTitle(title);
            good.setContent(content);
            good.setPrice(price);
            good.setImg(img);
            int addResult = goodsDao.addGood(good);
            request.setAttribute("addResult",addResult);
            request.getRequestDispatcher("/admin/goodAdd.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}