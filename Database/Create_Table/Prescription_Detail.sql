-- Entity: PRESCRIPTIONDETAIL
create table Hospital_Information.PrescriptionDetail(
DetailID int auto_increment primary key,
PrescriptionID varchar(12) not null,
MedicineName nvarchar(255) not null,
Dosage nvarchar(255) not null,
Frequency nvarchar(255) not null,
Duration nvarchar(255) not null,
ExpirationDate date,
Note nvarchar(255) not null,
	-- Link information to table information 'Prescription'
foreign key (PrescriptionID) references hospital_information.prescription(PrescriptionID)
);