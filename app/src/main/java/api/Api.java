package api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    /* the class for base set up of the retrofit as by given URL */

    private static Retrofit retrofit = null;

    public static final String URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
