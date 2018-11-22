/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Marlen
 */
public class GraficoProxy implements Grafico{
    
    private GraficoReal graficoReal;
    private String tituloGrafico;
    private String EtiqHoriz;
    private String EtiqVert; 
    ArrayList<ArrayList> Proxy = new ArrayList();
    
    @Override
    public void dibujar() {
        if(graficoReal == null)
        {
            graficoReal = new GraficoReal(tituloGrafico,EtiqHoriz,EtiqVert);
            graficoReal.dibujar();
            
        }
        else{
            
        }
    }
}
