/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuispboperpus;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelIanggota {
        static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
        static final String USER = "root";
        static final String PASS = "";

        Connection koneksi;
        Statement statement;

    public  ModelIanggota(){
    try{
        Class.forName(JDBC_DRIVER);
        koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Koneksi berhasil");
    }

    catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
        System.out.println("Koneksi gagal");
    }
}

    public void createAnggota(String nis, String namasiswa,String ttl, String jenkel, String agama, String daftar, String berlaku, String kelas){
    try{
        String query="INSERT INTO `anggota`(`NIS`, `Namasiswa`, `Ttl`,`Jenkel`,`Agama`,`Daftar`,`Berlaku`,`Kelas`)VALUES('"+nis+"','"+namasiswa+"','"+ttl+"','"+jenkel+"','"+agama+"','"+daftar+"','"+berlaku+"','"+kelas+"')";
        statement =(Statement) koneksi.createStatement();
        statement.executeUpdate(query);
        System.out.println("Berhasil ditambahkan");
        JOptionPane.showMessageDialog(null, "Data berhasil Ditambahkan");
    }    
     catch (Exception sql){
         System.out.println(sql.getMessage());
         JOptionPane.showMessageDialog(null, sql.getMessage());
    }
}

    public String[][] readAnggota(){
        try{
            int jmlData = 0;
            String data[][]= new String[getBanyakData()][8];
            String query="Select * from `anggota`";
            ResultSet resultSet =statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] =resultSet.getString("NIS");
                data[jmlData][1] =resultSet.getString("Namasiswa");
                data[jmlData][2] =resultSet.getString("Ttl");
                data[jmlData][3] =resultSet.getString("Jenkel");
                data[jmlData][4] =resultSet.getString("Agama");
                data[jmlData][5] =resultSet.getString("Daftar");
                data[jmlData][6] =resultSet.getString("Berlaku");
                data[jmlData][7] =resultSet.getString("Kelas");
                jmlData++;
            }
            return data;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL ERROR");
            return null;
        }
    }

    public int getBanyakData(){
        int jmlData=0;
        try{
            statement = koneksi.createStatement();
            String query ="Select * from `anggota`";
            ResultSet resultSet =statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL ERROR");
            return 0;
        }
    }

public void deleteAnggota(String nis){
    try{
        String query ="DELETE FROM `anggota` WHERE `NIS` = '"+nis+"'";
        statement = koneksi.createStatement();
        statement.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    
}

    
}
