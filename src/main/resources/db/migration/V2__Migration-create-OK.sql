
CREATE TABLE visit.outpost (

id int(6) NOT NULL AUTO_INCREMENT,

name varchar(40) NOT NULL,

adress varchar(40) NOT NULL,

postcode varchar(10) NOT NULL,

town varchar(40) NOT NULL,

country varchar(40) NOT NULL,

PRIMARY KEY (id)

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE visit.employee (

id int(6) NOT NULL AUTO_INCREMENT,

firstName varchar(20) NOT NULL,

lastName varchar(20) NOT NULL,

telephoneNumber varchar(12) NOT NULL,

adress varchar(40) NOT NULL,

email varchar(40) NOT NULL UNIQUE,

postcode varchar(10) NOT NULL,

town varchar(40) NOT NULL,

country varchar(40) NOT NULL,

idOutpost int(6),

PRIMARY KEY (id),

FOREIGN KEY (idOutpost) REFERENCES visit.outpost(id)

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE visit.user (

id int(6) NOT NULL AUTO_INCREMENT,

login varchar(40) NOT NULL,

password varchar(40) NOT NULL,

idEmployee int(6) NOT NULL,

PRIMARY KEY (id),

FOREIGN KEY (idEmployee) REFERENCES visit.employee(id)

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


create table visit.visit (

id int(6) NOT NULL AUTO_INCREMENT,

idEmployee int(6) not null,

idCustomer int(6) not null,

Date date not null,

Time varchar(20) not null,

primary key (id),

FOREIGN KEY (idEmployee) REFERENCES visit.employee(id),

FOREIGN KEY (idCustomer) REFERENCES visit.customer(id)

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


create table visit.customer (

id int(6) NOT NULL AUTO_INCREMENT,

firstName varchar(20) NOT NULL,

lastName varchar(20) NOT NULL,

telephoneNumber varchar(12) NOT NULL,

primary key (id),

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


create table visit.schedule (

id int(6) NOT NULL AUTO_INCREMENT,

startTime varchar(20) not null,

endTime varchar(20) not null,

primary key (id)

)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;