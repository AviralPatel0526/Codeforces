import java.util.*;

import java.lang.*;

import java.io.*;



/**

 * Xometry_Easy_Version

 */

class Xometry_Easy_Version {



    // GCD Method

    static long gcd(long a, long b) {

        while (b != 0) {

            long t = b;

            b = a % b;

            a = t;

        }

        return a;

    }

    

    // LCM Method

    static long lcm(long a, long b) {

        return (a / gcd(a, b)) * b;

    }

    

    static FastReader in = new FastReader();

    

    // input of long array

    static long[] al(int n) {

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) arr[i] = in.nextLong();

        return arr;

    }

    

    static class FastReader {

        BufferedReader br;

        StringTokenizer st;

    

        public FastReader() {

            br = new BufferedReader(new InputStreamReader(System.in));

        }

    

        String next() {

            while (st == null || !st.hasMoreTokens()) {

                try {

                    st = new StringTokenizer(br.readLine());

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

            return st.nextToken();

        }

    

        int nextInt() {

            return Integer.parseInt(next());

        }

    

        long nextLong() {

            return Long.parseLong(next());

        }

    

        double nextDouble() {

            return Double.parseDouble(next());

        }

    

        String nextLine() {

            String str = "";

            try {

                str = br.readLine().trim();

            } catch (Exception e) {

                e.printStackTrace();

            }

            return str;

        }

    }

    

    public static void main(String[] args) throws java.lang.Exception {
    long t = in.nextLong();

    while (t != 0) {
        t--;
        int n = in.nextInt();  // n will remain as int since it represents the array size
        long[] a = al(n);  // input array as long

        // Assuming the XOR result fits within the range of a 32-bit integer (0 to 2^31 - 1)
        int MAX_XOR = 1 << 20; // Adjust size if larger XOR results are expected
        long[] xorCount = new long[MAX_XOR];

        // Loop through all pairs (i, j) to calculate XOR and store the frequency
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int z = (int)(a[i] ^ a[j]);  // XOR of two elements
                xorCount[z]++;
            }
        }

        long ans = 0;

        // Calculate the number of valid quadruples based on XOR results
        for (int i = 0; i < MAX_XOR; i++) {
            if (xorCount[i] >= 2) {
                // For each XOR value, if there are at least 2 pairs, they can form a rectangle
                ans += xorCount[i] * (xorCount[i] - 1) / 2;
            }
        }

        // Each valid rectangle can be arranged in 8 ways because we are counting ordered quadruples
        ans *= 8;

        System.out.println(ans);
    }
}


}

