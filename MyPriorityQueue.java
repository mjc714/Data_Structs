/** This class demonstrates a priority queue that uses
  * an underlying heap. */
public class MyPriorityQueue<E extends Comparable<E>> {
  
  private Heap<E> heap = new Heap<E>();
  
  /** Add an object to the queue. */
  public void enqueue(E newObject) {
    heap.add(newObject);
  }
  
  /** Remove the highest priority object from the queue and
    * return it. */
  public E dequeue() {
    return heap.remove();
  }
  
  /** Return the size of the queue. */
  public int getSize() {
    return heap.getSize();
  }
  
  /** An inner class representing a patient. This is 
    * used to test the queue. */
  static class Patient implements Comparable<Patient> {
    private String name;    // patient's name
    private int priority;   // patient's priority for care
    
    /** Constructor for a new patient. */
    public Patient(String name, int priority) {
      this.name = name;
      this.priority = priority;
    }
    
    /** Return a string describing the patient. */
    public String toString() {
      return name + "(priority: " + priority + ")";
    }
    
    /** Compare this patient to another based on priority. Because
      * we implement Comparable<Patient> (instead of the raw type Comparable),
      * our compareTo argument must be Patient, not Object. */
    public int compareTo(Patient o) {
      return this.priority - ((Patient)o).priority;
    }
  }
  
  /** Test the program with three patients. */
  public static void main (String args[]) {
    MyPriorityQueue<Patient> pq = new MyPriorityQueue<Patient>();
    pq.enqueue(new Patient("Anakin Skywalker", 90));
    pq.enqueue(new Patient("Rambo", 1));
    pq.enqueue(new Patient("John Doe", 10));
    while (pq.getSize() > 0) {
      System.out.println(pq.dequeue());
    }
  }
}