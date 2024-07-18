package org.example.Repository;

import org.example.Models.Coffee;

import java.util.ArrayList;
import java.util.List;

public class SortedDataRepository implements DataRepository {

    private static SortedDataRepository INSTANCE;

    private SortedDataRepository() {
    }

    public static SortedDataRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SortedDataRepository();
        }
        return INSTANCE;
    }

    private List<Coffee> coffeeList = new ArrayList<>();

    @Override
    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    @Override
    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }
}
