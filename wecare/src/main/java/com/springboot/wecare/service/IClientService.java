package com.springboot.wecare.service;

import java.util.List;

import com.springboot.wecare.model.Client;


public interface IClientService {

	public List<Client> getAll();
	public String register(Client client) ;
	public String viewProfileInfo(long cliId);
	public String updateProfileInfo(long cliId, Object[] fieldsToUpd) ;
	public String removeClient(long cliId);

}
