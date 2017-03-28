/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl;

/**
 *
 * @author migue
 */
public class NodoAvl extends Nodo 
{ 
    int fe;
    public NodoAvl(Object valor) 
    {  
        super(valor);
        fe = 0; 
    } 
    public NodoAvl(Object valor, NodoAvl ramaIzdo, NodoAvl ramaDcho) 
    {
        super (ramaIzdo, valor, ramaDcho);
        fe = 0; 
    } 
    
}


 