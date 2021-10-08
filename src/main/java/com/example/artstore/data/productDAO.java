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

    //returns all the products in the PRODUCT table
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

    //returns a product by ID
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

    //returns a product by name
    public List<product> findByName(String name)
    {
        try {
            conn = DriverManager.getConnection(url,user,password);

            String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME  LIKE ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+name+"%");

            ResultSet rs = statement.executeQuery();
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

    //deletes a product by Id
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

    //adds a product to the PRODUCT table
    public String addProduct(product product)
    {
        try {
            conn = DriverManager.getConnection(url,user,password);
            String name = product.getProductName();
            String desc = product.getProductDescription();
            String price = product.getProductPrice();

            String sql = "INSERT INTO `PRODUCT` (`PRODUCT_NAME`, `PRODUCT_DESCRIPTION`, `PRODUCT_PRICE`) VALUES(?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, desc);
            statement.setString(3, price);

            int rs = statement.executeUpdate();

            return "Successfully added the product";

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return throwables.toString();
        }
    }

    //updates the price of a products by Id
    public String updateProduct(product product)
    {
        try {
            conn = DriverManager.getConnection(url,user,password);
            Statement st = conn.createStatement();
            String id = product.getId();
            String price = product.getProductPrice();

            String sql = "UPDATE `PRODUCT` SET `PRODUCT_PRICE` = ? WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, price);
            statement.setString(2, id);

            int rs = statement.executeUpdate();

            return "Successfully updated the product price";

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return throwables.toString();
        }
    }

}
