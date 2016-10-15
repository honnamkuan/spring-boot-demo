CREATE TABLE user_table (
  id         INT(11) NOT NULL AUTO_INCREMENT,
  address    VARCHAR(255)     DEFAULT NULL,
  age        INT(11)          DEFAULT NULL,
  is_married BIT(1)           DEFAULT NULL,
  full_name  VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE user_table ADD UNIQUE KEY UK_fullNameAge (full_name, age);

INSERT INTO user_table (full_name, address, age) VALUES ('Siva', '46, Jalan Pipit', 23);
INSERT INTO user_table (full_name, address, age) VALUES ('Prasad', '56, Jalan Damansara', 25);
INSERT INTO user_table (full_name, address, age) VALUES ('Reddy', '66, Jalan Puchong', 27);