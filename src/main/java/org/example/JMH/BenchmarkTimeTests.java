package org.example.JMH;

import org.example.DataGeneration.DataGeneration;
import org.example.DataGeneration.RandomGeneration;
import org.example.Repository.GenerationDataRepository;
import org.example.Sorting.LibrarySort;
import org.example.Sorting.SmoothSort;

public class BenchmarkTimeTests {
    public static void main(String[] args) {
        int[] times = new int[]{100, 1000, 10000};
        DataGeneration dataGeneration = new RandomGeneration();
        dataGeneration.setDataRepository(GenerationDataRepository.getInstance());
        LibrarySort librarySort = new LibrarySort();
        SmoothSort smoothSort = new SmoothSort();
        for (int time : times) {
            dataGeneration.dataGeneration(time);
            double startTime = System.currentTimeMillis();
            librarySort.sortArray(true);
            double finishTime = System.currentTimeMillis();
            System.out.println("Библиотечная сортировка с локальной пере балансировкой на "
                    + time + " данных за "
                    + (finishTime - startTime) / 1000
                    + " миллисекунды\n");
        }
        for (int time : times) {
            dataGeneration.dataGeneration(time);
            double startTime = System.currentTimeMillis();
            librarySort.sortArray(false);
            double finishTime = System.currentTimeMillis();
            System.out.println("Библиотечная сортировка с полной пере балансировкой на "
                    + time + " данных за "
                    + (finishTime - startTime) / 1000
                    + " миллисекунды\n");
        }
        for (int time : times) {
            dataGeneration.dataGeneration(time);
            double startTime = System.currentTimeMillis();
            smoothSort.sortArray();
            double finishTime = System.currentTimeMillis();
            System.out.println("Плавная сортировка на "
                    + time + " данных за "
                    + (finishTime - startTime) / 1000
                    + " миллисекунды\n");
        }
    }
}
