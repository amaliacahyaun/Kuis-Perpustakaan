/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuispboperpus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

public class ViewIbuku extends JFrame{
  JLabel lBuku= new JLabel("INPUT BUKU");
    
   JLabel lKodebuku= new JLabel("Kode Buku :");
   JTextField tfKodebuku = new JTextField();
   JLabel lNamabuku = new JLabel("Nama Buku :");
   JTextField tfNamabuku = new JTextField();
   JLabel lNpengarang = new JLabel("Nama Pengarang :");
   JTextField tfNpengarang = new JTextField();
   JLabel lNterbit = new JLabel("Nama Penerbit :");
   JTextField tfNterbit = new JTextField();
   JLabel lTterbit = new JLabel("Tahun Terbit :");
   JTextField tfTterbit = new JTextField();
   
   JButton btnCreatePanel = new JButton("Simpan");
   JButton btnDeletePanel = new JButton("Hapus");
   JButton btnSearchPanel = new JButton("Cari");
   JButton btnExitPanel = new JButton("Keluar");
   JButton btnRefershPanel = new JButton("Refesh");
   
   JTable tabel3;
   DefaultTableModel tableModel3;
   JScrollPane scrollPane3;
   Object namaKolom3[] = {"Kode Buku","Nama Buku","Nama Pengarang","Nama Penerbit","Tahun Terbit"};
   
   public ViewIbuku(){
       tableModel3 = new DefaultTableModel (namaKolom3,0);
       tabel3 = new JTable(tableModel3);
       scrollPane3 = new JScrollPane(tabel3);
       
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       //setVisible(true);
       setLayout(null);
       setSize(900,700);
       setLocation(225,75);
       
       add(lBuku);
       lBuku.setBounds(345,15,90,20);
       add(lKodebuku);
       lKodebuku.setBounds(15,50,90,20);
       add(tfKodebuku);
       tfKodebuku.setBounds(115,50,90,20);
       add(lNamabuku);
       lNamabuku.setBounds(15,80,90,20);
       add(tfNamabuku);
       tfNamabuku.setBounds(115,80,90,20);
       add(lNpengarang);
       lNpengarang.setBounds(15,110,100,20);
       add(tfNpengarang);
       tfNpengarang.setBounds(115,110,90,20);
       add(lNterbit);
       lNterbit.setBounds(15,140,90,20);
       add(tfNterbit);
       tfNterbit.setBounds(115,140,90,20);
       add(lTterbit);
       lTterbit.setBounds(15,170,90,20);
       add(tfTterbit);
       tfTterbit.setBounds(115,170,90,20);
       
       add(btnCreatePanel);
       btnCreatePanel.setBounds(345,90,90,20);
       add(btnDeletePanel);
       btnDeletePanel.setBounds(445,90,90,20);
       add(btnSearchPanel);
       btnSearchPanel.setBounds(245,130,90,20);
       add(btnExitPanel);
       btnExitPanel.setBounds(345,130,90,20);
       add(btnRefershPanel);
       btnRefershPanel.setBounds(445,130,90,20);
      
      add(scrollPane3);
       scrollPane3.setBounds(5,250,600,200);
       scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    
                btnExitPanel.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e){
           GUI g = new GUI();
       dispose();
               }
          });         

     setVisible(true);
   }
   
    public String getKodebuku(){
       return tfKodebuku.getText();
   }
   public String getNamabuku(){
       return tfNamabuku.getText();
   }
  public String getNpengarang(){
       return tfNpengarang.getText();
   }
   public String getNterbit(){
       return tfNterbit.getText();
   }
   public String getTterbit(){
       return tfTterbit.getText();
   }
   
      
}
