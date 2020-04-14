/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuispboperpus;

/**
 *
 * @author DELL
 */
public class MVC_IAnggota {
  ViewIanggota viewIanggota = new ViewIanggota();
  ModelIanggota modelIanggota = new ModelIanggota();
  ControllerIanggota controllerIanggota = new ControllerIanggota(modelIanggota, viewIanggota);   
}
