insert into Hospital_Information.Appointment() values ('3112192MH001','F2004MH86032','F197820KL120','2019-12-31',null,'A040012','Dry cough, Shortness of breath, Sore throat',null,null);
update Hospital_Information.Appointment
set Status = 'Canceled'
where AppointmentID = '3112192MH001';
insert into Hospital_Information.Appointment() values ('0301202TH002','M1999TH06051',null,'2020-01-03',null,null,'Shortness of breath, Sore throat',null,null);
update Hospital_Information.Appointment
set Status = 'Complete'
where AppointmentID = '0301202TH002 ';
insert into Hospital_Information.Appointment() values ('0501204MK003','M2009MK30116','M197019DT117','2020-01-05','7:31:59','A010001','Severe shortness of breath, Persistent chest pain, Loss of consciousness','On the way to the emergency room',null);
update Hospital_Information.Appointment
set Status = 'Complete'
where AppointmentID = '0501204MK003';
insert into Hospital_Information.Appointment() values ('1001203NT004','M2001NT07832','M197119TB114','2020-01-10','8:30:00','A040013','Shortness of breath, dry cough',null,null);
insert into Hospital_Information.Appointment() values ('1201205CV005','M2004CV30129',null,'2020-01-12',null,'B020045','Heart attack',null,null);
insert into Hospital_Information.Appointment() values ('1201203TL006','M2006TL30087','M197419AK725','2020-01-12',null,'B020045','heart attack',null,null);
update Hospital_Information.Appointment
set Status = 'Complete'
where AppointmentID = '1001203NT004';

update Hospital_Information.Appointment
set Status = 'Complete'
where AppointmentID = '1201205CV005';

update Hospital_Information.Appointment
set Status = 'Complete'
where AppointmentID = '1201203TL006';