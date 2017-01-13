import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Created by DAM on 14/12/16.
 */
public interface AtletaService {


    @GET("/atletas")
    Call<List<Atleta>> getAtletas();

    @GET("/players/{id}")
    Call<Atleta> getAtleta(@Path("id") Long id);

    @GET("/atletas/{nacionalidad}")
    Call<List<Atleta>> getAtletasByNacionalidad(@Path("nacionalidad")String nacionalidad);

    @GET("/atletas/nacimiento/{nacimientoStr}")
    Call<List<Atleta>> getAtletasNacimiento(@Path("nacimientoStr")String nacimiento);

    @GET("/atletas/groupby/nacionalidad")
    Call<Map<String, List<Atleta>>> getAtletasGroupByNacionalidad();

    @POST("/atletas")
    Call<Atleta> createAtleta(@Body Atleta atleta);

    @PUT("/atletas")
    Call<Atleta> updateAtleta(@Body Atleta atleta);


    @DELETE("/atletas/{id}")
    Call<Void> deleteAtleta(@Path("id") Long id);

}
