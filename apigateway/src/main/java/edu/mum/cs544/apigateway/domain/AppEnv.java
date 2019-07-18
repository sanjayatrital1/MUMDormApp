package edu.mum.cs544.apigateway.domain;


public class AppEnv{
    private static final String userService = "http://172.19.141.163:8082";
    private static final  String productService = "http://172.19.144.129:8083";
    private static final  String cartService = "http://172.19.144.129:8083";

    public static String getUserService() {
        return userService;
    }

    public static String getProductService() {
        return productService;
    }

    public static String getCartService() {
        return cartService;
    }
}
