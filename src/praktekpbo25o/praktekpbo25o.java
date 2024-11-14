/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktekpbo25o;
import Config.ConfigDatabase;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author NUR AL BAR BASKORO
 */
public class praktekpbo25o {

    //Koding Menjalankan Simpan Dinamis akademik
    /*public static void main(String[] args) {
        try {
            ConfigDatabase config = new ConfigDatabase();

             //Mengisi parameter untuk pemanggilan SimpanDinamisInformasi
            int Id_akademik = 1;
            String Nama_kegiatan = "Pembelajaran Tatap Muka";
            String Tgl_mulai = "2024-11-14";
            String Tgl_lahir = "2020-12-12";
            int id_thnajaran = 2013;

            // Memanggil metode Simpan Dinamis Akademik
            config.SimpanDinamisAkademik(Id_akademik, Nama_kegiatan, Tgl_mulai, Tgl_lahir, id_thnajaran);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    
    //Koding Menjalankan Simpan Dinamis Mata Pelajaran
    /*public static void main(String[] args) {
        try {
            ConfigDatabase config = new ConfigDatabase();

             //Mengisi parameter untuk pemanggilan SimpanDinamisInformasi
            int Kode_pelajaran = 1;
            String Mt_pelajaran = "Agama Islam";
            String Kategori_pelajaran = "Pelajaran Tauhid";
            int Id_admin = 2013;

            // Memanggil metode SimpanSuratDinamis
            config.SimpanDinamisMataPelajaran(Kode_pelajaran, Mt_pelajaran, Kategori_pelajaran, Id_admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    
    //Koding Menjalankan Ubah Dinamis
    /*public static void main(String[] args) {
        try {
            ConfigDatabase config = new ConfigDatabase();
            
            // Menentukan tabel, primary key, dan isi primary key
            String NamaTabel = "mata_pelajaran";
            String PrimaryKey = "id_mtpelajaran";
            String IsiPrimary = "1";
            
            // Menentukan field dan value untuk update
            String[] Field = {"Mt_pelajaran", "Kategori_pelajaran", "id_kurikulum"};
            String[] Value = {"IPS", "Sosial", "2015"};
            
            // Memanggil metode UbahDinamis
            config.UbahDinamis(NamaTabel, PrimaryKey, IsiPrimary, Field, Value);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    
    //Koding Hapus Dinamis
    public static void main(String[] args) {
        try {
            ConfigDatabase config = new ConfigDatabase();
            
            // Menentukan tabel, primary key, dan isi primary key yang akan dihapus
            String NamaTabel = "mata_pelajaran";
            String PrimaryKey = "id_mtpelajaran";
            String IsiPrimary = "1";  // Nilai primary key yang ingin dihapus
            
            // Memanggil metode HapusDinamis
            config.HapusDinamis(NamaTabel, PrimaryKey, IsiPrimary);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}