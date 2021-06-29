create table download(
	download_id serial primary key,
	user_id varchar (40) not null,
	movie_id int not null,
	genre varchar(20)not null,
	name varchar (50) not null,
	year int not null,
	check (year>1950),
	language varchar (50) not null,
	category varchar(50) not null,
	membership varchar(20) not null,
	status varchar(20) not null,
	check (membership in ('prime','non prime')),
	grade varchar(2) not null,
	check (grade in ('U','V','A')),
	check (status in ('active','inactive')),
    download_on DATE NOT NULL,
    expire_on DATE NOT NULL
);