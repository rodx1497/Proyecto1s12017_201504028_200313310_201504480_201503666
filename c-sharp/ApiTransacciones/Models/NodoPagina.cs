namespace ApiTransacciones.Models
{
    using System;

    public class NodoPagina //: IEquatable<NodoPagina>
    {
        public string IdTransaccion { get; set; }

        public Transaccion Transaccion { get; set; }

        //public bool Equals(NodoPagina other)
        //{
        //    return this.IdTransaccion.Equals(other.IdTransaccion) && this.Transaccion.Equals(other.Transaccion);
        //}
    }
}
