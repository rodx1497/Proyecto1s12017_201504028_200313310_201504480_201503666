namespace ApiTransacciones.Models
{
    using System;
    using System.Diagnostics;
    using System.Linq;

    public class Arbol
    {
        public Arbol()
        {
            this.Orden = 5;
            this.Raiz = new Nodo(this.Orden);
            this.Altura = 1;
        }

        public Nodo Raiz { get; private set; }

        public int Orden { get; private set; }

        public int Altura { get; private set; }
        
        public void insertar(Transaccion transaccion)
        {
            // Verificamos si la Raiz esta llena
            if (!this.Raiz.EstaLleno)
            {
                this.insertarTransaccion(this.Raiz, transaccion);
            }
            else
            {
                // Si esta llena entonces tenemos que crear una nueva hoja dividiendo la Raiz
                Nodo oldRoot = this.Raiz;
                this.Raiz = new Nodo(this.Orden);
                this.Raiz.Hojas.Add(oldRoot);
                this.DividirHoja(this.Raiz, 0, oldRoot);
                this.insertarTransaccion(this.Raiz, transaccion);

                this.Altura++;
            }
        }

        private void insertarTransaccion(Nodo nodo, Transaccion transaccion)
        {
            int nuevaPosicion = nodo.Pagina.TakeWhile(nodoPagina => transaccion.id.CompareTo(nodoPagina.IdTransaccion) >= 0).Count();

            if (nodo.EsHoja)
            {
                nodo.Pagina.Insert(nuevaPosicion, new NodoPagina() { IdTransaccion = transaccion.id, Transaccion = transaccion });
            }
            else
            {
                // Tiene Hojas (actua como Raiz)
                Nodo hoja = nodo.Hojas[nuevaPosicion];
                if (hoja.EstaLleno)
                {
                    this.DividirHoja(nodo, nuevaPosicion, hoja);
                    if (transaccion.id.CompareTo(nodo.Pagina[nuevaPosicion].IdTransaccion) > 0)
                    {
                        nuevaPosicion++;
                    }
                }

                this.insertarTransaccion(nodo.Hojas[nuevaPosicion], transaccion);
            }
        }

        public NodoPagina Buscar(string id)
        {
            return this.BuscarTransaccion(this.Raiz, id);
        }

        private NodoPagina BuscarTransaccion(Nodo node, string key)
        {
            int i = node.Pagina.TakeWhile(entry => key.CompareTo(entry.IdTransaccion) > 0).Count();

            if (i < node.Pagina.Count && node.Pagina[i].IdTransaccion.CompareTo(key) == 0)
            {
                return node.Pagina[i];
            }

            return node.EsHoja ? null : this.BuscarTransaccion(node.Hojas[i], key);
        }

        private void DividirHoja(Nodo raiz, int posicion, Nodo nodo)
        {
            var newNode = new Nodo(this.Orden);

            raiz.Pagina.Insert(posicion, nodo.Pagina[this.Orden - 1]);
            raiz.Hojas.Insert(posicion + 1, newNode);

            newNode.Pagina.AddRange(nodo.Pagina.GetRange(this.Orden, this.Orden - 1));
            
            // remove also Entries[this.Orden - 1], which is the one to move up to the parent
            nodo.Pagina.RemoveRange(this.Orden - 1, this.Orden);

            if (!nodo.EsHoja)
            {
                newNode.Hojas.AddRange(nodo.Hojas.GetRange(this.Orden, this.Orden));
                nodo.Hojas.RemoveRange(this.Orden, this.Orden);
            }
        }

        
    }
}
