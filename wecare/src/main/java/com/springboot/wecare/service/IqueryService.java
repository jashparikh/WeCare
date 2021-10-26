package com.springboot.wecare.service;

import java.util.List;

import com.springboot.wecare.model.Query;

public interface IqueryService {

	
	public List<Query> getAll();

    public String addQuery(Query query) ;
}
