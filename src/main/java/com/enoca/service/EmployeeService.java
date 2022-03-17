package com.enoca.service;

import com.enoca.dto.request.UpdateEmployeeRequestDto;
import com.enoca.mapper.EmployeeMapper;
import com.enoca.repository.IEmployeeRepository;
import com.enoca.repository.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final IEmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    public Employee updateEmployee(UpdateEmployeeRequestDto employee){
        Employee dbEmployee = findEmployeeById(employee.getId());
        dbEmployee = employeeMapper.toUpdateEmployee(employee);
        return employeeRepository.save(dbEmployee);
    }
    public String delete(long id){
        employeeRepository.deleteById(id);

        return "Çalışan bilgileri başarıyla silinmiştir";
    }

    public Employee findEmployeeById(long id){
        Optional<Employee> dbEmployee = employeeRepository.findById(id);
        if (dbEmployee.isEmpty()){
            throw new EntityNotFoundException("Employee don't find: "+id);
        }
        return dbEmployee.get();
    }


}
