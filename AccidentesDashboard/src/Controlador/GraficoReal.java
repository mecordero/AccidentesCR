/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.DAOSql;
import Model.Datos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
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
    DAOSql dao = new DAOSql();
    //GraficoProxy guardar;// guarda las estadisticas
    
    public GraficoReal(String tituloGrafico, String EtiqHoriz, String EtiqVert) {
        this.tituloGrafico = tituloGrafico;
        this.EtiqHoriz = EtiqHoriz;
        this.EtiqVert = EtiqVert;
    }
    
    @Override
    public ChartPanel dibujar(){
        grafica =ChartFactory.createBarChart(tituloGrafico,EtiqHoriz, EtiqVert, datos,PlotOrientation.VERTICAL, true, true, false);
        ChartPanel Panel = new ChartPanel(grafica);
        return Panel;
        /*JFrame Ventana = new JFrame("JFreeChart");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
        Ventana.setLocationRelativeTo(null);*/
    }
    
    public void anadirDatos(String Indicador,GraficoProxy guardar) throws SQLException{
        datos = new DefaultCategoryDataset();
        ArrayList<ArrayList> grafic_info;
        ArrayList temp = new ArrayList();
        grafic_info= dao.consultaGrafic(Indicador);
        ArrayList<String> name= grafic_info.get(1);
        ArrayList<Integer> counter= grafic_info.get(0);
        // se guarda la info con respecto al indicador 
        temp.add(Indicador);
        for (int i = 0; i < name.size(); i++) {
            temp.add(name.get(i));
            temp.add(counter.get(i));
            datos.addValue(counter.get(i), Indicador , name.get(i)); 
        }
        guardar.memoria.add(temp);
    }
    
}
