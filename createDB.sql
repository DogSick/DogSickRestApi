USE DOGSICKDB;

DROP TABLE IF EXISTS MYDOGDB CASCADE;

CREATE TABLE IF NOT EXISTS MYDOGDB
(
    MYDOG_CODE INT AUTO_INCREMENT,
    MYDOG_DATE DATE,
    MYDOG_LOCATION VARCHAR(255),
    MYDOG_MEMO VARCHAR(255),
    MYDOG_ID VARCHAR(255),
    CONSTRAINT pk_category_code PRIMARY KEY (MYDOG_CODE)
) ENGINE=INNODB;

INSERT INTO MYDOGDB(
	MYDOG_DATE
    , MYDOG_LOCATION
    , MYDOG_MEMO)
VALUES
	('2024-06-05', 'location test', 'memo test'),
    ('2024-06-04', 'location test2', 'memo test2');