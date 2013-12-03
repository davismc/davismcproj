-- Student: Merrill Davis
-- CS 347: Database Management
-- October 2013
-- Purpose: models data schema for an IT company

-- Basic information on a person.  Employee table provides further information if the person is an employee    
CREATE TABLE Person
(
	lastName varchar (40) NOT NULL,
	firstName varchar (20) NOT NULL,
	birthDate date,
	id_Person integer,
	PRIMARY KEY(id_Person)
);  

CREATE TABLE Proficiency
(
	proficiencyName varchar (20),
	skillLevel integer,
	PRIMARY KEY(skillLevel)
);

CREATE TABLE Title
(
	titleName varchar (20),
	PRIMARY KEY(titleName)
); 
  
-- Association List allowing a many-to-many relationship between a person and specific titles 
CREATE TABLE Person_Title_List
(
	id_Person integer,
	titleName varchar (50),
	PRIMARY KEY(id_Person, titleName),
	FOREIGN KEY(id_Person) REFERENCES Person (id_Person)
		INITIALLY DEFERRED DEFERRABLE,
	FOREIGN KEY(titleName) REFERENCES Title (titleName)
		INITIALLY DEFERRED DEFERRABLE
); 
  
CREATE TABLE Skill
(
	skillName varchar (50),
	PRIMARY KEY(skillName)
);  
  
-- Association List allowing a many-to-many relationship between a person and specific skills  
CREATE TABLE Person_Skill_List
(
	id_person integer,
	skillName varchar (50),
	skillLevel integer,
	PRIMARY KEY(id_person, skillName),
	FOREIGN KEY(id_person) REFERENCES Person (id_Person)
		INITIALLY DEFERRED DEFERRABLE,
	FOREIGN KEY(skillName) REFERENCES Skill (skillName)
		INITIALLY DEFERRED DEFERRABLE,
	FOREIGN KEY(skillLevel) REFERENCES Proficiency (skillLevel)
		INITIALLY DEFERRED DEFERRABLE
);   

-- Allows a person to have multiple addresses (home, mailing, office, etc)  
CREATE TABLE Address
(
	streetAddress varchar (50),
	city varchar (50),
	state varchar (2),
	zip integer,
	addressType varchar (50),
	id_Address integer,
	id_Person integer NOT NULL,
	PRIMARY KEY(id_Address),
	FOREIGN KEY(id_Person) REFERENCES Person (id_Person)
		INITIALLY DEFERRED DEFERRABLE
);  
  
CREATE TABLE Degree
(
	university varchar (50),
	major varchar (50),
	yearGraduated integer,
	degreeType varchar (50),
	id_Degree integer,
	id_Person integer NOT NULL,
	PRIMARY KEY(id_Degree),
	FOREIGN KEY(id_Person) REFERENCES Person (id_Person)
		INITIALLY DEFERRED DEFERRABLE
);  
  
-- Email addresses - allows a person to have multiple.  Might not be unique, so using an integer key  
CREATE TABLE Email
(
	emailAddress varchar (100),
	id_Email integer,
	id_Person integer NOT NULL,
	PRIMARY KEY(id_Email),
	FOREIGN KEY(id_Person) REFERENCES Person (id_Person)
		INITIALLY DEFERRED DEFERRABLE
);  
 
-- Phone Numbers - allows a person to have multiple (ie home, cell, etc). Might not be unique if shared line
CREATE TABLE PhoneNumber
(
	areaCode integer,
	phoneNum integer,
	phoneType varchar (50),
	id_PhoneNumber integer,
	id_Person integer NOT NULL,
	PRIMARY KEY(id_PhoneNumber),
	FOREIGN KEY(id_Person) REFERENCES Person (id_Person)
		INITIALLY DEFERRED DEFERRABLE
);  

-- Employee is basically a subclass of person
CREATE TABLE Employee
(
	startDate date,
	employeeID varchar (50) NOT NULL,
	gender char,
	race varchar (30),
	managerID integer,
	deptName varchar (50),
	id_Person integer,
	PRIMARY KEY(employeeID),
	FOREIGN KEY(id_Person) REFERENCES Person (id_Person)
			INITIALLY DEFERRED DEFERRABLE
);  

-- Couldn't define this recursive relationship until table employee existed
-- managerID refers to another employee
-- named the constraint to facilitate removal
ALTER TABLE Employee
	ADD CONSTRAINT fk_managerID_emp FOREIGN KEY(managerID) REFERENCES Person (id_Person)
		INITIALLY DEFERRED DEFERRABLE;

CREATE TABLE Department
(
	deptName varchar (20),
	deptPhoneNum varchar (13),
	managerID varchar (50),
	PRIMARY KEY(deptName)
);  

-- Couldn't define these foreign keys until department existed
-- named the constraint to facilitate removal
ALTER TABLE Department
	ADD CONSTRAINT fk_managerID_dept FOREIGN KEY(managerID) REFERENCES Employee (employeeID)
		INITIALLY DEFERRED DEFERRABLE;
ALTER TABLE Employee
	ADD CONSTRAINT fk_deptName FOREIGN KEY(deptName) REFERENCES Department (deptName)
		INITIALLY DEFERRED DEFERRABLE;
		
CREATE TABLE Project
(
	projectName varchar (30),
	id_Project integer,
	projectManager varchar (50),
	PRIMARY KEY(id_Project),
	FOREIGN KEY(projectManager) REFERENCES Employee (employeeID)
		INITIALLY DEFERRED DEFERRABLE
); 

CREATE TABLE ProjectMilestone
(
	milestoneDate date,
	milestoneName varchar (50),
	id_ProjectMilestone integer,
	id_Project integer NOT NULL,
	PRIMARY KEY(id_ProjectMilestone),
	FOREIGN KEY(id_Project) REFERENCES Project (id_Project)
		INITIALLY DEFERRED DEFERRABLE
); 

-- Allows employees to have a many-to-many relationship with projects
CREATE TABLE ProjectParticipants
(
	employeeID varchar (50) NOT NULL,
	id_Project integer NOT NULL,
	PRIMARY KEY(employeeID, id_Project),
	FOREIGN KEY(employeeID) REFERENCES Employee (employeeID)
		INITIALLY DEFERRED DEFERRABLE,
	FOREIGN KEY(id_Project) REFERENCES Project (id_Project)
		INITIALLY DEFERRED DEFERRABLE
);  

-- Allows departments to have a many-to-many relationship with projects
CREATE TABLE ProjectDepartments
(
	deptName varchar (50) NOT NULL,
	id_Project integer NOT NULL,
	PRIMARY KEY(deptName, id_Project),
	FOREIGN KEY(deptName) REFERENCES Department (deptName)
		INITIALLY DEFERRED DEFERRABLE,
	FOREIGN KEY(id_Project) REFERENCES Project (id_Project)
		INITIALLY DEFERRED DEFERRABLE
);  

-- Keep a list of company patents.  May have more than 1 associated employee
CREATE TABLE Patent
(
	patentName varchar (50),
	patentNumber varchar (50),
	issueYear integer,
	issueStatus varchar (50),
	PRIMARY KEY(patentNumber)
); 

-- Allows employees to have a many-to-many relationship with patents
CREATE TABLE PatentEmployee
(
	employeeID varchar (50) NOT NULL,
	patentNumber varchar (50) NOT NULL,
	PRIMARY KEY(employeeID, patentNumber),
	FOREIGN KEY(employeeID) REFERENCES Employee (employeeID)
		INITIALLY DEFERRED DEFERRABLE,
	FOREIGN KEY(patentNumber) REFERENCES Patent (patentNumber)
		INITIALLY DEFERRED DEFERRABLE
); 

-- Subclass of employee that holds payroll info
CREATE TABLE PayrollInfo
(
	SSN varchar (50),
	fedWithholdings integer,
	baseSalary float,
	employeeID varchar (50) NOT NULL,
	PRIMARY KEY(employeeID),
	FOREIGN KEY(employeeID) REFERENCES Employee (employeeID)
		INITIALLY DEFERRED DEFERRABLE
);

CREATE TABLE Bonus
(
	bonusAmount float,
	bonusDate date,
	id_Bonus integer,
	employeeID varchar (50) NOT NULL,
	PRIMARY KEY(id_Bonus),
	FOREIGN KEY(employeeID) REFERENCES Employee (employeeID)
		INITIALLY DEFERRED DEFERRABLE
);  

-- Assigning an id since there's an off chance two insurance companies might use same policy number
CREATE TABLE InsurancePolicy
(
	policyNum integer,
	policyName varchar (50),
	policyCompany varchar (50),
	id_InsurancePolicy integer,
	employeeID varchar (50) NOT NULL,
	PRIMARY KEY(id_InsurancePolicy),
	FOREIGN KEY(employeeID) REFERENCES Employee (employeeID)
		INITIALLY DEFERRED DEFERRABLE
);  

CREATE TABLE VacationAllotment
(
	vacationYear integer,
	vacationDays integer,
	employeeID varchar (50) NOT NULL,
	PRIMARY KEY(vacationYear, employeeID),
	FOREIGN KEY(employeeID) REFERENCES Employee (employeeID)
		INITIALLY DEFERRED DEFERRABLE
); 

CREATE TABLE VacationDay
(
	vacationDate date,
	hoursVacation integer,
	employeeID varchar (50) NOT NULL,
	PRIMARY KEY(vacationDate, employeeID),
	FOREIGN KEY(employeeID) REFERENCES Employee (employeeID)
		INITIALLY DEFERRED DEFERRABLE
);  

CREATE TABLE SickAllotment
(
	sickYear integer,
	sickDays integer,
	employeeID varchar (50) NOT NULL,
	PRIMARY KEY(sickYear, employeeID),
	FOREIGN KEY(employeeID) REFERENCES Employee (employeeID)
		INITIALLY DEFERRED DEFERRABLE
); 

CREATE TABLE SickDay
(
	sickDate date,
	hoursSick integer,
	employeeID varchar (50) NOT NULL,
	PRIMARY KEY(sickDate, employeeID),
	FOREIGN KEY(employeeID) REFERENCES Employee (employeeID)
		INITIALLY DEFERRED DEFERRABLE
); 