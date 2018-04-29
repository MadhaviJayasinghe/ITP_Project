package Interface;



import My_Code.DBconnect;
import static Validation.validation.vvalidation;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author MAXMO
 */
public class Report_Home extends javax.swing.JInternalFrame {
    Connection ct = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public static String pstm;
    public static String petm;
private void showdate(){
        Date d=new Date();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        jLabel27.setText(s.format(d));
        


}
    /**
     * Creates new form Report_Home
     */
    public Report_Home() {
        initComponents();
        showdate();
      showdate();
        ct = DBconnect.connect();
        String qq =jLabel27.getText();
        
        try {
            String p = "SELECT SUM(c.payment_amount) FROM cust_payments c WHERE c.payment_date = '"+ qq + "' AND c.payment_id NOT IN (select cus_pay_fk FROM cust_card )";  
            ps = ct.prepareStatement(p); 
            rs = ps.executeQuery(); 
            while(rs.next()){
                if(rs.getString("SUM(c.payment_amount)")==null){
                    jLabel17.setText("0");
                }
                else{
            jLabel17.setText(rs.getString("SUM(c.payment_amount)"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
        try {
            String p = "select SUM(chqPay+cashBillPay+other) from cashmng where date='"+qq+"'";  
            ps = ct.prepareStatement(p); 
            rs = ps.executeQuery(); 
            while(rs.next()){
                if(rs.getString("SUM(chqPay+cashBillPay+other)")==null){
                    jLabel21.setText("0");
                }
                else{  
            jLabel21.setText(rs.getString("SUM(chqPay+cashBillPay+other)"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
         try {
            String p = "select SUM(disc_amount) from discounts where date='"+qq+"'";  
            ps = ct.prepareStatement(p); 
            rs = ps.executeQuery(); 
            while(rs.next()){
             if(rs.getString("SUM(disc_amount)")==null){
                    jLabel22.setText("0");
                }
                else{   
            jLabel22.setText(rs.getString("SUM(disc_amount)"));
             }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
         try {
            String p = "select SUM(debt_amount) from debt where debt_status = 'y'  AND debt_date='"+qq+"'";  
            ps = ct.prepareStatement(p); 
            rs = ps.executeQuery(); 
            while(rs.next()){
                if(rs.getString("SUM(debt_amount)")==null){
                   jLabel24.setText("0");
                }
                else{
            jLabel24.setText(rs.getString("SUM(debt_amount)"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Customer = new javax.swing.JButton();
        Register = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        Customer1 = new javax.swing.JButton();
        IHome = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1080, 725));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(85, 55, 118));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Customer.setBackground(new java.awt.Color(85, 55, 118));
        Customer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Customer.setForeground(new java.awt.Color(255, 255, 255));
        Customer.setText("Daily profit Report");
        Customer.setAutoscrolls(true);
        Customer.setBorder(null);
        Customer.setBorderPainted(false);
        Customer.setFocusable(false);
        Customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerActionPerformed(evt);
            }
        });
        jPanel3.add(Customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 180, 40));

        Register.setBackground(new java.awt.Color(85, 55, 118));
        Register.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Register.setForeground(new java.awt.Color(255, 255, 255));
        Register.setText("Monthly Sales Report");
        Register.setAutoscrolls(true);
        Register.setBorder(null);
        Register.setBorderPainted(false);
        Register.setFocusable(false);
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        jPanel3.add(Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 220, 40));

        Logout.setBackground(new java.awt.Color(85, 55, 118));
        Logout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");
        Logout.setAutoscrolls(true);
        Logout.setBorder(null);
        Logout.setBorderPainted(false);
        Logout.setFocusable(false);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jPanel3.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 111, 40));

        Customer1.setBackground(new java.awt.Color(85, 55, 118));
        Customer1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Customer1.setForeground(new java.awt.Color(255, 255, 255));
        Customer1.setText("Daily Sales Report");
        Customer1.setAutoscrolls(true);
        Customer1.setBorder(null);
        Customer1.setBorderPainted(false);
        Customer1.setFocusable(false);
        Customer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customer1ActionPerformed(evt);
            }
        });
        jPanel3.add(Customer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Date :");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Input :");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 59, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Total");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 400, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("NULL");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setText("=");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Starting cashier amount");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Cashier remain total");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 53, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("=");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("=");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("NULL");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("NULL");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, 510, 436));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Message :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 578, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("NULL");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 578, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("NULL");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 55, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Daily cashouts");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 53, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Discount");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 93, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Debt income");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 133, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Total");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 400, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("NULL");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 53, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("NULL");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 93, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("NULL");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 133, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("NULL");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 400, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("=");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 53, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("=");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 93, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setText("=");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 133, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setText("=");
        jPanel6.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 400, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Customer Sales (cash)");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("NULL");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 13, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setText("=");
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 13, -1, -1));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 115, 510, 436));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setText("Daily Sales ");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 21, -1, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 56, 101, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Total :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 59, -1, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 56, 104, -1));

        jButton1.setBackground(new java.awt.Color(85, 55, 118));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("calculate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 578, 172, -1));

        jButton2.setBackground(new java.awt.Color(85, 55, 118));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Genarate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 578, 147, -1));

        jDesktopPane1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        IHome.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout IHomeLayout = new javax.swing.GroupLayout(IHome);
        IHome.setLayout(IHomeLayout);
        IHomeLayout.setHorizontalGroup(
            IHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        IHomeLayout.setVerticalGroup(
            IHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(IHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1080, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerActionPerformed
        jDesktopPane1.removeAll();
        DailyPROF m = new DailyPROF();
        jDesktopPane1.add(m).setVisible(true);
        
        
        /*IHome.removeAll ();
        cusstomerManagement CM = new cusstomerManagement ();
        IHome.add ( CM ).setVisible ( true );*/
    }//GEN-LAST:event_CustomerActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        jDesktopPane1.removeAll();
        MonthlyPROF mf = new MonthlyPROF();
        jDesktopPane1.add(mf).setVisible(true);
        /*IHome.removeAll ();
        customerReg CR = new customerReg ();
        IHome.add ( CR ).setVisible ( true );*/
    }//GEN-LAST:event_RegisterActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed

        Home_Page1 HP1 = new Home_Page1 ();
        HP1.setVisible ( true );
        this.dispose ();
    }//GEN-LAST:event_LogoutActionPerformed

    private void Customer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Customer1ActionPerformed
        jDesktopPane1.removeAll();
        SalesREP sr = new SalesREP();
        jDesktopPane1.add(sr).setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_Customer1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
//        if(vvalidation(jTextField1.getText())){
//            jLabel19.setText(jTextField1.getText());
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
//        if(vvalidation(jTextField2.getText())){
//            jLabel20.setText(jTextField2.getText());
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            double e1 = Double.parseDouble(jLabel17.getText());
            //double e2 = Double.parseDouble(jLabel18.getText());
            double l1 = Double.parseDouble(jLabel19.getText());
            double l2 = Double.parseDouble(jLabel20.getText());
            double l3 = Double.parseDouble(jLabel21.getText());
            double l4 = Double.parseDouble(jLabel22.getText());
            double l6 = Double.parseDouble(jLabel24 .getText());
            double tot = l2 - l1;
            double tot2= e1 - l3 - l4 + l6;
            String tt=Double.toString(tot);
            String tt2=Double.toString(tot2);
            jLabel25.setText(tt);
            jLabel26.setText(tt2);
            if(jLabel25.getText().equals(jLabel26.getText())){
                jLabel16.setText("Balancesheet is balanced");
            }
            else{
                jLabel16.setText("NOT BALANCED");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Input Remaining Amount and Started Amount");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String stm = jLabel19.getText();
         pstm = jLabel19.getText();
        petm = jLabel20.getText();
        if("Balancesheet is balanced".equals(jLabel16.getText())){
            int x= JOptionPane.showConfirmDialog(null,"Do you really want to print ?");
                    if(x==0){   
            bill b;
                try {
                    b = new bill(pstm,petm);
                    b.setVisible(true);
                } catch (PrinterException ex) {
                    //Logger.getLogger(Report_Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                    } 
        }
        else{
            JOptionPane.showMessageDialog(null, "Balancesheet is not balanced \n Cannot print");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        vvalidation(Character.toString(c));
       jLabel19.setText(jTextField1.getText());
        if(!(vvalidation(Character.toString(c))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER))){
            //getToolkit().beep();
            jTextField1.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Invalid input\n Please enter price");
            evt.consume();
        }
        jTextField1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        jLabel20.setText(jTextField2.getText());
        /*if(!(vvalidation(Character.toString(c))||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER))){
            getToolkit().beep();
            jTextField2.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Invalid input\n Please enter price");
            evt.consume();
        }*/
//        else if(vvalidation(Character.toString(c)))
//            jLabel20.setText(Character.toString(c));

        jTextField2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }//GEN-LAST:event_jTextField2KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Customer;
    private javax.swing.JButton Customer1;
    private javax.swing.JDesktopPane IHome;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Register;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}