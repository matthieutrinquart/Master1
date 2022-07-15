package com.example.tp4.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.tp4.model.Planning;
import com.example.tp4.repository.PlanningDao;

@Database(entities ={Planning.class},version =1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract PlanningDao planningDao();
}
