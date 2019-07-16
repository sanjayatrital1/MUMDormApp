package edu.mum.cs544.apigateway.service;

import edu.mum.cs544.apigateway.domain.Uzer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    public List<Uzer> getAll();
    public void addUser(Uzer newUser);
    public Uzer getUser(long id);
    public void update(Uzer user);
    public void delete(long id);
    Uzer getUserByEmail(String email);
}
