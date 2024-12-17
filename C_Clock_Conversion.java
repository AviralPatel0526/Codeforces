import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Clock_Conversion {

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
            String time=in.next();
            String hr=time.substring(0,2);
            String min=time.substring(3);
            int h=Integer.parseInt(hr);
            int m=Integer.parseInt(min);
            if(h == 0){
                if(m == 0){
                    System.out.println("12:00 AM");
                }else{
                    
                System.out.println("12:"+min+" AM");
                }
                continue;
            }
            if(h < 12){
                System.out.println(time+" AM");
                continue;
            }
            if(h == 12){
                System.out.println(time + " PM");
                continue;
            }
            if(h > 12){
                int x=h-12;
                if(x < 10){
                    System.out.println("0"+x+":"+min+" PM");
                }else{
                    System.out.println(x+":"+min+" PM");
                }
                
            }
        }
    }
}