package edu.mum.cs544.apigateway.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.cs544.apigateway.domain.Cart;
import edu.mum.cs544.apigateway.domain.Product;
import edu.mum.cs544.apigateway.service.CartProxy;
import edu.mum.cs544.apigateway.service.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.DataInput;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    ProductProxy productProxy;

    @Autowired
    CartProxy cartProxy;

    ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/")
    public String getAll( Model model, Product product){
        model.addAttribute("product",productProxy.getAllProduct());

        List<Cart> carts = cartProxy.getAll(1);
        model.addAttribute("items", carts.size());
        model.addAttribute("cart", carts);
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

    @ModelAttribute("categoryList")
    public Map<String, String> getCountryList() {
        Map<String, String> categoryList = new HashMap<String, String>();
        categoryList.put("NB", "Notebook");
        categoryList.put("SP", "Smartphone");
        categoryList.put("AC", "Accessories");
        return categoryList;
    }
}
