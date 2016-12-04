/** This class demonstrates merge sort. This is a recursive method
  * which splits the list into two halves, and the recursively sorts
  * the halves. Once it has two sorted half-lists, it merges them
  * into a single sorted list. */
public class MergeSort {
  
  /** Sort a list using merge sort. */
  public static void mergeSort(int[] list) {
    if (list.length > 1) {
      // merge sort  the first half
      int[] firstHalf = new int[list.length/2];
      System.arraycopy(list, 0, firstHalf, 0, list.length/2);
      mergeSort(firstHalf);
      
      // merge sort the second half
      int secondHalfLength = list.length - list.length/2;
      int[] secondHalf = new int[secondHalfLength];
      System.arraycopy(list, list.length/2, secondHalf, 0, secondHalfLength);
      mergeSort(secondHalf);
      
      // merge two halves
      int[] temp = merge(firstHalf, secondHalf);
      System.arraycopy(temp, 0, list, 0, temp.length);
    }
  }
  
  /** The recursive helper method for the merge. */
  private static int[] merge(int[] list1, int[] list2) {
    int[] temp = new int[list1.length + list2.length];
    int current1 = 0; // index in list 1
    int current2 = 0; // index in list 2
    int current3 = 0; // index in temp
    
    // as long as neither index is at the end, compare them
    // and copy the smaller value to temp
    while (current1 < list1.length && current2 < list2.length) {
      if (list1[current1] < list2[current2])
        temp[current3++] = list1[current1++];
      else
        temp[current3++] = list2[current2++];
    }
    
    // copy remaining values from list1 to temp
    while (current1 < list1.length)
      temp[current3++] = list1[current1++];
    
    // copy remaining values from list2 to temp
    while (current2 < list2.length)
      temp[current3++] = list2[current2++];
    return temp;
  }
  
}