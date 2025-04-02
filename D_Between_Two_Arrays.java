// import java.util.*;
// import java.lang.*;
// import java.io.*;
// public class D_Between_Two_Arrays {

//     // GCD Method
//     static long gcd(long a, long b) {
//         while (b != 0) {
//             long t = b;
//             b = a % b;
//             a = t;
//         }
//         return a;
//     }
    
//     // LCM Method
//     static long lcm(long a, long b) {
//         return (a / gcd(a, b)) * b;
//     }
    
//     // Find Power Method
//     static long findPower(long num, long base) {
//         if (num < 1 || base <= 1) return -1;
//         double logResult = Math.log(num) / Math.log(base);
//         if (Math.abs(logResult - Math.round(logResult)) < 1e-10) {
//             return (long) Math.round(logResult);
//         } else {
//             return -1;
//         }
//     }
    
//     // Fast Exponentiation Method using Modular Arithmetic
//     static long fastExponentiation(long base, long exp, long mod) {
//         long result = 1;
//         base %= mod;
//         while (exp > 0) {
//             if ((exp & 1) == 1) {
//                 result = (result * base) % mod;
//             }
//             base = (base * base) % mod;
//             exp >>= 1;
//         }
//         return result;
//     }
    
//     // Sieve Method
//     static boolean[] sieve;
//     static void fillSieve(int ssize) {
//         sieve = new boolean[ssize + 1];
//         Arrays.fill(sieve, true);
//         sieve[0] = sieve[1] = false;
//         for (int i = 2; i * i <= ssize; i++) {
//             if (sieve[i]) {
//                 for (int j = i * i; j <= ssize; j += i) {
//                     sieve[j] = false;
//                 }
//             }
//         }
//     }
    
//     // Smallest Prime Factor (SPF) Method
//     static int[] spf;
//     static void fillSpf(int ssize) {
//         spf = new int[ssize + 1];
//         for (int i = 0; i <= ssize; i++) {
//             spf[i] = i;
//         }
//         for (int i = 2; i * i <= ssize; i++) {
//             if (spf[i] == i) {
//                 for (int j = i * i; j <= ssize; j += i) {
//                     if (spf[j] == j) {
//                         spf[j] = i;
//                     }
//                 }
//             }
//         }
//     }
    
//     // Reverse Array Function
//     static void reverse(long[] arr) {
//         int n = arr.length;
//         for (int i = 0; i < n / 2; i++) {
//             long temp = arr[i];
//             arr[i] = arr[n - i - 1];
//             arr[n - i - 1] = temp;
//         }
//     }
    
//     // Print Array Elements (Space-separated)
//     static void aout(long[] arr) {
//         StringBuilder sb = new StringBuilder();
//         for (long num : arr) {
//             sb.append(num).append(" ");
//         }
//         System.out.println(sb.toString().trim());
//     }
    
//     // Print ArrayList Elements (Space-separated)
//     static void lout(ArrayList<Long> list) {
//         StringBuilder sb = new StringBuilder();
//         for (long num : list) {
//             sb.append(num).append(" ");
//         }
//         System.out.println(sb.toString().trim());
//     }
    
//     static FastReader in = new FastReader();
    
//     // Input of int array
//     static int[] ai(int n) {
//         int[] arr = new int[n];
//         for (int i = 0; i < n; i++) arr[i] = in.nextInt();
//         return arr;
//     }
    
//     // Input of long array
//     static long[] al(int n) {
//         long[] arr = new long[n];
//         for (int i = 0; i < n; i++) arr[i] = in.nextLong();
//         return arr;
//     }
    
//     static class FastReader {
//         BufferedReader br;
//         StringTokenizer st;
    
//         public FastReader() {
//             br = new BufferedReader(new InputStreamReader(System.in));
//         }
    
//         String next() {
//             while (st == null || !st.hasMoreTokens()) {
//                 try {
//                     st = new StringTokenizer(br.readLine());
//                 } catch (IOException e) {
//                     e.printStackTrace();
//                 }
//             }
//             return st.nextToken();
//         }
    
//         int nextInt() {
//             return Integer.parseInt(next());
//         }
    
//         long nextLong() {
//             return Long.parseLong(next());
//         }
    
//         double nextDouble() {
//             return Double.parseDouble(next());
//         }
    
//         String nextLine() {
//             String str = "";
//             try {
//                 str = br.readLine().trim();
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//             return str;
//         }
//     }
//     static int mod=998244353;
//     public static void main(String[] args) throws java.lang.Exception {
//         int n=in.nextInt();
//         int a[]=ai(n);
//         int b[]=ai(n);
//         long dp[][]=new long[n][101];
//         for(int i=0;i<n-1;i++){
//             if(i == 0){
//                 for(int k=0;k<101;k++){
//                     if(k >= a[0] && k<=b[0]){
//                         dp[0][k]=Math.min(b[1]-k+1,b[1]-a[1]+1);
//                     }
//                 }
//             }else{
//                 for(int k=0;k<=100;k++){
//                     if(k >= a[i] && k <= b[i]){
//                         dp[i][k]=((dp[i-1][k] != 0 ? dp[i-1][k] : 1)%mod*(Math.min(b[i+1]-k+1,b[i+1]-a[i+1]+1))%mod)%mod;
//                     }
//                 }
//             }
//             for(int j=1;j<101;j++){
//                 dp[i][j]=(dp[i][j]%mod+dp[i][j-1])%mod;
//             }
                
            
//         }
//         long ans=0;
//         for(int i=a[n-2];i<=b[n-2];i++){
//             ans=(ans%mod+dp[n-2][i]%mod)%mod;
//         }
//         System.out.println(dp[n-2][100]);
//     }
// }

import java.util.*;
import java.io.*;

public class D_Between_Two_Arrays {
    static final int MOD = 998244353;
    
    public static void main(String[] args) throws Exception {
        // Use BufferedReader for fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine().trim());
        
        int[] a = new int[n];
        int[] b = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        // The maximum possible value in c (we use b[n-1] or 3000 if needed)
        int maxVal = 101;  // since b_i <= 3000
        
        long[][] dp = new long[n][maxVal+1];
        
        // Base case: for i = 0, c[0] can be any value in [a[0], b[0]]
        for (int x = a[0]; x <= b[0]; x++) {
            dp[0][x] = 1;
        }
        
        // Process each element i from 1 to n-1
        for (int i = 1; i < n; i++) {
            // Build prefix sums for dp[i-1]
            long[] prefix = new long[maxVal+1];
            prefix[0] = dp[i-1][0];
            for (int x = 1; x <= maxVal; x++) {
                prefix[x] = (prefix[x-1] + dp[i-1][x]) % MOD;
            }
            
            // For each valid x in current range [a[i], b[i]]
            for (int x = a[i]; x <= b[i]; x++) {
                dp[i][x] = prefix[x];  // All ways with previous value <= x
            }
        }
        for(int i=0;i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        // The answer is the sum over dp[n-1][x] for x in [a[n-1], b[n-1]]
        long ans = 0;
        for (int x = a[n-1]; x <= b[n-1]; x++) {
            ans = (ans + dp[n-1][x]) % MOD;
        }
        
        System.out.println(ans);
    }
}
