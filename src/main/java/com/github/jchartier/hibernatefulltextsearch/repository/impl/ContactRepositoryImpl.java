package com.github.jchartier.hibernatefulltextsearch.repository.impl;

import com.github.jchartier.hibernatefulltextsearch.model.Contact;
import com.github.jchartier.hibernatefulltextsearch.repository.CustomContactRepository;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class ContactRepositoryImpl implements CustomContactRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> search(String keywords) {

        // Must be retrieved inside a transaction to take part of
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        // Prepare a search query builder
        QueryBuilder queryBuilder =
            fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Contact.class).get();

        Query query = queryBuilder.keyword().onFields("firstName", "lastName", "email", "address").matching(keywords)
            .createQuery();

        return fullTextEntityManager.createFullTextQuery(query, Contact.class).getResultList();
    }
}
