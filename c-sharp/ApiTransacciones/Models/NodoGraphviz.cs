using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ApiTransacciones.Models
{
    public class NodoGraphviz
    {
        public string nombre { get; set; }
        public string etiqueta { get; set; }
        public string conexiones { get; set; }
        public string cuerpo { get; set; }
    }
}
