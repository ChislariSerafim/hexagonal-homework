create table news
(
    id      	        int8 generated by default as identity,
    title 	         	varchar(200)    	not null,
    content         	text    		not null,
    date				date			not null,
    priority			int2			default(10),
    primary key (id)
);