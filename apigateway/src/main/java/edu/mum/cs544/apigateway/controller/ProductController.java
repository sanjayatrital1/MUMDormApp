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
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.File;
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
    public String addProduct(@ModelAttribute("userId") String userId,@ModelAttribute Product product, BindingResult result, Model model,  @RequestParam("file") MultipartFile file) throws IOException {

        System.out.println("User Id= "+userId);
        if (result.hasErrors()) {
            System.out.println("ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
            model.addAttribute("errors", result.getAllErrors());
            return "addProduct";
        }

            if (!file.isEmpty()) {
                BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
                System.out.println(src);
                System.out.println(file.getName());
                File destination = new File("C:/Users/sanjaya/IdeaProjects/EALabs/EAProject/cs544EAproject/apigateway/src/main/webapp/resources/img/"+product.getProductName()+product.getId()+".jpg") ;// something like C:/Users/tom/Documents/nameBasedOnSomeId.png
                ImageIO.write(src,"JPG",destination);
//                ImageIO.createImageOutputStream(new File(""));
                //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
            product.setImage(destination.getName());
                System.out.println(destination.getPath());
                System.out.println(destination.getName());
                System.out.println(destination.getAbsoluteFile());
            }
        System.out.println("SUUUUUUUUUUUUUUUUUUUUCCCCCCCCCCCCCCESSSSSSSSSS");
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

    @GetMapping(value = "/productPage/{id}")
    public String getProduct(@PathVariable long id ,Model model){
        model.addAttribute("productData",productProxy.get(id));
        return "product";
    }
}
