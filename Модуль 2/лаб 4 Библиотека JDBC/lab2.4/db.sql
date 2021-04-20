/* ������ �������� ������� ���� ������ */
DROP DATABASE IF EXISTS my_db;

/* �������� ����� ���� ������ */
CREATE DATABASE my_db DEFAULT CHARACTER SET utf8;

/* ������������� � �������� ������� ������ ��� ��������� ���� ������ */
USE my_db;

/* �������� � ���� ������ ����� ������� */
CREATE TABLE CarOwner (
    Id INTEGER NOT NULL AUTO_INCREMENT,
    CarNumber VARCHAR(10) NOT NULL,
	Name VARCHAR(20) NOT NULL,
	Surname VARCHAR(20) NOT NULL,
	MiddlName VARCHAR(20) NOT NULL,
	CompositionOffense VARCHAR(250) NOT NULL,
	DateOffense VARCHAR(10) NOT NULL,
	PenaltySum DOUBLE NOT NULL,
	DatePayment VARCHAR(10) NULL,
	Penalty DOUBLE NOT NULL,
    PRIMARY KEY (Id)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;