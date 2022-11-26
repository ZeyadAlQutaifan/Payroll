/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_page;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zeyad
 */
public class MainControllerImpl implements MainController {

    private final MainView view;
    private DefaultTableModel model;
    String[] detpList1 = new String[globals.GlobalVariable.departments.size()];
    Object[] tableLines = new Object[globals.GlobalVariable.employeeListBuffer.size()];

    public MainControllerImpl(MainView view) {
        this.view = view;

        detpList1 = globals.GlobalVariable.departments.toArray(new String[0]);

        this.view.cmbDept.setModel(new DefaultComboBoxModel(add(detpList1.length, detpList1)));

        fillTable();
        windowClosingListener();

        view.txtID.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                disable();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                if (view.txtID.getText().isEmpty()) {
                    enable();

                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {

            }

        });

    }

    @Override
    public void fillTable() {
        model = (DefaultTableModel) view.tblEmp.getModel();
        model.setRowCount(0);

        tableLines = globals.GlobalVariable.employeeListBuffer.toArray(new String[0]);
        for (int i = 0; i < tableLines.length; i++) {
            String line = tableLines[i].toString().trim();
            String[] dataRow = line.split(",");
            model.addRow(dataRow);

        }
    }

    private void enable() {
        view.txtName.setEnabled(true);
        view.lblName.setEnabled(true);
        view.lblDept.setEnabled(true);
        view.cmbDept.setEnabled(true);

    }

    private void disable() {
        view.txtName.setEnabled(false);
        view.lblName.setEnabled(false);
        view.lblDept.setEnabled(false);
        view.cmbDept.setEnabled(false);
    }

    private String[] add(int n, String arr[]) {
        int i;
        // create a new array of size n+1
        String newarr[] = new String[n + 1];
        newarr[0] = "All";
        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 1; i < newarr.length; i++) {
            newarr[i] = arr[i - 1];
        }

        return newarr;
    }

    @Override
    public void sreach() {
        boolean isNameSelected = !view.txtName.getText().isEmpty();
        boolean isIDSelected = !view.txtID.getText().isEmpty();
        boolean isDeptSelected = !view.cmbDept.getSelectedItem().toString().trim().equals("All");
        String name = view.txtName.getText().trim();
        String ID = view.txtID.getText().trim();
        String dept = view.cmbDept.getSelectedItem().toString().trim();
        model.setRowCount(0);

        System.out.println(isNameSelected + " " + isIDSelected + " " + isDeptSelected);
        int resultCount = 0;
        
        if (isIDSelected) {
            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim(); 
                String[] dataRow = line.split(",");
                if (dataRow[1].trim().equals(ID)) {
                    ++resultCount;
                    model.addRow(dataRow);
                }
            }

        } else if (isNameSelected && isDeptSelected) {
            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim();
                String[] dataRow = line.split(",");
                if (dataRow[2].trim().equals(dept) && dataRow[0].trim().equals(name)) {
                    ++resultCount;
                    model.addRow(dataRow);
                }
            }

        } else if (!isNameSelected && isDeptSelected) {
            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim();
                String[] dataRow = line.split(",");
                if (dataRow[1].trim().equals(dept)) {
                    ++resultCount;
                    model.addRow(dataRow);
                }
            }

        } else if (isNameSelected && !isDeptSelected) {
            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim();
                String[] dataRow = line.split(",");
                if (dataRow[0].trim().equals(name)) {
                    ++resultCount;
                    model.addRow(dataRow);
                }
            }

        } else if (!isNameSelected && !isIDSelected && !isDeptSelected) {
            fillTable();
        }
        if (resultCount == 0) {
            JOptionPane.showMessageDialog(view, "no results found");
            fillTable();
        }

    }

    private void windowClosingListener() {
        view.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    globals.GlobalVariable.saveChanges();
                } catch (IOException ex) {
                    Logger.getLogger(MainControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
               System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated");
            }

        });

    }

}
