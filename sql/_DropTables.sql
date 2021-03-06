DROP TABLE AGILE_LIST;
DROP SEQUENCE AGILE_LIST_SEQ;

DROP TABLE PROJECT;
DROP SEQUENCE PROJECT_SEQ;

DROP TABLE SPRINT;
DROP SEQUENCE SPRINT_SEQ;

DROP TABLE STORY;
DROP SEQUENCE STORY_SEQ;

DROP TABLE USER;
DROP SEQUENCE USER_SEQ;

ALTER TABLE AGILE_LIST DROP CONSTRAINT FK_AGILE_LIST_STORY_ID;
ALTER TABLE PROJECT DROP CONSTRAINT FK_PROJECT_BACKLOG_ID;
ALTER TABLE SPRINT DROP CONSTRAINT FK_SPRINT_BACKLOG_ID;
ALTER TABLE SPRINT DROP CONSTRAINT FK_SPRINT_DOING_ID;
ALTER TABLE SPRINT DROP CONSTRAINT FK_SPRINT_DONE_ID;
ALTER TABLE USER DROP CONSTRAINT FK_USER_PROJECT_ID;
ALTER TABLE USER DROP CONSTRAINT FK_USER_SPRINT_ID;
