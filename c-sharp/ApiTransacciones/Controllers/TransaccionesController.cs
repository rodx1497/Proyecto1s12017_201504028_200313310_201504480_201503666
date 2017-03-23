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

        // GET: api/values
        [HttpGet]
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET api/values/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }

        //// POST api/values  //Agregar Transaccion
        //[HttpPost]
        //public string Post([FromBody]TransaccionViewModel t)
        //{
        //    string id = RandomString(15);
        //    Transaccion nuevaTransaccion = new Transaccion {
        //        id = id,
        //        usuario = t.usuario,
        //        activo = t.activo,
        //        departamento = t.departamento,
        //        empresa = t.empresa,
        //        tiempoRenta = t.tiempoRenta,
        //        fecha = DateTime.Now
        //    };
        //    arbol.insertar(nuevaTransaccion);
        //    return id;
        //}

        // POST api/values  //Agregar Transaccion
        [HttpPost]
        public void PostTest([FromBody]string t)
        {
            string id = RandomString(15);
            Transaccion nuevaTransaccion = new Transaccion
            {
                id = id,
                fecha = DateTime.Now
            };
            arbol.insertar(nuevaTransaccion);
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }

        string RandomString(int length, string alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789")
        {
            var outOfRange = byte.MaxValue + 1 - (byte.MaxValue + 1) % alphabet.Length;

            return string.Concat(
                Enumerable
                    .Repeat(0, int.MaxValue)
                    .Select(e => RandomByte())
                    .Where(randomByte => randomByte < outOfRange)
                    .Take(length)
                    .Select(randomByte => alphabet[randomByte % alphabet.Length])
            );
        }

        byte RandomByte()
        {
            using (var randomizationProvider = System.Security.Cryptography.RandomNumberGenerator.Create())
            {
                var randomBytes = new byte[1];
                randomizationProvider.GetBytes(randomBytes);
                return randomBytes.Single();
            }
        }



    }
}
