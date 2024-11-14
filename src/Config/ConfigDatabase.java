/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;




/**
 *
 * @author NUR AL BAR BASKORO
 */
public class ConfigDatabase {
    /*
      rencana method(produser/funtion)
      simpan, ubah, hapus, cari data,
      duplikat data, tampil data, cetak laporan 

    */
    
    private String jdbcURL="jdbc:mysql://localhost:3306/2210010613_pbo2";;
    private String username="root";
    private String password="";
    
    private DefaultTableModel Modelnya;
    private TableColumn kolomnya;
    
    public ConfigDatabase(){}
    
    public Connection getKoneksiDB() throws SQLException {
        try {
            Driver mysqldriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(mysqldriver);
            System.out.println("Koneksi DB berhasil");
        } catch (Exception e){
            System.out.println(e.toString());
        }
        
        return DriverManager.getConnection(jdbcURL, username, password);
    }
    public boolean duplicateKey(String table, String PrimaryKey, String value) { 
        boolean hasil=false;

        try {
            Statement sts = getKoneksiDB().createStatement();
            ResultSet rs = sts.executeQuery("SELECT * FROM "+table+" WHERE "+PrimaryKey+" ='"+value+"'");

            hasil = rs.next();

            rs.close();
            sts.close(); 
            getKoneksiDB().close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
        return hasil;
    }
    
    public void SimpanDinamisAkademik (int Id_akademik, String Nama_kegiatan, String Tgl_mulai, String Tgl_lahir, int id_thnajaran) {
        try {
            if (duplicateKey("akademik", "Id_akademik", "Id_akademik")) {
                JOptionPane.showMessageDialog(null, "ID sudah Terdaftar");
            } else{ 
                String SQL ="INSERT INTO akademik (Id_akademik,Nama_kegiatan,Tgl_mulai,Tgl_lahir,id_thnajaran) VALUE (?, ?, ?, ?, ?)";
                PreparedStatement simpan = getKoneksiDB().prepareStatement (SQL);
                simpan.setInt(1, Id_akademik);
                simpan.setString (2, Nama_kegiatan);
                simpan.setString(3, Tgl_mulai);
                simpan.setString(4, Tgl_mulai);
                simpan.setInt(5, id_thnajaran);
                 System.out.println("Data Berhasil Disimpan");
                simpan.executeUpdate();
                simpan.close(); getKoneksiDB().close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void SimpanDinamisMataPelajaran (int id_mtpelajaran, String Mt_pelajaran, String Kategori_pelajaran, int id_kurikulum) {
        try {
            if (duplicateKey("mata_pelajaran", "id_mtpelajaran", "id_mtpelajaran")) {
                JOptionPane.showMessageDialog(null, "Id sudah Terdaftar");
            } else{ 
                String SQL ="INSERT INTO mata_pelajaran (id_mtpelajaran,Mt_pelajaran,Kategori_pelajaran,id_kurikulum) VALUE (?, ?, ?, ?)";
                PreparedStatement simpan = getKoneksiDB().prepareStatement (SQL);
                simpan.setInt(1, id_mtpelajaran);
                simpan.setString(2, Mt_pelajaran);
                simpan.setString(3, Kategori_pelajaran);
                simpan.setInt(4, id_kurikulum);
                 System.out.println("Data Berhasil Disimpan");
                simpan.executeUpdate();
                simpan.close(); getKoneksiDB().close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public String getFieldValueEdit(String[] Field, String[] value){
        String hasil = "";
        int deteksi = Field.length-1;
        try {
            for (int i = 0; i < Field.length; i++) {
                if (i==deteksi){
                    hasil = hasil +Field[i]+" ='"+value[i]+"'";
                }else{
                   hasil = hasil +Field[i]+" ='"+value[i]+"',";  
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return hasil;
    }
    
    public void UbahDinamis(String NamaTabel, String PrimaryKey, String IsiPrimary,String[] Field, String[] Value){
        
        try {
           String SQLUbah = "UPDATE "+NamaTabel+" SET "+getFieldValueEdit(Field, Value)+" WHERE "+PrimaryKey+"='"+IsiPrimary+"'";
           Statement perintah = getKoneksiDB().createStatement();
           System.out.println("Data Berhasil Diubah");
           perintah.executeUpdate(SQLUbah);
           perintah.close();
           getKoneksiDB().close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        
    }
    
    public void HapusDinamis(String NamaTabel, String PK, String isi){
        try {
            String SQL="DELETE FROM "+NamaTabel+" WHERE "+PK+"='"+isi+"'";
            Statement perintah = getKoneksiDB().createStatement();
            System.out.println("Data Berhasil Dihapus");
            perintah.executeUpdate(SQL);
            perintah.close();
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}