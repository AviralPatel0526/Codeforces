import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Make_Them_Equal {

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
            int n = in.nextInt();
            char c = in.next().charAt(0);
            String s = in.next();
            int ans=-1;
            for(int i=1;i<=n;i++){
                boolean flag=true;
                for(int j=i;j<=n;j+=i){
                    if(s.charAt(j-1) != c){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    ans=i;
                    break;
                }
            }
            if(ans!=-1){
                if(ans==1){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                    System.out.println(ans);
                }
            }else{
                System.out.println(2);
                System.out.println(n+" "+(n-1));
            }
        }
    }
}