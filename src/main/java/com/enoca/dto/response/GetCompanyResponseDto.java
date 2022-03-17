package com.enoca.dto.response;

import com.enoca.repository.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetCompanyResponseDto {
    private long id;
    private String name;
    private String description;
    private Date creationDate;

    public GetCompanyResponseDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.description = company.getDescription();
        this.creationDate = company.getCreationDate();
    }
}
