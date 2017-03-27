using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using ApiTransacciones.Models;
using System.Text;
using ApiTransacciones.ViewModels;

// For more information on enabling Web API for empty projects, visit http://go.microsoft.com/fwlink/?LinkID=397860

namespace ApiTransacciones.Controllers
{
    [Route("api/[controller]")]
    public class TransaccionesController : Controller
    {
        Arbol arbol;

        public TransaccionesController(Arbol arbolPrincipal)
        {
            arbol = arbolPrincipal;
        }

        // GET: api/Transacciones
        // devolvera el string para poder graficar con graphviz
        [HttpGet]
        public dynamic Get()
        {
            return new { graphviz = "digraph G { " + arbol.graphviz() + " }"};
        }

        // GET api/Transacciones/12345abcde67890
        // Buscar una transacción por Id
        [HttpGet("{id}")]
        public Transaccion Get(string id)
        {

            NodoPagina n = arbol.Buscar(id);
            if (n != null)
            {
                return n.Transaccion;
            }
            else
            {
                return null;
            }
        }

        // POST api/Transacciones  
        // Agregar nueva Transaccion
        [HttpPost]
        public Transaccion Post(TransaccionViewModel t)
        {
            string id = Utils.RandomString(15);
            Transaccion nuevaTransaccion = new Transaccion
            {
                id = id,
                usuario = t.usuario,
                activo = t.activo,
                departamento = t.departamento,
                empresa = t.empresa,
                tiempoRenta = t.tiempoRenta,
                fecha = DateTime.Now
            };
            arbol.insertar(nuevaTransaccion);
            return nuevaTransaccion;
        }

        // PUT api/values/5
        // Este api no tiene opción para hacer update a una transacción
        //[HttpPut("{id}")]
        //public void Put(int id, [FromBody]string value)
        //{
        //}

        // DELETE api/values/5
        // Este api no tiene opción para eliminar una transacción
        //[HttpDelete("{id}")]
        //public void Delete(int id)
        //{
        //}

        



    }
}
