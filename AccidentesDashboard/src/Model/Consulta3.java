/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Usuario
 */
public class Consulta3 {
    
    private int idSexo;
    private int idProvincia;
    private int resultado;

    public Consulta3(int idSexo, int idProvincia, int resultado) {
        this.idSexo = idSexo;
        this.idProvincia = idProvincia;
        this.resultado = resultado;
    }

    public int getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Consulta3{" + "idSexo=" + idSexo + ", idProvincia=" + idProvincia + ", resultado=" + resultado + '}';
    }
  
}
