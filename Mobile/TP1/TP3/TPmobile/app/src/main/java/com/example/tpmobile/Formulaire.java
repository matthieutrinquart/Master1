package com.example.tpmobile;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class Formulaire implements Parcelable {

    private long id = 0;
    private String nom;
    private String prenom;
    private String date;
    private String num;
    private String mail;
    private ArrayList<Hobbit> hobbit;

    public Formulaire(String nom, String prenom, String date, String num, String mail, ArrayList<Hobbit> hobbit) {
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.num = num;
        this.mail = mail;
        this.hobbit = hobbit;
    }
    public  Formulaire(Context context) throws IOException {
        InputStream input = context.openFileInput("donner.json");
        byte[] buffer=new byte[input.available()];
        input.read(buffer);
        input.close();
        String text=new String(buffer);
        Gson gson = new Gson();
        Formulaire f = gson.fromJson(text, Formulaire.class);
        this.nom = f.nom;
        this.prenom = f.prenom;
        this.date = f.date;
        this.num = f.num;
        this.mail =f.mail;
        this.hobbit = f.hobbit;
    }


    protected Formulaire(Parcel in) {
        id = in.readLong();
        nom = in.readString();
        prenom = in.readString();
        date = in.readString();
        num = in.readString();
        mail = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(date);
        dest.writeString(num);
        dest.writeString(mail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Formulaire> CREATOR = new Creator<Formulaire>() {
        @Override
        public Formulaire createFromParcel(Parcel in) {
            return new Formulaire(in);
        }

        @Override
        public Formulaire[] newArray(int size) {
            return new Formulaire[size];
        }
    };

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate() {
        return this.date;
    }

    public String getNum() {
        return num;
    }

    public String getMail() {
        return mail;
    }

    public ArrayList<Hobbit> getHobbit() {
        return hobbit;
    }

    public void ecrire(Context context){
        try {
            FileOutputStream fOut = context.openFileOutput("donner.json",0);
            Gson gson = new Gson();
            String json = gson.toJson(this);
            fOut.write(json.getBytes());
            fOut.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



}



