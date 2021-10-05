package com.example.artstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class ArtStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtStoreApplication.class, args);

        System.out.println("Whats up1111");
        String url = "jdbc:mysql://localhost:3306/artstoredb";
        String user ="root";
        String password ="root";
        Connection conn;

        {
            try {
                conn = DriverManager.getConnection(url,user,password);
                Statement st = conn.createStatement();
                String sql = "SELECT * FROM PRODUCT";
                ResultSet rs = st.executeQuery(sql);

                while(rs.next())
                {
                    System.out.println(rs.getString("PRODUCT_NAME"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
