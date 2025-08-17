-- Entity: STAFFSCHEDULE
create table Hospital_Information.StaffSchedule(
ScheduleID int auto_increment primary key,
StaffID varchar(12) not null,
WorkDate date not null,
StartTime time not null,
EndTime time not null,
RoomName varchar(7) not null,
Note nvarchar(255),
	-- Link information to table information 'Staff,Room'
foreign key (StaffID) references hospital_information.staff(StaffID),
foreign key (RoomName) references hospital_information.room(RoomName)
);