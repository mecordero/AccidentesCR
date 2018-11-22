/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.DAOSql;
import Model.Datos;
import Model.Distrito;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Marlen
 */
public class Controlador {
    private DTOUser dto;
    private DAOSql dao = new DAOSql();
    GraficoProxy proxy =  new GraficoProxy();

    
    public Datos cargarDatos() throws SQLException{
        Datos datos = new Datos();
        datos = dao.cargarDatos();
        
        return datos;
    }
    
    public void ConsultaSimple(String horiz,String vert,String indicador,String titulo){
        proxy.setEtiqHoriz(horiz);
        proxy.setEtiqVert(vert);
        proxy.setTituloGrafico(titulo);
        proxy.setIndicador(indicador);
        proxy.dibujar();
    }
    
}
