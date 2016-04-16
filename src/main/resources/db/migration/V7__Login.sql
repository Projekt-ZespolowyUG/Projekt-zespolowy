DROP TABLE visit.user;

CREATE  TABLE visit.users (
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (username),
  idEmployee BIGINT(6) NOT NULL,
  CONSTRAINT users_employee FOREIGN KEY (idEmployee) REFERENCES visit.employee(id)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
 CREATE TABLE user_roles (
  user_role_id BIGINT(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES visit.users (username)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

