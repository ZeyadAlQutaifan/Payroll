/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update_page;

import globals.GlobalVariable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author zeyad
 */
public class UpdateDialogView extends javax.swing.JDialog {

    UpdateController controller;

    /**
     * Creates new form UpdateView
     * @param parent
     * @param modal
     * @param selectedRowIndex refers to the index of the selected row in JTable 
     */
    public UpdateDialogView(java.awt.Frame parent, boolean modal, int selectedRowIndex) {
        super(parent, modal);
        initComponents();

        controller = new UpdateControllerImpl(this, selectedRowIndex);
          SpinnerDateModel model = new SpinnerDateModel();
        spnHiredate.setModel(model);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGender = new javax.swing.ButtonGroup();
        buttonGroupStatus = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        spnHiredate = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        rbtnMale = new javax.swing.JRadioButton();
        rbtnFemale = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        rbtnSingle = new javax.swing.JRadioButton();
        rbtnMarried = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbDept = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(6, 1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setText("Name");
        jPanel2.add(jLabel1);
        jPanel2.add(txtName);

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        jLabel2.setText("ID");
        jPanel3.add(jLabel2);
        jPanel3.add(txtID);

        jPanel1.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        jLabel3.setText("Hiredate");
        jPanel4.add(jLabel3);

        spnHiredate.setModel(new javax.swing.SpinnerDateModel());
        spnHiredate.setEditor(new javax.swing.JSpinner.DateEditor(spnHiredate, "dd-MM-yyyy"));
        jPanel4.add(spnHiredate);

        jPanel1.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        jLabel4.setText("Gender");
        jPanel5.add(jLabel4);

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroupGender.add(rbtnMale);
        rbtnMale.setSelected(true);
        rbtnMale.setText("Male");
        jPanel6.add(rbtnMale);

        buttonGroupGender.add(rbtnFemale);
        rbtnFemale.setText("Female");
        jPanel6.add(rbtnFemale);

        jPanel5.add(jPanel6);

        jPanel1.add(jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        jLabel5.setText("Social Status");
        jPanel7.add(jLabel5);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroupStatus.add(rbtnSingle);
        rbtnSingle.setText("Single");
        jPanel8.add(rbtnSingle);

        buttonGroupStatus.add(rbtnMarried);
        rbtnMarried.setSelected(true);
        rbtnMarried.setText("Married");
        jPanel8.add(rbtnMarried);

        jPanel7.add(jPanel8);

        jPanel1.add(jPanel7);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.GridLayout(1, 2));

        jLabel7.setText("jLabel7");
        jPanel10.add(jLabel7);

        cmbDept.setModel(new DefaultComboBoxModel(GlobalVariable.departments.toArray(new String[0])));
        jPanel10.add(cmbDept);

        jPanel1.add(jPanel10);

        jLabel6.setText("Address");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        controller.updateEmployee();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.ButtonGroup buttonGroupStatus;
    protected javax.swing.JComboBox<String> cmbDept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JRadioButton rbtnFemale;
    protected javax.swing.JRadioButton rbtnMale;
    protected javax.swing.JRadioButton rbtnMarried;
    protected javax.swing.JRadioButton rbtnSingle;
    protected javax.swing.JSpinner spnHiredate;
    protected javax.swing.JTextArea txtAddress;
    protected javax.swing.JTextField txtID;
    protected javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}