import java.util.*;
import java.lang.*;
import java.io.*;
public class Subs {
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
    static void f(int i,int n,String s,String temp, ArrayList<Integer> list){
        if(i == n){
            if(!temp.equals(""))
            list.add(Integer.parseInt(temp));
            return;
        }
        f(i+1,n,s,temp+s.charAt(i),list);
        f(i+1,n,s,temp,list);
    }
    public static void main(String[] args) throws java.lang.Exception {
        int n=in.nextInt();
        String s=in.next();
        int k=in.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        f(0,n,s,"",list);
        int ans=0;
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            if(list.get(i) > k){
                ans=list.get(i);
                break;
            }
        }
        System.out.println(ans);
    }
}
