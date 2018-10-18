 DROP schema if exists sistema_conjuntos_residenciales;
 CREATE DATABASE  IF NOT EXISTS `sistema_conjuntos_residenciales` ;
 USE `sistema_conjuntos_residenciales`;
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
-- Table structure for table `parqueadero`
--

DROP TABLE IF EXISTS `parqueadero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parqueadero` (
  `numero` varchar(6) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parqueadero`
--

LOCK TABLES `parqueadero` WRITE;
/*!40000 ALTER TABLE `parqueadero` DISABLE KEYS */;
INSERT INTO `parqueadero` VALUES ('1-101'),('1-102'),('1-103'),('1-104'),('1-201'),('1-202'),('1-203'),('1-204'),('1-301'),('1-302'),('2-101'),('2-102'),('2-103'),('2-104'),('2-201'),('2-202'),('2-203'),('2-204'),('2-301'),('2-302'),('2-303'),('2-304'),('3-101'),('3-102'),('3-103'),('3-104'),('3-201'),('3-202'),('3-203'),('3-204');
/*!40000 ALTER TABLE `parqueadero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `documento` varchar(10) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `nacimiento` varchar(15) NOT NULL,
  `correo` varchar(40) NOT NULL,
  `id_sesion` int(10) NOT NULL,
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
INSERT INTO `persona` VALUES ('1014293457','sara fuentes','123123','1993-10-14','lrodriguez52@uan.edu.co',3),('1014293632','David Esteban Rodriguez Fuentes','3144706204','16/11/1997','drodriguez88@uan.edu.co',2),('1014293634','Leidy Yohana Rodriguez Fuentes','3227525187','16/11/1997','lrodriguez52@uan.edu.co',1),('1023978932','luzena ricardo','564332','1991-06-05','lrodriguez52@uan.edu.co',5),('12345678','leidy fuentes','123123','1995-10-12','lrodriguez52@uan.edu.co',6),('1234567890','david rodriguez','765433','1993-10-13','lrodriguez52@uan.edu.co',7),('2132342545','lizeth farfan','353452','1995-10-10','lrodriguez52@uan.edu.co',4);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
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
INSERT INTO `sesion` VALUES (1,'leidy1234','1014293634',1),(2,'david1234','1014293632',2),(3,'N�[���U��i/W�(qDq��ā<�7b(lyd �=Y$тs�ժ>����I\'��s��D`�F��P��*�)�6\"Ȼ^ 2���','1014293457',2),(4,'�W�S��^a��\"#5�U�XT�.���2�Թ!�#�/���s6YjY��]��Q���YU�	�^�ʔ��O�]���','2132342545',2),(5,'*u�Gbz��!׍˫8ǮH�����}ћ�����:S0�I���r��n�d|0����VOJ��g���J#-�o7�Bϐ�','1023978932',2),(6,'*���ؽ�ɨ\'Q���>	�����y���\"������R;��o�`TT(�^�Cf�d5��za\Za����W','12345678',2),(7,'�31;�P�*�D�RP���)�o�+煞�9J��is6�K\n�?0	ZR��;\Z3�\\�J�S����k5�����/Q\ZzH�','1234567890',2);
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
INSERT INTO `torre` VALUES (1,20,10,1),(2,16,12,2),(3,12,8,4);
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
INSERT INTO `torreapart` VALUES (1,101,'si','no','1234567890'),(1,102,'','',NULL),(1,103,'','',NULL),(1,104,'','',NULL),(1,201,'','',NULL),(1,202,'','',NULL),(1,203,'','',NULL),(1,204,'si','si','1014293457'),(1,301,'','',NULL),(1,302,'','',NULL),(1,303,'','',NULL),(1,304,'','',NULL),(1,401,'','',NULL),(1,402,'','',NULL),(1,403,'','',NULL),(1,404,'','',NULL),(1,501,'','',NULL),(1,502,'','',NULL),(1,503,'','',NULL),(1,504,'','',NULL),(2,101,'','',NULL),(2,102,'','',NULL),(2,103,'','',NULL),(2,104,'si','si','12345678'),(2,201,'','',NULL),(2,202,'','',NULL),(2,203,'','',NULL),(2,204,'','',NULL),(2,301,'','',NULL),(2,302,'','',NULL),(2,303,'','',NULL),(2,304,'','',NULL),(2,401,'','',NULL),(2,402,'','',NULL),(2,403,'si','no','2132342545'),(2,404,'','',NULL),(3,101,'','',NULL),(3,102,'','',NULL),(3,103,'','',NULL),(3,104,'','',NULL),(3,201,'','',NULL),(3,202,'','',NULL),(3,203,'','',NULL),(3,204,'','',NULL),(3,301,'','',NULL),(3,302,'','',NULL),(3,303,'','',NULL),(3,304,'si','si','1023978932');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitante`
--

LOCK TABLES `visitante` WRITE;
/*!40000 ALTER TABLE `visitante` DISABLE KEYS */;
INSERT INTO `visitante` VALUES (1,'1014293687','carlos paez',2,403,'18-10-2018-7:13:36','18-10-2018-7:14:53'),(2,'1034293976','stefany perez',1,101,'18-10-2018-7:14:24','18-10-2018-7:15:1');
/*!40000 ALTER TABLE `visitante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `apartprop`
--

/*!50001 DROP VIEW IF EXISTS `apartprop`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `apartprop` AS select `persona`.`documento` AS `documento`,`persona`.`nombre` AS `nombre`,`persona`.`telefono` AS `telefono`,`persona`.`nacimiento` AS `nacimiento`,`persona`.`correo` AS `correo`,`torreapart`.`ntorre` AS `ntorre`,`torreapart`.`napartamento` AS `napartamento`,`torreapart`.`reside` AS `reside`,`torreapart`.`parqueadero` AS `parqueadero` from (`persona` join `torreapart` on((`persona`.`documento` = `torreapart`.`documento`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `inmueble`
--

/*!50001 DROP VIEW IF EXISTS `inmueble`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `inmueble` AS select `torreapart`.`ntorre` AS `ntorre`,`torreapart`.`napartamento` AS `napartamento`,`torreapart`.`reside` AS `reside`,`torreapart`.`parqueadero` AS `parqueadero`,`tipozona`.`nombre` AS `nombre`,`tipozona`.`costoadmin` AS `costoadmin`,`tipozona`.`costoparq` AS `costoparq` from ((`torreapart` join `torre` on((`torreapart`.`ntorre` = `torre`.`numero`))) join `tipozona` on((`torre`.`idzona` = `tipozona`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `loginpersona`
--

/*!50001 DROP VIEW IF EXISTS `loginpersona`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `loginpersona` AS select `persona`.`documento` AS `documento`,`persona`.`nombre` AS `nombre`,`persona`.`telefono` AS `telefono`,`persona`.`nacimiento` AS `nacimiento`,`persona`.`correo` AS `correo`,`tipo_usuario`.`nombre` AS `tipo`,`sesion`.`usuario` AS `usuario`,`sesion`.`contraseña` AS `contraseña` from ((`persona` join `sesion` on((`persona`.`id_sesion` = `sesion`.`id`))) join `tipo_usuario` on((`sesion`.`id_tipo` = `tipo_usuario`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `totaltorre`
--

/*!50001 DROP VIEW IF EXISTS `totaltorre`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `totaltorre` AS select `torre`.`numero` AS `numero`,`torre`.`naptos` AS `naptos`,`tipozona`.`nombre` AS `zona`,`torre`.`npuestos` AS `puestos`,(`tipozona`.`costoadmin` + `tipozona`.`costoparq`) AS `costo` from (`torre` join `tipozona` on((`torre`.`idzona` = `tipozona`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-18  7:16:32
