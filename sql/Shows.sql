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

INSERT INTO shows (genre,name,year,language,category,membership,grade,status,likes)
values ('drama','bigil',2019,'tamil','movie','non prime','U','active',0);
INSERT INTO shows (genre,name,year,language,category,membership,grade,status,likes)
values ('drama','sivaji',2012,'tamil','movie','prime','U','active',0);
INSERT INTO shows (genre,name,year,language,category,membership,grade,status,likes)
values ('kids','dora',2020,'english','movie','prime','V','active',0);
INSERT INTO shows (genre,name,year,language,category,membership,grade,status,likes)
values ('action','explosion',2018,'english','movie','prime','U','active',0);
INSERT INTO shows (genre,name,year,language,category,membership,grade,status,likes)
values ('action','fast and furious',2009,'english','movie','prime','U','active',0);


select *from shows
select id,genre,name,year,language,category,membership,grade,status from shows