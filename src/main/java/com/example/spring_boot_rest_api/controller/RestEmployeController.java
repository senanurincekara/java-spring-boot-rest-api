package com.example.spring_boot_rest_api.controller;


import com.example.spring_boot_rest_api.model.Employe;
import com.example.spring_boot_rest_api.model.UpdateEmployeeRequest;
import com.example.spring_boot_rest_api.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class RestEmployeController {

    //http://localhost:8080/rest/api/

    //conroller servise bağlanmalı
    @Autowired
    private EmployeService employeeService;


    @GetMapping(path = "/employee")
    public List<Employe> getAllEmployeeList(){

        //controller sen isteği aldın şimdi servise yönlendir burda
        return employeeService.getAllEmployeList();
    }


    //PATHVARİABLE ANATASYONU --> İD Sİ ŞU OLAN KİŞİYİ GETİR
    @GetMapping(path = "/employee-id/{id}")
    public Employe getEmployeById(@PathVariable(name="id", required = true) String id) {
        return employeeService.getEmployeByid(id);
    }


    //REQUESTPARAM --> şu değişkenimin değeri bu olan ve şu değişkenimin değeri şu olan listeyi bana getir
    @GetMapping(path = "/employe-requestparam")
    public List<Employe> getEmployeWithParams(@RequestParam(name = "firstName" , required = false) String firstName, @RequestParam(name="lastName",required = false) String lastName){

        System.out.println(firstName + " "+ lastName);
        return employeeService.getEmployeWithParams(firstName,lastName);
    }


    //POST İŞLEMİ REQUESTBODY
    @PostMapping(path = "/save-employee")
    public Employe saveEmploye(@RequestBody Employe newEmployee){

        System.out.println(newEmployee);
        return employeeService.saveEmployee(newEmployee);
    }


    //DELETE İŞLEMİ
    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id") String id){

        return employeeService.deleteEmployee(id);

    }

    //PUT İŞLEMİ GÜNCELLEME
    @PutMapping(path = "/update-employee/{id}")
    public Employe updateEmployee(@PathVariable(name = "id") String id , @RequestBody UpdateEmployeeRequest data){

        return employeeService.updateEmloyee(id , data);
    }

}




