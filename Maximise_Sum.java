import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Maximise_Sum
 */
public class Maximise_Sum {

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
            long a[]=al(n);
            long sum=0;
            ArrayList<Long> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(a[i] < 0){
                    list.add(a[i]);
                }else{
                    sum+=a[i];
                }
            }
            Collections.sort(list);
            if(list.size()%2 == 0){
                for(int i=0;i<list.size()-1;i+=2){
                    sum+=list.get(i)*-1 + list.get(i+1)*-1;
                }
            }else{
                for(int i=0;i<list.size()-1;i+=2){
                    sum+=list.get(i)*-1 + list.get(i+1)*-1;
                }
                sum+=list.get(list.size()-1);
            }
            System.out.println(sum);
        }
    }
}