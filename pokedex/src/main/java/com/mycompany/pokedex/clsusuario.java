/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokedex;



/**
 *
 * @author vh367
 */
public class clsusuario {
     private String correo;
   private String contraseña;
  
    public clsusuario(){
        
    }
    
    
    public clsusuario(String correo, String contraseña){
       
        this.correo=correo;
         this.contraseña=contraseña;
         
    }

    @Override
    public String toString() {
        return "usuario{" + "correo=" + getCorreo() + ", contraseña=" + getContraseña() + '}';
    }

    /**
     * @return the usuario
     */
   

    
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the favoritos
     */
   
    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    
    
}