package org.example;

import org.example.Client_interface.ClientInterface;
import org.example.DataGeneration.DataGeneration;
import org.example.DataGeneration.RandomGeneration;
import org.example.Repository.GenerationDataRepository;
import org.example.Sorting.LibrarySort;
import org.example.Sorting.SmoothSort;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Main {
    public static void main(String[] args) {
        ClientInterface clientInterface = new ClientInterface();
        clientInterface.starClientInterface();
    }

    @Param({"10", "100"})
    static int iterations;

    @Setup
    public void setMap() {
        DataGeneration dataGeneration = new RandomGeneration();
        dataGeneration.setDataRepository(GenerationDataRepository.getInstance());
        int count = 10000;
        dataGeneration.dataGeneration(count);
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void LibrarySortTestFullRebalance() {
        LibrarySort librarySort = new LibrarySort();
        for (int i = 0; i < iterations; i++) {
            librarySort.sortArray(false);
        }
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void LibrarySortTestLocalRebalance() {
        LibrarySort librarySort = new LibrarySort();
        for (int i = 0; i < iterations; i++) {
            librarySort.sortArray(true);
        }
    }

    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void SmoothSortTest() {
        SmoothSort smoothSort = new SmoothSort();
        for (int i = 0; i < iterations; i++) {
            smoothSort.sortArray();
        }
    }
}