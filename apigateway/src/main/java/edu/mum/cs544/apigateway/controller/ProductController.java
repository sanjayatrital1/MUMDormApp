package edu.mum.cs544.apigateway.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.cs544.apigateway.domain.Product;
import edu.mum.cs544.apigateway.service.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.DataInput;
import java.io.IOException;
import java.util.List;
@Controller
public class ProductController {
    @Autowired
    ProductProxy productProxy;
    ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/")
    public String getAll( Model model, Product product){
//        product = mapper.readValue((DataInput) productProxy.get(id),Product.class);
        model.addAttribute("product",productProxy.getAllProduct());
       // model.addAttribute("product",productProxy.getAllProduct());
        return "home";
    }

//    @PostMapping(value = "/product/", params = "uid")
//    public String getUserProduct(@PathVariable long uid, Model model){
//        model.addAttribute("userProduct",productProxy.get(uid));
//        return "cart";
//    }
}
