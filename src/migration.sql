USE lechat;

DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages` (
  `id` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `text` VARCHAR(500) NOT NULL,
  `senderId` VARCHAR(100) NOT NULL,
  `receiverId` VARCHAR(100) NOT NULL,
  `senderName` VARCHAR(100) NOT NULL,
  `receiverName` VARCHAR(100) NOT NULL
) Engine=InnoDB;

DROP TABLE IF EXISTS `group_messages`;
CREATE TABLE `group_messages` (
  `id` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `text` VARCHAR(500) NOT NULL,
  `senderId` VARCHAR(100) NOT NULL,
  `senderName` VARCHAR(100) NOT NULL,
  `groupId` VARCHAR(100) NOT NULL
) Engine=InnoDB;

DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(100) NOT NULL,
  `members_id` VARCHAR(500) NOT NULL
) Engine=InnoDB;
