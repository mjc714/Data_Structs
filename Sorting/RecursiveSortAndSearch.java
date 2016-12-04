/** This class demonstrates how recursive helper methods can
  * be used to do selection sort and binary search. */
public class RecursiveSortAndSearch {
  
  /** Sort a list of doubles using recursive selection sort. */
  public static void sort(double[] list) {
    sort(list, 0);
  }
  
  /** A recursive helper method for sort(double[]). The low 
    * parameter is the index where the next sorted element
    * should be placed. */
  public static void sort(double[] list, int low) {
    if (low < list.length-1) {
      
      // find minimum element
      int indexOfMin = low;
      double min = list[low];
      for (int i = low + 1; i <= list.length-1; i++) {
        if (list[i] < min) {
          min = list[i];
          indexOfMin = i;
        }
      }
      
      // swap
      list[indexOfMin] = list[low];
      list[low] = min;
      
      // sort the remaining list
      sort(list, low+1);
    }
    // nothing happens on the base case, a list of length 1 is always sorted
  }
  
  /** Find the index of a key in a sorted list of doubles using 
    * recursive binary search. */
  public static int binarySearch(double[] list, double key) {
    return binarySearch(list, key, 0, list.length-1);
  }
  
  /** A recursive helper method for binarySearch(double[],double). Low and high
    * are the start and end indexes of the sublist to search. */
  public static int binarySearch(double[] list, double key, int low, int high) {
    if (low > high)                     // not found
      return -low - 1;
    int mid = (low + high) / 2;
    if (key < list[mid])                  // must search in first half of array
      return binarySearch(list, key, low, mid - 1);
    else if (key == list[mid])                // found it!
      return mid;
    else                                    // must search in second half of array
      return binarySearch(list, key, mid + 1, high);
  }
  
  public static void main(String[] args) {
    double[] list = {5.2, 1.3, 6.4, 3.2, 4.8};
    
    // first sort the list
    sort(list);
    
    // note list.toString() just prints out the reference to the array
    // Arrays.toString() "pretty prints" the array.
    System.out.println("Sorted list: " + java.util.Arrays.toString(list));
    
    // then look for a key
    int i = binarySearch(list, 5.2);
    System.out.println("Index of 5.2 in sorted list is: " + i);
    
  }

}