
Create table if not exists Product(
	code varchar(10) not null,
	description varchar(255) not null,
	price double not null,
	primary key (code)
    );