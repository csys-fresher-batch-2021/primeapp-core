
create table admin (
admin_name varchar(20) primary key not null,
admin_password varchar(20)not null
);

insert into admin (admin_name,admin_password)
values('venkatesh','Venkat@19')

select * from admin