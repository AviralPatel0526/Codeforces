import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * C_Traffic_Light
 */
public class C_Traffic_Light {

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
            char ch=in.next().charAt(0);
            String s=in.next();
            if(ch == 'g'){
                System.out.println(0);
            }else{
                ArrayList<Integer> idxch=new ArrayList<>();
                ArrayList<Integer> idxg=new ArrayList<>();
                for(int i=0;i<n;i++){
                    if(s.charAt(i) == ch){
                        idxch.add(i);
                    }
                    if(s.charAt(i) == 'g'){
                        idxg.add(i);
                    }
                }      
                int max=Integer.MIN_VALUE;      
                for(int i=0;i<idxch.size();i++){
                    int idx=idxch.get(i);
                    int min=Integer.MAX_VALUE;
                    for(int j=0;j<idxg.size();j++){
                        int g=idxg.get(j);
                        if(idx < g){
                            min=Math.min(min,g-idx);
                        }else{
                            min=Math.min(min,n-idx+idxg.get(0));
                        }
                    }
                    max=Math.max(max, min);
                }
                System.out.println(max);
            }
           
        }
    }
}