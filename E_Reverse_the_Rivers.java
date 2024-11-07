import java.util.*;
import java.lang.*;
import java.io.*;
public class E_Reverse_the_Rivers {

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
    public static int lowerBound(List<Long> list, int key) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) > key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low; // First index where element is greater than 'key'
    }
    public static int upperBound(List<Long> list, int key) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // First index where element is greater than 'key'
    }
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n=in.nextInt();
            int k=in.nextInt();
            long q=in.nextLong();
            long a[][]=new long[n][k];
            for(int i=0;i<n;i++){
                for(int j=0;j<k;j++){
                    a[i][j]=in.nextLong();
                }
            }
            ArrayList<ArrayList<Long>> list=new ArrayList<>();
            for(int i=0;i<k;i++){
                long x=0;
                ArrayList<Long> temp=new ArrayList<>();
                for(int j=0;j<n;j++){
                    x|=a[j][i];
                    temp.add(x);
                }
                list.add(temp);
            } 
            for(int i=0;i<q;i++){
                int m=in.nextInt();
                int st=0;
                int en=n-1;
                for(int j=0;j<m;j++){
                    int r=in.nextInt();
                    char ch=in.next().charAt(0);
                    int c=in.nextInt();
                    ArrayList<Long> temp=list.get(r-1);
                    if(ch == '<'){
                        int ub=upperBound(temp, c);
                    }else{
                        int lb=lowerBound(temp, c);
                    }
                }
                
            }     
            
        }
    }
}