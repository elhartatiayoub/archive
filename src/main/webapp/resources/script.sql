CREATE TABLE `User` (
  Email    varchar(255) NOT NULL, 
  RoleID   int(11) NOT NULL, 
  Name     varchar(255), 
  PassHash varchar(255), 
  PRIMARY KEY (Email));
CREATE TABLE Image (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  UserEmail   varchar(255) NOT NULL, 
  Title       varchar(255), 
  `Date`      date, 
  Likes       int(10) NOT NULL, 
  Shares      int(10) NOT NULL, 
  Pravacy     varchar(255), 
  Url         varchar(255), 
  Description varchar(255), 
  Downloads   int(11) NOT NULL, 
  PRIMARY KEY (ID));
CREATE TABLE Role (
  ID   int(11) NOT NULL AUTO_INCREMENT, 
  Name varchar(255), 
  PRIMARY KEY (ID));
CREATE TABLE Comment (
  ID        int(11) NOT NULL AUTO_INCREMENT, 
  ImageID   int(10) NOT NULL, 
  UserEmail varchar(255) NOT NULL, 
  `Date`    date, 
  Text      varchar(255), 
  PRIMARY KEY (ID));
CREATE TABLE Category (
  ID          int(11) NOT NULL AUTO_INCREMENT, 
  Name        varchar(255), 
  Description varchar(255), 
  PRIMARY KEY (ID));
CREATE TABLE Category_Image (
  CategoryID int(11) NOT NULL, 
  ImageID    int(10) NOT NULL, 
  PRIMARY KEY (CategoryID, 
  ImageID));
CREATE TABLE Image_keywords (
  ImageID    int(10) NOT NULL, 
  ImageIndex int(11) NOT NULL, 
  Keywords   varchar(255), 
  PRIMARY KEY (ImageID, 
  ImageIndex));
ALTER TABLE Image ADD INDEX Image (UserEmail), ADD CONSTRAINT Image FOREIGN KEY (UserEmail) REFERENCES `User` (Email);
ALTER TABLE `User` ADD INDEX role (RoleID), ADD CONSTRAINT role FOREIGN KEY (RoleID) REFERENCES Role (ID);
ALTER TABLE Comment ADD INDEX FKComment65436 (UserEmail), ADD CONSTRAINT FKComment65436 FOREIGN KEY (UserEmail) REFERENCES `User` (Email);
ALTER TABLE Comment ADD INDEX FKComment435738 (ImageID), ADD CONSTRAINT FKComment435738 FOREIGN KEY (ImageID) REFERENCES Image (ID);
ALTER TABLE Category_Image ADD INDEX FKCategory_I387140 (CategoryID), ADD CONSTRAINT FKCategory_I387140 FOREIGN KEY (CategoryID) REFERENCES Category (ID);
ALTER TABLE Category_Image ADD INDEX FKCategory_I808807 (ImageID), ADD CONSTRAINT FKCategory_I808807 FOREIGN KEY (ImageID) REFERENCES Image (ID);
ALTER TABLE Image_keywords ADD INDEX FKImage_keyw517101 (ImageID), ADD CONSTRAINT FKImage_keyw517101 FOREIGN KEY (ImageID) REFERENCES Image (ID);

Insert into `Role` values (1,'admin');
Insert into `Role` values (2,'user');
