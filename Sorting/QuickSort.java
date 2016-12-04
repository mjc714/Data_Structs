/** This program demonstrates the quick sort algorithm */
public class QuickSort  {
  
  /** Sort a list of integers using quick sort. */
  public static void quickSort(int[] list) {
    quickSort(list, 0, list.length - 1);
  }
  
  /** The recusrive helper method for quickSort(int[]) */
  private static void quickSort(int[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);            // sort the lower partition
      quickSort(list, pivotIndex + 1, last);             // sort the upper partition
    }
  }
   
   
  /** Choose a pivot and partition the list into two sets: the elements
    * less than the pivot and the elements greater than the pivot. Place
    * the pivot between these two sets and return its index. */
  private static int partition(int[] list, int first, int last) {
    int pivot = list[first];   // we'll just select the first element, there are better ways
    int low = first + 1;
    int high = last;
    while (high > low) {
      // look for the leftmost element > pivot
      while (low <= high && pivot >= list[low])
        low++;
      // look for the rightmost element <= pivot
      while (low <= high && pivot < list[high])
        high--;
      
      // if we found a pair of out-of-place elements, swap them
      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }
    
    // find where pivot needs to be placed (move high down until it is < pivot)
    while (high > first && list[high] >= pivot)
      high--;
    
    // swap pivot with list[high]
    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else                  // this case is needed if the low partition is empty
      return first;
  }
  
  /** Test the algorithm. */
  public static void main(String[] args) {
    int[] list = {6, 2, 8, 1, 9, 15, 3, -1};
    quickSort(list);
    System.out.println(java.util.Arrays.toString(list));
  }
  
}
    
 