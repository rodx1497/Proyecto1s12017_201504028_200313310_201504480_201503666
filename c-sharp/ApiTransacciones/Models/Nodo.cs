namespace ApiTransacciones.Models
{
    using System.Collections.Generic;

    public class Nodo
    {
        private int Orden;

        public Nodo(int orden)
        {
            this.Orden = orden;
            this.Hojas = new List<Nodo>(orden);
            this.Pagina = new List<NodoPagina>(orden);
        }

        public List<Nodo> Hojas { get; set; }

        public List<NodoPagina> Pagina { get; set; }

        public bool EsHoja
        {
            get
            {
                return this.Hojas.Count == 0;
            }
        }

        public bool EstaLleno
        {
            get
            {
                return this.Pagina.Count == (2 * this.Orden) - 1;
            }
        }

        public bool TieneElMinimo
        {
            get
            {
                return this.Pagina.Count == this.Orden - 1;
            }
        }
    }
}
