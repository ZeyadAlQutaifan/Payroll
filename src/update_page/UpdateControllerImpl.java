/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update_page;

import Modules.Employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;
import validator.InputValidator;

/**
 *
 * @author zeyad
 */
public class UpdateControllerImpl implements UpdateController {

    private final UpdateDialogView view;
    Employee mEmployee;
    private final int selectedRowIndex;

    UpdateControllerImpl(UpdateDialogView view, int selectedRowIndex) {
        this.view = view;
        this.selectedRowIndex = selectedRowIndex;
        try {
            setValues();
        } catch (ParseException ex) {
            Logger.getLogger(UpdateControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateEmployee() {
        try {
            initEmp();
        } catch (ParseException ex) {
            Logger.getLogger(UpdateControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(employeeExist()){
            JOptionPane.showMessageDialog(view, "employee with id "+view.txtID.getText() +" is already exist");
            view.txtID.requestFocus();
            return;
        }
        if(!InputValidator.validID(view.txtID.getText())){
            view.txtID.requestFocus();
            return;
        }
        if(!InputValidator.validInput(view.txtName.getText())){
            
            view.txtName.requestFocus();
            return; 
        }
        globals.GlobalVariable.employeeListBuffer.set(selectedRowIndex, mEmployee.toString());
        System.out.println(globals.GlobalVariable.employeeListBuffer);
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

    private void initEmp() throws ParseException {
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
                    department,
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

    private void setValues() throws ParseException {
        Object[] tableLines = new Object[globals.GlobalVariable.employeeListBuffer.size()];
        tableLines = globals.GlobalVariable.employeeListBuffer.toArray(new String[0]);
        String[] oldData = tableLines[selectedRowIndex].toString().trim().split(",");
        view.txtName.setText(oldData[0]);
        view.txtID.setText(oldData[1]);
        view.cmbDept.setSelectedItem(oldData[2]);
        System.out.println(oldData[3]);

       
        
     
        String OLD_FORMAT = "dd-MM-yyyy";
        String oldDateString =oldData[3] ;
        String hiredate;
        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
        Date d = null;
        try {
            d = sdf.parse(oldDateString);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.spnHiredate.setValue(d);
        
        
        if (oldData[4].equals("Single")) {
            view.rbtnSingle.setSelected(true);
        } else {
            view.rbtnMarried.setSelected(true);
        }

        
        if (oldData[5].equals("Female")) {
            view.rbtnFemale.setSelected(true);
        } else {
            view.rbtnMale.setSelected(true);
        }
        view.txtAddress.setText(oldData[6]);

    }

}
