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
    Activate nchar(20) NOT NULL,
    PRIMARY KEY(JobId)
);
CREATE TABLE EmpSkill (
    ESId INT primary key auto_increment NOT NULL,
    EmployeeId INT,
    CONSTRAINT fk1 FOREIGN KEY (EmployeeId) 
        REFERENCES Employee (EmployeeId)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    SkillId INT,
    CONSTRAINT fk2 FOREIGN KEY (SkillId)
        REFERENCES Skill (SkillId)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    ExpYear INT NOT NULL
)  ENGINE=INNODB;
					

CREATE TABLE EmpJob (
    EJId INT primary key auto_increment NOT NULL,
    EmployeeId INT,
    CONSTRAINT fk_empid FOREIGN KEY (EmployeeId) 
        REFERENCES Employee (EmployeeId)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    JobId INT,
    CONSTRAINT fk_jobid FOREIGN KEY (JobId)
        REFERENCES Job (JobId)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    Recruited varchar(20) NOT NULL
)  ENGINE=INNODB;
Select * from skill;


    
    