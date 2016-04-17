DROP TABLE user_roles;
DROP TABLE visit.users;

CREATE TABLE visit.user (

id BIGINT(6) NOT NULL AUTO_INCREMENT,

login varchar(40) NOT NULL,

password varchar(40) NOT NULL,

idEmployee BIGINT(6) NOT NULL,

PRIMARY KEY (id),

CONSTRAINT user_employee FOREIGN KEY (idEmployee) REFERENCES visit.employee(id)

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;