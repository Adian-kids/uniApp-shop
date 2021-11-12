package shop.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import shop.entity.Good;

public class goodsDao{
    public List<Good> getGoodsList(String keyword) throws SQLException, ClassNotFoundException {
        List <Good> goodList = new ArrayList();
        String sqlString = null;
        String[] params = {keyword};
        baseDao basedao = new baseDao();
        if(keyword.equals("all")){
            sqlString = "SELECT * FROM goods";
        }else {
            sqlString = "SELECT * FROM goods WHERE title like '%" + keyword + "%'";
        }
        Map selectResult = basedao.sqlQuery(sqlString,null);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
            Good good = new Good();
            good.setGoodId(selectResultSet.getInt("goodId"));
            good.setTitle(selectResultSet.getString("title"));
            good.setImg(selectResultSet.getString("img"));
            good.setPrice(selectResultSet.getString("price"));
            goodList.add(good);
        }
        return goodList;
    }

    public Good getGoodInfo(int goodId) throws SQLException, ClassNotFoundException {
        Good good = new Good();
        String sqlString = "SELECT * FROM goods WHERE goodId=?";
        String[] params = {Integer.toString(goodId)};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
            good.setGoodId(selectResultSet.getInt("goodId"));
            good.setTitle(selectResultSet.getString("title"));
            good.setImg(selectResultSet.getString("img"));
            good.setPrice(selectResultSet.getString("price"));
            good.setContent(selectResultSet.getString("content"));
        }
        return good;
    }
    public int deleteGood(int goodId) throws SQLException, ClassNotFoundException {
        String sqlString = "DELETE FROM goods WHERE goodId=?";
        String[] params = {Integer.toString(goodId)};
        baseDao basedao = new baseDao();
        Map deleteResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) deleteResult.get("rowNum");
        return rowNum;
    }

    public int addGood(Good good) throws SQLException,ClassNotFoundException{
        String title = good.getTitle();
        String content = good.getContent();
        String img = good.getImg();
        String price = good.getPrice();
        String sqlString = "INSERT INTO goods (title,content,price,img) VALUES (?,?,?,?)";
        String[] params = {title,content,price,img};
        baseDao basedao = new baseDao();
        Map insertResult = basedao.sqlQuery(sqlString,params);
        int addResult = (int) insertResult.get("rowNum");
        return addResult;
    }
}
