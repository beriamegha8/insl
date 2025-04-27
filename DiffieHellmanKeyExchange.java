public class DiffieHellman {
    public static void main(String[] args) {
        int p = 23, g = 5;
        int a = 6; // Alice's private key
        int b = 15; // Bob's private key

        int A = (int)(Math.pow(g, a) % p);
        int B = (int)(Math.pow(g, b) % p);

        int keyA = (int)(Math.pow(B, a) % p);
        int keyB = (int)(Math.pow(A, b) % p);

        System.out.println("Alice's Key: " + keyA);
        System.out.println("Bob's Key: " + keyB);
    }
}
