import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * C_Raspberries
 */
public class C_Raspberries {

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
            int n=in.nextInt();
            int k=in.nextInt();
            int a[]=ai(n);
            int max=Integer.MIN_VALUE;
            int c1=0;
            int ceve=0;
            int codd=0;
            boolean flag=false;
            // int min=Integer.MAX_VALUE;
            for(int i:a){
                max=Math.max(max,i%k);
                if(i%k == 0){
                    flag=true;
                    break;
                }
                if(i%2 == 0){
                    ceve++;
                }else{
                    codd++;
                }
            }
            if(flag){
                System.out.println(0);
            }else{
                if(k == 4){
                    if(ceve == 0){
                        if(max == 1 && codd >= 2){
                            System.out.println(2);
                        }else{
                            System.out.println(4-max);
                        }
                    }else if(ceve == 1){
                        System.out.println(1);
                    }else if(ceve >= 2){
                        System.out.println(0);
                    }
                }else{
                    System.out.println(k-max);
                }
            }
        }
    }
}