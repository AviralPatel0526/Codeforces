import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * XOR_Smaller
 */
public class XOR_Smaller {

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
            int a[] = ai(n);
            ArrayList<String> list = new ArrayList<>();
            int min = Integer.MAX_VALUE;
        
            for (int i : a) {
                String binaryString = Integer.toBinaryString(i);
                min = Math.min(min, binaryString.length());
                String reversedBinaryString = new StringBuilder(binaryString).reverse().toString();
                list.add(reversedBinaryString);
            }
        
            // // Print all reversed binary strings
            // for (String s : list) {
            //     System.out.println(s);  // Print each reversed binary string
            // }
        
            int cnt = 0;
        
            for (int i = 0; i < min; i++) {
                boolean flag = true;
                for (int j = 0; j < list.size(); j++) {
                    char ch = list.get(j).charAt(i);
                    if (ch != '1') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cnt+=Math.pow(2,i);
                } 
            }
            System.out.println(cnt);
        }
        

    }
}