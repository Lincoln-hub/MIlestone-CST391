package com.example.artstore.controller;

import com.example.artstore.business.productService;
import com.example.artstore.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Service
@RestController
@RequestMapping( value = "/products")
public class productController {

    @Autowired
    private productService ps;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<product> getAll()
    {
        return ps.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<product> findById(@PathVariable("id") String id)
    {
        return ps.findById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteById(@PathVariable("id") String id)
    {
        return ps.deleteById(id);
    }

    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public List<product> findByName(@PathVariable("name") String name)
    {
        return ps.findByName(name);
    }



}
