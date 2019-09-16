create table user_permissions
(
    upns_id   bigserial    not null primary key,
    upns_name varchar(255) not null unique,
    upns_type int          not null
);

create table user_roles
(
    urls_id            bigserial    not null primary key,
    urls_upns_id       bigint       not null,
    urls_name          varchar(255) not null unique,

    urls_creation_date timestamp default current_timestamp,
    urls_update_date   timestamp default current_timestamp,

    constraint fk_urls_upns_id foreign key (urls_upns_id) references user_permissions (upns_id) on delete restrict
);

create table users
(
    usrs_id            bigserial    not null primary key,

    usrs_email         varchar(255) not null unique,
    usrs_cell_phone    bigint       not null,
    usrs_password      varchar(255) not null,

    usrs_cnrs_code     varchar(4),
    usrs_crns_code     varchar(4),

    usrs_first_name    varchar(255),
    usrs_last_name     varchar(255),
    usrs_middle_name   varchar(255),
    usrs_timezone      int,
    usrs_language      int,

    usrs_oath_token    varchar(255),
    usrs_vk_token      varchar(255),
    usrs_google_token  varchar(255),

    usrs_creation_date timestamp    not null default current_timestamp,
    usrs_update_date   timestamp    not null default current_timestamp,

    usrs_version       int          not null,
    usrs_deleted       boolean      not null default false,

    constraint fk_udfn_cnrs_code foreign key (usrs_cnrs_code) references countries (cnrs_code) on delete restrict,
    constraint fk_udfn_crns_code foreign key (usrs_crns_code) references country_regions (crns_code) on delete restrict
);

create table user_roles_assignment
(
    urat_usrs_id bigint not null,
    urat_urls_id bigint not null,

    constraint fk_urat_usrs_id foreign key (urat_usrs_id) references users (usrs_id) on delete restrict,
    constraint fk_urat_urls_id foreign key (urat_urls_id) references user_roles (urls_id) on delete restrict
);

insert into user_permissions
values (1, 'PERMISSION_ALL', 0),
       (2, 'PERMISSION_AUTHENTICATE', 1);

insert into user_roles
values (1, 1, 'ROLE_SUPER_USER', current_timestamp, current_timestamp),
       (2, 2, 'ROLE_AUTHENTICATE', current_timestamp, current_timestamp);

insert into users (usrs_id, usrs_email, usrs_cell_phone, usrs_password, usrs_version)
values (1, 'super-user@dev', 0, 'super-user@dev', 1);

insert into user_roles_assignment
values (1, 1);
