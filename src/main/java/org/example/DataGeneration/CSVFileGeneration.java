package org.example.DataGeneration;

import com.opencsv.CSVReader;
import org.example.Models.Coffee;
import org.example.Repository.DataRepository;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVFileGeneration extends DataGeneration {
    @Override
    public void setDataRepository(DataRepository dataRepository) {
        super.setDataRepository(dataRepository);
    }

    public List<String[]> readAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                csvReader.readNext();
                return csvReader.readAll();
            }
        }
    }

    @Override
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
            super.getDataRepository().setCoffeeList(coffeeList);
        }
        System.out.println("Способ генерации 'Загрузка из файла' выполнена");
    }
}