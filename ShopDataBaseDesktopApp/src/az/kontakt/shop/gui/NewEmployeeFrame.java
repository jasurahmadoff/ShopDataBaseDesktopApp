package az.kontakt.shop.gui;

import az.kontakt.shop.model.*;
import az.kontakt.shop.service.*;
import java.util.Date;
import java.util.List;
import javax.swing.*;

public class NewEmployeeFrame extends javax.swing.JFrame {

    private EmployeeService employeeService;
    private ShopService shopService;
    private JobService jobService;
    private MainFrame mainFrame;

    public NewEmployeeFrame(EmployeeService employeeService, ShopService shopService, JobService jobService, MainFrame mainFrame) {
        initComponents();
        this.employeeService = employeeService;
        this.shopService = shopService;
        this.jobService = jobService;
        this.mainFrame = mainFrame;

        showShopCombo();
        showJobCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        password1 = new javax.swing.JLabel();
        password2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        username1 = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        surnameTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        hireDateTxt = new com.toedter.calendar.JDateChooser();
        password3 = new javax.swing.JLabel();
        shopCmb = new javax.swing.JComboBox<>();
        jobCmb = new javax.swing.JComboBox<>();
        nameTxt = new javax.swing.JTextField();
        salaryTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Employee");
        setResizable(false);

        password1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password1.setText("Job");

        password2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password2.setText("Hire Date");

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));

        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cesur\\Desktop\\Java\\Udemy\\ShopDataBaseDesktopApp\\contact.png")); // NOI18N
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username.setText("Name");

        username1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username1.setText("Shop");

        password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password.setText("Surname");

        surnameTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        surnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTxtActionPerformed(evt);
            }
        });

        saveBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        clearBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        hireDateTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        password3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password3.setText("Salary");

        shopCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Shop" }));
        shopCmb.setToolTipText("");

        jobCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Job" }));

        nameTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtActionPerformed(evt);
            }
        });

        salaryTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        salaryTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryTxtActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(password1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                    .addGap(66, 66, 66))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(password3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(username)
                                    .addComponent(password))
                                .addGap(45, 45, 45)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jobCmb, javax.swing.GroupLayout.Alignment.TRAILING, 0, 174, Short.MAX_VALUE)
                            .addComponent(shopCmb, javax.swing.GroupLayout.Alignment.TRAILING, 0, 174, Short.MAX_VALUE)
                            .addComponent(hireDateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(surnameTxt)
                            .addComponent(salaryTxt, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(surnameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shopCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password1))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password3)
                    .addComponent(salaryTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hireDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void surnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTxtActionPerformed

    }//GEN-LAST:event_surnameTxtActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed

        try {
            String name = nameTxt.getText();
            String surname = surnameTxt.getText();
            Shop shop = (Shop) shopCmb.getSelectedItem();
            Job job = (Job) jobCmb.getSelectedItem();
            Double salary = Double.parseDouble(salaryTxt.getText());
            Date hireDate = hireDateTxt.getDate();

            Employee employee = new Employee();
            employee.setName(name);
            employee.setSurname(surname);
            employee.setShop(shop);
            employee.setJob(job);
            employee.setSalary(salary);
            employee.setHireDate(hireDate);

            employeeService.addEmployee(employee);
            JOptionPane.showMessageDialog(null, "Employee has been successfully added!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problem! Employee has not been successfully added!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        this.dispose();
        try {
            mainFrame.showEmployeeData(employeeService.getEmployeeList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        surnameTxt.setText("");
        surnameTxt.setText("");
        shopCmb.setSelectedIndex(0);
        jobCmb.setSelectedIndex(0);
        salaryTxt.setText("");
        hireDateTxt.setDate(null);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void nameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtActionPerformed

    private void salaryTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private com.toedter.calendar.JDateChooser hireDateTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> jobCmb;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel password;
    private javax.swing.JLabel password1;
    private javax.swing.JLabel password2;
    private javax.swing.JLabel password3;
    private javax.swing.JTextField salaryTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox<String> shopCmb;
    private javax.swing.JTextField surnameTxt;
    private javax.swing.JLabel username;
    private javax.swing.JLabel username1;
    // End of variables declaration//GEN-END:variables

    private void showShopCombo() {

        try {
            DefaultComboBoxModel shopCombo = (DefaultComboBoxModel) shopCmb.getModel();
            List<Shop> shopList = shopService.getShopList();

            for (Shop shop : shopList) {
                shopCombo.addElement(shop);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showJobCombo() {

        try {
            DefaultComboBoxModel jobCombo = (DefaultComboBoxModel) jobCmb.getModel();
            List<Job> jobList = jobService.getJobList();

            for (Job job : jobList) {
                jobCombo.addElement(job);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}