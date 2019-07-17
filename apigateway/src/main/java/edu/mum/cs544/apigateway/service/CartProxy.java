package edu.mum.cs544.apigateway.service;

import edu.mum.cs544.apigateway.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ProductProxy implements ProductService {
    @Autowired
    private RestTemplate restTemplate;

   private String productIp ="http://localhost:8083";//"http://172.19.141.122:8083";
    private final String productUrl = productIp+"/product/{id}";
    private final String pplUrl = productIp+"/product/";
    private final String addUrl =productIp+"/product/?uid=1";


    @Override
    public List<Product> getAllProduct() {
        ResponseEntity<List<Product>> response =
                restTemplate.exchange(pplUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Product>>() {
                        });
        return response.getBody();
    }

    @Override
    public Product get(long id) {
        return restTemplate.getForObject(productUrl, Product.class, id);
    }

    @Override
    public void add(Product product) {
       restTemplate.postForLocation(addUrl, product);
//        if (uri == null) {
//            return null;
//        }
//        Matcher m = Pattern.compile(".*/product/(\\d+)").matcher(uri.getPath());
//        m.matches();
//        return Long.parseLong(m.group(1));
    }

    @Override
    public void delete(long id) {
        restTemplate.delete(productUrl, id);
    }

    @Override
    public void update(Product product) {
        restTemplate.put(productUrl, product, product.getId());
    }
//    @Override
//    public List<Product>getUserProduct(long id){
//
//    }
}
