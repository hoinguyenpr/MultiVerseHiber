package com.ecommerce.admin.user;

import com.common.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <User, Integer> {
    public Optional<User> findByEmail(String email);
}
