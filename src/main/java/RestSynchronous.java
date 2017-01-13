import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
        Response<List<Atleta>> response = call.execute();

        if (response.isSuccessful()) {
            List<Atleta> atletaList = response.body();
            System.out.println(System.lineSeparator() + "Atletas: " + atletaList);
        } else {
            System.out.println("status " + response.code() + "error" + response.errorBody());
        }

        Call<List<Atleta>> call2 = atletaService.getAtletasByNacionalidad("Peru");
        Response<List<Atleta>> response2 = call2.execute();
        if (response2.isSuccessful()) {
            List<Atleta> atletaList = response2.body();
            System.out.println(System.lineSeparator() + "Atletas: " + atletaList);
        } else {
            System.out.println("Status code: " + response2.code() + "Message error: " + response2.errorBody());
        }

// get post delete

        Atleta atleta = new Atleta();
        atleta.setNombre("Pepe");
        atleta.setApellidos("Sancho");

        Call<Atleta> callAtleta = atletaService.createAtleta(atleta);
        Response<Atleta> responseAtleta = callAtleta.execute();
        if (responseAtleta.isSuccessful()) {
            Atleta atletaResp = responseAtleta.body();
            System.out.println("Status code: " + responseAtleta.code() + System.lineSeparator() +
                    "POST player: " + atletaResp);
            callAtleta = atletaService.updateAtleta(atletaResp);
            responseAtleta= callAtleta.execute();

            System.out.println("Status code: " + responseAtleta.code() + System.lineSeparator() +
                    "PUT player: " + responseAtleta.body());


        Call<Void> callDelete = atletaService.deleteAtleta(atletaResp.getId());
            Response<Void> responseDelete= callDelete.execute();
        System.out.println("DELETE status code: " + responseDelete.code());
        call = atletaService.getAtletas();
        response= call.execute();
        System.out.println("Comprobación del delete " +
                "Status code: " + response.code() + System.lineSeparator() +
                "GET players: " + response.body());
    } else {
        System.out.println("Status code: " + responseAtleta.code() +
                "Message error: " + responseAtleta.errorBody());
    }
    }
}