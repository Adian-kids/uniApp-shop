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


@WebServlet("/goods")
public class getGoodsListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");

        try {
            // 获取商品列表
            goodsDao goodsDao = new goodsDao();
            List<Good> goods = goodsDao.getGoodsList(keyword);
            // 处理为json
            response.setContentType("text/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            JSONArray jsonarray = new JSONArray();
            JSONObject allobj = new JSONObject();
            JSONObject jsonobj = new JSONObject();
            for (Good good : goods){
                jsonobj.put("img",good.getImg());
                jsonobj.put("goodId",good.getGoodId());
                jsonobj.put("title",good.getTitle());
                jsonobj.put("price",good.getPrice());
                jsonarray.add(jsonobj);
            }
            allobj.put("goodslist",jsonarray);
            out = response.getWriter();
            out.println(allobj);








        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

