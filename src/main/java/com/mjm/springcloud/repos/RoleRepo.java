package com.mjm.springcloud.repos;

import com.mjm.springcloud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface RoleRepo extends JpaRepository<Role, Long> {
}
