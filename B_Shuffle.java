import java.util.*;
import java.lang.*;
import java.io.*;
public class B_Shuffle {

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
    
    // Find Power Method
    static long findPower(long num, long base) {
        if (num < 1 || base <= 1) return -1;
        double logResult = Math.log(num) / Math.log(base);
        if (Math.abs(logResult - Math.round(logResult)) < 1e-10) {
            return (long) Math.round(logResult);
        } else {
            return -1;
        }
    }
    
    // Fast Exponentiation Method using Modular Arithmetic
    static long fastExponentiation(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
    
    // Sieve Method
    static boolean[] sieve;
    static void fillSieve(int ssize) {
        sieve = new boolean[ssize + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        for (int i = 2; i * i <= ssize; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= ssize; j += i) {
                    sieve[j] = false;
                }
            }
        }
    }
    
    // Smallest Prime Factor (SPF) Method
    static int[] spf;
    static void fillSpf(int ssize) {
        spf = new int[ssize + 1];
        for (int i = 0; i <= ssize; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= ssize; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= ssize; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }
    
    static FastReader in = new FastReader();
    
    // Input of int array
    static int[] ai(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        return arr;
    }
    
    // Input of long array
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
    static class Pair {
        int p;
        int q;
        Pair(int p,int q){
            this.p=p;
            this.q=q;
        }
    }
        
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n = in.nextInt();
            int x = in.nextInt();
            int m = in.nextInt();
            int[][] a = new int[m][2];
            ArrayList<Pair> list = new ArrayList<>();
            int prevx=x;
            int prevy=x;
            for (int i = 0; i < m; i++) {
                a[i][0] = in.nextInt();
                a[i][1] = in.nextInt();
                if(x >= a[i][0] && x <= a[i][1]){
                    list.add(new Pair(a[i][0], a[i][1]));
                    prevx=Math.min(prevx, a[i][0]);
                    prevy=Math.max(prevy, a[i][1]);
                }else if(a[i][0] >= prevx && a[i][0] <= prevy || a[i][1] >= prevx && a[i][1] <= prevy){
                    list.add(new Pair(a[i][0], a[i][1]));
                    prevx=Math.min(prevx, a[i][0]);
                    prevy=Math.max(prevy, a[i][1]);
                }
            }
            
            Collections.sort(list, (p1, p2) -> Integer.compare(p1.p, p2.p));
            // for(int i=0;i<list.size();i++){
            //     System.out.println(list.get(i).p+" "+list.get(i).q);
            // }
            int ans=0;
            if(list.size() != 0){
                int end = list.get(0).q;
            ans = end-list.get(0).p+1;
            
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).q > end) {
                    ans +=list.get(i).q - Math.max(end+1,list.get(i).p) +1;
                    end = Math.max(end, list.get(i).q);
                }
            }
            }else{
                ans=1;
            }
            
            
            System.out.println(ans);
        }
        
    }
}