package api;

import android.content.Context;

import model.Dataclass;
 import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetrofitCallFunction {



    private retrofit2.Call<Dataclass> call;
    private DatatoPass data;
    private String city;
    public static final int RESP_OK       = 200;

    public RetrofitCallFunction(Context context, DatatoPass datainteface) {
        this.data = datainteface;

      }

    /* the method is for executing the retrofit and storing the response values
    into interface show that can be colelcted in activity */
    public void execute() {

        CallInterface callInterface = Api.getClient().create(CallInterface.class);
           call = (Call<Dataclass>) callInterface.parsingJSONAPI();
        call.enqueue(new Callback<Dataclass>() {
            @Override
            public void onResponse(retrofit2.Call<Dataclass> call, Response<Dataclass> response) {
                int statusCode = response.code();
                 if(statusCode == RESP_OK) {
                     data.onSuccess(response.body());
               } else {
                     data.onFailure("On Failure - " + statusCode);
                }

            }
            @Override
            public void onFailure(retrofit2.Call<Dataclass> call, Throwable t) {
                data.onFailure(t.getMessage());

            }
        });
    }

    /* crating an interface to update in activity by passing the response values in retrofit*/

    public interface DatatoPass {
        void onSuccess(Dataclass content);
        void onFailure(Object t);
    }

}
