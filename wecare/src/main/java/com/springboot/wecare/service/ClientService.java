package com.springboot.wecare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.wecare.model.Client;
import com.springboot.wecare.repository.ClientRepository;

@Service
public class ClientService implements IClientService {

	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> getAll() {
		return clientRepository.findAll();
	}
	
	public String register(Client client) {
		try {
			clientRepository.save(client);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Success!";
	}
	
	public String viewProfileInfo(long id) {
		try {
			return clientRepository.findById(id).get().toString();
		} catch (Exception e) {
			return e.getMessage();
		}
		}
	
	public String updateProfileInfo(Client client, Object[] fieldsToUpd) {
		Optional<Client> clien = clientRepository.findById(client.getClientId());
		Client cli = clien.get();
		if (fieldsToUpd[0]!=null) {
				cli.setClientAddressId((int) fieldsToUpd[0]);
			}
		
		if (fieldsToUpd[1]!=null) {
			cli.setClientDob((String) fieldsToUpd[1]);
		}
		
		if (fieldsToUpd[2]!=null) {
			cli.setClientEmail((String) fieldsToUpd[2]);
		}
		
		if (fieldsToUpd[3]!=null) {
			cli.setClientSName((String) fieldsToUpd[3]);
		}
		
		if (fieldsToUpd[4]!=null) {
			cli.setClientFName((String) fieldsToUpd[4]);
		}
		
		if (fieldsToUpd[5]!=null) {
			cli.setClientWeight((float) fieldsToUpd[5]);
		}
		try {
			clientRepository.save(cli);
		} catch (Exception e) {
			return e.getMessage();
		}
		return ("Successfully saved");
	}
	
	public String removeClient(Client client) {
		//might need to send client to an archive repository + set state to deceased? 
		//or add the reason why client is being archived
		try {
			clientRepository.deleteById(client.getClientId());
		} catch (Exception e) {
			return e.getMessage();
		}

		return ("Successfully removed");	
	}

}
