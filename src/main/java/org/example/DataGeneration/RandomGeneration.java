package org.example.DataGeneration;

import org.example.Enum.PaymentType;
import org.example.Enum.TypeOfCoffee;
import org.example.Models.Coffee;
import org.example.Repository.GenerationDataRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGeneration {
    private final GenerationDataRepository generationDataRepository;

    public RandomGeneration(GenerationDataRepository generationDataRepository) {
        this.generationDataRepository = generationDataRepository;
    }

    // Метод создает классы с рандомными данными и передает их в репозиторий
    public void dataGeneration(int count) {
        List<Coffee> coffeeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Coffee coffee = new Coffee.CoffeeBuilder()
                    .id(new Random().nextInt(count * 10))
                    .paymentType(PaymentType.getRandomPaymentType().toString())
                    .price(new Random().nextInt(1000))
                    .typeOfCoffee(TypeOfCoffee.getRandomTypeOfCoffee().toString())
                    .build();

            coffeeList.add(coffee);
            generationDataRepository.setCoffeeList(coffeeList);
        }
        System.out.println("Способ генерации 'Случайный' выполнен");
    }
}
