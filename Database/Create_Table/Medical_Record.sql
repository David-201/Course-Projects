-- Entity: MEDICALRECORD
create table Hospital_Information.MedicalRecord(
RecordID varchar(12) primary key,
PatientID varchar(12) not null,
VisitDate date not null,
Diagnosis nvarchar(255) not null,
Prescription nvarchar(255) not null,
Note nvarchar(255),
	-- Link information to table information 'Patient'
foreign key (PatientID) references hospital_information.patient(PatientID)
);