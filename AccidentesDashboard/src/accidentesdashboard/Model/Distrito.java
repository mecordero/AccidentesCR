/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accidentesdashboard.Model;

/**
 *
 * @author Usuario
 */
public class Distrito {
    
    private String nombre;
    private String canton;
    private String provincia;
    private String latitud;
    private String longitud;

    public Distrito(String nombre, String canton, String provincia, String latitud, String longitud) {
        this.nombre = nombre;
        this.canton = canton;
        this.provincia = provincia;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Distrito() {
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Distrito{" + "nombre=" + nombre + ", canton=" + canton + ", provincia=" + provincia + ", latitud=" + latitud + ", longitud=" + longitud + '}';
    }
    
    
}
