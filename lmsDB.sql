create database lmsdb;

use lmsdb;

create table teacher(
	email char(50) primary key not null,
    password char(50) not null,
    name char(50) not null,
    gender char(50) not null
);

create table users(
	name char(50) not null,
    email char(50) primary key not null,
    password char(50),
    teacher boolean,
    admin boolean,
    gender char(50) not null
);

create table LectureTable(
WeekNO int primary key not null,
courseTittle1 nvarchar(50),
courseTittle2 nvarchar(50),
courseTittle3 nvarchar(50),
courseTittle4 nvarchar(50),
Content nvarchar(50)
);

create table assign(
week_no int,
course nvarchar(50),
assign_path varchar(50),
assign_tittle varchar(50),
id int primary key auto_increment
);

create table lecturetable(
week_no int,
course varchar(50),
lec_path varchar(50),
lec_tittle varchar(50),
id int primary key auto_increment
);

select * from users;
select * from student;
select * from teacher;


create table student(
	id int primary key auto_increment,
    name char(50) not null,
    email char(50) unique not null,
    password char(50) not null,
    semester int not null,
    gender char(50) not null,
    pl int,
    ds int,
    logic int,
    maths int,
    course1 nvarchar(50) default'-',
course2 nvarchar(50) default'-',
course3 nvarchar(50) default'-',
course4 nvarchar(50) default'-'
);
alter table student auto_increment = 202100;

CREATE TABLE question (
  id  int NOT NULL ,
  Qname varchar(500) NOT NULL ,
  opt1 varchar(500) DEFAULT '________'  ,
  opt2 varchar(500) DEFAULT '________' ,
  opt3 varchar(500) DEFAULT '________' ,
  opt4 varchar(500) DEFAULT '________' ,
  answer varchar(500) NOT NULL ,
  CourseName varchar(100) NOT NULL ,
  PRIMARY KEY (id)
); 

drop table question ;
drop table quiz ;

create table quiz (
    id varchar(10) NOT NULL,
    QID1 int NOT NULL,
    QID2 int NOT NULL,
    QID3 int NOT NULL ,
    QID4 int NOT NULL,
    QID5 int NOT NULL,
    CourseName varchar(100) NOT NULL,
    PRIMARY KEY (id) ,
    CONSTRAINT FK_QID1 FOREIGN KEY (QID1)REFERENCES question(id) ,
    CONSTRAINT FK_QID2 FOREIGN KEY (QID2)REFERENCES question(id) ,
    CONSTRAINT FK_QID3 FOREIGN KEY (QID3)REFERENCES question(id) ,
    CONSTRAINT FK_QID4 FOREIGN KEY (QID4)REFERENCES question(id) ,
    CONSTRAINT FK_QID5 FOREIGN KEY (QID5)REFERENCES question(id) 
);

drop database lmsdb;
