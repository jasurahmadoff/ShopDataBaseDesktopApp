package az.kontakt.shop.gui;

import az.kontakt.shop.model.Product;
import az.kontakt.shop.model.Shop;
import az.kontakt.shop.model.Stock;
import az.kontakt.shop.service.ProductService;
import az.kontakt.shop.service.ShopService;
import az.kontakt.shop.service.StockService;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class EditProductFrame extends javax.swing.JFrame {

    private ProductService productService;
    private ShopService shopService;
    private StockService stockService;
    private MainFrame mainFrame;
    private Long selectedId;

    public EditProductFrame(ProductService productService, ShopService shopService, StockService stockService, Long selectedId, MainFrame mainFrame) {

        initComponents();
        this.productService = productService;
        this.shopService = shopService;
        this.stockService = stockService;
        this.mainFrame = mainFrame;
        this.selectedId = selectedId;
        showOldProductData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stockCmb = new javax.swing.JComboBox<>();
        quantityTxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        shopLbl = new javax.swing.JLabel();
        stockLbl = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        quantityLbl = new javax.swing.JLabel();
        shopCmb = new javax.swing.JComboBox<>();
        updateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Product");
        setResizable(false);

        stockCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Stock" }));

        quantityTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        quantityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTxtActionPerformed(evt);
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
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        shopLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        shopLbl.setText("Shop");

        stockLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stockLbl.setText("Stock");

        clearBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        quantityLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantityLbl.setText("Quantity");

        shopCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Shop" }));
        shopCmb.setToolTipText("");
        shopCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopCmbActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(shopLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stockLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(53, 53, 53))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(quantityLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shopCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stockCmb, 0, 205, Short.MAX_VALUE)
                            .addComponent(quantityTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shopLbl)
                    .addComponent(shopCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stockCmb, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(stockLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void quantityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTxtActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        shopCmb.setSelectedIndex(0);
        stockCmb.setSelectedIndex(0);
        quantityTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void shopCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shopCmbActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        try {
            Shop shop = (Shop) shopCmb.getSelectedItem();
            Stock stock = (Stock) stockCmb.getSelectedItem();
            Integer quantity = Integer.parseInt(quantityTxt.getText());
            Integer count = productService.findTotalCountOfSelectedProductInProductTable(stock);

            if ((quantity + count) > stock.getQuantity()) {
                JOptionPane.showMessageDialog(null, "Total count of " + stock.getName() + " in stock can not be exceeded!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Product product = productService.getProductByID(selectedId);
                product.setShop(shop);
                product.setStock(stock);
                product.setQuantity(quantity);
                productService.updateProduct(product);
                JOptionPane.showMessageDialog(null, "Product has been successfully updated!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problem! Product has not been updated!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        this.dispose();
        try {
            mainFrame.showProductData(productService.getProductList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel quantityLbl;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JComboBox<String> shopCmb;
    private javax.swing.JLabel shopLbl;
    private javax.swing.JComboBox<String> stockCmb;
    private javax.swing.JLabel stockLbl;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void showOldProductData() {

        try {
            Product pro = productService.getProductByID(selectedId);
            editShopCombo(pro.getShop());
            editStockCombo(pro.getStock());
            quantityTxt.setText(String.valueOf(pro.getQuantity()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void editShopCombo(Shop s) {

        try {

            DefaultComboBoxModel shopCombo = (DefaultComboBoxModel) shopCmb.getModel();
            List<Shop> shopList = shopService.getShopList();

            for (Shop shop : shopList) {
                shopCombo.addElement(shop);
            }

            shopCombo.setSelectedItem(s);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void editStockCombo(Stock s) {

        try {
            DefaultComboBoxModel stockCombo = (DefaultComboBoxModel) stockCmb.getModel();
            List<Stock> stockList = stockService.getStockList();

            for (Stock stock : stockList) {
                stockCombo.addElement(stock);
            }
            stockCombo.setSelectedItem(s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
