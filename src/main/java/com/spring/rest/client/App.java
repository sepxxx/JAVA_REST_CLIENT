package com.spring.rest.client;

import com.spring.rest.client.configuration.MyConfig;
import com.spring.rest.client.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = annotationConfigApplicationContext.getBean(Communication.class);

//        System.out.println(communication.showAllEmployees());
//        System.out.println(communication.getEmployee(2));

        Employee employee = new Employee("kamil","sharipov","SALES", 1333);
        employee.setId(15);
        communication.saveEmployee(employee);
    }

}
