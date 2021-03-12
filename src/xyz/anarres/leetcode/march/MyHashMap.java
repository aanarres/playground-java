package xyz.anarres.leetcode.march;

import java.util.ArrayList;

/**
 * Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

    put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
    get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

 * 
    All keys and values will be in the range of [0, 1000000].
    The number of operations will be in the range of [1, 10000].
    Please do not use the built-in HashMap library.

 */
public class MyHashMap {
	ArrayList<Integer> keys;
	ArrayList<Integer> values;
	
	    /** Initialize your data structure here. */
	    public MyHashMap() {
	        keys = new ArrayList<Integer>();
	        values = new ArrayList<Integer>();
	    }
	    
	    /** value will always be non-negative. */
	    public void put(int key, int value) {
	        if (keys.contains(key)) {
	        	int i = keys.indexOf(key);
	        	values.set(i, value);
	        } else {
	        	keys.add(key);
	        	values.add(value);
	        }
	    }
	    
	    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	    public int get(int key) {
	        int i = keys.indexOf(key);
	        if (i != -1) {
	        	return values.get(i);
	        }
	        return -1;
	    }
	    
	    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
	    public void remove(int key) {
	        int i = keys.indexOf(key);
	        if (i != -1 ) {
	        	keys.remove(i);
	        	values.remove(i);
	        }
	    }

	/**
	 * Your MyHashMap object will be instantiated and called as such:
	 * MyHashMap obj = new MyHashMap();
	 * obj.put(key,value);
	 * int param_2 = obj.get(key);
	 * obj.remove(key);
	 */
	public static void main(String[] args) {
		// quick test
		MyHashMap obj = new MyHashMap();
		obj.put(1, 1);
		obj.put(2, 2);
		System.out.println("returns 1: " + obj.get(1));
		System.out.println("returns -1: " + obj.get(3));
		obj.put(2, 1);
		System.out.println("returns 1: " + obj.get(2));
		obj.remove(2);
		System.out.println("returns -1: " + obj.get(2));
	}
}
