/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SC;

/**
 *
 * @author melki
 */
public class datosFilas {
    String numeroD;
    String descrip;
    String cuenta;
    String debito;
    String credito;
    String comentario;

    public datosFilas(String numeroD, String descrip, String cuenta, String debito, String credito, String comentario) {
        this.numeroD = numeroD;
        this.descrip = descrip;
        this.cuenta = cuenta;
        this.debito = debito;
        this.credito = credito;
        this.comentario = comentario;
    }

    public String getNumeroD() {
        return numeroD;
    }

    public void setNumeroD(String numeroD) {
        this.numeroD = numeroD;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDebito() {
        return debito;
    }

    public void setDebito(String debito) {
        this.debito = debito;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}
