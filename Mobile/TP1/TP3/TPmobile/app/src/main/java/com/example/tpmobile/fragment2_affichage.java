package com.example.tpmobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class fragment2_affichage extends Fragment {

        private TextView Tnom;
        private TextView Tprenom;
        private TextView Tdate;
        private TextView Tnum;
        private TextView Tmail;

        private ListView listView;
        private Button valider;
        private Button retour;
        private Formulaire f;
        private boolean synchroniser;





        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View root =  inflater.inflate(R.layout.fragment2_affichage, container, false);


            f = (Formulaire) this.getArguments().getParcelable("FORMULAIRE");
            synchroniser = this.getArguments().getBoolean("SYNCHRONISER");

            Tnom = (TextView)root.findViewById(R.id.idnom);
            Tprenom = (TextView)root.findViewById(R.id.idprenom);
            Tdate = (TextView)root.findViewById(R.id.idDate);
            Tmail = (TextView)root.findViewById(R.id.idMail);
            Tnum = (TextView)root.findViewById(R.id.idNum);
            Tnom.setText(f.getNom());
            Tprenom.setText(f.getPrenom());
            Tdate.setText(f.getDate());
            Tmail.setText(f.getMail());
            Tnum.setText(String.valueOf(f.getNum()));
            List<String> tab = new ArrayList<String>();

            for(Hobbit u: f.getHobbit()){
                if(u.isVal())
                    tab.add(u.getNom());
            }



            listView = (ListView)root.findViewById(R.id.listView) ;

            ListAdaptateur1 adapter = new ListAdaptateur1(getActivity(),tab);
            listView.setAdapter(adapter);


            valider = (Button)root.findViewById(R.id.valider) ;
            valider.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(synchroniser){
                        try {
                            Postrequest();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                 f.ecrire(getActivity());
            }});

            retour = (Button)root.findViewById(R.id.retour) ;
            retour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ChangementFragment();
                }});



            return root;
    }

    public void ChangementFragment(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment1_saisi fragment  = new Fragment1_saisi();
        fragmentTransaction.replace(R.id.fragmentContainerView , fragment);
        fragmentTransaction.commit();
    }

    public void Postrequest() throws JSONException {
        Gson gson = new Gson();
        String json = gson.toJson(f);
        JSONObject parameters = new JSONObject(json);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "http://192.168.1.25:8080/formulaire/api/formulaire";
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(jsonRequest);
    }
}
