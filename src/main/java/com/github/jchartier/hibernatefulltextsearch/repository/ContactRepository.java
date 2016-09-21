package com.github.jchartier.hibernatefulltextsearch.repository;

import com.github.jchartier.hibernatefulltextsearch.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "contact", path = "contact")
public interface ContactRepository extends CrudRepository<Contact, Integer>, CustomContactRepository {
}
