/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

/**
 *
 * @author zeyad
 */
public class Employee {
    
    private String name ; 
    private String id; 
    private String hiredate; 
    private String socialStatus ; 
    private String gender ; 
    private String address; 
    private String department; 
    

    public Employee(String name, String id, String hiredate,String department, String socialStatus, String gender) {
        this.name = name;
        this.id = id;
        this.hiredate = hiredate;
        this.socialStatus = socialStatus;
        this.gender = gender;
        this.address = "no address specified";
        this.department = department; 
    }
    
     public Employee(String name, String id, String hiredate, String department, String socialStatus, String gender , String address) {
        this.name = name;
        this.id = id;
        this.hiredate = hiredate;
        this.socialStatus = socialStatus;
        this.gender = gender;
        this.address = address;
        this.department = department; 
    }

    @Override
    public String toString() {
        return name + "," + id + "," +department +","+ hiredate + "," + socialStatus + "," + gender + "," + address ;
    }
     
     
     
    
    
    
}
