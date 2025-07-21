create database Intern;
use Intern;
show databases;

CREATE TABLE DepartmentHarika (
  Dept_ID VARCHAR(10) primary key,
  Dept_Name VARCHAR(20) NOT NULL
);
INSERT INTO DepartmentHarika(Dept_ID,Dept_Name) VALUES ('D1', 'Computer Science'),('D2', 'Mathematics'), ('D3', 'Physics');

CREATE TABLE CourseHarika (
  Course_ID VARCHAR(10) primary key,
  Course_Name VARCHAR(20) not null,
  Dept_id varchar(10), foreign key(Dept_ID) references DepartmentHarika(Dept_ID) 
);
INSERT INTO CourseHarika(Course_ID,Course_Name,Dept_id) VALUES ('C1', 'DBMS','D1'),('C2', 'Linear Algebra','D2'), ('C3', 'Quantum Mechanics','D3');


CREATE TABLE StudentHarika (
  Student_ID varchar(10) primary key,
  Student_Name VARCHAR(20) not null,
  age INT, DOB DATE,Dept_ID VARCHAR(10), foreign key(Dept_ID) references DepartmentHarika(Dept_ID)
);
INSERT INTO StudentHarika(Student_ID,Student_Name,age,DOB,Dept_ID) VALUES ('S1',"Ravi",22,'2002-06-10','D1'),('S2',"Sneha",23,'2001-03-15','D2'),('S3',"Arjun",21,'2003-01-20','D1');
        

CREATE TABLE ENROLLMENT (STUDENT_ID VARCHAR(10),COURSE_ID VARCHAR(10),
						PRIMARY KEY(STUDENT_ID,COURSE_ID),
                        foreign key(STUDENT_ID) references STUDENTHARIKA(STUDENT_ID),
                         foreign key(COURSE_ID) references COURSEHARIKA(COURSE_ID));
INSERT INTO ENROLLMENT (STUDENT_ID,COURSE_ID) VALUES ('S1','C1'),('S1','C2'),('S2','C1');
SELECT * FROM ENROLLMENT;
        
        
-- Add a new column to the courses table
ALTER TABLE CourseHarika ADD Course_duration varchar(20);

-- Update a student's name.
UPDATE StudentHarika SET Student_Name="Sneha Reddy" WHERE Student_name='sneha';
SELECT * FROM StudentHarika;

-- Delete a course
delete FROM CourseHarika where Course_id='C3';
select * from CourseHarika;
	
-- Show all students older than 21
SELECT * FROM StudentHarika WHERE age>21;

-- Display name,DOB ordered by age(older first)
SELECT Student_Name,DOB,AGE FROM StudentHarika ORDER BY AGE;
    
-- Show top 2 youngest students
SELECT Student_Name,DOB,AGE FROM StudentHarika ORDER BY DOB DESC LIMIT 2;

--  Show student count per department
SELECT DEPT_ID,COUNT(*) AS TOTAL_STUDENTS FROM StudentHarika GROUP BY Dept_ID;

-- find the average age of students per department
SELECT (SELECT dept_Name FROM DepartmentHarika WHERE DepartmentHarika.dept_ID=StudentHarika.dept_ID) AS Dept_Name,
    AVG(age) AS Avg_age
FROM StudentHarika
GROUP BY StudentHarika.dept_ID;

SELECT DEPT_ID,AVG(AGE) FROM STUDENTHARIKA GROUP BY DEPT_ID;

-- get max and min age in the entire table
SELECT MAX(age) AS max_age,MIN(age) AS min_age FROM StudentHarika;


CREATE TABLE Accounts_Harika 
	(account_ID varchar(10) primary key , holder_name varchar(50) not null, balance float);
INSERT INTO Accounts_Harika (account_ID,holder_name,balance) VALUES ('Account1','Alice',5000),('Account2','BOB',3000),('Account3','Charlie',4000);
SELECT * FROM Accounts_harika;

-- Start a Transaction – Transfer ₹1000 from Alice to Bob
START TRANSACTION;
-- updated few column values 
UPDATE Accounts_Harika SET balance=balance-1000 WHERE holder_name = 'Alice';
UPDATE Accounts_Harika SET balance=balance+1000 WHERE holder_name = 'Bob';
SELECT * FROM Accounts_harika;
-- Undoes all changes made in the current transaction that haven't been commited.
ROLLBACK;
SELECT * FROM Accounts_Harika; 

-- New Transaction with SAVEPOINT
START TRANSACTION;
UPDATE Accounts_Harika SET balance=balance-1000 WHERE holder_name = 'Alice';
SAVEPOINT after_debit;
UPDATE Accounts_Harika SET balance=balance+1000 WHERE holder_name = 'Bob';
UPDATE Accounts_Harika SET balance=balance+500 WHERE holder_name = 'Charlie';
ROLLBACK TO after_debit;

COMMIT;

--  Add course_code column and make it as UNIQUE.
ALTER TABLE CourseHarika ADD course_code varchar(10) UNIQUE;
UPDATE CourseHarika SET course_code='CS101' where COURSE_ID='C1';
UPDATE CourseHarika SET course_code='MATH205' where COURSE_ID='C2';
SELECT * FROM CourseHarika;

-- Add a column credits to the courses table and enforce a CHECK constraint
ALTER TABLE Courseharika DROP COLUMN CREDITS;
ALTER TABLE CourseHarika ADD COLUMN credits INT CHECK (credits BETWEEN 1 and 5);
UPDATE CourseHarika SET Credits = 4 where course_id='C2';
UPDATE CourseHarika SET Credits = 5 where course_id='C1';
SELECT * FROM CourseHarika;

-- Display student names along with their department names (INNER JOIN)
SELECT S.STUDENT_NAME,D.DEPT_NAME 
FROM STUDENTHARIKA S
INNER JOIN DEPARTMENTHARIKA D
ON S.DEPT_ID=D.DEPT_ID;

 -- List all departments even if they have no students (LEFT JOIN)
SELECT D.DEPT_ID,S.STUDENT_NAME 
FROM DEPARTMENTHARIKA D
LEFT JOIN STUDENTHARIKA S
ON D.DEPT_ID=S.DEPT_ID;

--  list students older than their department’s average age(correlated query)
SELECT STUDENT_NAME,AGE,DEPT_ID FROM STUDENTHARIKA S WHERE AGE > ( SELECT AVG(S1.AGE) FROM STUDENTHARIKA S1 WHERE S1.DEPT_ID = S.DEPT_ID); 
SELECT * FROM STUDENTHarika;
------  OR ----------
SELECT STUDENT_NAME ,AGE,DEPT_ID
FROM STUDENTHARIKA s 
WHERE age > (SELECT AVG(age) FROM STUDENTHARIKA WHERE dept_id = s.dept_id);

--  Use SELF JOIN to show employee–manager pairs
CREATE TABLE EMPLOYEEHARIKA ( EMP_ID INT PRIMARY KEY,EMP_NAME VARCHAR(20),MANAGER_ID INT );
INSERT INTO EMPLOYEEHARIKA (EMP_ID,EMP_NAME,MANAGER_ID) VALUES (111,'JOHN',222),(333,'JACK',111),(222,'RON',NULL),(555,'MAXI',222);
SELECT * FROM EMPLOYEEHARIKA;

SELECT E1.EMP_NAME AS EMPLOYEE ,E2.EMP_NAME AS MANAGER
 FROM EMPLOYEEHARIKA E1 
LEFT JOIN EMPLOYEEHARIKA E2 ON E1.MANAGER_ID=E2.EMP_ID;

SELECT E1.EMP_NAME AS MANAGER,E2.EMP_NAME AS EMPLOYEE
FROM EMPLOYEEHARIKA E1
RIGHT JOIN EMPLOYEEHARIKA E2 ON E1.EMP_ID=E2.MANAGER_ID;

-- Use a CTE (Common Table Expression) to get student count per department.
WITH STUDENT_COUNT AS (
	SELECT DEPT_ID,COUNT(*) AS STUD_COUNT FROM STUDENTHARIKA GROUP BY STUDENT_ID
)
SELECT * FROM STUDENT_COUNT;



-------------- EVALUATION-----------
-- Write a query to find students who haven't enrolled in any course.
SELECT S.STUDENT_ID,S.STUDENT_NAME,S.DEPT_ID FROM STUDENTHARIKA S
 LEFT JOIN ENROLLMENT E
 ON S.STUDENT_ID=E.STUDENT_ID WHERE E.STUDENT_ID IS NULL;
 
 -- Show course count per department.
SELECT DEPT_ID,COUNT(*) AS COURSE_COUNT FROM COURSEHARIKA GROUP BY COURSE_ID;

SELECT * FROM STUDENTHARIKA;
SELECT * FROM COURSEHARIKA;
SELECT * FROM DEPARTMENTHARIKA;

-- Create a view that shows student names along with their department names

CREATE VIEW DISPLAY_STDNAMES_DEPTNAMES AS
SELECT S.STUDENT_NAME,D.DEPT_NAME FROM STUDENTHARIKA S 
RIGHT JOIN DEPARTMENTHARIKA D ON S.DEPT_ID=D.DEPT_ID; 

--  Query the view to display data
SELECT * FROM DISPLAY_STDNAMES_DEPTNAMES;

-- Attempt to update data via the view (observe if it succeeds or fails and why).
UPDATE DISPLAY_STDNAMES_DEPTNAMES SET STUDENT_NAME="SENHA REDDY" WHERE STUDENT_ID='S3'; 
-- Views with complex queries, like those with joins, subqueries, or aggregate functions, may not be directly updatable.



