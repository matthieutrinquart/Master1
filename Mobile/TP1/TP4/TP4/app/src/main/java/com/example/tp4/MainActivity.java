package com.example.tp4;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText IDnom;
    EditText IDprenom;
    EditText IDage;
    EditText IDnumero;
    EditText IDndp;
    Formulaire f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IDnom = (EditText) findViewById(R.id.idNom);
        IDprenom = (EditText) findViewById(R.id.idPrenom);
        IDage = (EditText) findViewById(R.id.idage);
        IDnumero = (EditText) findViewById(R.id.idnum);
        IDndp = (EditText) findViewById(R.id.idmdp);
    }

    public void soumettre(View view) {

        Intent intention = new Intent(MainActivity.this, Utilisation.class);
        f = new Formulaire(IDnom.getText().toString(),IDprenom.getText().toString(),IDage.getText().toString(),IDnumero.getText().toString(),IDndp.getText().toString());
        intention.putExtra("FORMULAIRE",f);
        startActivityForResult(intention, 200);
    }

    public void planning(View view) {

        Intent intention = new Intent(MainActivity.this, planning.class);
        startActivity(intention);
    }
}