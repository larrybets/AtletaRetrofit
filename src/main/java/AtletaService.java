import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by DAM on 14/12/16.
 */
public interface AtletaService {

    @GET("/atleta")
    Call<List<Atleta>> getAtletas();

    @GET("/atletas/{nacionalidad}")
    Call<Atleta> getAtletaByNacionalidad(@Path("nacionalidad") String nacionalidad);


}
