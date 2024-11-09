import java.util.*;
import java.lang.*;
import java.io.*;
public class B_MEXor_Mixup {

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
            int mex=in.nextInt();
            int xor=in.nextInt();
            int toFind=mex-1;
            int ans=mex;
            int xorUpTo=0;
            if(toFind%4 == 0){
                xorUpTo=toFind;
            }else if(toFind%4 == 1){
                xorUpTo=1;
            }else if(toFind%4 == 2){
                xorUpTo=toFind+1;
            }else if(toFind%4 == 3){
                xorUpTo=0;
            }
        
            if((xor^xorUpTo) == mex){
                System.out.println(ans+2);
            }else if(xorUpTo == xor){
                System.out.println(ans);
            }else{
                System.out.println(ans+1);
            }
        }
    }
}