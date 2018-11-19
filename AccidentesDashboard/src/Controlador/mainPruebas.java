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
public class mainPruebas {
    public static void main(String[] args) {
        ArrayList<ArrayList> datos = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            datos.add(new ArrayList());            
        }
        
        datos.get(0).add("Cartago");
        datos.get(1).add("Alvarado");
        datos.get(1).add("Cartago");
        datos.get(3).add("Lunes");
        datos.get(3).add("Martes");
        datos.get(3).add("Miercoles");
        datos.get(4).add("Agosto");
        datos.get(5).add("2014");
        datos.get(6).add("Conductor");
        datos.get(6).add("Ciclista");
        datos.get(7).add("Muerte");     
        
        ParametrosCollection pa = new ParametrosCollection(datos);
        ParametrosIterator p = new ParametrosIterator(pa);   
            
        
        do{
            SetParametros s = (SetParametros) p.next();
            System.out.println(s.toString());
        }while(p.hasNext());
    }
}
