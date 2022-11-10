package com.company.employee.user.service.impl;

import com.company.employee.user.UserNotFoundException;
import com.company.employee.user.domain.Registration;
import com.company.employee.user.repository.RegistrationRepository;
import com.company.employee.user.service.RegistrationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationServices {
    @Autowired
    RegistrationRepository registrationRepository;

    @Override
    public void save(Registration registration){
        registrationRepository.save(registration);
    }

    @Override
    public void delete(Integer id) throws UserNotFoundException {
        Long count = registrationRepository.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("could not find any users with ID " + id);
        }
        registrationRepository.deleteById(id);
    }

    @Override
    public Registration getRegistration(String email, String password) throws UserNotFoundException {
        Optional<Registration> getByEmail = registrationRepository.findByEmail(email);
        if(!getByEmail.isPresent()){
            throw new UserNotFoundException("could not find any users with email " + email);
        }

        Registration registration = getByEmail.get();

        if(!registration.getPassword().equals(password)){
            throw new UserNotFoundException("Username and Password not matched");
        }

        return registration;
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return (List<Registration>) registrationRepository.findAll();
    }

    @Override
    public Registration get(Integer id) throws UserNotFoundException {
        Optional<Registration> result = registrationRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any Registered users with ID " + id);
    }
}
