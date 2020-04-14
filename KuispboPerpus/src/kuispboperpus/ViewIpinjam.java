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

public class ViewIpinjam extends JFrame{
   JLabel lPinjam= new JLabel("INPUT PENGEMBALIAN BUKU");
    
   JLabel lNopinjam= new JLabel("Nomor Pinjam :");
   JTextField tfNopinjam = new JTextField();
   JLabel lNIS= new JLabel("NIS :");
   JTextField tfNIS = new JTextField();
   JLabel lNamasiswa = new JLabel("Nama Siswa :");
   JLabel lHNamasiswa = new JLabel();
   JLabel lKelas = new JLabel("Kelas :");
   JLabel lHKelas = new JLabel();
   JLabel lKodebuku= new JLabel("Kodebuku  :");
   JTextField tfKodebuku = new JTextField();
   JLabel lNamabuku = new JLabel(" Nama Buku :");
   JLabel lHNamabuku = new JLabel();
   JLabel lNamapenerbit = new JLabel(" Penerbit :");
   JLabel lHNamapenerbit = new JLabel();
  
   JLabel lTglpinjam= new JLabel("Tgl Pinjam :");
   JTextField tfTglpinjam = new JTextField();
   JLabel lTglkembali= new JLabel("Tgl Kembali :");
   JTextField tfTglkembali = new JTextField();
   JLabel lLpinjam = new JLabel(" Lama pinjam :");
   JLabel lLHpinjam = new JLabel();
   
   JLabel lDenda= new JLabel("Denda :");
   JLabel lHDenda= new JLabel();
   JLabel lNIK= new JLabel("NIK :");
   JTextField tfNIK = new JTextField();
   JLabel lKaryawan= new JLabel("Karyawan yang bertugas :");
   JLabel lHKaryawan= new JLabel();
   
   
   JButton btnCreatePanel = new JButton("Simpan");
   JButton btnSearchPanel = new JButton("Cari");
   JButton btnPrintPanel = new JButton("Print");
   JButton btnRefershPanel = new JButton("Refesh");
   JButton btnDeletePanel = new JButton("Hapus");
   JButton btnExitPanel = new JButton("Keluar");
   
   JTable tabel3;
   DefaultTableModel tableModel3;
   JScrollPane scrollPane3;
   Object namaKolom3[] = {"No pengembalian","NIS","Nama Siswa","Kelas","Kode Buku","Nama Pengarang","Penerbit","Tanggal Pinjam","Tanggal Kembali","Lama","Denda","Petugas","NIK"};
   
   public ViewIpinjam(){
       tableModel3 = new DefaultTableModel (namaKolom3,0);
       tabel3 = new JTable(tableModel3);
       scrollPane3 = new JScrollPane(tabel3);
       
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       //setVisible(true);
       setLayout(null);
       setSize(900,700);
       setLocation(225,75);
       
       add(lPinjam);
       lPinjam.setBounds(345,15,150,20);
       add(lNopinjam);
       lNopinjam.setBounds(15,50,90,20);
       add(tfNopinjam);
       tfNopinjam.setBounds(115,50,90,20);
       add(lNIS);
       lNIS.setBounds(15,80,90,20);
       add(tfNIS);
       tfNIS.setBounds(115,80,90,20);
       add(lNamasiswa);
       lNamasiswa.setBounds(15,110,90,20);
       add(lHNamasiswa);
       lHNamasiswa.setBounds(115,110,90,20);
       add(lKelas);
       lKelas.setBounds(115,140,90,20);
       add(lHKelas);
       lHKelas.setBounds(15,140,90,20);
       add(lKodebuku);
       lKodebuku.setBounds(15,170,90,20);
       add(tfKodebuku);
       tfKodebuku.setBounds(115,170,90,20);
       add(lNamabuku);
       lNamabuku.setBounds(15,200,90,20);
       add(lHNamabuku);
       lHNamabuku.setBounds(115,200,90,20);
       add(lNamapenerbit);
       lNamapenerbit.setBounds(15,230,90,20);
       add(lHNamapenerbit);
       lHNamapenerbit.setBounds(115,230,90,20);
       add(lTglpinjam);
       lTglpinjam.setBounds(15,260,90,20);
       add(tfTglpinjam);
       tfTglpinjam.setBounds(115,260,90,20);
       add(lTglkembali);
       lTglkembali.setBounds(15,290,90,20);
       add(tfTglkembali);
       tfTglkembali.setBounds(115,290,90,20);
       add(lLpinjam);
       lLpinjam.setBounds(15,320,90,20);
       add(lLHpinjam);
       lLHpinjam.setBounds(115,320,90,20);
       
       
       add(lDenda);
       lDenda.setBounds(320,230,90,20);
       add(lNIK);
       lNIK.setBounds(320,260,90,20);
       add(tfNIK);
       tfNIK.setBounds(420,260,90,20);
       add(lKaryawan);
       lKaryawan.setBounds(320,290,90,20);
       add(lHKaryawan);
       lHKaryawan.setBounds(420,290,90,20);
       
       
       add(btnCreatePanel);
       btnCreatePanel.setBounds(250,80,90,20);
       add(btnSearchPanel);
       btnSearchPanel.setBounds(250,110,90,20);
       add(btnPrintPanel);
       btnPrintPanel.setBounds(250,140,90,20);
       add(btnDeletePanel);
       btnDeletePanel.setBounds(350,110,90,20);
       add(btnExitPanel);
       btnExitPanel.setBounds(350,140,90,20);
       add(btnRefershPanel);
       btnRefershPanel.setBounds(350,80,90,20);
      
      add(scrollPane3);
       scrollPane3.setBounds(5,400,600,250);
       scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    
       btnExitPanel.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
     GUI g = new GUI();
 dispose();
         }
    }); 
tfNIS.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(ActionEvent e) {
  String NIS = tfNIS.getText();
  String Kelas , Namasiswa;
  
  if (null == NIS) {
      Namasiswa = "tidak diketahui";
      Kelas="tidak diketahui";
  } else  switch (NIS) {
        case "112":
            Namasiswa = "amal";
            Kelas="b";
           break;
        case "113":
            Namasiswa = "doni";
            Kelas="c";
           break;
        case "114":
            Namasiswa = "timmy";
            Kelas="c";
           break;
        default:
            Namasiswa = "tidak diketahui";
            Kelas="tidak diketahui";
            break;
    } 
  lHNamasiswa.setText(Namasiswa);
   lHKelas.setText(Kelas);
 }
});
    tfKodebuku.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(ActionEvent e) {
  String Kodebuku = tfKodebuku.getText();
  String Namapenerbit, Namabuku;
  
  if (null == Kodebuku) {
      Namabuku = "tidak diketahui";
      Namapenerbit="tidak diketahui";
  } else  switch (Kodebuku) {
        case "123":
            Namabuku = "Bumi";
            Namapenerbit="Gramedia";
           break;
        case "124":
            Namabuku = "Polusi";
            Namapenerbit="Bukune";
            break;
        case "125":
            Namabuku = "People";
            Namapenerbit="gramed";
           break;
        default:
            Namabuku = "tidak diketahui";
            Namapenerbit="tidak diketahui";
            break;
    } 
  lHNamabuku.setText(Namabuku);
   lHNamapenerbit.setText(Namapenerbit);
 }
});

        tfNIK.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(ActionEvent e) {
  String NIK = tfNIK.getText();
  String Karyawan;
  
  if (null == NIK) {
      Karyawan = "tidak diketahui";
  } else  switch (NIK) {
        case "221":
           Karyawan="aku";
                   break;
        case "222":
            Karyawan="siti";
            break;
        case "223":
            Karyawan="brian";
            break;
        default:
            Karyawan = "tidak diketahui";
            break;
    } 
  lHKaryawan.setText(Karyawan);
   
 }
});
    
     setVisible(true);
   }
   
    public String getNopinjam(){
       return tfNopinjam.getText();
   }
   public String getNIS(){
       return tfNIS.getText();
   }
  public String getKodebuku(){
       return tfKodebuku.getText();
   }
       
   public String getTglpinjam(){
       return tfTglpinjam.getText();
   }
   public String getTglkembali(){
       return tfTglkembali.getText();
   }
   public String getNIK(){
       return tfNIK.getText();
   }
   
     
}
