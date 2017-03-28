/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl;


  public class Entero implements Comparador 
  {	
      private int numerador;
      public Entero(int numerador)
      {
          this.numerador=numerador;
      }
      
      public int obtenerdato(){
          return numerador;
      }
      
      public boolean igualQue(Object op2) 
      {	
          Entero n2 = (Entero) op2;
          return((double)numerador==(double)n2.numerador);	
      }	
      public boolean menorQue(Object op2) 
      {		
          Entero n2 =	(Entero) op2;
      	  return((double)numerador<(double)n2.numerador);	
      }
      public boolean menorIgualQue(Object op2)
      {	 
          Entero n2 = (Entero)op2;
          return((double)numerador<=(double)n2.numerador);	
      }		
      public boolean mayorQue(Object op2){
          Entero n2 = (Entero) op2;
          return((double)numerador>(double)n2.numerador);	
      }	
      public boolean mayorIgualQue(Object op2)	
      {	
          Entero n2 =	(Entero) op2;
         return((double)numerador>=(double)n2.numerador);	
      } 
      
  }
     interface Comparador {	
          boolean igualQue(Object op2);	
          boolean menorQue(Object op2);	
          boolean menorIgualQue(Object op2);
          boolean mayorQue(Object op2);	
          boolean mayorIgualQue(Object op2);
      } 

