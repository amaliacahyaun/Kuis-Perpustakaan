/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuispboperpus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerIpinjam {
 ModelIpinjam modelIpinjam;
   ViewIpinjam viewIpinjam;

   public ControllerIpinjam(ModelIpinjam modelIpinjam, ViewIpinjam viewIpinjam){
        this.modelIpinjam = modelIpinjam;
        this.viewIpinjam = viewIpinjam;
        if(modelIpinjam.getBanyakData() !=0){
           String dataPinjam[][]= modelIpinjam.readPinjam();
           viewIpinjam.tabel3.setModel((new JTable(dataPinjam, viewIpinjam.namaKolom3)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null,"Data Tidak ada");          
        }
        viewIpinjam.btnCreatePanel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (viewIpinjam.getNopinjam().equals("")
                        || viewIpinjam.getNIS().equals("")
                        || viewIpinjam.getKodebuku().equals("")
                        || viewIpinjam.getTglpinjam().equals("")
                        || viewIpinjam.getTglkembali().equals("")
                        || viewIpinjam.getNIK().equals("")
                        //|| viewIpinjam.getJgaji().equals("")
                        ){JOptionPane.showMessageDialog(null, "Field tidk boleh kosong");
                       
            }else{                      
                    String nis = viewIpinjam.getNIS();
                    String nik = viewIpinjam.getNIK();
                    String nopinjam = viewIpinjam.getNopinjam();
                    String kodebuku = viewIpinjam.getKodebuku();
                    String tglpinjam = viewIpinjam.getTglpinjam();
                    String tglkembali = viewIpinjam.getTglkembali();
                    String namasiswa = viewIpinjam.lHNamasiswa.getText();
                    String kelas = viewIpinjam.lHKelas.getText();
                    String namabuku = viewIpinjam.lHNamabuku.getText();
                    String penerbit = viewIpinjam.lHNamapenerbit.getText();
                    String lama = viewIpinjam.lLpinjam.getText();
                    String denda = viewIpinjam.lHDenda.getText();
                    String karyawan = viewIpinjam.lHKaryawan.getText();
                    

                    modelIpinjam.createPinjam(nopinjam,nis, namasiswa, kelas, kodebuku, namabuku, penerbit, tglpinjam, tglkembali,lama, denda, nik,karyawan);
                    
                    String dataPinjam[][] = modelIpinjam.readPinjam();
                    viewIpinjam.tabel3.setModel(new JTable (dataPinjam, viewIpinjam.namaKolom3).getModel());
                }
                
        }
        });  
   
    viewIpinjam.btnRefershPanel.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataPinjam[][] = modelIpinjam.readPinjam();
                    viewIpinjam.tabel3.setModel(new JTable (dataPinjam, viewIpinjam.namaKolom3).getModel());
            
            viewIpinjam.tfNopinjam.setText(null);    
            viewIpinjam.tfNIS.setText(null);
            viewIpinjam.lHNamasiswa.setText(null);
            viewIpinjam.lHKelas.setText(null);
            viewIpinjam.tfKodebuku.setText(null);
            viewIpinjam.lHNamabuku.setText(null);
            viewIpinjam.lHNamapenerbit.setText(null);
            viewIpinjam.tfTglpinjam.setText(null);
            viewIpinjam.tfTglkembali.setText(null);
            viewIpinjam.lLpinjam.setText(null);
            viewIpinjam.lHDenda.setText(null);
            viewIpinjam.tfNIK.setText(null);
            viewIpinjam.lHKaryawan.setText(null);
 }
    });
    viewIpinjam.tabel3.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
           int baris = viewIpinjam.tabel3.getSelectedRow();
           int kolom = viewIpinjam.tabel3.getSelectedColumn();
        String dataterpilih = viewIpinjam.tabel3.getValueAt(baris, 0).toString();
        System.out.println(dataterpilih);
       
       viewIpinjam.btnDeletePanel.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){    
                    modelIpinjam.deletePinjam(dataterpilih);
                    String dataPinjam[][]= modelIpinjam.readPinjam();
                    viewIpinjam.tabel3.setModel(new JTable(dataPinjam, viewIpinjam.namaKolom3).getModel());
                  
             }
        });
    
        }
    });
        
   }   
}