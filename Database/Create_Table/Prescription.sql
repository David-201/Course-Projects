-- Entity: PRESCRIPTION
create table Hospital_Information.Prescription(
PrescriptionID varchar(12) primary key, 
RecordID varchar(12) not null,
PrescriptionDate date not null,
Note nvarchar(255),
	-- Link information to table information 'Medical Record'
foreign key (RecordID) references hospital_information.medicalrecord(RecordID)
);