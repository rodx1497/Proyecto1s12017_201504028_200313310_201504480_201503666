/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class ArbolAvl 
{ 
    NodoAvl raiz;
     public ArbolAvl() 
     {  
         raiz = null;
     } 
     public NodoAvl raizArbol () 
     {  return raiz; 
     }
     
     private NodoAvl rotacionII(NodoAvl n, NodoAvl n1) 
     { 
         n.ramaIzdo(n1.subarbolDcho());
         n1.ramaDcho(n); 
        // actualización de los factores de equilibrio   
         if (n1.fe == -1)  // se cumple en la inserción  
         {  
             n.fe = 0;
             n1.fe = 0; 
         } else 
         {  
             n.fe = -1;
             n1.fe = 1; 
         } return n1; 
     } 
     private NodoAvl rotacionDD(NodoAvl n, NodoAvl n1) 
     { 
         n.ramaDcho(n1.subarbolIzdo());
         n1.ramaIzdo(n); 
    // actualización de los factores de equilibrio   
         if (n1.fe == +1)  // se cumple en la inserción 
         {  
             n.fe = 0;
             n1.fe = 0; 
         } else {  
             n.fe = +1;  
             n1.fe = -1;
         } return n1; 
     } 
     private NodoAvl rotacionID(NodoAvl n, NodoAvl n1) 
     {  
        NodoAvl n2; 
        n2 = (NodoAvl) n1.subarbolDcho();
        n.ramaIzdo(n2.subarbolDcho()); 
        n2.ramaDcho(n); 
        n1.ramaDcho(n2.subarbolIzdo());
        n2.ramaIzdo(n1); // actualización de los factores de equilibrio 
        if (n2.fe == +1)  
            n1.fe = -1; 
        else  n1.fe = 0; 
        if (n2.fe == -1)  
            n.fe = 1; 
        else  n.fe = 0; n2.fe = 0; 
        return n2; 
     } 
     private NodoAvl rotacionDI(NodoAvl n, NodoAvl n1) 
     { 
         NodoAvl n2;
         n2 = (NodoAvl)n1.subarbolIzdo();
         n.ramaDcho(n2.subarbolIzdo()); 
         n2.ramaIzdo(n); 
         n1.ramaIzdo(n2.subarbolDcho()); 
         n2.ramaDcho(n1);  
        // actualización de los factores de equilibrio 
        if (n2.fe == +1) 
            n.fe = -1; 
        else n.fe = 0; 
        if (n2.fe == -1)  
            n1.fe = 1; 
        else  n1.fe = 0; 
        n2.fe = 0; 
        return n2; 
     }
     
          private NodoAvl
     insertarAvl(NodoAvl raiz, Entero dt, Logical h) throws Exception 
      { 
        NodoAvl n1;
        if (raiz == null) 
        {  
           raiz = new NodoAvl(dt);
           h.setLogical(true);
        } else if(dt.menorQue(raiz.valorNodo())) 
        {  
            NodoAvl iz;
            iz = insertarAvl((NodoAvl)raiz.subarbolIzdo(), dt, h);
            raiz.ramaIzdo(iz);  
            // regreso por los nodos del camino de búsqueda  
            if (h.booleanValue())  
            {   // decrementa el fe por aumentar la altura de rama izquierda   
                switch (raiz.fe)   
                {     
                    case  1:      
                        raiz.fe = 0;
                        h.setLogical(false);     
                        break;      
                    case  0:      
                        raiz.fe = -1;     
                        break;    
                    case -1: // aplicar rotación a la izquierda      
                        n1 = (NodoAvl)raiz.subarbolIzdo();     
                        if (n1.fe == -1)      
                            raiz = rotacionII(raiz, n1);    
                        else      
                            raiz = rotacionID(raiz, n1);     
                        h.setLogical(false);   
                }  
            } 
        } 
        else if (dt.mayorQue(raiz.valorNodo())) 
        {  
            NodoAvl dr;
            dr = insertarAvl((NodoAvl)raiz.subarbolDcho(), dt, h);  
            raiz.ramaDcho(dr);  // regreso por los nodos del camino de búsqueda  
            if (h.booleanValue())  {   
            // incrementa el fe por aumentar la altura de rama izquierda   
            switch (raiz.fe)   {     
                case  1:  // aplicar rotación a la derecha     
                    n1 = (NodoAvl)raiz.subarbolDcho();     
                    if (n1.fe == +1)      
                        raiz = rotacionDD(raiz, n1);
                    else      
                        raiz = rotacionDI(raiz,n1);     
                        h.setLogical(false);     
                        break;     
                case 0:     
                    raiz.fe = +1;     
                    break;     
                case -1:      
                    raiz.fe = 0;      
                    h.setLogical(false);       
            }  
            } 
        } else  
            throw new Exception("No puede haber claves repetidas " ); 
        return raiz; 
      }
     
     public void eliminar (Object valor) throws Exception 
     { 
         Comparador dato;
         dato = (Comparador) valor; 
         Logical flag = new Logical(false); 
         raiz = borrarAvl(raiz, dato, flag); 
     } 
     
     private NodoAvl borrarAvl(NodoAvl r, Comparador clave,
               Logical cambiaAltura) throws Exception 
   { 
         if (r == null) 
         {
           throw new Exception (" Nodo no encontrado ");      
         } 
         else if (clave.menorQue(r.valorNodo())) 
         {  
            NodoAvl iz;   
            iz = borrarAvl((NodoAvl)r.subarbolIzdo(),clave,cambiaAltura);  
            r.ramaIzdo(iz);  
            if (cambiaAltura.booleanValue())  
                r = equilibrar1(r, cambiaAltura); 
         } 
         else if (clave.mayorQue(r.valorNodo())) 
          {  
             NodoAvl dr;   
             dr = borrarAvl((NodoAvl)r.subarbolDcho(), clave, cambiaAltura);  
             r.ramaDcho(dr);  
             if (cambiaAltura.booleanValue())
                 r = equilibrar2(r, cambiaAltura); 
          } 
          else   // Nodo encontrado  
           {  
              NodoAvl q;          
              q = r;   // nodo a quitar del árbol  
              if (q.subarbolIzdo()== null)
              {   
                  r = (NodoAvl) q.subarbolDcho();  
                  cambiaAltura.setLogical(true);  
              }  
              else if (q.subarbolDcho() == null)  
              {   
                  r = (NodoAvl) q.subarbolIzdo();
                  cambiaAltura.setLogical(true);  
              }  
              else  
              {    // tiene rama izquierda y derecha 
                  NodoAvl iz;   
                  iz = reemplazar(r, (NodoAvl)r.subarbolIzdo(),cambiaAltura);   
                  r.ramaIzdo(iz);   
                  if (cambiaAltura.booleanValue())
                      r = equilibrar1(r, cambiaAltura);  
               }  
                  q = null; 
              }
             return r;
    } 
  private NodoAvl reemplazar(NodoAvl n, NodoAvl act, Logical cambiaAltura) 
        {  
            if (act.subarbolDcho() != null) 
            {  
                NodoAvl d;
                d = reemplazar(n, (NodoAvl)act.subarbolDcho(), cambiaAltura);  
                act.ramaDcho(d);  
                if (cambiaAltura.booleanValue())   
                    act = equilibrar2(act, cambiaAltura); 
            } 
            else 
            {  
                n. nuevoValor(act.valorNodo());
                n = act;  
                act = (NodoAvl)act.subarbolIzdo();  
                n = null;  
                cambiaAltura.setLogical(true); 
            } 
            return act; 
        } 
        
        private NodoAvl equilibrar1(NodoAvl n, Logical cambiaAltura) 
        { 
            NodoAvl n1;
            switch (n.fe) 
            {  
                case -1 : 
                   n.fe = 0;
                   break;  
                case 0  : 
                    n.fe = 1;      
                    cambiaAltura.setLogical(false);      
                    break;  
                case +1  :  //se aplicar un tipo de rotación derecha       
                    n1 = (NodoAvl)n.subarbolDcho();      
                    if (n1.fe >= 0)      
                    {       
                        if (n1.fe == 0) //la altura no vuelve a disminuir          
                            cambiaAltura.setLogical(false);       
                        n = rotacionDD(n, n1);      
                    }      
                    else      
                        n = rotacionDI(n, n1);     
                    break; 
            } return n; 
        } 
        private NodoAvl equilibrar2(NodoAvl n, Logical cambiaAltura)
        { 
           
           NodoAvl n1;

           switch (n.fe) 
           {  
              case -1: // Se aplica un tipo de rotación izquierda       
                  n1 = (NodoAvl)n.subarbolIzdo();      
                  if (n1.fe <= 0)      
                  {       
                      if (n1.fe == 0)         
                          cambiaAltura.setLogical(false); 
                      n = rotacionII(n, n1);      
                  }      
                  else      
                      n = rotacionID(n,n1);      
                  break;  
              case 0  : 
                  n.fe = -1;      
                  cambiaAltura.setLogical(false);      
                  break;  
              case +1 : n.fe = 0;      
                  break;  
           }  
           return n; 
        }
     
    public void insertar (Object valor)throws Exception 
      { 
          Entero dato;
          Logical h = new Logical(false);
          // intercambia un valor booleano 
          dato = (Entero) valor; 
          raiz = insertarAvl(raiz, dato, h); 
          System.out.println("INSERTADO");
      }
   public void recorrer ()throws Exception 
    { 
          NodoAvl raiz=raizArbol();
          Entero o = (Entero)raiz.dato;
          System.out.println("RAIZ="+o.obtenerdato());
          o = (Entero)raiz.izdo.dato;
          System.out.println("RAIZ-NODO IZQ= "+o.obtenerdato());
          o = (Entero)raiz.dcho.dato;
          System.out.println("RAIZ-NODO DER= "+o.obtenerdato());
          grafo();
   }
   String cadena="";
   public void inorden(Nodo r) 
   { 
       if (r != null)	
       {  
           String r1="";
           String aux="";
           String aux2="";
           String aux3="";
           inorden(r.subarbolIzdo());  
             try {
               String r2= r.izdo.visitar();
               aux2=aux2+("-> t"+r2);
                } catch (Exception ex) {
                   
             }
           r1= r.visitar();
           aux=aux+("t"+r1+"[label=\""+r1+"\"];");
            inorden (r.subarbolDcho());	
             try {
               String r3= r.dcho.visitar();
               aux3=aux3+("-> t"+r3);
                } catch (Exception ex) {
                    
             }
             cadena=cadena+"\n"+aux+"\n t"+r1+aux2+";"+"t"+r1+aux3+";";          
       } 
   }
   
   public void grafo(){
        cadena="\n digraph g{";
        inorden(raiz);
       //src/Salidas/
//        aux=self.primero
//        for valor in range(0, self.size):
//            if aux!=None and aux.siguiente!=None:
//                cadena=cadena+("t"+str(valor)+"-> t"+str(valor+1)+";")
//                cadena=cadena+("t"+str(valor)+"[label=\""+str(aux.dato)+"\"];")
//            if valor==self.size-1:
//                cadena=cadena+("t"+str(valor)+"[label=\""+str(aux.dato)+"\"]")
//            aux=aux.siguiente
                    
        cadena=cadena+"\n}";
        System.out.println(cadena);
   }
      public void escribir(String escritura, String nombre) throws IOException{
        String ruta = "src/graficos/"+nombre+".dot";
        FileWriter fichero = null;
        PrintWriter pw = null;
        File file = new File(ruta);
        
            if(!file.exists()) {
            file.createNewFile();
              }
           FileOutputStream fop=new FileOutputStream(file);
                  fop.write(escritura.getBytes());
                  fop.flush();
            fop.close();
            
            fabricar(nombre);
       }
          public void fabricar (String nombre_archivo) throws IOException{
            String[] cmd = new String[5];
            cmd[0] = "dot"; 
            cmd[1] = "-Tpng"; 
            cmd[2] = "src/graficos/" + nombre_archivo + ".dot";
            cmd[3] = "-o"; 
            cmd[4] = "src/graficos/" + nombre_archivo + ".png"; 
            Runtime rt = Runtime.getRuntime(); 
            rt.exec(cmd);
          }
   
}
      

       