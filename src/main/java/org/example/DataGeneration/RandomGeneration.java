package org.example.DataGeneration;

import org.example.Enum.PaymentType;
import org.example.Enum.TypeOfCoffee;
import org.example.Models.Coffee;
import org.example.Repository.DataRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGeneration extends DataGeneration {

    @Override
    public void setDataRepository(DataRepository dataRepository) {
        super.setDataRepository(dataRepository);
    }

    @Override
    public void dataGeneration(int count) {
        List<Coffee> coffeeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Coffee coffee = new Coffee.CoffeeBuilder()
                    .id(i)
                    .paymentType(PaymentType.getRandomPaymentType().toString())
                    .price(new Random().nextInt(1000))
                    .typeOfCoffee(TypeOfCoffee.getRandomTypeOfCoffee().toString())
                    .build();

            coffeeList.add(coffee);
            super.getDataRepository().setCoffeeList(coffeeList);
        }
        System.out.println("Способ генерации 'Случайный' выполнен");
    }
}
