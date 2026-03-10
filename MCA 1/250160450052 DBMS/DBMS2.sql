---> Create dept table

CREATE TABLE Dept1
(
    Dept_id int PRIMARY KEY,
    Dept_name VARCHAR(30),
    Dept_Location VARCHAR(50) 
);

---> Create emp table

CREATE TABLE emp
(
    Emp_id int PRIMARY KEY,
    Emp_name VARCHAR(35),
    Emp_Dept_id int,
    Emp_Boss_id int,
    Emp_salary LONG,
    FOREIGN KEY (Emp_Dept_id) REFERENCES Dept1(Dept_id),
    FOREIGN KEY (Emp_Boss_id) REFERENCES emp(Emp_id)
);


---> insert data into dept1

INSERT INTO dept1(Dept_id,Dept_name,Dept_Location) VALUES (1,'Scince','Ahmedabad');
INSERT INTO dept1(Dept_id,Dept_name,Dept_Location) VALUES (2,'BA','Mumbai');
INSERT INTO dept1(Dept_id,Dept_name,Dept_Location) VALUES (3,'Yog','Bhavanagar');

---> insert data into Emp2

INSERT INTO emp(Emp_id, Emp_name, Emp_Dept_id, Emp_Boss_id, Emp_salary) VALUES (101,'Ketan',1,NULL, 55000);
INSERT INTO emp(Emp_id, Emp_name, Emp_Dept_id, Emp_Boss_id, Emp_salary) VALUES (102,'John',1,101, 52000);
INSERT INTO emp(Emp_id, Emp_name, Emp_Dept_id, Emp_Boss_id, Emp_salary) VALUES (103,'Make',1,101, 57000);
INSERT INTO emp(Emp_id, Emp_name, Emp_Dept_id, Emp_Boss_id, Emp_salary) VALUES (201,'Vishal',2, NULL, 80000);
INSERT INTO emp(Emp_id, Emp_name, Emp_Dept_id, Emp_Boss_id, Emp_salary) VALUES (202,'Mike',2, 201, 75000);
INSERT INTO emp(Emp_id, Emp_name, Emp_Dept_id, Emp_Boss_id, Emp_salary) VALUES (203,'David',2, 201, 79000);
INSERT INTO emp(Emp_id, Emp_name, Emp_Dept_id, Emp_Boss_id, Emp_salary) VALUES (301,'Carry',3,NULL, 62000);
INSERT INTO emp(Emp_id, Emp_name, Emp_Dept_id, Emp_Boss_id, Emp_salary) VALUES (302,'Vello',3,301, 61000);
INSERT INTO emp(Emp_id, Emp_name, Emp_Dept_id, Emp_Boss_id, Emp_salary) VALUES (303,'jens',3,301, 60000);

---> (1)show emp_name,employee department name,boss name and boss salary

SELECT 
    e.emp_name AS employee_name,
    d1.dept_name AS emp_dept_name,
    m.emp_name AS boss_name,
    m.emp_salary AS boss_salary
FROM 
    emp e
JOIN 
    Dept1 d1 ON e.Emp_Dept_id = d1.Dept_id
LEFT JOIN 
    emp m ON e.Emp_Boss_id = m.Emp_id;


---> (2) show those emp whose salary is greater than their boss

SELECT 
    e.Emp_name AS employee_name,
    d1.Dept_name AS emp_dept_name,
    m.Emp_name AS boss_name,
    d2.Dept_name AS boss_dept_name
FROM 
    emp e
JOIN 
    Dept1 d1 ON e.Emp_Dept_id = d1.Dept_id
LEFT JOIN 
    emp m ON e.Emp_Boss_id = m.Emp_id
LEFT JOIN 
    Dept1 d2 ON m.Emp_Dept_id = d2.Dept_id
WHERE 
    e.Emp_salary > m.Emp_salary;

		

---> Trigger

--create table account

CREATE TABLE account 
(
    acc_no INT PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL
);

---> create table account_summary

CREATE TABLE account_summary
(
	total_amount DECIMAL(15, 2) NOT NULL
);
---> insert into acount_summary

INSERT INTO account_summary (total_amount) VALUES (0.00);

---> create trigger

DELIMITER $$

CREATE TRIGGER after_account_insert
AFTER INSERT ON account
FOR EACH ROW
BEGIN
    UPDATE account_summary
    SET total_amount = total_amount + NEW.amount;
END$$

DELIMITER ;

---> insert into ACCOUNT

INSERT INTO account(acc_no,amount) VALUES (76786262,12000);
INSERT INTO account(acc_no,amount) VALUES (85693201,11100);
INSERT INTO account(acc_no,amount) VALUES (10235647,33000);

SELECT * FROM account_summary;


---> deadlock

CREATE TABLE accounts (
    acc_id INT PRIMARY KEY,
    acc_name VARCHAR(50),
    balance DECIMAL(10,2)
);


INSERT INTO accounts VALUES
(1, 'MAYANK', 5000.00),
(2, 'VIVEK', 35000.00);

user-1
START TRANSACTION;
UPDATE accounts SET balance = balance - 200 WHERE acc_id = 1; 
 
user-2
START TRANSACTION;
UPDATE accounts SET balance = balance - 200 WHERE acc_id = 2;  
