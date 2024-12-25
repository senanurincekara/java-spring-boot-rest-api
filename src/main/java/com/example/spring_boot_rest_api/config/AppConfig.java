package com.example.spring_boot_rest_api.config;

import com.example.spring_boot_rest_api.model.Employe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//veri tabanı olmadığı için , yalancı veri oluşturuorum burda şuan

@Configuration
public class AppConfig {

    @Bean
    public List<Employe> employeeList(){
        List<Employe> employeeList = new ArrayList<>();

        employeeList.add(new Employe("1","name1","cc"));
        employeeList.add(new Employe("2","name2","aa"));
        employeeList.add(new Employe("3","name3","bb"));
        employeeList.add(new Employe("4","name3","bbb"));
        return employeeList;
    }
}
