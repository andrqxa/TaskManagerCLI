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
package com.andrqxa.training.taskmanager;

import com.andrqxa.training.taskmanager.manager.Person;
import com.andrqxa.training.taskmanager.manager.Task;
import com.andrqxa.training.taskmanager.manager.TaskQueueElement;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Andrey Pugachenko <andrqxa@gmail.com>
 */
public class App {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml")) {
            Person person = (Person) ctx.getBean("person");
            person.setName("Andrey");
            person.setPatronic("S.");
            person.setSurname("Pugachenko");

            Task task = (Task) ctx.getBean("task");
            task.setName("Finished housework");
            task.setDescription("I have to finish my housework till 7p.m.");

            TaskQueueElement taskQueueElement = (TaskQueueElement) ctx.getBean("taskQueueElement");
            taskQueueElement.setPerson(person);
            taskQueueElement.setTask(task);

            System.out.println(taskQueueElement.toString());
        }
    }

}
