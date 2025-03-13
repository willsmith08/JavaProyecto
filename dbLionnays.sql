-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dblayonnais
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dblayonnais
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dblayonnais` DEFAULT CHARACTER SET utf8mb3 ;
USE `dblayonnais` ;

-- -----------------------------------------------------
-- Table `dblayonnais`.`ciudad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dblayonnais`.`ciudad` (
  `idciudad` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idciudad`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `dblayonnais`.`pregustasdeseguridad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dblayonnais`.`pregustasdeseguridad` (
  `idpreguntasDeSeguridad` INT NOT NULL AUTO_INCREMENT,
  `preguntaDeSeguridad` LONGTEXT NOT NULL,
  PRIMARY KEY (`idpreguntasDeSeguridad`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `dblayonnais`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dblayonnais`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `correoElectronico` VARCHAR(45) NOT NULL,
  `suscripto` VARCHAR(45) NOT NULL,
  `direccionPrincipal` LONGTEXT NOT NULL,
  `direccionSecundaria` LONGTEXT NULL DEFAULT NULL,
  `ciudad_idciudad` INT NOT NULL,
  `pregustasDeSeguridad_idpregustasDeSeguridad` INT NOT NULL,
  `respuesta` LONGTEXT NOT NULL,
  PRIMARY KEY (`idusuario`),
  INDEX `fk_usuario_ciudad_idx` (`ciudad_idciudad` ASC) VISIBLE,
  INDEX `fk_usuario_pregustasDeSeguridad1_idx` (`pregustasDeSeguridad_idpregustasDeSeguridad` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_ciudad`
    FOREIGN KEY (`ciudad_idciudad`)
    REFERENCES `dblayonnais`.`ciudad` (`idciudad`),
  CONSTRAINT `fk_usuario_pregustasDeSeguridad1`
    FOREIGN KEY (`pregustasDeSeguridad_idpregustasDeSeguridad`)
    REFERENCES `dblayonnais`.`pregustasdeseguridad` (`idpreguntasDeSeguridad`))
ENGINE = InnoDB
AUTO_INCREMENT = 40
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `dblayonnais`.`entrega`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dblayonnais`.`entrega` (
  `identrega` INT NOT NULL AUTO_INCREMENT,
  `metodoEntrega` ENUM('DOMICILIO', 'RECOGIDO') NOT NULL,
  `fecha_hora` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario_idusuario` INT NOT NULL,
  PRIMARY KEY (`identrega`),
  INDEX `fk_entrega_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  CONSTRAINT `fk_entrega_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `dblayonnais`.`usuario` (`idusuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb3;

USE `dblayonnais` ;

-- -----------------------------------------------------
-- procedure CUD_usuario
-- -----------------------------------------------------

DELIMITER $$
USE `dblayonnais`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CUD_usuario`(
in opcion varchar(30),
ComprobanteCorreo varchar(45),
Nombre varchar(45),
Apellidos varchar(45),
Contrasena varchar(45),
CorreoElectronico varchar(45),
Susucripto varchar(45),
DireccionPrincipal longtext,
DireccionSecundaria longtext,
IdCiudad int,
IdPregunta int,
Respuesta longtext
)
begin
    case opcion
		when "update" then
			if ComprobanteCorreo in (select u.correoElectronico from usuario u) then
				update usuario u set 
					u.nombre = ifnull(Nombre, u.nombre),
                    u.apellidos = ifnull(Apellidos, u.apellidos),
                    u.correoElectronico = ifnull(CorreoElectronico, u.correoElectronico),
                    u.DireccionPrincipal = ifnull(DireccionPrincipal, u.direccionPrincipal),
                    u.DireccionSecundaria = ifnull(DireccionSecundaria, u.direccionSecundaria)
					where u.correoElectronico = ComprobanteCorreo;
			else
				select 'Error de actualizacion';
			end if;
        #-------------------------------------------------------------  
        
        when "insert" then
			insert into usuario (nombre,apellidos,contrasena,correoElectronico,
            suscripto,direccionPrincipal,direccionSecundaria,ciudad_idciudad,
            pregustasDeSeguridad_idpregustasDeSeguridad,respuesta) 
            
                value (Nombre,Apellidos,Contrasena,CorreoElectronico,
                Susucripto,DireccionPrincipal,DireccionSecundaria,IdCiudad,
                IdPregunta,Respuesta);
        #-------------------------------------------------------------    
		
       
       #eliminar
		when 'delete' then
			if ComprobanteCorreo in (select u.correoElectronico from usuario u) then
				delete from usuario where usuario.correoElectronico = ComprobanteCorreo;
			else
				select 'Error: Cliente no registrado';
			end if;
		#-------------------------------------------------------------
            
	end case;
end$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
