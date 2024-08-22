import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * D_Deletive_Editing
 */
public class D_Deletive_Editing {

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
            String big = in.next();  // Read the big string
            String small = in.next();  // Read the small string

            // HashMap to store the frequency of characters in small
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < small.length(); i++) {
                map.put(small.charAt(i), map.getOrDefault(small.charAt(i), 0) + 1);
            }

            // Build the big2 string containing only characters from big that are also in small
            StringBuilder big2 = new StringBuilder();
            for (int i = 0; i < big.length(); i++) {
                if (map.containsKey(big.charAt(i))) {
                    big2.append(big.charAt(i));
                }
            }

            // Create a frequency map for big2
            HashMap<Character, Integer> map2 = new HashMap<>();
            for (int i = 0; i < big2.length(); i++) {
                char ch = big2.charAt(i);
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            }

            // Build the ans string based on map comparison
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < big2.length(); i++) {
                char ch = big2.charAt(i);
                // Only add to ans if map2's count does not exceed map's count
                if (map2.get(ch) > map.get(ch)) {
                    map2.put(ch, map2.get(ch) - 1);  // Decrement the count in map2
                } else {
                    ans.append(ch);  // Append character to ans
                }
            }

            // Check if the constructed ans equals small
            if (ans.toString().equals(small)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}


 