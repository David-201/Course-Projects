-- Entity: DEPARTMENT
create table Hospital_Information.Department(
DepartmentID varchar(12) primary key, 
DepartmentName nvarchar(255) not null,
HeadOfDepartment nvarchar(255),
Location varchar(255),
PhoneExtension varchar(10) unique
); 