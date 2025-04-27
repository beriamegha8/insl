public class RSAFull {
    
    // Function to calculate GCD
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Function to calculate Modular Inverse
    public static int modInverse(int e, int phi) {
        for (int d = 1; d < phi; d++) {
            if ((e * d) % phi == 1) return d;
        }
        return -1; // If modular inverse doesn't exist
    }

    // Function to perform modular exponentiation
    public static int modPow(int base, int exponent, int mod) {
        int result = 1;
        base = base % mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1)
                result = (result * base) % mod;
            exponent = exponent >> 1;
            base = (base * base) % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        // Step 1: Choose two prime numbers
        int p = 3, q = 11;

        // Step 2: Calculate n and phi
        int n = p * q;           // n = 33
        int phi = (p - 1) * (q - 1); // phi = 20

        // Step 3: Choose e such that 1 < e < phi and gcd(e, phi) = 1
        int e;
        for (e = 2; e < phi; e++) {
            if (gcd(e, phi) == 1) break;
        }

        // Step 4: Calculate d such that (d * e) % phi = 1
        int d = modInverse(e, phi);

        // Display Public and Private Keys
        System.out.println("Public Key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private Key (d, n): (" + d + ", " + n + ")");

        // Step 5: Encrypt a message
        int message = 7; // Example message
        int cipher = modPow(message, e, n);
        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Cipher: " + cipher);

        // Step 6: Decrypt the message
        int decrypted = modPow(cipher, d, n);
        System.out.println("Decrypted Message: " + decrypted);
    }
}
