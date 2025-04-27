public class RailFenceCipher {
    public static String encrypt(String text, int key) {
        StringBuilder[] rail = new StringBuilder[key];
        for (int i = 0; i < key; i++) rail[i] = new StringBuilder();
        int dir = 1, row = 0;

        for (char c : text.toCharArray()) {
            rail[row].append(c);
            row += dir;
            if (row == 0 || row == key - 1) dir *= -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rail) result.append(sb);
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "HELLO";
        int key = 2;
        String encrypted = encrypt(text, key);
        System.out.println("Encrypted: " + encrypted);
    }
}
