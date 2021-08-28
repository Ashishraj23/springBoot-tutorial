package com.learn.Springboottutorial.service;

import com.learn.Springboottutorial.entity.Department;
import com.learn.Springboottutorial.error.DepartmentNotFoundException;

import java.util.List;


public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentId(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long id);

    Department updateDepartmentById(Long id, Department department);

    Department fetchDepartmentByName(String name);
}
