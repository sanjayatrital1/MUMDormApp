package edu.mum.cs544.apigateway.service;

import edu.mum.cs544.apigateway.domain.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserService implements IUserService {

    @Resource
    private RestTemplate restTemplate;



    private final String getByIdUrl="http://localhost:8082/users/search/{id}";
    private final String getAllUrl="http://localhost:8082/users/all";
    private final String getByEmailPasswordUrl="http://localhost:8082/users/lookupuser/{email}/{password}";
    private final String getByEmailUrl="http://localhost:8082/users/lookupbyemail/{email}";
    private final String postForSaveUrl="http://localhost:8082/users/create";
    private final String getByObjUrl="http://localhost:8082/users/lookupbyobject/";

    public List<User> getAll() {
        //return userRepository.findAll(Sort.by("userName"));
        ResponseEntity<List<User>> usersList=restTemplate.exchange(getAllUrl, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<User>>() {});
        return usersList.getBody();
    }


    public void addUser(User newUser) {
        restTemplate.postForLocation(postForSaveUrl,newUser);

    }


    public User getUser(long id) {
        //return userRepository.findById(id).orElse(null);
        return restTemplate.getForObject(getByIdUrl, User.class, id);
    }


    public void update(User change) {
//        userRepository.save(change);
    }


    public void delete(long id) {
//        userRepository.deleteById(id);
    }

    @Override
    public Long getUserIdByEmail(String email, String password) {
        Long userId=restTemplate.getForObject(getByEmailPasswordUrl,Long.class,email,password);
        System.out.println("User Id is :"+userId);
        return userId;
    }


    public User getUserByEmail(String email) {
        User userId=restTemplate.getForObject(getByEmailUrl,User.class,email);
        System.out.println("User Id is :"+userId);
        return userId;
    }

    @Override
    public String getUserByObject(User testUser) {
        User user= restTemplate.postForObject(getByObjUrl,testUser,User.class);
        if (user==null)
            return null;
        return user.getUserName();
    }


}
