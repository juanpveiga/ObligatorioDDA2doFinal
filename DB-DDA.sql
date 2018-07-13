/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 5.7.22-log : Database - obligatoriodda
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`obligatoriodda` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `obligatoriodda`;

/*Table structure for table `administrador` */

DROP TABLE IF EXISTS `administrador`;

CREATE TABLE `administrador` (
  `oid` int(15) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `primerNombre` varchar(20) NOT NULL,
  `segundoNombre` varchar(20) DEFAULT NULL,
  `primerApellido` varchar(20) NOT NULL,
  `segundoApellido` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `administrador` */

insert  into `administrador`(`oid`,`usuario`,`password`,`primerNombre`,`segundoNombre`,`primerApellido`,`segundoApellido`) values 
(9,'Gamboa','asdf','Adriana','Lucia','Reyes','Gonzalez'),
(8,'Gervaz','asdf','Armando','Esteban','Quito',NULL);

/*Table structure for table `juego` */

DROP TABLE IF EXISTS `juego`;

CREATE TABLE `juego` (
  `oid` int(15) NOT NULL,
  `fecha` date DEFAULT NULL,
  `cantManos` int(5) NOT NULL,
  `ganador` varchar(20) DEFAULT NULL,
  `totalApostado` double(10,2) DEFAULT NULL,
  `luz` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `oid` (`oid`,`ganador`),
  KEY `ganador` (`ganador`),
  CONSTRAINT `juego_ibfk_2` FOREIGN KEY (`ganador`) REFERENCES `jugador` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `juego` */

insert  into `juego`(`oid`,`fecha`,`cantManos`,`ganador`,`totalApostado`,`luz`) values 
(32,'2018-07-09',2,'Juan',180.00,20.00),
(33,'2018-07-09',3,'Jorge',255.00,20.00),
(34,'2018-07-09',2,'Juan',180.00,20.00),
(35,'2018-07-09',1,'Jorge',70.00,20.00),
(37,'2018-07-09',4,'Lucas',265.00,20.00),
(38,'2018-07-09',1,'Juan',60.00,20.00),
(39,'2018-07-09',12,'Jose',805.00,20.00),
(40,'2018-07-09',1,'Juan',75.00,20.00),
(41,'2018-07-09',2,'Juan',150.00,20.00),
(42,'2018-07-09',4,'Jorge',220.00,20.00),
(43,'2018-07-09',2,'LEON',115.00,20.00),
(44,'2018-07-09',3,'Jorge',210.00,20.00),
(45,'2018-07-09',1,'Lucas',75.00,20.00),
(46,'2018-07-09',2,'Jorge',115.00,20.00),
(47,'2018-07-09',2,'Juan',135.00,20.00),
(48,'2018-07-09',2,'Juan',135.00,20.00),
(49,'2018-07-09',1,'Juan',70.00,20.00),
(50,'2018-07-09',2,'Jorge',110.00,20.00),
(51,'2018-07-09',1,'Jose',70.00,20.00),
(52,'2018-07-09',2,'Jose',105.00,20.00),
(53,'2018-07-09',2,'Jorge',120.00,20.00),
(54,'2018-07-09',1,'Jose',70.00,20.00),
(55,'2018-07-09',1,'Jose',75.00,20.00),
(56,'2018-07-09',3,'Juan',225.00,20.00),
(57,'2018-07-09',1,'Marcelo',75.00,20.00),
(58,'2018-07-09',1,'Lucas',60.00,20.00),
(59,'2018-07-09',1,'Jorge',70.00,20.00),
(60,'2018-07-09',4,'Juan',250.00,20.00),
(61,'2018-07-09',3,'Jorge',210.00,20.00),
(62,'2018-07-09',3,'Juan',185.00,20.00),
(63,'2018-07-09',3,'Juan',205.00,20.00),
(64,'2018-07-09',3,'Juan',180.00,20.00),
(65,'2018-07-09',3,'Juan',210.00,20.00),
(66,'2018-07-09',2,'Jose',130.00,20.00),
(67,'2018-07-09',2,'Jose',130.00,20.00),
(68,'2018-07-09',2,'Juan',135.00,20.00),
(69,'2018-07-09',6,'Juan',435.00,20.00),
(70,'2018-07-09',2,'Juan',135.00,20.00),
(71,'2018-07-09',2,'Marcelo',135.00,20.00),
(72,'2018-07-09',3,'Juan',200.00,20.00),
(73,'2018-07-09',6,'Jose',405.00,20.00);

/*Table structure for table `jugador` */

DROP TABLE IF EXISTS `jugador`;

CREATE TABLE `jugador` (
  `oid` int(15) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `primerNombre` varchar(20) NOT NULL,
  `segundoNombre` varchar(20) DEFAULT NULL,
  `primerApellido` varchar(20) NOT NULL,
  `segundoApellido` varchar(20) DEFAULT NULL,
  `saldo` double(10,2) NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `jugador` */

insert  into `jugador`(`oid`,`usuario`,`password`,`primerNombre`,`segundoNombre`,`primerApellido`,`segundoApellido`,`saldo`) values 
(3,'Jorge','12345','Jorge','Pedro','Fernandez','Brum',930.00),
(2,'Jose','12345','Jose','Pablo','Gonzalez','Oviedo',1235.00),
(1,'Juan','12345','Juan','Pedro','Veiga','Zabala',1390.00),
(5,'LEON','12345','Leon','Agustin','Viega','Palleiro',595.00),
(6,'Lucas','12345','Lucas','Martin','Lorenzo','Lorenzo',415.00),
(4,'Marcelo','12345','Marcelo','null','Sanchez','Rodriguez',490.00),
(7,'Mariano','12345','Mariano','Manuel','Fernandez','Suarez',0.00);

/*Table structure for table `oid` */

DROP TABLE IF EXISTS `oid`;

CREATE TABLE `oid` (
  `valor` int(15) NOT NULL,
  PRIMARY KEY (`valor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `oid` */

insert  into `oid`(`valor`) values 
(74);

/*Table structure for table `participante` */

DROP TABLE IF EXISTS `participante`;

CREATE TABLE `participante` (
  `juego` int(15) NOT NULL,
  `saldoInicial` double(10,2) NOT NULL,
  `totalGanado` double(10,2) DEFAULT NULL,
  `totalApostado` double(10,2) DEFAULT NULL,
  `jugador` int(15) NOT NULL,
  PRIMARY KEY (`juego`,`jugador`),
  CONSTRAINT `participante_ibfk_1` FOREIGN KEY (`juego`) REFERENCES `juego` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `participante` */

insert  into `participante`(`juego`,`saldoInicial`,`totalGanado`,`totalApostado`,`jugador`) values 
(32,200.00,60.00,60.00,1),
(32,200.00,120.00,60.00,2),
(32,200.00,0.00,60.00,3),
(33,240.00,0.00,85.00,1),
(33,260.00,90.00,85.00,2),
(33,140.00,165.00,85.00,3),
(34,155.00,320.00,70.00,1),
(34,265.00,200.00,60.00,2),
(34,260.00,0.00,50.00,3),
(35,200.00,0.00,25.00,1),
(35,200.00,0.00,25.00,2),
(35,200.00,70.00,20.00,3),
(37,100.00,0.00,85.00,4),
(37,100.00,195.00,90.00,5),
(37,100.00,575.00,90.00,6),
(38,35.00,60.00,20.00,1),
(38,205.00,0.00,20.00,5),
(38,610.00,0.00,20.00,6),
(39,500.00,485.00,270.00,1),
(39,500.00,985.00,285.00,2),
(39,500.00,215.00,250.00,3),
(40,715.00,225.00,25.00,1),
(40,1225.00,0.00,25.00,2),
(40,465.00,0.00,25.00,3),
(41,970.00,0.00,50.00,1),
(41,1200.00,300.00,50.00,2),
(41,440.00,0.00,50.00,3),
(42,840.00,0.00,45.00,1),
(42,1375.00,0.00,85.00,2),
(42,830.00,310.00,90.00,3),
(43,500.00,0.00,25.00,4),
(43,500.00,190.00,45.00,5),
(43,500.00,0.00,45.00,6),
(44,795.00,450.00,70.00,1),
(44,1265.00,0.00,70.00,2),
(44,1050.00,435.00,70.00,3),
(45,1195.00,0.00,25.00,2),
(45,425.00,225.00,25.00,4),
(45,405.00,0.00,25.00,6),
(46,1170.00,0.00,45.00,2),
(46,1605.00,40.00,45.00,3),
(46,400.00,75.00,25.00,4),
(47,1175.00,60.00,45.00,1),
(47,1125.00,75.00,45.00,2),
(47,1620.00,0.00,45.00,3),
(48,1205.00,0.00,45.00,1),
(48,1130.00,0.00,40.00,2),
(48,1555.00,275.00,50.00,3),
(49,1140.00,210.00,25.00,1),
(49,1090.00,0.00,20.00,2),
(49,1570.00,0.00,25.00,3),
(50,1305.00,140.00,45.00,1),
(50,1070.00,0.00,25.00,2),
(50,1545.00,0.00,40.00,3),
(51,1400.00,0.00,25.00,1),
(51,1045.00,210.00,25.00,2),
(51,1505.00,0.00,20.00,3),
(52,1375.00,130.00,45.00,1),
(52,1210.00,0.00,40.00,2),
(52,1485.00,0.00,20.00,3),
(53,1460.00,140.00,25.00,1),
(53,1170.00,100.00,45.00,2),
(53,1465.00,0.00,50.00,3),
(54,1435.00,0.00,25.00,1),
(54,1125.00,70.00,20.00,2),
(54,1395.00,0.00,25.00,3),
(55,1410.00,0.00,25.00,1),
(55,1295.00,150.00,25.00,2),
(55,1370.00,0.00,25.00,3),
(56,1385.00,0.00,75.00,1),
(56,1400.00,225.00,75.00,2),
(56,1345.00,75.00,75.00,3),
(57,375.00,150.00,25.00,4),
(57,620.00,0.00,25.00,5),
(57,360.00,0.00,25.00,6),
(58,1345.00,0.00,20.00,3),
(58,480.00,0.00,20.00,4),
(58,335.00,60.00,20.00,6),
(59,1290.00,210.00,25.00,1),
(59,1400.00,0.00,20.00,2),
(59,1325.00,0.00,25.00,3),
(60,1405.00,0.00,85.00,1),
(60,1335.00,65.00,95.00,2),
(60,1255.00,285.00,70.00,3),
(61,1345.00,75.00,70.00,1),
(61,1210.00,75.00,70.00,2),
(61,1150.00,60.00,70.00,3),
(62,1330.00,75.00,65.00,1),
(62,1190.00,140.00,50.00,2),
(62,1055.00,0.00,70.00,3),
(63,1340.00,135.00,70.00,1),
(63,1140.00,70.00,70.00,2),
(63,985.00,0.00,65.00,3),
(64,1445.00,75.00,65.00,1),
(64,1140.00,0.00,45.00,2),
(64,920.00,260.00,70.00,3),
(65,1455.00,60.00,70.00,1),
(65,1095.00,75.00,70.00,2),
(65,1110.00,75.00,70.00,3),
(66,1465.00,0.00,40.00,1),
(66,1075.00,60.00,45.00,2),
(66,1090.00,70.00,45.00,3),
(67,1425.00,0.00,40.00,1),
(67,1030.00,60.00,45.00,2),
(67,1115.00,70.00,45.00,3),
(68,1310.00,135.00,45.00,1),
(68,1130.00,0.00,45.00,2),
(68,1075.00,0.00,45.00,3),
(69,1440.00,150.00,145.00,1),
(69,1085.00,225.00,145.00,2),
(69,1030.00,135.00,145.00,3),
(70,1425.00,135.00,45.00,1),
(70,1015.00,0.00,45.00,2),
(70,1020.00,0.00,45.00,3),
(71,1510.00,0.00,45.00,1),
(71,930.00,75.00,45.00,3),
(71,460.00,60.00,45.00,4),
(72,1465.00,75.00,65.00,1),
(72,1000.00,0.00,65.00,2),
(72,960.00,320.00,70.00,3),
(73,1475.00,75.00,135.00,1),
(73,935.00,400.00,140.00,2),
(73,1085.00,0.00,130.00,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
