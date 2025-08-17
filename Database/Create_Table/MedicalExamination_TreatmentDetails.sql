-- Entity: MEDICAL EXAMINATION AND TREATMENT DETAILS
create table Hospital_Information.MedicalExamination_TreatmentDetails(
ID int auto_increment primary key,
RecordID varchar(12) not null,
Time datetime,
StaffID varchar(12) not null,
RoomName varchar(7) not null,
Result nvarchar(255) not null,
Note nvarchar(255),
	-- Link information to table information 'MedicalRecord,Staff,Room'
foreign key (RecordID) references hospital_information.medicalrecord(RecordID),
foreign key (StaffID) references hospital_information.staff(StaffID),
foreign key (RoomName) references hospital_information.room(RoomName)
);