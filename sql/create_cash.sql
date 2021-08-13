CREATE TABLE `conygre`.`cash` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date_time` DATETIME NOT NULL,
  `financial_institution` VARCHAR(100) NOT NULL,
  `account_type` INT NOT NULL,
  `transaction_type` INT NOT NULL,
  `balance` FLOAT NOT NULL,
  PRIMARY KEY (`id`))