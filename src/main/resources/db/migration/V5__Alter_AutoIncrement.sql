ALTER TABLE visit.employee DROP FOREIGN KEY employee_outpost;
ALTER TABLE visit.user DROP FOREIGN KEY user_employee;
ALTER TABLE visit.visit DROP FOREIGN KEY visit_employee;
ALTER TABLE visit.visit DROP FOREIGN KEY visit_customer;
ALTER TABLE visit.schedule DROP FOREIGN KEY schedule_employee;

ALTER TABLE visit.outpost MODIFY id BIGINT(6) AUTO_INCREMENT;
ALTER TABLE visit.employee MODIFY id BIGINT(6) AUTO_INCREMENT;
ALTER TABLE visit.customer MODIFY id BIGINT(6) AUTO_INCREMENT;
ALTER TABLE visit.visit MODIFY id BIGINT(6) AUTO_INCREMENT;
ALTER TABLE visit.schedule MODIFY id BIGINT(6) AUTO_INCREMENT;
ALTER TABLE visit.user MODIFY id BIGINT(6) AUTO_INCREMENT;

ALTER TABLE visit.employee ADD CONSTRAINT employee_outpost FOREIGN KEY (idOutpost) REFERENCES visit.outpost(id);
ALTER TABLE visit.user ADD CONSTRAINT user_employee FOREIGN KEY (idEmployee) REFERENCES visit.employee(id);
ALTER TABLE visit.visit  ADD CONSTRAINT visit_employee FOREIGN KEY (idEmployee) REFERENCES visit.employee(id);
ALTER TABLE visit.visit ADD CONSTRAINT visit_customer FOREIGN KEY (idCustomer) REFERENCES visit.customer(id);
ALTER TABLE visit.schedule ADD CONSTRAINT schedule_employee FOREIGN KEY (idEmployee) REFERENCES visit.employee(id);