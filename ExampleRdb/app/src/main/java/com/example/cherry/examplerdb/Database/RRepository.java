package com.example.cherry.examplerdb.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RRepository {
    RDatabase rDatabase;
    LiveData<List<RTable>> list;

    public RRepository(Application application){
        rDatabase = RDatabase.getrDatabase(application);
        list = rDatabase.rDao().getAll();
    }
    public void insert(RTable rTable){
        new InsertTask().execute(rTable);
    }
    public void delete(RTable rTable){
        new DeleteTask().execute(rTable);
    }
    public void update(RTable rTable){
        new UpdateTask().execute(rTable);
    }
    class InsertTask extends AsyncTask<RTable,Void,Void>{
        @Override
        protected Void doInBackground(RTable... rTables) {
            for (int i=0;i<rTables.length;i++){
                rDatabase.rDao().insert(rTables[i]);
            }
            return null;
        }
    }
    public LiveData<List<RTable>> readAllData(){
        return list;
    }
    class DeleteTask extends AsyncTask<RTable,Void,Void>{
        @Override
        protected Void doInBackground(RTable... rTables) {
            rDatabase.rDao().delete(rTables[0]);
            return null;
        }
    }
    class UpdateTask extends AsyncTask<RTable,Void,Void>{
        @Override
        protected Void doInBackground(RTable... rTables) {
            rDatabase.rDao().update(rTables[0]);
            return null;
        }
    }


}
