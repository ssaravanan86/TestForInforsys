package com.example.infosysprogram;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.infosysprogram.test.R;
import com.example.infosysprogram.test.databinding.FirstFileBinding;

import adapter.listLoadingAdapter;
import api.RetrofitCallFunction;
import model.Dataclass;


public class MainActivity extends AppCompatActivity {


     private RetrofitCallFunction  retorfitCall;

      private FirstFileBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_file);

        binding =    DataBindingUtil.setContentView(this, R.layout.first_file);
        binding.contentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //binding.se
        binding.executePendingBindings();

       // binding.

        ConnectivityManager ConnectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()==true )
        {
            mehtodForAPI();

        }
        else
        {
            Toast.makeText(MainActivity.this, "Network Not Available", Toast.LENGTH_SHORT).show();

        }


    }

   public void mehtodForAPI()
    {
        retorfitCall = new RetrofitCallFunction(this , new  RetrofitCallFunction.DatatoPass() {
            @Override
            public void onSuccess(Dataclass response) {
                binding.contentRecyclerView.setAdapter(new listLoadingAdapter(response.rows));
                //   binding.
            }
            @Override
            public void onFailure(Object t) {
                Toast.makeText(getApplicationContext(), "Error = "+t.toString(), Toast.LENGTH_LONG).show();
            }
        });

        retorfitCall.execute();
    }


    }

