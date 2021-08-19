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

  05-Sep-25

insert into bonds values (1, "2021-01-01 12:12:12", "MAN", "Manitoba Savings Bonds","Fixed-rate bonds", 0, 1000, "2025-09-05 00:09:00", 2.7, 1000);
insert into bonds values (2, "2021-01-02 9:42:12", "QC", "Quebec Savings Bonds", "Fixed-rate bonds",0, 1000, "2029-09-01 00:09:00", 2.3, 1000);
insert into bonds values (3, "2021-01-03 12:12:12", "ONT", "Ontario Savings Bonds","Fixed-rate bonds", 0, 1000, "2023-09-08 00:09:00", 2.9, 1000);
insert into bonds values (4, "2021-01-04 16:12:12", "BC", "British Columbia Savings Bonds", "Fixed-rate bonds",0, 1000, "2027-11-19 00:09:00", 2.7, 1000);
insert into bonds values (5, "2021-01-05 10:12:12", "CAN", "Canada Saving Bonds", "Fixed-rate bonds",0, 1000, "2029-06-01 00:09:00", 2.25, 1000);