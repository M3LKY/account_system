/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author melki
 */
public class Registrar extends javax.swing.JFrame {

    /**
     * Creates new form Registrar
     */
    String path = "archivoLogin.txt", path2 = "usuarioTable.txt";
    boolean crear = false;
    public static String Satigualinea="";
    ArrayList<String> userss = new ArrayList<String>();
    public Registrar() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Crear = new javax.swing.JButton();
        regresar = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        adm = new javax.swing.JRadioButton();
        normal = new javax.swing.JRadioButton();
        status = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 372));
        setMinimumSize(new java.awt.Dimension(600, 372));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 90, -1));

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Apellido:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 70, -1));

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Nivel:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 37, -1));

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Contrasena: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 80, -1));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("Email:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 37, -1));

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Nombre de Usuario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        Crear.setBackground(new java.awt.Color(255, 0, 0));
        Crear.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        Crear.setForeground(new java.awt.Color(0, 0, 0));
        Crear.setText("Crear");
        Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearActionPerformed(evt);
            }
        });
        jPanel1.add(Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 90, 40));

        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarMouseClicked(evt);
            }
        });
        jPanel1.add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 70, 50));

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 160, 30));
        jPanel1.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 160, 30));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 220, 30));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 160, 30));
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 140, 30));

        adm.setForeground(new java.awt.Color(204, 255, 255));
        adm.setText("Administrador");
        jPanel1.add(adm, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, -1, -1));

        normal.setForeground(new java.awt.Color(204, 255, 255));
        normal.setText("Normal");
        jPanel1.add(normal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        status.setToolTipText("");
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarMouseClicked
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarMouseClicked

    private void CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearActionPerformed
        // TODO add your handling code here:
          // get the textfields data
        String user = username.getText();
        String passW = String.valueOf(pass.getPassword());
        String apellid = apellido.getText();
        String nom = nombre.getText();
        String emaill = email.getText();
        String tipo = "";
        //nom,apellid,user,passW,tipo,emaill
        grupo.add(adm);
        grupo.add(normal);
        //adm.setSelected(true);
        if(adm.isSelected()){
            tipo = "0";
        }else if(normal.isSelected()){
            tipo = "1";
        }
        //File file = new File(path);
        //File file2 = new File(path2);
        
        //---------------------------------------
                
                String Snuevalinea="";

                ArchivoPrueba MA =new ArchivoPrueba();
                

                try {

                    if (crear==false)
                    {
                        MA.GuardarDatos (nom,apellid,user,passW,tipo,emaill);
                    }
                    else
                    {
                        Snuevalinea=(nom +"; "+apellid+"; "+user+"; "+passW+"; "+tipo+"; "+emaill);
                        
                        MA.modify(Satigualinea, Snuevalinea);
                    }
                    apellido.setText("");
                            username.setText("");
                            pass.setText("");
                            
                            email.setText("");
                    status.setText("");
                    //Salida.setText("");
                    
                } // fin try
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
        //---------------------------------------
        
    }//GEN-LAST:event_CrearActionPerformed
    
    public boolean checkIfUsernameExist(String un){
        boolean exist = false;
        
        for(String username: userss)
        {
            if(username.equals(un))
            {
                exist = true;
            }
        }
        
        return exist;
    }
    
    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
        boolean encontrado=false;
        String tipoC = "";
        //cod=Integer.parseInt(Codigo.getText());

        Scanner s;

        try {
            File f = new File("archivoLogin.txt");
            s= new Scanner(f);
            
            if(!f.exists())
            {
                f.createNewFile();
            }
            
            else
            {
                while (s.hasNextLine() && !encontrado)
                {

                    String linea = s.nextLine();
                    Scanner sl = new Scanner(linea);

                    sl.useDelimiter("\\s*;\\s*");
                    /*
                    nom +"; "+apellid+"; "+user+"; "+passW+"; "+tipo+" "+emaill
                    String user = username.getText();
        String passW = String.valueOf(pass.getPassword());
        String apellid = apellido.getText();
        String nom = nombre.getText();
        String emaill = email.getText();
                    */
                    try {
                        if(nombre.getText().equals(sl.next()))
                        {
                            apellido.setText(sl.next());
                            username.setText(sl.next());
                            pass.setText(sl.next());
                            tipoC = sl.next();
                            if(tipoC.equals("0")){
                                adm.setSelected(true);
                            }else if(tipoC.equals("1")){
                                normal.setSelected(true);
                            }
                            email.setText(sl.next());
                            encontrado=true;
                            crear = true;
                            Satigualinea=(nombre.getText() + "; " + apellido.getText()+ "; " + username.getText()+ "; " + pass.getPassword()+ "; " + tipoC+ "; " + email.getText());
                            status.setText("Modificando");
                        }
                        else
                        { //Salida.setText("Este registro no existe");
                            
                            apellido.setText("");
                            username.setText("");
                            pass.setText("");
                            
                            tipoC = sl.next();
                            if(tipoC.equals("0")){
                                adm.setSelected(true);
                            }else if(tipoC.equals("1")){
                                normal.setSelected(true);
                            }
                            email.setText("");
                            
                            encontrado=false;
                            crear = false;
                            //Satigualinea=(nombre.getText() + "; " + apellido.getText()+ "; " + username.getText()+ "; " + pass.getPassword()+ "; " + tipoC+ "; " + email.getText());
                            status.setText("Creando");
                        }
                    } // fin try
                    catch (Exception e1)
                    {
                        // JOptionPane.showMessageDialog(null,"Error al leer Archivo " + e1);
                        e1.printStackTrace();
                    }
                } // fin while
            }
            s.close();
        } // fin try
        catch (FileNotFoundException e1)
        {
                JOptionPane.showMessageDialog(null,"Error al leer Archivo " + e1);
            //e1.printStackTrace();
            }
            catch (IOException e1)
            {
            // TODO Auto-generated catch block
                e1.printStackTrace();
            }
    }//GEN-LAST:event_nombreActionPerformed

    void uncode(){
        /*
        try {
            // file = the file we want to write on
            // true = we wan to append the text on it
            FileWriter fw = new FileWriter(file, true);
            //FileWriter fw2 = new FileWriter(file2, true);
            BufferedWriter bw = new BufferedWriter(fw);
            // we need to check if the textfields are empty
            // we need to check if the confirmation password equal the password
            // we need to check if the username already exist
          
            // check if the textfields are empty
            if( user.equals("") || nom.equals("") ||apellid.equals("")|| emaill.equals("") || passW.equals("") || tipo.equals("") )
            {
                System.out.println("One Or More Fields Are Empty");
                //msgF.jLabel_Title.setText("Signup Error");
                //msgF.jLabel_message.setText("One Or More Fields Are Empty");
            }
            else{
                // confirmation password
                
                    // check if the username already exist
                    if(!checkIfUsernameExist(user))
                    {
                        bw.write(nom +"; "+apellid+"; "+user+"; "+passW+"; "+tipo+" "+emaill);
                        bw.newLine();
                        //fw.write("Nombre: "+nom);
                        //fw.write(System.getProperty("line.separator"));
                        //fw.write("Apellido: "+apellid);
                        //fw.write(System.getProperty("line.separator"));
                        //fw.write("Usuario: "+user);
                        //fw.write(System.getProperty("line.separator"));
                        //fw.write("Password: "+passW);
                        //fw.write(System.getProperty("line.separator"));
                        //fw.write("Email: "+emaill);
                        //fw.write(System.getProperty("line.separator"));
                        //fw.write("-------");
                        //fw.write(System.getProperty("line.separator"));
                        fw.close();
                        bw.close();
                        //fw2.close();
                        // populate the array and hashmap
                        Login log = new Login();
                        log.usuarios();
                        
                        //msgF.jLabel_Title.setText("Signup");
                        //msgF.jLabel_message.setText("You Have Created A New Account Successfully");
                        
                    }
                    else
                    {
                       System.out.println("This Username Already Exist, Try Another One");  
                       //msgF.jLabel_Title.setText("Signup Error");
                       //msgF.jLabel_message.setText("This Username Already Exist, Try Another One");
                    }  
            }
            
            //msgF.setVisible(true);
            
        } catch (IOException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        String user = username.getText();
        String passW = String.valueOf(pass.getPassword());
        String apellid = apellido.getText();
        String nom = nombre.getText();
        String emaill = email.getText();
        
        File file = new File(path);
        try {
            FileWriter fw = new FileWriter(file, true);
            
            fw.write("Nombre: "+nom);
            fw.write(System.getProperty("line.separator"));
            fw.write("Apellido: "+apellid);
            fw.write(System.getProperty("line.separator"));
            fw.write("Usuario: "+user);
            fw.write(System.getProperty("line.separator"));
            fw.write("Password: "+passW);
            fw.write(System.getProperty("line.separator"));
            fw.write("Email: "+emaill);
            fw.write(System.getProperty("line.separator"));
            fw.write("-------");
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Crear;
    private javax.swing.JRadioButton adm;
    private javax.swing.JTextField apellido;
    private javax.swing.JTextField email;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombre;
    private javax.swing.JRadioButton normal;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel regresar;
    private javax.swing.JTextField status;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
