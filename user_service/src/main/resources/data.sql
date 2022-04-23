DElete from Rolee;
DElete from university;
DELETE from course;

INSERT INTO rolee (role_name)
VALUES ('ROLE_USER');

INSERT INTO rolee (role_name)
VALUES ('ROLE_ADMIN');

INSERT INTO university (university_id, university_name)
VALUES (1, 'Fom');

INSERT INTO university (university_id, university_name)
VALUES (2, 'Provadis');

INSERT INTO university (university_id, university_name)
VALUES (3, 'HTWK');

INSERT INTO course (course_id, name, course_begin)
VALUES (1, 'Informatik', 2022);

INSERT INTO course (course_id, name, course_begin)
VALUES (2, 'BWL',2022);

INSERT INTO course (course_id, name, course_begin)
VALUES (3, 'Wirtschaftsinformatik',2022);

