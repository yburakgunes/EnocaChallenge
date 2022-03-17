package com.enoca.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateEmployeeRequestDto {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
}
