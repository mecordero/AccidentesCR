/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.DAOSql;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Meli
 */
public class mainPruebas {
    public static void main(String[] args) throws SQLException {
        DAOSql dao = new DAOSql();
        
        dao.conectar();
              
        ArrayList<ArrayList> datos = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            datos.add(new ArrayList());            
        }
        
        datos.get(0).add("CARTAGO");
        datos.get(0).add("ALAJUELA");
        datos.get(0).add("GUANACASTE");
        datos.get(0).add("HEREDIA");
        datos.get(0).add("LIMÓN");
        datos.get(0).add("PUNTARENAS");
        datos.get(0).add("SAN JOSÉ");
        
        datos.get(5).add(2014);
        
        datos.get(3).add("Lunes");
        datos.get(3).add("Martes");
        datos.get(3).add("Miércoles");
        datos.get(3).add("Jueves");
        datos.get(3).add("Viernes");
        datos.get(3).add("Sábado");
        datos.get(3).add("Domingo");

        datos.get(4).add("Enero");
        datos.get(4).add("Febrero");
        datos.get(4).add("Marzo");
        datos.get(4).add("Abril");
        datos.get(4).add("Mayo");
        datos.get(4).add("Junio");
        datos.get(4).add("Julio");
        datos.get(4).add("Agosto");
        datos.get(4).add("Setiembre");
        datos.get(4).add("Octubre");
        datos.get(4).add("Noviembre");
        datos.get(4).add("Diciembre"); 
        /*
                
        
        datos.get(4).add("Agosto");
        
        datos.get(6).add("Conductor");
        datos.get(6).add("Ciclista");
        datos.get(7).add("Muerte");     */
        
        ParametrosCollection pa = new ParametrosCollection(datos);
        ParametrosIterator p = new ParametrosIterator(pa);   
            
        
        do{
            SetParametros s = (SetParametros) p.next();
            CallableStatement cstmt = dao.getCon().prepareCall("{call ConsultaDinamica(?,?,?,?,?,?,?,?,?,?,?)}");
            cstmt.setString("Provincia", s.getProvincia());
            cstmt.setString("Canton", s.getCanton());
            cstmt.setString("Distrito", s.getDistrito());
            cstmt.setString("Dia", s.getDia());
            cstmt.setString("Mes", s.getMes());
            cstmt.setInt("Anho", s.getAnho());
            cstmt.setString("Rol", s.getRol());
            cstmt.setString("Lesion", s.getLesion());
            cstmt.setString("Edad_Quinquenal", s.getEdadQuinquenal());
            cstmt.setString("Sexo", s.getSexo());
            cstmt.registerOutParameter ("Count", java.sql.Types.INTEGER);                        
            cstmt.execute();            
            int res = cstmt.getInt("Count");
        }while(p.hasNext());
        
        System.out.println("finish");
    }
}
