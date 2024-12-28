import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Sums_on_Segments {

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
    
    // Reverse Array Function
    static void reverse(long[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            long temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
    
    // Print Array Elements (Space-separated)
    static void aout(long[] arr) {
        StringBuilder sb = new StringBuilder();
        for (long num : arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    
    // Print ArrayList Elements (Space-separated)
    static void lout(ArrayList<Long> list) {
        StringBuilder sb = new StringBuilder();
        for (long num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
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
        int idx;
        long num;
        Pair(int idx,long num){
             this.idx=idx;
             this.num=num;
        }
        
    }
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n = in.nextInt();
            long[] a = al(n);
            int pos = -1;
            TreeSet<Long> set = new TreeSet<>();
        
            for (int i = 0; i < n; i++) {
                if (a[i] != 1 && a[i] != -1) {
                    pos = i;
                    break;
                }
            }
            long lp=0;
            long sp=0;
            for(int i=0;i<pos;i++){
                sp+=a[i];
                if(sp < 0){
                    sp=0;
                }
                lp=Math.max(lp,sp);
            }
            long ln=0;
            long sn=0;
            for(int i=0;i<pos;i++){
                sn+=a[i];
                if(sn >= 0){
                    sn=0;
                }
                ln=Math.min(ln,sn);
            }
            long rp=0;
            long spr=0;
            for(int i=pos+1;i<n;i++){
                spr+=a[i];
                if(spr < 0){
                    spr=0;
                }
                rp=Math.max(rp,spr);
            }
            long rn=0;
            long snr=0;
            for(int i=pos+1;i<n;i++){
                snr+=a[i];
                if(snr >= 0){
                    snr=0;
                }
                rn=Math.min(rn,snr);
            }
            for (long i = ln; i <= lp; i++) set.add(i);
            for (long i = rn; i <= rp; i++) set.add(i);

            if (pos != -1) {
                long lmax = 0;
                long lmin = 0;
                long rmax = 0;
                long rmin = 0;
                long sl = 0;
                long sr = 0;
        
                for (int i = pos - 1; i >= 0; i--) {
                    sl += a[i];
                    lmax = Math.max(lmax, sl);
                    lmin = Math.min(lmin, sl);
                }
                for (int i = pos + 1; i < n; i++) {
                    sr += a[i];
                    rmax = Math.max(rmax, sr);
                    rmin = Math.min(rmin, sr);
                }
        
                lmin=a[pos]+lmin+rmin;
                lmax=a[pos]+lmax+rmax;
                
                for (long i = lmin; i <= lmax; i++) set.add(i);
            }
        
            System.out.println(set.size());
            for (Long i : set) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
    }
}