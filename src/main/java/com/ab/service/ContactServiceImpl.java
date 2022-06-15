package com.ab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.model.Contact;
import com.ab.repo.ContactRepo;

@Service
public class ContactServiceImpl implements IContactService {

	//inject the repo
	@Autowired
	private ContactRepo repo;
	@Override
	public String upsert(Contact contact) {
		int id = repo.save(contact).getCid();
		return "Register the contact with "+id;
	}

	@Override
	public List<Contact> findAllContacts() {
		return repo.findAll();
	}

	@Override
	public Contact findById(int id) {
		Optional<Contact> contact= repo.findById(id);
		if(contact.isPresent()) {
			return contact.get();
		}
		return null;
	}

	@Override
	public String deleteById(int id) {
		repo.deleteById(id);
		return "Record deleted Successfully"+id;
	}

}
