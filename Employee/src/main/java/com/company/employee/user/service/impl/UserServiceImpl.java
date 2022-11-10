package com.company.employee.user.service.impl;

import com.company.employee.user.UserNotFoundException;
import com.company.employee.user.domain.User;
import com.company.employee.user.repository.UserRepository;
import com.company.employee.user.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {
    @Autowired
    private UserRepository repo;

    @Override
    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("could not find any users with ID " + id);
    }

    @Override
    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("could not find any users with ID " + id);
        }
        repo.deleteById(id);
    }
}
