package com.example.artstore.controller;

import com.example.artstore.business.productService;
import com.example.artstore.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Service
@RestController
@RequestMapping( value = "/products")
public class productController {

    @Autowired
    private productService ps;

    //returns all the products in the database
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<product> getAll()
    {
        return ps.findAll();
    }

    //finds a product by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<product> findById(@PathVariable("id") String id)
    {
        return ps.findById(id);
    }

    //deletes a product by id
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteById(@PathVariable("id") String id)
    {
        return ps.deleteById(id);
    }

    //finds a product by name
    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public List<product> findByName(@PathVariable("name") String name)
    {
        return ps.findByName(name);
    }

    //adds a product to the database
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@RequestBody Map<String, String> json)
    {
        product product = new product(null,json.get("name"),json.get("desc"),json.get("price"));
        return ps.addProduct(product);
    }

    //updates the product price
    @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Map<String, String> json)
    {
        product product = new product(json.get("id"),null,null,json.get("price"));
        return ps.updateProduct(product);
    }



}
