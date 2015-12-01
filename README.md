# tworzenie tabel w sqlu


# 1.Employee

CREATE TABLE `visit`.`employee` (

 `idEmployee` int(6) NOT NULL AUTO_INCREMENT,  
 
firstName varchar(20) NOT NULL,

lastName varchar(20) NOT NULL,

telephoneNumber varchar(15) NOT NULL,

adress varchar(20) NOT NULL,

postcode varchar(6) NOT NULL,

town varchar(20) NOT NULL,

country varchar(20) NOT NULL,

PRIMARY KEY (`idEmployee`)  

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;  

