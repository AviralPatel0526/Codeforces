import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Anya_and_1100 {

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
    // input of int array
    static int[] ai(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        return arr;
    }
    
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
        int t = in.nextInt();

        while (t != 0) {
            t--;
            String s = in.next();
            int n = s.length();
            TreeSet<Integer> set = new TreeSet<>();

            // Initial scan to find all occurrences of "1100"
            for (int i = 0; i <= n - 4; i++) {
                if (s.substring(i, i + 4).equals("1100")) {
                    set.add(i + 1);
                }
            }

            int q = in.nextInt();
            char[] ch = s.toCharArray();

            for (int i = 0; i < q; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                char chb = (char) (b + '0');

                if (ch[a - 1] != chb) {
                    // Update character
                    ch[a - 1] = chb;

                    // Remove all potentially affected substrings
                    for (int j = Math.max(0, a - 4); j <= Math.min(n - 4, a); j++) {
                        if (set.contains(j + 1) && !checkPattern(ch, j)) {
                            set.remove(j + 1);
                        }
                    }

                    // Add new valid substrings if they match "1100"
                    for (int j = Math.max(0, a - 4); j <= Math.min(n - 4, a); j++) {
                        if (!set.contains(j + 1) && checkPattern(ch, j)) {
                            set.add(j + 1);
                        }
                    }
                }

                // Output the result for the current query
                if (set.size() > 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    // Helper function to check if substring starting at `index` matches "1100"
    private static boolean checkPattern(char[] ch, int index) {
        return index + 3 < ch.length && ch[index] == '1' && ch[index + 1] == '1' && ch[index + 2] == '0' && ch[index + 3] == '0';
    }
}