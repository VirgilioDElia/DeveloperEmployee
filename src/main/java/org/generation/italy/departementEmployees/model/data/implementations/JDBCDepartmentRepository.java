package org.generation.italy.departementEmployees.model.data.implementations;

import org.generation.italy.departementEmployees.model.data.abstractions.DepartmentRepository;
import org.generation.italy.departementEmployees.model.data.exceptions.DataException;
import org.generation.italy.departementEmployees.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.departementEmployees.model.entities.Department;
import org.generation.italy.departementEmployees.model.entities.Employee;
import org.generation.italy.departementEmployees.model.entities.Sex;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.generation.italy.departementEmployees.model.data.JDBCCostants.*;

public class JDBCDepartmentRepository implements DepartmentRepository {
    private Connection con;
    public JDBCDepartmentRepository(Connection connection){
        this.con=connection;
    }
    @Override
    public Department addDepartment(Department department) throws DataException {
        try (
                PreparedStatement st = con.prepareStatement(INSERT_DEPARTMENT, Statement.RETURN_GENERATED_KEYS);//factory method pattern
        ) {
            st.setString(1, department.getName());
            st.setString(2, department.getAddress());
            st.setInt(3, department.getMaxCapacity());
            st.executeUpdate();
            try (ResultSet keys = st.getGeneratedKeys()){
                keys.next();
                long key = keys.getLong(1);
                department.setId(key);
                return department;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataException("errore nell'insermiento del corso", e);
        }
    }

    @Override
    public void deleteById(long id) throws EntityNotFoundException, DataException {
        try (
                PreparedStatement st = con.prepareStatement(DELETE_DEPARTMENT_BY_ID);//factory method pattern
        ) {
            st.setLong(1, id);
            int numLines = st.executeUpdate();
            if (numLines != 1) {
                throw new EntityNotFoundException("Non e' stato trovato il dipartimento con quell'id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataException("Errore nella lettura dei dipartimenti da database", e);
        }
    }

    @Override
    public Iterable<Department> findByNameContains(String part) throws DataException {
        try (
                PreparedStatement st = con.prepareStatement(FIND_BY_DEPARTMENT_NAME);//factory method pattern
        ) {
            st.setString(1, "%" + part + "%");
            try(ResultSet rs = st.executeQuery()){
                List<Department> dl = new ArrayList<>();
                while(rs.next()){
                    dl.add(databaseToDepartment(rs));
                }
                return dl;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataException("Errore nella lettura dei corsi da database", e);
        }
    }

    private Department databaseToDepartment(ResultSet rs) throws SQLException{
        Set<Employee> es = new HashSet<>();
        Employee e = new Employee(rs.getLong(5),rs.getString(6),rs.getString(7),rs.getDate(8).toLocalDate(), (Sex) rs.getObject(9));
        es.add(e);
        return new Department(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getInt(4),es);
    }
}
