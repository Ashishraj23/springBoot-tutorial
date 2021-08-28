package com.learn.Springboottutorial.service;

import com.learn.Springboottutorial.entity.Department;
import com.learn.Springboottutorial.error.DepartmentNotFoundException;
import com.learn.Springboottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentId(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);

        return department.orElseThrow(() ->  new DepartmentNotFoundException("Department not Available"));
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Department department1 = departmentRepository.findById(id).get();
        if (!ObjectUtils.isEmpty(department1) && !StringUtils.isEmpty(department1.getDepartmentName()) &&
                !StringUtils.isEmpty(department1.getDepartmentAddress()) && !StringUtils.isEmpty(department1.getDepartmentCode())) {
            department1.setDepartmentAddress(department.getDepartmentAddress());
            department1.setDepartmentCode(department.getDepartmentCode());
            department1.setDepartmentName(department.getDepartmentName());
        }
        return departmentRepository.save(department1);

    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }
}
