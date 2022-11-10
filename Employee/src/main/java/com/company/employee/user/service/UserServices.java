package com.company.employee.user.service;

import com.company.employee.user.UserNotFoundException;
import com.company.employee.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserServices {
    public void save(User user);

    public List<User> listAll();

    public User get(Integer id) throws UserNotFoundException;

    public void delete(Integer id) throws UserNotFoundException;

}
