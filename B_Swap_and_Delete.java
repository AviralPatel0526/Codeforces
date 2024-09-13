import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * B_Swap_and_Delete
 */
public class B_Swap_and_Delete {

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
            String s=in.next();
            int c0=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '0'){
                    c0++;
                }
            }
            int c1=s.length()-c0;
            String ans="";
            int i=0;
            while(i < s.length()){
                if(c0 != 0 && c1 != 0){
                    if(s.charAt(i) == '0'){
                        ans+='1';
                        c1--;
                    }else{
                        ans+='0';
                        c0--;
                    }
                }else{
                    break;
                }
                i++;
            }
            if(c0 == 0){
                while( c1 > 0 && s.charAt(i) == '0'){
                    ans+='1';
                    c1--;
                    i++;
                }
            }
            if(c1 == 0){
                while( c0 > 0 && s.charAt(i) == '1'){
                    ans+='0';
                    c0--;
                    i++;
                }
            }
            System.out.println(s.length()-ans.length());
        }
    }
}