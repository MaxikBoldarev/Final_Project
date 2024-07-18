package org.example.Client_interface;

import org.example.DataGeneration.CSVFileGeneration;
import org.example.DataGeneration.DataGeneration;
import org.example.DataGeneration.RandomGeneration;
import org.example.DataGeneration.UserGeneration;
import org.example.Models.Coffee;
import org.example.Repository.DataRepository;
import org.example.Repository.GenerationDataRepository;
import org.example.Repository.SortedDataRepository;
import org.example.Sorting.LibrarySort;
import org.example.Sorting.SmoothSort;

import java.util.Scanner;

public class ClientInterface {
    private final Scanner scanner = new Scanner(System.in);

    public void starClientInterface() {
        boolean bool = true;
        while (bool) {
            System.out.println("""
                    Привет, это приложение для генерации и сортировки покупок Кофе.
                    Функции:
                    1. Генерация данных
                    2. Просмотр полученных данных
                    3. Выбор способа сортировки
                    4. Выход из программы
                    Введите номер в консоль:
                    """);

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    choiceGeneration();
                    break;
                case 2:
                    choiceMethodOutput();
                    break;
                case 3:
                    choiceMethodSorted();
                    break;
                case 4:
                    System.out.println("Программа завершена");
                    scanner.close();
                    bool = false;
                    break;
                default:
                    System.out.println("Ошибка ввода! Пожалуйста, введите число соответствующее выбранной команде");
                    break;
            }
        }
    }

    private void choiceGeneration() {
        System.out.println("""
                Какой способ генерации данных предпочитаете?
                1. Ручную.
                2. Случайную
                3. Загрузку из файла.
                Введите номер в консоль:
                """);

        int choice = scanner.nextInt();
        DataGeneration dataGeneration;
        switch (choice) {
            case 1:
                dataGeneration = new UserGeneration();
                break;
            case 2:
                dataGeneration = new RandomGeneration();
                break;
            case 3:
                dataGeneration = new CSVFileGeneration();
                break;
            default:
                System.out.println("Ошибка ввода! Пожалуйста, введите число соответствующее выбранной команде");
                return;
        }
        System.out.println("Укажите кол-во строк в документе:");
        int count = scanner.nextInt();
        dataGeneration.setDataRepository(GenerationDataRepository.getInstance());
        dataGeneration.dataGeneration(count);
    }

    public void choiceMethodSorted() {
        System.out.println("""
                Какой вариант сортировки предоставить?
                1. Библиотечная(локальная перебалансировка).
                2. Библиотечная(полная перебалансировка).
                3. Плавная.
                Введите номер в консоль:
                """);

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                new LibrarySort().sortArray(false);
                break;
            case 2:
                new LibrarySort().sortArray(true);
                break;
            case 3:
                new SmoothSort().sortArray();
                break;
            default:
                System.out.println("Ошибка ввода! Пожалуйста, введите число соответствующее выбранной команде");
                break;
        }
    }

    public void choiceMethodOutput() {
        System.out.println("""
                Какой вариант данных предоставить?
                1. Сгенерированные.
                2. Отсортированные.
                Введите номер в консоль:
                """);
        int choice = scanner.nextInt();
        DataRepository dataRepository;
        switch (choice) {
            case 1:
                dataRepository = GenerationDataRepository.getInstance();
                break;
            case 2:
                dataRepository = SortedDataRepository.getInstance();
                break;
            default:
                System.out.println("Ошибка ввода! Пожалуйста, введите число соответствующее выбранной команде");
                return;
        }
        for (Coffee coffee : dataRepository.getCoffeeList()) {
            System.out.println(coffee);
        }
    }
}
