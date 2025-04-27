public class HillCipher {
    static int[][] keyMatrix = { {3, 3}, {2, 5} };

    public static String encrypt(String text) {
        text = text.toUpperCase().replaceAll("\\s", "");
        if (text.length() % 2 != 0) text += "X";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            int[] vector = {text.charAt(i) - 'A', text.charAt(i+1) - 'A'};
            int e1 = (keyMatrix[0][0]*vector[0] + keyMatrix[0][1]*vector[1]) % 26;
            int e2 = (keyMatrix[1][0]*vector[0] + keyMatrix[1][1]*vector[1]) % 26;
            result.append((char)(e1 + 'A')).append((char)(e2 + 'A'));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "HELP";
        System.out.println("Encrypted Text: " + encrypt(text));
    }
}
