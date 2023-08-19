package com.backend.services.interfaces;

import com.backend.dtos.EmployeeDTO;
import com.backend.pojos.EmployeePOJO;

public interface IEmployeeService {
    public EmployeeDTO AddEmployee(EmployeeDTO employeeDTO,Long deptId);
}
