CREATE TABLE  t_buy(
 buy_id SERIAL NOT NULL AUTO_INCREMENT,
 user_id int(11) NOT NULL,
 total_price int(11) NOT NULL,
 delivery_id int(11) NOT NULL,
 create_date datetime NOT NULL
) 

SELECT * FROM t_buy;
