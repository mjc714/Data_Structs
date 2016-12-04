import java.util.Arrays;

/** This class demonstrates heap sort. */
public class HeapSort {
  
  public static void heapSort(int[] list) {
    
    // Create a heap to store and organize the values. */
    Heap<Integer> heap = new Heap<Integer>();
    
    // add all elements to the heap
    for (int i=0; i<list.length; i++)
      heap.add(list[i]);
    
    // remove the elements from the heap and add to list, from right to left
    for (int i=list.length-1; i>=0; i--)
      list[i] = heap.remove();
  }
  
  /** Test the algorithm. */
  public static void main(String[] args) {
    int[] list = {6, 2, 8, 1, 9, 15, 3, -1};
    heapSort(list);
    System.out.println(Arrays.toString(list));
  }
}