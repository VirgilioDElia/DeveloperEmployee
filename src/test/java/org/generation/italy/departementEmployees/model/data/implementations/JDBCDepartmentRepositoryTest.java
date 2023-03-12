package org.generation.italy.departementEmployees.model.data.implementations;

import org.generation.italy.departementEmployees.model.data.exceptions.DataException;
import org.generation.italy.departementEmployees.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.departementEmployees.model.entities.Department;
import org.generation.italy.departementEmployees.model.entities.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.generation.italy.departementEmployees.model.data.JDBCCostants.*;
import static org.generation.italy.departementEmployees.model.data.implementations.TestCostants.*;
import static org.junit.jupiter.api.Assertions.*;

class JDBCDepartmentRepositoryTest {
    private Department d1;
    private Department d2;
    private Connection con;
    private JDBCDepartmentRepository repo;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws SQLException {
        con= DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        con.setAutoCommit(false);
        //aggiungo developer
        d1 = new Department(0,D1_NAME,ADDRESS1,D1_MAX_CAPACITY);
        d2 = new Department(0,D2_NAME,ADDRESS2,D2_MAX_CAPACITY);
        //aggiungo employee
        repo = new JDBCDepartmentRepository(con);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        try{
            if(con!=null){
                con.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.jupiter.api.Test
    void add_department() {
        try{
            Department department = repo.addDepartment(d1);
            assertEquals(D1_NAME,department.getName());
            assertEquals(ADDRESS1,department.getAddress());
            assertEquals(D1_MAX_CAPACITY,department.getMaxCapacity());
        }catch (DataException e){
            fail(e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void deleteById() {
        try{
            repo.deleteById(d1.getId());
        }catch (EntityNotFoundException | DataException e){
            fail(e);
        }
    }

    @org.junit.jupiter.api.Test
    void findByTitleContains() {
        try{
            Iterable<Department> result = repo.findByNameContains("1N");
            var it = result.iterator();
            assertTrue(it.hasNext());
            var department1=it.next();
            assertTrue(department1.getId() == d1.getId());
        }catch (DataException e) {
            fail(e.getMessage());
        }
    }
}