package com.example.tpmobile;

import android.icu.util.Calendar;
import android.os.Bundle;

import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class Fragment1_saisi extends Fragment  {


    private CheckBox checksport;
    private CheckBox checklecture;
    private CheckBox checkmusique;
    private CheckBox checksynchroniser;
    private EditText TNom;
    private EditText TPrenom;
    private EditText TDate;
    private EditText TNum;
    private EditText TMail;
    private Button soumettre;
    private Button telecharger;
    private Formulaire f ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rooter = inflater.inflate(R.layout.fragment1_saisi, container, false);
        TNom = (EditText)rooter.findViewById(R.id.idNom);
        TPrenom = (EditText)rooter.findViewById(R.id.idPrenom);
        TDate = (EditText)rooter.findViewById(R.id.idDate);
        TNum = (EditText)rooter.findViewById(R.id.idNum);
        TMail = (EditText)rooter.findViewById(R.id.idMail);
        TNum.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        TextWatcher tw =new TextWatcher() {
            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";
            private Calendar cal = Calendar.getInstance();
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]|\\.", "");
                    String cleanC = current.replaceAll("[^\\d.]|\\.", "");
                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2)
                        sel++;
                    if (clean.equals(cleanC)) sel--;
                    if (clean.length() < 8) clean = clean + ddmmyyyy.substring(clean.length());
                    else{
                        int day  = Integer.parseInt(clean.substring(0,2));
                        int mon  = Integer.parseInt(clean.substring(2,4));
                        int year = Integer.parseInt(clean.substring(4,8));
                        mon = mon < 1 ? 1 : mon > 12 ? 12 : mon;
                        cal.set(Calendar.MONTH, mon-1);
                        year = (year<1900)?1900:(year>2100)?2100:year;
                        cal.set(Calendar.YEAR, year);
                        day = (day > cal.getActualMaximum(Calendar.DATE))? cal.getActualMaximum(Calendar.DATE):day;
                        clean = String.format("%02d%02d%02d",day, mon, year);
                    }
                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));
                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    TDate.setText(current);
                    TDate.setSelection(sel < current.length() ? sel : current.length());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };


        TDate.addTextChangedListener(tw);





        checksport = (CheckBox)rooter.findViewById(R.id.CheckSport);
        checklecture = (CheckBox)rooter.findViewById(R.id.CheckLecture);
        checkmusique = (CheckBox)rooter.findViewById(R.id.CheckMusique);
        checksynchroniser = (CheckBox)rooter.findViewById(R.id.CheckSynchoniser);


        Lecturefichier();
        soumettre = (Button)rooter.findViewById(R.id.soumettre) ;
        soumettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changementFragment();
            }
        });

        telecharger = (Button)rooter.findViewById(R.id.telecharger) ;
        telecharger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telecharger(rooter);

            }
        });

        return rooter;
    }

    public void Lecturefichier(){
        String file_name=getActivity().getFilesDir() + "/"+"donner.json";
        File t = new File(file_name);
        if(t.exists()){
            try {
                f = new Formulaire(getActivity());
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateaffichage();
        }
    }

    public void updateaffichage(){
        TNom.setText(f.getNom());
        TPrenom.setText(f.getPrenom());
        TDate.setText(f.getDate());
        TMail.setText(f.getMail());
        TNum.setText(String.valueOf(f.getNum()));
        checksport.setChecked(f.getHobbit().get(0).isVal());
        checkmusique.setChecked(f.getHobbit().get(1).isVal());
        checklecture.setChecked(f.getHobbit().get(2).isVal());
    }
    public void telecharger(View rooter){
        RequestQueue queue = Volley.newRequestQueue(rooter.getContext());
        String url ="http://192.168.1.25:8080/formulaire/api/form";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        f = gson.fromJson(response, Formulaire.class);
                        updateaffichage();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("marche pas");
            }
        });
        queue.add(stringRequest);
    }

    public void changementFragment(){
        Bundle bundle = new Bundle();
        ArrayList<Hobbit> t = new ArrayList<>();
        t.add( new Hobbit("Sport", checksport.isChecked() ,0));
        t.add( new Hobbit("Musique", checkmusique.isChecked(),1));
        t.add( new Hobbit("Lecture", checklecture.isChecked(),2));
        f = new Formulaire(TNom.getText().toString(),TPrenom.getText().toString(),TDate.getText().toString(),TNum.getText().toString(),TMail.getText().toString(),t);
        bundle.putParcelable("FORMULAIRE" ,  f);
        bundle.putBoolean("SYNCHRONISER" ,checksynchroniser.isChecked() );
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment2_affichage fragment  = new fragment2_affichage();
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragmentContainerView , fragment);
        fragmentTransaction.commit();
    }



}