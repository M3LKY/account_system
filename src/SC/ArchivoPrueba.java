package SC;
import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 import java.io.FileReader;
 import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ArchivoPrueba {
@SuppressWarnings("resource")
    public void GuardarDatos (String nom,String apellid,String user,String passW,String tipo,String emaill) throws IOException
    {
        try
        {
            FileWriter F1=new FileWriter("archivoLogin.txt", true);
            PrintWriter pw=new PrintWriter(F1);
            pw.println(nom + "; " + apellid+ "; " + user+ "; " + passW+ "; " + tipo+ "; " + emaill);
            pw.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error al grabar Archivo " + ex);
        }
    } // fin metodo GuardarDatos
    //public void Modificar(String codigo,String nombre, String edad)

    public static void modify(String oldLine, String newLine) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("archivoLogin.txt"));
        String line = reader.readLine();
        String modifiedText = "";

        while (line != null) {
            String[] words = line.split("; ");
            String firstWord = words[0];

            if (firstWord.equals(oldLine.split("; ")[0])) {
                modifiedText += newLine + System.lineSeparator();
            } else {
                modifiedText += line + System.lineSeparator();
            }
            line = reader.readLine();
        }

        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter("archivoLogin.txt"));
        writer.write(modifiedText);
        writer.close();
    }
    
    void Escribir(File fFichero,String cadena)
    {
        // Declaramos un buffer de escritura
        BufferedWriter bw;
        try
        {
        if(!fFichero.exists())
        {
            fFichero.createNewFile();
        }

        // Luego de haber creado el archivo procedemos a escribir dentro de el.
        bw = new BufferedWriter(new FileWriter(fFichero,true));
        bw.write(cadena+"\r\n");
        bw.close();

        }// fin try
        catch(Exception e)
        {
            System.out.println(e);
        }

    } // fin metodo Escribir

    void borrar (File Ffichero)
    {
       try
       {
       // Comprovamos si el fichero existe de ser así procedemos a borrar el archivo
            if(Ffichero.exists())
            {
                Ffichero.delete();
                System.out.println("Ficherro Borrado");
            }
       } // fin try
       catch(Exception e)
       {
            System.out.println(e);
       }
    } // fin metodo Borrar
} //Fin AchivoPrueba   




