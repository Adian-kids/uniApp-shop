package shop.dao;

import shop.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class orderDao {
    public int addOrder(Order order) throws SQLException, ClassNotFoundException {
        String userId = Integer.toString(order.getUserId());
        String goodId = Integer.toString(order.getGoodId());
        String State = "0";
        String express = "null";
        String recvAddress = order.getRecvAddress();
        String name = order.getName();
        String phone = order.getPhone();
        String sqlString = "INSERT INTO orders (userId,goodId,state,express,recvAddress,name,phone) VALUES (?,?,?,?,?,?,?)";
        baseDao basedao = new baseDao();
        String[] params = {userId,goodId,State,express,recvAddress,name,phone};
        Map insertResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) insertResult.get("rowNum");
        return rowNum;
    }
    public int deleteOrder (int orderId) throws SQLException, ClassNotFoundException {
        String sqlString = "DELETE FROM orders WHERE orderId=?";
        String[] params = {Integer.toString(orderId)};
        baseDao basedao = new baseDao();
        Map deleteResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) deleteResult.get("rowNum");
        return rowNum;
    }
    public List getOrderList(int userId) throws SQLException, ClassNotFoundException {
        List<Order> orderList = new ArrayList();
        String sqlString = "SELECT * FROM orders WHERE userId=?";
        String[] params = {Integer.toString(userId)};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
            Order order = new Order();
            order.setOrderId(selectResultSet.getInt("orderId"));
            order.setGoodId(selectResultSet.getInt("goodId"));
            order.setExpress(selectResultSet.getString("express"));
            order.setState(selectResultSet.getInt("state"));
            order.setRecvAddress(selectResultSet.getString("recvAddress"));
            order.setName(selectResultSet.getString("name"));;
            order.setPhone(selectResultSet.getString("phone"));
            orderList.add(order);
        }

        return orderList;
    }
    public List getAllOrder() throws SQLException, ClassNotFoundException {
        List<Order> orderList = new ArrayList();
        String sqlString = "SELECT * FROM orders";
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,null);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        while (selectResultSet.next()){
            Order order = new Order();
            order.setOrderId(selectResultSet.getInt("orderId"));
            order.setGoodId(selectResultSet.getInt("goodId"));
            order.setExpress(selectResultSet.getString("express"));
            order.setState(selectResultSet.getInt("state"));
            order.setRecvAddress(selectResultSet.getString("recvAddress"));
            order.setName(selectResultSet.getString("name"));;
            order.setPhone(selectResultSet.getString("phone"));
            orderList.add(order);
        }

        return orderList;
    }

    public int sendOut(int orderId,String express) throws SQLException,ClassNotFoundException{
        String sqlString = "UPDATE orders SET state=1,express=? WHERE orderId=?";
        String[] params = {express,Integer.toString(orderId)};
        baseDao basedao = new baseDao();
        Map updateResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) updateResult.get("rowNum");
        return rowNum;
    }
}
