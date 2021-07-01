	create table prime_topup (
	user_id varchar (30)not null ,
	plan int not null,
	recharge_on DATE not null ,
	validity int not null,
	screen int not null,
	expires_on DATE not null,
	check (plan in (399,699)),
	check (screen in (0,1,2))
	);