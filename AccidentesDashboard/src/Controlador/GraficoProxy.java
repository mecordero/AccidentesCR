/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Marlen
 */
public class GraficoProxy implements Grafico{
    
    private GraficoReal graficoReal;
    private String tituloGrafico;
    private String EtiqHoriz;
    private String EtiqVert; 
    JFreeChart grafica;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    ArrayList<ArrayList> memoria= new ArrayList();
    String indicador;

    @Override
    public ChartPanel dibujar() {
        ArrayList<String> name= new ArrayList();
        ArrayList<Integer> counter= new ArrayList();
        
        if(memoria.isEmpty()){
            graficoReal = new GraficoReal(tituloGrafico, EtiqHoriz, EtiqVert);
            try {
                graficoReal.anadirDatos(indicador,this);
            } catch (SQLException ex) {
                Logger.getLogger(GraficoProxy.class.getName()).log(Level.SEVERE, null, ex);
            }
            return graficoReal.dibujar();
        }
        for (int i = 0; i < memoria.size(); i++) {
            if(memoria.get(i).get(0).equals(indicador)){
                for (int j = 1; j < memoria.get(i).size(); j++) {
                    if(j%2==0){
                        counter.add((Integer) memoria.get(i).get(j));
                    }
                    else{
                        name.add(memoria.get(i).get(j).toString());
                    }
                }
                datos= new  DefaultCategoryDataset();
                anadirDatos(indicador, name, counter);
                grafica =ChartFactory.createBarChart(tituloGrafico,EtiqHoriz, EtiqVert, datos,PlotOrientation.VERTICAL, true, true, false);
                ChartPanel Panel = new ChartPanel(grafica);
                return Panel;
                /*JFrame Ventana = new JFrame("JFreeChart");
                Ventana.getContentPane().add(Panel);
                Ventana.pack();
                Ventana.setVisible(true);
                Ventana.setLocationRelativeTo(null);
                return;*/
            }
        }    
                
                graficoReal = new GraficoReal(tituloGrafico, EtiqHoriz, EtiqVert);
                try {
                    graficoReal.anadirDatos(indicador,this);
                } catch (SQLException ex) {
                    Logger.getLogger(GraficoProxy.class.getName()).log(Level.SEVERE, null, ex);
                }
                return graficoReal.dibujar();
    }
    public void anadirDatos(String Indicador,ArrayList<String> name,ArrayList<Integer> counter){
        for (int i = 0; i < name.size(); i++) {
            datos.addValue(counter.get(i), Indicador , name.get(i)); 
        }
     }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }
    
    public void setTituloGrafico(String tituloGrafico) {
        this.tituloGrafico = tituloGrafico;
    }

    public void setEtiqHoriz(String EtiqHoriz) {
        this.EtiqHoriz = EtiqHoriz;
    }

    public void setEtiqVert(String EtiqVert) {
        this.EtiqVert = EtiqVert;
    }

    public ArrayList<ArrayList> getMemoria() {
        return memoria;
    }
    
}
