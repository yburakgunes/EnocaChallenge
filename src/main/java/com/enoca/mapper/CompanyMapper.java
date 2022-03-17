package com.enoca.mapper;

import com.enoca.dto.request.CreateCompanyRequestDto;
import com.enoca.dto.request.UpdateCompanyRequestDto;
import com.enoca.repository.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CompanyMapper {

    Company toUpdateCompany(UpdateCompanyRequestDto dto);
    Company toCreateCompany(CreateCompanyRequestDto dto);
}
