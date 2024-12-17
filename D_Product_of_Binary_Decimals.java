import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class D_Product_of_Binary_Decimals {

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
            int x=in.nextInt();
            int n=x;
            if(n == 1){
                System.out.println("YES");
                continue;
            }
            int a[]={10,11,110,111,100,101,1110,1111,1100,1101,1010,1011,1000,1001,11110,11111,11100,11101,11010,11011,11000,11001,10110,10111,10100,10101,10010,10011,10000,10001};
            HashSet<Integer> set=new HashSet<>();
            for(int i=0;i<a.length;i++){
                set.add(a[i]);
            }
            if(set.contains(n)){
                System.out.println("YES");
                continue;
            }
            boolean flag=false;
            outer : for(int i=0;i<a.length;i++){
                if(n%a[i] == 0){
                    while(n%a[i] == 0){
                        n/=a[i];
                        if(n == 1){
                            flag=true;
                            break outer;
                        }
                    }
                }
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}