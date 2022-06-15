package com.ab.service;

import java.util.List;

import com.ab.model.Contact;

public interface IContactService {

	public String upsert(Contact contact);
	public List<Contact> findAllContacts();
	public Contact findById(int id);
	public String deleteById(int id);
	
	
}
