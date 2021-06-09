
create table users (
	user_id varchar (30)not null primary key,
	name varchar(30) not null,
	phone_number bigint not null ,
	password varchar (30) not null,
	joined_on timestamp not null
	);
	
insert into users (user_id,name,phone_number,password,joined_on) 
values('venkat9790430272','venkat',9790430272,'Venkat@19',now());

select * from users
	