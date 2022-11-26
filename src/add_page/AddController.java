/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package add_page;

import Modules.Employee;



import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import validator.InputValidator;

/**
 *
 * @author zeyad
 */
public class AddController {

    private Employee mEmployee;
    private AddDialogView view;

    public AddController(AddDialogView view) {
        this.view = view;
    }

    public void addEmployee() throws IOException {

      
        if(employeeExist()){
            JOptionPane.showMessageDialog(view, "employee with id "+view.txtID.getText() +" is already exist");
            view.txtID.requestFocus();
            return;
        }
         if(!InputValidator.validInput(view.txtName.getText())){
            
            view.txtName.requestFocus();
            return; 
        } 
         if(!InputValidator.validID(view.txtID.getText())){
            view.txtID.requestFocus();
            return;
        }
       
        
        try {
            initEmployee();
        } catch (ParseException ex) {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        globals.GlobalVariable.employeeListBuffer.add( mEmployee.toString());
       
        System.out.println( "the new updated list ==> " + globals.GlobalVariable.employeeListBuffer);
        
    }

    private boolean employeeExist(){
        /**
         * create a new array containing all employees 
         */
        String[] employees = new String[globals.GlobalVariable.employeeListBuffer.size()];
        employees = globals.GlobalVariable.employeeListBuffer.toArray(new String[0]);
        
        /**
         * 
         * 
         */
        for (String employee : employees) {
            String employeeId = employee.split(",")[1].trim();
            if(employeeId.equals(view.txtID.getText().trim()))
                return true;
        }
        return false ; 
    }
    private void initEmployee() throws ParseException {
        String OLD_FORMAT = "E MMM dd HH:mm:ss z yyyy";
        String oldDateString = view.spnHiredate.getValue().toString();
        String hiredate;
        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
        Date d = sdf.parse(oldDateString);
        sdf.applyPattern("dd-MM-yyyy");
        hiredate = sdf.format(d);
        System.out.println(hiredate);
        String department = view.cmbDept.getSelectedItem().toString(); 
        String status = view.rbtnMarried.isSelected() ? "Married" : "Single";
        String gender = view.rbtnFemale.isSelected() ? "Female" : "Male";
        if (view.txtAddress.getText().isEmpty()) {

            mEmployee = new Employee(
                    view.txtName.getText(),
                    view.txtID.getText(),
                    hiredate,
                    department ,
                    status,
                    gender);
        } else {

            mEmployee = new Employee(
                    view.txtName.getText(),
                    view.txtID.getText(),
                    hiredate,
                    department,
                    status,
                    gender,
                    view.txtAddress.getText());
        }
    }

}
