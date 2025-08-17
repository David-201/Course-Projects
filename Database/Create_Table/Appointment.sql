-- Entity: APPOINTMENT
create table Hospital_Information.Appointment(
AppointmentID varchar(12) primary key, 
PatientID varchar(12) not null,
StaffID varchar(12),
AppointmentDate date not null,
AppointmentTime time,
RoomName varchar(7),
Purpose nvarchar(255),
Note nvarchar(255),
Status enum('Complete','Canceled'),
	-- Link information to table information 'Patient,Staff,Room'
foreign key (PatientID) references hospital_information.Patient(PatientID),
foreign key (StaffID) references hospital_information.Staff(StaffID),
foreign key (RoomName) references hospital_information.Room(RoomName)
);