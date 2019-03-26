CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`students` (
  `idstudents` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `cnp` VARCHAR(13) NOT NULL,
  PRIMARY KEY (`idstudents`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`exam` (
  `exams` INT NOT NULL AUTO_INCREMENT,
  `grades` INT NULL,
  `students_idstudents` INT NOT NULL,
  PRIMARY KEY (`exams`, `students_idstudents`),
 
    FOREIGN KEY (`students_idstudents`)
    REFERENCES `mydb`.`students` (`idstudents`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
CREATE TABLE IF NOT EXISTS `mydb`.`teachers` (
  `idteachers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `id_examteachersteachers_ibfk_1` INT NOT NULL,
  PRIMARY KEY (`idteachers`, `id_exam`),
 
    FOREIGN KEY (`id_exam`)
    REFERENCES `mydb`.`exam` (`exams`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;