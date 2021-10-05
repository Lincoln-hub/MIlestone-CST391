package com.example.artstore.data;
import com.example.artstore.model.product;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class productDAO {

    String url = "jdbc:mysql://localhost:3306/artstoredb";
    String user ="root";
    String password ="root";
    Connection conn;

    public productDAO()
    {

    }

    public List<product> findAll()
    {

        try {
            conn = DriverManager.getConnection(url,user,password);
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM PRODUCT";
            ResultSet rs = st.executeQuery(sql);
            List<product> rs1 = new ArrayList<>();


            while(rs.next())
            {
                rs1.add(new product(rs.getString("ID"),rs.getString("PRODUCT_NAME"),rs.getString("PRODUCT_DESCRIPTION"),rs.getString("PRODUCT_PRICE")));

            }

            return rs1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public List<product> findById(String id)
    {
        try {
            conn = DriverManager.getConnection(url,user,password);
            Statement st = conn.createStatement();
            int i = Integer.parseInt(id);
            String sql = "SELECT * FROM PRODUCT WHERE ID = " +i ;
            ResultSet rs = st.executeQuery(sql);

            List<product> rs1 = new ArrayList<>();


            while(rs.next())
            {
                rs1.add(new product(rs.getString("ID"),rs.getString("PRODUCT_NAME"),rs.getString("PRODUCT_DESCRIPTION"),rs.getString("PRODUCT_PRICE")));

            }

            return rs1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<product> findByName(String name)
    {
        try {
            conn = DriverManager.getConnection(url,user,password);
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME  LIKE " + name+"%";
            ResultSet rs = st.executeQuery(sql);

            List<product> rs1 = new ArrayList<>();


            while(rs.next())
            {
                rs1.add(new product(rs.getString("ID"),rs.getString("PRODUCT_NAME"),rs.getString("PRODUCT_DESCRIPTION"),rs.getString("PRODUCT_PRICE")));

            }

            return rs1;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String deleteById(String id)
    {
        try {
            conn = DriverManager.getConnection(url,user,password);
            Statement st = conn.createStatement();
            String sql = "DELETE FROM PRODUCT WHERE ID =" + id;
            int rs = st.executeUpdate(sql);


            return "Successfully deleted product with id of "+ id;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
