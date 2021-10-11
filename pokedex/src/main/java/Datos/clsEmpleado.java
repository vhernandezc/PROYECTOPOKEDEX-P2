/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author vh367
 */
public class clsEmpleado {
   private String usuario;
 
   private String favoritos;
   private String no_gustan;
    @Override
    public String toString() {
        return "clsAlumno{" + "usuario=" + getUsuario() +  ", favoritos=" + getFavoritos() + ", no_gustan=" + getNo_gustan() + '}';
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    /**
     * @return the favoritos
     */
    public String getFavoritos() {
        return favoritos;
    }

    /**
     * @param favoritos the favoritos to set
     */
    public void setFavoritos(String favoritos) {
        this.favoritos = favoritos;
    }

    /**
     * @return the no_gustan
     */
    public String getNo_gustan() {
        return no_gustan;
    }

    /**
     * @param no_gustan the no_gustan to set
     */
    public void setNo_gustan(String no_gustan) {
        this.no_gustan = no_gustan;
    }

   

    

   
}
