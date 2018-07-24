package api;

import model.Dataclass;

import retrofit2.Call;
import retrofit2.http.GET;


public interface CallInterface {

    /* the class for providing the list of api methods calling with end parameters */

    //https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json
    @GET("facts?")
     Call<Dataclass> parsingJSONAPI();
}

