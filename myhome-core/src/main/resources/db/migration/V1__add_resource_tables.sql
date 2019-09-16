create table country_regions
(
    crns_code       varchar(4)   not null primary key,
    crns_code_short varchar(4)   not null,
    crns_name       varchar(255) not null
);

create table countries
(
    cnrs_code       varchar(4)   not null primary key,
    cnrs_crns_code  varchar(4)   not null,

    cnrs_code_short varchar(4)   not null,
    cnrs_name       varchar(255) not null unique,
    cnrs_phone_code int          not null,

    constraint fk_cnrs_crns_id foreign key (cnrs_crns_code) references country_regions (crns_code) on delete restrict
);

insert into country_regions
values ('MNK', 'MNSK', 'Minsk');

insert into countries
values ('BY', 'MNK', 'BY', 'Belarus', 375)