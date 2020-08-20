package com.example.cherry.examplerdb.Database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RViewModel extends AndroidViewModel {
    RRepository rRepository;
    LiveData<List<RTable>> list;
    public RViewModel(@NonNull Application application) {
        super(application);
        rRepository = new RRepository(application);
        list = rRepository.readAllData();
    }
    public void insert(RTable rTable){
        rRepository.insert(rTable);
    }
    public LiveData<List<RTable>> readData(){
        return list;
    }
    public void delete(RTable rTable){
        rRepository.delete(rTable);
    }
    public void update(RTable rTable){
        rRepository.update(rTable);
    }
}
