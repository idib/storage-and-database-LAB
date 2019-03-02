

**generate entities**

    mvn org.jooq:jooq-codegen-maven:3.11.9:generate



[**about JOOQ**](https://www.jooq.org/doc/3.11/manual/getting-started/tutorials/jooq-in-7-steps/)


**test SQL (postgers)**

    create table car
    (
      id        bigserial not null
        constraint car_pkey
        primary key,
      name      varchar(200),
      length    integer,
      width     integer,
      height    integer,
      wheelbase integer,
      volume    integer   not null,
      power     integer   not null
    );
    
    alter table car
      owner to postgres;
    


**UMl project**

current version 1.0

[source](SADB%20UML%20v1.uxf) open in [site](http://www.umlet.com/umletino/umletino.html)


![](img/UML%20v1.jpg)



**SQL**

current "[result.sql](sql/RESULT.sql)" target to postgres.

converter [link](http://www.sqlines.com/online)