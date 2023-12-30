drop table if exists room;
create table if not exists room
(
    kdno      int(4),
    kcno      int(2),
    ccno      int(2),
    kdname    varchar(20),
    exptime   timestamp,
    papername varchar(10),
    primary key (kdno, kcno, ccno)
    ) DEFAULT CHARACTER SET utf8;
drop table if exists student;
create table if not exists student
(
    registno varchar(7),
    name     varchar(20),
    kdno     int(4),
    kcno     int(2),
    ccno     int(2),
    seat     int(1),
    primary key (registno)
    ) DEFAULT CHARACTER SET utf8;