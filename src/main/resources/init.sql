drop table if exists message;
drop table if exists favorite;
drop table if exists price_history;
drop table if exists product;
drop table if exists platform;
drop table if exists vendor;
drop table if exists user;
create table if not exists user
(
    id       int(11) auto_increment,
    name     varchar(20),
    password varchar(20),
    age      int(11),
    gender   varchar(2),
    phone    varchar(20),
    email    varchar(20),
    reg_time datetime,
    primary key (id)
    ) DEFAULT CHARACTER SET utf8;
create table if not exists vendor
(
    id       int(11) auto_increment,
    name     varchar(20),
    password varchar(20),
    address  varchar(100),
    email    varchar(30),
    reg_time datetime,
    primary key (id)
    ) DEFAULT CHARACTER SET utf8;
CREATE TABLE if not exists platform
(
    id          INT(11),
    name        VARCHAR(50),
    description VARCHAR(255),
    PRIMARY KEY (id)
    ) DEFAULT CHARACTER SET utf8;
create table if not exists product
(
    id              int(11) auto_increment,
    name            varchar(20),
    category        varchar(20),
    origin          varchar(50),
    production_date date,
    price           decimal(10, 2),
    description     varchar(100),
    vendor_id       int(11),
    platform_id     int(11),
    primary key (id),
    foreign key (vendor_id) references vendor (id),
    foreign key (platform_id) references platform (id)
    ) DEFAULT CHARACTER SET utf8;
CREATE TABLE if not exists price_history
(
    id         INT PRIMARY KEY,
    product_id INT,
    vendor_id  INT,
    price      DECIMAL(10, 2),
    date_time  DATETIME,
    FOREIGN KEY (product_id) REFERENCES product (id),
    FOREIGN KEY (vendor_id) REFERENCES vendor (id)
    ) DEFAULT CHARACTER SET utf8;
CREATE TABLE if not exists message
(
    id        INT PRIMARY KEY,
    user_id   INT,
    content   VARCHAR(255),
    date_time DATETIME,
    FOREIGN KEY (user_id) REFERENCES user (id)
    ) DEFAULT CHARACTER SET utf8;
CREATE TABLE if not exists favorite
(
    user_id     INT,
    product_id  INT,
    price_limit DECIMAL(10, 2),
    PRIMARY KEY (user_id, product_id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (product_id) REFERENCES product (id)
    ) DEFAULT CHARACTER SET utf8;