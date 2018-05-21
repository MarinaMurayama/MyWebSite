CREATE TABLE   m_delivery (
delivery_id int(11) PRIMARY KEY,
delivery varchar(10) NOT NULL,
delivery_priceprice  int(11) NOT NULL
) 

INSERT INTO m_delivery VALUES (1, '通常配送',0);
INSERT INTO m_delivery VALUES (2, '日時指定配送',200);
INSERT INTO m_delivery VALUES (3, '特別配送',500);

SELECT * FROM  m_delivery;

