CREATE SCHEMA bank DEFAULT CHARACTER SET utf8;
USE bank;

DROP table IF EXISTS account;
CREATE TABLE account(
      `accid` INT NOT NULL auto_increment,
      `username` VARCHAR(45) NULL DEFAULT NULL,
      `psw` VARCHAR(45) NULL DEFAULT NULL,
      `deposit` decimal(10,2) NULL DEFAULT NULL,
      PRIMARY KEY (`accid`))
    ENGINE = InnoDB;

