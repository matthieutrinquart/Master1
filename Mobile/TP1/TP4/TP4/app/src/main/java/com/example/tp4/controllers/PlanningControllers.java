package com.example.tp4.controllers;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;
import com.example.tp4.model.Planning;
import com.example.tp4.repository.AppDataBase;
import com.example.tp4.repository.PlanningDao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanningControllers extends ViewModel {


    private PlanningDao plandao;



    public void init(Context context){
        AppDataBase db = Room.databaseBuilder(context,AppDataBase.class,"database-name").allowMainThreadQueries().build();
        this.plandao = db.planningDao();
        Planning n1 = new Planning(0,"16/04/2022","TRAVAILLE1","TRAVAILLE1","TRAVAILLE1","TRAVAILLE1");
        Planning n2 = new Planning(1,"17/04/2022","TRAVAILLE2","TRAVAILLE2","TRAVAILLE2","TRAVAILLE2");
        Planning n3 = new Planning(2,"18/04/2022","TRAVAILLE3","TRAVAILLE3","TRAVAILLE3","TRAVAILLE3");
        Planning n4 = new Planning(3,"19/04/2022","TRAVAILLE4","TRAVAILLE4","TRAVAILLE4","TRAVAILLE4");
        this.plandao.insert(n1);
        this.plandao.insert(n2);
        this.plandao.insert(n3);
        this.plandao.insert(n4);


    }
    public Planning getPlanning() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        return plandao.loadAllByDate(formatter.format(now));

    }

    public String getCreneaux1() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        return plandao.loadAllByDatec1(formatter.format(now));
    }
    public String getCreneaux2() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        return plandao.loadAllByDatec2(formatter.format(now));
    }
    public String getCreneaux3() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        return plandao.loadAllByDatec3(formatter.format(now));
    }
    public String getCreneaux4() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        return plandao.loadAllByDatec4(formatter.format(now));
    }

    @Override
    protected void onCleared(){
        super.onCleared();
    }


}
