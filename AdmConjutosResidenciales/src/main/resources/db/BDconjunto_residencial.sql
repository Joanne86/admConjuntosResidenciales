 DROP schema if exists sistema_conjuntos_residenciales;
 CREATE DATABASE  IF NOT EXISTS `sistema_conjuntos_residenciales` ;
 USE `sistema_conjuntos_residenciales`;

-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_ventas
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesion`
--

LOCK TABLES `sesion` WRITE;
/*!40000 ALTER TABLE `sesion` DISABLE KEYS */;
 INSERT INTO `sesion` VALUES (1,'WXwb56uGr3lE0yNf9WpHaw==','1014293634',1);
/*!40000 ALTER TABLE `sesion` ENABLE KEYS */;
UNLOCK TABLES;


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
  `id_sesion` int(10) ,
  PRIMARY KEY (`documento`),
  KEY `id_sesion` (`id_sesion`),
  CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`id_sesion`) REFERENCES `sesion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesion`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
 INSERT INTO `persona` VALUES ('1014293634','Leidy Yohana Rodriguez Fuentes','3227525187','16/11/1997','lrodriguez52@uan.edu.co', 1);
 -- INSERT INTO `persona` VALUES ('1014293632','David Esteban Rodriguez Fuentes','3144706204','16/11/1997','drodriguez88@uan.edu.co', 2);

/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
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
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipozona` WRITE;
/*!40000 ALTER TABLE `tipozona` DISABLE KEYS */;
INSERT INTO `tipozona` VALUES (1,'penthouse', 150000, 60000),(2,'familiar', 60000, 30000),(3,'comun', 40000, 20000),(4,'parejas', 20000, 15000);
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
 -- INSERT INTO `torre` VALUES (1,12,1);
/*!40000 ALTER TABLE `torre` ENABLE KEYS */;
UNLOCK TABLES;


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
INSERT INTO `apartamento`
 VALUES (101),(102),(103),(104),
(201),(202),(203),(204),
(301),(302),(303),(304),
(401),(402),(403),(404),
(501),(502),(503),(504),
(601),(602),(603),(604);
/*!40000 ALTER TABLE `apartamento` ENABLE KEYS */;
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
  `documento` varchar(10),
  KEY `ntorre` (`ntorre`),
  CONSTRAINT `torreapart_ibfk_1` FOREIGN KEY (`ntorre`) REFERENCES `torre` (`numero`),
  KEY `napartamento` (`napartamento`),
  CONSTRAINT `torreapart_ibfk_2` FOREIGN KEY (`napartamento`) REFERENCES `apartamento` (`numero`),
  KEY `documento` (`documento`),
  CONSTRAINT `torreapart_ibfk_3` FOREIGN KEY (`documento`) REFERENCES `persona` (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torreapart`
--

LOCK TABLES `torreapart` WRITE;
/*!40000 ALTER TABLE `torreapart` DISABLE KEYS */;
-- INSERT INTO `torreapart` VALUES (1,101,'si','si','1014293632');
-- INSERT INTO `torreapart` VALUES (1,102,'si','si','1014293632');
/*!40000 ALTER TABLE `torreapart` ENABLE KEYS */;
UNLOCK TABLES;

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
/*!40000 ALTER TABLE `parqueadero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parqueadero`
--

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitante`
--

LOCK TABLES `visitante` WRITE;
/*!40000 ALTER TABLE `visitante` DISABLE KEYS */;
/*!40000 ALTER TABLE `visitante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parqueadero`
--


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parqueadero`
--

LOCK TABLES `novedad` WRITE;
/*!40000 ALTER TABLE `novedad` DISABLE KEYS */;
/*!40000 ALTER TABLE `novedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parqueadero`
--



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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--



--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo` (
  `codigo` int(3) NOT NULL,
  `ntorre` int(3) NOT NULL,
  `napart` int(3) NOT NULL,
  `zona` varchar(15) NOT NULL,
  `costoadmin` float NOT NULL,
  `costoparq` float NOT NULL,
  `total` float NOT NULL,
  `documento` varchar(15) NOT NULL,
  `nombre` varchar(60) NOT NULL,
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
/*!40000 ALTER TABLE `recibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo`
--



-- vistas
create view loginpersona as select persona.documento, persona.nombre, persona.telefono, persona.nacimiento, persona.correo, tipo_usuario.nombre as tipo, sesion.usuario, sesion.contraseña as contraseña
from persona inner join sesion on persona.id_sesion = sesion.id inner join tipo_usuario on sesion.id_tipo = tipo_usuario.id;

create view inmueble as select torreapart.ntorre, torreapart.napartamento, torreapart.reside, torreapart.parqueadero, tipozona.nombre, tipozona.costoadmin, tipozona.costoparq from torreapart 
inner join torre on torreapart.ntorre = torre.numero inner join tipozona on torre.idzona = tipozona.id;

create view totaltorre as select torre.numero as numero, torre.naptos as naptos, tipozona.nombre as zona, torre.npuestos as puestos, tipozona.costoadmin+tipozona.costoparq as costo from torre inner join tipozona on torre.idzona = tipozona.id;

create view apartprop as select persona.documento, persona.nombre, persona.telefono, persona.nacimiento, persona.correo, torreapart.ntorre, torreapart.napartamento, torreapart.reside, torreapart.parqueadero from persona inner join torreapart on persona.documento = torreapart.documento;

create view novedadResid as select torreapart.ntorre, torreapart.napartamento, loginpersona.tipo, loginpersona.nombre, novedad.tiponovedad, novedad.detallenovedad from torreapart inner join loginpersona on torreapart.documento = loginpersona.documento
inner join novedad on loginpersona.documento=novedad.documento;

create view personalServicio as select persona.documento, persona.nombre, persona.telefono, persona.nacimiento, persona.correo, servicio.nombreserv, servicio.horario from persona inner join servicio on persona.documento=servicio.documento;
