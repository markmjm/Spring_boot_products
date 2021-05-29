package com.mjm.springcloud.repos;

import com.mjm.springcloud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String Email);

}
