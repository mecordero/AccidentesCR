/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;

/**
 *
 * @author Meli
 */
public class ParametrosIterator implements Iterator{
    ParametrosCollection parametros;
    
    private int[] actual;

    private boolean hasNext;
    
    public ParametrosIterator(ParametrosCollection parametros) {
        this.parametros = parametros;
        actual = new int[10];
        hasNext = true;
        for (int i = 0; i < 10; i++) {
            ArrayList array = parametros.getI(i);
            if(array.size() == 0)
                actual[i] = -1;
        }
        
    }
   
    @Override
    public Object next() {
        
        SetParametros resultado = new SetParametros();
        
        
        for (int i = 0; i < 10; i++) {
            if(actual[i] == -1){
                resultado.addParametro(null);
            }
            else
                resultado.addParametro((String) parametros.getI(i).get(actual[i]));
        }
        
        hasNext = false;
        for (int i = 9; i > -1; i--) {
            if(actual[i] == -1)
                continue;
            //seria 0 o mayor
            if(parametros.getI(i).size()-1 > actual[i]){
                actual[i] = actual[i] + 1;
                hasNext = true;
                break;
            }
            else
                actual[i] = 0;
        }
        return resultado;
        
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
    
    
    
}
