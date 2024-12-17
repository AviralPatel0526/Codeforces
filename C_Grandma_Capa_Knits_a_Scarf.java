import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Grandma_Capa_Knits_a_Scarf {

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
    static int f(String temp,char x){
        int i=0;
        int j=temp.length()-1;
        int cnt=0;
        while(i < j){
            if(temp.charAt(i) != temp.charAt(j)){
                if(temp.charAt(i) == x){
                    i++;
                    cnt++;
                }else if(temp.charAt(j) == x){
                    j--;
                    cnt++;
                }else{
                    return -1;
                }
            }else{
                i++;
                j--;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n=in.nextInt();
            String s=in.next();
            int i=0;;
            int j=n-1;
            int res=0;
            while(i<j){
                if(s.charAt(i) != s.charAt(j)){
                    int ans1=f(s,s.charAt(i));
                    int ans2=f(s,s.charAt(j));
                    if(ans1 != -1 && ans2 != -1){
                        res=Math.min(ans1,ans2);
                    }else if(ans1 != -1){
                        res=ans1;
                    }else if(ans2 != -1){
                        res=ans2;
                    }else{
                        res=-1;
                    }
                    break;
                }
                i++;
                j--;
            }
            System.out.println(res);
        }
    }
}