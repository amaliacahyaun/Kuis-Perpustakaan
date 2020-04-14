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

public class ModelIpinjam {
 static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
        static final String USER = "root";
        static final String PASS = "";

        Connection koneksi;
        Statement statement;

    public  ModelIpinjam(){
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

    public void createPinjam(String nopinjam, String nis,String namasiswa, String kelas, String kodebuku, String namabuku, String npenerbit, String tglpinjam, String tglkembali, String lama, String denda, String nik, String karyawan){
    try{
        String query="INSERT INTO `pinjam`(`Nopinjam`, `NIS`, `Namasiswa`,`Kelas`,`Kodebuku`,`Namabuku`,`Npenerbit`,`Tglpinjam`,`Tglkembali`,`Lama`,`Denda`, `NIK`,`Karyawan`)VALUES('"+nopinjam+"','"+nis+"','"+namasiswa+"','"+kelas+"','"+kodebuku+"','"+namabuku+"','"+npenerbit+"','"+tglpinjam+"','"+tglkembali+"','"+lama+"','"+denda+"','"+nik+"','"+karyawan+"')";
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

    public String[][] readPinjam(){
        try{
            int jmlData = 0;
            String data[][]= new String[getBanyakData()][13];
            String query="Select * from `pinjam`";
            ResultSet resultSet =statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] =resultSet.getString("Nopinjam");
                data[jmlData][1] =resultSet.getString("NIS");
                data[jmlData][2] =resultSet.getString("Namasiswa");
                data[jmlData][3] =resultSet.getString("Kelas");
                data[jmlData][4] =resultSet.getString("Kodebuku");
                data[jmlData][5] =resultSet.getString("Namabuku");
                data[jmlData][6] =resultSet.getString("Npenerbit");
                data[jmlData][7] =resultSet.getString("Tglpinjam");
                data[jmlData][8] =resultSet.getString("Tglkembali");
                data[jmlData][9] =resultSet.getString("Lama");
                data[jmlData][10] =resultSet.getString("Denda");
                data[jmlData][11] =resultSet.getString("NIK");
                data[jmlData][12] =resultSet.getString("Karyawan");
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
            String query ="Select * from `pinjam`";
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

public void deletePinjam(String nopinjam){
    try{
        String query ="DELETE FROM `pinjam` WHERE `Nopinjam` = '"+nopinjam+"'";
        statement = koneksi.createStatement();
        statement.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    
}   
}
