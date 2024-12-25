package com.example.spring_boot_rest_api.repository;

import com.example.spring_boot_rest_api.model.Employe;
import com.example.spring_boot_rest_api.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeRepository {

    @Autowired
    private List<Employe> employeeList;


    public List<Employe> getAllEmployeList(){

        return employeeList;
    }

    public Employe getEmployeById(String id){
        Employe findEmployee = null;
        for (Employe employee : employeeList){
            if(employee.getId().equals(id)) {
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }

    public  List<Employe> getEmployeWithParams(String firstName , String lastName){
        List<Employe> employeeListWithParamsList =  new ArrayList<>();
        if(firstName == null && lastName ==null){
            return employeeList;
        }
        for(Employe employe : employeeList){
            if(firstName != null && lastName !=null){
                if(employe.getFirstName().equalsIgnoreCase(firstName) && employe.getLastName().equalsIgnoreCase(lastName)){
                    employeeListWithParamsList.add(employe);
                }
            }
            if(firstName != null && lastName == null){
                if(employe.getFirstName().equalsIgnoreCase(firstName) ){
                    employeeListWithParamsList.add(employe);
                }
            }

            if(lastName != null && firstName == null){
                if(employe.getLastName().equalsIgnoreCase(lastName) ){
                    employeeListWithParamsList.add(employe);
                }
            }
        }

        return employeeListWithParamsList;

    }

    public Employe saveEmploye(Employe newEmployee){
        employeeList.add(newEmployee);
        return newEmployee;
    }


    public boolean deleteEmployee(String id ){
        //delete from employee where id = :id

        for(Employe employe : employeeList){
            if(employe.getId().equals(id)){
                employeeList.remove(employe);
                return true;
            }
        }
        return false;

    }



    private Employe findEmloyeebyId(String id){
        Employe findEmploye = null;
        for(Employe employe : employeeList){
            if(employe.getId().equals(id)){
                findEmploye = employe;
                break;

            }
        }
        return findEmploye;
    }

    public Employe updateEmployee(String id , UpdateEmployeeRequest request){
        //id liyi sil yemni değeri ekle

        Employe findEmployee = findEmloyeebyId(id);

        if(findEmployee != null){
            deleteEmployee(id);

            Employe updatedEmployee = new Employe(id, request.getFirstName(), request.getLastName());

            updatedEmployee.setId(id);
            updatedEmployee.setFirstName(request.getFirstName());
            updatedEmployee.setLastName(request.getLastName());

            employeeList.add(updatedEmployee);

            return updatedEmployee;

        }

        return null;


    }
}
