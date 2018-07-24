package com.example.infosysprogram;

import android.databinding.DataBindingUtil;
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

