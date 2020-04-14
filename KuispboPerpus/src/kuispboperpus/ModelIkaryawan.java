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

public class ModelIkaryawan {
        static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
        static final String USER = "root";
        static final String PASS = "";

        Connection koneksi;
        Statement statement;
  
    public  ModelIkaryawan(){
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

    public void createKaryawan(String nik, String namakaryawan, String jenkel, String gol, String jabatan, String tunjang, String tgaji){
    try{
        String query="INSERT INTO `karyawan`(`NIK`, `Namakaryawan`,`Jenkel`,`Gol`,`Jabatan`,`Tunjang`,`Tgaji`)VALUES('"+nik+"','"+namakaryawan+"','"+jenkel+"','"+gol+"','"+jabatan+"','"+tunjang+"','"+tgaji+"')";
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

    public String[][] readKaryawan(){
        try{
            int jmlData = 0;
            String data[][]= new String[getBanyakData()][7];
            String query="Select * from `karyawan`";
            ResultSet resultSet =statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] =resultSet.getString("NIK");
                data[jmlData][1] =resultSet.getString("Namakaryawan");
                data[jmlData][2] =resultSet.getString("Jenkel");
                data[jmlData][3] =resultSet.getString("Gol");
                data[jmlData][4] =resultSet.getString("Jabatan");
                data[jmlData][5] =resultSet.getString("Tunjang");
                data[jmlData][6] =resultSet.getString("Tgaji");
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
            String query ="Select * from `karyawan`";
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

    public void deleteKaryawan(String nik){
    try{
        String query ="DELETE FROM `karyawan` WHERE `NIK` = '"+nik+"'";
        statement = koneksi.createStatement();
        statement.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    
}

    
}
