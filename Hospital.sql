create database hospital;
use hospital;

create table PatientRegistration(
PatientID varchar(30) not null,
DoctorID varchar(30) not null,
Patientname varchar(30) not null, 
FatherName varchar(30) not null,
Email varchar(30) not null,
ContactNo varchar(30) not null,
Age varchar(30) not null,
Remarks varchar(30) not null,
Gen varchar(30) not null,
BG varchar(30) not null,
Address varchar(30) not null,
Regdate date not null
);

insert into PatientRegistration values(
"1", "1", "suresh", "ramesh", "suresh@gamil.com", "4544545454", "54", "null", "M", "O+", "ganesh nagar", curdate());

select * from PatientRegistration;
truncate table PatientRegistration;
                    
create table Doctor(
DoctorID varchar(30) not null,
Doctorname varchar(30) not null, 
FatherName varchar(30) not null,
Email varchar(30) not null,
ContactNo varchar(30) not null,
Address varchar(30) not null,
Qualification varchar(30) not null,
Gen varchar(30) not null,
BG varchar(30) not null,
DateofJoin date not null
);
truncate table Doctor;

drop table Doctor;



create table Bill(
PatientID varchar(30) not null,
DoctorID varchar(30),
DischargeDate date
);

insert into Bill values('1', '1', curdate());

drop table Bill;
select * from Bill;
truncate table Bill;

drop table Bill;


create table account(
email varchar(30) not null,
pass varchar(30) not null,
name varchar(30) not null,
id varchar(30) not null
);

insert into account values(
"shivam", "hello","shivam", "1");

delete from account;

select email from account where email = "shivam";

select * from account;

create table dated(
pid varchar(30),
Regdate date, 
DateofDischarge date default null,
datedi integer(10)
);


insert into dated(datedi) values(datediff(Regdate, DateofDischarge)) where pid = '1';

desc dated;

insert into dated(pid, Regdate, DateofDischarge) values(
'1', curdate(), curdate());

select * from dated;

drop table dated;




use student;
select * from stu;
create table temp(
d date);

insert into temp values(curdate());
select * from temp;

select curdate();
drop table temp;
select curdate();


SELECT DATEDIFF("2017-06-25", curdate());
SELECT DATEDIFF("2017-06-25 09:34:21", "2017-06-15 15:25:35");

