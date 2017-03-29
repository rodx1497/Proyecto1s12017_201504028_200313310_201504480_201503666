package com.usacedd.estuardoarevalo.eddrentaarticulos.api;

import com.usacedd.estuardoarevalo.eddrentaarticulos.api.modelos.IniciarSesionResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by estuardoarevalo on 3/28/17.
 */

public interface PythonApi {

    @FormUrlEncoded
    @POST("lista_compobrar_contra")
    Call<IniciarSesionResponse> iniciarSesion(@Field("usuario") String usuario,
                                              @Field("contraseña") String contrasena,
                                              @Field("empresa") String empresa,
                                              @Field("departamento") String departamento);
}
