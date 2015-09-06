# Users schema

# --- !Ups

CREATE TABLE Menu (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    day bigint(20),
    price bigint(20),
--     password varchar(255) NOT NULL,
--     fullname varchar(255) NOT NULL,
--     isAdmin boolean NOT NULL,
    PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE User;