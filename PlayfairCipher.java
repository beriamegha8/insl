import java.util.*;

public class PlayfairCipher {
    static char[][] matrix = new char[5][5];
    static String key = "MONARCHY";

    static void generateMatrix() {
        String keyString = key.toUpperCase().replaceAll("J", "I") + "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : keyString.toCharArray()) set.add(c);

        Iterator<Character> it = set.iterator();
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                matrix[i][j] = it.next();
    }

    static String prepare(String text) {
        text = text.toUpperCase().replaceAll("J", "I").replaceAll("\\s+", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(text.charAt(i));
            if (i < text.length() - 1 && text.charAt(i) == text.charAt(i + 1)) sb.append('X');
        }
        if (sb.length() % 2 != 0) sb.append('X');
        return sb.toString();
    }

    static String encryptPair(char a, char b) {
        int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == a) { r1 = i; c1 = j; }
                if (matrix[i][j] == b) { r2 = i; c2 = j; }
            }
        if (r1 == r2) return "" + matrix[r1][(c1 + 1) % 5] + matrix[r2][(c2 + 1) % 5];
        else if (c1 == c2) return "" + matrix[(r1 + 1) % 5][c1] + matrix[(r2 + 1) % 5][c2];
        else return "" + matrix[r1][c2] + matrix[r2][c1];
    }

    public static void main(String[] args) {
        generateMatrix();
        String text = "HIDETHEGOLD";
        String prepared = prepare(text);
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < prepared.length(); i += 2)
            encrypted.append(encryptPair(prepared.charAt(i), prepared.charAt(i + 1)));
        System.out.println("Encrypted Text: " + encrypted);
    }
}
