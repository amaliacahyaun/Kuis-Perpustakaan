/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuispboperpus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;

public class ViewIanggota extends JFrame {
    JLabel lAnggota= new JLabel("INPUT ANGGOTA");
    
   JLabel lNIS= new JLabel("NIS :");
   JTextField tfNIS = new JTextField();
   JLabel lNamasiswa = new JLabel("Nama Siswa :");
   JTextField tfNamasiswa = new JTextField();
   JLabel lTtl= new JLabel("TTL  :");
   JTextField tfTtl = new JTextField();
   
   JLabel lJenkel = new JLabel(" Jenis Kelamin :");

   JCheckBox cbPria = new JCheckBox(" Laki-Laki ");
   JCheckBox cbWanita = new JCheckBox(" Perempuan ");

   JLabel lAgama = new JLabel(" Agama ");
   String[] namaAgama =
            {" Islam"," Kristen "," Katolik "," Hindu "," Budha "};
   JComboBox cmbAgama = new JComboBox(namaAgama);
   
   JLabel lKelas= new JLabel("Kelas :");
   JTextField tfKelas = new JTextField();
   JLabel lDaftar= new JLabel("Tgl Daftar :");
   JTextField tfDaftar = new JTextField();
   JLabel lBerlaku= new JLabel("Berlaku Hingga :");
   JTextField tfBerlaku = new JTextField();
   
   
   JButton btnCreatePanel = new JButton("Simpan");
   JButton btnDeletePanel = new JButton("Hapus");
   JButton btnExitPanel = new JButton("Keluar");
   JButton btnRefershPanel = new JButton("Refesh");
   
   JTable tabel1;
   DefaultTableModel tableModel1;
   JScrollPane scrollPane1;
   Object namaKolom1[] = {"NIS","Nama Siswa","TTL","Jenis Kelamin","Agama","TGL Daftar","Berlaku S/D","Kelas"};
   
   public ViewIanggota(){
       tableModel1 = new DefaultTableModel (namaKolom1,0);
       tabel1 = new JTable(tableModel1);
       scrollPane1 = new JScrollPane(tabel1);
       
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       //setVisible(true);
       setLayout(null);
       setSize(900,700);
       setLocation(225,75);
       
       add(lAnggota);
       lAnggota.setBounds(345,15,90,20);
       add(lNIS);
       lNIS.setBounds(15,50,90,20);
       add(tfNIS);
       tfNIS.setBounds(115,50,90,20);
       add(lNamasiswa);
       lNamasiswa.setBounds(15,80,90,20);
       add(tfNamasiswa);
       tfNamasiswa.setBounds(115,80,90,20);
       add(lTtl);
       lTtl.setBounds(15,110,90,20);
       add(tfTtl);
       tfTtl.setBounds(115,110,90,20);
       add(lJenkel);
       lJenkel.setBounds(15,130,90,20);
       add(cbWanita);
       cbWanita.setBounds(115,160,90,20);
       add(cbPria);
       cbPria.setBounds(210,160,90,20);
       
       add(lAgama);
       lAgama.setBounds(320,50,90,20);
       add(cmbAgama);
       cmbAgama.setBounds(420,50,90,20);
       add(lKelas);
       lKelas.setBounds(320,80,90,20);
       add(tfKelas);
       tfKelas.setBounds(420,80,90,20);
       add(lDaftar);
       lDaftar.setBounds(320,110,90,20);
       add(tfDaftar);
       tfDaftar.setBounds(420,110,90,20);
       add(lBerlaku);
       lBerlaku.setBounds(320,140,90,20);
       add(tfBerlaku);
       tfBerlaku.setBounds(420,140,90,20);
       
       add(btnCreatePanel);
       btnCreatePanel.setBounds(120,200,90,20);
       add(btnDeletePanel);
       btnDeletePanel.setBounds(220,200,90,20);
       add(btnExitPanel);
       btnExitPanel.setBounds(320,200,90,20);
       add(btnRefershPanel);
       btnRefershPanel.setBounds(420,200,90,20);
      
      add(scrollPane1);
       scrollPane1.setBounds(5,250,600,200);
       scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    
            btnExitPanel.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e){
           GUI g = new GUI();
       dispose();
               }
          });         

     setVisible(true);
   }
    
   
    public String getNIS(){
       return tfNIS.getText();
   }
   public String getNamasiswa(){
       return tfNamasiswa.getText();
   }
  public String getTtl(){
       return tfTtl.getText();
   }
   
   public String getAgama(){
       return (String) cmbAgama.getSelectedItem();
   }
   public String getDaftar(){
       return tfDaftar.getText();
   }
   public String getBerlaku(){
       return tfBerlaku.getText();
   }
   public String getKelas(){
       return tfKelas.getText();
   }
   
   
}
