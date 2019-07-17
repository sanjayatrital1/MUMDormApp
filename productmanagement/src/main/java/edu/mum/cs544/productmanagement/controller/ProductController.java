package edu.mum.cs544.productmanagement.controller;

import edu.mum.cs544.productmanagement.domain.Product;
import edu.mum.cs544.productmanagement.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController

public class ProductController {

    @Autowired
   private ProductServiceImpl productService;

    @GetMapping("/product/")
    public List<Product>getAll(){
        System.out.println(productService.getAll());
        return productService.getAll();
    }

    @PostMapping(value = "/product/", params = "uid")
    public Long add(@RequestParam long uid,@RequestBody Product product){
        product.setUserId(uid);
        product.setStatus(true);
        System.out.println("============================");
        System.out.println(productService.add(product));
        return productService.add(product);
    }

    @GetMapping(value = "/product/{id}")
    public Product get(@PathVariable long id){
        System.out.println("=========================");
        System.out.println(productService.get(id));
        return productService.get(id);
    }

    @GetMapping(value = "/product/", params = "uid")
    public List<Product> getUSerProduct(@RequestParam long uid){
        return productService.findByUser(uid);
    }

    @PutMapping(value = "/product/{id}")
    public void update(@PathVariable long id, @RequestBody Product product){
        if(id != product.getId()){
            throw new IllegalArgumentException();
        }
        productService.update(product);
    }

    @DeleteMapping(value = "/product/{id}")
    public void delete(@PathVariable long id){
        productService.delete(id);
    }

    @PostMapping(value = "/product/redirect/")
    public RedirectView post(@RequestBody Product person) {
        long id = productService.add(person);
        return new RedirectView("/product/" + id);
    }

    @GetMapping(value = "/product/category/{category}")
    public List<Product>findByCategory(@PathVariable String category){
        return productService.searchByCategory(category);
    }


}
