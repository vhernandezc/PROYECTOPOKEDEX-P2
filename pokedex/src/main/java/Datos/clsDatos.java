/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mycompany.pokedex.Clsconexion;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vh367
 */
public class clsDatos {
    
   
    public DefaultTableModel muestrDatosTabla()
    {
        String []  nombresColumnas = {"id","name","forme_name","forme_base_pokemon_id","generation_id"};
        String [] datosFilas = new String[5];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);// es null porque los datos se ingresan de la tabla en mysql
        
        String sql = "SELECT * FROM pokemon";//indicamos la tabla de Mysql
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
           cn = Clsconexion.getConnection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            
            while(rs.next())
            {
                datosFilas[0] = rs.getString("id");//asignamos columna a cada dato
                
               datosFilas[1] = rs.getString("name");
                
               datosFilas [2] = rs.getString("forme_name");
                 datosFilas[3] = rs.getString("forme_base_pokemon_id");
                  datosFilas[4] = rs.getString("generation_id");
                
                modelo.addRow(datosFilas);//enviamos el formato a la tabla
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();//cerramos conexiones
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
}
