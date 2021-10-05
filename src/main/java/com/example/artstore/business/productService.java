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

    public List<product> findAll()
    {
        return dao.findAll();
    }

    public List<product> findById(String id)
    {
        return dao.findById(id);
    }

    public List<product> findByName(String name)
    {
        return dao.findByName(name);
    }

    public String deleteById(String id)
    {
        return dao.deleteById(id);
    }


}
