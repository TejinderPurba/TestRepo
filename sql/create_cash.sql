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