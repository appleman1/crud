CREATE TABLE todo_list (
  id               UUID PRIMARY KEY NOT NULL,
  planned_datetime TIMESTAMP        NOT NULL,
  name             VARCHAR(100)     NOT NULL,
  completed_planned_datetime TIMESTAMP
);