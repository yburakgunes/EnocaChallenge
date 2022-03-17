package com.enoca.dto.response;

import com.enoca.repository.entity.Company;
import com.enoca.repository.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetEmployeeResponseDto {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private Date creationDate;
    private long companyId;

    public GetEmployeeResponseDto(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.age = employee.getAge();
        this.salary = employee.getSalary();
        this.creationDate = employee.getCreationDate();
        if(employee.getCompany()!=null){
            this.companyId = employee.getCompany().getId();
        }


    }
}
