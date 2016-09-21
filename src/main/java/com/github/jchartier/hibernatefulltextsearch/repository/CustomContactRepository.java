package com.github.jchartier.hibernatefulltextsearch.repository;

import com.github.jchartier.hibernatefulltextsearch.model.Contact;

import java.util.List;

public interface CustomContactRepository {

    List<Contact> search(String keywords);
}
