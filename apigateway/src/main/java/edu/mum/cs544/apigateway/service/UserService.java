package edu.mum.cs544.apigateway.service;

import edu.mum.cs544.apigateway.domain.Uzer;
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
    private final String getByEmailUrl="http://localhost:8082/users/all";
    private final String postForSaveUrl="http://localhost:8082/users/create";

    public List<Uzer> getAll() {
        //return userRepository.findAll(Sort.by("userName"));
        ResponseEntity<List<Uzer>> usersList=restTemplate.exchange(getAllUrl, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Uzer>>() {});
        return usersList.getBody();
    }


    public void addUser(Uzer newUser) {
        restTemplate.postForLocation(postForSaveUrl,newUser);

    }


    public Uzer getUser(long id) {
        //return userRepository.findById(id).orElse(null);
        return restTemplate.getForObject(getByIdUrl, Uzer.class, id);
    }


    public void update(Uzer change) {
//        userRepository.save(change);
    }


    public void delete(long id) {
//        userRepository.deleteById(id);
    }

    @Override
    public Uzer getUserByEmail(String email) {
        return restTemplate.getForObject(getByEmailUrl, Uzer.class, email);
    }


}
