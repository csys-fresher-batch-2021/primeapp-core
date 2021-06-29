create table users (
	user_id varchar (30)not null primary key,
	name varchar(30) not null,
	phone_number bigint not null unique,
	password varchar (30) not null,
	joined_on timestamp not null
	);