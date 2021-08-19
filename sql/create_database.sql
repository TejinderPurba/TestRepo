drop database conygre;
CREATE DATABASE IF NOT EXISTS conygre;
use conygre;

CREATE TABLE `conygre`.`stocks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date_time` DATETIME NOT NULL,
  `symbol` VARCHAR(10) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `transaction_type` INT NOT NULL,
  `quantity_affected` INT NOT NULL,
  `total_quantity` INT NOT NULL,
  `market_value` FLOAT NOT NULL,
  `total_value` FLOAT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `conygre`.`exchange_traded_funds` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date_time` DATETIME NOT NULL,
  `symbol` VARCHAR(10) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `transaction_type` INT NOT NULL,
  `quantity_affected` INT NOT NULL,
  `total_quantity` INT NOT NULL,
  `market_value` FLOAT NOT NULL,
  `total_value` FLOAT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `conygre`.`cash` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date_time` DATETIME NOT NULL,
  `financial_institution` VARCHAR(100) NOT NULL,
  `account_type` INT NOT NULL,
  `transaction_type` INT NOT NULL,
  `balance` FLOAT NOT NULL,
  `transaction_amount` FLOAT NOT NULL,
  `account_number` INT NOT NULL,
  PRIMARY KEY (`id`));

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

use conygre;
insert into stocks values (1, "2021-01-01 12:12:12", "MSFT", "Microsoft", 0, 10, 10, 40, 400);
insert into stocks values (2, "2021-01-02 9:42:12", "MSFT", "Microsoft", 0, 10, 20, 45, 850);
insert into stocks values (3, "2021-01-03 12:12:12", "MSFT", "Microsoft", 0, 10, 30, 38, 1230);
insert into stocks values (4, "2021-01-04 16:12:12", "MSFT", "Microsoft", 0, 10, 40, 42, 1760);
insert into stocks values (5, "2021-01-05 10:12:12", "MSFT", "Microsoft", 0, 10, 50, 45, 2153);
insert into stocks values (6, "2021-01-06 12:12:12", "MSFT", "Microsoft", 0, 10, 60, 47, 2785);
insert into stocks values (7, "2021-01-07 13:12:12", "MSFT", "Microsoft", 0, 10, 70, 50, 3350);
insert into stocks values (8, "2021-01-01 15:12:12", "TSLA", "TESLA", 0, 10, 10, 40, 4000);
insert into stocks values (9, "2021-01-02 9:42:12", "TSLA", "TESLA", 0, 10, 20, 45, 8500);
insert into stocks values (10, "2021-01-03 14:12:12", "TSLA", "TESLA", 0, 10, 30, 38, 12030);
insert into stocks values (11, "2021-01-04 11:12:12", "TSLA", "TESLA", 0, 10, 40, 42, 45064);
insert into stocks values (12, "2021-01-05 10:18:12", "TSLA", "TESLA", 0, 10, 50, 45, 45048);
insert into stocks values (13, "2021-01-06 12:12:12", "TSLA", "TESLA", 0, 10, 60, 47, 45405);
insert into stocks values (14, "2021-01-07 14:18:12", "TSLA", "TESLA", 0, 10, 70, 50, 45608);
insert into stocks values (15, "2021-02-01 15:12:12", "FR", "First Majestic", 0, 100, 100, 15, 54783);
insert into stocks values (16, "2021-02-02 9:42:12", "FR", "First Majestic", 0, 100, 200, 20, 54557);
insert into stocks values (17, "2021-03-03 14:12:12", "FR", "First Majestic", 0, 100, 300, 18, 54600);
insert into stocks values (18, "2021-04-04 11:12:12", "FR", "First Majestic", 0, 100, 400, 11, 54181);
insert into stocks values (19, "2021-05-05 10:18:12", "FR", "First Majestic", 0, 100, 500, 10, 54058);
insert into stocks values (20, "2021-06-06 12:12:12", "FR", "First Majestic", 0, 100, 600, 18, 54954);
insert into stocks values (21, "2021-07-07 14:18:12", "FR", "First Majestic", 0, 100, 700, 13, 59553);
insert into stocks values (22, "2021-02-01 12:12:12", "MSFT", "Microsoft", 1, 10, 60, 51, 2985);
insert into stocks values (23, "2021-02-02 9:42:12", "MSFT", "Microsoft", 1, 10, 50, 52, 2203);
insert into stocks values (24, "2021-02-03 12:12:12", "MSFT", "Microsoft", 1, 10, 40, 54, 1860);
insert into stocks values (25, "2021-02-04 16:12:12", "MSFT", "Microsoft", 1, 10, 30, 54, 1330);
insert into stocks values (26, "2021-02-05 10:12:12", "MSFT", "Microsoft", 1, 10, 20, 56, 950);
insert into stocks values (27, "2021-02-06 12:12:12", "MSFT", "Microsoft", 1, 10, 10, 58, 580);
insert into stocks values (28, "2021-02-07 13:12:12", "MSFT", "Microsoft", 1, 10, 0, 60, 0);
insert into stocks values (29, "2021-06-01 15:12:12", "GS", "Goldman Sachs", 0, 1000, 1000, 1000, 4000);
insert into stocks values (30, "2021-06-02 9:42:12", "GS", "Goldman Sachs", 1, 1000, 0, 1100, 0);
insert into stocks values (31, "2021-06-03 14:12:12", "GS", "Goldman Sachs", 0, 1000, 1000, 1050, 12030);
insert into stocks values (32, "2021-06-04 11:12:12", "GS", "Goldman Sachs", 1, 1000, 0, 1000, 0);
insert into stocks values (33, "2021-06-05 10:18:12", "GS", "Goldman Sachs", 0, 1000, 1000, 1100, 45048);
insert into stocks values (34, "2021-06-06 12:12:12", "GS", "Goldman Sachs", 1, 1000, 0, 1200, 0);
insert into stocks values (35, "2021-06-07 14:18:12", "GS", "Goldman Sachs", 0, 1000, 1000, 900, 90000);
insert into stocks values (36, "2021-08-01 15:12:12", "ABM", "ABM Industries", 0, 100, 100, 15, 54783);
insert into stocks values (37, "2021-08-02 9:42:12", "ABM", "ABM Industries", 0, 100, 200, 20, 54557);
insert into stocks values (38, "2021-08-03 14:12:12", "ABM", "ABM Industries", 0, 100, 300, 18, 54600);
insert into stocks values (39, "2021-08-04 11:12:12", "ABM", "ABM Industries", 0, 100, 400, 11, 54181);
insert into stocks values (40, "2021-08-05 10:18:12", "ABM", "ABM Industries", 0, 100, 500, 10, 54058);
insert into stocks values (41, "2021-08-06 12:12:12", "ABM", "ABM Industries", 0, 100, 600, 18, 54954);
insert into stocks values (42, "2021-08-07 14:18:12", "ABM", "ABM Industries", 0, 100, 700, 13, 59553);

use conygre; 
insert into exchange_traded_funds values (1, "2021-01-01 12:12:12", "MSFT", "Microsoft", 0, 10, 10, 40, 400);
insert into exchange_traded_funds values (2, "2021-01-02 9:42:12", "MSFT", "Microsoft", 0, 10, 20, 45, 850);
insert into exchange_traded_funds values (3, "2021-01-03 12:12:12", "MSFT", "Microsoft", 0, 10, 30, 38, 1230);
insert into exchange_traded_funds values (4, "2021-01-04 16:12:12", "MSFT", "Microsoft", 0, 10, 40, 42, 4564);
insert into exchange_traded_funds values (5, "2021-01-05 10:12:12", "MSFT", "Microsoft", 0, 10, 50, 45, 4548);
insert into exchange_traded_funds values (6, "2021-01-06 12:12:12", "MSFT", "Microsoft", 0, 10, 60, 47, 4545);
insert into exchange_traded_funds values (7, "2021-01-07 13:12:12", "MSFT", "Microsoft", 0, 10, 70, 50, 4568);
insert into exchange_traded_funds values (8, "2021-01-01 15:12:12", "TSLA", "TESLA", 0, 10, 10, 40, 4000);
insert into exchange_traded_funds values (9, "2021-01-02 9:42:12", "TSLA", "TESLA", 0, 10, 20, 45, 8500);
insert into exchange_traded_funds values (10, "2021-01-03 14:12:12", "TSLA", "TESLA", 0, 10, 30, 38, 12030);
insert into exchange_traded_funds values (11, "2021-01-04 11:12:12", "TSLA", "TESLA", 0, 10, 40, 42, 45064);
insert into exchange_traded_funds values (12, "2021-01-05 10:18:12", "TSLA", "TESLA", 0, 10, 50, 45, 45048);
insert into exchange_traded_funds values (13, "2021-01-06 12:12:12", "TSLA", "TESLA", 0, 10, 60, 47, 45405);
insert into exchange_traded_funds values (14, "2021-01-07 14:18:12", "TSLA", "TESLA", 0, 10, 70, 50, 45608);
insert into exchange_traded_funds values (15, "2021-02-01 15:12:12", "FR", "First Majestic", 0, 100, 100, 15, 54783);
insert into exchange_traded_funds values (16, "2021-02-02 9:42:12", "FR", "First Majestic", 0, 100, 200, 20, 54557);
insert into exchange_traded_funds values (17, "2021-03-03 14:12:12", "FR", "First Majestic", 0, 100, 300, 18, 54600);
insert into exchange_traded_funds values (18, "2021-04-04 11:12:12", "FR", "First Majestic", 0, 100, 400, 11, 54181);
insert into exchange_traded_funds values (19, "2021-05-05 10:18:12", "FR", "First Majestic", 0, 100, 500, 10, 54058);
insert into exchange_traded_funds values (20, "2021-06-06 12:12:12", "FR", "First Majestic", 0, 100, 600, 18, 54954);
insert into exchange_traded_funds values (21, "2021-07-07 14:18:12", "FR", "First Majestic", 0, 100, 700, 13, 59553);
insert into exchange_traded_funds values (22, "2021-02-01 12:12:12", "MSFT", "Microsoft", 1, 10, 60, 51, 2985);
insert into exchange_traded_funds values (23, "2021-02-02 9:42:12", "MSFT", "Microsoft", 1, 10, 50, 52, 2203);
insert into exchange_traded_funds values (24, "2021-02-03 12:12:12", "MSFT", "Microsoft", 1, 10, 40, 54, 1860);
insert into exchange_traded_funds values (25, "2021-02-04 16:12:12", "MSFT", "Microsoft", 1, 10, 30, 54, 1330);
insert into exchange_traded_funds values (26, "2021-02-05 10:12:12", "MSFT", "Microsoft", 1, 10, 20, 56, 950);
insert into exchange_traded_funds values (27, "2021-02-06 12:12:12", "MSFT", "Microsoft", 1, 10, 10, 58, 580);
insert into exchange_traded_funds values (28, "2021-02-07 13:12:12", "MSFT", "Microsoft", 1, 10, 0, 60, 0);
insert into exchange_traded_funds values (29, "2021-06-01 15:12:12", "GS", "Goldman Sachs", 0, 1000, 1000, 1000, 4000);
insert into exchange_traded_funds values (30, "2021-06-02 9:42:12", "GS", "Goldman Sachs", 1, 1000, 0, 1100, 0);
insert into exchange_traded_funds values (31, "2021-06-03 14:12:12", "GS", "Goldman Sachs", 0, 1000, 1000, 1050, 12030);
insert into exchange_traded_funds values (32, "2021-06-04 11:12:12", "GS", "Goldman Sachs", 1, 1000, 0, 1000, 0);
insert into exchange_traded_funds values (33, "2021-06-05 10:18:12", "GS", "Goldman Sachs", 0, 1000, 1000, 1100, 45048);
insert into exchange_traded_funds values (34, "2021-06-06 12:12:12", "GS", "Goldman Sachs", 1, 1000, 0, 1200, 0);
insert into exchange_traded_funds values (35, "2021-06-07 14:18:12", "GS", "Goldman Sachs", 0, 1000, 1000, 900, 90000);
insert into exchange_traded_funds values (36, "2021-08-01 15:12:12", "ABM", "ABM Industries", 0, 100, 100, 15, 54783);
insert into exchange_traded_funds values (37, "2021-08-02 9:42:12", "ABM", "ABM Industries", 0, 100, 200, 20, 54557);
insert into exchange_traded_funds values (38, "2021-08-03 14:12:12", "ABM", "ABM Industries", 0, 100, 300, 18, 54600);
insert into exchange_traded_funds values (39, "2021-08-04 11:12:12", "ABM", "ABM Industries", 0, 100, 400, 11, 54181);
insert into exchange_traded_funds values (40, "2021-08-05 10:18:12", "ABM", "ABM Industries", 0, 100, 500, 10, 54058);
insert into exchange_traded_funds values (41, "2021-08-06 12:12:12", "ABM", "ABM Industries", 0, 100, 600, 18, 54954);
insert into exchange_traded_funds values (42, "2021-08-07 14:18:12", "ABM", "ABM Industries", 0, 100, 700, 13, 59553);

use conygre; 
insert into cash values(1, "2021-06-01 9:32:12", "Citi", 1, 0, 1000, 1000, 102010415);
insert into cash values(2, "2021-06-02 9:32:12", "Citi", 1, 0, 2000, 1000, 102010415);
insert into cash values(3, "2021-06-03 9:32:12", "Citi", 1, 0, 3000, 1000, 102010415);
insert into cash values(4, "2021-06-04 13:32:12", "Citi", 1, 1, 1000, 2000, 102010415);
insert into cash values(5, "2021-06-05 9:32:12", "Citi", 2, 0, 1000, 1000, 102010425);
insert into cash values(6, "2021-06-06 11:32:12", "Citi", 2, 0, 1100, 100, 102010425);
insert into cash values(7, "2021-06-07 12:32:12", "Citi", 2, 0, 1900, 800, 102010425);
insert into cash values(8, "2021-06-08 11:32:12", "Citi", 2, 0, 2900, 1000, 102010425);
insert into cash values(9, "2021-06-09 10:32:12", "Citi", 1, 0, 2000, 1000, 102010415);
insert into cash values(10, "2021-06-10 10:32:12", "Citi", 1, 1, 1500, 500, 102010415);
insert into cash values(11, "2021-06-01 9:32:12", "Bank of America", 2, 0, 1150, 150, 358048028);
insert into cash values(12, "2021-06-02 9:32:12", "Bank of America", 2, 0, 1300, 150, 358048028);
insert into cash values(13, "2021-06-03 9:32:12", "Bank of America", 4, 0, 1500, 500, 358048048);
insert into cash values(14, "2021-06-04 13:32:12", "Bank of America", 2, 1, 800, 500, 358048028);
insert into cash values(15, "2021-06-05 9:32:12", "Bank of America", 2, 1, 300, 500, 358048028);
insert into cash values(16, "2021-06-06 11:32:12", "Bank of America", 2, 1, 100, 200, 358048028);
insert into cash values(17, "2021-06-07 12:32:12", "Bank of America", 4, 0, 1580, 80, 358048048);
insert into cash values(18, "2021-06-08 11:32:12", "Bank of America", 4, 0, 1680, 100, 358048048);
insert into cash values(19, "2021-06-09 10:32:12", "Bank of America", 2, 0, 1300, 1200, 358048028);
insert into cash values(20, "2021-06-10 10:32:12", "Bank of America", 2, 0, 1750, 450, 358048028);
insert into cash values(21, "2021-06-11 9:32:12", "Morgan Chase", 1, 0, 150, 150, 913823416);
insert into cash values(22, "2021-06-12 9:32:12", "Morgan Chase", 1, 0, 300, 150, 913823416);
insert into cash values(23, "2021-06-13 9:52:12", "Morgan Chase", 1, 0, 500, 200, 913823416);
insert into cash values(24, "2021-06-14 13:32:12", "Morgan Chase", 1, 1, 250, 250, 913823416);
insert into cash values(25, "2021-06-15 9:32:12", "Morgan Chase", 1, 0, 1250, 1000, 913823416);
insert into cash values(26, "2021-06-16 11:32:12", "Morgan Chase", 1, 1, 200, 1050, 913823416);
insert into cash values(27, "2021-06-17 12:32:12", "Morgan Chase", 3, 0, 80, 80, 913823436);
insert into cash values(28, "2021-06-18 10:32:12", "Morgan Chase", 3, 0, 180, 100, 913823436);
insert into cash values(29, "2021-06-19 10:42:12", "Morgan Chase", 1, 0, 300, 100, 913823416);
insert into cash values(30, "2021-06-21 11:32:12", "Morgan Chase", 1, 0, 400, 100, 913823416);

use conygre;
insert into bonds values (1, "2021-05-21 12:12:12", "MAN", "Manitoba Savings Bonds","Fixed-rate bonds", 0, 1000, "2025-09-05 00:09:00", 2.7, 1000);
insert into bonds values (2, "2021-06-08 9:42:12", "QC", "Quebec Savings Bonds", "Fixed-rate bonds",0, 2000, "2029-09-01 00:09:00", 2.3, 2000);
insert into bonds values (3, "2021-07-01 12:12:12", "ONT", "Ontario Savings Bonds","Fixed-rate bonds", 0, 3000, "2023-09-08 00:09:00", 2.9, 3000);
insert into bonds values (4, "2021-08-10 16:12:12", "BC", "British Columbia Savings Bonds", "Fixed-rate bonds",0, 4000, "2027-11-19 00:09:00", 2.7, 4000);
insert into bonds values (5, "2021-03-19 10:12:12", "CAN", "Canada Savings Bonds", "Fixed-rate bonds",0, 1000, "2029-06-01 00:09:00", 2.25, 1000);