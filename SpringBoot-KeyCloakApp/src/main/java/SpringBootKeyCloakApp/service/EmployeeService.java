package SpringBootKeyCloakApp.service;

import SpringBootKeyCloakApp.entity.Employee;
import SpringBootKeyCloakApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
//    @PostConstruct
//    public void initializeEmployee(){
//        employeeRepository.saveAll(
//                Stream.of(new Employee(1,"Esme",20000.00),
//                        new Employee(2,"John",30000.00),
//                        new Employee(3,"Abebe",100000.00)
//                        ).collect(Collectors.toList()));
//    }
    public Employee getEmployee(int empId){
        return employeeRepository.findById(empId).orElse(null);
    }
    public List<Employee> getAllEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }
}
