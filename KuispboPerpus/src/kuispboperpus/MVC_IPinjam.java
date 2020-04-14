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
public class MVC_IPinjam {
 ViewIpinjam viewIpinjam = new ViewIpinjam();
  ModelIpinjam modelIpinjam = new ModelIpinjam();
  ControllerIpinjam controllerIpinjam = new ControllerIpinjam(modelIpinjam, viewIpinjam);   
   
}
