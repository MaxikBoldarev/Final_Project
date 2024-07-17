package org.example.DataGeneration;

import org.example.Models.Coffee;
import org.example.Repository.GenerationDataRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UserGeneration {
    private final GenerationDataRepository generationDataRepository;

    public UserGeneration(GenerationDataRepository generationDataRepository) {
        this.generationDataRepository = generationDataRepository;
    }

    public void dataGeneration(int count) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число больше 0");
        int number = scanner.nextInt();
        if (number <= 0) {
            System.out.println("Число равно или меньше 0");
        } else {
            System.out.println("""
                    Введите названия Кофе через ';' в одну строку.
                    Слова будут использованы для генерации""");
            String letter = scanner.next();
            String[] coffeeArray = letter.trim().split(";");

            System.out.println("Введите способы оплаты через ';' в одну строку");
            String payment = scanner.next();
            String[] paymentArray = payment.trim().split(";");

            if (letter.trim().length() <= 6) {
                System.out.println("Слово меньше или равно 6 символам");
            } else {
                List<Coffee> coffeeList = new ArrayList<>();

                for (int i = 1; i <= count; i++) {
                    Coffee coffee = new Coffee.CoffeeBuilder()
                            .id(i)
                            .paymentType(paymentArray[new Random().nextInt(paymentArray.length)])
                            .price(new Random().nextInt(number + 1))
                            .typeOfCoffee(coffeeArray[new Random().nextInt(coffeeArray.length)])
                            .build();

                    coffeeList.add(coffee);
                    generationDataRepository.setCoffeeList(coffeeList);
                }
                System.out.println("Способ генерации 'Ручной' выполнен");
            }
        }
    }
}
