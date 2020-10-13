package com.tyeporter;

import com.tyeporter.cache.LRUCache;

public class Main {

    public static void main(String[] args) {
        // Create LRUCache object
        LRUCache myCache = new LRUCache(5);

        // Put some values in myCache
        myCache.put(2, 8);
        myCache.put(3, 4);

        // Make sure key points to the right value
        System.out.println(myCache.get(3) == 4);

        // Put more items in the myCache
        myCache.put(6, 2);
        myCache.put(7, 8);
        myCache.put(5, 9);
        myCache.put(1, 0);

        // Make sure least recently used item is removed from myCache
        System.out.println(myCache.get(2) == -1);
    }
    
}
