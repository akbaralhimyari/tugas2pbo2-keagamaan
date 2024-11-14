/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class mata_pelajaran extends javax.swing.JFrame {
    
    private String jdbcURL="jdbc:mysql://localhost:3306/2210010613_pbo2";;
    private String username="root";
    private String password="";
    public Connection KoneksiDB;

    /**
     * Creates new form mata_pelajaran
     */
    public mata_pelajaran() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            Driver driverku = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driverku);
            KoneksiDB = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Koneksi Database Muhammad Akbar Al Himyari");
        } catch (Exception e) {
            System.out.println(e.toString());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kode Mata Pelajaran");

        jLabel2.setText("Mata Pelajaran");

        jLabel3.setText("Kategori Pelajaran");

        jLabel4.setText("No Kurikulum");

        jButton1.setText("SIMPAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UBAH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("HAPUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(34, 34, 34)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String SimpanData = "INSERT INTO mata_pelajaran (id_mtpelajaran,Mt_pelajaran,Kategori_pelajaran,id_kurikulum) VALUES (?, ?, ?, ?)";
            Statement cekPrimaryKey = KoneksiDB.createStatement();
            ResultSet hasilcekPrimary = cekPrimaryKey.executeQuery("SELECT * FROM akademik WHERE Id_akademik='"+jTextField1.getText()+"'");
            
            if(hasilcekPrimary.next()){
                JOptionPane.showMessageDialog(null, "Kode Mata Pelajaran Sudah Terdaftar");
                hasilcekPrimary.close();
                cekPrimaryKey.close();
            } else {
                PreparedStatement perintahSimpan = KoneksiDB.prepareStatement(SimpanData);
                perintahSimpan.setInt(1, Integer.parseInt(jTextField1.getText()));
                perintahSimpan.setString(2, jTextField2.getText());
                perintahSimpan.setString(3, jTextField3.getText());
                perintahSimpan.setInt(4, Integer.parseInt(jTextField4.getText()));
                perintahSimpan.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");
                
                perintahSimpan.close();
                hasilcekPrimary.close();
                cekPrimaryKey.close();
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
        // Query untuk mengubah data berdasarkan primary key (no_alat)
        String UbahData = "UPDATE mata_pelajaran SET Mt_pelajaran = ?, Kategori_pelajaran = ?, id_kurikulum = ? WHERE Id_mtpelajaran = ?";

        PreparedStatement perintahUbah = KoneksiDB.prepareStatement(UbahData);

        // Mengisi parameter query dengan nilai dari text field
        perintahUbah.setString(1, jTextField2.getText());
        perintahUbah.setString(2, jTextField3.getText());
        perintahUbah.setInt(3, Integer.parseInt(jTextField4.getText()));
        perintahUbah.setInt(4, Integer.parseInt(jTextField1.getText()));// no_alat sebagai primary key

        // Eksekusi perintah update
        int barisTerubah = perintahUbah.executeUpdate();
        
        if (barisTerubah > 0) {
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah!");
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan atau Gagal Diubah!");
        }

        // Menutup PreparedStatement
        perintahUbah.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Terjadi Kesalahan: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
        // Query untuk menghapus data berdasarkan primary key (no_alat)
        String HapusData = "DELETE FROM mata_pelajaran WHERE id_mtpelajaran = ?";

        // Membuat PreparedStatement
        PreparedStatement perintahHapus = KoneksiDB.prepareStatement(HapusData);

        // Mengisi parameter query dengan nilai no_alat dari jTextField1
        perintahHapus.setInt(1, Integer.parseInt(jTextField1.getText()));

        // Konfirmasi sebelum menghapus data
        int pilihan = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        
        if (pilihan == JOptionPane.YES_OPTION) {
            // Eksekusi perintah delete
            int barisTerhapus = perintahHapus.executeUpdate();
            
            if (barisTerhapus > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan atau Gagal Dihapus!");
            }
        }

        // Menutup PreparedStatement
        perintahHapus.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Terjadi Kesalahan: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(mata_pelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mata_pelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mata_pelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mata_pelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mata_pelajaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
