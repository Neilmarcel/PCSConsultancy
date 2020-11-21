create database pcsdb;
use pcsdb;
CREATE TABLE Employee (
    EmployeeId INT AUTO_INCREMENT,
    FirstName NVARCHAR(50) NOT NULL,
    LastName NVARCHAR(50) NOT NULL,
    UserId NVARCHAR(256) NOT NULL,
    Password NVARCHAR(30) NOT NULL,
    Role NVARCHAR(50) NOT NULL,
    Gender NCHAR(20) NOT NULL,
    Active NCHAR(10) NOT NULL,
    PRIMARY KEY(EmployeeId)
);

CREATE TABLE Skill (
    SkillId INT AUTO_INCREMENT,
    SkillName NVARCHAR(50) NOT NULL,
    SkillDescription NVARCHAR(400) NOT NULL,
    Active NCHAR(10) NOT NULL,
    PRIMARY KEY(SkillId)
);

CREATE TABLE Job (
    JobId INT AUTO_INCREMENT,
    JobTitle NVARCHAR(50) NOT NULL,
    JobDescription NVARCHAR(400) NOT NULL,
    CompanyName NVARCHAR(50) NOT NULL,
    Location GEOMETRY NULL,
    KeySkill NVARCHAR(50) NOT NULL,
    Salary DECIMAL(15 , 4 ) NULL,
    Activate BIT NOT NULL,
    PRIMARY KEY(JobId)
);
                 
CREATE TABLE EmpSkill (
    ESId INT AUTO_INCREMENT,
    EmployeeId INT NOT NULL,
    CONSTRAINT fk1 FOREIGN KEY (EmployeeId)
        REFERENCES Employee (EmployeeId),
    SkillId INT NOT NULL,
    CONSTRAINT fk2 FOREIGN KEY (SkillId)
        REFERENCES Skill (SkillId),
    ExpYear SMALLINT NOT NULL,
    PRIMARY KEY (ESId)
);
CREATE TABLE EmpJob (
    EJId INT AUTO_INCREMENT,
    EmployeeId INT NOT NULL,
    CONSTRAINT EmployeeId FOREIGN KEY (EmployeeId)
        REFERENCES Employee (EmployeeId),
    JobId INT NOT NULL,
    CONSTRAINT JobId FOREIGN KEY (JobId)
        REFERENCES Job(JobId),
    Recruited NVARCHAR(20) NOT NULL,
    PRIMARY KEY(EJId)
);

Select * from employee;


    
    