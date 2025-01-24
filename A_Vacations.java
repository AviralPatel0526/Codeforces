import java.util.*;
import java.lang.*;
import java.io.*;
public class A_Vacations {

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
    static int f(int i,int prev,int a[], int dp[][]){
        if(i == a.length) return 0;
        if(dp[i][prev] != -1) return dp[i][prev];
        int ans=Integer.MAX_VALUE;
        if(a[i] == 0){
            ans=1+f(i+1,0,a,dp);
        }else if(a[i] == 1){
            if(prev != 1){
                ans=Math.min(ans,f(i+1,1,a,dp));
            }else{
                ans=Math.min(ans,1+f(i+1,0,a,dp));
            }
        }else if(a[i] == 2){
            if(prev != 2){
                ans=Math.min(ans,f(i+1,2,a,dp));
            }else{
                ans=Math.min(ans,1+f(i+1,0,a,dp));
            }
        }else{
            if(prev != 1){
                ans=Math.min(ans,f(i+1,1,a,dp));
            }else{
                ans=Math.min(ans,1+f(i+1,0,a,dp));
            }
            if(prev != 2){
                ans=Math.min(ans,f(i+1,2,a,dp));
            }else{
                ans=Math.min(ans,1+f(i+1,0,a,dp));
            }
        }
        return dp[i][prev]=ans;
    }
    public static void main(String[] args) throws java.lang.Exception {
        int n=in.nextInt();
        int[] a=ai(n);
        int dp[][]=new int[n][3];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(f(0, 0, a, dp));
    }
}


// import java.util.Scanner;
// import java.util.Arrays;

// public class A_Vacations {
//     public static void main(String[] args) throws java.lang.Exception {
//         Scanner in = new Scanner(System.in);
//         int n = in.nextInt();
//         int[] a = new int[n];
//         for (int i = 0; i < n; i++) {
//             a[i] = in.nextInt();
//         }

//         int[][] dp = new int[n + 1][3];
//         for (int i = 0; i <= n; i++) {
//             Arrays.fill(dp[i], Integer.MAX_VALUE);
//         }
//         dp[0][0] = 0;

//         for (int i = 1; i <= n; i++) {
//             dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] + 1);
//             dp[i][0] = Math.min(dp[i][0], dp[i - 1][1] + 1);
//             dp[i][0] = Math.min(dp[i][0], dp[i - 1][2] + 1);

//             if (a[i - 1] == 1 || a[i - 1] == 3) {
//                 dp[i][1] = Math.min(dp[i][1], dp[i - 1][0]);
//                 dp[i][1] = Math.min(dp[i][1], dp[i - 1][2]);
//             }

//             if (a[i - 1] == 2 || a[i - 1] == 3) {
//                 dp[i][2] = Math.min(dp[i][2], dp[i - 1][0]);
//                 dp[i][2] = Math.min(dp[i][2], dp[i - 1][1]);
//             }
//         }

//         int result = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
//         System.out.println(result);
//     }
// }