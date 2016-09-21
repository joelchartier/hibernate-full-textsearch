package com.github.jchartier.hibernatefulltextsearch.controller;

import com.github.jchartier.hibernatefulltextsearch.model.Contact;
import com.github.jchartier.hibernatefulltextsearch.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> search(@RequestParam("keyword") List<String> keywords) {

        return contactRepository.search(keywords.stream().collect(Collectors.joining(" ")));
    }
}
