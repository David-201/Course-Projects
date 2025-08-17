-- Entity: STAFF
create table Hospital_Information.Staff(
StaffID varchar(12) primary key,
FullName nvarchar(255) not null,
DOB date not null,
Sex enum('Male','Female') not null,
CitizenIdentification varchar(20) not null unique,
Address nvarchar(255),
PhoneNumber varchar(10) not null unique, -- int VietNam
Email nvarchar(255) not null unique,
DepartmentID varchar(12) not null,
Position nvarchar(255) not null,
Note nvarchar(255),
	-- Link information to table information 'Hospital_Information.Department'
foreign key (DepartmentID) references hospital_information.department(DepartmentID)
);