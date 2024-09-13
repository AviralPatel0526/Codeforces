import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Ball_Game
 */
public class Ball_Game {

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
    static class Pair{
        long x;
        long y;
        Pair(long x,long y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n = in.nextInt();
            long avirala[] = al(n);
            long aviralb[] = al(n);
            ArrayList<Pair> list = new ArrayList<>();
            
            // Add pairs to the list
            for (int i = 0; i < n; i++) {
                list.add(new Pair(avirala[i], aviralb[i]));
            }
            
            // Sort list by the 'x' values (casting long to int can cause data loss, be careful)
            Collections.sort(list, (p1, p2) -> Long.compare(p1.x, p2.x));
            
            Stack<Integer> idx = new Stack<>();
            idx.push(n - 1);
            int result = 1;
            
            // Iterate through the pairs from n-2 down to 0
            for (int i = n - 2; i >= 0; i--) {
                if (list.get(i).x * list.get(idx.peek()).y <= list.get(i).y * list.get(idx.peek()).x) {
                    result++;
                    idx.pop();
                    idx.push(i);
                }
            }
            System.out.println(result);
        }
        
    }
}