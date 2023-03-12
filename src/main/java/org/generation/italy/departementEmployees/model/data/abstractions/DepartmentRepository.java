package org.generation.italy.departementEmployees.model.data.abstractions;

import org.generation.italy.departementEmployees.model.data.exceptions.DataException;
import org.generation.italy.departementEmployees.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.departementEmployees.model.entities.Department;

import java.util.List;

public interface DepartmentRepository {
    //Un metodo per inserire un nuovo dipartimento
    Department addDepartment(Department department) throws DataException;

    // Un metodo per cancellare un dato dipartimento con un certo id
    void deleteById(long id) throws EntityNotFoundException, DataException;

    //Un metodo che mi da tutti i dipartimenti che contengono una data stringa nel nome,
    // ma quest'ultimo deve anche caricare tutti gli impiegati che ci lavorano
    Iterable<Department> findByNameContains(String part) throws DataException;



}
