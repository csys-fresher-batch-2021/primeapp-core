create table shows (
	id  serial primary key,
	genre varchar (20) not null,
	name varchar (50) not null,
	year int not null,
	check (year>1950),
	language varchar (50) not null,
	category varchar(50) not null,
	membership varchar(20) not null,
	check (membership in ('prime','non prime')),
	grade varchar(2) not null,
	status varchar(20) not null,
	likes int not null,
	check (grade in ('U','V','A')),
	check (status in ('active','inactive'))
);
