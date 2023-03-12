DROP TABLE IF EXISTS department,employee;
DROP TYPE IF EXISTS sex;

CREATE TYPE sex					AS ENUM ('MALE','FEMALE','UNDECIDED');

CREATE TABLE department
(
	id_department        BIGINT       NOT NULL,
	name_department      VARCHAR(32)  NOT NULL,
	address_department   VARCHAR(100),
	max_capacity         int          NOT NULL,

	CONSTRAINT PK_department PRIMARY KEY(id_department)
);

CREATE SEQUENCE department_sequence
  OWNED BY department.id_department;


CREATE TABLE employee
(
	id_employee        BIGINT       NOT NULL,
	firstname     VARCHAR(32)  NOT NULL,
	lastname       VARCHAR(32)  NOT NULL,
	hire_date			DATE,
	sex       sex        NOT NULL,
	id_department          BIGINT,
	CONSTRAINT PK_employee PRIMARY KEY(id_employee),
	CONSTRAINT FK_employee_department FOREIGN KEY(id_department)
		REFERENCES department(id_department)
);

CREATE SEQUENCE employee_sequence
  OWNED BY employee.id_employee;