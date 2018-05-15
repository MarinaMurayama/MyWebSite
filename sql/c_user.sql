
CREATE TABLE  c_user(
  user_id SERIAL,
  login_id varchar(20) UNIQUE NOT NULL,
  name varchar(30) NOT NULL,
  birth_date date NOT NULL,
  address varchar(100) NOT NULL,
  password varchar(20) NOT NULL,
  create_date datetime NOT NULL,
  update_date datetime NOT NULL
);

