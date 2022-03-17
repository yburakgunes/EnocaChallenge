package com.enoca.service;

import com.enoca.dto.request.CreateCompanyRequestDto;
import com.enoca.dto.request.CreateEmployeeRequestDto;
import com.enoca.dto.request.UpdateCompanyRequestDto;
import com.enoca.mapper.CompanyMapper;
import com.enoca.mapper.EmployeeMapper;
import com.enoca.repository.ICompanyRepository;
import com.enoca.repository.IEmployeeRepository;
import com.enoca.repository.entity.Company;
import com.enoca.repository.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final ICompanyRepository companyRepository;
    private final IEmployeeRepository employeeRepository;
    private final CompanyMapper companyMapper;
    private final EmployeeMapper employeeMapper;


    public Company saveCompany(CreateCompanyRequestDto company) {
        Company dbCompany = new Company();
        dbCompany = companyMapper.toCreateCompany(company);
        return dbCompany;
    }

    public Company updateCompany(UpdateCompanyRequestDto company) {
        Company dbCompany = findCompanyById(company.getId());
        dbCompany = companyMapper.toUpdateCompany(company);
        return companyRepository.save(dbCompany);

    }
    public String delete(long id) {
        companyRepository.deleteById(id);
        return "Şirket bilgileri silinmiştir";
    }

    public Company findCompanyById(long id){
        Optional<Company>dBCompany=companyRepository.findById(id);
        if(dBCompany.isEmpty()){
            throw new EntityNotFoundException("Company don't find: "+id);
        }
        return dBCompany.get();
    }
    public String addNewEmployee (long id, CreateEmployeeRequestDto dto){
        Company company = companyRepository.findById(id).get();
        Employee employee = employeeMapper.toCreateEmployee(dto);
        employee.setCompany(company);
        company.getEmployeeList().add(employee);
        employeeRepository.save(employee);
        return "Şirkete yeni bir çalışan başarıyla eklendi.";
    }

    public List<Employee> listAllEmployees (long id){
        Company company = companyRepository.findById(id).get();
        return company.getEmployeeList();
    }

    public List<Company> listAllCompany(){
        return companyRepository.findAll();
    }



}
