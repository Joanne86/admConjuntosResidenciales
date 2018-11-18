
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_conjuntos_residenciales
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apartamento`
--

DROP TABLE IF EXISTS `apartamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apartamento` (
  `numero` int(3) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartamento`
--

LOCK TABLES `apartamento` WRITE;
/*!40000 ALTER TABLE `apartamento` DISABLE KEYS */;
INSERT INTO `apartamento` VALUES (101),(102),(103),(104),(201),(202),(203),(204),(301),(302),(303),(304),(401),(402),(403),(404),(501),(502),(503),(504),(601),(602),(603),(604);
/*!40000 ALTER TABLE `apartamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `apartprop`
--

DROP TABLE IF EXISTS `apartprop`;
/*!50001 DROP VIEW IF EXISTS `apartprop`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `apartprop` AS SELECT 
 1 AS `documento`,
 1 AS `nombre`,
 1 AS `telefono`,
 1 AS `nacimiento`,
 1 AS `correo`,
 1 AS `ntorre`,
 1 AS `napartamento`,
 1 AS `reside`,
 1 AS `parqueadero`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `inmueble`
--

DROP TABLE IF EXISTS `inmueble`;
/*!50001 DROP VIEW IF EXISTS `inmueble`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `inmueble` AS SELECT 
 1 AS `ntorre`,
 1 AS `napartamento`,
 1 AS `reside`,
 1 AS `parqueadero`,
 1 AS `nombre`,
 1 AS `costoadmin`,
 1 AS `costoparq`*/;
 
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `loginpersona`
--

DROP TABLE IF EXISTS `loginpersona`;
/*!50001 DROP VIEW IF EXISTS `loginpersona`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `loginpersona` AS SELECT 
 1 AS `documento`,
 1 AS `nombre`,
 1 AS `telefono`,
 1 AS `nacimiento`,
 1 AS `correo`,
 1 AS `tipo`,
 1 AS `usuario`,
 1 AS `contraseña`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `novedad`
--

DROP TABLE IF EXISTS `novedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `novedad` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `tiponovedad` varchar(10) NOT NULL,
  `detallenovedad` varchar(2000) NOT NULL,
  `documento` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `documento` (`documento`),
  CONSTRAINT `novedad_ibfk_1` FOREIGN KEY (`documento`) REFERENCES `persona` (`documento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `novedad`
--

LOCK TABLES `novedad` WRITE;
/*!40000 ALTER TABLE `novedad` DISABLE KEYS */;
INSERT INTO `novedad` VALUES (1,'Sugerencia','Deberian poner mas canecas de basura por todo el conjunto','1234567890'),(2,'Sugerencia','FALTAN MAS CANECAS DE BASURA','1023883679');
/*!40000 ALTER TABLE `novedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `novedadresid`
--

DROP TABLE IF EXISTS `novedadresid`;
/*!50001 DROP VIEW IF EXISTS `novedadresid`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `novedadresid` AS SELECT 
 1 AS `ntorre`,
 1 AS `napartamento`,
 1 AS `tipo`,
 1 AS `nombre`,
 1 AS `tiponovedad`,
 1 AS `detallenovedad`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `parqueadero`
--

DROP TABLE IF EXISTS `parqueadero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parqueadero` (
  `numero` varchar(10) NOT NULL,
  `ocupado` varchar(6) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parqueadero`
--

LOCK TABLES `parqueadero` WRITE;
/*!40000 ALTER TABLE `parqueadero` DISABLE KEYS */;
INSERT INTO `parqueadero` VALUES ('No','sin No'),('1-101','No'),('1-102','No'),('1-103','No'),
('1-104','No'),('1-201','No'),('1-202','No'),('1-203','No'),('1-204','No'),('1-301','No'),('1-302','No'),
('2-101','No'),('2-102','No'),('2-103','No'),('2-104','No'),('2-201','No'),('2-202','No'),('2-203','No'),
('2-204','No'),('2-301','No'),('2-302','No'),('2-303','No'),('2-304','No'),('2-401','No'),('2-402','No'),
('2-403','No'),('3-101','No'),('3-102','No'),('3-103','No'),('3-104','No'),('3-201','No'),('3-202','No'),
('3-203','No'),('3-204','No'),('3-301','No'),('3-302','No'),('3-303','No'),('3-304','No'),('4-101','No'),
('4-102','No'),('4-103','No'),('4-104','No'),('4-201','No'),('4-202','No'),('4-203','No'),('4-204','No'),
('5-101','No'),('5-102','No'),('5-103','No'),('5-104','No'),('5-201','No'),('5-202','No'),('5-203','No'),
('5-204','No'),('5-301','No'),('6-101','No'),('6-102','No'),('6-103','No'),('6-104','No'),('6-201','No');
/*!40000 ALTER TABLE `parqueadero` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `arrendatario`
--

DROP TABLE IF EXISTS `arrendatario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arrendatario` (
  `documento` varchar(15) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(40) NOT NULL,
  `torreapart` varchar(7) NOT NULL,
  `parqn` varchar(10) NOT NULL,
  PRIMARY KEY (`documento`),
  KEY `parqn` (`parqn`),
  CONSTRAINT `arrendatario_ibfk_1` FOREIGN KEY (`parqn`) REFERENCES `parqueadero` (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arrendatario`
--

LOCK TABLES `arrendatario` WRITE;
/*!40000 ALTER TABLE `arrendatario` DISABLE KEYS */;
-- INSERT INTO `arrendatario` VALUES ('1014265845','william torres','3125830084','1985-04-16','lrodriguez52@uan.edu.co',NULL),('1014293634','Leidy Yohana Rodriguez Fuentes','3227525187','16/11/1997','lrodriguez52@uan.edu.co',1),('1023883679','Yeimmy Ricardo','3124568907','1991-07-23','yricardo79@uan.edu.co',4),('1031152621','Lizeth Farfán','3017489662','1993-03-09','lfarfan21@uan.edu.co',5),('1234567890','david rojas','3148924321','1984-03-14','lrodriguez52@uan.edu.co',6),('2334564567','diego gomez','3102347568','1992-10-16','dagomezs@uan.edu.co',NULL),('2345678901','Carlos Gonzales','1234567','1982-06-16','lrodriguez52@uan.edu.co',NULL),('4576321897','esteban herrera','3007210339','1966-06-15','lrodriguez52@uan.edu.co',7),('46356895','sara fuentes','3125256290','1993-10-15','lrodriguez52@uan.edu.co',NULL),('79289201','william rodriguez','3124217525','1967-10-27','lrodriguez52@uan.edu.co',3);
/*!40000 ALTER TABLE `arrendatario` ENABLE KEYS */;
UNLOCK TABLES;




--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `documento` varchar(15) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `nacimiento` varchar(15) NOT NULL,
  `correo` varchar(40) NOT NULL,
  `id_sesion` int(10) DEFAULT NULL,
  PRIMARY KEY (`documento`),
  KEY `id_sesion` (`id_sesion`),
  CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`id_sesion`) REFERENCES `sesion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES ('1014265845','william torres','3125830084','1985-04-16','lrodriguez52@uan.edu.co',NULL),('1014293634','Leidy Yohana Rodriguez Fuentes','3227525187','16/11/1997','lrodriguez52@uan.edu.co',1),('1023883679','Yeimmy Ricardo','3124568907','1991-07-23','yricardo79@uan.edu.co',4),('1031152621','Lizeth Farfán','3017489662','1993-03-09','lfarfan21@uan.edu.co',5),('1234567890','david rojas','3148924321','1984-03-14','lrodriguez52@uan.edu.co',6),('2334564567','diego gomez','3102347568','1992-10-16','dagomezs@uan.edu.co',NULL),('2345678901','Carlos Gonzales','1234567','1982-06-16','lrodriguez52@uan.edu.co',NULL),('4576321897','esteban herrera','3007210339','1966-06-15','lrodriguez52@uan.edu.co',7),('46356895','sara fuentes','3125256290','1993-10-15','lrodriguez52@uan.edu.co',NULL),('79289201','william rodriguez','3124217525','1967-10-27','lrodriguez52@uan.edu.co',3);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `personalservicio`
--

DROP TABLE IF EXISTS `personalservicio`;
/*!50001 DROP VIEW IF EXISTS `personalservicio`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `personalservicio` AS SELECT 
 1 AS `documento`,
 1 AS `nombre`,
 1 AS `telefono`,
 1 AS `nacimiento`,
 1 AS `correo`,
 1 AS `nombreserv`,
 1 AS `horario`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo` (
  `codigo` varchar(15) NOT NULL,
  `documento` varchar(15) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `ntorre` varchar(4) NOT NULL,
  `napart` varchar(4) NOT NULL,
  `zona` varchar(15) NOT NULL,
  `costoadmin` varchar(10) NOT NULL,
  `costoparq` varchar(10) NOT NULL,
  `total` varchar(10) NOT NULL,
  `cancelado` varchar(4) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `documento` (`documento`),
  CONSTRAINT `recibo_ibfk_1` FOREIGN KEY (`documento`) REFERENCES `persona` (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo`
--

LOCK TABLES `recibo` WRITE;
/*!40000 ALTER TABLE `recibo` DISABLE KEYS */;
INSERT INTO `recibo` VALUES ('150042','1234567890','david rojas','5','101','parejas','20000','0','20000.0','no'),('481776','4576321897','esteban herrera','1','204','penthouse','150000','60000','210000.0','no'),('654881','79289201','william rodriguez','2','502','penthouse','150000','60000','210000.0','no'),('781585','1023883679','Yeimmy Ricardo','3','203','familiar','60000','0','60000.0','si');
/*!40000 ALTER TABLE `recibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicio` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `nombreserv` varchar(20) NOT NULL,
  `horario` varchar(15) NOT NULL,
  `documento` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `documento` (`documento`),
  CONSTRAINT `servicio_ibfk_1` FOREIGN KEY (`documento`) REFERENCES `persona` (`documento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (1,'mantenimiento','7:00am-12:00pm','46356895'),(2,'vigilancia','4:00am-12:00pm','1014265845'),(3,'aseo','2:00pm-5:00pm','2345678901'),(5,'vigilancia','9:00am-12:00pm','2334564567');
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sesion`
--

DROP TABLE IF EXISTS `sesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sesion` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `contraseña` varchar(2000) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `id_tipo` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_tipo` (`id_tipo`),
  CONSTRAINT `sesion_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesion`
--

LOCK TABLES `sesion` WRITE;
/*!40000 ALTER TABLE `sesion` DISABLE KEYS */;
INSERT INTO `sesion` VALUES (1,'WXwb56uGr3lE0yNf9WpHaw==','1014293634',1),(3,'fuDfzkFykV0=','79289201',2),(4,'uiQGcR0rOcw=','1023883679',2),(5,'cF4My5L2dEs=','1031152621',2),(6,'Favevg/NoCU=','1234567890',2),(7,'IzkDAH52QVc=','4576321897',2);
/*!40000 ALTER TABLE `sesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_usuario` (
  `id` int(2) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'administrador'),(2,'propietario'),(3,'arrendatario'),(4,'vigilancia'),(5,'aseo'),(6,'mantenimiento');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipozona`
--

DROP TABLE IF EXISTS `tipozona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipozona` (
  `id` int(2) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `costoadmin` float NOT NULL,
  `costoparq` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipozona`
--

LOCK TABLES `tipozona` WRITE;
/*!40000 ALTER TABLE `tipozona` DISABLE KEYS */;
INSERT INTO `tipozona` VALUES (1,'penthouse',150000,60000),(2,'familiar',60000,30000),(3,'comun',40000,20000),(4,'parejas',20000,15000);
/*!40000 ALTER TABLE `tipozona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torre`
--

DROP TABLE IF EXISTS `torre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `torre` (
  `numero` int(3) NOT NULL,
  `naptos` int(3) NOT NULL,
  `npuestos` int(3) NOT NULL,
  `idzona` int(2) NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `idzona` (`idzona`),
  CONSTRAINT `torre_ibfk_1` FOREIGN KEY (`idzona`) REFERENCES `tipozona` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torre`
--

LOCK TABLES `torre` WRITE;
/*!40000 ALTER TABLE `torre` DISABLE KEYS */;
INSERT INTO `torre` VALUES (1,12,10,1),(2,20,15,1),(3,24,12,2),(4,16,8,3),(5,18,9,4),(6,10,5,2);
/*!40000 ALTER TABLE `torre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torreapart`
--

DROP TABLE IF EXISTS `torreapart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `torreapart` (
  `ntorre` int(3) NOT NULL,
  `napartamento` int(3) NOT NULL,
  `reside` varchar(3) NOT NULL,
  `parqueadero` varchar(3) NOT NULL,
  `documento` varchar(10) DEFAULT NULL,
  KEY `ntorre` (`ntorre`),
  KEY `napartamento` (`napartamento`),
  KEY `documento` (`documento`),
  CONSTRAINT `torreapart_ibfk_1` FOREIGN KEY (`ntorre`) REFERENCES `torre` (`numero`),
  CONSTRAINT `torreapart_ibfk_2` FOREIGN KEY (`napartamento`) REFERENCES `apartamento` (`numero`),
  CONSTRAINT `torreapart_ibfk_3` FOREIGN KEY (`documento`) REFERENCES `persona` (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torreapart`
--

LOCK TABLES `torreapart` WRITE;
/*!40000 ALTER TABLE `torreapart` DISABLE KEYS */;
INSERT INTO `torreapart` VALUES (1,101,'','',NULL),(1,102,'','',NULL),(1,103,'','',NULL),(1,104,'','',NULL),(1,201,'','',NULL),(1,202,'','',NULL),(1,203,'','',NULL),(1,204,'si','si','4576321897'),(1,301,'','',NULL),(1,302,'','',NULL),(1,303,'','',NULL),(1,304,'','',NULL),(2,101,'','',NULL),(2,102,'','',NULL),(2,103,'','',NULL),(2,104,'','',NULL),(2,201,'','',NULL),(2,202,'','',NULL),(2,203,'','',NULL),(2,204,'','',NULL),(2,301,'','',NULL),(2,302,'','',NULL),(2,303,'','',NULL),(2,304,'','',NULL),(2,401,'','',NULL),(2,402,'','',NULL),(2,403,'','',NULL),(2,404,'','',NULL),(2,501,'','',NULL),(2,502,'si','si','79289201'),(2,503,'','',NULL),(2,504,'','',NULL),(3,101,'','',NULL),(3,102,'','',NULL),(3,103,'','',NULL),(3,104,'','',NULL),(3,201,'','',NULL),(3,202,'','',NULL),(3,203,'si','no','1023883679'),(3,204,'','',NULL),(3,301,'','',NULL),(3,302,'','',NULL),(3,303,'','',NULL),(3,304,'','',NULL),(3,401,'','',NULL),(3,402,'','',NULL),(3,403,'','',NULL),(3,404,'','',NULL),(3,501,'','',NULL),(3,502,'','',NULL),(3,503,'','',NULL),(3,504,'','',NULL),(3,601,'','',NULL),(3,602,'','',NULL),(3,603,'','',NULL),(3,604,'','',NULL),(4,101,'','',NULL),(4,102,'','',NULL),(4,103,'','',NULL),(4,104,'','',NULL),(4,201,'','',NULL),(4,202,'','',NULL),(4,203,'','',NULL),(4,204,'','',NULL),(4,301,'','',NULL),(4,302,'si','si','1031152621'),(4,303,'','',NULL),(4,304,'','',NULL),(4,401,'','',NULL),(4,402,'','',NULL),(4,403,'','',NULL),(4,404,'','',NULL),(5,101,'si','no','1234567890'),(5,102,'','',NULL),(5,103,'','',NULL),(5,104,'','',NULL),(5,201,'','',NULL),(5,202,'','',NULL),(5,203,'','',NULL),(5,204,'','',NULL),(5,301,'','',NULL),(5,302,'','',NULL),(5,303,'','',NULL),(5,304,'','',NULL),(5,401,'','',NULL),(5,402,'','',NULL),(5,403,'','',NULL),(5,404,'','',NULL),(5,501,'','',NULL),(5,502,'','',NULL),(6,101,'','',NULL),(6,102,'','',NULL),(6,103,'','',NULL),(6,104,'','',NULL),(6,201,'','',NULL),(6,202,'','',NULL),(6,203,'','',NULL),(6,204,'','',NULL),(6,301,'','',NULL),(6,302,'','',NULL);
/*!40000 ALTER TABLE `torreapart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `totaltorre`
--

DROP TABLE IF EXISTS `totaltorre`;
/*!50001 DROP VIEW IF EXISTS `totaltorre`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `totaltorre` AS SELECT 
 1 AS `numero`,
 1 AS `naptos`,
 1 AS `zona`,
 1 AS `puestos`,
 1 AS `costo`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `visitante`
--

DROP TABLE IF EXISTS `visitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visitante` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `documento` varchar(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `ntorre` int(3) NOT NULL,
  `napartamento` int(3) NOT NULL,
  `entrada` varchar(30) NOT NULL,
  `salida` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitante`
--

LOCK TABLES `visitante` WRITE;
/*!40000 ALTER TABLE `visitante` DISABLE KEYS */;
INSERT INTO `visitante` VALUES (1,'2345167816','mercedes parra',5,101,'23-10-2018-9:49:30','23-10-2018-9:50:24'),(2,'567432908','lucero castellanos',2,502,'23-10-2018-9:50:5','23-10-2018-18:41:31'),(3,'1023883679','yeimmy ricardo',2,502,'23-10-2018-18:39:52','23-10-2018-18:40:47');
/*!40000 ALTER TABLE `visitante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `apartprop`
--

 DROP VIEW IF EXISTS `apartprop`;
 CREATE VIEW `apartprop` AS select `persona`.`documento` AS `documento`,`persona`.`nombre` AS `nombre`,`persona`.`telefono` AS `telefono`,`persona`.`nacimiento` AS `nacimiento`,`persona`.`correo` AS `correo`,`torreapart`.`ntorre` AS `ntorre`,`torreapart`.`napartamento` AS `napartamento`,`torreapart`.`reside` AS `reside`,`torreapart`.`parqueadero` AS `parqueadero` from (`persona` join `torreapart` on((`persona`.`documento` = `torreapart`.`documento`))) ;


--
-- Final view structure for view `inmueble`
--

DROP VIEW IF EXISTS `inmueble`;
CREATE VIEW `inmueble` AS select `torreapart`.`ntorre` AS `ntorre`,`torreapart`.`napartamento` AS `napartamento`,`torreapart`.`reside` AS `reside`,`torreapart`.`parqueadero` AS `parqueadero`,`tipozona`.`nombre` AS `nombre`,`tipozona`.`costoadmin` AS `costoadmin`,`tipozona`.`costoparq` AS `costoparq` from ((`torreapart` join `torre` on((`torreapart`.`ntorre` = `torre`.`numero`))) join `tipozona` on((`torre`.`idzona` = `tipozona`.`id`)));

--
-- Final view structure for view `loginpersona`
--

 DROP VIEW IF EXISTS `loginpersona`;
CREATE VIEW `loginpersona` AS select `persona`.`documento` AS `documento`,`persona`.`nombre` AS `nombre`,`persona`.`telefono` AS `telefono`,`persona`.`nacimiento` AS `nacimiento`,`persona`.`correo` AS `correo`,`tipo_usuario`.`nombre` AS `tipo`,`sesion`.`usuario` AS `usuario`,`sesion`.`contraseña` AS `contraseña` from ((`persona` join `sesion` on((`persona`.`id_sesion` = `sesion`.`id`))) join `tipo_usuario` on((`sesion`.`id_tipo` = `tipo_usuario`.`id`))) ;


--
-- Final view structure for view `novedadresid`
--

DROP VIEW IF EXISTS `novedadresid`;
CREATE VIEW `novedadresid` AS select `torreapart`.`ntorre` AS `ntorre`,`torreapart`.`napartamento` AS `napartamento`,`loginpersona`.`tipo` AS `tipo`,`loginpersona`.`nombre` AS `nombre`,`novedad`.`tiponovedad` AS `tiponovedad`,`novedad`.`detallenovedad` AS `detallenovedad` from ((`torreapart` join `loginpersona` on((`torreapart`.`documento` = `loginpersona`.`documento`))) join `novedad` on((`loginpersona`.`documento` = `novedad`.`documento`))) ;


--
-- Final view structure for view `personalservicio`
--

DROP VIEW IF EXISTS `personalservicio`;
CREATE VIEW `personalservicio` AS select `persona`.`documento` AS `documento`,`persona`.`nombre` AS `nombre`,`persona`.`telefono` AS `telefono`,`persona`.`nacimiento` AS `nacimiento`,`persona`.`correo` AS `correo`,`servicio`.`nombreserv` AS `nombreserv`,`servicio`.`horario` AS `horario` from (`persona` join `servicio` on((`persona`.`documento` = `servicio`.`documento`))) ;


--
-- Final view structure for view `totaltorre`
--

DROP VIEW IF EXISTS `totaltorre`;
CREATE VIEW `totaltorre` AS select `torre`.`numero` AS `numero`,`torre`.`naptos` AS `naptos`,`tipozona`.`nombre` AS `zona`,`torre`.`npuestos` AS `puestos`,(`tipozona`.`costoadmin` + `tipozona`.`costoparq`) AS `costo` from (`torre` join `tipozona` on((`torre`.`idzona` = `tipozona`.`id`)));
