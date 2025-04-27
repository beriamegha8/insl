import java.util.Random;

public class ElGamal {
    public static void main(String[] args) {
        int p = 23;
        int g = 5;
        int x = 6; // Private key
        int y = (int)(Math.pow(g, x) % p); // Public key

        int m = 15; // Message
        Random rand = new Random();
        int k = rand.nextInt(p - 2) + 1; // Random number

        int a = (int)(Math.pow(g, k) % p);
        int b = (int)(m * Math.pow(y, k) % p);

        System.out.println("Cipher: (" + a + ", " + b + ")");

        int m_decrypted = (int)(b * Math.pow(a, p - 1 - x) % p);
        System.out.println("Decrypted Message: " + m_decrypted);
    }
}
