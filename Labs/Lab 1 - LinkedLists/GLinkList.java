class GLinkList {
    GNode<String> llist;   //Type is String

    GLinkList( int sz ) {
 if ( sz <= 0 ) {
     llist = null;
 }
 else {
     // start with list of size 1
   llist = new GNode<String>( "0", null ); 
     GNode<String> current = llist; // temp node for loop
     // add further nodes
     for ( int i=1; i<sz; ++i ) {
  // create node and attach it to the list
  GNode<String> node2Add = new GNode<String>( Integer.toString(i), null );
  current.setNext(node2Add);   // add first node
  current=node2Add;
     }
 }
    }
    
    /**
     * Print all the elements of the list assuming that they are Strings
     */
    public void print() {
 /* Print the list */
 GNode<String> current = llist; // point to the first node
 while (current != null) {
     System.out.print((String)current.getElement() + " "); 
     current = current.getNext(); // move to the next
 }
 System.out.println(); 
    }

    public void deleteFirst() {
 if ( llist != null ) {
     llist = llist.getNext();
 }
    }

    public void deleteLast() {
 if ( llist == null ) return; // no node
 GNode<String> prev = llist;
 GNode<String> current = prev.getNext(); 
 if ( current == null ) { // only 1 node
     llist = null;
     return;
 }
 while ( current.getNext() != null ) { // more than 1 node
     prev = current;
     current = current.getNext();
 }
 prev.setNext( null );
 return;
    }

    // create and display a linked list
    public static void main(String [] args){
 /* Create the list */
 GLinkList llist = new GLinkList( 5 );
 /* Print the list */
 llist.print();
 /* delete first and print */
 llist.deleteFirst();
 llist.print();
 /* delete last and print 5 times */
 for ( int i=0; i< 5; ++i ) {
     llist.deleteLast();
     llist.print();
 }
    }
}
