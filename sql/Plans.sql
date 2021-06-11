create table Prime_plans(
	id serial primary key,
	plans int not null,
    live_shows varchar(50) not null,
	multiplex_Indian varchar(50) not null ,
	dubbed_original varchar(50)not null,
	advertisement varchar (20) not null,
	screens int not null,
	video_quality varchar(2) not null,
	audio_quality varchar (20) not null,
	check (dubbed_original in ('dubbed','dubbed+original')),
	check(advertisment in ('contains ad','ads free')),
	check (screens in (1,2)),
	check (video_quality in('HD','4K'))
	
);
INSERT INTO prime_plans (plans,live_shows,multiplex_Indian,dubbed_original,advertisement,screens,video_quality,audio_quality)
values (699,'live shows','multiplex+indian','dubbed+original','ads free',2,'4K','dolby 5.1');