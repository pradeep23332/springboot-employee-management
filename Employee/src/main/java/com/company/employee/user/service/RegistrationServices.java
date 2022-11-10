package com.company.employee.user.service;

import com.company.employee.user.UserNotFoundException;
import com.company.employee.user.domain.Registration;
import com.company.employee.user.domain.User;

import java.util.List;


public interface RegistrationServices {

    void save(Registration registration);
    void delete(Integer id) throws UserNotFoundException;
    Registration getRegistration(String email, String password) throws UserNotFoundException;
    List<Registration> getAllRegistrations();
    Registration get(Integer id) throws UserNotFoundException;
}
