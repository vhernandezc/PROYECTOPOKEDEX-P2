/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import Datos.clsDatos;
import Datos.clsEmpleado;
import Datos.clsEmpleadoJDBC;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.pokedex.clsusuario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author vh367
 */
public class ventana_pokedex extends javax.swing.JFrame {
   
      DefaultTableModel dtm=new DefaultTableModel();
    
    
    
     BufferedImage  buffer1 = null;
    Image imagen1 = null;
    int contador = 0;
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    
    @Override
    public void paint (Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) imagenPoke.getGraphics();
        
        g2.drawImage(buffer1, 0, 0,imagenPoke.getWidth(),imagenPoke.getHeight(),null);
        
    /**
     * Creates new form ventana_pokedex
     */
    }
    public ventana_pokedex() {
        
    // Objeto modelo de tabla para crear y agregar datos a las tablas
        
     initComponents();
    
   
     lblcolor.setVisible(false);
              lblspecies.setVisible(false);
              lblcapture_rate.setVisible(false);
              lblbase_experience.setVisible(false);
        //para centrar la ventana
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana_pokedex");
        
        try {
           // imagen1 = ImageI0.read(getClass().getResource(""));
           imagen1 = ImageIO.read(new File("C:\\Users\\vh367\\OneDrive\\Desktop\\datos\\imagenes\\black-white.png"));
        } catch (IOException ex) {
           ex.printStackTrace(System.out);
        }
        
        buffer1 = (BufferedImage) imagenPoke.createImage(imagenPoke.getWidth(),imagenPoke.getHeight());
        
        Graphics2D g2 = buffer1.createGraphics();
        dibujaElPokemonQueEstaEnLaPosicion(30);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String JDBC_URL="jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
            
            conexion = DriverManager.getConnection(JDBC_URL,"root","Dacruz4032");
            estado = (Statement) conexion.createStatement();
            
     
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace(System.out);
           System.out.println("Hay error de Base de Datos");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Hay error de Base de Datos");
        }
        
     
        
    }
     private void dibujaElPokemonQueEstaEnLaPosicion(int posicion){
        int fila = posicion/31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.pink);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPoke .getWidth(),
                imagenPoke.getHeight());
        g2.drawImage(imagen1,
                0, //posicion X inicial dentro del jpanel
                0, // posicion Y inicial dentro del jpanel
                imagenPoke.getWidth(), //ancho del jpanel
                imagenPoke.getHeight(), //alto del jpanel
                columna*96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila*96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna*96 + 96, //posicion final X
                fila*96 + 96, //posicion final Y
                null //si no lo pones no va
                );
        repaint();
    
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombrepoke = new javax.swing.JLabel();
        lblprueba = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imagenPoke = new javax.swing.JPanel();
        lblspecies = new javax.swing.JLabel();
        query = new javax.swing.JLabel();
        lblcolor = new javax.swing.JLabel();
        lblbase_experience = new javax.swing.JLabel();
        lblcapture_rate = new javax.swing.JLabel();
        nombrePoke = new javax.swing.JLabel();
        izquierda = new javax.swing.JButton();
        derecha = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jcomboPokemones = new javax.swing.JComboBox<>();
        jcombocolor = new javax.swing.JComboBox<>();
        jcomboHabitats = new javax.swing.JComboBox<>();
        btncolor = new javax.swing.JButton();
        btnbuscarNombre = new javax.swing.JButton();
        prueba = new javax.swing.JButton();
        jcomboNombres = new javax.swing.JComboBox<>();
        btncambiar = new javax.swing.JButton();
        lblusuario = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnfavoritos = new javax.swing.JButton();
        btnNogusta = new javax.swing.JButton();
        btnreporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 1000));

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        imagenPoke.setBackground(new java.awt.Color(0, 0, 0));
        imagenPoke.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 255, 204)));

        javax.swing.GroupLayout imagenPokeLayout = new javax.swing.GroupLayout(imagenPoke);
        imagenPoke.setLayout(imagenPokeLayout);
        imagenPokeLayout.setHorizontalGroup(
            imagenPokeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );
        imagenPokeLayout.setVerticalGroup(
            imagenPokeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        lblspecies.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "species", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(0, 153, 204))); // NOI18N

        query.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "habitat", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(0, 153, 204))); // NOI18N

        lblcolor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "color", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(0, 153, 204))); // NOI18N

        lblbase_experience.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "base_experience", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(0, 153, 204))); // NOI18N

        lblcapture_rate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Capture_rate", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(0, 153, 204))); // NOI18N

        nombrePoke.setBackground(new java.awt.Color(51, 0, 102));
        nombrePoke.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nombrePoke.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombrePoke.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "nombre", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(0, 153, 204))); // NOI18N

        izquierda.setText("<= izquierda");
        izquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izquierdaActionPerformed(evt);
            }
        });

        derecha.setText("derecha ==>");
        derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagenPoke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcapture_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombrePoke, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblspecies, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblbase_experience, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(izquierda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(derecha)
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblspecies, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblbase_experience, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nombrePoke, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(imagenPoke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcapture_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(izquierda)
                    .addComponent(derecha))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jcomboPokemones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcomboPokemones.setMaximumRowCount(800);
        jcomboPokemones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pokemones" }));
        jcomboPokemones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboPokemonesActionPerformed(evt);
            }
        });

        jcombocolor.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcombocolor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colores" }));
        jcombocolor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombocolorActionPerformed(evt);
            }
        });

        jcomboHabitats.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcomboHabitats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habitats" }));
        jcomboHabitats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboHabitatsActionPerformed(evt);
            }
        });

        btncolor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btncolor.setText("por color ==>>");
        btncolor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncolorActionPerformed(evt);
            }
        });

        btnbuscarNombre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnbuscarNombre.setText("por nombre ==>");
        btnbuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarNombreActionPerformed(evt);
            }
        });

        prueba.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        prueba.setText("ver habitats  ==>>");
        prueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebaActionPerformed(evt);
            }
        });

        jcomboNombres.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jcomboNombres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombres" }));
        jcomboNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboNombresActionPerformed(evt);
            }
        });

        btncambiar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btncambiar.setForeground(new java.awt.Color(255, 51, 51));
        btncambiar.setText("Cambiar de usuario");

        lblusuario.setBackground(new java.awt.Color(255, 51, 51));
        lblusuario.setForeground(new java.awt.Color(153, 255, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btncambiar)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(prueba)
                .addGap(18, 18, 18)
                .addComponent(jcomboHabitats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jcomboPokemones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnbuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcomboNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btncolor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcombocolor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prueba)
                            .addComponent(jcomboPokemones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcomboHabitats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btncolor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcombocolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcomboNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(btncambiar)
                .addGap(29, 29, 29))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        btnfavoritos.setText("agregar a favoritos");
        btnfavoritos.setActionCommand("");
        btnfavoritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfavoritosActionPerformed(evt);
            }
        });

        btnNogusta.setText("Agregar a No me gusta");
        btnNogusta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNogustaActionPerformed(evt);
            }
        });

        btnreporte.setText("generar reporte");
        btnreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnfavoritos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNogusta))
                    .addComponent(btnreporte))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnfavoritos)
                    .addComponent(btnNogusta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnreporte)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblprueba)
                            .addComponent(nombrepoke)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(461, 461, 461)
                                .addComponent(nombrepoke))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251)
                        .addComponent(lblprueba)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izquierdaActionPerformed
        
      
             
             contador --;
             if(contador<=0){
             contador = 1;
             }
             dibujaElPokemonQueEstaEnLaPosicion(contador-1);
             try {
             int id = contador;
             String qr = "select * from pokemon where id="+id;
             
             resultadoConsulta = estado.executeQuery(qr);
             
             if(resultadoConsulta.next()){
             nombrePoke.setText(resultadoConsulta.getString(2));
             query.setText(resultadoConsulta.getString("habitat"));
             }else{
             nombrePoke.setText("El pokemon no esta o no existe en el pokedex");
             
             }
             } catch (SQLException ex) {
             Logger.getLogger(ventana_pokedex.class.getName()).log(Level.SEVERE, null, ex);
             }
           // TODO add your handling code here:
        
    }//GEN-LAST:event_izquierdaActionPerformed

    private void derechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derechaActionPerformed
        
        
       dibujaElPokemonQueEstaEnLaPosicion(contador);
       
        String cuerito = "Select * from pokemon where id="+(contador+1);
        
        
        try {
            resultadoConsulta = estado.executeQuery(cuerito);
            if (resultadoConsulta.next()){
                nombrePoke.setText(resultadoConsulta.getString(2));
                 query.setText(resultadoConsulta.getString("habitat"));
            } else {
                nombrePoke.setText("no existe");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");
        }
        
        contador++;
        if (contador >=649){
            contador = 649;
        }
      
              // TODO add your handling code here:
    }//GEN-LAST:event_derechaActionPerformed
      
    private void pruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebaActionPerformed
         // String cuerito2 = "SELECT distinct(habitat) as habitat FROM pokemon order by 1";
        String cuerito2 = "SELECT distinct(habitat) as habitat FROM pokemon order by 1";
        try {
            resultadoConsulta = estado.executeQuery(cuerito2);
            
          while (resultadoConsulta.next()){
                jcomboHabitats.remove(this);
                jcomboHabitats.addItem(resultadoConsulta.getString("habitat"));
            }
           
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");        // TODO add your handling code here:
    }//GEN-LAST:event_pruebaActionPerformed
    }        
    private void jcomboHabitatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboHabitatsActionPerformed
         String habit=(String)jcomboHabitats.getSelectedItem();    
       
             jcomboPokemones.removeAllItems();
              String cuerito1 ="SELECT  name from pokemon where habitat='"+habit+"'" ;
             
                         
        try {
            resultadoConsulta = estado.executeQuery(cuerito1);
            
            
          while (resultadoConsulta.next()){
                 jcomboPokemones.remove(this);
                jcomboPokemones.addItem(resultadoConsulta.getString("name"));
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");        // TODO add your handling code here:
                }    
        
        
         
        
         
           
                       // TODO add your handling code here:
    }//GEN-LAST:event_jcomboHabitatsActionPerformed

    private void btncolorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncolorActionPerformed
       String cuerito3 = "SELECT DISTINCT (color) as color FROM pokemon order by 1";//ordena alfabeticamente los colores
        try {
            resultadoConsulta = estado.executeQuery(cuerito3);
            
          while (resultadoConsulta.next()){
                 jcombocolor.remove(this);
                jcombocolor.addItem(resultadoConsulta.getString("color"));
            }
           
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");
                    }
// TODO add your handling code here:
    }//GEN-LAST:event_btncolorActionPerformed

    private void jcombocolorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombocolorActionPerformed
        
        String habit=(String)jcombocolor.getSelectedItem();    
         jcomboPokemones.removeAllItems();
              String cuerito1 ="SELECT  name from pokemon where color='"+habit+"'" ;
              
           try {
                resultadoConsulta = estado.executeQuery(cuerito1);
            } catch (SQLException ex) {
                Logger.getLogger(ventana_pokedex.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                while (resultadoConsulta.next()){
                     jcomboPokemones.remove(this);
                    jcomboPokemones.addItem(resultadoConsulta.getString("name"));
                }
                
                // TODO add your handling code here:
                // TODO add your handling code here:
            } catch (SQLException ex) {
                Logger.getLogger(ventana_pokedex.class.getName()).log(Level.SEVERE, null, ex);
            
    }//GEN-LAST:event_jcombocolorActionPerformed
    }
    private void btnbuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarNombreActionPerformed
          String cuerito3 = "SELECT DISTINCT (name) as name FROM pokemon order by 1";//ordena alfabeticamente los colores
        try {
            resultadoConsulta = estado.executeQuery(cuerito3);
            
          while (resultadoConsulta.next()){
                 jcomboNombres.remove(this);
                jcomboNombres.addItem(resultadoConsulta.getString("name"));
            }
           
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");
                    }
        
        
            
            
                     
    }//GEN-LAST:event_btnbuscarNombreActionPerformed

    private void jcomboPokemonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboPokemonesActionPerformed
            
    }//GEN-LAST:event_jcomboPokemonesActionPerformed
             
    private void jcomboNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboNombresActionPerformed
               String habit=(String)jcomboNombres.getSelectedItem();  
               
              
              String cuerito1 ="SELECT  id, name, habitat,color,species,capture_rate,base_experience from pokemon where name='"+habit+"'" ;
              
           try {
                resultadoConsulta = estado.executeQuery(cuerito1);
            } catch (SQLException ex) {
                Logger.getLogger(ventana_pokedex.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try {
                while (resultadoConsulta.next()){
                     jcombocolor.remove(this);
                    //jcombocolor.addItem(resultadoConsulta.getString("name"));
                    String f;
                   f=(resultadoConsulta.getString("id"));
                   
                   contador= Integer.parseInt(f) ;
                     dibujaElPokemonQueEstaEnLaPosicion(contador);
                    // nombrePoke.setText(resultadoConsulta.getString("name"));
                      //query.setText(resultadoConsulta.getString("habitat"));
                     query.setText(resultadoConsulta.getString("habitat"));
                    nombrePoke.setText(resultadoConsulta.getString("name"));
                     lblcolor.setText(resultadoConsulta.getString("color"));
                     lblspecies.setText(resultadoConsulta.getString("species"));
                     lblcapture_rate.setText(resultadoConsulta.getString("capture_rate"));
                     lblbase_experience.setText(resultadoConsulta.getString("base_experience"));
                      lblcolor.setVisible(true);
                       lblspecies.setVisible(true);
                      lblcapture_rate.setVisible(true);
                     lblbase_experience.setVisible(true);
        
        contador++;
        if (contador >=649){
            contador = 649;
        }
                
                       
                      
                }
                
                
                // TODO add your handling code here:
                // TODO add your handling code here:
            } catch (SQLException ex) {
                Logger.getLogger(ventana_pokedex.class.getName()).log(Level.SEVERE, null, ex);        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboNombresActionPerformed
    }
    private void btnfavoritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfavoritosActionPerformed
                  clsEmpleado agregar=new clsEmpleado();//variable agregar que va a llevar todos lod datos ingresados
               
                   
                   agregar.setUsuario(lblusuario.getText());
                   agregar.setFavoritos(nombrePoke.getText());
                 
                   clsEmpleadoJDBC alJDBC=new clsEmpleadoJDBC();
                   
                   alJDBC.insert(agregar);//llamamos a la funci�n insert con el parametro agregar
                   
                   JOptionPane.showMessageDialog(null,"pokemon agregado a favoritos");
                 
   // TODO add your handling code here:
    }//GEN-LAST:event_btnfavoritosActionPerformed

    private void btnNogustaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNogustaActionPerformed
        clsEmpleado agregar=new clsEmpleado();//variable agregar que va a llevar todos lod datos ingresados
               
                   
                   agregar.setUsuario(lblusuario.getText());
                   agregar.setNo_gustan(nombrePoke.getText());
                 
                   clsEmpleadoJDBC alJDBC=new clsEmpleadoJDBC();
                   
                   alJDBC.insert(agregar);//llamamos a la funci�n insert con el parametro agregar
                   
                   JOptionPane.showMessageDialog(null,"agregado a no te gustan");
               
    }//GEN-LAST:event_btnNogustaActionPerformed

    private void btnreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreporteActionPerformed
          Document Documento = new Document();
                  
          try{
          String ruta=System.getProperty("user.home");
          PdfWriter.getInstance(Documento, new FileOutputStream(ruta+"/Desktop/ReportePoke.pdf"));//indicamos la biblioteca donde queremos guardarlo
          Documento.open();//documento lo abrimos con el metodo open
             
          //todos los registros los guardamos dentro de la siguiente tabla
          PdfPTable tabla=new PdfPTable(4);
          tabla.addCell("id_usuario");
          tabla.addCell("usuario");
          tabla.addCell("favoritos");
          tabla.addCell("no_gustan");
          
          try{
          Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","Dacruz4032");
          PreparedStatement pst=cn.prepareStatement("select*from tb_favoritos");
          ResultSet rs=pst.executeQuery();
          
          //agrega todos los registros de la tabla hasta que ya no encuentre minguno
          if (rs.next()){
              do{
                  tabla.addCell(rs.getString(1));
                  tabla.addCell(rs.getString(2));
                  tabla.addCell(rs.getString(3));
                  tabla.addCell(rs.getString(4));
              }while (rs.next());
              Documento.add(tabla);
          }
          
          
                  
                  }
          catch(DocumentException | SQLException e){
              
          }
          Documento.close();
          JOptionPane.showMessageDialog(null, "reporte creado");
                  
                  }catch(DocumentException | HeadlessException | FileNotFoundException e )  {
    }   
                  
                   JOptionPane.showMessageDialog(null, "reporte no creado");
                  
                  
                  
                  // TODO add your handling code here:

    }//GEN-LAST:event_btnreporteActionPerformed

        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
         
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventana_pokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana_pokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana_pokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana_pokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana_pokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNogusta;
    private javax.swing.JButton btnbuscarNombre;
    private javax.swing.JButton btncambiar;
    private javax.swing.JButton btncolor;
    private javax.swing.JButton btnfavoritos;
    private javax.swing.JButton btnreporte;
    private javax.swing.JButton derecha;
    private javax.swing.JPanel imagenPoke;
    private javax.swing.JButton izquierda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> jcomboHabitats;
    private javax.swing.JComboBox<String> jcomboNombres;
    private javax.swing.JComboBox<String> jcomboPokemones;
    private javax.swing.JComboBox<String> jcombocolor;
    private javax.swing.JLabel lblbase_experience;
    private javax.swing.JLabel lblcapture_rate;
    javax.swing.JLabel lblcolor;
    private javax.swing.JLabel lblprueba;
    private javax.swing.JLabel lblspecies;
    public static javax.swing.JLabel lblusuario;
    private javax.swing.JLabel nombrePoke;
    private javax.swing.JLabel nombrepoke;
    private javax.swing.JButton prueba;
    private javax.swing.JLabel query;
    // End of variables declaration//GEN-END:variables
}
