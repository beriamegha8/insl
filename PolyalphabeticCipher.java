public class PolyalphabeticCipher {
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char c = (char)((text.charAt(i) + key.charAt(i % key.length()) - 2 * 'A') % 26 + 'A');
            result.append(c);
        }
        return result.toString();
    }

    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char c = (char)((text.charAt(i) - key.charAt(i % key.length()) + 26) % 26 + 'A');
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "HELLO";
        String key = "KEY";
        String encrypted = encrypt(text, key);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypt(encrypted, key));
    }
}
