DELETE FROM EVENTS;
DELETE FROM STUDENT where ID = 182124;
DELETE FROM STUDENT where ID = 182125;
UPDATE STUDENT SET ROOM_ID = NULL;
DELETE FROM ROOM W;
DELETE FROM SYNC_LOG WHERE ID > 66;
DELETE FROM PUBLICATIONS;
DELETE FROM READER_SHEET;
DELETE FROM LIST_PARTICIPANT;
DELETE FROM LIST_PARTICIPANT_PROJECT;
DELETE FROM RESULTS;
DELETE FROM STUDENT;
