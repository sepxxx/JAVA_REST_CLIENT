package com.spring.rest.client;


import com.spring.rest.client.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/JAVA_REST_API_war_exploded/api/employees";

    public List<Employee> showAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
        });
        List<Employee> employees = responseEntity.getBody();
        return employees;
    }

    public Employee getEmployee(int id) {
        Employee employee = restTemplate.getForObject(URL+"/"+id, Employee.class);
        return employee;
    }

    public void saveEmployee(Employee employee) {
        int id =employee.getId();
        if(id==0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL,employee, String.class );
            System.out.println(responseEntity);
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with id "+id+ " was updated");
        }
    }


}
