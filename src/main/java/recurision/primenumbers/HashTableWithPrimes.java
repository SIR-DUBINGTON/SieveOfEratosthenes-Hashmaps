/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recurision.primenumbers;

import java.util.HashMap;

/**
 *
 * @author Eoin
 */
public class HashTableWithPrimes {
    private int capacity;
    private HashMap<Integer, String> table;
    private int size;

    public HashTableWithPrimes(int capacity) {
        this.capacity = findNextPrime(capacity);
        this.table = new HashMap<>(this.capacity);
        this.size = 0;
    }
    public void put(int key, String value) {
        int index = key % capacity;

        while (table.containsKey(index)) {
            index = (index + 1) % capacity;
        }

        table.put(index, value);
        size++;

        if ((double) size / capacity > 0.75) {
            rehash();
        }
    }

    public String get(int key) {
        int index = key % capacity;

        while (table.containsKey(index)) {
            if (table.get(index) != null && index == key) {
                return table.get(index);
            }
            index = (index + 1) % capacity;
        }

        return null;
    }

    private void rehash() {
        int newCapacity = findNextPrime(2 * capacity);
        HashMap<Integer, String> newTable = new HashMap<>(newCapacity);

        for (int key : table.keySet()) {
            newTable.put(key % newCapacity, table.get(key));
        }

        table = newTable;
        capacity = newCapacity;
    }

    private int findNextPrime(int n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}