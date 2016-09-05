-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Program`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Program` (
  `Program_ID` INT NOT NULL COMMENT 'Program ID for Btech, Mtech, PhD',
  `Program_type` VARCHAR(45) NULL,
  PRIMARY KEY (`Program_ID`))
ENGINE = InnoDB
MAX_ROWS = 99;


-- -----------------------------------------------------
-- Table `mydb`.`Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Department` (
  `Department_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Department ID for chemical, ICT, etc',
  `Department_type` VARCHAR(45) NULL,
  PRIMARY KEY (`Department_ID`))
ENGINE = InnoDB
MAX_ROWS = 999;


-- -----------------------------------------------------
-- Table `mydb`.`Dept_Prog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Dept_Prog` (
  `Department_ID` INT NULL,
  `Program_ID` INT NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Dept_Prog_Program1_idx` ON `mydb`.`Dept_Prog` (`Program_ID` ASC);

CREATE INDEX `fk_Dept_Prog_Department_idx` ON `mydb`.`Dept_Prog` (`Department_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Courses` (
  `Course_ID` VARCHAR(10) NOT NULL,
  `Course_name` VARCHAR(45) NOT NULL,
  `Credits` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`Course_ID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Course ID_UNIQUE` ON `mydb`.`Courses` (`Course_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Courses_has_Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Courses_has_Department` (
  `Courses_Course_ID` VARCHAR(10) NULL COMMENT 'Courses are in which department',
  `Department_Department_ID` INT NULL,
  `Elective` INT NOT NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Courses_has_Department_Department1_idx` ON `mydb`.`Courses_has_Department` (`Department_Department_ID` ASC);

CREATE INDEX `fk_Courses_has_Department_Courses1_idx` ON `mydb`.`Courses_has_Department` (`Courses_Course_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Semester`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Semester` (
  `Semester_ID` INT NOT NULL COMMENT 'Semester ID for semester number 1,2,3,etc',
  `Semester_number` VARCHAR(45) NOT NULL COMMENT 'Cannot be greater than one specified by the degree',
  PRIMARY KEY (`Semester_ID`))
ENGINE = InnoDB
MAX_ROWS = 10;

CREATE UNIQUE INDEX `Semester ID_UNIQUE` ON `mydb`.`Semester` (`Semester_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Offerings_Semester`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Offerings_Semester` (
  `Semester_O_ID` VARCHAR(10) NOT NULL COMMENT 'Various semester offerings for a particular semester',
  `Year` INT NOT NULL,
  `Start_date` DATE NOT NULL,
  `End_date` DATE NOT NULL,
  `Program_Program_ID` INT NULL,
  `Department_Department_ID` INT NULL,
  `Semester_Semester_ID` INT NULL,
  `SO_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Auto increment',
  PRIMARY KEY (`SO_ID`))
ENGINE = InnoDB;

CREATE INDEX `fk_Offerings Semester_Program1_idx` ON `mydb`.`Offerings_Semester` (`Program_Program_ID` ASC);

CREATE INDEX `fk_Offerings Semester_Department1_idx` ON `mydb`.`Offerings_Semester` (`Department_Department_ID` ASC);

CREATE INDEX `fk_Offerings Semester_Semester1_idx` ON `mydb`.`Offerings_Semester` (`Semester_Semester_ID` ASC);

CREATE UNIQUE INDEX `SO ID_UNIQUE` ON `mydb`.`Offerings_Semester` (`SO_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Offerings_Semester_has_Courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Offerings_Semester_has_Courses` (
  `Courses_Course_ID` VARCHAR(10) NULL,
  `Offerings_Semester_SO_ID` INT NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Offerings Semester_has_Courses_Courses1_idx` ON `mydb`.`Offerings_Semester_has_Courses` (`Courses_Course_ID` ASC);

CREATE INDEX `fk_Offerings Semester_has_Courses_Offerings Semester1_idx` ON `mydb`.`Offerings_Semester_has_Courses` (`Offerings_Semester_SO_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Faculty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Faculty` (
  `Faculty_ID` VARCHAR(5) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(100) NOT NULL,
  `Date_of_birth` DATE NOT NULL,
  `Contact_number` VARCHAR(10) NOT NULL,
  `Email_ID` VARCHAR(25) NOT NULL,
  `Designation` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`Faculty_ID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Faculty ID_UNIQUE` ON `mydb`.`Faculty` (`Faculty_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Department_has_Faculty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Department_has_Faculty` (
  `Department_Department_ID` INT NULL,
  `Faculty_Faculty_ID` VARCHAR(5) NULL,
  `Program_Program_ID` INT NULL,
  `Date_of_joining` DATE NOT NULL COMMENT 'Date of joining the institute by the faculty\nJoining dates in different departments can be different')
ENGINE = InnoDB;

CREATE INDEX `fk_Department_has_Faculty_Department1_idx` ON `mydb`.`Department_has_Faculty` (`Department_Department_ID` ASC);

CREATE INDEX `fk_Department_has_Faculty_Program1_idx` ON `mydb`.`Department_has_Faculty` (`Program_Program_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Teaching_Assistants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Teaching_Assistants` (
  `TA_ID` INT NOT NULL,
  `Faculty_Faculty_ID` VARCHAR(5) NULL,
  PRIMARY KEY (`TA_ID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `TA ID_UNIQUE` ON `mydb`.`Teaching_Assistants` (`TA_ID` ASC);

CREATE INDEX `fk_Teaching Assistants_Faculty1_idx` ON `mydb`.`Teaching_Assistants` (`Faculty_Faculty_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Class` (
  `Class_ID` INT NOT NULL COMMENT 'Class room allocated for various classes',
  `Title` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`Class_ID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Class ID_UNIQUE` ON `mydb`.`Class` (`Class_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Quizzes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Quizzes` (
  `Quiz_ID` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `total_marks` INT NOT NULL COMMENT 'Should not be greater than 100%',
  `Class_Class_ID` INT NULL,
  `weightage` INT NOT NULL COMMENT 'in percntage %',
  `Start_Time` TIME NOT NULL,
  `End_Time` TIME NOT NULL,
  `TA_has_Offerings_Semester_TA_ID` INT NULL,
  PRIMARY KEY (`Quiz_ID`))
ENGINE = InnoDB;

CREATE INDEX `fk_Quizzes_Class1_idx` ON `mydb`.`Quizzes` (`Class_Class_ID` ASC);

CREATE UNIQUE INDEX `Quiz ID_UNIQUE` ON `mydb`.`Quizzes` (`Quiz_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Exams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Exams` (
  `Exam_ID` INT NOT NULL AUTO_INCREMENT,
  `start_time` TIME NOT NULL,
  `Date` DATE NOT NULL,
  `marks` INT NOT NULL,
  `end_time` TIME NOT NULL,
  `Class_Class_ID` INT NULL,
  `weightage` INT NOT NULL,
  `exam_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Exam_ID`))
ENGINE = InnoDB;

CREATE INDEX `fk_Exams_Class1_idx` ON `mydb`.`Exams` (`Class_Class_ID` ASC);

CREATE UNIQUE INDEX `Exam ID_UNIQUE` ON `mydb`.`Exams` (`Exam_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Assignments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Assignments` (
  `Assignment_ID` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `Total_marks` INT NOT NULL COMMENT 'Maximum attainable marks',
  `Link` VARCHAR(100) NOT NULL,
  `weightage` INT NOT NULL,
  PRIMARY KEY (`Assignment_ID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Assignment ID_UNIQUE` ON `mydb`.`Assignments` (`Assignment_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Student`
-- -----------------------------------------------------
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
CREATE TABLE IF NOT EXISTS `mydb`.`Project` (
  `Project_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Academic projects',
  `Total_marks` INT NOT NULL COMMENT 'Maximum attainable marks',
  `Deadline` DATE NOT NULL,
  `weightage` INT NOT NULL,
  `Date_of_Allocation` DATE NOT NULL,
  `Faculty_Faculty_ID` VARCHAR(5) NULL,
  `Section_has_course_structures_Course_Section_ID` INT NULL,
  PRIMARY KEY (`Project_ID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Project ID_UNIQUE` ON `mydb`.`Project` (`Project_ID` ASC);

CREATE INDEX `fk_Project_Faculty1_idx` ON `mydb`.`Project` (`Faculty_Faculty_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Project_has_Topics`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Project_has_Topics` (
  `Project_Project_ID` INT NULL,
  `Project_Title` VARCHAR(50) NOT NULL,
  `Internal_Project_ID` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Internal_Project_ID`))
ENGINE = InnoDB;

CREATE INDEX `fk_Project_has_Topics_Project1_idx` ON `mydb`.`Project_has_Topics` (`Project_Project_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Project_has_Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Project_has_Student` (
  `Student_Student_ID` VARCHAR(10) NULL,
  `Marks` INT NOT NULL,
  `Project_has_Topics_Internal_Project_ID` INT NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Project_has_Student_Student1_idx` ON `mydb`.`Project_has_Student` (`Student_Student_ID` ASC);

CREATE INDEX `fk_Project_has_Student_Project_has_Topics1_idx` ON `mydb`.`Project_has_Student` (`Project_has_Topics_Internal_Project_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Department_has_Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Department_has_Student` (
  `Department_Department_ID` INT NULL COMMENT 'Students are in which department',
  `Student_Student_ID` VARCHAR(10) NOT NULL,
  `Program_Program_ID` INT NULL,
  `Date_of_joining` DATE NOT NULL,
  PRIMARY KEY (`Student_Student_ID`))
ENGINE = InnoDB;

CREATE INDEX `fk_Department_has_Student_Student1_idx` ON `mydb`.`Department_has_Student` (`Student_Student_ID` ASC);

CREATE INDEX `fk_Department_has_Student_Department1_idx` ON `mydb`.`Department_has_Student` (`Department_Department_ID` ASC);

CREATE INDEX `fk_Department_has_Student_Program1_idx` ON `mydb`.`Department_has_Student` (`Program_Program_ID` ASC);

CREATE UNIQUE INDEX `Student_Student_ID_UNIQUE` ON `mydb`.`Department_has_Student` (`Student_Student_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Courses_has_Topics`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Courses_has_Topics` (
  `Topics_Topic_ID` INT NULL,
  `Structure_Course_Course_Structure_ID` INT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Student_has_Quizzes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Student_has_Quizzes` (
  `Student_Student_ID` VARCHAR(10) NULL,
  `Quizzes_Quiz_ID` INT NULL,
  `Marks` INT NOT NULL COMMENT 'Should be lesser than or equal to 100%')
ENGINE = InnoDB;

CREATE INDEX `fk_Student_has_Quizzes_Quizzes1_idx` ON `mydb`.`Student_has_Quizzes` (`Quizzes_Quiz_ID` ASC);

CREATE INDEX `fk_Student_has_Quizzes_Student1_idx` ON `mydb`.`Student_has_Quizzes` (`Student_Student_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Student_has_Assignments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Student_has_Assignments` (
  `Student_Student_ID` VARCHAR(10) NULL,
  `Assignments_Assignment_ID` INT NULL,
  `Marks` INT NOT NULL COMMENT 'Should be lesser than or equal to 100%')
ENGINE = InnoDB;

CREATE INDEX `fk_Student_has_Assignments_Assignments1_idx` ON `mydb`.`Student_has_Assignments` (`Assignments_Assignment_ID` ASC);

CREATE INDEX `fk_Student_has_Assignments_Student1_idx` ON `mydb`.`Student_has_Assignments` (`Student_Student_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Course_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Course_type` (
  `Course_Type_ID` VARCHAR(10) NOT NULL,
  `Type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Course_Type_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Courses_has_Course_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Courses_has_Course_type` (
  `Courses_Course_ID` VARCHAR(10) NULL,
  `Course_type_Course_Type_ID` VARCHAR(10) NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Courses_has_Course type_Course type1_idx` ON `mydb`.`Courses_has_Course_type` (`Course_type_Course_Type_ID` ASC);

CREATE INDEX `fk_Courses_has_Course type_Courses1_idx` ON `mydb`.`Courses_has_Course_type` (`Courses_Course_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Grade_Points`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Grade_Points` (
  `Grade` VARCHAR(2) NOT NULL,
  `Grade_Point` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`Grade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Grades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Grades` (
  `Student_Student_ID` VARCHAR(10) NULL,
  `Section_has_course_structures_Course_Section_ID` INT NULL,
  `Grade_Points_Grade` VARCHAR(2) NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Grades_Student1_idx` ON `mydb`.`Grades` (`Student_Student_ID` ASC);

CREATE INDEX `fk_Grades_Grade Points1_idx` ON `mydb`.`Grades` (`Grade_Points_Grade` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Research_Projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Research_Projects` (
  `Research_ID` INT NOT NULL COMMENT 'Research details and status',
  `Title` VARCHAR(100) NOT NULL,
  `Deadline` DATE NOT NULL,
  `objective` VARCHAR(150) NOT NULL,
  `Status` VARCHAR(30) NOT NULL,
  `Start_date` DATE NOT NULL,
  PRIMARY KEY (`Research_ID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `Research ID_UNIQUE` ON `mydb`.`Research_Projects` (`Research_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Research_Topics`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Research_Topics` (
  `R_topic_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'research topics for research projects',
  `title` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`R_topic_ID`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `R topic ID_UNIQUE` ON `mydb`.`Research_Topics` (`R_topic_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Research_Projects_has_Research_Topics`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Research_Projects_has_Research_Topics` (
  `Research_Projects_Research_ID` INT NULL,
  `Research_Topics_R_topic_ID` INT NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Research Projects_has_Research Topics_Research Topics1_idx` ON `mydb`.`Research_Projects_has_Research_Topics` (`Research_Topics_R_topic_ID` ASC);

CREATE INDEX `fk_Research Projects_has_Research Topics_Research Projects1_idx` ON `mydb`.`Research_Projects_has_Research_Topics` (`Research_Projects_Research_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Research_Projects_has_Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Research_Projects_has_Student` (
  `Research_Projects_Research_ID` INT NULL,
  `Student_Student_ID` VARCHAR(10) NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Research Projects_has_Student_Student1_idx` ON `mydb`.`Research_Projects_has_Student` (`Student_Student_ID` ASC);

CREATE INDEX `fk_Research Projects_has_Student_Research Projects1_idx` ON `mydb`.`Research_Projects_has_Student` (`Research_Projects_Research_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Research_Projects_has_Faculty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Research_Projects_has_Faculty` (
  `Research_Projects_Research_ID` INT NULL,
  `Faculty_Faculty_ID` VARCHAR(5) NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Research Projects_has_Faculty_Faculty1_idx` ON `mydb`.`Research_Projects_has_Faculty` (`Faculty_Faculty_ID` ASC);

CREATE INDEX `fk_Research Projects_has_Faculty_Research Projects1_idx` ON `mydb`.`Research_Projects_has_Faculty` (`Research_Projects_Research_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Time_Schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Time_Schedule` (
  `Start_time` TIME NOT NULL,
  `End_time` TIME NOT NULL,
  `Section_has_course_structures_Course_Section_ID` INT NULL,
  `Day` VARCHAR(9) NOT NULL,
  `Class_Class_ID` INT NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Time Schedule_Class1_idx` ON `mydb`.`Time_Schedule` (`Class_Class_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Student_has_Exams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Student_has_Exams` (
  `Student_Student_ID` VARCHAR(10) NULL COMMENT 'Student appears for various exams',
  `Exams_Exam_ID` INT NULL,
  `Marks` INT NOT NULL COMMENT 'Should be lesser than or equal to 100%')
ENGINE = InnoDB;

CREATE INDEX `fk_Student_has_Exams1_Exams1_idx` ON `mydb`.`Student_has_Exams` (`Exams_Exam_ID` ASC);

CREATE INDEX `fk_Student_has_Exams1_Student1_idx` ON `mydb`.`Student_has_Exams` (`Student_Student_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Research_Projects_has_Paper`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Research_Projects_has_Paper` (
  `Research_Projects_Research_ID` INT NULL,
  `Paper_Paper_ID` INT NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Research Projects_has_Paper_Research Projects1_idx` ON `mydb`.`Research_Projects_has_Paper` (`Research_Projects_Research_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Prerequisites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Prerequisites` (
  `Courses_Course_ID` VARCHAR(10) NULL,
  `Prerequisite_ID` VARCHAR(10) NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Pre-requisites_Courses1_idx` ON `mydb`.`Prerequisites` (`Courses_Course_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Faculty_has_course_structures`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Faculty_has_course_structures` (
  `Section_has_course_structures_Course_Section_ID` INT NULL,
  `Faculty_Faculty_ID` VARCHAR(5) NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Faculty has course structures_Faculty1_idx` ON `mydb`.`Faculty_has_course_structures` (`Faculty_Faculty_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Quiz_of_courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Quiz_of_courses` (
  `Section_has_course_structures_Course_Section_ID` INT NULL,
  `Quizzes_Quiz_ID` INT NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Quiz of courses_Quizzes1_idx` ON `mydb`.`Quiz_of_courses` (`Quizzes_Quiz_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Assignment_Course_structure`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Assignment_Course_structure` (
  `Assignments_Assignment_ID` INT NULL,
  `Section_has_course_structures_Course_Section_ID` INT NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Assignment_Course structure_Assignments1_idx` ON `mydb`.`Assignment_Course_structure` (`Assignments_Assignment_ID` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Exams_has_course_structure`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Exams_has_course_structure` (
  `Exams_Exam_ID` INT NULL,
  `Section_has_course_structures_Course_Section_ID` INT NULL)
ENGINE = InnoDB;

CREATE INDEX `fk_Exams_has_Section has course structures_Exams1_idx` ON `mydb`.`Exams_has_course_structure` (`Exams_Exam_ID` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;