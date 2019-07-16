package edu.mum.cs544.service;

import edu.mum.cs544.domain.User;

import java.util.List;

public interface IUserService {
    public List<User> getAll();
    public void addUser(User newUser);
    public User getUser(long id);
    public void update(User user);
    public void delete(long id);
}
