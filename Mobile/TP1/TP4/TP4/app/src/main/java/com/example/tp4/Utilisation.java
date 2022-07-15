package com.example.tp4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Utilisation extends AppCompatActivity {

    private int nbClics ;
    Bundle extras ;
    Formulaire f;
    Button retour;
    TextView Tnom;
    TextView Tprenom;
    TextView Tage;
    TextView Tnum;
    TextView Tmdp;
    TextView Tnombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilisation);
        Tnom = (TextView)findViewById(R.id.idnomaff) ;
        Tprenom = (TextView)findViewById(R.id.idprenomaff) ;
        Tage = (TextView)findViewById(R.id.idageaff) ;
        Tnum = (TextView)findViewById(R.id.idnumaff) ;
        Tmdp = (TextView)findViewById(R.id.idmdpaff) ;
        Tnombre = (TextView)findViewById(R.id.idnombre) ;
        retour = (Button) findViewById(R.id.button2) ;

        extras = getIntent().getExtras();
        f = extras.getParcelable("FORMULAIRE");
        Tnom.setText(f.getNom());
        Tprenom.setText(f.getPrenom().toString());
        Tage.setText(f.getAge().toString());
        Tnum.setText(f.getNum().toString());
        Tmdp.setText(f.getMdp().toString());
    }
    public void retour(View view) {

        Intent intention = new Intent(Utilisation.this, MainActivity.class);
        startActivity(intention);

    }

    public void Nombreutilisation() {
        ++this.nbClics;
        System.out.println("fonction : " + nbClics);
    }
    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        this.nbClics = sharedPref.getInt("nbClick",0);
        System.out.println("Lecture : " + nbClics);
        Nombreutilisation();
        Tnombre.setText(String.valueOf(this.nbClics));

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        System.out.println("Stop : " + nbClics);
        editor.putInt("nbClick", nbClics);
        editor.apply();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}