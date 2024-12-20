import java.util.*;
import java.lang.*;
import java.io.*;
public class B_Flip_the_Bits {

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
            String a = in.next();
            String b = in.next();
            int c0[]=new int[n];
            int c1[]=new int[n];
            for(int i=0;i<n;i++){
                if(a.charAt(i) == '0'){
                    c0[i]+=1;
                }else{
                    c1[i]+=1;
                }
                if(i > 0){
                    c0[i]+=c0[i-1];
                    c1[i]+=c1[i-1];
                }
            }
            boolean flag = true;
            int i = n-1;
            int flpcnt=0;
            while (i >= 0) {
                char ca=a.charAt(i);
                if(flpcnt%2 != 0){
                    if(ca == '0'){
                        ca='1';
                    }else{
                        ca='0';
                    }
                }
                if (ca != b.charAt(i)) {
                  if(c0[i] != c1[i]){
                    flag=false;
                  }
                  flpcnt++;
                } 
                i--;
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
    
}