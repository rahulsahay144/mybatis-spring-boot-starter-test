DROP TABLE IF EXISTS usr;
CREATE TABLE IF NOT EXISTS test_usr(
  id BIGINT AUTO_INCREMENT PRIMARY KEY ,
  account VARCHAR(32) NOT NULL COMMENT '',
  phone VARCHAR(16) NOT NULL COMMENT '',
  password VARCHAR(32) NOT NULL COMMENT ''
);

CREATE TABLE IF NOT EXISTS test_fr(
  id BIGINT AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(32) NOT NULL COMMENT ''

);

INSERT INTO test_usr(account,phone,password) VALUES ('0002','11111','aaa'),('0003','2222','bbb');
INSERT INTO test_fr(name) VALUES ('Hello');