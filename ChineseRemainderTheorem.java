public class ChineseRemainder {
    static int findMinX(int[] num, int[] rem) {
        int prod = 1;
        for (int n : num) prod *= n;

        int result = 0;
        for (int i = 0; i < num.length; i++) {
            int pp = prod / num[i];
            result += rem[i] * mulInv(pp, num[i]) * pp;
        }
        return result % prod;
    }

    static int mulInv(int a, int b) {
        int b0 = b, t, q;
        int x0 = 0, x1 = 1;
        if (b == 1) return 1;
        while (a > 1) {
            q = a / b;
            t = b;
            b = a % b; a = t;
            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }
        if (x1 < 0) x1 += b0;
        return x1;
    }

    public static void main(String[] args) {
        int[] num = {3, 4, 5};
        int[] rem = {2, 3, 1};
        System.out.println("x is " + findMinX(num, rem));
    }
}
