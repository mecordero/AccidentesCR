/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class DAOSql {

    private Connection con = null;

    public Connection getCon() {
        return con;
    }

    public void conectar() throws SQLException {
        try {
            //conexion a ms sql 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//esto siempre es igual
            String password = "12345678";
            String url = "jdbc:sqlserver://localhost;databaseName=BD_AccidentesCR";
            con = DriverManager.getConnection(url, "root", password);
            System.out.println("Conectado a base de datos");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            System.out.println("Error en conexion");
        }
    }

    public void desconectar() throws SQLException {
        if (this.con != null) {
            this.con.close();
        }
        System.out.println("Desconectado de la base");
    }

    public Datos cargarDatos() throws SQLException {
        conectar();
        Datos datos = new Datos();
        Statement select = con.createStatement();
        ResultSet result = select
                .executeQuery("SELECT * FROM Dia");
        while (result.next()) { 
            int key = result.getInt(1);
            String val = result.getString(2);

            System.out.println("Dia = " + val);
            datos.dias.put(key, val);
        }
        
        select = con.createStatement();
        result = select
                .executeQuery("SELECT * FROM Sexo");
        while (result.next()) { 
            int key = result.getInt(1);
            String val = result.getString(2);

            System.out.println("Sexo = " + val);
            datos.dias.put(key, val);
        }
        
        select = con.createStatement();
        result = select
                .executeQuery("SELECT * FROM Rol");
        while (result.next()) { 
            int key = result.getInt(1);
            String val = result.getString(2);

            System.out.println("Rol = " + val);
            datos.roles.put(key, val);
        }
        
        select = con.createStatement();
        result = select
                .executeQuery("SELECT * FROM Mes");
        while (result.next()) { 
            int key = result.getInt(1);
            String val = result.getString(2);

            System.out.println("Mes = " + val);
            datos.meses.put(key, val);
        }
        
        select = con.createStatement();
        result = select
                .executeQuery("SELECT id_provincia, RTRIM(nombre) FROM Provincia");
        while (result.next()) { 
            int key = result.getInt(1);
            String val = result.getString(2);

            System.out.println("Provincia = " + val);
            datos.provincias.put(key, val);
        }
        
        select = con.createStatement();
        result = select
                .executeQuery("SELECT * FROM Lesion");
        while (result.next()) { 
            int key = result.getInt(1);
            String val = result.getString(2);

            System.out.println("Lesion = " + val);
            datos.lesiones.put(key, val);
        }
        
        select = con.createStatement();
        result = select
                .executeQuery("SELECT id_canton, RTRIM(nombre) FROM Canton");
        while (result.next()) { 
            int key = result.getInt(1);
            String val = result.getString(2);

            datos.cantones.put(key, val);
        }
        
        select = con.createStatement();
        result = select
                .executeQuery("SELECT d.id_distrito, RTRIM(d.nombre), d.id_canton, c.id_provincia, RTRIM(d.latitud), RTRIM(d.longitud)"
                        + " FROM Distrito d INNER JOIN Canton c on c.id_canton = d.id_canton");
        while (result.next()) { 
            Distrito d =  new Distrito();
            int key = result.getInt(1);
            d.setNombre(result.getString(2));
            d.setCanton(datos.cantones.get(result.getInt(3)));
            d.setProvincia(datos.provincias.get(result.getInt(4)));
            d.setLatitud(result.getString(5));
            d.setLongitud(result.getString(6));

            datos.distritos.put(key, d);
        }
        desconectar();
        return datos;
    }
    
    public void consulta2(String indicador) throws SQLException{
        conectar();
        Statement select = con.createStatement();
        Resultado resultado = new Resultado();
        int i = 0;
        ResultSet result = select
                .executeQuery("SELECT COUNT(*), id_" + indicador + 
                        " FROM Afectado GROUP BY id_" + indicador);
        while (result.next()) { 
            int count = result.getInt(1);
            int id = result.getInt(2);
            resultado.resultado.put(id, count);
            System.out.println("Indicador " + count);
        }
        desconectar();
    }
    
    public void consulta3() throws SQLException {
        conectar(); // se conecta a la base
        Statement select = con.createStatement();
        Resultado resultado = new Resultado();
        int i = 0;
        ResultSet result = select
                .executeQuery("SELECT id_sexo, id_provincia, COUNT(id_sexo) FROM Afectado GROUP BY id_provincia, id_sexo");
        while (result.next()) { 
            int sexo = result.getInt(1);
            int provincia = result.getInt(2);
            int count = result.getInt(3);
            Consulta3 consulta3 = new Consulta3(sexo, provincia, count);
            resultado.resultado.put(++i, consulta3);
            System.out.println(consulta3.toString());
        }
        desconectar();
    }

}
