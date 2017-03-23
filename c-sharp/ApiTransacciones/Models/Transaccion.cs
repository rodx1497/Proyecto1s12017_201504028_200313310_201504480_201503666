using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ApiTransacciones.Models
{
    public class Transaccion
    {
        public string id { get; set; }
        public string activo { get; set; }
        public string usuario { get; set; }
        public string departamento { get; set; }
        public string empresa { get; set; }
        public DateTime fecha { get; set; }
        public int tiempoRenta { get; set; }
    }
}
