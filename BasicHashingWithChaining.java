import java.util.LinkedList;

public class HashingChaining {
    private static final int SIZE = 10;
    private LinkedList<Integer>[] table;

    public HashingChaining() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) table[i] = new LinkedList<>();
    }

    public void insert(int key) {
        int index = key % SIZE;
        table[index].add(key);
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + ": ");
            for (int key : table[i]) System.out.print(key + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashingChaining hashTable = new HashingChaining();
        int[] keys = {10, 20, 30, 5, 15, 25};

        for (int key : keys) hashTable.insert(key);

        hashTable.display();
    }
}
