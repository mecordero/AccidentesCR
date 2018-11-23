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
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    ArrayList<ArrayList> datos = new ArrayList<>();
        
        

    public Controlador() throws SQLException {
        Resultado resultado = dao.consulta3();
        provincias = new Provincias();
        for (int key : resultado.resultado.keySet()){
            ProvinciaObserver provinciaObserver = new ProvinciaObserver(provincias);
            provinciaObserver.setProvincia((Consulta3) resultado.resultado.get(key));
        }
        for (int i = 0; i < 10; i++) {
            datos.add(new ArrayList());            
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
    public void ConsultaCompuesta(String indicador,ArrayList opcion){
        if(indicador.equals("Provincia")){
            for (Object op : opcion) {
                datos.get(0).add(op);
            }
        }
        if(indicador.equals("Canton")){
            for (Object op : opcion) {
                datos.get(1).add(op);
            }
        }
        if(indicador.equals("Distrito")){
            for (Object op : opcion) {
                datos.get(2).add(op);
            }
        }
        if(indicador.equals("Dia")){
            for (Object op : opcion) {
                datos.get(3).add(op);
            }
        }
        if(indicador.equals("Mes")){
            for (Object op : opcion) {
                datos.get(4).add(op);
            }
        }
        if(indicador.equals("Ano")){
            for (Object op : opcion) {
                datos.get(5).add(op);
            }
        }
        if(indicador.equals("Rol")){
            for (Object op : opcion) {
                datos.get(6).add(op);
            }
        }
        if(indicador.equals("Lesion")){
            for (Object op : opcion) {
                datos.get(7).add(op);
            }
        }
        if(indicador.equals("Sexo")){
            for (Object op : opcion) {
                datos.get(9).add(op);
            }
        }
        System.out.println(datos);
    }
    public void RealizarConsulta(){
        ParametrosCollection pa = new ParametrosCollection(datos);
        ParametrosIterator p = new ParametrosIterator(pa);   
        do{
                try {
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
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
        }while(p.hasNext());
    }
    
}
