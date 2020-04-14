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
public class MVC_IKaryawan {
 ViewIkaryawan viewIkaryawan = new ViewIkaryawan();
  ModelIkaryawan modelIkaryawan = new ModelIkaryawan();
  ControllerIkaryawan controllerIkaryawan = new ControllerIkaryawan(modelIkaryawan, viewIkaryawan);      
}
