package shop.servlet.good;

import shop.entity.Good;
import shop.dao.goodsDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import shop.entity.Good;


@WebServlet("/good")
public class getGoodInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String goodId = request.getParameter("goodId");

        try {
            // 获取商品列表
            goodsDao goodsDao = new goodsDao();
            Good good = goodsDao.getGoodInfo(Integer.parseInt(goodId));

            // 处理为json
            response.setContentType("text/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("title",good.getTitle());
            jsonobj.put("img",good.getImg());
            jsonobj.put("content",good.getContent());
            jsonobj.put("goodId",good.getGoodId());
            jsonobj.put("price",good.getPrice());
            out = response.getWriter();
            out.println(jsonobj);








        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

