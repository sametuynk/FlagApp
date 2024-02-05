package com.example.flagapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.flagapp.databinding.ActivityQuizBinding;

import java.util.ArrayList;
import java.util.HashSet;

public class QuizActivity extends AppCompatActivity {

    private ActivityQuizBinding binding;
    private ArrayList<Bayraklar>sorularListe;
    private ArrayList<Bayraklar>yanlisSeceneklerListe;
    private Bayraklar dogruSoru;
    private Database db;
    //SAYAÇLAR
    private int soruSayac=0;
    private int yanlisSayac=0;
    private int dogruSayac=0;
    //SEÇENEKLER
    private HashSet<Bayraklar>secenekleriKaristirmaListe=new HashSet<>();
    private ArrayList<Bayraklar>seceneklerListe=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db=new Database(this);
        sorularListe=new BayraklarDao().rastgele5Getir(db);
        soruYukle();
        binding.buttonA.setOnClickListener(v -> {
            dogruKontrol(binding.buttonA);
            sayacKontrol();

        });
        binding.buttonB.setOnClickListener(v -> {
            dogruKontrol(binding.buttonB);
            sayacKontrol();
        });
        binding.buttonC.setOnClickListener(v -> {
            dogruKontrol(binding.buttonC);
            sayacKontrol();
        });
        binding.buttonD.setOnClickListener(v -> {
            dogruKontrol(binding.buttonD);
            sayacKontrol();
        });
    }
    public void soruYukle(){
        binding.textViewSoruSayaci.setText((soruSayac+1)+". SORU");
        binding.textViewDogru.setText("Doğru :"+dogruSayac);
        binding.textViewYanlis.setText("Yanlış :"+yanlisSayac);


        dogruSoru=sorularListe.get(soruSayac);
        yanlisSeceneklerListe=new BayraklarDao().rastgele3YanlisSecenekGetir(db,dogruSoru.getBayrak_id());
        binding.imageViewBayrak.setImageResource(getResources().getIdentifier(dogruSoru.getBayrak_resim(),"drawable",getPackageName()));

        secenekleriKaristirmaListe.clear();
        secenekleriKaristirmaListe.add(dogruSoru);
        secenekleriKaristirmaListe.add(yanlisSeceneklerListe.get(0));
        secenekleriKaristirmaListe.add(yanlisSeceneklerListe.get(1));
        secenekleriKaristirmaListe.add(yanlisSeceneklerListe.get(2));

        seceneklerListe.clear();
        for (Bayraklar b:secenekleriKaristirmaListe){
            seceneklerListe.add(b);
        }
        binding.buttonA.setText(seceneklerListe.get(0).getBayrak_ad());
        binding.buttonB.setText(seceneklerListe.get(1).getBayrak_ad());
        binding.buttonC.setText(seceneklerListe.get(2).getBayrak_ad());
        binding.buttonD.setText(seceneklerListe.get(3).getBayrak_ad());



    }
    public void dogruKontrol(Button button){

        String buttonYazi=button.getText().toString();
        String dogruCevap=dogruSoru.getBayrak_ad();

        if (buttonYazi.equals(dogruCevap)){
            dogruSayac++;
        }else{
            yanlisSayac++;
        }


    }
    public void sayacKontrol(){
        soruSayac++;
        if (soruSayac!=5){
            soruYukle();
        }else{

            Intent intent=new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("dogruSayac",dogruSayac);
            startActivity(intent);
            finish();
        }

    }













}