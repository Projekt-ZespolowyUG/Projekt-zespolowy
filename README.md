# tworzenie tabel w sqlu

CREATE TABLE `visit`.`employee` (

 `idEmployee` int(6) NOT NULL AUTO_INCREMENT,  
 
firstName varchar(40) NOT NULL,

lastName varchar(40) NOT NULL,

telephoneNumber varchar(40) NOT NULL.

adress varchar(40) NOT NULL.

postcode varchar(40) NOT NULL,

town varchar(40) NOT NULL,

country varchar(40)NOT NULL,

PRIMARY KEY (`idEmployee`)  

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;  

