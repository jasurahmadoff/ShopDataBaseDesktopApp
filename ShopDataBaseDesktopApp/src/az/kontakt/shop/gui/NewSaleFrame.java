package az.kontakt.shop.gui;

import az.kontakt.shop.model.*;
import az.kontakt.shop.service.*;
import java.util.*;
import javax.swing.*;

public class NewSaleFrame extends javax.swing.JFrame {

    private SaleService saleService;
    private ShopService shopService;
    private ProductService productService;
    private CustomerService customerService;
    private EmployeeService employeeService;
    private MainFrame mainFrame;
    private Hashtable subItems = new Hashtable();

    public NewSaleFrame(SaleService saleService, ShopService shopService, ProductService productService, CustomerService customerService, EmployeeService employeeService, MainFrame mainFrame) {

        initComponents();
        this.saleService = saleService;
        this.shopService = shopService;
        this.productService = productService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.mainFrame = mainFrame;

        showShopCombo();
        showCustomerCombo();
        showEmployeeCombo();

        try {
            List<Product> subProductItems = new ArrayList<>();

            for (int i = 0; i < shopService.getShopList().size(); i++) {
                Shop tempShop = shopService.getShopList().get(i);
                subProductItems = shopService.getProductListByShopId(tempShop);
                Product[] tempProductArray = new Product[subProductItems.size()];
                for (int j = 0; j < tempProductArray.length; j++) {
                    tempProductArray[j] = subProductItems.get(j);
                }
                subItems.put(tempShop.getId(), tempProductArray);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerCmb = new javax.swing.JComboBox<>();
        employeeCmb = new javax.swing.JComboBox<>();
        password4 = new javax.swing.JLabel();
        password1 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        password3 = new javax.swing.JLabel();
        username1 = new javax.swing.JLabel();
        username2 = new javax.swing.JLabel();
        shopCmb = new javax.swing.JComboBox<>();
        password5 = new javax.swing.JLabel();
        productCmb = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        discountTxt = new javax.swing.JTextField();
        quantityTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Sale");
        setResizable(false);

        customerCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Customer" }));
        customerCmb.setToolTipText("");

        employeeCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Employee" }));

        password4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password4.setText("Discount");

        password1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password1.setText("Employee");

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
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        password3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password3.setText("Quantity");

        username1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username1.setText("Customer");

        username2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username2.setText("Shop");

        shopCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Shop" }));
        shopCmb.setToolTipText("");
        shopCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopCmbActionPerformed(evt);
            }
        });

        password5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password5.setText("Product");

        productCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Product" }));
        productCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productCmbActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("%");

        discountTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        discountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountTxtActionPerformed(evt);
            }
        });

        quantityTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        quantityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(password3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(password4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(username2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(username1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(password1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(password5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(quantityTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, 212, Short.MAX_VALUE)
                            .addComponent(customerCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shopCmb, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(discountTxt))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shopCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(discountTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        customerCmb.getAccessibleContext().setAccessibleName("174");
        customerCmb.getAccessibleContext().setAccessibleDescription("26");
        employeeCmb.getAccessibleContext().setAccessibleName("174");
        employeeCmb.getAccessibleContext().setAccessibleDescription("26");
        password4.getAccessibleContext().setAccessibleName("174");
        password4.getAccessibleContext().setAccessibleDescription("26");
        password1.getAccessibleContext().setAccessibleName("174");
        password1.getAccessibleContext().setAccessibleDescription("26");
        password3.getAccessibleContext().setAccessibleName("174");
        password3.getAccessibleContext().setAccessibleDescription("26");
        username1.getAccessibleContext().setAccessibleName("174");
        username1.getAccessibleContext().setAccessibleDescription("26");
        username2.getAccessibleContext().setAccessibleName("174");
        username2.getAccessibleContext().setAccessibleDescription("26");
        shopCmb.getAccessibleContext().setAccessibleName("174");
        shopCmb.getAccessibleContext().setAccessibleDescription("26");
        password5.getAccessibleContext().setAccessibleName("174");
        password5.getAccessibleContext().setAccessibleDescription("26");
        productCmb.getAccessibleContext().setAccessibleName("174");
        productCmb.getAccessibleContext().setAccessibleDescription("26");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed

        try {

            Shop shop = (Shop) shopCmb.getSelectedItem();
            Product product = (Product) productCmb.getSelectedItem();
            Customer customer = (Customer) customerCmb.getSelectedItem();
            Employee employee = (Employee) employeeCmb.getSelectedItem();
            Integer quantity = Integer.parseInt(quantityTxt.getText());
            Double discount = Double.parseDouble(discountTxt.getText());

            Sale sale = new Sale();
            sale.setShop(shop);
            sale.setProduct(product);
            sale.setCustomer(customer);
            sale.setEmployee(employee);
            sale.setQuantity(quantity);
            sale.setDiscount(discount);

            saleService.addSale(sale);
            JOptionPane.showMessageDialog(null, "Sale has been successfully added!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problem! Sale has not been successfully added!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        this.dispose();
        try {
            mainFrame.showSaleData(saleService.getSaleList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed

        shopCmb.setSelectedIndex(0);
        productCmb.setSelectedIndex(0);
        customerCmb.setSelectedIndex(0);
        employeeCmb.setSelectedIndex(0);
        quantityTxt.setText("");
        discountTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void productCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productCmbActionPerformed

    private void discountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountTxtActionPerformed

    }//GEN-LAST:event_discountTxtActionPerformed

    private void quantityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTxtActionPerformed

    private void shopCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopCmbActionPerformed

        try {
            Shop item = (Shop) shopCmb.getSelectedItem();
            Object o = subItems.get(item.getId());

            if (o != null) {
                DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
                comboModel.addElement("Select Product");
                Product products[] = (Product[]) o;
                for (Product product : products) {
                    comboModel.addElement(product);
                }
                productCmb.setModel(comboModel);
            } else {
                productCmb.setModel(new DefaultComboBoxModel());
                DefaultComboBoxModel productCombo = (DefaultComboBoxModel) productCmb.getModel();
                productCombo.addElement("Select Product");
            }
        } catch (ClassCastException ex) {

            productCmb.setModel(new DefaultComboBoxModel());
            DefaultComboBoxModel productCombo = (DefaultComboBoxModel) productCmb.getModel();
            productCombo.addElement("Select Product");
        }
    }//GEN-LAST:event_shopCmbActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox<String> customerCmb;
    private javax.swing.JTextField discountTxt;
    private javax.swing.JComboBox<String> employeeCmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel password1;
    private javax.swing.JLabel password3;
    private javax.swing.JLabel password4;
    private javax.swing.JLabel password5;
    private javax.swing.JComboBox<String> productCmb;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox<String> shopCmb;
    private javax.swing.JLabel username1;
    private javax.swing.JLabel username2;
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

    private void showCustomerCombo() {

        try {
            DefaultComboBoxModel customerCombo = (DefaultComboBoxModel) customerCmb.getModel();
            List<Customer> customerList = customerService.getCustomerList();

            for (Customer customer : customerList) {
                customerCombo.addElement(customer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showEmployeeCombo() {

        try {
            DefaultComboBoxModel employeeCombo = (DefaultComboBoxModel) employeeCmb.getModel();
            List<Employee> employeeList = employeeService.getEmployeeList();

            for (Employee employee : employeeList) {
                employeeCombo.addElement(employee);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}