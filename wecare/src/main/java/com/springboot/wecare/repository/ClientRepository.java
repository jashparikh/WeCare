package com.springboot.wecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.wecare.model.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, Long> { //<> define class and data type of primary key

}
