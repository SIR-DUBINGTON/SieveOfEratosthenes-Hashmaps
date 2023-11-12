/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package recurision.primenumbers;

/**
 *
 * @author Eoin
 */
public class PrimeNumbers {

    public static void main(String[] args) {
        HashTableWithDynamicPrimes hashTable = new HashTableWithDynamicPrimes(1000);

        // Insert key-value pairs
        hashTable.put(1, "Value 1");
        hashTable.put(2, "Value 2");
        hashTable.put(3, "Value 3");
        hashTable.put(500, "Value 500");

        // Retrieve values
        String value1 = hashTable.get(1);
        String value2 = hashTable.get(2);
        String value3 = hashTable.get(3);

        hashTable.put(1, "Duplicate Value");

        String duplicateValue = hashTable.get(1);
        // Retrieve and print values
        System.out.println("Value for key 1: " + hashTable.get(1));
        System.out.println("Value for key 2: " + hashTable.get(2));
        System.out.println("Value for key 3: " + hashTable.get(3));
        System.out.println("Value for key 4: " + hashTable.get(4));
    }
}
