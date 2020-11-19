
use pcsdb;
CREATE TABLE Employee (
    EmployeeId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName NVARCHAR(50) NOT NULL,
    LastName NVARCHAR(50) NOT NULL,
    UserId NVARCHAR(256) NOT NULL,
    Password VARCHAR(10) NOT NULL,
    Gender NCHAR(1) NOT NULL,
    Role NVARCHAR(50) NOT NULL,
    Active NCHAR(1) NOT NULL
);
CREATE TABLE Skill (
    SkillId INT PRIMARY KEY AUTO_INCREMENT,
    SkillName NVARCHAR(50) NOT NULL,
    SkillDescription NVARCHAR(400) NOT NULL,
    Active NCHAR(1) NOT NULL
);

create table Job(JobId int primary key AUTO_INCREMENT,
				 JobTitle nvarchar(50) not null,
				 JobDescription nvarchar(400) not null,
				 CompanyName nvarchar(50) not null,
				 Location GEOMETRY null,
				 KeySkill nvarchar(50) not null,
				 Salary decimal(15,4) null,
				 Activate bit not null);
CREATE TABLE EmpSkill (
    ESId INT PRIMARY KEY AUTO_INCREMENT,
    EmployeeId INT NOT NULL,
    CONSTRAINT fk1 FOREIGN KEY (EmployeeId)
        REFERENCES Employee (EmployeeId),
    SkillId INT NOT NULL,
    CONSTRAINT fk2 FOREIGN KEY (SkillId)
        REFERENCES Skill (SkillId),
    ExpYear SMALLINT NOT NULL
);
CREATE TABLE EmpJob (
    EJId INT PRIMARY KEY AUTO_INCREMENT,
    EmployeeId INT NOT NULL,
    CONSTRAINT EmployeeId FOREIGN KEY (EmployeeId)
        REFERENCES Employee (EmployeeId),
    JobId INT NOT NULL,
    CONSTRAINT JobId FOREIGN KEY (JobId)
        REFERENCES Job(JobId),
    Recruited BIT NOT NULL
);
Select * from empjob