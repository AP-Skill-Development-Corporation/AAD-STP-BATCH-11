package com.example.cherry.examplerdb.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RDao {

    @Query("Select * from StudentDetails")
    LiveData<List<RTable>> getAll();

    @Insert
    void insert(RTable rTable);

    @Delete
    void delete(RTable rTable);

    @Update
    void update(RTable rTable);
}
