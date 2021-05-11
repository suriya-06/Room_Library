package com.example.room_library.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Contact")
public class Contact {
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "occupation")
    private String occupation;

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }



    public Contact(@NonNull String name, @NonNull String occupation) {
        this.name = name;
        this.occupation = occupation;
    }


}
