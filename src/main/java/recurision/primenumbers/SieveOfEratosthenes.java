/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recurision.primenumbers;

/**
 *
 * @author Eoin
 */
public class SieveOfEratosthenes {
    public static boolean[] findPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        return isPrime;
    }
}
