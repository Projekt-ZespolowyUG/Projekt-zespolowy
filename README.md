# Projekt-zespolowy

#Czlonkowie grupy:

Martin Zelek

Krzysztof Stelmach

Robert Knop

(Projekt realizowany w PGS Software)


#Temat:
Uniwersalny system umawiania na wizyty przeznaczony dla wielu branż.

#Proponowane technologie:

-Html/JSP/CSS/SASS

-MySQL

-Hibernate + Spring

-Tomcat, Maven


# tworzenie tabel w sqlu


# 1.Employee

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

FOREIGN KEY (idOutpost) REFERENCES visit.outpost(id),


) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

# 2.Outpost

CREATE TABLE visit.outpost (

id int(6) NOT NULL AUTO_INCREMENT,

name varchar(40) NOT NULL,

adress varchar(40) NOT NULL,

postcode varchar(10) NOT NULL,

town varchar(40) NOT NULL,

country varchar(40) NOT NULL,

PRIMARY KEY (id)

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

# 3.User

CREATE TABLE visit.user (

id int(6) NOT NULL AUTO_INCREMENT,

login varchar(40) NOT NULL,

password varchar(40) NOT NULL,

idEmployee int(6) NOT NULL,

PRIMARY KEY (id),

FOREIGN KEY (idEmployee) REFERENCES visit.employee(id)

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
