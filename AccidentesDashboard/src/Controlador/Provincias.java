/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Consulta3;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Usuario
 */
public class Provincias {
    
    private List<Observer> observers = new ArrayList<>();
    private int state;
    protected GraficoReal grafico = new GraficoReal("Consulta3", "Provincias", "Cantidad por sexo");

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        grafico.datos = new DefaultCategoryDataset();
        notifyAllObservers();
    }

    public GraficoReal getGrafico() {
        return grafico;
    }
    
    public void attach(Observer observer){
      observers.add(observer);		
   }

   public void notifyAllObservers(){
      for (Observer observer : observers) {
         observer.update();
      }
   } 
    
}
