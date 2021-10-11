/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokedex;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vh367
 */
public class usuarioJDBC {
     private  static final String SQL_SELECT="select*from usuarios";
     
   
      public boolean select_validacion(clsusuario datos){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsusuario usuario = new clsusuario();
        boolean tiene_permiso = false;
        
        try {
            conn = Clsconexion.getConnection();//hacemos la conexion
            String condicion = SQL_SELECT + " where correo='"+datos.getCorreo()+"'"+" and contraseña='"+datos.getContraseña()+"'";
                     
            stmt = conn.prepareStatement(condicion);//y mandamos a llamar a la instrucion select
            rs = stmt.executeQuery();//cuando ejecute el query devuelve un tipo de dato rs
            while(rs.next()){
                tiene_permiso = true;
               
                
                String correo = rs.getString("correo");
                String contraseña = rs.getString("contraseña");
 
                usuario = new clsusuario();
                
                usuario.setCorreo(correo);
                usuario.setContraseña(contraseña);
               
                                
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Clsconexion.close(rs);//mandamos
            Clsconexion.close(stmt);
            Clsconexion.close(conn);
        }
        return tiene_permiso; 
    
}


}
