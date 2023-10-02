package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = null;
            String userName = "root";
            String password = "hommageynk24";
            String url = "jdbc:mysql://localhost:3306/customer";

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("연결 실패");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("알수 없는 오류");
            e.printStackTrace();
        }
        return connection;
    }
}
