package recurision.primenumbers;

/**
 *
 * @author Eoin
 */
import java.util.HashMap;



public class HashTableWithDynamicPrimes {
    private int capacity;
    private HashMap<Integer, String> table;
    private int size;

    public HashTableWithDynamicPrimes(int initialCapacity) {
        this.capacity = findNextPrime(initialCapacity);
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
            capacity = findNextPrime(2 * capacity); 
            rehash();
        }

        System.out.println("Inserted key " + key + " at index " + index);
    }

    public String get(int key) {
        int index = key % capacity;

        while (table.containsKey(index)) {
            if (table.get(index) != null && index == key) {
                System.out.println("Retrieved key " + key + " from index " + index);
                return table.get(index);
            }
            // Collision: Linear probing
            index = (index + 1) % capacity;
        }

        System.out.println("Key " + key + " not found in the table.");
        return null;
    }

    private void rehash() {
        HashMap<Integer, String> newTable = new HashMap<>(capacity);

        for (int key : table.keySet()) {
            newTable.put(key % capacity, table.get(key));
        }

        table = newTable;
        System.out.println("Rehashed to new capacity: " + capacity);
    }

    private int findNextPrime(int n) {
        //
        boolean[] isPrime = new boolean[n * 2];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p < isPrime.length; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < isPrime.length; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        for (int i = n + 1; i < isPrime.length; i++) {
            if (isPrime[i]) {
                return i;
            }
        }
        return n * 2; 
    }
}

