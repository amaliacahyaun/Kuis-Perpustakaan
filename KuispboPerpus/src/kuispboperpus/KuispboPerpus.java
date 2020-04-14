/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuispboperpus;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DELL
 */
public class KuispboPerpus {

    public static void main(String[] args) {
       GUI g = new GUI();
        // TODO code application logic here
    }
    
}
class GUI extends JFrame {
   JButton btnIAnggota = new JButton("INPUT ANGGOTA");
   JButton btnIBuku = new JButton("INPUT DATA BUKU");
   JButton btnIKaryawan = new JButton("INPUT KARYAWAN");
   JButton btnPinjam = new JButton("PEMINJAMAN");
public GUI() {
setTitle("Login");
	setDefaultCloseOperation(3);
	setSize(350,200);
        setLocation(500,275);
setLayout(null);
	add(btnIAnggota);
	add(btnIBuku);
        add(btnIKaryawan);
	add(btnPinjam);
        
   
btnIAnggota.setBounds(10,10,150,40);
btnIBuku.setBounds(160,10,150,40);
btnIKaryawan.setBounds(10,100,150,40);
btnPinjam.setBounds(160,100,150,40);

        
        btnIAnggota.addActionListener(new ActionListener(){
       
             @Override
             public void actionPerformed(ActionEvent e){
                 
                     MVC_IAnggota mvcp = new MVC_IAnggota();
         
            dispose();
             }
   });
        
       btnIKaryawan.addActionListener(new ActionListener(){
       
             @Override
             public void actionPerformed(ActionEvent e){
                 
                     MVC_IKaryawan mvcp = new MVC_IKaryawan();
         
            dispose();
             }
   }); 

btnIBuku.addActionListener(new ActionListener(){
       
             @Override
             public void actionPerformed(ActionEvent e){
                 
                     MVC_IBuku mvcp = new MVC_IBuku();
         
            dispose();
             }
   }); 
  

btnPinjam.addActionListener(new ActionListener(){
       
             @Override
             public void actionPerformed(ActionEvent e){
                 
                     MVC_IPinjam mvcp = new MVC_IPinjam();
         
            dispose();
             }
   }); 

        setVisible(true);
}
}
    

