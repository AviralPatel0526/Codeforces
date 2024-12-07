import java.util.*;

import javax.print.FlavorException;

import java.lang.*;
import java.io.*;
public class A_Alice_s_Adventures_in_Chess {

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
            int a=in.nextInt();
            int b=in.nextInt();
            int x=0;
            int y=0;
            String s=in.next();
            s+=s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s;
            // System.out.println(s);
            boolean flag=false;
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(ch == 'N'){
                    y++;
                }else if(ch == 'E'){
                    x++;
                }else if(ch == 'S'){
                    y--;
                }else{
                    x--;
                }
                if(x == a && y == b){
                    flag=true;
                    break;
                }
            }
            // if(a-x < a && b-y < b){
            //     flag=true;
            // }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}