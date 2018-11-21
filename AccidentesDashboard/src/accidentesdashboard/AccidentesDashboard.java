/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accidentesdashboard;

import Controlador.GraficoReal;
import Model.DAOSql;
import java.sql.SQLException;

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
        dao.cargarDatos();
        GraficoReal gr = new GraficoReal("Informacion accidentes","X","Cantidad");
        gr.anadirDatos("sexo");
        gr.dibujar("dia");
        dao.consulta3();
    }
    
}
