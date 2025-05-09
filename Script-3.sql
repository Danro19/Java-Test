CREATE DATABASE `SolucionesEficientes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- SolucionesEficientes.Asignacion definition

CREATE TABLE `Asignacion` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ID_Empleado` int NOT NULL,
  `ID_Proyecto` int NOT NULL,
  `HorasTrabajadas` int NOT NULL,
  `FechaAsignacion` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_Empleado` (`ID_Empleado`),
  KEY `ID_Proyecto` (`ID_Proyecto`),
  CONSTRAINT `Asignacion_ibfk_1` FOREIGN KEY (`ID_Empleado`) REFERENCES `Empleado` (`ID`),
  CONSTRAINT `Asignacion_ibfk_2` FOREIGN KEY (`ID_Proyecto`) REFERENCES `Proyecto` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- SolucionesEficientes.Cliente definition

CREATE TABLE `Cliente` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `representante` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `Sector` enum('Tecnologia','Salud','Educacion','Comercio','Manufactura') DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- SolucionesEficientes.Contrato definition

CREATE TABLE `Contrato` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `costoTotal` int NOT NULL,
  `estado` enum('Activo','En espera','Finalizado') DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- SolucionesEficientes.Empleado definition

CREATE TABLE `Empleado` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `Salario` int NOT NULL,
  `especialidad` enum('TI','Administracion','Limpieza','Seguridad') DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- SolucionesEficientes.Proyecto definition

CREATE TABLE `Proyecto` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `estado` enum('En curso','Completado','Cancelado') DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- SolucionesEficientes.Servicio definition

CREATE TABLE `Servicio` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `precioPorHora` int NOT NULL,
  `categoria` enum('TI','Limpieza','Seguridad','Administracion') DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- SolucionesEficientes.ClienteContrato definition

CREATE TABLE `ClienteContrato` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ID_Cliente` int NOT NULL,
  `ID_Contrato` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_Cliente` (`ID_Cliente`),
  KEY `ID_Contrato` (`ID_Contrato`),
  CONSTRAINT `ClienteContrato_ibfk_1` FOREIGN KEY (`ID_Cliente`) REFERENCES `Cliente` (`ID`),
  CONSTRAINT `ClienteContrato_ibfk_2` FOREIGN KEY (`ID_Contrato`) REFERENCES `Contrato` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- SolucionesEficientes.ClienteProyecto definition

CREATE TABLE `ClienteProyecto` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ID_Cliente` int NOT NULL,
  `ID_Proyecto` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_Cliente` (`ID_Cliente`),
  KEY `ID_Proyecto` (`ID_Proyecto`),
  CONSTRAINT `ClienteProyecto_ibfk_1` FOREIGN KEY (`ID_Cliente`) REFERENCES `Cliente` (`ID`),
  CONSTRAINT `ClienteProyecto_ibfk_2` FOREIGN KEY (`ID_Proyecto`) REFERENCES `Proyecto` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- SolucionesEficientes.ServicioContrato definition

CREATE TABLE `ServicioContrato` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ID_Servicio` int NOT NULL,
  `ID_Contrato` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_Servicio` (`ID_Servicio`),
  KEY `ID_Contrato` (`ID_Contrato`),
  CONSTRAINT `ServicioContrato_ibfk_1` FOREIGN KEY (`ID_Servicio`) REFERENCES `Servicio` (`ID`),
  CONSTRAINT `ServicioContrato_ibfk_2` FOREIGN KEY (`ID_Contrato`) REFERENCES `Contrato` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;