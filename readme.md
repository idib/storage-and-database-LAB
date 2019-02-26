

generate entities

    mvn org.jooq:jooq-codegen-maven:3.11.9:generate



[about JOOQ](https://www.jooq.org/doc/3.11/manual/getting-started/tutorials/jooq-in-7-steps/)


test SQL (postgers)

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
    
