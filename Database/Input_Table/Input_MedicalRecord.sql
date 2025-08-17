insert into	Hospital_Information.MedicalRecord() values ('000000000001','M1999TH06051','2020-01-03','','',null);
Update Hospital_Information.MedicalRecord
set Diagnosis = 'Respiratory obstruction due to phlegm',
Prescription = 'Dexamethasone, Albuterol'
where RecordID = '000000000001';
insert into	Hospital_Information.MedicalRecord() values ('000000000002','M2009MK30116','2020-01-05','','',null);
Update Hospital_Information.MedicalRecord
set Diagnosis = 'Covid-19 causes severe heart failure',
Note = 'dead'
where RecordID = '000000000002';
insert into	Hospital_Information.MedicalRecord() values ('000000000003','M2001NT07832','2020-01-10','','',null);
Update Hospital_Information.MedicalRecord
set Diagnosis = 'Covid-19 virus infection'
where RecordID = '000000000003';
insert into	Hospital_Information.MedicalRecord() values ('000000000004','M2004CV30129','2020-01-12','','',null);
insert into	Hospital_Information.MedicalRecord() values ('000000000005','M2006TL30087','2020-01-12','','',null);
Update Hospital_Information.MedicalRecord
set Note = 'covid-19 infection leads to death'
where RecordID = '000000000004';

Update Hospital_Information.MedicalRecord
set Diagnosis = 'Covid-19 infection leads to heart failure, falls down stairs at night', 
	Note = 'death'
where RecordID = '000000000004';

Update Hospital_Information.MedicalRecord
set Diagnosis = 'Covid-19 infection leads to severe heart failure, stroke at night', 
	Note = 'death'
where RecordID = '000000000005';