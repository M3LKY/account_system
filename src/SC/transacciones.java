/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author melki
 */
public class transacciones extends javax.swing.JFrame {

    /**
     * Creates new form transacciones
     */
    String status = "";
    String ruta = "Tcabecera.txt", rutaTabla = "Ttabla.txt", rutaCa = "catalogo.txt";
    static DefaultTableModel modelo = new DefaultTableModel();
    static ArrayList<datosFilas> arr = new ArrayList<datosFilas>();
    
    public transacciones() {
        initComponents();
        setLocationRelativeTo(null);
        formatoTabla();
        File file = new File(ruta);
        File file2 = new File(rutaTabla);
        //addEnterListener(tdoc, tdate, tdep, ttdoc, usuari, montoTotal, tabla, file, file2);
         tdoc.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                // Check if the Enter key was released
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Search for the line in textfileONE that starts with the text in PRIME
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            String[] parts = line.split("; ");
                            if (parts[0].equals(tdoc.getText())) {
                                if (parts[2].equals("1")) {
                                    JOptionPane.showMessageDialog(null, "Transacción ha sido Actualizada.");
                                    break;
                                } else {
                                    clearFields(tdate, ttdoc, usuari, montoTotal, tdep, tabla);
                                    updateFields(tdoc.getText(), file, file2);
                                    break;
                                }
                            }
                            clearFields(tdate, ttdoc, usuari, montoTotal, tdep, tabla);
                        }
                        if (!scanner.hasNextLine()) {
                            //clearFields(tdate, ttdoc, usuari, montoTotal, tdep, tabla);
                            //JOptionPane.showMessageDialog(null, "Cuenta no existe.");
                        }
                        scanner.close();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
       
        setDate(tdate);
    }
    
    public static void updateFields(String str, File file1, File file2) {
    try {
        // Initialize the JTextFields and JTextArea
        

        // Initialize the table and model
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(7);
        table.setModel(model);

        // Search for the line in file1 that starts with the given string
        Scanner scanner = new Scanner(file1);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("; ");
            if (parts[0].equals(str)) {
                // Set the values of the fields and text area
                if (!parts[1].isEmpty()) tdate.setText(parts[1]);
                if (!parts[3].isEmpty()) tdep.setText(parts[3]);
                if (!parts[4].isEmpty()) usuari.setText(parts[4]);
                if (!parts[5].isEmpty()) ttdoc.setText(parts[5]);
                if (!parts[6].isEmpty()) montoTotal.setText(parts[6]);
                break;
            }
        }
        scanner.close();

        // Search for the lines in file2 that start with the given string
        addLinesToTable(str, tabla, file2);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }
    
    
    
    public static void addLinesToTable(String str, JTable table, File file) {
    try {
        // Initialize the table model
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Search for the lines in the file that start with the given string
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("; ");
            if (parts[0].equals(str)) {
                // Add the line to the table, handling empty elements
                Object[] row = new Object[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].isEmpty()) {
                        row[i] = "";
                    } else {
                        row[i] = parts[i];
                    }
                }
                model.addRow(row);
            }
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
    
    public static void setDate(JTextField textField) {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    textField.setText(sdf.format(cal.getTime()));
    }
    

    public static void modifyLine(String str1, String str2, String str3, String fileName) throws IOException {
// Create a FileReader to read from the file
FileReader fr = new FileReader(fileName);
// Create a BufferedReader to read from the FileReader
BufferedReader br = new BufferedReader(fr);
// Create a temporary file to store the modified line
File tempFile = new File("temp.txt");
// Create a FileWriter to write to the temporary file
FileWriter fw = new FileWriter(tempFile);
// Create a BufferedWriter to write to the FileWriter
BufferedWriter bw = new BufferedWriter(fw);
// Read each line of the file
    String line;
    while ((line = br.readLine()) != null) {
        // If the line starts with str1, modify it and write it to the temporary file
        if (line.startsWith(str1)) {
            // Split the line by "; "
            String[] words = line.split("; ");
            // Modify the eleventh word by adding str2 to it
            double eleventhWord = Double.parseDouble(words[10]) + Double.parseDouble(str2);
            // Rebuild the line with the modified eleventh word
            String modifiedLine = "";
            for (int i = 0; i < words.length; i++) {
                // If this is the eleventh word, use the modified value
                if (i == 10) {
                    modifiedLine += eleventhWord + "; ";
                }
                // Otherwise, use the original value
                else {
                    modifiedLine += words[i] + "; ";
                }
            }
            // Add str3 at the end of the line
            modifiedLine += str3;
            // Write the modified line to the temporary file
            bw.write(modifiedLine);
        }
        // If the line does not start with str1, write it to the temporary file as is
        else {
            bw.write(line);
        }
        // Add a newline character after each line
        bw.newLine();
    }

    // Close the BufferedReader, BufferedWriter, and FileReader
    bw.close();
    br.close();
    fr.close();

    // Delete the original file
    File oldFile = new File(fileName);
    oldFile.delete();
    // Rename the temporary file to the original file
    tempFile.renameTo(oldFile);
}

    

   
    
    public static void clearFields(JTextField field1, JTextField field2, JTextField field3, JTextField field4, JTextArea area, JTable table) {
    // Clear the text fields and text area
    setDate(field1);
    field2.setText("");
    field3.setText("");
    field4.setText("");
    area.setText("");

    // Clear the table
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);
}
    
    public void writeStringsToFile(String str1, String str2, String str3, String str4, 
            String str5, String str6, String str7, File file) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
        // Check if the first string is already in the file
        boolean exists = false;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("; ");
            if (parts[0].equals(str1)) {
                exists = true;
                break;
            }
        }
        scanner.close();

        // If the first string is not in the file, write the strings to the file
        if (!exists) {
            String line = str1 + "; " + str2 + "; " + str3 + "; " + str4 + "; " + str5 + "; " + str6 + "; " + str7;
            writer.write(line);
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    public void writeTableToFile(JTable table, File file) {
    TableModel model = table.getModel();
    int rowCount = model.getRowCount();
    int columnCount = model.getColumnCount();

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
        for (int i = 0; i < rowCount; i++) {
            String line = "";
            for (int j = 0; j < columnCount; j++) {
                line += model.getValueAt(i, j).toString();
                if (j < columnCount - 1) {
                    line += "; ";
                }
            }

            // Check if the line is already in the file
            boolean exists = false;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String existingLine = scanner.nextLine();
                if (line.equals(existingLine)) {
                    exists = true;
                    break;
                }
            }
            scanner.close();

            // If the line is not in the file, write it to the file
            if (!exists) {
                writer.write(line);
                writer.newLine();
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    public String verifyLine(String str1, File file) {
    String str2 = "";
    boolean found = false;
    try {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("; ");
            if (parts[0].equals(str1)) {
                if (parts[2].equals("DETALLE")) {
                    str2 = parts[1];
                    found = true;
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "La cuenta no es DETALLE.");
                    break;
                }
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Cuenta no existe.");
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return str2;
}
    
    public boolean checkTable(String str, JTable table) {
    TableModel model = table.getModel();
    int rowCount = model.getRowCount();

    for (int i = 0; i < rowCount; i++) {
        String value = model.getValueAt(i, 2).toString();
        if (value.equals(str)) {
            JOptionPane.showMessageDialog(null, "Esta cuenta ya fue agregada.");
            return true;
        }
    }
    return false;
    }
    
    public boolean calculateSums(JTable table, JTextField textField) {
    TableModel model = table.getModel();
    int rowCount = model.getRowCount();

    double sum5 = 0;
    double sum6 = 0;
    for (int i = 0; i < rowCount; i++) {
        String value5 = model.getValueAt(i, 4).toString();
        String value6 = model.getValueAt(i, 5).toString();
        if (!value5.isEmpty()) {
            sum5 += Double.parseDouble(value5);
        }
        if (!value6.isEmpty()) {
            sum6 += Double.parseDouble(value6);
        }
    }

    if (sum5 != sum6) {
        JOptionPane.showMessageDialog(null, "Debito y Credito no cuadra");
        return true;
    } else {
        textField.setText(String.valueOf(sum5));
        JOptionPane.showMessageDialog(null, "Guardado!");
        return false;
    }
}
    
    public static void llenarTabla(){
        Object[] datos = new Object[modelo.getColumnCount()];
        int i = 1;
        modelo.setRowCount(0);
        for(datosFilas filas: arr){
            datos[0] = filas.getNumeroD();
            datos[1] = i;
            datos[2] = filas.getCuenta();
            datos[3] = filas.getDescrip();
            datos[4] = filas.getDebito();
            datos[5] = filas.getCredito();
            datos[6] = filas.getComentario();
            i++;
            modelo.addRow(datos);
        }
        tabla.setModel(modelo);
    }
    
    public static void formatoTabla(){
        String[] encab = {"Nro. Documento", "Secuencia", "Cuenta Contable","Descripcion", "Debito", "Credito", "Comentario"};
        modelo.setColumnIdentifiers(encab);
        tabla.setModel(modelo);
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        numeroDoc = new javax.swing.JLabel();
        tipoDoc = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        descripcion = new javax.swing.JLabel();
        tdoc = new javax.swing.JTextField();
        ttdoc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdep = new javax.swing.JTextArea();
        tdate = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        numeroCuenta = new javax.swing.JLabel();
        NumCuenta = new javax.swing.JTextField();
        usur = new javax.swing.JLabel();
        usuari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        debito = new javax.swing.JTextField();
        credito = new javax.swing.JTextField();
        comentario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        montoTotal = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        agrgarD = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 700));

        panel.setBackground(new java.awt.Color(102, 0, 0));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numeroDoc.setBackground(new java.awt.Color(255, 255, 255));
        numeroDoc.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        numeroDoc.setForeground(new java.awt.Color(255, 255, 255));
        numeroDoc.setText("Numero de Documento:");
        panel.add(numeroDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        tipoDoc.setBackground(new java.awt.Color(255, 255, 255));
        tipoDoc.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        tipoDoc.setForeground(new java.awt.Color(255, 255, 255));
        tipoDoc.setText("Tipo de Documento:");
        panel.add(tipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        fecha.setBackground(new java.awt.Color(255, 255, 255));
        fecha.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setText("Fecha:");
        panel.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, 20));

        descripcion.setBackground(new java.awt.Color(255, 255, 255));
        descripcion.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        descripcion.setForeground(new java.awt.Color(255, 255, 255));
        descripcion.setText("Descripcion:");
        panel.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        tdoc.setBackground(new java.awt.Color(255, 255, 204));
        panel.add(tdoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 220, 40));

        ttdoc.setBackground(new java.awt.Color(255, 255, 204));
        panel.add(ttdoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 220, 40));

        tdep.setBackground(new java.awt.Color(255, 255, 204));
        tdep.setColumns(20);
        tdep.setRows(5);
        jScrollPane1.setViewportView(tdep);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 290, 50));

        tdate.setBackground(new java.awt.Color(255, 255, 204));
        panel.add(tdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 180, 40));

        tabla.setBackground(new java.awt.Color(102, 255, 102));
        tabla.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(tabla);

        panel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 750, 290));

        numeroCuenta.setBackground(new java.awt.Color(255, 255, 255));
        numeroCuenta.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        numeroCuenta.setForeground(new java.awt.Color(255, 255, 255));
        numeroCuenta.setText("Cuenta Contable: ");
        panel.add(numeroCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        NumCuenta.setBackground(new java.awt.Color(204, 255, 204));
        panel.add(NumCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 160, 40));

        usur.setBackground(new java.awt.Color(255, 255, 255));
        usur.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        usur.setForeground(new java.awt.Color(255, 255, 255));
        usur.setText("Hecho por:");
        panel.add(usur, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        usuari.setBackground(new java.awt.Color(255, 255, 204));
        panel.add(usuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 180, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Debito");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Credito");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Comentario");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, -1));

        debito.setBackground(new java.awt.Color(204, 255, 204));
        panel.add(debito, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 140, 40));

        credito.setBackground(new java.awt.Color(204, 255, 204));
        panel.add(credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 140, 40));

        comentario.setBackground(new java.awt.Color(204, 255, 204));
        panel.add(comentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 210, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Monto:");
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, -1));

        montoTotal.setBackground(new java.awt.Color(255, 255, 204));
        montoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montoTotalActionPerformed(evt);
            }
        });
        panel.add(montoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 270, 40));

        guardar.setBackground(new java.awt.Color(0, 153, 153));
        guardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("Agregar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        panel.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 160, 40));

        agrgarD.setBackground(new java.awt.Color(0, 102, 102));
        agrgarD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        agrgarD.setForeground(new java.awt.Color(255, 255, 255));
        agrgarD.setText("Guardar");
        agrgarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agrgarDActionPerformed(evt);
            }
        });
        panel.add(agrgarD, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, 170, 40));
        panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 780, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        String NumeroCuenta = NumCuenta.getText(); 
        if(checkTable(NumeroCuenta, tabla)){
            
        }else{
            File file3 = new File(rutaCa);
            String docc = tdoc.getText(); 
            String debit = debito.getText();
            String credit = credito.getText();
            String depcri = verifyLine(NumeroCuenta, file3);
            String comen = comentario.getText();
            String g = "";
            if(debit.equals("")){
                g = credit;
            }else{
                g = debit;
            }
            try {
                modifyLine(NumeroCuenta, g, tdate.getText(), "catalogo.txt");
            } catch (IOException ex) {
                Logger.getLogger(transacciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!depcri.equals("")){
                datosFilas filas = new datosFilas(docc, depcri, NumeroCuenta, debit, credit, comen);
                arr.add(filas);
                llenarTabla();
            }
        }
        
        
    }//GEN-LAST:event_guardarActionPerformed

    private void agrgarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agrgarDActionPerformed
        // TODO add your handling code here:
        status = "0";
        File file = new File(ruta);
        File file2 = new File(rutaTabla);
        if(calculateSums(tabla, montoTotal)){}
        else{
            writeStringsToFile(tdoc.getText(), tdate.getText(), status,tdep.getText(),
                usuari.getText(), ttdoc.getText(), montoTotal.getText(), file);
        
            writeTableToFile(tabla, file2);
            
        }
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_agrgarDActionPerformed

    private void montoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montoTotalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transacciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NumCuenta;
    private javax.swing.JButton agrgarD;
    private javax.swing.JTextField comentario;
    private javax.swing.JTextField credito;
    private javax.swing.JTextField debito;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JTextField montoTotal;
    private javax.swing.JLabel numeroCuenta;
    private javax.swing.JLabel numeroDoc;
    private javax.swing.JPanel panel;
    private static javax.swing.JTable tabla;
    private static javax.swing.JTextField tdate;
    private static javax.swing.JTextArea tdep;
    private javax.swing.JTextField tdoc;
    private javax.swing.JLabel tipoDoc;
    private static javax.swing.JTextField ttdoc;
    private static javax.swing.JTextField usuari;
    private javax.swing.JLabel usur;
    // End of variables declaration//GEN-END:variables
}
