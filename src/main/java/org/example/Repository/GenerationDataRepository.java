package org.example.Repository;

import org.example.Models.Coffee;

import java.util.ArrayList;
import java.util.List;

public class GenerationDataRepository {

    private List<Coffee> coffeeList = new ArrayList<>();

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public int[] getCoffeeListForSorted() {
        int[] coffeeArray = new int[coffeeList.size()];
        for (int i = 0; i < coffeeList.size(); i++) {
            Coffee coffee = coffeeList.get(i);
            coffeeArray[i] = coffee.getPrice();
        }
        return coffeeArray;
    }

    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }
}
