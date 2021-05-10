package az.kontakt.shop.gui;

import az.kontakt.shop.model.*;
import az.kontakt.shop.service.*;
import java.util.List;
import javax.swing.*;

public class NewProductFrame extends javax.swing.JFrame {

    private ProductService productService;
    private ShopService shopService;
    private StockService stockService;
    private MainFrame mainFrame;

    public NewProductFrame(ProductService productService, ShopService shopService, StockService stockService, MainFrame mainFrame) {
        initComponents();
        this.productService = productService;
        this.shopService = shopService;
        this.stockService = stockService;
        this.mainFrame = mainFrame;

        showShopCombo();
        showStockCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        username1 = new javax.swing.JLabel();
        password1 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        password3 = new javax.swing.JLabel();
        shopCmb = new javax.swing.JComboBox<>();
        stockCmb = new javax.swing.JComboBox<>();
        quantityTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Product");
        setResizable(false);

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

        username1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username1.setText("Shop");

        password1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password1.setText("Stock");

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

        password3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password3.setText("Quantity");

        shopCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Shop" }));
        shopCmb.setToolTipText("");
        shopCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopCmbActionPerformed(evt);
            }
        });

        stockCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Stock" }));

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
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(username1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(password1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(53, 53, 53))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(password3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(stockCmb, javax.swing.GroupLayout.Alignment.TRAILING, 0, 174, Short.MAX_VALUE)
                            .addComponent(shopCmb, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantityTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username1)
                    .addComponent(shopCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stockCmb, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(password1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed

        try {
            Shop shop = (Shop) shopCmb.getSelectedItem();
            Stock stock = (Stock) stockCmb.getSelectedItem();
            Integer quantity = Integer.parseInt(quantityTxt.getText());

            Integer count = productService.findTotalCountOfSelectedProductInProductTable(stock);

            if ((quantity + count) > stock.getQuantity()) {
                JOptionPane.showMessageDialog(null, "Total count of " + stock.getName() + " in stock can not be exceeded!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                Product product = new Product();
                product.setShop(shop);
                product.setStock(stock);
                product.setQuantity(quantity);

                productService.addProduct(product);
                JOptionPane.showMessageDialog(null, "Product has been successfully added!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problem! Product has not been successfully added!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        this.dispose();
        try {
            mainFrame.showProductData(productService.getProductList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        shopCmb.setSelectedIndex(0);
        stockCmb.setSelectedIndex(0);
        quantityTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void shopCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shopCmbActionPerformed

    private void quantityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel password1;
    private javax.swing.JLabel password3;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox<String> shopCmb;
    private javax.swing.JComboBox<String> stockCmb;
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

    private void showStockCombo() {

        try {

            DefaultComboBoxModel stockCombo = (DefaultComboBoxModel) stockCmb.getModel();
            List<Stock> stockList = stockService.getStockList();

            for (Stock stock : stockList) {
                stockCombo.addElement(stock);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
