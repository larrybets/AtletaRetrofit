import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by DAM on 14/12/16.
 */
public class RestSynchronous {

    private static Retrofit retrofit;

    public static void main(String[] args) throws IOException {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AtletaService atletaService = retrofit.create(AtletaService.class);
        Call<List<Atleta>> call = atletaService.getAtletas();
        Response<List<Atleta>> response= call.execute();

        if(response.isSuccessful()){
            List<Atleta> atletaList = response.body();
            System.out.println(System.lineSeparator()+"Atletas: " + atletaList);
        } else {
            System.out.println("status " + response.code()+ "error" + response.errorBody());
        }
    }
}