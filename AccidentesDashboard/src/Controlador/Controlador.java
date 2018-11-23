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
import javax.swing.JOptionPane;

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
    
      public void abrirMapa(double latitud, double longitud )
    {
        String direccion = "https://maps.googleapis.com/maps/api/"+ "staticmap?zoom=8&size=800x800&markers=size:tiny&color:red&";
        String key = "&key=AIzaSyCCu1UJxIme0c1I90gNW7nV_jpJ99vdgVs";
        String la = Double.toString(latitud);
        String lo = Double.toString(longitud);
        String las = la.replace('.', 'C');
        String los = lo.replace('.','C');
        direccion = direccion + las + '&' + los + "&center="+la+","+lo + key;
        try
        {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + direccion);
        }
        catch(Exception err)
        {
            JOptionPane.showMessageDialog(null,"Error: "+err);
        }
        

    }
    
}
