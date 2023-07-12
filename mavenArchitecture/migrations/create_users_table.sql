CREATE TABLE "users"
(
    "id"        VARCHAR PRIMARY KEY,
    "firstname" VARCHAR(50)  NOT NULL,
    "lastname"  VARCHAR(50)  NOT NULL,
    "createdat" DATE         NOT NULL,
    "email"     VARCHAR(255) NOT NULL UNIQUE,
    "phone"     VARCHAR(16),
    "language"  VARCHAR(4),
    "disabled"  BOOLEAN      NOT NULL,
    "initpass"  BOOLEAN      NOT NULL
);