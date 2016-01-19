ALTER TABLE visit.outpost MODIFY id BIGINT(6);
ALTER TABLE visit.employee MODIFY id BIGINT(6);
ALTER TABLE visit.visit MODIFY id BIGINT(6);
ALTER TABLE visit.customer MODIFY id BIGINT(6);
ALTER TABLE visit.schedule MODIFY id BIGINT(6);
ALTER TABLE visit.user MODIFY id BIGINT(6);

ALTER TABLE visit.employee MODIFY idOutpost BIGINT(6);
ALTER TABLE visit.user MODIFY idEmployee BIGINT(6);
ALTER TABLE visit.visit MODIFY idEmployee BIGINT(6);
ALTER TABLE visit.visit MODIFY idCustomer BIGINT(6);

ALTER TABLE visit.schedule ADD idEmployee BIGINT(6) after endTime;
ALTER TABLE visit.schedule ADD CONSTRAINT fk_Employee FOREIGN KEY (idEmployee) REFERENCES visit.employee(id);
ALTER TABLE visit.schedule MODIFY startTime datetime;
ALTER TABLE visit.schedule MODIFY endTime datetime;

ALTER TABLE visit.visit DROP COLUMN Time;
ALTER TABLE visit.visit DROP COLUMN Date;
ALTER TABLE visit.visit ADD startDate datetime;
ALTER TABLE visit.visit ADD endDate datetime;




