package com.patika.rsakin.patikarentacarservice.repository;

import com.patika.rsakin.patikarentacarservice.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
