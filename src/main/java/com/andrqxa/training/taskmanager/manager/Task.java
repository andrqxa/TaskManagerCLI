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
 * The class which stores task
 *
 * @author Andrey Pugachenko <andrqxa@gmail.com>
 */
@Component("task")
@Scope("prototype")
@Entity
@Table(name = "task")
public class Task implements Serializable, Comparable<Task> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Task() {
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

    public String getDescription() {
        Optional<String> result = Optional.ofNullable(description);
        return result.orElse(StringUtils.EMPTY);
    }

    public void setDescription(String description) {
        Optional<String> result = Optional.ofNullable(description);
        this.description = result.orElse(StringUtils.EMPTY);
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(this.id)
                .append(this.name)
                .append(this.description);

        return builder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Task)) {
            return false;
        }

        Task other = (Task) obj;

        EqualsBuilder builder = new EqualsBuilder();
        builder.append(this.id, other.getId())
                .append(this.name, other.getName())
                .append(this.description, other.getDescription());

        return builder.isEquals();
    }

    @Override
    public int compareTo(Task task) {
        return name.compareTo(task.getName());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("----------------------------------------------------------------------------\n")
                .append(String.format("id:%s\nname:%s\ndescription:%s\n", id, name, description))
                .append("----------------------------------------------------------------------------\n");

        return builder.toString();
    }

}
