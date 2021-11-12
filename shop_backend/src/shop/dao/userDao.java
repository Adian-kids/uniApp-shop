package shop.dao;

import shop.entity.User;
import shop.utils.md5;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class userDao {
    public Map login(User user) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String email = user.getEmail();
        String passwd = user.getPasswd();
        String sqlString = "SELECT * FROM user WHERE email=?";
        String[] params = {email};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        Map resultMap = new HashMap();
        if (selectResultSet.next()){
            String passwd_database = selectResultSet.getString("passwd");
            passwd = new md5().md5Encrypt(passwd);
            System.out.println(passwd);
            System.out.println(passwd_database);
            if (passwd_database.equals(passwd)){
                System.out.println("密码对了");
                int userId = selectResultSet.getInt("userId");
                resultMap.put("code",1);
                resultMap.put("userId",Integer.toString(userId));
                return resultMap;
            }
            else {
                resultMap.put("code",0);
                return resultMap;
            }
        }else {
            resultMap.put("code",0);
            return resultMap;
        }
    }

    public Map register(User user) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        Map resultMap = new HashMap();
        String email = user.getEmail();
        String userId = null;
        int checkEmailResult = this.checkEmail(email);
        if (checkEmailResult == 1) {
            String nickName = "用户" + email;
            String passwd = new md5().md5Encrypt(user.getPasswd());
            baseDao basedao = new baseDao();
            String sqlString = "INSERT INTO user (email,nickName,passwd) VALUES (?,?,?)";
            String[] params = {email, nickName, passwd};
            Map insertResult = basedao.sqlQuery(sqlString, params);
            int rowNum = (int) insertResult.get("rowNum");
            String getIdSqlString = "SELECT userId FROM user WHERE email=?";
            String[] paramsNew = {email};
            Map selectResult = basedao.sqlQuery(getIdSqlString,paramsNew);
            ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
            while (selectResultSet.next()){
                userId = Integer.toString(selectResultSet.getInt("userId"));
                System.out.println(userId);
            }

            resultMap.put("code","1");
            resultMap.put("userId",userId);
        } else {
            resultMap.put("code","0");
        }
        return resultMap;
    }


    public int changeInfo(User user) throws SQLException, ClassNotFoundException {
        String nickName = user.getNickname();
        String phone = user.getPhone();
        String userId = Integer.toString(user.getUserId());
        String sqlString = "UPDATE user SET nickname=?,phone=? WHERE userId=?";
        String[] params = {nickName,phone,userId};
        baseDao basedao = new baseDao();
        Map updateResult = basedao.sqlQuery(sqlString,params);
        int rowNum = (int) updateResult.get("rowNum");
        return rowNum;
    }

    public int checkEmail(String email) throws SQLException, ClassNotFoundException {
        String sqlString = "SELECT * FROM user WHERE email='" + email + "'";
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString, null);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");

        if (selectResultSet.next()) {
            return 0;
        } else {
            return 1;
        }
    }
    public User getInfo(int userId) throws SQLException, ClassNotFoundException {
        String sqlString = "SELECT * FROM user WHERE userId=?";
        String[] params = {Integer.toString(userId)};
        baseDao basedao = new baseDao();
        Map selectResult = basedao.sqlQuery(sqlString,params);
        ResultSet selectResultSet = (ResultSet) selectResult.get("selectResult");
        User user = new User();
        while (selectResultSet.next()){
            user.setEmail(selectResultSet.getString("email"));
            user.setNickname(selectResultSet.getString("nickName"));
            user.setPhone(selectResultSet.getString("phone"));
        }
        return user;
    }
}
