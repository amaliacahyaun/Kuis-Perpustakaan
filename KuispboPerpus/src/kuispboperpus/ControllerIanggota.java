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

/**
 *
 * @author DELL
 */
public class ControllerIanggota {
   ModelIanggota modelIanggota;
   ViewIanggota viewIanggota;

   public ControllerIanggota(ModelIanggota modelIanggota, ViewIanggota viewIanggota){
        this.modelIanggota = modelIanggota;
        this.viewIanggota = viewIanggota;
        if(modelIanggota.getBanyakData() !=0){
           String dataAnggota[][]= modelIanggota.readAnggota();
           viewIanggota.tabel1.setModel((new JTable(dataAnggota, viewIanggota.namaKolom1)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null,"Data Tidak ada");          
        }
        viewIanggota.btnCreatePanel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (viewIanggota.getNIS().equals("")
                        || viewIanggota.getNamasiswa().equals("")
                        || viewIanggota.getTtl().equals("")
                        //|| viewIanggota.getJenkel().equals("")
                        || viewIanggota.getAgama().equals("")
                        || viewIanggota.getDaftar().equals("")
                        || viewIanggota.getBerlaku().equals("")
                        || viewIanggota.getKelas().equals("")){
                    JOptionPane.showMessageDialog(null, "Field tidk boleh kosong");
                       
            }else{
                    String nis = viewIanggota.getNIS();
                    String namasiswa = viewIanggota.getNamasiswa();
                    String ttl = viewIanggota.getTtl();
                    String jenkel=(null);
                    if(viewIanggota.cbWanita.isSelected()){
                             jenkel="Perempuan";
                    }
                    else if(viewIanggota.cbPria.isSelected()){
                     jenkel="Laki-laki";
                    }
                    //String jenkel = viewIanggota.getJenkel();
                    String agama = viewIanggota.getAgama();
                    String daftar = viewIanggota.getDaftar();
                    String berlaku = viewIanggota.getBerlaku();
                    String kelas = viewIanggota.getKelas();
                    modelIanggota.createAnggota(nis, namasiswa, ttl, jenkel, agama,daftar, berlaku, kelas);
                    
                    String dataAnggota[][] = modelIanggota.readAnggota();
                    viewIanggota.tabel1.setModel(new JTable (dataAnggota, viewIanggota.namaKolom1).getModel());
                }
                
        }
        });  
    
        viewIanggota.btnRefershPanel.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataAnggota[][] = modelIanggota.readAnggota();
                    viewIanggota.tabel1.setModel(new JTable (dataAnggota, viewIanggota.namaKolom1).getModel());
                
            viewIanggota.tfNIS.setText(null);
            viewIanggota.tfNamasiswa.setText(null);
            viewIanggota.tfTtl.setText(null);
            viewIanggota.cbWanita.setText("Perempuan");
            viewIanggota.cbPria.setText("Laki-laki");
            viewIanggota.cmbAgama.setSelectedItem(null);
            viewIanggota.tfDaftar.setText(null);
            viewIanggota.tfBerlaku.setText(null);
            viewIanggota.tfKelas.setText(null);
        }
    });

       
        
    viewIanggota.tabel1.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
           int baris = viewIanggota.tabel1.getSelectedRow();
           int kolom = viewIanggota.tabel1.getSelectedColumn();
        String dataterpilih = viewIanggota.tabel1.getValueAt(baris, 0).toString();
        System.out.println(dataterpilih);
       
       viewIanggota.btnDeletePanel.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){    
                    modelIanggota.deleteAnggota(dataterpilih);
                    String dataAnggota[][]= modelIanggota.readAnggota();
                    viewIanggota.tabel1.setModel(new JTable(dataAnggota, viewIanggota.namaKolom1).getModel());
                  
             }
        });
    
     }
       });
    
        
   }
   
}