/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Consulta3;
import Model.DAOSql;
import Model.Datos;
import Model.Distrito;
import Model.Resultado;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Marlen
 */
public class Controlador {
    private DTOUser dto;
    private DAOSql dao = new DAOSql();
    GraficoProxy proxy =  new GraficoProxy();
    private Provincias provincias;

    public Controlador() throws SQLException {
        Resultado resultado = dao.consulta3();
        provincias = new Provincias();
        for (int key : resultado.resultado.keySet()){
            ProvinciaObserver provinciaObserver = new ProvinciaObserver(provincias);
            provinciaObserver.setProvincia((Consulta3) resultado.resultado.get(key));
        }
    }

    public Datos cargarDatos() throws SQLException{
        Datos datos = new Datos();
        datos = dao.cargarDatos();
        return datos;
    }
    
    public ChartPanel ConsultaSimple(String horiz,String vert,String indicador,String titulo){
        proxy.setEtiqHoriz(horiz);
        proxy.setEtiqVert(vert);
        proxy.setTituloGrafico(titulo);
        proxy.setIndicador(indicador);
        return proxy.dibujar();
    }
    
    public ChartPanel ConsultaLibre(int state) throws SQLException{
        provincias.setState(state);
        return provincias.getGrafico().dibujar();
    }
    
}
