package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static Connection getConnection(){
        Connection connection = null;
        String userName = "ADMIN";
        String password = "!Hommageynk24";
        String url = "jdbc:oracle:thin:@hidongmin37_high?TNS_ADMIN=/Users/hidongmin37/web_1900_hds/resource/Wallet_hidongmin37";
        //드라이버를 메모리에 할당
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url,userName,password);
            System.out.println("연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("연결 실패");
            e.printStackTrace();
        }

        return connection;
    }
}
