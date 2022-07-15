package com.example.tp4.repository;

import androidx.room.*;
import com.example.tp4.model.Planning;

import java.util.List;

@Dao
public interface PlanningDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Planning plan);

    @Query("SELECT * FROM planning")
    List<Planning> getAll();
    @Query("SELECT * FROM planning WHERE pid IN (:planIds)")
    List<Planning> loadAllByIds(int[] planIds);
    @Query("SELECT * FROM planning WHERE date IN (:planDate)")
    Planning loadAllByDate(String planDate);

    @Query("SELECT creneau1 FROM planning WHERE date IN (:planDate)")
    String loadAllByDatec1(String planDate);

    @Query("SELECT creneau2 FROM planning WHERE date IN (:planDate)")
    String loadAllByDatec2(String planDate);

    @Query("SELECT creneau3 FROM planning WHERE date IN (:planDate)")
    String loadAllByDatec3(String planDate);

    @Query("SELECT creneau4 FROM planning WHERE date IN (:planDate)")
    String loadAllByDatec4(String planDate);



    @Delete
    void delete(Planning plan);

}
