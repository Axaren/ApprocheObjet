package sort_bench;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;

public class SortBenchmark {
  private HashSet<SortAlgorithm> algorithms;

  public SortBenchmark() {
    this.algorithms = new HashSet<>();
  }

  public void addAlgorithm(SortAlgorithm algorithm) {
    algorithms.add(algorithm);
  }

  public void bench() {
    String[] unsorted = generateRandomStrings(100,3,10);
    System.out.println("Starting benchmark");
    System.out.println("Unsorted Strings : " + Arrays.toString(unsorted));
    for(SortAlgorithm algorithm : algorithms) {
      System.out.println("Benchmarking " + algorithm.getClass().getName());
      long startTime = System.currentTimeMillis();
      String[] sorted = algorithm.sort(unsorted);
      long stopTime = System.currentTimeMillis();
      System.out.println("Sorted array in " + (stopTime - startTime));
      System.out.println("Result : " + Arrays.toString(sorted));
    }
  }

  private static String[] generateRandomStrings(int size, int minLength, int maxLength) {
    String[] strings = new String[size];
    int leftBound = 97; // 'a'
    int rightBound = 122 + 1; // 'z'
    Random random = new Random();
    for (int i = 0; i < strings.length; i++) {
        strings[i] = String.valueOf(random
            .ints(random.nextInt(maxLength + 1) + minLength, leftBound, rightBound)
            .mapToObj(c -> Character.toString((char) c))
            .collect(Collectors.joining())
            .toCharArray());
    }
    return strings;
  }

  public static void main(String[] args) {
    SortBenchmark benchmark = new SortBenchmark();
    benchmark.addAlgorithm(new InsertSort());
    benchmark.addAlgorithm(new BubbleSort());
    benchmark.bench();
  }
}
