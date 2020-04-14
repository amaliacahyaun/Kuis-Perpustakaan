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

public class ControllerIbuku {
   ModelIbuku modelIbuku;
   ViewIbuku viewIbuku;

   public ControllerIbuku(ModelIbuku modelIbuku, ViewIbuku viewIbuku){
        this.modelIbuku = modelIbuku;
        this.viewIbuku = viewIbuku;
        if(modelIbuku.getBanyakData() !=0){
           String dataBuku[][]= modelIbuku.readBuku();
           viewIbuku.tabel3.setModel((new JTable(dataBuku, viewIbuku.namaKolom3)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null,"Data Tidak ada");          
        }
        viewIbuku.btnCreatePanel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (viewIbuku.getKodebuku().equals("")
                        || viewIbuku.getNamabuku().equals("")
                        || viewIbuku.getNpengarang().equals("")
                        || viewIbuku.getNterbit().equals("")
                        || viewIbuku.getTterbit().equals("")
                       ){
                    JOptionPane.showMessageDialog(null, "Field tidk boleh kosong");
                       
            }else{
                    String kodebuku = viewIbuku.getKodebuku();
                    String namabuku = viewIbuku.getNamabuku();
                    String npengarang = viewIbuku.getNpengarang();
                    String nterbit = viewIbuku.getNterbit();
                    String tterbit = viewIbuku.getTterbit();
                    modelIbuku.createBuku(kodebuku, namabuku, npengarang, nterbit, tterbit);
                    
                    String dataBuku[][] = modelIbuku.readBuku();
                    viewIbuku.tabel3.setModel(new JTable (dataBuku, viewIbuku.namaKolom3).getModel());
                }
                
        }
        });  
 
               

        
        viewIbuku.btnRefershPanel.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataBuku[][] = modelIbuku.readBuku();
                    viewIbuku.tabel3.setModel(new JTable (dataBuku, viewIbuku.namaKolom3).getModel());
                
            viewIbuku.tfKodebuku.setText(null);
            viewIbuku.tfNamabuku.setText(null);
            viewIbuku.tfNpengarang.setText(null);
            viewIbuku.tfNterbit.setText(null);
            viewIbuku.tfTterbit.setText(null);
        }
    });
   
    
    viewIbuku.tabel3.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
           int baris = viewIbuku.tabel3.getSelectedRow();
           int kolom = viewIbuku.tabel3.getSelectedColumn();
        String dataterpilih = viewIbuku.tabel3.getValueAt(baris, 0).toString();
        System.out.println(dataterpilih);
       
       viewIbuku.btnDeletePanel.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){    
                    modelIbuku.deleteBuku(dataterpilih);
                    String dataBuku[][]= modelIbuku.readBuku();
                    viewIbuku.tabel3.setModel(new JTable(dataBuku, viewIbuku.namaKolom3).getModel());
                  
             }
        });    
  }
       });
          
}
}
