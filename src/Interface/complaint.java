package Interface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Validation.report_Code;
import My_Code.DBconnect;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import java.sql.Date;
import javax.swing.BorderFactory;
//import myCode.report_Code;

/**
 *
 * @author MAXMO
 */
public class complaint extends javax.swing.JInternalFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int r;
    int f;
    int i;
    /**
     * Creates new form complaint
     */
    public complaint() {
        initComponents();
        
            con = DBconnect.connect();
            tableload();
    }
    
    public void clear(){
            comname.setText("");
            com.setText("");
            comphone.setText("");
            comdate.setCalendar(null);
            cid.setText("");
    }

    public void tableload()
    {
        try
        {
            String log = "SELECT cid AS CID,cphone AS Phone,cname AS Name,date AS Date,complaint AS Complaint  FROM complaints";
            pst = con.prepareStatement(log);
            rs = pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comphone = new javax.swing.JTextField();
        comname = new javax.swing.JTextField();
        Expiry8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Expiry9 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cid = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        com = new javax.swing.JTextArea();
        delete = new javax.swing.JButton();
        Expiry10 = new javax.swing.JButton();
        comdate = new com.toedter.calendar.JDateChooser();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1080, 640));

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Customer Complaints");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Customer Phone");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Customer Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Date of Complaint");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Complaint");

        comphone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comphoneActionPerformed(evt);
            }
        });
        comphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comphoneKeyTyped(evt);
            }
        });

        comname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comnameActionPerformed(evt);
            }
        });
        comname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comnameKeyTyped(evt);
            }
        });

        Expiry8.setBackground(new java.awt.Color(85, 55, 118));
        Expiry8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Expiry8.setForeground(new java.awt.Color(255, 255, 255));
        Expiry8.setText("Enter Complaint");
        Expiry8.setAutoscrolls(true);
        Expiry8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Expiry8.setBorderPainted(false);
        Expiry8.setFocusable(false);
        Expiry8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Expiry8ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        Expiry9.setBackground(new java.awt.Color(85, 55, 118));
        Expiry9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Expiry9.setForeground(new java.awt.Color(255, 255, 255));
        Expiry9.setText("Update");
        Expiry9.setAutoscrolls(true);
        Expiry9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Expiry9.setBorderPainted(false);
        Expiry9.setFocusable(false);
        Expiry9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Expiry9ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("CID");

        com.setColumns(20);
        com.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        com.setRows(5);
        jScrollPane2.setViewportView(com);

        delete.setBackground(new java.awt.Color(85, 55, 118));
        delete.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.setAutoscrolls(true);
        delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete.setBorderPainted(false);
        delete.setFocusable(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        Expiry10.setBackground(new java.awt.Color(85, 55, 118));
        Expiry10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Expiry10.setForeground(new java.awt.Color(255, 255, 255));
        Expiry10.setText("Clear");
        Expiry10.setAutoscrolls(true);
        Expiry10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Expiry10.setBorderPainted(false);
        Expiry10.setFocusable(false);
        Expiry10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Expiry10ActionPerformed(evt);
            }
        });

        comdate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(46, 46, 46)
                                .addComponent(comphone, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comname, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(comdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cid, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(104, 104, 104))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Expiry9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(Expiry8, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Expiry10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(800, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comphone, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete)
                            .addComponent(Expiry9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Expiry8)
                    .addComponent(Expiry10))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comphoneActionPerformed
         try
        {
            String log = "SELECT cus_name FROM customer WHERE cus_phone="+ comphone.getText();
            pst = con.prepareStatement(log);
            rs = pst.executeQuery();
            while(rs.next())
            {
                comname.setText(rs.getString("cus_name"));
            }
            
            
        }
        catch (Exception e)
        {
        
    }
    }//GEN-LAST:event_comphoneActionPerformed

    
    private void comnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comnameActionPerformed

    private void Expiry8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Expiry8ActionPerformed
        String phone = comphone.getText();
        String name = comname.getText();
        java.sql.Date date = new java.sql.Date(comdate.getDate().getTime());
        String complain = com.getText();
        if (phone.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Phone can't be empty");
        }
        else if (name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Name can't be empty");
        }
        else if (complain.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Request can't be empty");
        }
        
        else{
        
    try 
    {
        String d = "INSERT INTO complaints (cphone,cname,date,complaint) values ('"+ phone +"', '"+ name +"','"+ date +"', '"+ complain +"')";
        pst = con.prepareStatement(d);
        pst.execute();
    }
        
    catch (Exception e)
    {
        
    }
    
    tableload();
    clear();
    JOptionPane.showMessageDialog(null, "Complaint Added Successfully");
        }
    }//GEN-LAST:event_Expiry8ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        r = jTable2.getSelectedRow ();

        comphone.setText(jTable2.getValueAt(r, 1).toString());
        comname.setText(jTable2.getValueAt ( r, 2).toString());
        String Date = jTable2.getValueAt ( r, 3).toString ();
        com.setText(jTable2.getValueAt ( r, 4).toString());
        cid.setText(jTable2.getValueAt(r, 0).toString());
        ((JTextField)comdate.getDateEditor().getUiComponent()).setText ( Date );

    }//GEN-LAST:event_jTable2MouseClicked

    private void Expiry9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Expiry9ActionPerformed
if(jTable2.getSelectedRow()<0){

    JOptionPane.showMessageDialog(null,"Select detail to update");
    }
else{       
        
        java.sql.Date date = new java.sql.Date(comdate.getDate().getTime());
        String phone  = comphone.getText();
        String name = comname.getText();
        
        try {
            int x = JOptionPane.showConfirmDialog(null, "Do you really want to update?");
                
        if( x==0){
        i = Integer.parseInt(cid.getText());
        String update = "UPDATE complaints SET cphone=? , cname=? , date=? , complaint=? WHERE cid=? ";
        pst = con.prepareStatement(update);
        pst.setString(1, phone);
        pst.setString(2, name);
         pst.setDate(3, date);
        pst.setString(4, com.getText());
        pst.setString(5, cid.getText());
        pst.executeUpdate();
        
        tableload();
        clear();
        
        JOptionPane.showMessageDialog(null,"Update successful");

        }
        else{clear();}
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
                  
       
}
    }//GEN-LAST:event_Expiry9ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
if(jTable2.getSelectedRow()<0){

    JOptionPane.showMessageDialog(null,"Select detail to delete");
    }
else{
        try {
            int x = JOptionPane.showConfirmDialog(null, "Do you really want to delete?");
                
        if( x==0){
            
            f = Integer.parseInt(cid.getText());
            String delete = "DELETE from complaints where cid='"+ f +"'";
            pst = con.prepareStatement(delete);
            pst.executeUpdate();
            
        tableload();
        clear();

        JOptionPane.showMessageDialog(null,"Delete successful");
        }
        else{clear();}
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

        
    }//GEN-LAST:event_deleteActionPerformed
    }
    private void Expiry10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Expiry10ActionPerformed
        clear();// TODO add your handling code here:
    }//GEN-LAST:event_Expiry10ActionPerformed

    private void comphoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comphoneKeyTyped
       
        report_Code rc = new report_Code();
        
        char c = evt.getKeyChar();
        String x = Character.toString(c);
        if (comphone.getText().length()>9)
        {
            comphone.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Phone cannot include more than 10 digits");
            evt.consume();
        }
        else if(!(rc.digitsOnly(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            comphone.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Phone cannot include alphabetic values.");
            evt.consume();
        
        }
        
        comphone.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        
        
    /*type1 = st.getSelectedItem().toString();
         if(!a3.StockTypeValidation(type1)){
             getToolkit().beep();
             qty.setText(" ");
             //qty.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Select Stock Type", "Error", JOptionPane.INFORMATION_MESSAGE);
             qty.setText(" ");
             evt.consume();
         }
         else{
               
         char c = evt.getKeyChar();
         String x = Character.toString(c);
         if(!(a2.isIntQty(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
             getToolkit().beep();
             qty.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Quantity invalid it's should be Digits only ");
             evt.consume();
         }
         qty.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         }*/
    }//GEN-LAST:event_comphoneKeyTyped

    private void comnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comnameKeyTyped
        report_Code rc = new report_Code();
        
        char c = evt.getKeyChar();
        String x = Character.toString(c);
        if(!(rc.lettersOnly(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            comname.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Name cannot include numeric values.");
            evt.consume();
        
        }
        
        comname.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    }//GEN-LAST:event_comnameKeyTyped

      public static void main ( String args[] ) {
       
        java.awt.EventQueue.invokeLater (new Runnable () {
            
            public void run () {
                
                new complaint ().setVisible ( true );
                
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Expiry10;
    private javax.swing.JButton Expiry8;
    private javax.swing.JButton Expiry9;
    private javax.swing.JLabel cid;
    private javax.swing.JTextArea com;
    private com.toedter.calendar.JDateChooser comdate;
    private javax.swing.JTextField comname;
    private javax.swing.JTextField comphone;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}