import java.util.*;
import java.lang.*;
import java.io.*;

public class B_Array_merging {

    static FastReader in = new FastReader();

    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
            }

            for (int i = 0; i < n; ++i) {
                b[i] = in.nextInt();
            }

            HashMap<Integer, Integer> mapa = new HashMap<>();
            HashMap<Integer, Integer> mapb = new HashMap<>();
            int cnt = 1;

            // Count for array a
            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1]) {
                    cnt++;
                } else {
                    mapa.put(a[i - 1], Math.max(mapa.getOrDefault(a[i - 1], 0), cnt));
                    cnt = 1; // reset count for a new number
                }
            }
            // Ensure the last sequence is added
            mapa.put(a[n - 1], Math.max(mapa.getOrDefault(a[n - 1], 0), cnt));

            // Reset counter for the next array
            cnt = 1;
            // Count for array b
            for (int i = 1; i < n; i++) {
                if (b[i] == b[i - 1]) {
                    cnt++;
                } else {
                    mapb.put(b[i - 1], Math.max(mapb.getOrDefault(b[i - 1], 0), cnt));
                    cnt = 1; // reset count for a new number
                }
            }
            // Ensure the last sequence is added
            mapb.put(b[n - 1], Math.max(mapb.getOrDefault(b[n - 1], 0), cnt));

            int ans = 0;
            // Calculate the maximum sequence length by combining both maps
            for (int key : mapa.keySet()) {
                int sum = mapa.getOrDefault(key, 0) + mapb.getOrDefault(key, 0);
                ans = Math.max(ans, sum);
            }

            // Also check keys present in mapb but not in mapa
            for (int key : mapb.keySet()) {
                if (!mapa.containsKey(key)) {
                    ans = Math.max(ans, mapb.get(key));
                }
            }

            System.out.println(ans);
        }
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
}