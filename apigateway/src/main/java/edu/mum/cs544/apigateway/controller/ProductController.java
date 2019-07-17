package edu.mum.cs544.apigateway.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.cs544.apigateway.domain.Product;
import edu.mum.cs544.apigateway.service.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.DataInput;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"username","userId"})
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
    public String addProduct(@ModelAttribute("userId") String userId,@ModelAttribute Product product, BindingResult result, Model model, HttpSession session){

        System.out.println("User Id= "+userId);
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "addProduct";
        }
        productProxy.add(product, userId);
        return "redirect:/";
    }
    @GetMapping(value = "/product")
    public String getProduct(Model model){
       model.addAttribute("product",new Product());
        return "addProduct";
    }
    @GetMapping("/product?category=")
    public String findByCategory(Model model) {
        model.addAttribute("category");
        return "home";
    }
//    @GetMapping("/checkout")
//    public

    @ModelAttribute("categoryList")
    public Map<String, String> getCountryList(){
        Map<String, String> categoryList = new HashMap<String, String>();
        categoryList.put("NB", "Notebook");
        categoryList.put("SP", "Smartphone");
        categoryList.put("AC", "Accessories");
        return categoryList;
    }
}
