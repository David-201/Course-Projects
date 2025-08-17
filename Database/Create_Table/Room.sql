-- Entity: ROOM
create table Hospital_Information.Room(
RoomName varchar(7) primary key, -- x000000 (1-2-4): area-floor-Random
DepartmentID varchar(12),
RoomType nvarchar(255),
Location nvarchar(255) not null,
Note nvarchar(255),
	-- Link information to table information 'Hospital_Information.Department'
foreign key (DepartmentID) references hospital_information.Department(DepartmentID)
);