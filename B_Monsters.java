import java.util.*;
import java.io.*;

public class B_Monsters {

    static FastReader in = new FastReader();

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
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt() % k;
                if (a[i] == 0) {
                    a[i] = k;
                }
            }

            // Using ArrayList for the indices
            ArrayList<Integer> ord = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ord.add(i);
            }

            // Sort ord list using Comparator based on the values in array `a`
            ord.sort((i, j) -> Integer.compare(a[j], a[i]));

            // Print the sorted indices + 1 (to match 1-based indexing)
            for (int i = 0; i < n; i++) {
                System.out.print((ord.get(i) + 1) + " ");
            }
            System.out.println();
        }
    }
}
