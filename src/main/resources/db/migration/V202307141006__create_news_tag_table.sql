create table news_tag
(
    news_id 	        int8    	not null references news(id),
    tag 	         	varchar(50) not null references tag(name)
)
