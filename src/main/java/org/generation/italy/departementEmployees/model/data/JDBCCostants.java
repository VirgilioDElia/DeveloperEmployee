package org.generation.italy.departementEmployees.model.data;

public class JDBCCostants {
    public static final String URL = "jdbc:postgresql://localhost:5432/department-excercise";
    public static final String USER_NAME = "postgresMaster";
    public static final String PASSWORD = "goPostgresGo";
    public static final String INSERT_DEPARTMENT = """
            INSERT INTO department(id_department, name_department, address_department,max_capacity)
            VALUES(nextval ('department_sequence', ?, ?, ?)
            RETURNING id_department;
            """;
    public static final String DELETE_DEPARTMENT_BY_ID = """
               DELETE FROM department
               WHERE id_department = ?
            """;
    public static final String FIND_BY_DEPARTMENT_NAME = """
            SELECT id_department, d.name_department,d.address_department,d.max_capacity,
            e.id_employee, e.firstname, e.lastname, e.hire_date, e.sex
            FROM department AS d
            JOIN employee AS e
            USING (id_department)
            WHERE (d.name_department LIKE ?)
            """;
}
