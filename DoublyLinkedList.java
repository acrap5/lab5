/*
 * DoublyLinkedList
 * 
 * This class implements the Java List interface using a doubly-linked list.
 * 
 * A nested ListNode class is included.
 * 
 */
import java.util.*;

public class DoublyLinkedList<T> extends AbstractList<T> {
   int size;
   ListNode header, trailer;
   
   /*
    * ListNode
    * 
    * This nested class represents one node in a doubly linked list.
    */
   protected class ListNode {
      T datum;
      ListNode prior, next;

       ListNode(){
	   this(null);
       }
      
       ListNode(T data){
	   this(data,null,null);
       }
      
       ListNode(T data, ListNode prior, ListNode next){
	   this.datum = data;
	   this.prior = prior;
	   this.next = next;
       }
   } // end of class ListNode
   
   /*
    * Constructs an empty list.
    */
   DoublyLinkedList(){
       this.header = new ListNode(null);
       this.trailer = new ListNode(null, this.header, null);
       this.header.next = this.trailer;
   }
   
   /*
    * Returns a reference to the nth node in the list.
    */
   private ListNode getNthNode(int n) {
       int i = 0;
       ListNode node = header.next;
       if (n < 0 || n > size - 1) {
	   throw new IndexOutOfBoundsException("Index is Outside Range List");
       }
       while (i != n) {
	   node = node.next;
	   i++;
       }
       return node;
   }

   /*
    * Returns a count of the number of elements in the list.
    */
   public int size() {
      return size;
   }
   
   /*
    * Returns the data item at the given position in the list.
    */
   public T get(int position) {
       int i = 0;
       ListNode node = header.next;
       if (position < 0 || position > size - 1) {
	   throw new IndexOutOfBoundsException("Index is Outside Range List");
       }
       while (i != position) {
	   node = node.next;
	   i++;
       }
       return node.datum;
   }
   
   /*
    * Replaces the item at the given position with the
    * given data item.  The return value is the element
    * that is replaced.
    */
   public T set(int position, T data) {
       int i = 0;
       ListNode node = header.next;
       if (position < 0 || position > size - 1) {
	   throw new IndexOutOfBoundsException("Index is Outside Range List");
       }
       while (i != position) {
	   node = node.next;
	   i++;
       }
       T set = node.datum;
       node.datum = data;
       return set;
   }
   
   /*
    * Inserts the given data item at the end of the list.
    */
   public boolean add(T data) {
       ListNode node = new ListNode(data, trailer.prior, trailer);
       return true;
   }
   
   /*
    * Inserts the given data item at the given position in the list.
    */
   public void add(int position, T data) {
       ListNode node = new ListNode(data);
       int i = 0;
       if (data == null) {
	   throw new NullPointerException("Data is Null");
       }
       if (position < 0 || position > size - 1) {
	   throw new IndexOutOfBoundsException("Index is Outside Range List");
       }
       node = header.next;
       while (i != position) {
	   node = node.next;
	   i++;
       }
   }
   
   /*
    * Removes the element at a given index in the list.
    */
   public T remove(int index) {
       ListNode node = header.next;
       int i = 0;
       if (index < 0 || index > size - 1) {
	   throw new IndexOutOfBoundsException("Index is Outside Range List");
       }
       while (i != index) {
	   node = node.next;
	   i++;
       }
       T remove = node.datum;
       node.datum = null;
       node.next.prior= node.prior;
       return remove;
   }
   
   /*
    * Searches the list for the given object
    */
   public boolean contains(Object obj){
       ListNode node = header.next;
       if (header.next != trailer) {
	   for (int i =  0; i < size; i++) {
	       if (node.datum.equals(obj)) {
		   return true;
	       } else {
		   node = node.next;
	       }
	   }
       }
       return false;
   }

   /*
    * Returns the position of the given object
    */
   public int indexOf(Object obj){
       // TODO: Write the contains method
       return -1; // replace this line to return the position of obj
   }
   
   /*
    * Deletes all elements from the list.
    */
   public void clear() {
       // TODO: Write the clear method
   }
   
   /*
    * Determines if the list is empty.
    */
   public boolean isEmpty() {
      return size==0;
   }
   
   /*
    * Returns an iterator for this list
    */
   public Iterator<T> iterator(){
       // TODO: Write the iterator method
       return null;  /* replace this line */
   }
}

