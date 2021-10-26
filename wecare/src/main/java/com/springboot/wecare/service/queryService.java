package com.springboot.wecare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.wecare.model.Query;
import com.springboot.wecare.repository.QueryRepository;

@Service
public class queryService implements IqueryService{
	@Autowired
	QueryRepository queryRepository;

	public List<Query> getAll() {
		return queryRepository.findAll();

	}

	public String addQuery(Query query) {

		try {
			queryRepository.save(query);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Query Saved";
	}
}
