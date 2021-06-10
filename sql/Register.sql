
create table register (
	user_id varchar (30)not null primary key,
	name varchar(30) not null,
	phone_number bigint not null ,
	password varchar (30) not null
	);
	
insert into register (user_id,name,phone_number,password) 
values('venkat9790430272','venkat',9790430272,'Venkat@19');

select * from register
	