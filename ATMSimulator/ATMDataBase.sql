show databases;
use ATMSimulator;


create table signup(formNo varchar(20), Name varchar(20), Father_name varchar(20),  DOB varchar(20), gender varchar(20), email varchar(20), MArtial_Status varchar(20), Address varchar(60), City varchar(20), State varchar(20), Zipcode varchar(20));
select * from signup;


create table signuptwo(formNo varchar(20), Ethnicity varchar(20), Income varchar(20),  Education varchar(20), Occupation varchar(20), Pan_Number varchar(20), SSN varchar(20), Senior_Citizen varchar(20), Existing_Account varchar(20));
select * from signuptwo;


create table signupthree(formNo varchar(20), Account_Type varchar(40), Card_Number varchar(18),  Pin varchar(4), Facility varchar(20));
select * from signupthree;


create table login(formNo varchar(20), Card_Number varchar(25), Pin varchar(10));
select * from login;



create table bank(Pin varchar(20), Date varchar(50), Account_Type varchar(25), Amount varchar(25));
select * from bank;




show tables;




