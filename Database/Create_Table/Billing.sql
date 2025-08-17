-- Entity: BILLING
create table Hospital_Information.Billing(
BillID int auto_increment primary key,
RecordID varchar(12) not null,
Amount decimal(15,5) not null,
BillingDate date not null,
Note nvarchar(255),
	-- Link information to table information 'medicalrecord'
foreign key (RecordID) references hospital_information.medicalrecord(RecordID)
);




