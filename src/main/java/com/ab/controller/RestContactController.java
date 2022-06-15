package com.ab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.model.Contact;
import com.ab.service.IContactService;

@RestController
@RequestMapping("/contact")
public class RestContactController {
	
	//inject the service
	@Autowired
	private IContactService service;
	@PostMapping("/save")
	ResponseEntity<String> registerOrUpdateContact(@RequestBody Contact contact){
		String status = service.upsert(contact);
		return new ResponseEntity<>(status,HttpStatus.CREATED); 
	}
	
	@GetMapping("/findall")
	ResponseEntity<List<Contact>> findAllContact(){
		List<Contact> list= service.findAllContacts();
		return new ResponseEntity<>(list,HttpStatus.OK); 
	}
	
	@GetMapping("/findById/{id}")
	ResponseEntity<Contact> getById(@PathVariable int id){
		Contact contact = service.findById(id);
		return new ResponseEntity<>(contact,HttpStatus.OK);
	}
	
	@DeleteMapping("/del/{id}")
	ResponseEntity<String> delById(@PathVariable int id){
		String msg = service.deleteById(id);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	

}
