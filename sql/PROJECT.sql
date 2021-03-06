-- Remove Original Table and Sequence

DROP TABLE PROJECT;
DROP SEQUENCE PROJECT_SEQ;
-- Create Table


CREATE TABLE PROJECT (
    KEY                NUMBER(10) NOT NULL,
    TITLE              VARCHAR2(100),
    DESCRIPTION        VARCHAR2(1000),
    BACKLOG_ID         NUMBER(10),
    START_DATE         DATE,
    END_DATE           DATE,
    CONSTRAINT PROJECT_PK PRIMARY KEY ( KEY ));

CREATE SEQUENCE PROJECT_SEQ;


-- Sample Select Statement

SELECT
    KEY, TITLE, DESCRIPTION, BACKLOG_ID, START_DATE, END_DATE 
from PROJECT
WHERE
    KEY = 0;

-- PROTECTED CODE -->