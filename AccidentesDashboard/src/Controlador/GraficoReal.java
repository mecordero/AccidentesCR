/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Datos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Marlen
 */
public class GraficoReal implements Grafico {
    private String tituloGrafico;
    private String EtiqHoriz;
    private String EtiqVert;
    JFreeChart grafica;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
       
    public GraficoReal(String tituloGrafico, String EtiqHoriz, String EtiqVert) {
        this.tituloGrafico = tituloGrafico;
        this.EtiqHoriz = EtiqHoriz;
        this.EtiqVert = EtiqVert;
    }
    
    public void dibujar(){
        
        grafica =ChartFactory.createBarChart(tituloGrafico,EtiqHoriz, EtiqVert, datos,PlotOrientation.VERTICAL, true, true, false);
    }
    
    public void anadirDatos(String Seleccion){
        
    }
        
}
