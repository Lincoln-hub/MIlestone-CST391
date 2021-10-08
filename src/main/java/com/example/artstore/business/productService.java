package com.example.artstore.business;

import com.example.artstore.data.productDAO;
import com.example.artstore.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {

    @Autowired
    productDAO dao;

    //findAll() returns findAll() from the DAO
    public List<product> findAll()
    {
        return dao.findAll();
    }

    //findById() returns findById() from the DAO
    public List<product> findById(String id)
    {
        return dao.findById(id);
    }

    //findByName() returns findByName() from the DAO
    public List<product> findByName(String name)
    {
        return dao.findByName(name);
    }

    //deleteById() returns deleteById() from the DAO
    public String deleteById(String id)
    {
        return dao.deleteById(id);
    }

    //addProduct() returns addProduct() from the DAO
    public String addProduct(product product)
    {
        return dao.addProduct(product);
    }

    //updateProduct() returns updateProduct() from the DAO
    public String updateProduct(product product)
    {
        return dao.updateProduct(product);
    }


}
