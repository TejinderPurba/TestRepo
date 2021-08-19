drop database conygre;
CREATE DATABASE IF NOT EXISTS conygre;
use conygre;

CREATE TABLE `conygre`.`bonds` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date_time` DATETIME NOT NULL,
  `issuer` VARCHAR(50) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `bond_type` VARCHAR(50) NOT NULL,
  `transaction_type` INT NOT NULL,
  `face_value` FLOAT NOT NULL,
  `maturity` DATETIME NOT NULL,
  `coupon_rate` FLOAT NOT NULL,
  `total_value` FLOAT NOT NULL,
  PRIMARY KEY (`id`));

insert into bonds values (1, "2021-05-21 12:12:12", "MAN", "Manitoba Savings Bonds","Fixed-rate bonds", 0, 1000, "2025-09-05 00:09:00", 2.7, 1000);
insert into bonds values (2, "2021-06-08 9:42:12", "QC", "Quebec Savings Bonds", "Fixed-rate bonds",0, 2000, "2029-09-01 00:09:00", 2.3, 2000);
insert into bonds values (3, "2021-07-01 12:12:12", "ONT", "Ontario Savings Bonds","Fixed-rate bonds", 0, 3000, "2023-09-08 00:09:00", 2.9, 3000);
insert into bonds values (4, "2021-08-10 16:12:12", "BC", "British Columbia Savings Bonds", "Fixed-rate bonds",0, 4000, "2027-11-19 00:09:00", 2.7, 4000);
insert into bonds values (5, "2021-03-19 10:12:12", "CAN", "Canada Savings Bonds", "Fixed-rate bonds",0, 1000, "2029-06-01 00:09:00", 2.25, 1000);
