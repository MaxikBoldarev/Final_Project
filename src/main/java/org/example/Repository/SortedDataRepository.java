package org.example.Repository;

import org.example.Models.Coffee;

import java.util.ArrayList;
import java.util.List;

public class SortedDataRepository {
    private List<Coffee> coffeeList = new ArrayList<>();

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }
}
