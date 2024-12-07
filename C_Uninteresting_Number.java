import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Uninteresting_Number {

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
            String s = in.next();
            int n = s.length();
            int cnt2 = 0;
            int cnt6 = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                int x = Character.getNumericValue(ch); 
                if (x == 2) {
                    cnt2++;
                } else if (x == 3) {
                    cnt6++;
                }
                sum += x;
            }
            // System.out.println(cnt2+" sdfjhds" + cnt6);
            if (sum % 9 == 0) {
                System.out.println("YES");
            } else {
                int mod = sum % 9;
                int diff = 9 - mod;
                if(diff == 1){
                    if(cnt2 >= 5){
                        System.out.println("YES");
                    }else if(cnt2 >= 2 && cnt6 >= 1){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }
                }else if (diff == 2) {
                    if (cnt2 >= 1) { // Fixed check
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                } else if (diff == 3) {
                    if (cnt2 >= 6 || cnt6 >= 2) {
                        System.out.println("YES");
                    } else if (cnt2 >= 3 && cnt6 >= 1) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                } else if (diff == 4) {
                    if (cnt2 >= 2) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }else if(diff == 5){
                    if(cnt2 >= 7){
                        System.out.println("YES");
                    }else if(cnt2 >= 4 && cnt6 >= 1){
                        System.out.println("YES");
                    }else if(cnt2 >=1 && cnt6 >= 2){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }
                } else if (diff == 6) {
                    if (cnt2 >= 3 || cnt6 >= 1) {
                        System.out.println("YES"); 
                    } else {
                        System.out.println("NO");
                    }
                }else if(diff == 7){
                    if(cnt2 >= 8){
                        System.out.println("YES");
                    }else if(cnt2 >= 2 && cnt6 >= 2 ){
                        System.out.println("YES");
                    }else if(cnt2 >= 5 && cnt6 >= 1){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }
                } else if (diff == 8) {
                    if (cnt2 >= 4) {
                        System.out.println("YES");
                    } else if (cnt2 >= 1 && cnt6 >= 1) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                } else {
                    System.out.println("NO");
                }
            }
        }
        
    }
}