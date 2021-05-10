package az.kontakt.shop.gui;

import az.kontakt.shop.model.Catagory;
import az.kontakt.shop.model.Provider;
import az.kontakt.shop.model.Stock;
import az.kontakt.shop.service.CatagoryService;
import az.kontakt.shop.service.ProviderService;
import az.kontakt.shop.service.StockService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class EditStockFrame extends javax.swing.JFrame {

    private Long selectedId;
    private StockService stockService;
    private ProviderService providerService;
    private CatagoryService catagoryService;
    private MainFrame mainFrame;

    public EditStockFrame(StockService stockService, ProviderService providerService, CatagoryService catagoryService, Long selectedId, MainFrame mainFrame) {
        initComponents();
        this.stockService = stockService;
        this.providerService = providerService;
        this.catagoryService = catagoryService;
        this.mainFrame = mainFrame;
        this.selectedId = selectedId;
        showOldStockData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descriptionTxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        username1 = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        password1 = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        password3 = new javax.swing.JLabel();
        providerCmb = new javax.swing.JComboBox<>();
        catagoryCmb = new javax.swing.JComboBox<>();
        password4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        quantityTxt = new javax.swing.JTextField();
        unitPriceTxt = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Stock");
        setResizable(false);

        descriptionTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descriptionTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionTxtActionPerformed(evt);
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
                .addContainerGap(104, Short.MAX_VALUE))
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
        username1.setText("Provider");

        password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password.setText("Quantity");

        nameTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtActionPerformed(evt);
            }
        });

        password1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password1.setText("Catagory");

        clearBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        password3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password3.setText("Unit Price");

        providerCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Provider" }));
        providerCmb.setToolTipText("");
        providerCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerCmbActionPerformed(evt);
            }
        });

        catagoryCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Catagory" }));

        password4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password4.setText("Description");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("$");

        quantityTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        quantityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTxtActionPerformed(evt);
            }
        });

        unitPriceTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        unitPriceTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitPriceTxtActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(username1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(password1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(descriptionTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(unitPriceTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(providerCmb, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nameTxt)
                    .addComponent(quantityTxt)
                    .addComponent(catagoryCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(providerCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catagoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password1))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password3)
                    .addComponent(jLabel1)
                    .addComponent(unitPriceTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password4)
                    .addComponent(descriptionTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void descriptionTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionTxtActionPerformed

    private void nameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtActionPerformed

    }//GEN-LAST:event_nameTxtActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        nameTxt.setText("");
        quantityTxt.setText("");
        providerCmb.setSelectedIndex(0);
        catagoryCmb.setSelectedIndex(0);
        unitPriceTxt.setText("");
        descriptionTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void providerCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_providerCmbActionPerformed

    private void quantityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTxtActionPerformed

    private void unitPriceTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitPriceTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitPriceTxtActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        try {
            String name = nameTxt.getText();
            Integer quantity = Integer.parseInt(quantityTxt.getText());
            Provider provider = (Provider) providerCmb.getSelectedItem();
            Catagory catagory = (Catagory) catagoryCmb.getSelectedItem();
            Double unitPrice = Double.parseDouble(unitPriceTxt.getText());
            String description = descriptionTxt.getText();

            Stock stock = stockService.getStockById(selectedId);
            stock.setName(name);
            stock.setQuantity(quantity);
            stock.setProvider(provider);
            stock.setCatagory(catagory);
            stock.setUnitPrice(unitPrice);
            stock.setDescription(description);

            stockService.updateStock(stock);
            JOptionPane.showMessageDialog(null, "Stock has been successfully updated!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problem! Stock has not been updated!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        this.dispose();
        try {
            mainFrame.showStockData(stockService.getStockList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> catagoryCmb;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField descriptionTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel password;
    private javax.swing.JLabel password1;
    private javax.swing.JLabel password3;
    private javax.swing.JLabel password4;
    private javax.swing.JComboBox<String> providerCmb;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JTextField unitPriceTxt;
    private javax.swing.JButton updateBtn;
    private javax.swing.JLabel username;
    private javax.swing.JLabel username1;
    // End of variables declaration//GEN-END:variables

    private void showOldStockData() {

        try {

            Stock stock = stockService.getStockById(selectedId);
            nameTxt.setText(stock.getName());
            quantityTxt.setText(String.valueOf(stock.getQuantity()));
            editProviderCombo(stock.getProvider());
            editCatagoryCombo(stock.getCatagory());
            unitPriceTxt.setText(String.valueOf(stock.getUnitPrice()));
            descriptionTxt.setText(stock.getDescription());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editProviderCombo(Provider p) {

        try {
            DefaultComboBoxModel providerCombo = (DefaultComboBoxModel) providerCmb.getModel();
            List<Provider> providerList = providerService.getProviderList();
            for (Provider provider : providerList) {
                providerCombo.addElement(provider);
            }
            providerCombo.setSelectedItem(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void editCatagoryCombo(Catagory c) {

        try {
            DefaultComboBoxModel catagoryCombo = (DefaultComboBoxModel) catagoryCmb.getModel();
            List<Catagory> catagoryList = catagoryService.getCatagoryList();

            for (Catagory catagory : catagoryList) {
                catagoryCombo.addElement(catagory);
            }
            catagoryCombo.setSelectedItem(c);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
