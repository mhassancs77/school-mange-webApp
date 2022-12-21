
DROP TABLE IF EXISTS classes;  
CREATE TABLE classes (  
c_id INT   PRIMARY KEY ,  
c_name VARCHAR(50),
c_address VARCHAR(50),
c_capacity int,
c_space int
);

DROP TABLE IF EXISTS student;  
CREATE TABLE student (  
std_id INT   PRIMARY KEY AUTO_INCREMENT,  
std_name VARCHAR(50),
std_age int,
std_gender VARCHAR(1),
std_country VARCHAR(50),
std_phone VARCHAR(15),
c_id INT ,
foreign key (c_id) references classes(c_id)
); 

DROP TABLE IF EXISTS teacher;  
CREATE TABLE teacher (  
t_id INT   PRIMARY KEY AUTO_INCREMENT,  
t_name VARCHAR(50),
t_age INT ,
t_specialty VARCHAR(50),
c_id INT ,
foreign key (c_id) references classes(c_id)
);