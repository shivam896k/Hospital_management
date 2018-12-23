package Gui;


import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DocRec extends javax.swing.JFrame {
Connection con=null;
ResultSet rs=null;
PreparedStatement pst=null;
    /**
     * Creates new form DocRec
     */
    public DocRec() {
        initComponents();
        con= Connectdb.ConnectDB();
        Get_Data();
    }
    
    /*
        create table Doctor(
        DoctorID varchar(30) not null,
        Doctorname varchar(30) not null, 
        FatherName varchar(30) not null,
        Email varchar(30) not null,
        ContactNo varchar(30) not null,
        Address varchar(30) not null,
        Qualification varchar(3) not null,
        Gen varchar(30) not null,
        BG varchar(30) not null,
        DateofJoin varchar(30) not null
        );
    */
    
private void Get_Data(){
      String sql="select DoctorID, DoctorName, FatherName, Address, ContactNo, "
              + "Email, Qualification, Gen, BG, DateofJoin "
              + "from Doctor order by DoctorName";        
      
      try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String[] columnNames = {"ID", "Name", "Father's name", "Address", "Contact no", "Email", "Qualification",
                "Gender", "Blood group", "Date of joining"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);
            jTable1.setModel(model);
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jTable1.setFillsViewportHeight(true);
            
            String id = "", name = "", father = "", address = "", contact = "", email = "",
                    quali = "", gender = "", bg = "", dateofjoin = "";

            while (rs.next()) {
                id = rs.getString("DoctorID");
                name = rs.getString("DoctorName");
                father = rs.getString("FatherName");
                address = rs.getString("Address");
                contact = rs.getString("ContactNo");
                email = rs.getString("Email");
                quali = rs.getString("Qualification");
                gender = rs.getString("Gen");
                bg = rs.getString("BG");
                dateofjoin = rs.getString("DateofJoin");
                model.addRow(new Object[]{id, name, father, address, contact, email, quali, gender, bg, dateofjoin});

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

private static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for(int column = 1; column <= columnCount; column++){
            columnNames.add(metaData.getColumnName(column));
        }
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while(rs.next()){
            Vector<Object> vector = new Vector<Object>();
            for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        
        return new DefaultTableModel(data, columnNames);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
try{
            con=Connectdb.ConnectDB();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 0).toString();
            String sql= "select * from Doctor where DoctorID = '" + table_click + "'";
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if(rs.next()){
                this.hide();
                Entry frm = new Entry();
                frm.setVisible(true);
                String add1=rs.getString("DoctorID");
                frm.txtId.setText(add1);
                String add2=rs.getString("Doctorname");
                frm.txtName.setText(add2);
                String add3=rs.getString("Fathername");
                frm.txtFname.setText(add3);
                String add5=rs.getString("Email");
                frm.txtE.setText(add5);
                String add6=rs.getString("Qualifications");
                frm.txtQ.setText(add6);
                String add9=rs.getString("BloodGroup");
                frm.cmbB.setSelectedItem(add9);
                String add11=rs.getString("Gender");
                frm.cmbG.setSelectedItem(add11);
                String add14=rs.getString("DateOfJoining");
                frm.txtD.setText(add14);
                String add15=rs.getString("Address");
                frm.txtAd.setText(add15);
                String add16=rs.getString("ContacNo");
                frm.txtC.setText(add16);
                frm.btnSave.setEnabled(false);
             
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

     // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DocRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DocRec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}