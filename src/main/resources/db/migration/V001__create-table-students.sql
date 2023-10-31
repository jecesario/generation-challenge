CREATE TABLE students (
    id INTEGER(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    age INTEGER(3) NOT NULL,
    grade1 DOUBLE(4,2) NOT NULL,
    grade2 DOUBLE(4,2) NOT NULL,
    professor_name VARCHAR(50) NOT NULL,
    class_id VARCHAR(10) NOT NULL,

    PRIMARY KEY (id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;