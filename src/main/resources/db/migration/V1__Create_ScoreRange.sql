
use gradeapp_grade_db;

create table score_range
(id int primary key auto_increment,
max int not null ,
min int not null ,
grade char(1) not null );
`gradeapp_grade_db`.`get_grade`(<{avg float}>)
insert into score_range(max,min,grade) values('100','89','D');
insert into score_range(max,min,grade) values('88','69','A');
insert into score_range(max,min,grade) values('68','49','B');
insert into score_range(max,min,grade) values('48','0','F');


select get_grade(60);

select * from  score_range;



