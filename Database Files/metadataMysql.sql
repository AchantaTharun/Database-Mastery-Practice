
use testdb;
drop table metadata;

create table metadata(tname varchar(20), cnames varchar(200), ctypes varchar(200), csizes varchar(200));
select * from metadata;