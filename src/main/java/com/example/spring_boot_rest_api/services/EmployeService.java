package com.example.spring_boot_rest_api.services;

import com.example.spring_boot_rest_api.model.Employe;
import com.example.spring_boot_rest_api.model.UpdateEmployeeRequest;
import com.example.spring_boot_rest_api.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {

    //servistende repoya geçmem lazım
    //private EmployeRepository diye bşr sınıfın vardı sen bunu repository ie işaretlediğin için
    //bir spring bean oluştu . şiödi ben bunu servise enjekte edecem ki servisten repository e geçiş sağlansın

    @Autowired
    private EmployeRepository employeRepository;

    public List<Employe>  getAllEmployeList(){

        return employeRepository.getAllEmployeList();

    }

    public Employe getEmployeByid(String id){
        return employeRepository.getEmployeById(id);
    }

    public List<Employe> getEmployeWithParams(String firstName , String lastName){
        return employeRepository.getEmployeWithParams(firstName , lastName);

    }

    public Employe saveEmployee(Employe newEmployee){

        return employeRepository.saveEmploye(newEmployee);
    }

    public boolean deleteEmployee(String id){
        return  employeRepository.deleteEmployee(id);
    }

    public Employe updateEmloyee(String id , UpdateEmployeeRequest request){

        return  employeRepository.updateEmployee(id , request);
    }
}
