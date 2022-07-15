package com.example.tp4.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Planning {
    @PrimaryKey
    public int pid;

    @ColumnInfo(name = "Date")
    public String date;

    @ColumnInfo(name = "creneau1")
    public String creneau1;

    @ColumnInfo(name = "creneau2")
    public String creneau2;

    @ColumnInfo(name = "creneau3")
    public String creneau3;

    @ColumnInfo(name = "creneau4")
    public String creneau4;

    public Planning(int pid, String date, String creneau1, String creneau2, String creneau3, String creneau4) {
        this.pid = pid;
        this.date = date;
        this.creneau1 = creneau1;
        this.creneau2 = creneau2;
        this.creneau3 = creneau3;
        this.creneau4 = creneau4;
    }

    public int getPid() {
        return pid;
    }

    public String getDate() {
        return date;
    }

    public String getCreneau1() {
        return creneau1;
    }

    public String getCreneau2() {
        return creneau2;
    }

    public String getCreneau3() {
        return creneau3;
    }

    public String getCreneau4() {
        return creneau4;
    }
}
