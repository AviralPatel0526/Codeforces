import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * B_Triangles_on_a_Rectangle
 */
public class B_Triangles_on_a_Rectangle {

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
            long max = 0;
            int w = in.nextInt();
            int h = in.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            
            // Reading the input for the 4 sublists
            for (int j = 0; j < 4; j++) {
                int a = in.nextInt();
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < a; i++) {
                    temp.add(in.nextInt());
                }
                list.add(temp);
            }
            
            // Calculating the maximum difference for width
            long maxw = Math.max(
                list.get(0).get(list.get(0).size() - 1) - list.get(0).get(0),
                list.get(1).get(list.get(1).size() - 1) - list.get(1).get(0)
            );
            
            // Calculating the maximum difference for breadth
            long maxb = Math.max(
                list.get(2).get(list.get(2).size() - 1) - list.get(2).get(0),
                list.get(3).get(list.get(3).size() - 1) - list.get(3).get(0)
            );
            
            // Printing the maximum possible area
            System.out.println(Math.max(maxw * h, maxb * w));
        }
        
    }
}