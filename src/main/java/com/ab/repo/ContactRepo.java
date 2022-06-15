package com.ab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.model.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer>{

}
