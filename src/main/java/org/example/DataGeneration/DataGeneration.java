package org.example.DataGeneration;

import org.example.Repository.DataRepository;

public abstract class DataGeneration {

    private DataRepository dataRepository;

    public abstract void dataGeneration(int count);

    public DataRepository getDataRepository() {
        return dataRepository;
    }

    public void setDataRepository(DataRepository dataRepository){
        this.dataRepository = dataRepository;
    }
}
