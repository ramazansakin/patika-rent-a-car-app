package com.patika.rsakin.patikarentacarservice.repository;

import com.patika.rsakin.patikarentacarservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
