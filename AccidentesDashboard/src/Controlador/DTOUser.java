/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;

/**
 *
 * @author Marlen
 */
public class DTOUser {
    ArrayList Provincia=new  ArrayList();
    ArrayList Distrito=new  ArrayList();
    ArrayList Canton =new ArrayList();
    ArrayList Edad =new  ArrayList();
    ArrayList Sexo =new ArrayList();
    ArrayList Lesion =new ArrayList();
    ArrayList Annos =new ArrayList();
    ArrayList Roles =new ArrayList();

    public ArrayList getRoles() {
        return Roles;
    }

    public void setRoles(ArrayList Roles) {
        this.Roles = Roles;
    }
    
    public ArrayList getProvincia() {
        return Provincia;
    }

    public void setProvincia(ArrayList Provincia) {
        this.Provincia = Provincia;
    }

    public ArrayList getDistrito() {
        return Distrito;
    }

    public void setDistrito(ArrayList Distrito) {
        this.Distrito = Distrito;
    }

    public ArrayList getCanton() {
        return Canton;
    }

    public void setCanton(ArrayList Canton) {
        this.Canton = Canton;
    }

    public ArrayList getEdad() {
        return Edad;
    }

    public void setEdad(ArrayList Edad) {
        this.Edad = Edad;
    }

    public ArrayList getSexo() {
        return Sexo;
    }

    public void setSexo(ArrayList Sexo) {
        this.Sexo = Sexo;
    }

    public ArrayList getLesion() {
        return Lesion;
    }

    public void setLesion(ArrayList Lesion) {
        this.Lesion = Lesion;
    }

    public ArrayList getAnnos() {
        return Annos;
    }

    public void setAnnos(ArrayList Annos) {
        this.Annos = Annos;
    }
    
}
