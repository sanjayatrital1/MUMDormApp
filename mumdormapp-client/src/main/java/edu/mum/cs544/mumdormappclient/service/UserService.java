package edu.mum.cs544.mumdormappclient.service;

import edu.mum.cs544.mumdormappclient.domain.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserService implements IUserService {

    @Resource
    private RestTemplate restTemplate;



    private final String getByIdUrl="http://localhost:8082/users/search/{id}";
    private final String getAllUrl="http://localhost:8082/users/all";
    private final String postForSaveUrl="http://localhost:8082/users/create";

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


}
