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

import com.andrqxa.training.taskmanager.enums.Status;
import com.andrqxa.training.taskmanager.manager.Person;
import com.andrqxa.training.taskmanager.manager.Task;
import com.andrqxa.training.taskmanager.manager.TaskQueue;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Andrey Pugachenko <andrqxa@gmail.com>
 */
public interface TaskQueueDao {

    TaskQueue get(long id);

    TaskQueue getByStartTime(LocalDateTime startTime); //there is only one event for start time

    List<TaskQueue> getByFinishTime(LocalDateTime finishTime); //there are several events for finish time

    List<TaskQueue> getByStatus(Status status);

    TaskQueue getByTask(Task task); //there is only one event for task

    List<TaskQueue> getByPerson(Person person);

    void add(TaskQueue taskQueue);

    void delete(long id);

    void updateStatus(Status status);

    void setDone();
}
