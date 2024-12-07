import java.util.*;
import java.lang.*;
import java.io.*;
public class B_Replace_Character {

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
            String s = in.next();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int minf = n + 1;
            char minc = ' ';
            int maxf = 0;
            char maxc = ' ';
            for (Character key : map.keySet()) {
                int freq = map.get(key);
                if (freq > maxf) {
                    maxf = freq;
                    maxc = key;
                }
                if (freq < minf) {
                    minf = freq;
                    minc = key;
                }
            }
           
            if(minf == maxf){
                char arr[]=s.toCharArray();
                for(int i=0;i<n;i++){
                    if(arr[i] != arr[0]){
                        arr[i]=arr[0];
                        break;
                    }
                }
                System.out.println(new String(arr));
            }else{ 
                char arr[]=s.toCharArray();
                for(int i=0;i<n;i++){
                    if(arr[i] == minc){
                        arr[i]=maxc;
                        break;
                    }
                }
                System.out.println(new String(arr));
            }

        }
        
    }
}