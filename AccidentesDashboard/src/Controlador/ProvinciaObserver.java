/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Consulta3;
import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class ProvinciaObserver extends Observer{
    
    private Consulta3 provincia;

    public ProvinciaObserver(Provincias provincias) {
        this.provincias = provincias;
        this.provincias.attach(this);
    }

    public Consulta3 getProvincia() {
        return provincia;
    }

    public void setProvincia(Consulta3 provincia) {
        this.provincia = provincia;
    }

    @Override
    public void update() {
        if (this.provincias.getState() == 0){
            for (int i=1; i<4; i++){
                this.provincias.grafico.datos.addValue(provincia.getSexo(i), this.provincia.getSexoNombre(i), this.provincia.getNombre());
            }
        } else {
            this.provincias.grafico.datos.addValue(provincia.getSexo(this.provincias.getState()), this.provincia.getSexoNombre(this.provincias.getState()), this.provincia.getNombre());
        }
    }
   
    
}
