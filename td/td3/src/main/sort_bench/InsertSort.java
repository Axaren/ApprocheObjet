package sort_bench;

public class InsertSort implements SortAlgorithm {

  public String[] sort(String[] unsorted) {
    String[] sorted = unsorted.clone();
    for (int i = 1; i < sorted.length; i++) {
      String key = sorted[i];
      int j = i - 1;

      while(j >= 0 && sorted[j].compareTo(key) > 0) {
        sorted[j+1] = sorted[j];
        j--;
      }
      sorted[j+1] = key;
    }
    return sorted;
  }
}
