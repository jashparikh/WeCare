package com.springboot.wecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.wecare.model.Query;


@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {

}
