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
package com.andrqxa.training.taskmanager.manager;

import static com.andrqxa.training.taskmanager.enums.Compares.*;
import java.io.Serializable;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * The class stores personal information about person who created task
 *
 * @author Andrey Pugachenko <andrqxa@gmail.com>
 */
@Component("person")
@Scope("prototype")
@Entity
@Table(name = "person")
public class Person implements Serializable, Comparable<Person> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronic")
    private String patronic;

    public Person() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        Optional<String> result = Optional.ofNullable(name);
        return result.orElse(StringUtils.EMPTY);
    }

    public void setName(String name) {
        Optional<String> result = Optional.ofNullable(name);
        this.name = result.orElse(StringUtils.EMPTY);
    }

    public String getSurname() {
        Optional<String> result = Optional.ofNullable(surname);
        return result.orElse(StringUtils.EMPTY);
    }

    public void setSurname(String surname) {
        Optional<String> result = Optional.ofNullable(surname);
        this.surname = result.orElse(StringUtils.EMPTY);
    }

    public String getPatronic() {
        Optional<String> result = Optional.ofNullable(patronic);
        return result.orElse(StringUtils.EMPTY);
    }

    public void setPatronic(String patronic) {
        Optional<String> result = Optional.ofNullable(patronic);
        this.patronic = result.orElse(StringUtils.EMPTY);
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(this.id)
                .append(this.name)
                .append(this.surname)
                .append(this.patronic);

        return builder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }

        Person other = (Person) obj;

        EqualsBuilder builder = new EqualsBuilder();
        builder.append(this.id, other.getId())
                .append(this.name, other.getName())
                .append(this.surname, other.getSurname())
                .append(this.patronic, other.getPatronic());

        return builder.isEquals();
    }

    @Override
    public int compareTo(Person person) {
        if (surname.equalsIgnoreCase(person.getSurname())) {
            if (name.equalsIgnoreCase(person.getName())) {
                if (patronic.equalsIgnoreCase(person.getPatronic())) {
                    return EQUAL.getCompare();
                } else {
                    return patronic.compareTo(person.getPatronic());
                }

            } else {
                return name.compareTo(person.getName());
            }

        } else {
            return surname.compareTo(person.getSurname());
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("----------------------------------------------------------------------------\n")
                .append(String.format("id:%s\nsurname:%s\nname:%s\npatronic:%s\n", id, surname, name, patronic))
                .append("----------------------------------------------------------------------------\n");

        return builder.toString();
    }

}
