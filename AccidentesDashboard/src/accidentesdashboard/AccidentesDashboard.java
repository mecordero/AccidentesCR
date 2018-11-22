/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accidentesdashboard;

import Controlador.GraficoReal;
import Controlador.ProvinciaObserver;
import Controlador.Provincias;
import Model.Consulta3;
import Model.DAOSql;
import Model.Resultado;
import java.sql.SQLException;
import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public class AccidentesDashboard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        DAOSql dao = new DAOSql();
        //dao.cargarDatos();
        Resultado resultado = dao.consulta3();
        Provincias provincias = new Provincias();
        for (int key : resultado.resultado.keySet()){
            ProvinciaObserver provinciaObserver = new ProvinciaObserver(provincias);
            provinciaObserver.setProvincia((Consulta3) resultado.resultado.get(key));
        }
        
        
        provincias.setState(0);
        provincias.getGrafico().dibujar();
        //provincias.setState(2);
        //provincias.getGrafico().dibujar("ya");
    }
    
}
