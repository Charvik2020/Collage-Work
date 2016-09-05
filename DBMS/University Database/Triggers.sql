-- T1) Trigger for Quiz
delimiter //
CREATE TRIGGER upd_check_quiz BEFORE UPDATE ON student_has_quizzes
FOR EACH ROW
BEGIN
IF NEW.Marks < 0 THEN
	SET NEW.Marks = 0;
		ELSEIF NEW.Marks > 30 THEN
           SET NEW.Marks = 30;
         END IF;
END;//

delimiter ;
-- Statement to trigger above trigger
update student_has_quizzes
set marks=35
where Student_Student_ID="1401001A01" and Quizzes_Quiz_ID="1";

-- T2) Trigger for Exam
delimiter //
CREATE TRIGGER upd_check BEFORE UPDATE ON student_has_exams
FOR EACH ROW
BEGIN
IF NEW.Marks < 0 THEN
	SET NEW.Marks = 0;
		ELSEIF NEW.Marks > 100 THEN
           SET NEW.Marks = 100;
         END IF;
END;//

delimiter ;
-- Statement to trigger above trigger
update student_has_exams
set marks=-1
where Student_Student_ID="1401001A05" and Exams_Exam_ID="3";

-- T3) 101 Not available so shift to 103 Trigger
delimiter //
create trigger sd before insert  on exams
for each row 
begin
if new.Class_Class_ID=101 then
	set new.Class_Class_ID=103;
end if;
end;//

delimiter ;
-- trigger to trigger above trigger
INSERT INTO `mydb`.`Exams` (`Exam_ID`, `start_time`, `Date`, `marks`, `end_time`, `Class_Class_ID`, `weightage`, `exam_type`) 
VALUES (7, '09:00', '2014-12-11', 90, '11:00', 101, 30, 'FINAL');


-- T4) GPA > 2 are able to take research project
drop trigger rp;
delimiter //

create trigger rp before update on research_projects_has_student
for each row
begin
	if(grades.Grade_Points_Grade="D" or grades.Grade_Points_Grade="D-") and new.Student_Student_ID=grades.Student_Student_ID
    then 
    delete from research_projects_has_student where (grades.Student_Student_ID=new.Student_Student_ID);
    end if;
end;//
delimiter ;

-- statement to trigger to trigger above trigger
insert into  research_projects_has_student(Research_Projects_Research_ID,Student_Student_ID) values (2,"1401001A01");