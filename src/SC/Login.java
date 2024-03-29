/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author melki
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    String path = "archivoLogin.txt";
    String usaa = "";
    public String getusaa(){
        return usaa;
    }
    ArrayList<String> userss = new ArrayList<String>();
    Map<String, String> userANDpass = new HashMap<>(); 
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        usuarios();
    }
    public void usuarios(){
        
        File file = new File(path);
        String username = "";
        String password = "";
        
        try {
            
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            // read line by line from the text file
            Object[] lines = br.lines().toArray();
            for(int i = 0; i < lines.length; i++)
            {  
                // splite the row into two rows
                // one for the name of the field
                // and the other for the value of the field
                String[] row = lines[i].toString().split(": ");
                
                if(row[0].equals("Usuario"))
                {
                    // if it's the username field we will get the username
                    username = row[1];
                    // add the username to the all username array
                    userss.add(username);
                }
                else if(row[0].equals("Password"))
                {
                    // if it's the password field we will get the password
                    password = row[1];
                }
                if(!username.equals("") && !password.equals(""))
                {
                    // add the username and the password to the hashmap
                    userANDpass.put(username, password);
                }
                
            }

            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textoPass = new javax.swing.JPasswordField();
        textoUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(14, 0, 53));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(700, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(190, 252, 222));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Harrington", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add-User.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 20, 30));

        boton.setBackground(new java.awt.Color(255, 255, 255));
        boton.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        boton.setForeground(new java.awt.Color(0, 0, 0));
        boton.setText("Login");
        boton.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        boton.setBorderPainted(false);
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });
        jPanel2.add(boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 120, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Lock.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 20));

        textoPass.setBackground(new java.awt.Color(102, 255, 204));
        textoPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoPass.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(textoPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 250, 40));

        textoUsuario.setBackground(new java.awt.Color(102, 255, 204));
        textoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoUsuario.setForeground(new java.awt.Color(0, 0, 0));
        textoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(textoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 250, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 330, 290));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 50, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static boolean searchLine(String str, String fileName) throws IOException {
// Create a FileReader to read from the file
FileReader fr = new FileReader(fileName);
// Create a BufferedReader to read from the FileReader
BufferedReader br = new BufferedReader(fr);
// Read each line of the file
    String line;
    while ((line = br.readLine()) != null) {
        // Split the line by "; "
        String[] words = line.split("; ");
        // If the third word is equal to str and the fifth word is "1"
        if (words[2].equals(str) && words[4].equals("1")) {
            // Close the BufferedReader and FileReader
            br.close();
            fr.close();
            // Return true
            return true;
        }
    }

    // If the loop completes without finding a match, close the BufferedReader and FileReader
    br.close();
    fr.close();
    // Return false
    return false;
}
    private void textoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoUsuarioActionPerformed

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
         boolean encontrado=false;
String contra = String.valueOf(textoPass.getPassword());
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
                    sl.next();sl.next();
                    try {
                        if(textoUsuario.getText().equals(sl.next()) && contra.equals(sl.next()))
                        {
                            // Crea una instancia de la clase que contiene la variable
                            cha myClass = new cha();
                            // Asigna un valor a la variable
                            myClass.myVariable = textoUsuario.getText();
                            
                            //usaa = textoUsuario.getText();
                            encontrado=true; 
                        }
                        else
                        { //Salida.setText("Este registro no existe");
                            encontrado=false;                            
                        }
                    } // fin try
                    catch (Exception e1)
                    {
                        // JOptionPane.showMessageDialog(null,"Error al leer Archivo " + e1);
                        e1.printStackTrace();
                    }
                } // fin while
                if(encontrado){
                    
                    Menu menu = new Menu();
                            menu.setVisible(true);
                            
                           // close the login form
                           this.dispose();
                            
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Username.");
                }
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
    }//GEN-LAST:event_botonActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
       System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        ////<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField textoPass;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables
}
