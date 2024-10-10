import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * GCD_to_1_Easy
 */
public class GCD_to_1_Easy {

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
            int n = in.nextInt();
            int m = in.nextInt();
            int r = Math.min(m, n);  // Rows
            int c = Math.max(m, n);  // Columns
            int a[][] = new int[r][c];
            int pos = c - 1;  // Position to place 3 in each row
    
            // Fill the matrix
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (j == pos) {
                        a[i][j] = 3;
                        pos--;  // Move the position of 3 leftward for the next row
                    } else {
                        a[i][j] = 2;
                    }
                }
            }
            if(r!=c){
                for(int i=0;i<=pos;i++){
                    a[r-1][i]=3;
                }
            }
            if(n > m){
                for (int i = 0; i < c; i++) {
                    for (int j = 0; j < r; j++) {
                        System.out.print(a[j][i] + " ");
                    }
                    System.out.println();
                }
            }else{
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        System.out.print(a[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            
        }
    }
    
}