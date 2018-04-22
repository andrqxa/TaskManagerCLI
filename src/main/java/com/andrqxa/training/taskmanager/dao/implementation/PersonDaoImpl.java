/*
 * Copyright 2018 Andrey Pugachenko <andrqxa@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.andrqxa.training.taskmanager.dao.implementation;

import com.andrqxa.training.taskmanager.dao.interfaces.PersonDao;
import com.andrqxa.training.taskmanager.extensions.PersonNotExists;
import com.andrqxa.training.taskmanager.manager.Person;
import com.andrqxa.training.taskmanager.utils.HibernateUtil;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Andrey Pugachenko <andrqxa@gmail.com>
 */
public class PersonDaoImpl implements PersonDao {

    private final SessionFactory sessionFactory;

    public PersonDaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Person get(long id) throws PersonNotExists {
        Optional<Person> result;
        try (Session session = sessionFactory.openSession()) {
            result = Optional.ofNullable((Person) session.load(Person.class, id));
        }
        return result.orElseThrow(() -> new PersonNotExists(String.format("There is not person with %s id", id)));
    }

    @Override
    public List<Person> getBySurname(String surname) throws PersonNotExists {
        List<Person> result;
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
            criteriaQuery.from(Person.class);
            result = session.createQuery(criteriaQuery).getResultList();
        }
        if (result.isEmpty()) {
            throw new PersonNotExists(String.format("There is not person with surname: %s", surname));
        }
        result = result.stream()
                .filter(r -> r.getSurname().equalsIgnoreCase(surname))
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<Person> getBySurnameAndName(String surname, String name) throws PersonNotExists {
        List<Person> result;
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
            criteriaQuery.from(Person.class);
            result = session.createQuery(criteriaQuery).getResultList();
        }
        if (result.isEmpty()) {
            throw new PersonNotExists(String.format("There is not person with surname: %s", surname));
        }
        result = result.stream()
                .filter(r -> r.getSurname().equalsIgnoreCase(surname))
                .filter(r -> r.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<Person> getBySurnameAndNameAndPatronic(String surname, String name, String patronic) throws PersonNotExists {
        List<Person> result;
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
            criteriaQuery.from(Person.class);
            result = session.createQuery(criteriaQuery).getResultList();
        }
        if (result.isEmpty()) {
            throw new PersonNotExists(String.format("There is not person with surname: %s", surname));
        }
        result = result.stream()
                .filter(r -> r.getSurname().equalsIgnoreCase(surname))
                .filter(r -> r.getName().equalsIgnoreCase(name))
                .filter(r -> r.getName().equalsIgnoreCase(patronic))
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public void add(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) throws PersonNotExists {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearPersonInfo(Person person) throws PersonNotExists {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
