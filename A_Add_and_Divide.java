import java.util.*;
import java.lang.*;
import java.io.*;
public class A_Add_and_Divide {

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
    
        while (t-- > 0) {
            long a = in.nextLong();
            long copya=a;
            long b = in.nextLong();
            boolean flag=false;
            if (b == 1) {
                b++;
                flag=true;
            }
            long min=(long)(Math.log(a)/Math.log(b))+1;
            long pow=min;
            for(long i=1;i<29;i++){
                min=Math.min(min,i+(long)(Math.log(a)/Math.log(b+i))+1);
            }
            if(flag){
                min++;
            }
            if((long)(Math.pow(b,pow)) == copya){
                min++;
            }
            System.out.println(min);
        }
    }
}