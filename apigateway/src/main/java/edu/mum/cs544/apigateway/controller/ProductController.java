package edu.mum.cs544.apigateway.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.cs544.apigateway.domain.Product;
import edu.mum.cs544.apigateway.domain.Uzer;
import edu.mum.cs544.apigateway.service.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        model.addAttribute("product",productProxy.getAllProduct());
        return "home";
    }

    @GetMapping(value = "/product/", params = "uid")
    public String getUserProduct(@RequestParam long uid, Model model){
        model.addAttribute("userProduct",productProxy.get(uid));
        return "cart";
    }

    @PostMapping(value = "/product/")
    public String addProduct(@ModelAttribute Product product, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "addProduct";
        }
        productProxy.add(product);
        return "redirect:/";
    }
    @GetMapping(value = "/product")
    public String getProduct(Model model){
       model.addAttribute("product",new Product());
        return "addProduct";
    }
//    @GetMapping("/checkout")
//    public
}
