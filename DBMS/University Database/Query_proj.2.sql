use mydb;

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

select faculty.Faculty_ID ,name, count(*) Number_of_classes from faculty 
 group by Faculty_ID order by Number_of_Classes desc;

-- Q6 Information about Exam Type and Student ID

select distinct Student_ID,Exams_Exam_ID,exams.exam_type
 from (student_has_exams join student natural join exams)
 where (Student_Student_ID=Student_ID and Exam_ID=Exams_Exam_ID) ;

-- Q7 Projects with Deadline ,Weigtage ,Project_ID,Title,Internal Project Id,Student ID working on Same Internal Project Id

select distinct 
project.Deadline,
project.weightage,
Project_ID,
Project_Title ,
Project_has_Topics_Internal_Project_ID,
Student_Student_ID
 
	from (project  natural join project_has_topics natural join project_has_student)
    
	where (
				Project_ID=Project_Project_ID and  Internal_Project_ID=Project_has_Topics_Internal_Project_ID and Project_ID=1
		   );

 -- Q8 student first name ,Address,ID,Grade_point in Alfabetical order

 select distinct
 Student_Student_ID,
 student.First_Name,
 Address,
 Email_ID ,
 Grade_Points_Grade
 from (grades natural join student ) 
 where Student_ID=Student_Student_ID order by First_Name;

 -- Q9 Assignment

 select distinct
 Assignment_ID,
 Total_marks,
 assignments.Date,
 Link,
 weightage
	from (student_has_assignments join assignments) 
 where ( Assignments_Assignment_ID=Assignment_ID );

 -- Q10 FOR ASSIGNMENTS

select sum(weightage*(select sum(marks) from 
student_has_assignments where Student_Student_ID='1401001A01'))/sum(total_marks)
 from Assignments
where assignment_id in (select Assignments_Assignment_ID 
from student_has_assignments where Student_Student_ID='1401001A01');

-- Q11  List of successful research projects
select Research_ID, Title from research_projects where (Status = 'Completed');


-- Q12 The students who are working with maximum research projects
select
  First_Name,
  Last_Name,
  Student_Student_ID,
  max( No_Research_Prj) as No_of_Research_Prj
  from (select First_Name,Last_Name,Student_Student_ID,count(Student_Student_ID) as No_Research_Prj 
	from (select * from student s join research_projects_has_student r_s 
	on(s.Student_ID=r_s.Student_Student_ID))
AS T1
group by
Student_Student_ID
order by
No_Research_prj desc
)
AS T2;
 -- Q13 Student who have completed Reasearch project
select 
First_Name,
Student_ID,
Title 
	from (
    (select * from (research_projects join research_projects_has_student) where Status = 'Completed')
    as t1
	join 
	(select Student_ID,First_Name from (student))
	as t2
          ) 
where Student_ID=Student_Student_ID and Research_ID = Research_Projects_Research_ID;

-- Q14 running class and its time scedule

select
start_time,
end_time,
Class_ID,
Title 
from (time_schedule natural join class) where Class_ID=Class_Class_ID and Day='Monday';

-- Q15 Students who failed two courses in a year and thus have to repeat a year

 select 
 First_Name,
 Last_Name,
 Student_ID
 from(select Student_Student_ID,count(Student_Student_ID) as n 
	from grades g 
    join grade_points gp 
    on(g.Grade_Points_Grade=gp.Grade)
    where Grade_Point<=2.33 group by Student_Student_ID) as T 
 join  
 Student s 
 on(s.Student_ID=T.Student_Student_ID)
 where n>=2;
-- Q16  Total no of class on Monday on Classroom-1

select
count(Title) 
from (time_schedule natural join class) where Class_ID=Class_Class_ID and Day='Monday' and Title='Classroom-1';

-- Q17 Quiz to be held in Classroom-1 and its date, start time, end time and weigthage

select
 Quiz_ID,
 Class_ID,
 Title,
 weightage,
 Date,
 start_time,
 end_time
 from (quizzes natural join class) where  Class_ID=Class_Class_ID and Title='Classroom-1';

-- Q18


 -- Q28 Number of professors in given department
 
 select 
 Department_type,
 no_of_prof 
from (select count(Department_Department_ID)as no_of_prof,Department_Department_ID  
	from department_has_faculty df 
    join 
    faculty f on (df.Faculty_Faculty_ID=f.Faculty_id) 
    group by Department_Department_ID) as t 
join department d on(t.Department_Department_ID=d.Department_ID) where Department_type="Mechanical";

-- Q31 Number of graduating students in a given year in a given department for a given program

select (First_Name,Last_Name,Student_ID) from 
	(select * from 
		(select * from 
        department_has_student ds join department d 
			on(ds.Department_Department_ID=d.Department_ID)) as dsd 
            join 
            program p on(dsd.Program_Program_ID=p.Program_ID) 
            where 
		year(Date_of_joining)=2013 and Program_type="Btech" and Department_type="ICT") AS t 
	join student s on(s.Student_ID=t.Student_Student_ID);

-- Q32 Student who has scored above avreage in quiz 1 and exam 1 
 
 select
 First_Name,
 Last_Name,
 Student_Student_ID
 from (select * from (
	(select Student_Student_ID from 
	(
	select Student_Student_ID,T.Quizzes_Quiz_ID,a,Marks from 
	(
		select Quizzes_Quiz_ID,avg(Marks) as a from student_has_quizzes group by Quizzes_Quiz_ID
	) as T 
    join 
    student_has_quizzes q on(q.Quizzes_Quiz_ID=T.Quizzes_Quiz_ID)
) as t2 
where Quizzes_Quiz_ID = 1 and Marks > a ) as m1
natural join
(select Student_Student_ID from 
(
	select Student_Student_ID,T1.Exams_Exam_ID,a,Marks from 
    (
		select Exams_Exam_ID,avg(Marks) as a from student_has_exams group by Exams_Exam_ID
	) as T1 
    join 
    student_has_exams q1 on(q1.exams_exam_ID=T1.exams_exam_ID)
) as t3 
where Exams_Exam_ID = 1 and Marks > a) as m2 
-- on (m1.Student_Student_ID=m2.Student_Student_ID)
)
)as n 
join 
student s
on (s.Student_ID=n.Student_Student_ID);
