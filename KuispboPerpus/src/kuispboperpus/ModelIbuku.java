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

public class ModelIbuku {
        static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
        static final String USER = "root";
        static final String PASS = "";

        Connection koneksi;
        Statement statement;

    public  ModelIbuku(){
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

    public void createBuku(String kodebuku, String namabuku,String npengarang, String nterbit, String tterbit){
    try{
        String query="INSERT INTO `buku`(`Kodebuku`, `Namabuku`, `Npengarang`,`Nterbit`,`Tterbit`)VALUES('"+kodebuku+"','"+namabuku+"','"+npengarang+"','"+nterbit+"','"+tterbit+"')";
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

    public String[][] readBuku(){
        try{
            int jmlData = 0;
            String data[][]= new String[getBanyakData()][5];
            String query="Select * from `buku`";
            ResultSet resultSet =statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] =resultSet.getString("Kodebuku");
                data[jmlData][1] =resultSet.getString("Namabuku");
                data[jmlData][2] =resultSet.getString("Npengarang");
                data[jmlData][3] =resultSet.getString("Nterbit");
                data[jmlData][4] =resultSet.getString("Tterbit");
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
            String query ="Select * from `buku`";
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

public void deleteBuku(String kodebuku){
    try{
        String query ="DELETE FROM `buku` WHERE `Kodebuku` = '"+kodebuku+"'";
        statement = koneksi.createStatement();
        statement.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    
}
 
}
