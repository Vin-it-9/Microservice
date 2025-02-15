package org.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {



}
