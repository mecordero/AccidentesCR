/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class Datos {
    
    HashMap<Integer, String> dias = new HashMap<>();
    HashMap<Integer, String> meses = new HashMap<>();
    HashMap<Integer, String> sexos = new HashMap<>();
    HashMap<Integer, String> roles = new HashMap<>();
    HashMap<Integer, String> provincias = new HashMap<>();
    HashMap<Integer, String> cantones = new HashMap<>();
    HashMap<Integer, Distrito> distritos = new HashMap<>();
    HashMap<Integer, String> lesiones = new HashMap<>();

    public HashMap<Integer, String> getDias() {
        return dias;
    }

    public HashMap<Integer, String> getMeses() {
        return meses;
    }

    public HashMap<Integer, String> getSexos() {
        return sexos;
    }

    public HashMap<Integer, String> getRoles() {
        return roles;
    }

    public HashMap<Integer, String> getProvincias() {
        return provincias;
    }

    public HashMap<Integer, String> getCantones() {
        return cantones;
    }

    public HashMap<Integer, Distrito> getDistritos() {
        return distritos;
    }

    public HashMap<Integer, String> getLesiones() {
        return lesiones;
    }
    
    
}
