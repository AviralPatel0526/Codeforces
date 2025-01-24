

import java.util.*;

public class qUiRkY_qUesTs_Easy {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // Read the number of test cases
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() {
        // Read the input size
        int n = in.nextInt();
        List<Long> a = new ArrayList<>();

        // Read the array
        for (int i = 0; i < n; i++) {
            a.add(in.nextLong());
        }

        // Sort the array in descending order
        a.sort(Collections.reverseOrder());

        // Calculate the initial sum of all elements
        long sum = 0;
        for (long num : a) {
            sum += num;
        }

        // Initialize the maximum answer
        long ans = Math.max((long) n * n, sum);

        // Process the array to find the maximum value
        for (int i = 1; i <= n; i++) {
            sum -= a.remove(a.size() - 1); // Remove the last element and update sum
            ans = Math.max(ans, sum + (long) i * i);
        }

        // Output the result
        System.out.println(ans);
    }
}
