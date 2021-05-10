package az.kontakt.shop.gui;

import az.kontakt.shop.model.*;
import az.kontakt.shop.service.*;
import jaco.mp3.player.MP3Player;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {

    private CustomerService customerService;
    private StockService stockService;
    private EmployeeService employeeService;
    private ProviderService providerService;
    private LoginUser loginUser;
    private ShopService shopService;
    private JobService jobService;
    private ProductService productService;
    private SaleService saleService;
    private String globBtnName = "";
    private CatagoryService catagoryService;
    public static final String SONG_PATH = "welcome.mp3";
    public static MP3Player mp3Player = new MP3Player(new File(SONG_PATH));

    public MainFrame(CustomerService customerService, EmployeeService employeeService,
            ProviderService providerService, JobService jobService,
            ShopService shopService, ProductService productService,
            StockService stockService, SaleService saleService, CatagoryService catagoryService, LoginUser loginUser) {

        mp3Player.play();

        initComponents();
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.providerService = providerService;
        this.stockService = stockService;
        this.jobService = jobService;
        this.shopService = shopService;
        this.saleService = saleService;
        this.productService = productService;
        this.loginUser = loginUser;
        this.catagoryService = catagoryService;
        nameSurnameTxt.setText(this.loginUser.getName() + " " + this.loginUser.getSurname());

        if (loginUser.getRole().getRoleName().equals("ROLE_EMPLOYEE")) {
            delBtn.setVisible(false);
            System.out.println("Hello, Employee!");
        } else {
            System.out.println("Hello, Admin!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        stockDataBtn = new javax.swing.JButton();
        shopDataBtn = new javax.swing.JButton();
        productDataBtn = new javax.swing.JButton();
        jobDataBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        customerDataBtn = new javax.swing.JButton();
        providerDataBtn = new javax.swing.JButton();
        employeeDataBtn = new javax.swing.JButton();
        saleDataBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        delBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        newBtn = new javax.swing.JButton();
        keywordTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        azLang = new javax.swing.JLabel();
        engLang = new javax.swing.JLabel();
        welcomeLbl = new javax.swing.JLabel();
        nameSurnameTxt = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(250, 600));

        stockDataBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        stockDataBtn.setText("Stock Data      ");
        stockDataBtn.setMaximumSize(new java.awt.Dimension(300, 34));
        stockDataBtn.setMinimumSize(new java.awt.Dimension(180, 34));
        stockDataBtn.setName(""); // NOI18N
        stockDataBtn.setPreferredSize(new java.awt.Dimension(180, 34));
        stockDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockDataBtnActionPerformed(evt);
            }
        });

        shopDataBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        shopDataBtn.setText("Shop Data       ");
        shopDataBtn.setMaximumSize(new java.awt.Dimension(300, 34));
        shopDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopDataBtnActionPerformed(evt);
            }
        });

        productDataBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        productDataBtn.setText("Product Data   ");
        productDataBtn.setMaximumSize(new java.awt.Dimension(300, 34));
        productDataBtn.setMinimumSize(new java.awt.Dimension(180, 34));
        productDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productDataBtnActionPerformed(evt);
            }
        });

        jobDataBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jobDataBtn.setText("Job Data         ");
        jobDataBtn.setMaximumSize(new java.awt.Dimension(300, 34));
        jobDataBtn.setMinimumSize(new java.awt.Dimension(180, 34));
        jobDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobDataBtnActionPerformed(evt);
            }
        });

        logOutBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        logOutBtn.setText("Log Out            ");
        logOutBtn.setMaximumSize(new java.awt.Dimension(300, 34));
        logOutBtn.setMinimumSize(new java.awt.Dimension(180, 34));
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        customerDataBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        customerDataBtn.setText("Customer Data ");
        customerDataBtn.setMaximumSize(new java.awt.Dimension(300, 34));
        customerDataBtn.setMinimumSize(new java.awt.Dimension(180, 34));
        customerDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerDataBtnActionPerformed(evt);
            }
        });

        providerDataBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        providerDataBtn.setText("Provider Data  ");
        providerDataBtn.setMaximumSize(new java.awt.Dimension(300, 34));
        providerDataBtn.setMinimumSize(new java.awt.Dimension(180, 34));
        providerDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerDataBtnActionPerformed(evt);
            }
        });

        employeeDataBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        employeeDataBtn.setText("Employee Data");
        employeeDataBtn.setMaximumSize(new java.awt.Dimension(300, 34));
        employeeDataBtn.setMinimumSize(new java.awt.Dimension(180, 34));
        employeeDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeDataBtnActionPerformed(evt);
            }
        });

        saleDataBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        saleDataBtn.setText("Sale Data         ");
        saleDataBtn.setMaximumSize(new java.awt.Dimension(300, 34));
        saleDataBtn.setMinimumSize(new java.awt.Dimension(180, 34));
        saleDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleDataBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shopDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jobDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stockDataBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(productDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(providerDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saleDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stockDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shopDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jobDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(providerDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saleDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        delBtn.setBackground(new java.awt.Color(255, 0, 0));
        delBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        delBtn.setText("Delete");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(255, 0, 0));
        editBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        editBtn.setText("Edit");
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        newBtn.setBackground(new java.awt.Color(255, 0, 0));
        newBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        keywordTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        keywordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keywordTxtActionPerformed(evt);
            }
        });
        keywordTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keywordTxtKeyReleased(evt);
            }
        });

        searchBtn.setBackground(new java.awt.Color(255, 0, 0));
        searchBtn.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        searchBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cesur\\Desktop\\Java\\Udemy\\ShopDataBaseDesktopApp\\search.png")); // NOI18N
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cesur\\Desktop\\Java\\Udemy\\ShopDataBaseDesktopApp\\contact.png")); // NOI18N

        azLang.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cesur\\Desktop\\Java\\Udemy\\ShopDataBaseDesktopApp\\az.png")); // NOI18N
        azLang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                azLangMouseClicked(evt);
            }
        });

        engLang.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cesur\\Desktop\\Java\\Udemy\\ShopDataBaseDesktopApp\\eng.png")); // NOI18N
        engLang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                engLangMouseClicked(evt);
            }
        });

        welcomeLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        welcomeLbl.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLbl.setText("Welcome,");

        nameSurnameTxt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameSurnameTxt.setForeground(new java.awt.Color(255, 255, 255));
        nameSurnameTxt.setText("Jasur Ahmadov");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, Short.MAX_VALUE)
                        .addComponent(keywordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(searchBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(azLang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(engLang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(welcomeLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameSurnameTxt)))))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(engLang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(azLang, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameSurnameTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(welcomeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(keywordTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBtn))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(21);
        jTable1.setRowMargin(3);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void stockDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockDataBtnActionPerformed

        keywordTxt.setText("");
        try {
            showStockData(stockService.getStockList());
            globBtnName = "stock";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_stockDataBtnActionPerformed

    private void shopDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopDataBtnActionPerformed

        keywordTxt.setText("");
        try {
            showShopData(shopService.getShopList());
            globBtnName = "shop";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_shopDataBtnActionPerformed

    private void productDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productDataBtnActionPerformed

        keywordTxt.setText("");
        try {
            showProductData(productService.getProductList());
            globBtnName = "product";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_productDataBtnActionPerformed

    private void jobDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobDataBtnActionPerformed
        keywordTxt.setText("");
        try {
            showJobData(jobService.getJobList());
            globBtnName = "job";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jobDataBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getClickCount() == 2) {
            editBtnActionPerformed(null);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed

        MainFrame.mp3Player.stop();
        int isConfirmed = JOptionPane.showConfirmDialog(null, "Are you sure?", "Log Out", JOptionPane.YES_NO_OPTION);

        if (isConfirmed == JOptionPane.YES_OPTION) {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void customerDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerDataBtnActionPerformed

        keywordTxt.setText("");
        try {
            showCustomerData(customerService.getCustomerList());
            globBtnName = "customer";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_customerDataBtnActionPerformed

    private void saleDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleDataBtnActionPerformed

        keywordTxt.setText("");
        try {
            showSaleData(saleService.getSaleList());
            globBtnName = "sale";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_saleDataBtnActionPerformed

    private void providerDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerDataBtnActionPerformed

        keywordTxt.setText("");
        try {
            showProviderData(providerService.getProviderList());
            globBtnName = "provider";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_providerDataBtnActionPerformed

    private void employeeDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeDataBtnActionPerformed

        keywordTxt.setText("");
        try {
            showEmployeeData(employeeService.getEmployeeList());
            globBtnName = "employee";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_employeeDataBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        try {
            String keyword = keywordTxt.getText();

            switch (globBtnName) {

                case "stock":
                    List<Stock> stockList = stockService.searchStockData(keyword);
                    showStockData(stockList);
                    break;
                case "shop":
                    List<Shop> shopList = shopService.searchShopData(keyword);
                    showShopData(shopList);
                    break;
                case "product":
                    List<Product> productList = productService.searchProductData(keyword);
                    showProductData(productList);
                    break;
                case "job":
                    List<Job> jobList = jobService.searchJobData(keyword);
                    showJobData(jobList);
                    break;
                case "provider":
                    List<Provider> providerList = providerService.searchProviderData(keyword);
                    showProviderData(providerList);
                    break;
                case "customer":
                    List<Customer> customerList = customerService.searchCustomerData(keyword);
                    showCustomerData(customerList);
                    break;
                case "employee":
                    List<Employee> employeeList = employeeService.searchEmployeeData(keyword);
                    showEmployeeData(employeeList);
                    break;
                case "sale":
                    List<Sale> saleList = saleService.searchSaleData(keyword);
                    showSaleData(saleList);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please, select menu!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void keywordTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keywordTxtKeyReleased
        searchBtnActionPerformed(null);
    }//GEN-LAST:event_keywordTxtKeyReleased

    private void keywordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywordTxtActionPerformed
    }//GEN-LAST:event_keywordTxtActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed

        switch (globBtnName) {
            case "customer":
                NewCustomerFrame newCustomerFrame = new NewCustomerFrame(customerService, this);
                newCustomerFrame.setVisible(true);
                break;
            case "employee":
                NewEmployeeFrame newEmployeeFrame = new NewEmployeeFrame(employeeService, shopService, jobService, this);
                newEmployeeFrame.setVisible(true);
                break;
            case "job":
                NewJobFrame newJobFrame = new NewJobFrame(jobService, this);
                newJobFrame.setVisible(true);
                break;
            case "product":
                NewProductFrame newProductFrame = new NewProductFrame(productService, shopService, stockService, this);
                newProductFrame.setVisible(true);
                break;
            case "provider":
                NewProviderFrame newProviderFrame = new NewProviderFrame(providerService, this);
                newProviderFrame.setVisible(true);
                break;
            case "sale":
                NewSaleFrame newSaleFrame = new NewSaleFrame(saleService, shopService, productService, customerService, employeeService, this);
                newSaleFrame.setVisible(true);
                break;
            case "shop":
                NewShopFrame newShopFrame = new NewShopFrame(shopService, this);
                newShopFrame.setVisible(true);
                break;
            case "stock":
                NewStockFrame newStockFrame = new NewStockFrame(stockService, providerService, catagoryService, this);
                newStockFrame.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please, select menu!");
        }
    }//GEN-LAST:event_newBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed

        int rowIndex = jTable1.getSelectedRow();

        if (rowIndex != -1) {

            Long selectedId = (Long) jTable1.getValueAt(rowIndex, 0);

            switch (globBtnName) {
                case "customer":
                    EditCustomerFrame editCustomerFrame = new EditCustomerFrame(customerService, selectedId, this);
                    editCustomerFrame.setVisible(true);
                    break;
                case "employee":
                    EditEmployeeFrame editEmployeeFrame = new EditEmployeeFrame(employeeService, shopService, jobService, selectedId, this);
                    editEmployeeFrame.setVisible(true);
                    break;
                case "job":
                    EditJobFrame editJobFrame = new EditJobFrame(jobService, selectedId, this);
                    editJobFrame.setVisible(true);
                    break;
                case "product":
                    EditProductFrame editProductFrame = new EditProductFrame(productService, shopService, stockService, selectedId, this);
                    editProductFrame.setVisible(true);
                    break;
                case "provider":
                    EditProviderFrame editProviderFrame = new EditProviderFrame(providerService, selectedId, this);
                    editProviderFrame.setVisible(true);
                    break;
                case "sale":
                    EditSaleFrame editSaleFrame = new EditSaleFrame(saleService, shopService, productService, customerService, employeeService, selectedId, this);
                    editSaleFrame.setVisible(true);
                    break;
                case "shop":
                    EditShopFrame editShopFrame = new EditShopFrame(shopService, selectedId, this);
                    editShopFrame.setVisible(true);
                    break;
                case "stock":
                    EditStockFrame editStockFrame = new EditStockFrame(stockService, providerService, catagoryService, selectedId, this);
                    editStockFrame.setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please, select menu!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please, select menu!");
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
    }//GEN-LAST:event_editBtnMouseClicked

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed

        int rowIndex = jTable1.getSelectedRow();
        int isConfirmed;

        try {
            if (rowIndex != -1) {

                Long selectedId = (Long) jTable1.getValueAt(rowIndex, 0);

                switch (globBtnName) {
                    case "stock":
                        isConfirmed = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Stock", JOptionPane.YES_NO_OPTION);
                        if (isConfirmed == JOptionPane.YES_OPTION) {
                            stockService.deleteStock(selectedId);
                            JOptionPane.showMessageDialog(null, "Stock has been successfully deleted!");
                            showStockData(stockService.getStockList());
                        }
                        break;
                    case "shop":

                        isConfirmed = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Shop", JOptionPane.YES_NO_OPTION);
                        if (isConfirmed == JOptionPane.YES_OPTION) {
                            shopService.deleteShop(selectedId);
                            JOptionPane.showMessageDialog(null, "Shop has been successfully deleted!");
                            showShopData(shopService.getShopList());
                        }
                        break;
                    case "product":

                        isConfirmed = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Product", JOptionPane.YES_NO_OPTION);
                        if (isConfirmed == JOptionPane.YES_OPTION) {
                            productService.deleteProduct(selectedId);
                            JOptionPane.showMessageDialog(null, "Product has been successfully deleted!");
                            showProductData(productService.getProductList());
                        }
                        break;
                    case "job":

                        isConfirmed = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Job", JOptionPane.YES_NO_OPTION);
                        if (isConfirmed == JOptionPane.YES_OPTION) {
                            jobService.deleteJob(selectedId);
                            JOptionPane.showMessageDialog(null, "Job has been successfully deleted!");
                            showJobData(jobService.getJobList());
                        }
                        break;
                    case "provider":
                        isConfirmed = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Provider", JOptionPane.YES_NO_OPTION);
                        if (isConfirmed == JOptionPane.YES_OPTION) {
                            providerService.deleteProvider(selectedId);
                            JOptionPane.showMessageDialog(null, "Provider has been successfully deleted!");
                            showProviderData(providerService.getProviderList());
                        }
                        break;
                    case "customer":

                        isConfirmed = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Customer", JOptionPane.YES_NO_OPTION);
                        if (isConfirmed == JOptionPane.YES_OPTION) {
                            customerService.deleteCustomer(selectedId);
                            JOptionPane.showMessageDialog(null, "Customer has been successfully deleted!");
                            showCustomerData(customerService.getCustomerList());
                        }
                        break;
                    case "employee":

                        isConfirmed = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Employee", JOptionPane.YES_NO_OPTION);
                        if (isConfirmed == JOptionPane.YES_OPTION) {
                            employeeService.deleteEmployee(selectedId);
                            JOptionPane.showMessageDialog(null, "Employee has been successfully deleted!");
                            showEmployeeData(employeeService.getEmployeeList());
                        }
                        break;
                    case "sale":

                        isConfirmed = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete Sale", JOptionPane.YES_NO_OPTION);
                        if (isConfirmed == JOptionPane.YES_OPTION) {
                            saleService.deleteSale(selectedId);
                            JOptionPane.showMessageDialog(null, "Sale has been successfully deleted!");
                            showSaleData(saleService.getSaleList());
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Please, select menu!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please, select menu!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problem! " + globBtnName + " has not been successfully deleted!");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_delBtnActionPerformed

    private void azLangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_azLangMouseClicked

        welcomeLbl.setText("Xos gelmisiniz,");

        newBtn.setText("Yeni");
        editBtn.setText("Redakte");
        delBtn.setText("Sil");

        stockDataBtn.setText("Anbar          ");
        shopDataBtn.setText("Magazalar   ");
        productDataBtn.setText("Mallar          ");
        jobDataBtn.setText("Ixtisaslar      ");
        providerDataBtn.setText("Techizatcilar");
        customerDataBtn.setText("Musteriler     ");
        employeeDataBtn.setText("Ishchiler      ");
        saleDataBtn.setText("Satis           ");

        logOutBtn.setText("Cixis           ");
    }//GEN-LAST:event_azLangMouseClicked

    private void engLangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_engLangMouseClicked

        welcomeLbl.setText("Welcome,");

        newBtn.setText("New");
        editBtn.setText("Edit");
        delBtn.setText("Delete");

        stockDataBtn.setText("Stock Data      ");
        shopDataBtn.setText("Shop Data       ");
        productDataBtn.setText("Product Data   ");
        jobDataBtn.setText("Job Data         ");
        providerDataBtn.setText("Provider Data  ");
        customerDataBtn.setText("Customer Data ");
        employeeDataBtn.setText("Employee Data");
        saleDataBtn.setText("Sale Data         ");

        logOutBtn.setText("Log Out");
    }//GEN-LAST:event_engLangMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel azLang;
    private javax.swing.JButton customerDataBtn;
    private javax.swing.JButton delBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton employeeDataBtn;
    private javax.swing.JLabel engLang;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jobDataBtn;
    private javax.swing.JTextField keywordTxt;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel nameSurnameTxt;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton productDataBtn;
    private javax.swing.JButton providerDataBtn;
    private javax.swing.JButton saleDataBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton shopDataBtn;
    private javax.swing.JButton stockDataBtn;
    private javax.swing.JLabel welcomeLbl;
    // End of variables declaration//GEN-END:variables

    public void showCustomerData(List<Customer> customerList) {

        try {

            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            jTable1.setModel(model);
            model.addColumn("№");
            model.addColumn("Name");
            model.addColumn("Surname");
            model.addColumn("Address");
            model.addColumn("Phone");
            model.addColumn("Postal Code");

            for (Customer c : customerList) {
                Object[] data = new Object[]{
                    c.getId(), c.getName(), c.getSurname(), c.getAddress(), c.getPhone(), c.getPostalCode()
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showEmployeeData(List<Employee> employeeList) {

        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            jTable1.setModel(model);
            model.addColumn("№");
            model.addColumn("Name");
            model.addColumn("Surname");
            model.addColumn("Shop");
            model.addColumn("Job");
            model.addColumn("Salary");
            model.addColumn("Hire Date");

            for (Employee emp : employeeList) {
                Object[] data = new Object[]{
                    emp.getId(), emp.getName(), emp.getSurname(),
                    emp.getShop().getName(), emp.getJob().getName(),
                    "$" + emp.getSalary(), new SimpleDateFormat("dd-MMM-yyyy").format(emp.getHireDate())
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showProviderData(List<Provider> providerList) {

        try {

            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            jTable1.setModel(model);
            model.addColumn("№");
            model.addColumn("Name");
            model.addColumn("City");
            model.addColumn("Country");
            model.addColumn("Phone");

            for (Provider p : providerList) {
                Object[] data = new Object[]{
                    p.getId(), p.getName(), p.getCity(), p.getCountry(), p.getPhone()
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showJobData(List<Job> jobList) {

        try {

            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            jTable1.setModel(model);
            model.addColumn("№");
            model.addColumn("Name");
            model.addColumn("Description");

            for (Job j : jobList) {
                Object[] data = new Object[]{
                    j.getId(), j.getName(), j.getDescription()
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showShopData(List<Shop> shopList) {

        try {

            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            jTable1.setModel(model);
            model.addColumn("№");
            model.addColumn("Name");
            model.addColumn("City");
            model.addColumn("Address");
            model.addColumn("Phone");

            for (Shop shop : shopList) {
                Object[] data = new Object[]{
                    shop.getId(), shop.getName(), shop.getCity(),
                    shop.getAddress(), shop.getPhone()
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showProductData(List<Product> productList) {

        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            jTable1.setModel(model);
            model.addColumn("№");
            model.addColumn("Shop Name");
            model.addColumn("Product Name");
            model.addColumn("Product Quantity");

            for (Product product : productList) {
                Object[] data = new Object[]{
                    product.getId(), product.getShop().getName(), product.getStock().getName(),
                    product.getQuantity()
                };
                model.addRow(data);
            }

            model.fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showStockData(List<Stock> stockList) {

        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            jTable1.setModel(model);
            model.addColumn("№");
            model.addColumn("Name");
            model.addColumn("Quantity");
            model.addColumn("Provider");
            model.addColumn("Catagory");
            model.addColumn("Unit Price");
            model.addColumn("Description");
            model.addColumn("Update Time");

            for (Stock st : stockList) {
                Object[] data = new Object[]{
                    st.getId(), st.getName(), st.getQuantity(),
                    st.getProvider().getName(), st.getCatagory().getName(),
                    "$" + st.getUnitPrice(), st.getDescription(), new SimpleDateFormat("dd-MMM-yyyy").format(st.getLastUpdate())
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showSaleData(List<Sale> saleList) {

        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            jTable1.setModel(model);
            model.addColumn("№");
            model.addColumn("Shop");
            model.addColumn("Product");
            model.addColumn("Customer");
            model.addColumn("Employee");
            model.addColumn("Unit Price");
            model.addColumn("Quantity");
            model.addColumn("Discount");
            model.addColumn("Total Amount");
            model.addColumn("Cheque");
            model.addColumn("Sale Date");

            for (Sale sale : saleList) {
                Object[] data = new Object[]{
                    sale.getId(), sale.getShop(), sale.getProduct(), sale.getCustomer(),
                    sale.getEmployee(), "$" + sale.getProduct().getStock().getUnitPrice(), sale.getQuantity(),
                    sale.getDiscount() + "%",
                    "$" + sale.getAmount(), sale.getChequeNumber(), new SimpleDateFormat("dd-MMM-yyyy").format(sale.getSaleDate())
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
