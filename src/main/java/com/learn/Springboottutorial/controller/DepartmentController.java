package com.learn.Springboottutorial.controller;

import com.learn.Springboottutorial.entity.Department;
import com.learn.Springboottutorial.error.DepartmentNotFoundException;
import com.learn.Springboottutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("Getting data for save department {}", department);
        return departmentService.saveDepartment(department);

    }

    @GetMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping(value = "/departments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Department fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentId(id);
    }

    @DeleteMapping(value = "/departments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteDepartmentById(@PathVariable("id") Long id){
         departmentService.deleteDepartmentById(id);
         return "Deleted Successfully";
    }

    @PutMapping(value = "/departments/{id}")
    public Department UpdateDepartmentById(@PathVariable("id") Long id, @RequestBody Department department){
        return departmentService.updateDepartmentById(id, department);
    }

    @GetMapping(value = "/departments/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Department fetchDepartmentByName(@PathVariable("name") String name){
        return departmentService.fetchDepartmentByName(name);
    }
}
