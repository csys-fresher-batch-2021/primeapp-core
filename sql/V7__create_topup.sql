	create table prime_topup (
	user_id varchar (30)not null ,
	plan int not null,
	recharge_on DATE not null ,
	validity int not null,
	expires_on DATE not null,
	check (plan in (399,699)),
	
	);