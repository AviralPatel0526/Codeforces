import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Berland_Regional {

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
    
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
        
        // jo bhi dekh raha hai isko c++ me convert karke submit karna chal jaega

        while (t != 0) {
            t--;
            int n = in.nextInt();
            int a[] = ai(n);
            long b[] = al(n);
            HashMap<Integer, ArrayList<Long>> map = new HashMap<>();
            
            // Populate the map with keys from array `a` and values from array `b`
            for (int i = 0; i < n; i++) {
                if (map.containsKey(a[i])) {
                    map.get(a[i]).add(b[i]);
                } else {
                    ArrayList<Long> temp = new ArrayList<>();
                    temp.add(b[i]);
                    map.put(a[i], temp);
                }
            }
        
            // Sort the ArrayList in descending order for each key
            for (Integer key : map.keySet()) {
                ArrayList<Long> temp = map.get(key);
                temp.sort((x, y) -> Long.compare(y, x));
                map.put(key, temp);
            }
        
            // Calculate the cumulative sums for each ArrayList in the map
            for (Integer key : map.keySet()) {
                ArrayList<Long> temp = map.get(key);
                for (int i = 1; i < temp.size(); i++) {
                    temp.set(i, temp.get(i) + temp.get(i - 1));
                }
                map.put(key, temp);
            }
        
            long ans[] = new long[n];
            for (int i = 1; i <= n; i++) {
                long sum = 0;
                Iterator<Map.Entry<Integer, ArrayList<Long>>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, ArrayList<Long>> entry = iterator.next();
                    ArrayList<Long> temp = entry.getValue();
                    int size = temp.size();
        
                    if (size < i) {
                        iterator.remove(); 
                    } else {
                        sum += temp.get((size/i)*i - 1);
                    }
                }
        
                ans[i - 1] = sum;
            }
            aout(ans);
        }
    }
}