package com.enoca.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateEmployeeRequestDto {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
}
