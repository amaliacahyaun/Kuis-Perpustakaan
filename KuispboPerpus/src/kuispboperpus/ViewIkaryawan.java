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

public class ViewIkaryawan extends JFrame{
    JLabel lKaryawan= new JLabel("INPUT KARYAWAN");
    
   JLabel lNIK= new JLabel("NIK :");
   JTextField tfNIK = new JTextField();
   JLabel lNamakaryawan = new JLabel("Nama Karyawan :");
   JTextField tfNamakaryawan = new JTextField();
   
   JLabel lJenkel = new JLabel("Jenis Kelamin :");
   JCheckBox cbPria = new JCheckBox(" Laki-Laki ");
   JCheckBox cbWanita = new JCheckBox(" Perempuan ");

   JLabel lGol= new JLabel("Golongan :");
   JTextField tfGol = new JTextField();
   
   JLabel lJabatan= new JLabel("Jabatan :");
   JLabel lTunjang= new JLabel("Tunjangan :");
   JLabel lJgaji= new JLabel("Jumlah gaji :");
   JLabel lHJabatan= new JLabel();
   JLabel lHTunjang= new JLabel();
   JLabel lHTgaji= new JLabel();
   
   JButton btnCreatePanel = new JButton("Simpan");
   JButton btnSearchPanel = new JButton("Cari");
   JButton btnDeletePanel = new JButton("Hapus");
   JButton btnExitPanel = new JButton("Keluar");
   JButton btnRefershPanel = new JButton("Refesh");
   
   JTable tabel2;
   DefaultTableModel tableModel2;
   JScrollPane scrollPane2;
   Object namaKolom2[] = {"NIK","Nama Karyawan","Jenis Kelamin","Golongan","Jabatan","Tunjangan","Total Gaji"};
   
   public ViewIkaryawan(){
       tableModel2 = new DefaultTableModel (namaKolom2,0);
       tabel2 = new JTable(tableModel2);
       scrollPane2 = new JScrollPane(tabel2);
       
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       //setVisible(true);
       setLayout(null);
       setSize(900,700);
       setLocation(225,75);
       
       add(lKaryawan);
       lKaryawan.setBounds(345,15,150,20);
       add(lNIK);
       lNIK.setBounds(15,50,90,20);
       add(tfNIK);
       tfNIK.setBounds(115,50,90,20);
       add(lNamakaryawan);
       lNamakaryawan.setBounds(15,80,100,20);
       add(tfNamakaryawan);
       tfNamakaryawan.setBounds(115,80,90,20);
       
       add(lJenkel);
       lJenkel.setBounds(15,110,90,20);
       add(cbWanita);
       cbWanita.setBounds(15,130,100,20);
       add(cbPria);
       cbPria.setBounds(120,130,90,20);
       
       add(lGol);
       lGol.setBounds(15,160,90,20);
       add(tfGol);
       tfGol.setBounds(115,160,90,20);
       add(lJabatan);
       lJabatan.setBounds(15,190,90,20);
       add(lTunjang);
       lTunjang.setBounds(15,220,90,20);
       add(lJgaji);
       lJgaji.setBounds(15,250,90,20);
       add(lHJabatan);
       lHJabatan.setBounds(115,190,90,20);
       add(lHTunjang);
       lHTunjang.setBounds(115,220,90,20);
       add(lHTgaji);
       lHTgaji.setBounds(115,250,90,20);
       
       
       add(btnCreatePanel);
       btnCreatePanel.setBounds(320,50,90,20);
       add(btnRefershPanel);
       btnRefershPanel.setBounds(420,50,90,20);
       add(btnSearchPanel);
       btnSearchPanel.setBounds(320,90,90,20);
       add(btnDeletePanel);
       btnDeletePanel.setBounds(420,90,90,20);
       add(btnExitPanel);
       btnExitPanel.setBounds(360,130,90,20);
       
      add(scrollPane2);
       scrollPane2.setBounds(5,300,600,250);
       scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    
      btnExitPanel.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e){
           GUI g = new GUI();
       dispose();
               }
          }); 
      
      tfGol.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int Upah=0;
        String Golongan = tfGol.getText();
        int Tunjangan=0;
        String Jabatan; 
        if (null == Golongan) {
            Jabatan = "tidak diketahui";
        } else  switch (Golongan) {
              case "1":
                  Jabatan = "supervisor";
                  Tunjangan = 100000;
                  Upah = 2000000;
                  break;
              case "2":
                  Jabatan = "staff";
                  Tunjangan = 50000;
                  Upah = 1800000;
                  break;
              case "3":
                  Jabatan = "magang";
                  Tunjangan = 0;
                  Upah = 500000;
                  break;
              default:
                  Jabatan = "tidak diketahui";
                  break;
          }
        int Gaji = Upah+Tunjangan;
        
        lHJabatan.setText(Jabatan);
        lHTunjang.setText(Integer.toString(Tunjangan));
        lHTgaji.setText(Integer.toString(Gaji));
      }
    });
      
     setVisible(true);
   }
   
    public String getNIK(){
       return tfNIK.getText();
   }
   public String getNamakaryawan(){
       return tfNamakaryawan.getText();
   }
   public String getGol(){
       return tfGol.getText();
   
}
    
}
 