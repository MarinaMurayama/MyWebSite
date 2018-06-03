CREATE TABLE m_item(
 item_id SERIAL,
 item_num varchar(30) UNIQUE NOT NULL,
 taste_num varchar(20),
 item_img varchar(255) NOT NULL,
 item_name varchar(40) NOT NULL,
 item_detail varchar(255) NOT NULL,
 category_id varchar(10) NOT NULL,
 stocks int(11) NOT NULL,
 price int(11) NOT NULL,
 create_date DATETIME NOT NULL,
 update_date DATETIME NOT NULL
 ) 




