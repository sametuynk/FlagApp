package com.example.flagapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.flagapp.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;
    private int dogruSayac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dogruSayac=getIntent().getIntExtra("dogruSayac",0);

        binding.textViewSonuc.setText(dogruSayac+" DOĞRU "+(5-dogruSayac)+" YANLIŞ");
        binding.textViewYuzdeSonus.setText("% "+(dogruSayac*100)/5+" BAŞARI");

        binding.buttonTekrar.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), QuizActivity.class));
            finish();
        });
    }
}