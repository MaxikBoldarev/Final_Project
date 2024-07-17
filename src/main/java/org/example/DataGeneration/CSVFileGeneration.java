package org.example.DataGeneration;

import com.opencsv.CSVReader;
import org.example.Models.Coffee;
import org.example.Repository.GenerationDataRepository;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVFileGeneration {
    private final GenerationDataRepository generationDataRepository;

    public CSVFileGeneration(GenerationDataRepository generationDataRepository) {
        this.generationDataRepository = generationDataRepository;
    }

    public List<String[]> readAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                csvReader.readNext(); // пропускаем хедеры
                return csvReader.readAll();
            }
        }
    }

    public void dataGeneration(int count) {

        Path path = Paths.get("src/main/resources/Data.csv");

        List<String[]> allLines;

        try {
            allLines = readAllLines(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<Coffee> coffeeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] line = allLines.get(i % allLines.size());
            Coffee coffee = Coffee.builder()
                    .id(i)
                    .paymentType(line[1])
                    .price(Integer.parseInt(line[2]))
                    .typeOfCoffee(line[3])
                    .build();

            coffeeList.add(coffee);
            generationDataRepository.setCoffeeList(coffeeList);
        }
        System.out.println("Способ генерации 'Загрузка из файла' выполнена");
    }
}