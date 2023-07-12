CREATE TABLE "auth"
(
    "id"                 VARCHAR PRIMARY KEY,
    "login"              VARCHAR(255) UNIQUE NOT NULL,
    "passwordhash"       VARCHAR(128)        NOT NULL,
    "passwordsalt"       VARCHAR(64)         NOT NULL,
    "passwordresettoken" VARCHAR(128),
    "role"               SMALLINT            NOT NULL,
    "userid"             UUID                NOT NULL,

    CONSTRAINT fk_user2auth FOREIGN KEY ("userid") REFERENCES "users" ("id") ON DELETE CASCADE
);