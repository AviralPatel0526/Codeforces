import java.util.Scanner;

public class B_Red_and_Blue {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = in.nextInt();
            int[] r = new int[n];
            for (int i = 0; i < n; i++) {
                r[i] = in.nextInt();
            }

            int m = in.nextInt();
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = in.nextInt();
            }

            // Calculate maximum prefix sum for r
            int maxPrefixR = 0, currentSum = 0;
            for (int i = 0; i < n; i++) {
                currentSum += r[i];
                maxPrefixR = Math.max(maxPrefixR, currentSum);
            }

            // Calculate maximum prefix sum for b
            int maxPrefixB = 0;
            currentSum = 0;
            for (int i = 0; i < m; i++) {
                currentSum += b[i];
                maxPrefixB = Math.max(maxPrefixB, currentSum);
            }

            // The answer for this test case is the sum of both maximum prefix sums
            System.out.println(maxPrefixR + maxPrefixB);
        }

        in.close();
    }
}
