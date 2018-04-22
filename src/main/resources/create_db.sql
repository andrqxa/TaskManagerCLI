-- drop table task;
-- drop table status;
-- drop table person;
-- drop table taskqueue;

create table status(
    id bigint not null,
    name varchar(256),
    primary key(id)
);

create table person(
    id bigint not null,
    surname varchar(256) not null,
    name varchar(256),
    patronic varchar(256),
    primary key(id)
);
CREATE INDEX peson_name_idx ON person(surname);

create table task(
    id bigint not null,
    name varchar(256) not null,
    description varchar(256),
    primary key(id)
);
CREATE INDEX task_name_idx ON task(name);

create table taskqueue(
    id bigint not null,
    starttime timestamp not null,
    finishtime timestamp,
    status bigint not null,
    person bigint,
    task bigint,
    primary key(id),
    CONSTRAINT person_FK FOREIGN KEY (person) REFERENCES person(id),
    CONSTRAINT task_FK FOREIGN KEY (task) REFERENCES task(id),
    CONSTRAINT status_FK FOREIGN KEY (status) REFERENCES status(id)
);

