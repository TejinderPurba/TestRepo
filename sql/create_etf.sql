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
  PRIMARY KEY (`id`))