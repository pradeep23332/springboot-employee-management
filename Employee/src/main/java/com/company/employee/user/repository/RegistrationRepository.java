package com.company.employee.user.repository;

import com.company.employee.user.domain.Registration;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
    Optional<Registration> findByEmail(String email);
    Long countById(Integer id);
}
