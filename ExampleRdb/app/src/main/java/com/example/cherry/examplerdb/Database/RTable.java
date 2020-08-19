package com.example.cherry.examplerdb.Database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "StudentDetails")
public class RTable {

    @PrimaryKey
    @NonNull
    String roll;

    @NonNull
    public String getRoll() {
        return roll;
    }

    public void setRoll(@NonNull String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    String name,number;
}
