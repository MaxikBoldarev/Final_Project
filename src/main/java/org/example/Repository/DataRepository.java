package org.example.Repository;

import org.example.Models.Coffee;

import java.util.List;

public interface DataRepository {

    List<Coffee> getCoffeeList();
    void setCoffeeList(List<Coffee> coffeeList);
}
