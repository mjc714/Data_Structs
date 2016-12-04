/** This class demonstrates bubble sort, in which
  * low values bubble up to the top (i.e. front) of the list
  * and high value sink to the bottom (i.e. end of the list. */
public class BubbleSort {
  
  /** Sort list using bubble sort. */
  public static void bubbleSort(int[] list) {
    
    boolean needNextPass = true;
    
    for (int k=1; k < list.length && needNextPass; k++) {
      needNextPass = false;      // pass not need until a swap occurs
      
      // last k-1 elements are already sorted;
      for (int i=0; i < list.length - k; i++) {
        if (list[i] > list[i+1]) {
          //swap them
          int temp = list[i];
          list[i] = list[i+1];
          list[i+1] = temp;
          needNextPass = true;
        }
      }
    }
  }
}