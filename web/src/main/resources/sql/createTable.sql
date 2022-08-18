/**
 * Creates a table of users.
 * @param passenger_id user's id, which auto-generated as a unique identifier for the record
 * @param first_name user's first name
 * @param last_name user's last name
 * @param patronymic user's patronymic
 */
CREATE TABLE users
(
    id         BIGINT      NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START with 1 INCREMENT by 1),
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    patronymic VARCHAR(50) NOT NULL,
);

INSERT INTO users
    (first_name, last_name, patronymic)
VALUES ('Ivanov', 'Ivan', 'Ivanovich'),
       ('Petrov', 'Ivan', 'Petrovich'),
       ('Petrova', 'Anna', 'Petrovna')
;




