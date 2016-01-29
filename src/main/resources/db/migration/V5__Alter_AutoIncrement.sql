ALTER TABLE visit.employee DROP FOREIGN KEY employee_ibfk_1;
ALTER TABLE visit.user DROP FOREIGN KEY user_ibfk_1;
ALTER TABLE visit.visit DROP FOREIGN KEY visit_ibfk_1;
ALTER TABLE visit.visit DROP FOREIGN KEY visit_ibfk_2;
ALTER TABLE visit.schedule DROP FOREIGN KEY schedule_ibfk_1;

ALTER TABLE visit.outpost MODIFY id BIGINT(6) AUTO_INCREMENT;
ALTER TABLE visit.employee MODIFY id BIGINT(6) AUTO_INCREMENT;
ALTER TABLE visit.customer MODIFY id BIGINT(6) AUTO_INCREMENT;
ALTER TABLE visit.visit MODIFY id BIGINT(6) AUTO_INCREMENT;
ALTER TABLE visit.schedule MODIFY id BIGINT(6) AUTO_INCREMENT;
ALTER TABLE visit.user MODIFY id BIGINT(6) AUTO_INCREMENT;

ALTER TABLE visit.employee ADD FOREIGN KEY (idOutpost) REFERENCES visit.outpost(id);
ALTER TABLE visit.user ADD FOREIGN KEY (idEmployee) REFERENCES visit.employee(id);
ALTER TABLE visit.visit  ADD FOREIGN KEY (idEmployee) REFERENCES visit.employee(id);
ALTER TABLE visit.visit ADD FOREIGN KEY (idCustomer) REFERENCES visit.customer(id);
ALTER TABLE visit.schedule ADD FOREIGN KEY (idEmployee) REFERENCES visit.employee(id);