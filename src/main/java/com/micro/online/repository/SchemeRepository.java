package com.micro.online.repository;

import com.micro.online.model.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchemeRepository extends JpaRepository<Scheme, Integer> {
    // Custom query methods (if any) can be defined here
}
