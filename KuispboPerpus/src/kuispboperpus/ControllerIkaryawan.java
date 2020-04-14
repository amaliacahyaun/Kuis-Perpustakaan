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

public class ControllerIkaryawan {
 ModelIkaryawan modelIkaryawan;
   ViewIkaryawan viewIkaryawan;

   public ControllerIkaryawan(ModelIkaryawan modelIkaryawan, ViewIkaryawan viewIkaryawan){
        this.modelIkaryawan = modelIkaryawan;
        this.viewIkaryawan = viewIkaryawan;
        if(modelIkaryawan.getBanyakData() !=0){
           String dataKaryawan[][]= modelIkaryawan.readKaryawan();
           viewIkaryawan.tabel2.setModel((new JTable(dataKaryawan, viewIkaryawan.namaKolom2)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null,"Data Tidak ada");          
        }
        viewIkaryawan.btnCreatePanel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (viewIkaryawan.getNIK().equals("")
                        || viewIkaryawan.getNamakaryawan().equals("")
                        //|| viewIkaryawan.getJenkel().equals("")
                        || viewIkaryawan.getGol().equals("")
                        //|| viewIkaryawan.getJabatan().equals("")
                        //|| viewIkaryawan.getTunjang().equals("")
                        //|| viewIkaryawan.getJgaji().equals("")
                        ){JOptionPane.showMessageDialog(null, "Field tidk boleh kosong");
                       
            }else{
                    String nik = viewIkaryawan.getNIK();
                    String namakaryawan = viewIkaryawan.getNamakaryawan();
                   String jenkel=(null);
                    if(viewIkaryawan.cbWanita.isSelected()){
             jenkel="Perempuan";
            }
       else if(viewIkaryawan.cbPria.isSelected()){
           jenkel="Pria";
            }
                    //String jenkel = viewIkaryawan.getJenkel();
                    String gol = viewIkaryawan.getGol();
    
                   String jabatan = viewIkaryawan.lHJabatan.getText();
                    String tunjang = viewIkaryawan.lHTunjang.getText();
                    String jgaji = viewIkaryawan.lHTgaji.getText();
                    modelIkaryawan.createKaryawan(nik, namakaryawan, jenkel, gol, jabatan, tunjang, jgaji);
                    
                    String dataKaryawan[][] = modelIkaryawan.readKaryawan();
                    viewIkaryawan.tabel2.setModel(new JTable (dataKaryawan, viewIkaryawan.namaKolom2).getModel());
                }
                
        }
        });  
    
        viewIkaryawan.btnRefershPanel.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataKaryawan[][] = modelIkaryawan.readKaryawan();
                    viewIkaryawan.tabel2.setModel(new JTable (dataKaryawan, viewIkaryawan.namaKolom2).getModel());
                
            viewIkaryawan.tfNIK.setText(null);
            viewIkaryawan.tfNamakaryawan.setText(null);
            viewIkaryawan.cbWanita.setText("Perempuan");
            viewIkaryawan.cbPria.setText("Laki-laki");
            viewIkaryawan.tfGol.setText(null);
            viewIkaryawan.lHJabatan.setText(null);
            viewIkaryawan.lHTunjang.setText(null);
            viewIkaryawan.lHTgaji.setText(null);
        }
    });

    viewIkaryawan.tabel2.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
           int baris = viewIkaryawan.tabel2.getSelectedRow();
           int kolom = viewIkaryawan.tabel2.getSelectedColumn();
        String dataterpilih = viewIkaryawan.tabel2.getValueAt(baris, 0).toString();
        System.out.println(dataterpilih);
       
       viewIkaryawan.btnDeletePanel.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){    
                    modelIkaryawan.deleteKaryawan(dataterpilih);
                    String dataKaryawan[][]= modelIkaryawan.readKaryawan();
                    viewIkaryawan.tabel2.setModel(new JTable(dataKaryawan, viewIkaryawan.namaKolom2).getModel());
                  
             }
        });
    
     }
       });
    
        
   }   
}
