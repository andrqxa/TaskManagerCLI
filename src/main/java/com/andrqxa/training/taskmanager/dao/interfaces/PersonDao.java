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
package com.andrqxa.training.taskmanager.dao.interfaces;

import com.andrqxa.training.taskmanager.manager.Person;
import java.util.List;

/**
 *
 * @author Andrey Pugachenko <andrqxa@gmail.com>
 */
public interface PersonDao {

    Person get(long id);

    List<Person> getBySurname(String surname);

    List<Person> getBySurnameAndName(String surname, String name);

    List<Person> getBySurnameAndNameAndPatronic(String surname, String name, String patronic);

    void add(Person person);

    void delete(long id);

    void clearPersonInfo(Person person);
}
