create table shows (
	id  serial primary key,
	genre varchar (20) not null,
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
	check (status in ('active','inactive'))
);

INSERT INTO shows (genre,name,year,language,category,membership,grade,status)
values ('drama','bigil',2019,'tamil','movie','non prime','U','active');
INSERT INTO shows (genre,name,year,language,category,membership,grade,status)
values ('drama','sivaji',2012,'tamil','movie','prime','U','active');
INSERT INTO shows (genre,name,year,language,category,membership,grade,status)
values ('kids','dora',2020,'english','movie','prime','V','active');
INSERT INTO shows (genre,name,year,language,category,membership,grade,status)
values ('action','explosion',2018,'english','movie','prime','U','active');
INSERT INTO shows (genre,name,year,language,category,membership,grade,status)
values ('action','fast and furious',2009,'english','movie','prime','U','active');


select *from shows
select id,genre,name,year,language,category,membership,grade,status from shows