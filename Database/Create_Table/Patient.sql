-- Entity: PATIENT
create table Hospital_Information.Patient(
PatientID varchar(12) primary key,
FullName nvarchar(255) not null,
DOB date not null,
Sex enum('Male','Female') not null,
HealthInsurance varchar(15) unique, -- in VietNam
Address nvarchar(255),
PhoneNumber varchar(10) not null unique, -- in VietNam
Email nvarchar(255) unique
);