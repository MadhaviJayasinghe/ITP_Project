package Interface;

import My_Code.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import static Interface.Returns_Notification.id;
import static Interface.Returns_Notification.sname;
import static Interface.Returns_Notification.bname;
import static Interface.Returns_Notification.ndate;
import static Interface.Returns_Notification.edate;
import static Interface.Returns_Notification.qty;
import Validation.Returns;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import static rr.Ireport.MyReport;


public class Returns_Home extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
   public static String month1;
    String s1;
    String i1;
    String price;
    String a;
    String b;
    String price00;
    String c;
    
    public Returns_Home() {
        initComponents();
        
        con = DBconnect.connect();
        tableload ();
        fillcombo ();
//        fillcombo1 ();
        quantity.setEnabled(false);
    }
public boolean dateValidation(){
        if(((JTextField)date.getDateEditor().getUiComponent()).getText().isEmpty())
        {
            //JOptionPane.showMessageDialog(null, "Enter Date");
            return false;
        } else {
            return true;
        }
    }
    
    public boolean edateValidation(){
        if(((JTextField)edate1.getDateEditor().getUiComponent()).getText().isEmpty())
        {
            //JOptionPane.showMessageDialog(null, "Enter Date");
            return false;
        } else {
            return true;
        }
    }
  
    public void labelload () {
        try{
            System.out.println(sname);
            System.out.println(bname);
        String sql6 = "Select i.I_id FROM pharma_items i where i.brandName='"+bname+"'";
        pst = con.prepareStatement ( sql6);
        rs = pst.executeQuery ();
        
        
        
        while(rs.next()){
            //a = rs.getString(1);
            b = rs.getString(1);
        }
        System.out.println(b);
        String sql8 = "Select Quantity FROM sales_stock where Item_Code='"+b+"' and Expiry_Date <= DATE_ADD(DATE(now()), INTERVAL 7 MONTH) and Expiry_Date > CURDATE()";
        pst = con.prepareStatement ( sql8);
        rs = pst.executeQuery ();
         
        while(rs.next()){
            c = rs.getString(1);
            
        }
        
            System.out.println(c);
        bname1.setSelectedItem(bname);
        //sname1.setSelectedItem(sname);
        quantity.setText(c);
        ((JTextField)date.getDateEditor().getUiComponent()).setText (ndate);
        ((JTextField)edate1.getDateEditor().getUiComponent()).setText (edate);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void tableload () {
        
        try {
            
            String sql = "SELECT Return_Id,Brand_Name,Date,Supplier_Name,Qty,Expiry_Date FROM company_returns";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            returns.setModel ( DbUtils.resultSetToTableModel ( rs ));
          
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    } 
    
//    public void fillcombo1() {
//        
//        try {
//            
//            String sql = "SELECT * FROM pharma_supplier";
//            pst = con.prepareStatement ( sql );
//            rs = pst.executeQuery ();
//            
//            while ( rs.next ()) {
//                
//                String ps = rs.getString ( "S_Name" );
//                sname1.addItem ( ps );
//            }
//        }
//        
//        catch ( Exception e ) {
//            
//            System.out.println ( e );
//            
//            JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );
//            
//        }
//    }
     public void clear () {
        rid.setText("");
        bname1.setSelectedItem( "Select Brand Name" );
        sname1.setText( "" );
        quantity.setText( "" );
        date.setDate(null);
        edate1.setDate(null);
        
    }    
        
    public void fillcombo () {
        
        try {
            
            String sql = "SELECT * FROM pharma_items";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) {
                
                String pi = rs.getString ( "brandName" );
                bname1.addItem ( pi );
            }
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
            JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );
            
        }
    }    
    
    public void labelload2 (){
    String bname = bname1.getSelectedItem().toString();
    String sname = sname1.getText();
    
    try{
        String sql = "Select Return_Id from company_returns where Brand_Name = '"+ bname +"' and Supplier_Name = '"+ sname +"'";
         pst = con.prepareStatement(sql);
         rs=pst.executeQuery();   
         while(rs.next()) {
             rid.setText(rs.getString(1));
         }}
         catch ( Exception e ) {
            
            System.out.println ( e );
            
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
        Supplier = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        Expiry14 = new javax.swing.JButton();
        IHome = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        returns = new javax.swing.JTable();
        Expiry10 = new javax.swing.JButton();
        Expiry11 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Expiry12 = new javax.swing.JButton();
        bname1 = new javax.swing.JComboBox<>();
        date = new com.toedter.calendar.JDateChooser();
        edate1 = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox<>();
        Expiry13 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        rid = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        remove1 = new javax.swing.JButton();
        sname1 = new javax.swing.JTextField();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1080, 725));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(85, 55, 118));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Supplier.setBackground(new java.awt.Color(85, 55, 118));
        Supplier.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Supplier.setForeground(new java.awt.Color(255, 255, 255));
        Supplier.setText("Manage Supplier Returns");
        Supplier.setAutoscrolls(true);
        Supplier.setBorder(null);
        Supplier.setBorderPainted(false);
        Supplier.setFocusable(false);
        Supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierActionPerformed(evt);
            }
        });
        jPanel3.add(Supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 40));

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

        Expiry14.setBackground(new java.awt.Color(85, 55, 118));
        Expiry14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Expiry14.setForeground(new java.awt.Color(255, 255, 255));
        Expiry14.setText("View Notification");
        Expiry14.setAutoscrolls(true);
        Expiry14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Expiry14.setBorderPainted(false);
        Expiry14.setFocusable(false);
        Expiry14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Expiry14ActionPerformed(evt);
            }
        });
        jPanel3.add(Expiry14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Quantity");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Expiry Date");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Supplier Name");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Date");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Brand Name");

        quantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        returns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "BrandName", "SupplierName", "Quantity", "Date", "ExpiryDate"
            }
        ));
        returns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(returns);

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

        Expiry11.setBackground(new java.awt.Color(85, 55, 118));
        Expiry11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Expiry11.setForeground(new java.awt.Color(255, 255, 255));
        Expiry11.setText("Add");
        Expiry11.setAutoscrolls(true);
        Expiry11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Expiry11.setBorderPainted(false);
        Expiry11.setFocusable(false);
        Expiry11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Expiry11ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 33)); // NOI18N
        jLabel4.setText("Manage Supplier Returns");

        Expiry12.setBackground(new java.awt.Color(85, 55, 118));
        Expiry12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Expiry12.setForeground(new java.awt.Color(255, 255, 255));
        Expiry12.setText("Update");
        Expiry12.setAutoscrolls(true);
        Expiry12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Expiry12.setBorderPainted(false);
        Expiry12.setFocusable(false);
        Expiry12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Expiry12ActionPerformed(evt);
            }
        });

        bname1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Brand Name" }));
        bname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bname1ActionPerformed(evt);
            }
        });

        date.setDateFormatString("yyyy-MM-dd");

        edate1.setDateFormatString("yyyy-MM-dd");
        edate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edate1MouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Month");

        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        Expiry13.setBackground(new java.awt.Color(85, 55, 118));
        Expiry13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Expiry13.setForeground(new java.awt.Color(255, 255, 255));
        Expiry13.setText("View Return Details");
        Expiry13.setAutoscrolls(true);
        Expiry13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Expiry13.setBorderPainted(false);
        Expiry13.setFocusable(false);
        Expiry13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Expiry13ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("Return Id");

        jButton9.setBackground(new java.awt.Color(85, 55, 118));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("View Selected Notification");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        remove.setBackground(new java.awt.Color(85, 55, 118));
        remove.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("Remove");
        remove.setFocusable(false);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        remove1.setBackground(new java.awt.Color(85, 55, 118));
        remove1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        remove1.setForeground(new java.awt.Color(255, 255, 255));
        remove1.setText("View Report");
        remove1.setFocusable(false);
        remove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove1ActionPerformed(evt);
            }
        });

        sname1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sname1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(157, 157, 157)
                                .addComponent(month, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Expiry13)))
                        .addGap(638, 638, 638))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel25))
                                        .addGap(91, 91, 91)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sname1)
                                            .addComponent(bname1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(edate1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                                .addComponent(rid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(quantity))))
                                .addGap(43, 43, 43))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton9)
                                        .addGap(18, 18, 18)
                                        .addComponent(remove1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Expiry11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Expiry10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Expiry12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remove)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(bname1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(sname1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(edate1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(rid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9)
                    .addComponent(remove1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Expiry12)
                    .addComponent(Expiry10)
                    .addComponent(Expiry11)
                    .addComponent(remove))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(Expiry13)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void SupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierActionPerformed

        IHome.removeAll ();
        supplierreturns SR = new supplierreturns ();
        IHome.add ( SR ).setVisible ( true );
    }//GEN-LAST:event_SupplierActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed

        Home_Page1 HP1 = new Home_Page1 ();
        HP1.setVisible ( true );
        this.dispose ();
    }//GEN-LAST:event_LogoutActionPerformed

    private void Expiry14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Expiry14ActionPerformed
        // TODO add your handling code here:
        Returns_Notification rn = new Returns_Notification ();
        rn.setVisible ( true );
    }//GEN-LAST:event_Expiry14ActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void returnsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnsMouseClicked
        // TODO add your handling code here:
        int r = returns.getSelectedRow ();
        String rid1 = returns.getValueAt ( r, 0 ).toString ();
        String bname = returns.getValueAt ( r, 1 ).toString ();
        String sname = returns.getValueAt ( r, 3 ).toString ();
        String quantity1 = returns.getValueAt ( r, 4 ).toString ();
        String date1 = returns.getValueAt ( r, 2 ).toString ();
        String edate = returns.getValueAt ( r, 5 ).toString ();
        //SimpleDateFormat dformat = new SimpleDateFormat("MMM dd,yy");
        //String date1 = dformat.format(returns.getValueAt ( r, 2 ).toString ());
        rid.setText(rid1);
        bname1.setSelectedItem ( bname );
        sname1.setText ( sname );
        quantity.setText ( quantity1 );
        ((JTextField)date.getDateEditor().getUiComponent()).setText (date1);
        ((JTextField)edate1.getDateEditor().getUiComponent()).setText (edate);
    }//GEN-LAST:event_returnsMouseClicked

    private void Expiry10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Expiry10ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_Expiry10ActionPerformed

    private void Expiry11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Expiry11ActionPerformed
        labelload();

        Returns r = new Returns();

        try {

            String bname = bname1.getSelectedItem().toString();
            String sname = sname1.getText ();
            String quantity1 = quantity.getText ();
            SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = dformat.format(date.getDate());
            SimpleDateFormat dformat1 = new SimpleDateFormat("yyyy-MM-dd");
            String edate = dformat1.format(edate1.getDate());

            String sql = "INSERT INTO `company_returns`(`Brand_Name`, `Date`, `Supplier_Name`, `Qty`, `Expiry_Date`) VALUES ( '"+ bname +"', '"+ date1 +"', '"+ sname +"', '"+ quantity1 +"', '"+ edate +"')";
            pst = con.prepareStatement ( sql );
            pst.execute ();

            String sql2 = "Select s.S_Id,i.I_id FROM pharma_supplier s,pharma_items i where s.S_Name='"+sname+"' and i.brandName='"+bname+"'";
            pst = con.prepareStatement ( sql2 );
            rs = pst.executeQuery ();
            while(rs.next()){
                s1 = rs.getString(1);
                i1 = rs.getString(2);
            }

            String sql3 = "update sales_stock set Quantity = 0 WHERE Expiry_Date = '"+ edate +"' and Item_Code='"+ i1 +"' ";
            pst = con.prepareStatement ( sql3 );
            pst.execute ();

            String sql1 = "Delete from returns_notification where Notification_Id='"+id+"'";
            pst = con.prepareStatement ( sql1 );
            pst.execute ();

            JOptionPane.showMessageDialog ( null, "Register Succesful" );

            tableload ();
            labelload2();
            clear();

        }

        catch ( Exception e ) {

            System.out.print ( e );

            JOptionPane.showMessageDialog ( null, "Date or Expiry Date is incorrect" );

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_Expiry11ActionPerformed

    private void Expiry12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Expiry12ActionPerformed
        // TODO add your handling code here:
        quantity.setEnabled(false);

        Returns r = new Returns();
        int x = JOptionPane.showConfirmDialog ( null, "Do you really want to update?" );

        if ( x==0 ) {

            try {

                String bname = bname1.getSelectedItem().toString();
                String sname = sname1.getText ();
                String quantity1 = quantity.getText ();
                SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
                String date1 = dformat.format(date.getDate());
                SimpleDateFormat dformat1 = new SimpleDateFormat("yyyy-MM-dd");
                String edate = dformat1.format(edate1.getDate());
                labelload2();
                String rid2 = rid.getText();
                String sql = "UPDATE company_returns SET Brand_Name = '"+ bname +"', Date = '"+ date1 +"', Supplier_Name = '"+ sname +"', Qty = '"+ quantity1 +"', Expiry_Date = '"+ edate +"' WHERE Return_ID = '"+ rid2 +"' ";
                pst = con.prepareStatement ( sql );
                pst.execute ();

                JOptionPane.showMessageDialog ( null, "Update Succesful" );

                tableload ();
                clear();
            }

            catch ( Exception e ) {

                System.out.println ( e );

                JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot update." );

            }
        }
    }//GEN-LAST:event_Expiry12ActionPerformed

    private void bname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bname1ActionPerformed

    private void edate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edate1MouseClicked
        // TODO add your handling code here:
        if(!dateValidation()){
            getToolkit().beep();
            edate1.setDate(null);
            JOptionPane.showMessageDialog(null, "Enter Date");

            evt.consume();
        }
    }//GEN-LAST:event_edate1MouseClicked

    private void Expiry13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Expiry13ActionPerformed
        // TODO add your handling code here:

        month1 = month.getSelectedItem().toString();
        if(!(month1.equals("Select Month"))){
        ViewSupplierReturns1 VSR = new ViewSupplierReturns1 ();
        VSR.setVisible ( true );
        }
        else{
            JOptionPane.showMessageDialog(null, "Select Month");
        }

    }//GEN-LAST:event_Expiry13ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        labelload();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null,"Do you really want to delete?");

        if(x==0) {

            try {
                String rid1 = rid.getText();
                String Qty = quantity.getText();
                String bname = bname1.getSelectedItem().toString();
                String sname = sname1.getText ();
                SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
                String date1 = dformat.format(date.getDate());
                SimpleDateFormat dformat1 = new SimpleDateFormat("yyyy-MM-dd");
                String edate = dformat1.format(edate1.getDate());
                System.out.println(rid1);
                String sql = "Delete from company_returns where Return_ID = '"+rid1+"'";
                pst = con.prepareStatement(sql);
                pst.execute();

                String sql3 = "update sales_stock set Quantity = '"+Qty+"' WHERE Expiry_Date = '"+ edate +"' and Item_Code='"+ i1 +"' ";
                pst = con.prepareStatement ( sql3 );
                pst.execute ();

                String sql4 = "Select s.S_Id,i.I_id FROM pharma_supplier s,pharma_items i where s.S_Name='"+sname+"' and i.brandName='"+bname+"'";
                pst = con.prepareStatement ( sql4 );
                rs = pst.executeQuery ();
                while(rs.next()){
                    s1 = rs.getString(1);
                    i1 = rs.getString(2);
                }
                System.out.println(s1);
                System.out.println(i1);
                
                String y = "Select Expiry_Date from sales_stock where Item_Code='"+i1+"'";
                pst = con.prepareStatement ( y );
                rs = pst.executeQuery ();
                while(rs.next()){
                    price00 = rs.getString(1);

                }
                System.out.println("efsegddgv");
                
                String sql2 = "Select Price FROM sales_stock where Item_Code='"+i1+"' and Expiry_Date='"+price00+"'";
                pst = con.prepareStatement ( sql2 );
                rs = pst.executeQuery ();
                while(rs.next()){
                    price = rs.getString(1);

                }System.out.println(price);
                int qty=Integer.parseInt(Qty);
                double price1 = Double.parseDouble(price);
                double tot = price1*qty;
                String tot1 = Double.toString(tot);
                System.out.println("jj");
                String sql1 = "INSERT INTO `returns_notification`( `Brand_Name`, `Quantity`, `Total`, `Notification_Date`, `Expiry_Date`) VALUES('"+ bname +"', '"+ Qty +"','"+ tot1 +"','"+ date1 +"', '"+ edate +"')";
                pst = con.prepareStatement ( sql1 );
                pst.execute ();

                JOptionPane.showMessageDialog(null, "Delete Succesful");
                clear();
                tableload();
            }

            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Records. \nCannot delete.");

                System.out.println(e);
            }
            //tabled();
        }
    }//GEN-LAST:event_removeActionPerformed

    private void remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove1ActionPerformed
        // TODO add your handling code here:
         String report1="C:\\ireportsNew\\company_returns.jasper" ;
        
        try {
                       MyReport(report1,null);
        }
        catch (SQLException | JRException ex) {
        }
    }//GEN-LAST:event_remove1ActionPerformed

    private void sname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sname1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Expiry10;
    private javax.swing.JButton Expiry11;
    private javax.swing.JButton Expiry12;
    private javax.swing.JButton Expiry13;
    private javax.swing.JButton Expiry14;
    private javax.swing.JDesktopPane IHome;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Supplier;
    private javax.swing.JComboBox<String> bname1;
    private com.toedter.calendar.JDateChooser date;
    private com.toedter.calendar.JDateChooser edate1;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton remove;
    private javax.swing.JButton remove1;
    private javax.swing.JTable returns;
    private javax.swing.JLabel rid;
    private javax.swing.JTextField sname1;
    // End of variables declaration//GEN-END:variables
}
