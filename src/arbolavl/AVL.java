/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class AVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ArbolAvl avl = new ArbolAvl(); //1, 3, 4, 5, 6, 7, 8, 9 y 10 
        Entero prueba1= new Entero(51);
        Entero prueba2= new Entero(31);
        Entero prueba3= new Entero(17);
        Entero prueba4= new Entero(60);
        Entero prueba5= new Entero(48);
        Entero prueba6= new Entero(98);
        Entero prueba7= new Entero(90);
        Entero prueba8= new Entero(7);
        Entero prueba9= new Entero(9);
        Entero prueba10= new Entero(10);
        avl.insertar(prueba1);
        avl.insertar(prueba2);
        avl.insertar(prueba3);
        avl.insertar(prueba4);
        avl.insertar(prueba5);
        avl.insertar(prueba6);
        avl.insertar(prueba7);
        avl.insertar(prueba8);
        avl.insertar(prueba9);
        avl.insertar(prueba10);
        try {
            
          
//            for (int i = 0; i < 10; i++) {
//                Entero prueban= new Entero(i);
//                avl.insertar(prueban);
//            }
               
                //avl.eliminar(prueban);
            avl.recorrer();
        } catch (Exception ex) {
            Logger.getLogger(AVL.class.getName()).log(Level.SEVERE, null, ex);
        }

        
}
}
