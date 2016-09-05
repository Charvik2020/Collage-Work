-- Q1 List of successful research projects
select Research_ID, Title from research_projects where status = 'Completed';
-- Q2 No of students registered for core
select * from courses;
-- Q3 Information about visiting faculty in institute
select * from faculty where designation='visiting';
-- Q4 FOR EXAMS
select * from student_has_exams;
update student_has_exams set Exams_Exam_ID=3 where Exams_Exam_ID=4;
-- Q5 Group faculty in order of the number of classes they take
select faculty.Faculty_ID ,name, count(*) Number_of_classes from faculty_has_course_structures,faculty 
where faculty.Faculty_ID=faculty_has_course_structures.Faculty_Faculty_Id group by Faculty_ID order by Number_of_Classes desc;
-- Q6 Information about Exam sitting arangement
select Exam_ID,Date,Class_Class_ID,exam_type from (exams natural join exams_has_course_structure) where Exam_ID=Exams_Exam_ID;
-- Q7 Projects with Deadline ,Weigtage ,Project_ID,Title,Internal Project Id,Student ID working on Same Internal Project Id
select distinct project.Deadline,project.weightage,Project_ID,Project_Title ,Project_has_Topics_Internal_Project_ID,Student_Student_ID 
from (project  natural join project_has_topics natural join project_has_student)
 where Project_ID=Project_Project_ID and  Internal_Project_ID=Project_has_Topics_Internal_Project_ID and Project_ID=1;
 -- Q8 student first name ,Address,ID,Grade_point of course section id
 select distinct Student_Student_ID,student.First_Name,Address,Email_ID ,Grade_Points_Grade,Section_has_course_structures_Course_Section_ID
 from (grades natural join student ) 
 where Student_ID=Student_Student_ID order by First_Name;
 -- Q9 Assignment
 select Assignment_ID,Total_marks,assignments.Date,Link,weightage from (assignment_course_structure join assignments) where Assignments_Assignment_ID=Assignment_ID;
 -- Q10 FOR ASSIGNMENTS
select sum(weightage*(select sum(marks) from student_has_assignments where Student_Student_ID='1401001A01'))/sum(total_marks) from Assignments
where assignment_id in (select Assignments_Assignment_ID from student_has_assignments where Student_Student_ID='1401001A01');
