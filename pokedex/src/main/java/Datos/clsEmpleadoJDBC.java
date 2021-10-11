/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


import com.mycompany.pokedex.Clsconexion;
import com.mycompany.pokedex.clsusuario;
import com.mycompany.pokedex.usuarioJDBC;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vh367
 */
public class clsEmpleadoJDBC {
     
    Scanner t = new Scanner(System.in);//lee los datos que ingresamos
    Scanner j = new Scanner(System.in);
    Scanner j2 = new Scanner(System.in);
    String r;
    public static PreparedStatement sentencia_preparada;
    
    private static ResultSet resultado;
    private static final String SQL_SELECT="select*from tb_favoritos";
    private static final String SQL_INSERT="insert into tb_favoritos(usuario, Favoritos,no_gustan) values(?,?,?)";
    private static final String SQL_UPDATE="update tb_favoritos set empleado=?,Enero=?,Febrero=?,Marzo=? where codigo=?";
    private static final String SQL_DELETE="DELETE FROM tb_favoritos WHERE codigo =?";
        
   public int guardar_usuario(String nombre, String correo, String contraseña){
       int  resultado=0;
       Connection conexion =null;
       
       String Sentencia_guardar=("insert into usuarios(nombre, correo,contraseña) values(?,?,?)");
        
        try {
             conexion = Clsconexion.getConnection();
            sentencia_preparada=conexion.prepareStatement(Sentencia_guardar);
            sentencia_preparada.setString(1, nombre);
            sentencia_preparada.setString(2,correo);
            sentencia_preparada.setString(3, contraseña);
            
            resultado=sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
           
            
            
            System.out.println("empleado agregado...");
          
            System.out.println("Registros afectados:" + resultado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        
        }
        
      
  
        
        return resultado;
       
       
   }
    
    
    //METODO PARA INSERTAR DATOS A LA TABLA
   public int insert(clsEmpleado alumno){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Clsconexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumno.getUsuario());
           
            stmt.setString(2, alumno.getFavoritos());
            stmt.setString(3, alumno.getNo_gustan());
         
            
            System.out.println("empleado agregado...");
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Clsconexion.close(stmt);
            Clsconexion.close(conn);
        }
        
      
  
        
        return rows;}
  
  
  
  
 
 
       public  String verificar(String correo){
      String busqueda=null;
      Connection conexion=null;
      try{
          conexion=Clsconexion.getConnection();
          String sentencia_buscar=("select nombre from usuarios where correo='"+correo+"'");
          sentencia_preparada=conexion.prepareStatement(sentencia_buscar);
          resultado=sentencia_preparada.executeQuery();
          if (resultado.next()){
              String nombre=resultado.getString("nombre");
              busqueda=(nombre);
          }
          conexion.close();
      } catch (SQLException ex) {
            Logger.getLogger(clsEmpleadoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }return busqueda;
  }
  
           public  String busca_registro(String correo, String contraseña){
      String busqueda_usuario=null;
      Connection conexion =null;
      try{
          conexion=Clsconexion.getConnection();
          String sentencia_busca=("select nombre, correo, contraseña from usuarios where correo='"+correo+"'&& contraseña='"+contraseña+"'");
          sentencia_preparada=conexion.prepareStatement(sentencia_busca);
          resultado=sentencia_preparada.executeQuery();
          if (resultado.next()){
              busqueda_usuario="encontrado";
          }else{
              busqueda_usuario="usuario no encontrado";
          }conexion.close();
          
      }catch (Exception e){
          System.out.println(e);
  }return busqueda_usuario;
  
  
  //metodo para eliminar datos
  
  
  //menu principal
 
  }
}