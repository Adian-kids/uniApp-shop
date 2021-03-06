package shop.dao;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class baseDao {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/ChinaSoft";
    static final String USER = "ChinaSoft";
    static final String PASS = "12345";

    /**
     * Mysql连接类
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        // 注册 JDBC 驱动
        Class.forName(JDBC_DRIVER);
        // 打开链接
        Connection sqlConnection = DriverManager.getConnection(DB_URL,USER,PASS);

        return sqlConnection;
    }

    /**
     * Mysql执行类
     * @param prepareString
     * @param params
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Map sqlQuery(String prepareString, String[] params) throws SQLException, ClassNotFoundException {

        Map resultMap = new HashMap();
        Connection sqlConnection = getConnection();
        PreparedStatement prepareSql = sqlConnection.prepareStatement(prepareString);
        if(params !=null){
            for (int i = 0; i < params.length; i++) {
                prepareSql.setString(i + 1,params[i]);
            }
        }
        System.out.println(prepareSql);
        switch (prepareString.substring(0,6)){
            case "SELECT":
                ResultSet selectResult = prepareSql.executeQuery();
                resultMap.put("selectResult",selectResult);
                break;
            default:
                int rowNum = prepareSql.executeUpdate();
                resultMap.put("rowNum",rowNum);


        }
        return resultMap;
    }

}
