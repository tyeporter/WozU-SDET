package com.tyeporter.recreatelinkedlist.util;

/***********************************************************
 * NiceLinkedList is a superficial and incomplete 
 * implementation of a linked list
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-16-2020
 ***********************************************************/

public class NiceLinkedList<T> {
    // Properties
    // A linked list will only have one properpty: head
    private NiceNode<T> head;

    // =========================================================
    // Constructors
    // =========================================================

    public NiceLinkedList(T value) {
        // Create new Node object of type T (Any object type)
        NiceNode<T> node = new NiceNode<>(value);
        this.head = node;
    }

    // =========================================================
    // Private methods
    // =========================================================

    private NiceNode<T> getNode(int index) {
        // Check for null head (Nothing in linked list)
        if (head == null) return null; 

        // Create a variable that represents node's "position"
        int currentPosition = 0;
        // Create a variable that references "current" node
        NiceNode<T> currentNode = this.head;

        while (currentNode != null) { // We've not reached the end of the linked list
            // If current position is equal position passed in
            if (currentPosition == index) return currentNode;
            // Move foward
            currentNode = currentNode.getNext(); 
            currentPosition++;
        }

        // Return null if item not found
        return null;
    }

    // =========================================================
    // Public methods
    // =========================================================

    /***********************************************************
     * Adds an item to the {@code NiceLinkedList}
     * 
     * @param value The value to be added
     ***********************************************************/
    public void add(T value) {
        // Create new Node object of type T (Any object type)
        NiceNode<T> node = new NiceNode<>(value);

        // Check for null head (Nothing in linked list)
        if (head == null) {
           this.head = node;
           return; 
        }

        // Iterate through the linked list to find the "last" node
        NiceNode current = this.head;
        while (current.getNext() != null) { // The last node will return null for .getNext()
            current = current.getNext();
        }

        // Set the node passed in as the last node's next value
        current.setNext(node);
    }

    /***********************************************************
     * Adds an item to a specific index in the 
     * {@code NiceLinkedList}
     * 
     * @param value The value to be added
     ***********************************************************/
    public void add(int index, T value) {
        // Create new Node object of type T (Any object type)
        NiceNode<T> node = new NiceNode<>(value);

        // Check for null head (Nothing in linked list)
        if (head == null && index == 0) {
            this.head = node;
            return; 
        } else if (head == null && index != 0 || index > this.size() - 1) {
            // TODO: Refactor to throw exception instead
            /* Logging / Debugging */
            System.out.println("No items in linked list or index greater than list size, therefore unable to add " + value + " at position " + index + ".");
            return;
        }

        if (index == 0) {
            // Set the node's head to the current head
            node.setNext(this.head);
            // Set the LinkedList's head to the node
            this.head = node;
        } else {
            // Get nodes that will surround new Node
            NiceNode<T> previousNode = getNode(index - 1);
            NiceNode<T> replacedNode = previousNode.getNext();
            // Set the next value of Node in front of new Node to the new Node
            previousNode.setNext(node);
            // Set the next value of new Node to the node that used to be in this position / index
            node.setNext(replacedNode);
        }
    }

    /***********************************************************
     * Retrieves an item at a specific index in the 
     * {@code NiceLinkedList}
     * 
     * @return an item of {@code T} type and {@code null} 
     * if item not found
     * @param index The index of the item to get
     ***********************************************************/
    public T get(int index) {
        // Check for null head (Nothing in linked list)
        if (head == null) return null; 

        // Create a variable that represents node's "position"
        int currentPosition = 0;
        // Create a variable that references "current" node
        NiceNode<T> currentNode = this.head;

        while (currentNode != null) { // We've not reached the end of the linked list
            // If current position is equal position passed in
            if (currentPosition == index) return currentNode.getValue();
            // Move foward
            currentNode = currentNode.getNext(); 
            currentPosition++;
        }

        // Return null if item not found
        return null;
    }

    /***********************************************************
     * Removes the head of the {@code NiceLinkedList}
     * 
     * @return the removed item of {@code T} type and
     * {@code null} if there are no items
     ***********************************************************/
    public T remove() {
        // Check for null head (Nothing in linked list)
        if (head == null) return null;

        // Create a variable referecing head Node
        NiceNode<T> previousHead = this.head;
        // Create a variable referencing previous head's next value
        NiceNode<T> headsNext = previousHead.getNext();

        // Set head to previous head's next if not null
        if (headsNext != null) {
            this.head = headsNext;
            // TODO: Check on this...
            // Dereference new next node (Not sure if this will have impact on memory???)
            previousHead.setNext(null);
        }

        // Return previous head 
        return previousHead.getValue();
    }

    /***********************************************************
     * Removes an item at a specific index in the 
     * {@code NiceLinkedList}
     * 
     * @return the removed item of {@code T} type and {@code null} 
     * if item not found
     * @param index The index of the item to be removed
     ***********************************************************/
    public T remove(int index) {
        // Check for null head (Nothing in linked list)
        if (head == null) return null;

        // Get node at index
        NiceNode<T> currentNode = this.getNode(index);

        if (index == 0) { // If index is zero
            this.remove();
        } else {
            if (currentNode != null) {
                // Get surrounding nodes of Node to remove
                NiceNode<T> previousNode = getNode(index - 1);
                NiceNode<T> nextNode = currentNode.getNext();

                // Set the value of previous Node's next value to the Node that came after current Node
                previousNode.setNext(nextNode);
                // Dereference new next node (Not sure if this will have impact on memory???)
                currentNode.setNext(null);
            }
        }

        return currentNode.getValue();
    }

    /***********************************************************
     * Removes an item with a specific value in the 
     * {@code NiceLinkedList}
     * 
     * @return the removed item of {@code T} type and {@code null} 
     * if item not found
     * @param t the {@code T} value to be removed
     ***********************************************************/
    public T remove(T t) {
        // Check for null head (Nothing in linked list)
        if (head == null) return null;

        // Create a variable that represents node's "position"
        int currentPosition = 0;
        // Create a variable that references "current" node
        NiceNode<T> currentNode = this.head;

        while (currentNode != null) { // We've not reached the end of the linked list
            if (currentNode.getValue().equals(t)) {  // If current Node's value equals the value passed in...
                if (currentPosition == 0) { // If current position is equal to zero
                    // The next Node of head Node the head Node
                    this.head = currentNode.getNext();
                    // Dereference new next node (Not sure if this will have impact on memory???)
                    currentNode.setNext(null);
                } else {
                    // Get surrounding nodes
                    NiceNode<T> previousNode = getNode(currentPosition - 1);
                    NiceNode<T> nextNode = currentNode.getNext();

                    // Set the value of previous Node's next value to the Node that came after current Node
                    previousNode.setNext(nextNode);
                    // Dereference new next node (Not sure if this will have impact on memory???)
                    currentNode.setNext(null);
                }
                break;
            }

            // Move foward
            currentNode = currentNode.getNext();
            currentPosition++;
        }

        return currentNode.getValue();
    }

    /***********************************************************
     * Retrieves the size of the {@code NiceLinkedList}
     * 
     * @return the {@code int} number of items type in the list
     ***********************************************************/
    public int size() {
        int count = 0;
        NiceNode<T> currentNode = this.head;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.getNext();
        }

        return count;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        NiceNode<T> currentNode = this.head;

        for (int i = 0; i < this.size(); i++) {
            builder.append("(Node: " + currentNode.getValue() + ")");
            currentNode = currentNode.getNext();
        }

        return builder.toString();
    }
    

}