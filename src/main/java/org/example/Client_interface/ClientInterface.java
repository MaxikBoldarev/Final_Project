package org.example.Client_interface;

import org.example.DataGeneration.CSVFileGeneration;
import org.example.DataGeneration.RandomGeneration;
import org.example.DataGeneration.UserGeneration;
import org.example.Models.Coffee;
import org.example.Repository.GenerationDataRepository;
import org.example.Repository.SortedDataRepository;
import org.example.Sorting.LibrarySort;
import org.example.Sorting.SmoothSort;

import java.util.Scanner;

public class ClientInterface {
    private final GenerationDataRepository generationDataRepository = new GenerationDataRepository();
    private final SortedDataRepository sortedDataRepository = new SortedDataRepository();
    private final UserGeneration userGeneration = new UserGeneration(generationDataRepository);
    private final RandomGeneration randomGeneration = new RandomGeneration(generationDataRepository);
    private final CSVFileGeneration csvFileGeneration = new CSVFileGeneration(generationDataRepository);
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
        System.out.println("Укажите кол-во строк в документе:");
        int count = scanner.nextInt();
        switch (choice) {
            case 1:
                userGeneration.dataGeneration(count);
                break;
            case 2:
                randomGeneration.dataGeneration(count);
                break;
            case 3:
                csvFileGeneration.dataGeneration(count);
                break;
            default:
                System.out.println("Ошибка ввода! Пожалуйста, введите число соответствующее выбранной команде");
                break;
        }
    }

    public void choiceMethodSorted() {
        System.out.println("""
                Какой вариант сортировки предоставить?
                1. Библиотечная(локальная перебалансировка).
                2. Библиотечная(полная перебалансировка).
                3. Плавная.
                Введите номер в консоль:
                """);

        LibrarySort librarySort = new LibrarySort(generationDataRepository, sortedDataRepository);
        SmoothSort smoothSort = new SmoothSort(generationDataRepository, sortedDataRepository);

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                librarySort.sortArray(false);
                break;
            case 2:
                librarySort.sortArray(true);
                break;
            case 3:
                smoothSort.sort();
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
        switch (choice) {
            case 1:
                for (Coffee coffee : generationDataRepository.getCoffeeList()) {
                    System.out.println(coffee);
                }
                break;
            case 2:
                for (Coffee coffee : sortedDataRepository.getCoffeeList()) {
                    System.out.println(coffee);
                }
                break;
            default:
                System.out.println("Ошибка ввода! Пожалуйста, введите число соответствующее выбранной команде");
                break;
        }
    }
}
