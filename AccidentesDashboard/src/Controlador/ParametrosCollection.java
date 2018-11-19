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
public class ParametrosCollection implements Container{
    //provincias, cantones, distritos, dias, meses, años, roles, lesiones, edades quinquenales y sexos
    
    private ArrayList<ArrayList> datos;

    public ParametrosCollection(ArrayList<ArrayList> datos) {
        this.datos = datos;
    }   
    
    public ArrayList getI(int i){
        return datos.get(i);
    }
    
    public String getProvincia(int i){
        return (String) datos.get(0).get(i);
    }
    
    public String getCanton(int i){
        return (String) datos.get(1).get(i);
    }
    
    public String getDistrito(int i){
        return (String) datos.get(2).get(i);
    }
    
    public String getDia(int i){
        return (String) datos.get(3).get(i);
    }
    
    public String getMes(int i){
        return (String) datos.get(4).get(i);
    }
    
    public String getAnho(int i){
        return (String) datos.get(5).get(i);
    }
    
    public String getRol(int i){
        return (String) datos.get(6).get(i);
    }
    
    public String getLesion(int i){
        return (String) datos.get(7).get(i);
    }
    
    public String getEdadQuinquenal(int i){
        return (String) datos.get(8).get(i);
    }
    
    public String getSexo(int i){
        return (String) datos.get(9).get(i);
    }
    
    @Override
    public Iterator getIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
