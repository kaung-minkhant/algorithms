public class MergeSort {

  private void Sort(String[] input, int start, int end) {
    if (start == end-1) {
      return;
    }
    int mid = (int) Math.floor((start + end) / 2.0f);
    System.out.println("Mid: " + mid);
    Sort(input, start, mid);
    Sort(input, mid, end);
    MergeTwoHalves(input, start, mid, end);
  }


  private void MergeTwoHalves(String[] input, int start, int mid, int end) {
    int N = end - start;
    String[] aux = new String[N];
    int i = start, j = mid, k = 0;
    while (k < N) {
      if (i == mid)
        aux[k++] = input[j++];
      else if (j == end)
        aux[k++] = input[i++];
      if (i != mid && j != end + 1) {
        if (input[i].compareTo(input[j]) < 0)
          aux[k++] = input[i++];
        else
          aux[k++] = input[j++];
      }
    }
    for (i = 0; i < N; i++) {
      input[start + i] = aux[i];
    }
  }

  public static void main(String[] args) {
    MergeSort ms = new MergeSort();
    String[] input = { "a", "c", "b", "e", "i", "k" };
    ms.Sort(input, 0, input.length);
    for (int i = 0; i < input.length; i++) {
      System.out.println(input[i]);
    }
  }
}

// start = 5 end = 6
// mid = 5 + 6 = 11 / 2 = 5.5 = 6
// N = end - start =
// 1 3 4 5 2 8 7
// (1 3 4 5) (2 8 7)
// (1 3) (4 5) (2 8) (7)
// (1) (3) (4) (5) (2) (8) (7)
// (1 3) (4 5) (2 8) (7)
// (1 3 4 5) (2 7 8)
// (1 2 3 4 5 7 8)