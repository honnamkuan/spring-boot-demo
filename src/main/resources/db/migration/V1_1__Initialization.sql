CREATE TABLE user_table (id int(11) NOT NULL AUTO_INCREMENT,
  address varchar(255) DEFAULT NULL,
  age int(11) DEFAULT NULL,
  is_married bit(1) DEFAULT NULL,
  full_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_fullNameAge (full_name, age)
);

INSERT INTO user_table (full_name, address, age) VALUES ('Siva', '46, Jalan Pipit', 23);
INSERT INTO user_table (full_name, address, age) VALUES ('Prasad', '56, Jalan Damansara', 25);
INSERT INTO user_table (full_name, address, age) VALUES ('Reddy', '66, Jalan Puchong', 27);