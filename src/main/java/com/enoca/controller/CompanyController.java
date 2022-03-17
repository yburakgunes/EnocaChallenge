package com.enoca.controller;

import com.enoca.dto.request.CreateCompanyRequestDto;
import com.enoca.dto.request.CreateEmployeeRequestDto;
import com.enoca.dto.request.UpdateCompanyRequestDto;
import com.enoca.dto.response.GetCompanyResponseDto;
import com.enoca.dto.response.GetEmployeeResponseDto;
import com.enoca.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/company")
public class CompanyController {
    private final CompanyService service;

    @PostMapping("/save")
    public ResponseEntity <GetCompanyResponseDto> saveCompany(@RequestBody CreateCompanyRequestDto dto) {
        return ResponseEntity.ok(new GetCompanyResponseDto(service.saveCompany(dto)));
    }

    @PutMapping("/update")
    public ResponseEntity <GetCompanyResponseDto> updateCompany(@RequestBody UpdateCompanyRequestDto dto) {
        return ResponseEntity.ok(new GetCompanyResponseDto(service.updateCompany(dto)));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable long id){
        return ResponseEntity.ok(service.delete(id));
    }
    @GetMapping("/{id}")
    public  ResponseEntity<GetCompanyResponseDto> getCompany(@PathVariable long id){
        return ResponseEntity.ok(new GetCompanyResponseDto(service.findCompanyById(id)));
    }
    @PostMapping("/{companyId}/{employeeId}")
    public ResponseEntity<String> addNewEmployee(@PathVariable(name = "companyId")long id,@PathVariable(name = "employeeId") CreateEmployeeRequestDto dto){
        return ResponseEntity.ok(service.addNewEmployee(id,dto));
    }
    @PostMapping("/listAllEmployees/{id}")
    public ResponseEntity<List<GetEmployeeResponseDto>> listAllEmployees(@PathVariable long id){
        return ResponseEntity.ok().body(service.listAllEmployees(id).stream().map(GetEmployeeResponseDto::new).collect(Collectors.toList()));
    }


}
