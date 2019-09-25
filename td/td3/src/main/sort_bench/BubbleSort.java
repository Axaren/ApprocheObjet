package sort_bench;

public class BubbleSort implements SortAlgorithm {

  private void swap(String[] arr, int i, int j) {
    String tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  @Override
  public String[] sort(String[] unsorted) {
    String[] sorted = unsorted.clone();
    for (int i = 0; i < sorted.length - 1; i++) {
      for (int j = 0; j < sorted.length - i - 1; j++) {
        if (sorted[j].compareTo(sorted[j+1]) > 0)
          swap(sorted,j,j+1);
      }
    }
    return sorted;
  }
}
