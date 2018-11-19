/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;

/**
 *
 * @author Meli
 */
public class SetParametros {
    
    //provincia, canton, distrito, dia, mes, año, rol, lesion, edad quinquenal y sexo
    
    private ArrayList<String> parametros;

    public SetParametros() {
        parametros = new ArrayList<>();
       
    }


    public void addParametro(String parametro){
        parametros.add(parametro);
    }
    
    
    public String getProvincia() {
        return parametros.get(0);
    }

    public String getCanton() {
        return parametros.get(1);
    }

    public String getDistrito() {
        return parametros.get(2);
    }

    public String getDia() {
        return parametros.get(3);
    }

    public String getMes() {
        return parametros.get(4);
    }

    public String getAnho() {
        return parametros.get(5);
    }

    public String getRol() {
        return parametros.get(6);
    }

    public String getLesion() {
        return parametros.get(7);
    }

    public String getEdadQuinquenal() {
        return parametros.get(8);
    }

    public String getSexo() {
        return parametros.get(9);
    }

    @Override
    public String toString() {
        return "SetParametros{" + "provincia=" + getProvincia() + ", canton=" + getCanton() + ", distrito=" +
                getDistrito() + ", dia=" + getDia() + ", mes=" + getMes() + ", anho=" + getAnho() + ", rol=" + getRol()
                + ", lesion=" + getLesion() + ", edadQuinquenal=" + getEdadQuinquenal() + ", sexo=" + getSexo() + '}';
    }
    
    
    
}
