package com.tyeporter.dwightslist.util;

import java.util.Arrays;

// TODO: Finish documenting this code...

public class ExpandableList<E> {
    // Properites
    private Object[] internal = new Object[10];
    private int limit = 10;
    private int nextEmptySpace = 0;
    private boolean isReadOnly = false;

    // =========================================================
    // Public methods
    // =========================================================

    public boolean add(E e) {
        // If is read only...
        if (this.isReadOnly) { return false; } 
        else {
            if (nextEmptySpace >= limit) {
                this.limit += 10;
                Object[] temp = new Object[this.limit];
                populateFromArray(temp, this.internal);
                temp[this.nextEmptySpace] = e;
                this.nextEmptySpace++;
                this.internal = temp;
            } else {
                this.internal[this.nextEmptySpace] = e;
                this.nextEmptySpace++;
            }
            return true;
        }
    }

    public boolean add(E[] elements) {
        // If is read only...
        if (this.isReadOnly) { return false; } 
        else { for (E element : elements) { add(element); }
            return true;
        }
    }

    public boolean remove(int index) {
        if (index >= this.internal.length || index >= this.nextEmptySpace || isReadOnly) return false;
        if (index == this.internal.length - 1) {
            this.internal[index] = null;
            this.nextEmptySpace--;
        } else {
            removeShift(index);
            this.nextEmptySpace--;

            if (this.limit != 10 && this.internal[this.limit - 11] == null) {
                this.limit -= 10;
                Object[] temp = new Object[this.limit];
                populateFromArray(temp, this.internal);
                this.internal = temp;
            }
        }
        return true;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index >= limit) throw new IndexOutOfBoundsException("Index " + index + " passes bounds " + this.limit + " of ExpandableList");

        return (E)this.internal[index];
    }

    public int size() { return this.nextEmptySpace; }

    public int getLimit() { return this.limit; }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    // =========================================================
    // Private methods
    // =========================================================

    private void populateFromArray(Object[] newArray, Object[] oldArray) {
        for (int i = 0; i < (newArray.length > oldArray.length ? oldArray.length : newArray.length); i++) {
            newArray[i] = oldArray[i];
        }
    }

    private void removeShift(int index) {
        this.internal[index] = null;
        for (int i = index; i < this.internal.length; i++) {
            if (i == this.internal.length - 1) { break; } 
            else {
                Object next = this.internal[i + 1];
                if (next == null) {
                    break;
                } else {
                    this.internal[i] = next;
                    this.internal[i + 1] = null;
                }
            }
        }
    }

    // =========================================================
    // Overidden methods
    // =========================================================

    @Override
    public String toString() { return Arrays.toString(internal); }
    
}
