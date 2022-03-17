package com.enoca.mapper;

import com.enoca.dto.request.CreateEmployeeRequestDto;
import com.enoca.dto.request.UpdateEmployeeRequestDto;
import com.enoca.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EmployeeMapper {

    Employee toCreateEmployee(CreateEmployeeRequestDto dto);
    Employee toUpdateEmployee(UpdateEmployeeRequestDto dto);
}
