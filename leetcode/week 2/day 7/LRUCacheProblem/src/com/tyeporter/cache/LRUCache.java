package com.tyeporter.cache;

import java.util.Stack;
import java.util.HashMap;

/***********************************************************
 * LRUCache is a superficial implementation of a cache 
 * used to solve the "LRU Cache" LeetCode problem:
 * 
 * https://leetcode.com/problems/lru-cache
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-13-2020
 ***********************************************************/

 // TODO: Make implementation more efficient

public class LRUCache {

    // Properties
    private int capacity;
    private Stack<Integer> keyOrder;
    private HashMap<Integer, Integer> cache;

    // =========================================================
	// Constructors
	// =========================================================

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyOrder = new Stack<>();
        this.cache = new HashMap<>();
    }

    // =========================================================
	// Getters
    // =========================================================
    
    public int getCapacity() {
        return capacity;
    }
    
    public int get(int key) {
        if (cacheContains(key)) {
            removeDuplicateKeyFromKeyOrder(key);
            mostRecentlyUsedKey(key);
            return cache.get(key); 
        }
        return -1;
    }

    // =========================================================
	// Setters
	// =========================================================
    
    public void put(int key, int value) {
        if (!cacheContains(key)) { 
            cache.put(key, value); 
            removeLRU();
        } else { 
            cache.replace(key, value); 
            removeDuplicateKeyFromKeyOrder(key);
        }
        
        mostRecentlyUsedKey(key);
    }

    // =========================================================
	// Helpers
	// =========================================================

    private void mostRecentlyUsedKey(int key) {
        this.keyOrder.add(0, key);
    }

    private void removeDuplicateKeyFromKeyOrder(int key) {
        keyOrder.removeElement(key);
    }

    private void removeLRU() {
        if (keyOrder.size() == capacity) {
             Integer removedKey = keyOrder.remove(capacity - 1);
             cache.remove(removedKey);
        }
    }

    private boolean cacheContains(int key) {        
        return keyOrder.contains(key) && cache.containsKey(key);
    }

    // =========================================================
	// Overrides
	// =========================================================

    @Override
    public String toString() {
        return this.cache.toString();
    }

}
