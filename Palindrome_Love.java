import java.util.*;
import java.lang.*;
import java.io.*;
public class Palindrome_Love {

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
    static boolean isp(String s){
        int i=0;
        int j=s.length()-1;
        while(i < j){
            char chi=s.charAt(i);
            char chj=s.charAt(j);
            if(chi != chj){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n=in.nextInt();
            String s=in.next();
            if(isp(s)){
                System.out.println(0);
                continue;
            }
            HashSet<Character> seteve=new HashSet<>();
            HashSet<Character> setodd=new HashSet<>();
            for(int i=0;i<n;i++){
                if (i%2 == 0) {
                    seteve.add(s.charAt(i));
                } else {
                    setodd.add(s.charAt(i));
                }
            }
            if(seteve.size() == 1 && setodd.size() == 1){
                System.out.println(-1);
            }else{
                System.out.println(1);
            }
        }
    }
}