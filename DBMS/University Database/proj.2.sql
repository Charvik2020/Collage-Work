-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Program`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Program` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Program` (
  `Program_ID` INT NOT NULL COMMENT 'Program ID for Btech, Mtech, PhD',
  `Program_type` VARCHAR(45) NULL,
  PRIMARY KEY (`Program_ID`))
ENGINE = InnoDB
MAX_ROWS = 99;


-- -----------------------------------------------------
-- Table `mydb`.`Department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Department` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Department` (
  `Department_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Department ID for chemical, ICT, etc',
  `Department_type` VARCHAR(45) NULL,
  PRIMARY KEY (`Department_ID`))
ENGINE = InnoDB
MAX_ROWS = 999;


-- -----------------------------------------------------
-- Table `mydb`.`Dept_Prog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Dept_Prog` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Dept_Prog` (
  `Department_ID` INT NULL,
  `Program_ID` INT NULL,
  INDEX `fk_Dept_Prog_Program1_idx` (`Program_ID` ASC),
  INDEX `fk_Dept_Prog_Department_idx` (`Department_ID` ASC),
  CONSTRAINT `fk_Department_has_Program_Department`
    FOREIGN KEY (`Department_ID`)
    REFERENCES `mydb`.`Department` (`Department_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Department_has_Program_Program1`
    FOREIGN KEY (`Program_ID`)
    REFERENCES `mydb`.`Program` (`Program_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Courses` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Courses` (
  `Course_ID` VARCHAR(10) NOT NULL,
  `Course_name` VARCHAR(45) NOT NULL,
  `Credits` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`Course_ID`),
  UNIQUE INDEX `Course ID_UNIQUE` (`Course_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Courses_has_Department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Courses_has_Department` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Courses_has_Department` (
  `Courses_Course_ID` VARCHAR(10) NULL COMMENT 'Courses are in which department',
  `Department_Department_ID` INT NULL,
  `Elective` INT NOT NULL,
  INDEX `fk_Courses_has_Department_Department1_idx` (`Department_Department_ID` ASC),
  INDEX `fk_Courses_has_Department_Courses1_idx` (`Courses_Course_ID` ASC),
  CONSTRAINT `fk_Courses_has_Department_Courses1`
    FOREIGN KEY (`Courses_Course_ID`)
    REFERENCES `mydb`.`Courses` (`Course_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Courses_has_Department_Department1`
    FOREIGN KEY (`Department_Department_ID`)
    REFERENCES `mydb`.`Department` (`Department_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Semester`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Semester` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Semester` (
  `Semester_ID` INT NOT NULL COMMENT 'Semester ID for semester number 1,2,3,etc',
  `Semester_number` VARCHAR(45) NOT NULL COMMENT 'Cannot be greater than one specified by the degree',
  PRIMARY KEY (`Semester_ID`),
  UNIQUE INDEX `Semester ID_UNIQUE` (`Semester_ID` ASC))
ENGINE = InnoDB
MAX_ROWS = 10;


-- -----------------------------------------------------
-- Table `mydb`.`Offerings_Semester`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Offerings_Semester` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Offerings_Semester` (
  `Semester_O_ID` VARCHAR(10) NOT NULL COMMENT 'Various semester offerings for a particular semester',
  `Year` INT NOT NULL,
  `Start_date` DATE NOT NULL,
  `End_date` DATE NOT NULL,
  `Program_Program_ID` INT NULL,
  `Department_Department_ID` INT NULL,
  `Semester_Semester_ID` INT NULL,
  `SO_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Auto increment',
  PRIMARY KEY (`SO_ID`),
  INDEX `fk_Offerings Semester_Program1_idx` (`Program_Program_ID` ASC),
  INDEX `fk_Offerings Semester_Department1_idx` (`Department_Department_ID` ASC),
  INDEX `fk_Offerings Semester_Semester1_idx` (`Semester_Semester_ID` ASC),
  UNIQUE INDEX `SO ID_UNIQUE` (`SO_ID` ASC),
  CONSTRAINT `fk_Offerings Semester_Program1`
    FOREIGN KEY (`Program_Program_ID`)
    REFERENCES `mydb`.`Program` (`Program_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Offerings Semester_Department1`
    FOREIGN KEY (`Department_Department_ID`)
    REFERENCES `mydb`.`Department` (`Department_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Offerings Semester_Semester1`
    FOREIGN KEY (`Semester_Semester_ID`)
    REFERENCES `mydb`.`Semester` (`Semester_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Offerings_Semester_has_Courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Offerings_Semester_has_Courses` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Offerings_Semester_has_Courses` (
  `Courses_Course_ID` VARCHAR(10) NULL,
  `Offerings_Semester_SO_ID` INT NULL,
  INDEX `fk_Offerings Semester_has_Courses_Courses1_idx` (`Courses_Course_ID` ASC),
  INDEX `fk_Offerings Semester_has_Courses_Offerings Semester1_idx` (`Offerings_Semester_SO_ID` ASC),
  CONSTRAINT `fk_Offerings Semester_has_Courses_Courses1`
    FOREIGN KEY (`Courses_Course_ID`)
    REFERENCES `mydb`.`Courses` (`Course_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Offerings Semester_has_Courses_Offerings Semester1`
    FOREIGN KEY (`Offerings_Semester_SO_ID`)
    REFERENCES `mydb`.`Offerings_Semester` (`SO_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Faculty`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Faculty` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Faculty` (
  `Faculty_ID` VARCHAR(5) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(100) NOT NULL,
  `Date_of_birth` DATE NOT NULL,
  `Contact_number` VARCHAR(10) NOT NULL,
  `Email_ID` VARCHAR(25) NOT NULL,
  `Designation` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`Faculty_ID`),
  UNIQUE INDEX `Faculty ID_UNIQUE` (`Faculty_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Department_has_Faculty`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Department_has_Faculty` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Department_has_Faculty` (
  `Department_Department_ID` INT NULL,
  `Faculty_Faculty_ID` VARCHAR(5) NULL,
  `Program_Program_ID` INT NULL,
  `Date_of_joining` DATE NOT NULL COMMENT 'Date of joining the institute by the faculty\nJoining dates in different departments can be different',
  INDEX `fk_Department_has_Faculty_Department1_idx` (`Department_Department_ID` ASC),
  INDEX `fk_Department_has_Faculty_Program1_idx` (`Program_Program_ID` ASC),
  CONSTRAINT `fk_Department_has_Faculty_Department1`
    FOREIGN KEY (`Department_Department_ID`)
    REFERENCES `mydb`.`Department` (`Department_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Department_has_Faculty_Program1`
    FOREIGN KEY (`Program_Program_ID`)
    REFERENCES `mydb`.`Program` (`Program_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Teaching_Assistants`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Teaching_Assistants` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Teaching_Assistants` (
  `TA_ID` INT NOT NULL,
  `Faculty_Faculty_ID` VARCHAR(5) NULL,
  UNIQUE INDEX `TA ID_UNIQUE` (`TA_ID` ASC),
  INDEX `fk_Teaching Assistants_Faculty1_idx` (`Faculty_Faculty_ID` ASC),
  PRIMARY KEY (`TA_ID`),
  CONSTRAINT `fk_Teaching Assistants_Faculty1`
    FOREIGN KEY (`Faculty_Faculty_ID`)
    REFERENCES `mydb`.`Faculty` (`Faculty_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Class`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Class` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Class` (
  `Class_ID` INT NOT NULL COMMENT 'Class room allocated for various classes',
  `Title` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`Class_ID`),
  UNIQUE INDEX `Class ID_UNIQUE` (`Class_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Quizzes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Quizzes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Quizzes` (
  `Quiz_ID` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `total_marks` INT NOT NULL COMMENT 'Should not be greater than 100%',
  `Class_Class_ID` INT NULL,
  `weightage` INT NOT NULL COMMENT 'in percntage %',
  `Start_Time` TIME NOT NULL,
  `End_Time` TIME NOT NULL,
  PRIMARY KEY (`Quiz_ID`),
  INDEX `fk_Quizzes_Class1_idx` (`Class_Class_ID` ASC),
  UNIQUE INDEX `Quiz ID_UNIQUE` (`Quiz_ID` ASC),
  CONSTRAINT `fk_Quizzes_Class1`
    FOREIGN KEY (`Class_Class_ID`)
    REFERENCES `mydb`.`Class` (`Class_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Exams`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Exams` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Exams` (
  `Exam_ID` INT NOT NULL AUTO_INCREMENT,
  `start_time` TIME NOT NULL,
  `Date` DATE NOT NULL,
  `marks` INT NOT NULL,
  `end_time` TIME NOT NULL,
  `Class_Class_ID` INT NULL,
  `weightage` INT NOT NULL,
  `exam_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Exam_ID`),
  INDEX `fk_Exams_Class1_idx` (`Class_Class_ID` ASC),
  UNIQUE INDEX `Exam ID_UNIQUE` (`Exam_ID` ASC),
  CONSTRAINT `fk_Exams_Class1`
    FOREIGN KEY (`Class_Class_ID`)
    REFERENCES `mydb`.`Class` (`Class_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Assignments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Assignments` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Assignments` (
  `Assignment_ID` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `Total_marks` INT NOT NULL COMMENT 'Maximum attainable marks',
  `Link` VARCHAR(100) NOT NULL,
  `weightage` INT NOT NULL,
  PRIMARY KEY (`Assignment_ID`),
  UNIQUE INDEX `Assignment ID_UNIQUE` (`Assignment_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Student` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Student` (
  `Address` VARCHAR(100) NOT NULL COMMENT 'Should follow legal syntax',
  `D_O_B` DATE NOT NULL,
  `Contact_number` VARCHAR(15) NOT NULL COMMENT 'Cannot be greater than 12',
  `Email_ID` VARCHAR(25) NOT NULL COMMENT 'Should follow legal syntax',
  `First_Name` VARCHAR(45) NOT NULL,
  `Middle_name` VARCHAR(45) NOT NULL,
  `Last_Name` VARCHAR(45) NOT NULL,
  `Student_ID` VARCHAR(10) NOT NULL COMMENT 'YY PP DDD S RR',
  PRIMARY KEY (`Student_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Project` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Project` (
  `Project_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Academic projects',
  `Total_marks` INT NOT NULL COMMENT 'Maximum attainable marks',
  `Deadline` DATE NOT NULL,
  `weightage` INT NOT NULL,
  `Date_of_Allocation` DATE NOT NULL,
  `Faculty_Faculty_ID` VARCHAR(5) NULL,
  PRIMARY KEY (`Project_ID`),
  UNIQUE INDEX `Project ID_UNIQUE` (`Project_ID` ASC),
  INDEX `fk_Project_Faculty1_idx` (`Faculty_Faculty_ID` ASC),
  CONSTRAINT `fk_Project_Faculty1`
    FOREIGN KEY (`Faculty_Faculty_ID`)
    REFERENCES `mydb`.`Faculty` (`Faculty_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Project_has_Topics`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Project_has_Topics` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Project_has_Topics` (
  `Project_Project_ID` INT NULL,
  `Project_Title` VARCHAR(50) NOT NULL,
  `Internal_Project_ID` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_Project_has_Topics_Project1_idx` (`Project_Project_ID` ASC),
  PRIMARY KEY (`Internal_Project_ID`),
  CONSTRAINT `fk_Project_has_Topics_Project1`
    FOREIGN KEY (`Project_Project_ID`)
    REFERENCES `mydb`.`Project` (`Project_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Project_has_Student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Project_has_Student` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Project_has_Student` (
  `Student_Student_ID` VARCHAR(10) NULL,
  `Marks` INT NOT NULL,
  `Project_has_Topics_Internal_Project_ID` INT NULL,
  INDEX `fk_Project_has_Student_Student1_idx` (`Student_Student_ID` ASC),
  INDEX `fk_Project_has_Student_Project_has_Topics1_idx` (`Project_has_Topics_Internal_Project_ID` ASC),
  CONSTRAINT `fk_Project_has_Student_Student1`
    FOREIGN KEY (`Student_Student_ID`)
    REFERENCES `mydb`.`Student` (`Student_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Project_has_Student_Project_has_Topics1`
    FOREIGN KEY (`Project_has_Topics_Internal_Project_ID`)
    REFERENCES `mydb`.`Project_has_Topics` (`Internal_Project_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Department_has_Student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Department_has_Student` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Department_has_Student` (
  `Department_Department_ID` INT NULL COMMENT 'Students are in which department',
  `Student_Student_ID` VARCHAR(10) NULL,
  `Program_Program_ID` INT NULL,
  `Date_of_joining` DATE NOT NULL,
  INDEX `fk_Department_has_Student_Student1_idx` (`Student_Student_ID` ASC),
  INDEX `fk_Department_has_Student_Program1_idx` (`Program_Program_ID` ASC),
  INDEX `fk_Department_has_Student_Department1_idx` (`Department_Department_ID` ASC),
  CONSTRAINT `fk_Department_has_Student_Department1`
    FOREIGN KEY (`Department_Department_ID`)
    REFERENCES `mydb`.`Department` (`Department_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Department_has_Student_Student1`
    FOREIGN KEY (`Student_Student_ID`)
    REFERENCES `mydb`.`Student` (`Student_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Department_has_Student_Program1`
    FOREIGN KEY (`Program_Program_ID`)
    REFERENCES `mydb`.`Program` (`Program_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Student_has_Quizzes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Student_has_Quizzes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Student_has_Quizzes` (
  `Student_Student_ID` VARCHAR(10) NULL,
  `Quizzes_Quiz_ID` INT NULL,
  `Marks` INT NOT NULL COMMENT 'Should be lesser than or equal to 100%',
  INDEX `fk_Student_has_Quizzes_Quizzes1_idx` (`Quizzes_Quiz_ID` ASC),
  INDEX `fk_Student_has_Quizzes_Student1_idx` (`Student_Student_ID` ASC),
  CONSTRAINT `fk_Student_has_Quizzes_Student1`
    FOREIGN KEY (`Student_Student_ID`)
    REFERENCES `mydb`.`Student` (`Student_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Student_has_Quizzes_Quizzes1`
    FOREIGN KEY (`Quizzes_Quiz_ID`)
    REFERENCES `mydb`.`Quizzes` (`Quiz_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Student_has_Assignments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Student_has_Assignments` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Student_has_Assignments` (
  `Student_Student_ID` VARCHAR(10) NULL,
  `Assignments_Assignment_ID` INT NULL,
  `Marks` INT NOT NULL COMMENT 'Should be lesser than or equal to 100%',
  INDEX `fk_Student_has_Assignments_Assignments1_idx` (`Assignments_Assignment_ID` ASC),
  INDEX `fk_Student_has_Assignments_Student1_idx` (`Student_Student_ID` ASC),
  CONSTRAINT `fk_Student_has_Assignments_Student1`
    FOREIGN KEY (`Student_Student_ID`)
    REFERENCES `mydb`.`Student` (`Student_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Student_has_Assignments_Assignments1`
    FOREIGN KEY (`Assignments_Assignment_ID`)
    REFERENCES `mydb`.`Assignments` (`Assignment_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Course_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Course_type` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Course_type` (
  `Course_Type_ID` VARCHAR(10) NOT NULL,
  `Type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Course_Type_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Courses_has_Course_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Courses_has_Course_type` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Courses_has_Course_type` (
  `Courses_Course_ID` VARCHAR(10) NULL,
  `Course_type_Course_Type_ID` VARCHAR(10) NULL,
  INDEX `fk_Courses_has_Course type_Course type1_idx` (`Course_type_Course_Type_ID` ASC),
  INDEX `fk_Courses_has_Course type_Courses1_idx` (`Courses_Course_ID` ASC),
  CONSTRAINT `fk_Courses_has_Course type_Courses1`
    FOREIGN KEY (`Courses_Course_ID`)
    REFERENCES `mydb`.`Courses` (`Course_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Courses_has_Course type_Course type1`
    FOREIGN KEY (`Course_type_Course_Type_ID`)
    REFERENCES `mydb`.`Course_type` (`Course_Type_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Grade_Points`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Grade_Points` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Grade_Points` (
  `Grade` VARCHAR(2) NOT NULL,
  `Grade_Point` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`Grade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Grades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Grades` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Grades` (
  `Student_Student_ID` VARCHAR(10) NULL,
  `Grade_Points_Grade` VARCHAR(2) NULL,
  INDEX `fk_Grades_Student1_idx` (`Student_Student_ID` ASC),
  INDEX `fk_Grades_Grade Points1_idx` (`Grade_Points_Grade` ASC),
  CONSTRAINT `fk_Grades_Student1`
    FOREIGN KEY (`Student_Student_ID`)
    REFERENCES `mydb`.`Student` (`Student_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Grades_Grade Points1`
    FOREIGN KEY (`Grade_Points_Grade`)
    REFERENCES `mydb`.`Grade_Points` (`Grade`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Research_Projects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Research_Projects` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Research_Projects` (
  `Research_ID` INT NOT NULL COMMENT 'Research details and status',
  `Title` VARCHAR(100) NOT NULL,
  `Deadline` DATE NOT NULL,
  `objective` VARCHAR(150) NOT NULL,
  `Status` VARCHAR(30) NOT NULL,
  `Start_date` DATE NOT NULL,
  PRIMARY KEY (`Research_ID`),
  UNIQUE INDEX `Research ID_UNIQUE` (`Research_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Research_Topics`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Research_Topics` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Research_Topics` (
  `R_topic_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'research topics for research projects',
  `title` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`R_topic_ID`),
  UNIQUE INDEX `R topic ID_UNIQUE` (`R_topic_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Research_Projects_has_Research_Topics`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Research_Projects_has_Research_Topics` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Research_Projects_has_Research_Topics` (
  `Research_Projects_Research_ID` INT NULL,
  `Research_Topics_R_topic_ID` INT NULL,
  INDEX `fk_Research Projects_has_Research Topics_Research Topics1_idx` (`Research_Topics_R_topic_ID` ASC),
  INDEX `fk_Research Projects_has_Research Topics_Research Projects1_idx` (`Research_Projects_Research_ID` ASC),
  CONSTRAINT `fk_Research Projects_has_Research Topics_Research Projects1`
    FOREIGN KEY (`Research_Projects_Research_ID`)
    REFERENCES `mydb`.`Research_Projects` (`Research_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Research Projects_has_Research Topics_Research Topics1`
    FOREIGN KEY (`Research_Topics_R_topic_ID`)
    REFERENCES `mydb`.`Research_Topics` (`R_topic_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Research_Projects_has_Student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Research_Projects_has_Student` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Research_Projects_has_Student` (
  `Research_Projects_Research_ID` INT NULL,
  `Student_Student_ID` VARCHAR(10) NULL,
  INDEX `fk_Research Projects_has_Student_Student1_idx` (`Student_Student_ID` ASC),
  INDEX `fk_Research Projects_has_Student_Research Projects1_idx` (`Research_Projects_Research_ID` ASC),
  CONSTRAINT `fk_Research Projects_has_Student_Research Projects1`
    FOREIGN KEY (`Research_Projects_Research_ID`)
    REFERENCES `mydb`.`Research_Projects` (`Research_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Research Projects_has_Student_Student1`
    FOREIGN KEY (`Student_Student_ID`)
    REFERENCES `mydb`.`Student` (`Student_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Research_Projects_has_Faculty`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Research_Projects_has_Faculty` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Research_Projects_has_Faculty` (
  `Research_Projects_Research_ID` INT NULL,
  `Faculty_Faculty_ID` VARCHAR(5) NULL,
  INDEX `fk_Research Projects_has_Faculty_Faculty1_idx` (`Faculty_Faculty_ID` ASC),
  INDEX `fk_Research Projects_has_Faculty_Research Projects1_idx` (`Research_Projects_Research_ID` ASC),
  CONSTRAINT `fk_Research Projects_has_Faculty_Research Projects1`
    FOREIGN KEY (`Research_Projects_Research_ID`)
    REFERENCES `mydb`.`Research_Projects` (`Research_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Research Projects_has_Faculty_Faculty1`
    FOREIGN KEY (`Faculty_Faculty_ID`)
    REFERENCES `mydb`.`Faculty` (`Faculty_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Time_Schedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Time_Schedule` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Time_Schedule` (
  `Start_time` TIME NOT NULL,
  `End_time` TIME NOT NULL,
  `Day` VARCHAR(9) NOT NULL,
  `Class_Class_ID` INT NULL,
  INDEX `fk_Time Schedule_Class1_idx` (`Class_Class_ID` ASC),
  CONSTRAINT `fk_Time Schedule_Class1`
    FOREIGN KEY (`Class_Class_ID`)
    REFERENCES `mydb`.`Class` (`Class_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Student_has_Exams`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Student_has_Exams` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Student_has_Exams` (
  `Student_Student_ID` VARCHAR(10) NULL COMMENT 'Student appears for various exams',
  `Exams_Exam_ID` INT NULL,
  `Marks` INT NOT NULL COMMENT 'Should be lesser than or equal to 100%',
  INDEX `fk_Student_has_Exams1_Exams1_idx` (`Exams_Exam_ID` ASC),
  INDEX `fk_Student_has_Exams1_Student1_idx` (`Student_Student_ID` ASC),
  CONSTRAINT `fk_Student_has_Exams1_Student1`
    FOREIGN KEY (`Student_Student_ID`)
    REFERENCES `mydb`.`Student` (`Student_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Student_has_Exams1_Exams1`
    FOREIGN KEY (`Exams_Exam_ID`)
    REFERENCES `mydb`.`Exams` (`Exam_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Research_Projects_has_Paper`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Research_Projects_has_Paper` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Research_Projects_has_Paper` (
  `Research_Projects_Research_ID` INT NULL,
  `Paper_Paper_ID` INT NULL,
  INDEX `fk_Research Projects_has_Paper_Research Projects1_idx` (`Research_Projects_Research_ID` ASC),
  CONSTRAINT `fk_Research Projects_has_Paper_Research Projects1`
    FOREIGN KEY (`Research_Projects_Research_ID`)
    REFERENCES `mydb`.`Research_Projects` (`Research_ID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`Program`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Program` (`Program_ID`, `Program_type`) VALUES (01, 'Btech');
INSERT INTO `mydb`.`Program` (`Program_ID`, `Program_type`) VALUES (02, 'Mtech');
INSERT INTO `mydb`.`Program` (`Program_ID`, `Program_type`) VALUES (03, 'Phd');
INSERT INTO `mydb`.`Program` (`Program_ID`, `Program_type`) VALUES (04, 'BBA');
INSERT INTO `mydb`.`Program` (`Program_ID`, `Program_type`) VALUES (05, 'MBA');
INSERT INTO `mydb`.`Program` (`Program_ID`, `Program_type`) VALUES (06, 'MCom');
INSERT INTO `mydb`.`Program` (`Program_ID`, `Program_type`) VALUES (07, 'BCom');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Department`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Department` (`Department_ID`, `Department_type`) VALUES (001, 'ICT');
INSERT INTO `mydb`.`Department` (`Department_ID`, `Department_type`) VALUES (002, 'Mechanical');
INSERT INTO `mydb`.`Department` (`Department_ID`, `Department_type`) VALUES (003, 'Chemical');
INSERT INTO `mydb`.`Department` (`Department_ID`, `Department_type`) VALUES (004, 'Physics');
INSERT INTO `mydb`.`Department` (`Department_ID`, `Department_type`) VALUES (005, 'Chemistry');
INSERT INTO `mydb`.`Department` (`Department_ID`, `Department_type`) VALUES (006, 'Maths');
INSERT INTO `mydb`.`Department` (`Department_ID`, `Department_type`) VALUES (007, 'Medical');
INSERT INTO `mydb`.`Department` (`Department_ID`, `Department_type`) VALUES (008, 'Computer Science');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Dept_Prog`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Dept_Prog` (`Department_ID`, `Program_ID`) VALUES (001, 01);
INSERT INTO `mydb`.`Dept_Prog` (`Department_ID`, `Program_ID`) VALUES (001, 02);
INSERT INTO `mydb`.`Dept_Prog` (`Department_ID`, `Program_ID`) VALUES (001, 03);
INSERT INTO `mydb`.`Dept_Prog` (`Department_ID`, `Program_ID`) VALUES (004, 01);
INSERT INTO `mydb`.`Dept_Prog` (`Department_ID`, `Program_ID`) VALUES (002, 01);
INSERT INTO `mydb`.`Dept_Prog` (`Department_ID`, `Program_ID`) VALUES (003, 02);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Courses`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Courses` (`Course_ID`, `Course_name`, `Credits`) VALUES ('CS101', 'Introduction to Computer Programing', '3');
INSERT INTO `mydb`.`Courses` (`Course_ID`, `Course_name`, `Credits`) VALUES ('CS101L', 'Introduction to Computer Programing lab', '1.5');
INSERT INTO `mydb`.`Courses` (`Course_ID`, `Course_name`, `Credits`) VALUES ('CS102', 'Object oriented programming ', '3');
INSERT INTO `mydb`.`Courses` (`Course_ID`, `Course_name`, `Credits`) VALUES ('CS102L', 'Object oriented programming lab', '1.5');
INSERT INTO `mydb`.`Courses` (`Course_ID`, `Course_name`, `Credits`) VALUES ('EE101', 'Basic electronic circuits', '3');
INSERT INTO `mydb`.`Courses` (`Course_ID`, `Course_name`, `Credits`) VALUES ('ECO01', 'Economics', '4');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Courses_has_Department`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Courses_has_Department` (`Courses_Course_ID`, `Department_Department_ID`, `Elective`) VALUES ('CS101', 001, 0);
INSERT INTO `mydb`.`Courses_has_Department` (`Courses_Course_ID`, `Department_Department_ID`, `Elective`) VALUES ('CS101L', 001, 0);
INSERT INTO `mydb`.`Courses_has_Department` (`Courses_Course_ID`, `Department_Department_ID`, `Elective`) VALUES ('CS101', 008, 1);
INSERT INTO `mydb`.`Courses_has_Department` (`Courses_Course_ID`, `Department_Department_ID`, `Elective`) VALUES ('EE101', 001, 0);
INSERT INTO `mydb`.`Courses_has_Department` (`Courses_Course_ID`, `Department_Department_ID`, `Elective`) VALUES ('ECO01', 001, 1);
INSERT INTO `mydb`.`Courses_has_Department` (`Courses_Course_ID`, `Department_Department_ID`, `Elective`) VALUES ('ECO01', 002, 1);
INSERT INTO `mydb`.`Courses_has_Department` (`Courses_Course_ID`, `Department_Department_ID`, `Elective`) VALUES ('ECO01', 003, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Semester`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Semester` (`Semester_ID`, `Semester_number`) VALUES (01, 'First Sem');
INSERT INTO `mydb`.`Semester` (`Semester_ID`, `Semester_number`) VALUES (02, 'Second Sem');
INSERT INTO `mydb`.`Semester` (`Semester_ID`, `Semester_number`) VALUES (03, 'Third Sem');
INSERT INTO `mydb`.`Semester` (`Semester_ID`, `Semester_number`) VALUES (04, 'Fourth Sem');
INSERT INTO `mydb`.`Semester` (`Semester_ID`, `Semester_number`) VALUES (05, 'Fifth Sem');
INSERT INTO `mydb`.`Semester` (`Semester_ID`, `Semester_number`) VALUES (06, 'Sixth Sem');
INSERT INTO `mydb`.`Semester` (`Semester_ID`, `Semester_number`) VALUES (07, 'Seventh Sem');
INSERT INTO `mydb`.`Semester` (`Semester_ID`, `Semester_number`) VALUES (08, 'Eight Sem');
INSERT INTO `mydb`.`Semester` (`Semester_ID`, `Semester_number`) VALUES (09, 'Ninth Sem');
INSERT INTO `mydb`.`Semester` (`Semester_ID`, `Semester_number`) VALUES (10, 'Tenth Sem');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Offerings_Semester`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Offerings_Semester` (`Semester_O_ID`, `Year`, `Start_date`, `End_date`, `Program_Program_ID`, `Department_Department_ID`, `Semester_Semester_ID`, `SO_ID`) VALUES ('AUT', 2014, '2014-07-28', '2014-12-05', 01, 001, 01, 1);
INSERT INTO `mydb`.`Offerings_Semester` (`Semester_O_ID`, `Year`, `Start_date`, `End_date`, `Program_Program_ID`, `Department_Department_ID`, `Semester_Semester_ID`, `SO_ID`) VALUES ('AUT', 2014, '2014-07-07', '2014-11-05', 01, 001, 03, 2);
INSERT INTO `mydb`.`Offerings_Semester` (`Semester_O_ID`, `Year`, `Start_date`, `End_date`, `Program_Program_ID`, `Department_Department_ID`, `Semester_Semester_ID`, `SO_ID`) VALUES ('AUT', 2014, '2014-07-02', '2014-11-02', 01, 001, 05, 3);
INSERT INTO `mydb`.`Offerings_Semester` (`Semester_O_ID`, `Year`, `Start_date`, `End_date`, `Program_Program_ID`, `Department_Department_ID`, `Semester_Semester_ID`, `SO_ID`) VALUES ('AUT', 2014, '2014-07-02', '2014-11-02', 01, 001, 07, 4);
INSERT INTO `mydb`.`Offerings_Semester` (`Semester_O_ID`, `Year`, `Start_date`, `End_date`, `Program_Program_ID`, `Department_Department_ID`, `Semester_Semester_ID`, `SO_ID`) VALUES ('AUT', 2014, '2014-07-28', '2014-12-05', 01, 002, 01, 5);
INSERT INTO `mydb`.`Offerings_Semester` (`Semester_O_ID`, `Year`, `Start_date`, `End_date`, `Program_Program_ID`, `Department_Department_ID`, `Semester_Semester_ID`, `SO_ID`) VALUES ('MON', 2014, '2015-01-02', '2015-04-02', 01, 001, 02, 6);
INSERT INTO `mydb`.`Offerings_Semester` (`Semester_O_ID`, `Year`, `Start_date`, `End_date`, `Program_Program_ID`, `Department_Department_ID`, `Semester_Semester_ID`, `SO_ID`) VALUES ('MON', 2014, '2015-01-02', '2015-04-02', 01, 001, 04, 7);
INSERT INTO `mydb`.`Offerings_Semester` (`Semester_O_ID`, `Year`, `Start_date`, `End_date`, `Program_Program_ID`, `Department_Department_ID`, `Semester_Semester_ID`, `SO_ID`) VALUES ('MON', 2014, '2015-01-02', '2015-04-02', 01, 001, 06, 8);
INSERT INTO `mydb`.`Offerings_Semester` (`Semester_O_ID`, `Year`, `Start_date`, `End_date`, `Program_Program_ID`, `Department_Department_ID`, `Semester_Semester_ID`, `SO_ID`) VALUES ('MON', 2014, '2015-01-05', '2015-04-02', 01, 001, 08, 9);
INSERT INTO `mydb`.`Offerings_Semester` (`Semester_O_ID`, `Year`, `Start_date`, `End_date`, `Program_Program_ID`, `Department_Department_ID`, `Semester_Semester_ID`, `SO_ID`) VALUES ('MON', 2014, '2015-01-05', '2015-04-02', 01, 002, 02, 10);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Offerings_Semester_has_Courses`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Offerings_Semester_has_Courses` (`Courses_Course_ID`, `Offerings_Semester_SO_ID`) VALUES ('CS101', 1);
INSERT INTO `mydb`.`Offerings_Semester_has_Courses` (`Courses_Course_ID`, `Offerings_Semester_SO_ID`) VALUES ('CS101L', 1);
INSERT INTO `mydb`.`Offerings_Semester_has_Courses` (`Courses_Course_ID`, `Offerings_Semester_SO_ID`) VALUES ('EE101', 1);
INSERT INTO `mydb`.`Offerings_Semester_has_Courses` (`Courses_Course_ID`, `Offerings_Semester_SO_ID`) VALUES ('CS102', 2);
INSERT INTO `mydb`.`Offerings_Semester_has_Courses` (`Courses_Course_ID`, `Offerings_Semester_SO_ID`) VALUES ('CS102L', 2);
INSERT INTO `mydb`.`Offerings_Semester_has_Courses` (`Courses_Course_ID`, `Offerings_Semester_SO_ID`) VALUES ('ECO01', 2);
INSERT INTO `mydb`.`Offerings_Semester_has_Courses` (`Courses_Course_ID`, `Offerings_Semester_SO_ID`) VALUES ('ECO01', 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Faculty`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Faculty` (`Faculty_ID`, `Name`, `Address`, `Date_of_birth`, `Contact_number`, `Email_ID`, `Designation`) VALUES ('12001', 'Manish Jariwala', 'Ahmedabad', '1970-01-26', '9408282828', 'manishj@gmail.com', 'Senior Faculty');
INSERT INTO `mydb`.`Faculty` (`Faculty_ID`, `Name`, `Address`, `Date_of_birth`, `Contact_number`, `Email_ID`, `Designation`) VALUES ('12002', 'Dinesh Dave', 'Surat', '1965-05-19', '9899110922', 'dinesh.dave@gmail.com', 'Visiting');
INSERT INTO `mydb`.`Faculty` (`Faculty_ID`, `Name`, `Address`, `Date_of_birth`, `Contact_number`, `Email_ID`, `Designation`) VALUES ('13001', 'Manohar Daruwala', 'Ahmedabad', '1960-07-07', '9983929934', 'm.daru@hotmail.com', 'Associate professor');
INSERT INTO `mydb`.`Faculty` (`Faculty_ID`, `Name`, `Address`, `Date_of_birth`, `Contact_number`, `Email_ID`, `Designation`) VALUES ('14001', 'Rohan Patel', 'Rajkot', '1975-08-08', '9889959595', 'rohan.patel@gmail.com', 'Staff Engineer');
INSERT INTO `mydb`.`Faculty` (`Faculty_ID`, `Name`, `Address`, `Date_of_birth`, `Contact_number`, `Email_ID`, `Designation`) VALUES ('14002', 'Manish Paul', 'Bardoli', '1970-09-06', '9885948822', 'manishh.paul@gmail.com', 'Lecturer');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Department_has_Faculty`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Department_has_Faculty` (`Department_Department_ID`, `Faculty_Faculty_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '13001', 02, '2013-06-07');
INSERT INTO `mydb`.`Department_has_Faculty` (`Department_Department_ID`, `Faculty_Faculty_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '12001', 01, '2012-05-06');
INSERT INTO `mydb`.`Department_has_Faculty` (`Department_Department_ID`, `Faculty_Faculty_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (002, '12002', 01, '2012-04-02');
INSERT INTO `mydb`.`Department_has_Faculty` (`Department_Department_ID`, `Faculty_Faculty_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (002, '14001', 02, '2014-01-12');
INSERT INTO `mydb`.`Department_has_Faculty` (`Department_Department_ID`, `Faculty_Faculty_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (008, '12001', 02, '2013-07-08');
INSERT INTO `mydb`.`Department_has_Faculty` (`Department_Department_ID`, `Faculty_Faculty_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (003, '14002', 03, '2014-02-23');
INSERT INTO `mydb`.`Department_has_Faculty` (`Department_Department_ID`, `Faculty_Faculty_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (004, '14001', 04, '2014-01-22');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Teaching_Assistants`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Teaching_Assistants` (`TA_ID`, `Faculty_Faculty_ID`) VALUES (1001, '14001');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Class`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Class` (`Class_ID`, `Title`) VALUES (001, 'Admin Office');
INSERT INTO `mydb`.`Class` (`Class_ID`, `Title`) VALUES (002, 'Library');
INSERT INTO `mydb`.`Class` (`Class_ID`, `Title`) VALUES (003, 'Library');
INSERT INTO `mydb`.`Class` (`Class_ID`, `Title`) VALUES (101, 'Classroom-1 ');
INSERT INTO `mydb`.`Class` (`Class_ID`, `Title`) VALUES (102, 'Classroom-2');
INSERT INTO `mydb`.`Class` (`Class_ID`, `Title`) VALUES (103, 'Classroom-3');
INSERT INTO `mydb`.`Class` (`Class_ID`, `Title`) VALUES (104, 'Electronics Lab');
INSERT INTO `mydb`.`Class` (`Class_ID`, `Title`) VALUES (105, 'Computer Lab');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Quizzes`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Quizzes` (`Quiz_ID`, `Date`, `total_marks`, `Class_Class_ID`, `weightage`, `Start_Time`, `End_Time`) VALUES (1, '2014-08-03', 30, 101, 5, '14:00', '15:00');
INSERT INTO `mydb`.`Quizzes` (`Quiz_ID`, `Date`, `total_marks`, `Class_Class_ID`, `weightage`, `Start_Time`, `End_Time`) VALUES (2, '2014-08-03', 20, 102, 5, '14:00', '14:30');
INSERT INTO `mydb`.`Quizzes` (`Quiz_ID`, `Date`, `total_marks`, `Class_Class_ID`, `weightage`, `Start_Time`, `End_Time`) VALUES (3, '2014-08-25', 56, 101, 10, '15:00', '16:30');
INSERT INTO `mydb`.`Quizzes` (`Quiz_ID`, `Date`, `total_marks`, `Class_Class_ID`, `weightage`, `Start_Time`, `End_Time`) VALUES (4, '2014-08-25', 20, 101, 5, '09:00', '9:30');
INSERT INTO `mydb`.`Quizzes` (`Quiz_ID`, `Date`, `total_marks`, `Class_Class_ID`, `weightage`, `Start_Time`, `End_Time`) VALUES (5, '2014-09-14', 30, 103, 5, '11:00', '12:00');
INSERT INTO `mydb`.`Quizzes` (`Quiz_ID`, `Date`, `total_marks`, `Class_Class_ID`, `weightage`, `Start_Time`, `End_Time`) VALUES (6, '2014-10-10', 25, 103, 10, '11:30', '12:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Exams`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Exams` (`Exam_ID`, `start_time`, `Date`, `marks`, `end_time`, `Class_Class_ID`, `weightage`, `exam_type`) VALUES (1, '09:00', '2014-09-18', 50, '12:00', 101, 30, 'MID');
INSERT INTO `mydb`.`Exams` (`Exam_ID`, `start_time`, `Date`, `marks`, `end_time`, `Class_Class_ID`, `weightage`, `exam_type`) VALUES (2, '09:00', '2014-09-17', 50, '12:00', 102, 20, 'MID');
INSERT INTO `mydb`.`Exams` (`Exam_ID`, `start_time`, `Date`, `marks`, `end_time`, `Class_Class_ID`, `weightage`, `exam_type`) VALUES (3, '09:00', '2014-11-25', 40, '12:00', 103, 20, 'FINAL');
INSERT INTO `mydb`.`Exams` (`Exam_ID`, `start_time`, `Date`, `marks`, `end_time`, `Class_Class_ID`, `weightage`, `exam_type`) VALUES (4, '09:00', '2014-12-2', 50, '12:00', 101, 30, 'FINAL');
INSERT INTO `mydb`.`Exams` (`Exam_ID`, `start_time`, `Date`, `marks`, `end_time`, `Class_Class_ID`, `weightage`, `exam_type`) VALUES (5, '09:00', '2014-09-22', 60, '11:00', 102, 10, 'MID');
INSERT INTO `mydb`.`Exams` (`Exam_ID`, `start_time`, `Date`, `marks`, `end_time`, `Class_Class_ID`, `weightage`, `exam_type`) VALUES (6, '09:00', '2014-12-9', 100, '11:00', 103, 30, 'FINAL');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Assignments`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Assignments` (`Assignment_ID`, `Date`, `Total_marks`, `Link`, `weightage`) VALUES (1, '2014-07-25', 20, 'Network\\Server\\AS1', 2);
INSERT INTO `mydb`.`Assignments` (`Assignment_ID`, `Date`, `Total_marks`, `Link`, `weightage`) VALUES (2, '2014-08-11', 15, 'Network\\Server\\AS2', 3);
INSERT INTO `mydb`.`Assignments` (`Assignment_ID`, `Date`, `Total_marks`, `Link`, `weightage`) VALUES (3, '2014-08-23', 15, 'Network\\Server\\AS3', 5);
INSERT INTO `mydb`.`Assignments` (`Assignment_ID`, `Date`, `Total_marks`, `Link`, `weightage`) VALUES (4, '2014-08-27', 25, 'Network\\Server\\AS4', 5);
INSERT INTO `mydb`.`Assignments` (`Assignment_ID`, `Date`, `Total_marks`, `Link`, `weightage`) VALUES (5, '2014-09-07', 20, 'Network\\Server\\AS5', 5);
INSERT INTO `mydb`.`Assignments` (`Assignment_ID`, `Date`, `Total_marks`, `Link`, `weightage`) VALUES (6, '2014-09-22', 15, 'Network\\Server\\AS6', 5);
INSERT INTO `mydb`.`Assignments` (`Assignment_ID`, `Date`, `Total_marks`, `Link`, `weightage`) VALUES (7, '2014-10-07', 25, 'Network\\Server\\AS7', 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Student`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Ahmedabad', '1996-01-23', '9876543210', 'axar.patel@gmail.com', 'Axar', 'Raghav', 'Patel', '1301001A01');
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Baroda', '1995-11-30', '9876543214', 'jaiman.shah@gmail.com', 'Jaiman', 'Kamlesh', 'Shah', '1301001A02');
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Surat', '1995-03-13', '9787654345', 'raghu.panchal@gmail.com', 'Raghu', 'Umesh', 'Panchal', '1301001A03');
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Jamnagar', '1994-10-10', '9834512309', 'savita.purohit@gmail.com', 'Savita', 'Dinesh', 'Purohit', '1301001B01');
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Surat', '1995-01-09', '9090654321', 'sharad.raval@gmail.com', 'Sharad', 'Dinesh', 'Raval', '1301001B02');
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Ahmedabad', '1995-02-08', '9834563210', 'anita.shah@gmail.com', 'Anita', 'Anil', 'Shah', '1301002A01');
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Ahmedabad', '1994-01-07', '9012456125', 'amit.rathore@gmail.com', 'Amit', 'Pankaj', 'Rathore', '1401001A01');
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Rajkot', '1995-04-26', '9922345612', 'paresh.thakker@gmail.com', 'Paresh', 'Shiv', 'Thakkar', '1302001A01');
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Bharuch', '1996-07-13', '9825412345', 'dhaval.thummar@gmail.com', 'Dhaval', 'Khimji', 'Thummar', '1401001A02');
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Limkheda', '1996-05-18', '8898793465', 'jaman.zala@gmail.com', 'Jaman', 'Chaman', 'Zala', '1401001A03');
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Khavdi', '1996-02-07', '7899346745', 'gangubai@gmail.com', 'Ganga', 'Raman', 'Patel', '1401001A04');
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Jamnagar', '1996-07-25', '9976934432', 'smit.tilva@gmail.com', 'Smit', 'Haresh', 'Tilva', '1401001A05');
INSERT INTO `mydb`.`Student` (`Address`, `D_O_B`, `Contact_number`, `Email_ID`, `First_Name`, `Middle_name`, `Last_Name`, `Student_ID`) VALUES ('Rajkot', '1995-11-19', '9408282767', 'chetan.leela@gmail.com', 'Chetan', 'Kishor', 'Leela', '1401001A06');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Project`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Project` (`Project_ID`, `Total_marks`, `Deadline`, `weightage`, `Date_of_Allocation`, `Faculty_Faculty_ID`) VALUES (1, 80, '2014-10-25', 30, '2014-07-21', '12001');
INSERT INTO `mydb`.`Project` (`Project_ID`, `Total_marks`, `Deadline`, `weightage`, `Date_of_Allocation`, `Faculty_Faculty_ID`) VALUES (2, 30, '2014-10-15', 30, '2014-07-22', '12002');
INSERT INTO `mydb`.`Project` (`Project_ID`, `Total_marks`, `Deadline`, `weightage`, `Date_of_Allocation`, `Faculty_Faculty_ID`) VALUES (3, 50, '2014-10-18', 50, '2014-07-19', '12001');
INSERT INTO `mydb`.`Project` (`Project_ID`, `Total_marks`, `Deadline`, `weightage`, `Date_of_Allocation`, `Faculty_Faculty_ID`) VALUES (4, 100, '2014-11-05', 80, '2014-08-05', '12001');
INSERT INTO `mydb`.`Project` (`Project_ID`, `Total_marks`, `Deadline`, `weightage`, `Date_of_Allocation`, `Faculty_Faculty_ID`) VALUES (5, 40, '2014-11-02', 40, '2014-07-29', '12002');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Project_has_Topics`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Project_has_Topics` (`Project_Project_ID`, `Project_Title`, `Internal_Project_ID`) VALUES (1, 'Memory Management in C', 1);
INSERT INTO `mydb`.`Project_has_Topics` (`Project_Project_ID`, `Project_Title`, `Internal_Project_ID`) VALUES (1, 'Library management using File', 2);
INSERT INTO `mydb`.`Project_has_Topics` (`Project_Project_ID`, `Project_Title`, `Internal_Project_ID`) VALUES (1, 'Bank Management', 3);
INSERT INTO `mydb`.`Project_has_Topics` (`Project_Project_ID`, `Project_Title`, `Internal_Project_ID`) VALUES (2, 'Login Authentication', 4);
INSERT INTO `mydb`.`Project_has_Topics` (`Project_Project_ID`, `Project_Title`, `Internal_Project_ID`) VALUES (2, 'Mobile Sugesstion App', 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Project_has_Student`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Project_has_Student` (`Student_Student_ID`, `Marks`, `Project_has_Topics_Internal_Project_ID`) VALUES ('1401001A01', 62, 1);
INSERT INTO `mydb`.`Project_has_Student` (`Student_Student_ID`, `Marks`, `Project_has_Topics_Internal_Project_ID`) VALUES ('1401001A02', 62, 1);
INSERT INTO `mydb`.`Project_has_Student` (`Student_Student_ID`, `Marks`, `Project_has_Topics_Internal_Project_ID`) VALUES ('1401001A03', 68, 2);
INSERT INTO `mydb`.`Project_has_Student` (`Student_Student_ID`, `Marks`, `Project_has_Topics_Internal_Project_ID`) VALUES ('1401001A04', 65, 2);
INSERT INTO `mydb`.`Project_has_Student` (`Student_Student_ID`, `Marks`, `Project_has_Topics_Internal_Project_ID`) VALUES ('1401001A05', 55, 3);
INSERT INTO `mydb`.`Project_has_Student` (`Student_Student_ID`, `Marks`, `Project_has_Topics_Internal_Project_ID`) VALUES ('1401001A06', 58, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Department_has_Student`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '1301001A01', 01, '2013-07-01');
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '1301001A02', 01, '2013-07-08');
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '1301001A03', 01, '2013-07-15');
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '1301001B01', 01, '2013-07-01');
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '1301001B02', 01, '2013-07-08');
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (002, '1301002A01', 01, '2013-07-01');
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '1401001A06', 01, '2014-07-15');
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '1302001A01', 02, '2013-07-01');
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '1401001A01', 01, '2014-07-07');
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '1401001A02', 01, '2014-07-07');
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '1401001A03', 01, '2014-07-07');
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '1401001A04', 01, '2014-07-15');
INSERT INTO `mydb`.`Department_has_Student` (`Department_Department_ID`, `Student_Student_ID`, `Program_Program_ID`, `Date_of_joining`) VALUES (001, '1401001A05', 01, '2014-07-15');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Student_has_Quizzes`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A01', 1, 27);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A02', 1, 24);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A03', 1, 25);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A04', 1, 18);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A05', 1, 20);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A06', 1, 25);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A01', 2, 18);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A02', 2, 15);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A03', 2, 20);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A04', 2, 17);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A05', 2, 13);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A06', 2, 16);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A01', 3, 29);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A02', 3, 45);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A03', 3, 35);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A04', 3, 38);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A05', 3, 49);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A06', 3, 52);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A01', 4, 14);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A02', 4, 19);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A03', 4, 17);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A04', 4, 18);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A05', 4, 18);
INSERT INTO `mydb`.`Student_has_Quizzes` (`Student_Student_ID`, `Quizzes_Quiz_ID`, `Marks`) VALUES ('1401001A06', 4, 13);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Student_has_Assignments`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Student_has_Assignments` (`Student_Student_ID`, `Assignments_Assignment_ID`, `Marks`) VALUES ('1401001A01', 1, 8);
INSERT INTO `mydb`.`Student_has_Assignments` (`Student_Student_ID`, `Assignments_Assignment_ID`, `Marks`) VALUES ('1401001A02', 1, 12);
INSERT INTO `mydb`.`Student_has_Assignments` (`Student_Student_ID`, `Assignments_Assignment_ID`, `Marks`) VALUES ('1401001A03', 1, 19);
INSERT INTO `mydb`.`Student_has_Assignments` (`Student_Student_ID`, `Assignments_Assignment_ID`, `Marks`) VALUES ('1401001A04', 1, 15);
INSERT INTO `mydb`.`Student_has_Assignments` (`Student_Student_ID`, `Assignments_Assignment_ID`, `Marks`) VALUES ('1401001A05', 1, 18);
INSERT INTO `mydb`.`Student_has_Assignments` (`Student_Student_ID`, `Assignments_Assignment_ID`, `Marks`) VALUES ('1401001A06', 1, 15);
INSERT INTO `mydb`.`Student_has_Assignments` (`Student_Student_ID`, `Assignments_Assignment_ID`, `Marks`) VALUES ('1401001A01', 2, 10);
INSERT INTO `mydb`.`Student_has_Assignments` (`Student_Student_ID`, `Assignments_Assignment_ID`, `Marks`) VALUES ('1401001A02', 2, 13);
INSERT INTO `mydb`.`Student_has_Assignments` (`Student_Student_ID`, `Assignments_Assignment_ID`, `Marks`) VALUES ('1401001A03', 2, 12);
INSERT INTO `mydb`.`Student_has_Assignments` (`Student_Student_ID`, `Assignments_Assignment_ID`, `Marks`) VALUES ('1401001A04', 2, 14);
INSERT INTO `mydb`.`Student_has_Assignments` (`Student_Student_ID`, `Assignments_Assignment_ID`, `Marks`) VALUES ('1401001A05', 2, 14);
INSERT INTO `mydb`.`Student_has_Assignments` (`Student_Student_ID`, `Assignments_Assignment_ID`, `Marks`) VALUES ('1401001A06', 2, 13);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Course_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Course_type` (`Course_Type_ID`, `Type`) VALUES ('C', 'Core');
INSERT INTO `mydb`.`Course_type` (`Course_Type_ID`, `Type`) VALUES ('E', 'Elective');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Courses_has_Course_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Courses_has_Course_type` (`Courses_Course_ID`, `Course_type_Course_Type_ID`) VALUES ('CS101', 'C');
INSERT INTO `mydb`.`Courses_has_Course_type` (`Courses_Course_ID`, `Course_type_Course_Type_ID`) VALUES ('CS101L', 'C');
INSERT INTO `mydb`.`Courses_has_Course_type` (`Courses_Course_ID`, `Course_type_Course_Type_ID`) VALUES ('CS102', 'C');
INSERT INTO `mydb`.`Courses_has_Course_type` (`Courses_Course_ID`, `Course_type_Course_Type_ID`) VALUES ('CS102L', 'C');
INSERT INTO `mydb`.`Courses_has_Course_type` (`Courses_Course_ID`, `Course_type_Course_Type_ID`) VALUES ('EE101', 'C');
INSERT INTO `mydb`.`Courses_has_Course_type` (`Courses_Course_ID`, `Course_type_Course_Type_ID`) VALUES ('ECO01', 'E');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Grade_Points`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Grade_Points` (`Grade`, `Grade_Point`) VALUES ('A+', '4.33');
INSERT INTO `mydb`.`Grade_Points` (`Grade`, `Grade_Point`) VALUES ('A', '4.00');
INSERT INTO `mydb`.`Grade_Points` (`Grade`, `Grade_Point`) VALUES ('A-', '3.70');
INSERT INTO `mydb`.`Grade_Points` (`Grade`, `Grade_Point`) VALUES ('B+', '3.33');
INSERT INTO `mydb`.`Grade_Points` (`Grade`, `Grade_Point`) VALUES ('B', '3.00');
INSERT INTO `mydb`.`Grade_Points` (`Grade`, `Grade_Point`) VALUES ('B-', '2.70');
INSERT INTO `mydb`.`Grade_Points` (`Grade`, `Grade_Point`) VALUES ('C+', '2.33');
INSERT INTO `mydb`.`Grade_Points` (`Grade`, `Grade_Point`) VALUES ('C', '2.00');
INSERT INTO `mydb`.`Grade_Points` (`Grade`, `Grade_Point`) VALUES ('C-', '1.70');
INSERT INTO `mydb`.`Grade_Points` (`Grade`, `Grade_Point`) VALUES ('D+', '1.33');
INSERT INTO `mydb`.`Grade_Points` (`Grade`, `Grade_Point`) VALUES ('D', '1.00');
INSERT INTO `mydb`.`Grade_Points` (`Grade`, `Grade_Point`) VALUES ('F', '0.00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Grades`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Grade_Points_Grade`) VALUES ('1401001A01', 'A');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Grade_Points_Grade`) VALUES ('1401001A01', 'A');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Grade_Points_Grade`) VALUES ('1401001A02', 'B+');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Grade_Points_Grade`) VALUES ('1401001A02', 'B');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Grade_Points_Grade`) VALUES ('1401001A03', 'A-');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Grade_Points_Grade`) VALUES ('1401001A03', 'B+');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Grade_Points_Grade`) VALUES ('1401001A04', 'C');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Grade_Points_Grade`) VALUES ('1401001A04', 'C+');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Grade_Points_Grade`) VALUES ('1401001A05', 'D+');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Grade_Points_Grade`) VALUES ('1401001A05', 'A-');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Grade_Points_Grade`) VALUES ('1401001A06', 'B');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Grade_Points_Grade`) VALUES ('1401001A06', 'B-');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Research_Projects`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Research_Projects` (`Research_ID`, `Title`, `Deadline`, `objective`, `Status`, `Start_date`) VALUES (1, 'Spectrum of goodness of fit test', '2015-04-17', 'Using Anderson Darling test', 'In progress', '2014-12-17');
INSERT INTO `mydb`.`Research_Projects` (`Research_ID`, `Title`, `Deadline`, `objective`, `Status`, `Start_date`) VALUES (2, 'Probabilistic game theory', '2015-05-16', 'Using Linear Algebra and game theory', 'In progress', '2014-05-12');
INSERT INTO `mydb`.`Research_Projects` (`Research_ID`, `Title`, `Deadline`, `objective`, `Status`, `Start_date`) VALUES (3, 'Evolution in game theory using  2 players and 3 strategies', '2015-01-01', 'Using game theory', 'Completed', '2014-02-01');
INSERT INTO `mydb`.`Research_Projects` (`Research_ID`, `Title`, `Deadline`, `objective`, `Status`, `Start_date`) VALUES (4, 'Dome structure', '2015-02-01', 'Using construction theory and physics', 'Completed', '2013-01-01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Research_Topics`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Research_Topics` (`R_topic_ID`, `title`) VALUES (1, 'Cloud Computing');
INSERT INTO `mydb`.`Research_Topics` (`R_topic_ID`, `title`) VALUES (2, 'Construction theory');
INSERT INTO `mydb`.`Research_Topics` (`R_topic_ID`, `title`) VALUES (3, 'Physics');
INSERT INTO `mydb`.`Research_Topics` (`R_topic_ID`, `title`) VALUES (4, 'Game theory');
INSERT INTO `mydb`.`Research_Topics` (`R_topic_ID`, `title`) VALUES (5, 'Linear Algebra');
INSERT INTO `mydb`.`Research_Topics` (`R_topic_ID`, `title`) VALUES (6, 'Anderson Darling Test');
INSERT INTO `mydb`.`Research_Topics` (`R_topic_ID`, `title`) VALUES (7, 'Andriod Developement');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Research_Projects_has_Research_Topics`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Research_Projects_has_Research_Topics` (`Research_Projects_Research_ID`, `Research_Topics_R_topic_ID`) VALUES (1, 6);
INSERT INTO `mydb`.`Research_Projects_has_Research_Topics` (`Research_Projects_Research_ID`, `Research_Topics_R_topic_ID`) VALUES (2, 4);
INSERT INTO `mydb`.`Research_Projects_has_Research_Topics` (`Research_Projects_Research_ID`, `Research_Topics_R_topic_ID`) VALUES (2, 5);
INSERT INTO `mydb`.`Research_Projects_has_Research_Topics` (`Research_Projects_Research_ID`, `Research_Topics_R_topic_ID`) VALUES (3, 4);
INSERT INTO `mydb`.`Research_Projects_has_Research_Topics` (`Research_Projects_Research_ID`, `Research_Topics_R_topic_ID`) VALUES (4, 2);
INSERT INTO `mydb`.`Research_Projects_has_Research_Topics` (`Research_Projects_Research_ID`, `Research_Topics_R_topic_ID`) VALUES (4, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Research_Projects_has_Student`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Research_Projects_has_Student` (`Research_Projects_Research_ID`, `Student_Student_ID`) VALUES (1, '1302001A01');
INSERT INTO `mydb`.`Research_Projects_has_Student` (`Research_Projects_Research_ID`, `Student_Student_ID`) VALUES (2, '1302001A01');
INSERT INTO `mydb`.`Research_Projects_has_Student` (`Research_Projects_Research_ID`, `Student_Student_ID`) VALUES (1, '1301001A01');
INSERT INTO `mydb`.`Research_Projects_has_Student` (`Research_Projects_Research_ID`, `Student_Student_ID`) VALUES (3, '1401001A01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Research_Projects_has_Faculty`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Research_Projects_has_Faculty` (`Research_Projects_Research_ID`, `Faculty_Faculty_ID`) VALUES (1, '12002');
INSERT INTO `mydb`.`Research_Projects_has_Faculty` (`Research_Projects_Research_ID`, `Faculty_Faculty_ID`) VALUES (2, '12001');
INSERT INTO `mydb`.`Research_Projects_has_Faculty` (`Research_Projects_Research_ID`, `Faculty_Faculty_ID`) VALUES (3, '14001');
INSERT INTO `mydb`.`Research_Projects_has_Faculty` (`Research_Projects_Research_ID`, `Faculty_Faculty_ID`) VALUES (4, '12001');
INSERT INTO `mydb`.`Research_Projects_has_Faculty` (`Research_Projects_Research_ID`, `Faculty_Faculty_ID`) VALUES (2, '13001');
INSERT INTO `mydb`.`Research_Projects_has_Faculty` (`Research_Projects_Research_ID`, `Faculty_Faculty_ID`) VALUES (3, '12002');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Time_Schedule`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Day`, `Class_Class_ID`) VALUES ('09:30', '10:30', 'Monday', 101);
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Day`, `Class_Class_ID`) VALUES ('10:30', '11:30', 'Monday', 101);
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Day`, `Class_Class_ID`) VALUES ('12:00', '15:00', 'Monday', 105);
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Day`, `Class_Class_ID`) VALUES ('09:30', '10:30', 'Monday', 102);
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Day`, `Class_Class_ID`) VALUES ('11:00', '14:00', 'Monday', 104);
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Day`, `Class_Class_ID`) VALUES ('08:30', '09:30', 'Tuesday', 101);
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Day`, `Class_Class_ID`) VALUES ('11:00', '14:00', 'Tuseday', 105);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Student_has_Exams`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A01', 1, 35);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A02', 1, 38);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A03', 1, 45);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A04', 1, 42);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A05', 1, 31);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A06', 1, 41);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A01', 3, 30);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A02', 3, 27);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A03', 3, 38);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A04', 3, 41);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A05', 3, 47);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A06', 3, 34);

COMMIT;

