
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
INSERT INTO `mydb`.`Quizzes` (`Quiz_ID`, `Date`, `total_marks`, `Class_Class_ID`, `weightage`, `Start_Time`, `End_Time`, `TA_has_Offerings_Semester_TA_ID`) VALUES (1, '2014-08-03', 30, 101, 5, '14:00', '15:00', 1001);
INSERT INTO `mydb`.`Quizzes` (`Quiz_ID`, `Date`, `total_marks`, `Class_Class_ID`, `weightage`, `Start_Time`, `End_Time`, `TA_has_Offerings_Semester_TA_ID`) VALUES (2, '2014-08-03', 20, 102, 5, '14:00', '14:30', 1001);
INSERT INTO `mydb`.`Quizzes` (`Quiz_ID`, `Date`, `total_marks`, `Class_Class_ID`, `weightage`, `Start_Time`, `End_Time`, `TA_has_Offerings_Semester_TA_ID`) VALUES (3, '2014-08-25', 56, 101, 10, '15:00', '16:30', 1001);
INSERT INTO `mydb`.`Quizzes` (`Quiz_ID`, `Date`, `total_marks`, `Class_Class_ID`, `weightage`, `Start_Time`, `End_Time`, `TA_has_Offerings_Semester_TA_ID`) VALUES (4, '2014-08-25', 20, 101, 5, '09:00', '9:30', 2004);
INSERT INTO `mydb`.`Quizzes` (`Quiz_ID`, `Date`, `total_marks`, `Class_Class_ID`, `weightage`, `Start_Time`, `End_Time`, `TA_has_Offerings_Semester_TA_ID`) VALUES (5, '2014-09-14', 30, 103, 5, '11:00', '12:00', 2004);
INSERT INTO `mydb`.`Quizzes` (`Quiz_ID`, `Date`, `total_marks`, `Class_Class_ID`, `weightage`, `Start_Time`, `End_Time`, `TA_has_Offerings_Semester_TA_ID`) VALUES (6, '2014-10-10', 25, 103, 10, '11:30', '12:00', 2004);

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
INSERT INTO `mydb`.`Assignments` (`Assignment_ID`, `Date`, `Total_marks`, `Link`, `weightage`) VALUES (1, '2014-07-25', 20, 'Network\\Server\\AS1', 5);
INSERT INTO `mydb`.`Assignments` (`Assignment_ID`, `Date`, `Total_marks`, `Link`, `weightage`) VALUES (2, '2014-08-11', 15, 'Network\\Server\\AS2', 5);
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
INSERT INTO `mydb`.`Project` (`Project_ID`, `Total_marks`, `Deadline`, `weightage`, `Date_of_Allocation`, `Faculty_Faculty_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (1, 80, '2014-10-25', 40, '2014-07-21', '12001', 1);
INSERT INTO `mydb`.`Project` (`Project_ID`, `Total_marks`, `Deadline`, `weightage`, `Date_of_Allocation`, `Faculty_Faculty_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (2, 30, '2014-10-15', 30, '2014-07-22', '12002', 1);
INSERT INTO `mydb`.`Project` (`Project_ID`, `Total_marks`, `Deadline`, `weightage`, `Date_of_Allocation`, `Faculty_Faculty_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (3, 50, '2014-10-18', 50, '2014-07-19', '12001', 1);
INSERT INTO `mydb`.`Project` (`Project_ID`, `Total_marks`, `Deadline`, `weightage`, `Date_of_Allocation`, `Faculty_Faculty_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (4, 100, '2014-11-05', 80, '2014-08-05', '12001', 6);
INSERT INTO `mydb`.`Project` (`Project_ID`, `Total_marks`, `Deadline`, `weightage`, `Date_of_Allocation`, `Faculty_Faculty_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (5, 40, '2014-11-02', 40, '2014-07-29', '12002', 6);

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
-- Data for table `mydb`.`Courses_has_Topics`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Courses_has_Topics` (`Topics_Topic_ID`, `Structure_Course_Course_Structure_ID`) VALUES (1, 4);
INSERT INTO `mydb`.`Courses_has_Topics` (`Topics_Topic_ID`, `Structure_Course_Course_Structure_ID`) VALUES (2, 4);
INSERT INTO `mydb`.`Courses_has_Topics` (`Topics_Topic_ID`, `Structure_Course_Course_Structure_ID`) VALUES (3, 1);
INSERT INTO `mydb`.`Courses_has_Topics` (`Topics_Topic_ID`, `Structure_Course_Course_Structure_ID`) VALUES (4, 4);
INSERT INTO `mydb`.`Courses_has_Topics` (`Topics_Topic_ID`, `Structure_Course_Course_Structure_ID`) VALUES (5, 3);
INSERT INTO `mydb`.`Courses_has_Topics` (`Topics_Topic_ID`, `Structure_Course_Course_Structure_ID`) VALUES (6, 1);
INSERT INTO `mydb`.`Courses_has_Topics` (`Topics_Topic_ID`, `Structure_Course_Course_Structure_ID`) VALUES (7, 4);

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
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A01', 1, 'A');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A01', 2, 'A');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A02', 1, 'B+');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A02', 2, 'B');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A03', 1, 'A-');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A03', 2, 'B+');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A04', 1, 'C');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A04', 2, 'C+');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A05', 1, 'D+');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A05', 2, 'A-');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A06', 1, 'B');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A06', 2, 'B-');
INSERT INTO `mydb`.`Grades` (`Student_Student_ID`, `Section_has_course_structures_Course_Section_ID`, `Grade_Points_Grade`) VALUES ('1401001A07', 1, 'C-');

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
INSERT INTO `mydb`.`Research_Projects_has_Research_Topics` (`Research_Projects_Research_ID`, `Research_Topics_R_topic_ID`) VALUES (5, 7);

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
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Section_has_course_structures_Course_Section_ID`, `Day`, `Class_Class_ID`) VALUES ('09:30', '10:30', 1, 'Monday', 101);
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Section_has_course_structures_Course_Section_ID`, `Day`, `Class_Class_ID`) VALUES ('10:30', '11:30', 1, 'Monday', 101);
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Section_has_course_structures_Course_Section_ID`, `Day`, `Class_Class_ID`) VALUES ('12:00', '15:00', 2, 'Monday', 105);
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Section_has_course_structures_Course_Section_ID`, `Day`, `Class_Class_ID`) VALUES ('09:30', '10:30', 3, 'Monday', 102);
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Section_has_course_structures_Course_Section_ID`, `Day`, `Class_Class_ID`) VALUES ('11:00', '14:00', 5, 'Monday', 104);
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Section_has_course_structures_Course_Section_ID`, `Day`, `Class_Class_ID`) VALUES ('08:30', '09:30', 1, 'Tuesday', 101);
INSERT INTO `mydb`.`Time_Schedule` (`Start_time`, `End_time`, `Section_has_course_structures_Course_Section_ID`, `Day`, `Class_Class_ID`) VALUES ('11:00', '14:00', 2, 'Tuseday', 105);

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
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A01', 4, 30);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A02', 4, 27);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A03', 4, 38);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A04', 4, 41);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A05', 4, 47);
INSERT INTO `mydb`.`Student_has_Exams` (`Student_Student_ID`, `Exams_Exam_ID`, `Marks`) VALUES ('1401001A06', 4, 34);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Prerequisites`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Prerequisites` (`Courses_Course_ID`, `Prerequisite_ID`) VALUES ('CS102', 'CS101');
INSERT INTO `mydb`.`Prerequisites` (`Courses_Course_ID`, `Prerequisite_ID`) VALUES ('CS102', 'CS101L');
INSERT INTO `mydb`.`Prerequisites` (`Courses_Course_ID`, `Prerequisite_ID`) VALUES ('CS102L', 'CS101');
INSERT INTO `mydb`.`Prerequisites` (`Courses_Course_ID`, `Prerequisite_ID`) VALUES ('CS102L', 'CS101L');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Faculty_has_course_structures`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Faculty_has_course_structures` (`Section_has_course_structures_Course_Section_ID`, `Faculty_Faculty_ID`) VALUES (1, '12001');
INSERT INTO `mydb`.`Faculty_has_course_structures` (`Section_has_course_structures_Course_Section_ID`, `Faculty_Faculty_ID`) VALUES (2, '12001');
INSERT INTO `mydb`.`Faculty_has_course_structures` (`Section_has_course_structures_Course_Section_ID`, `Faculty_Faculty_ID`) VALUES (3, '13001');
INSERT INTO `mydb`.`Faculty_has_course_structures` (`Section_has_course_structures_Course_Section_ID`, `Faculty_Faculty_ID`) VALUES (4, '12002');
INSERT INTO `mydb`.`Faculty_has_course_structures` (`Section_has_course_structures_Course_Section_ID`, `Faculty_Faculty_ID`) VALUES (5, '13001');
INSERT INTO `mydb`.`Faculty_has_course_structures` (`Section_has_course_structures_Course_Section_ID`, `Faculty_Faculty_ID`) VALUES (6, '13001');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Quiz_of_courses`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Quiz_of_courses` (`Section_has_course_structures_Course_Section_ID`, `Quizzes_Quiz_ID`) VALUES (1, 1);
INSERT INTO `mydb`.`Quiz_of_courses` (`Section_has_course_structures_Course_Section_ID`, `Quizzes_Quiz_ID`) VALUES (1, 2);
INSERT INTO `mydb`.`Quiz_of_courses` (`Section_has_course_structures_Course_Section_ID`, `Quizzes_Quiz_ID`) VALUES (1, 3);
INSERT INTO `mydb`.`Quiz_of_courses` (`Section_has_course_structures_Course_Section_ID`, `Quizzes_Quiz_ID`) VALUES (1, 4);
INSERT INTO `mydb`.`Quiz_of_courses` (`Section_has_course_structures_Course_Section_ID`, `Quizzes_Quiz_ID`) VALUES (6, 5);
INSERT INTO `mydb`.`Quiz_of_courses` (`Section_has_course_structures_Course_Section_ID`, `Quizzes_Quiz_ID`) VALUES (6, 6);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Assignment_Course_structure`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Assignment_Course_structure` (`Assignments_Assignment_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (1, 1);
INSERT INTO `mydb`.`Assignment_Course_structure` (`Assignments_Assignment_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (2, 1);
INSERT INTO `mydb`.`Assignment_Course_structure` (`Assignments_Assignment_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (3, 1);
INSERT INTO `mydb`.`Assignment_Course_structure` (`Assignments_Assignment_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (4, 1);
INSERT INTO `mydb`.`Assignment_Course_structure` (`Assignments_Assignment_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (5, 6);
INSERT INTO `mydb`.`Assignment_Course_structure` (`Assignments_Assignment_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (6, 6);
INSERT INTO `mydb`.`Assignment_Course_structure` (`Assignments_Assignment_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (7, 6);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Exams_has_course_structure`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Exams_has_course_structure` (`Exams_Exam_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (1, 1);
INSERT INTO `mydb`.`Exams_has_course_structure` (`Exams_Exam_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (2, 1);
INSERT INTO `mydb`.`Exams_has_course_structure` (`Exams_Exam_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (3, 1);
INSERT INTO `mydb`.`Exams_has_course_structure` (`Exams_Exam_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (4, 1);
INSERT INTO `mydb`.`Exams_has_course_structure` (`Exams_Exam_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (5, 6);
INSERT INTO `mydb`.`Exams_has_course_structure` (`Exams_Exam_ID`, `Section_has_course_structures_Course_Section_ID`) VALUES (6, 6);

COMMIT;

