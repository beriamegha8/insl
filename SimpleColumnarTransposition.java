import java.util.Arrays;

public class ColumnarTransposition {
    public static String encrypt(String text, int key) {
        char[] arr = new char[key * (int)Math.ceil((double)text.length()/key)];
        Arrays.fill(arr, 'X');
        for (int i = 0; i < text.length(); i++) arr[i] = text.charAt(i);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < key; i++)
            for (int j = i; j < arr.length; j += key)
                result.append(arr[j]);

        return result.toString();
    }

    public static void main(String[] args) {
        String text = "HELLOWORLD";
        int key = 4;
        System.out.println("Encrypted: " + encrypt(text, key));
    }
}
