package com.company.employee.user.repository;

import com.company.employee.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);
}
