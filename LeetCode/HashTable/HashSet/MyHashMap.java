package com.example.hash;

/**
 * Demo class
 *
 * @author HengruiLiao
 * @date 2018/11/22
 */
public class MyHashMap {
    Bucket[] buckets = new Bucket[1000000];


    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {

    }

    /**
     * value will always be positive.
     */
    public void put(int key, int value) {

        Bucket bucket = new Bucket(key, value);
        buckets[key] = bucket;

    }

    public void remove(int key) {
        if (contains(key)) {
            buckets[key] = null;
        }
    }


    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        if (contains(key)) {
            return buckets[key].val;
        }
        return -1;
    }

    /**
     * Returns true if this set did not already contain the specified element
     */
    public boolean contains(int key) {
        if (buckets[key] == null) {
            return false;
        }
        return true;
    }

    class Bucket {
        int key;
        int val;

        public Bucket(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


}
