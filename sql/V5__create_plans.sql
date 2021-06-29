create table Prime_plans(
	plan_id serial primary key,
	plans int not null,
	validity int not null,
    live_shows varchar(3) not null,
	multiplex_indian varchar(10) not null ,
	dubbed_original varchar(20)not null,
	advertisement varchar (3) not null,
	screens int not null,
	video_quality varchar(5) not null,
	audio_quality varchar (10) not null,
	check (dubbed_original in ('dubbed','dubbed+original')),
	check(advertisement in ('YES','NO')),
	check (screens in (1,2)),
	check (video_quality in('HD','4K','1080p','720p','480p')),
	check (live_shows in('YES','NO'))
);